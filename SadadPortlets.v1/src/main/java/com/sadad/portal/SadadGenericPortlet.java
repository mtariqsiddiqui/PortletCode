/**
 * 
 */
package com.sadad.portal;

import java.lang.reflect.Field;
import java.util.Enumeration;

import javax.portlet.GenericPortlet;
import javax.portlet.PortletRequest;
import javax.portlet.PortletSession;

import com.sadad.portal.beans.SadadPortalSessionBean;
import com.sadad.portal.constant.PortalConstant;

/**
 * @author Tariq Siddiqui
 *
 */
public abstract class SadadGenericPortlet extends GenericPortlet
{
	protected static final String JSP_EXTENTION = ".jsp"; // JSP folder name
	protected static final String JSP_CORE_FOLDER = "/jsp/html/ebpp/core/"; // JSP folder name

	/**
	 * Handle the Screen handling logic. Any Form or Detail pages are displayed in Container 1 and Container 2 is empty, 
	 * whereas all the Summary and List pages are displayed in Container 2.
	 * 
	 * @param so Session Bean object
	 * @param jspFolder - Folder in which jsp file resides
	 * @param jspResourceId - Name of jsp file without extension (case sensitive)
	 */
	protected void screenHandling(SadadPortalSessionBean so, String jspFolder, String jspResourceId)
	{
		// in case of error next screen should not be rendered, just return 
		if(so.getMessageToDisplay() != null)
			return;
		
		if (jspResourceId.endsWith("Form") || jspResourceId.endsWith("Details"))
		{
			so.navigate(PortalConstant.NEXT);
			
			so.getScreen().setContainer1(getJspFilePath(jspFolder, jspResourceId));
			so.getScreen().setContainer2(null);
		}
		else if (jspResourceId.endsWith("Summary") || jspResourceId.endsWith("List"))
		{
			so.getScreen().setContainer2(getJspFilePath(jspFolder, jspResourceId));
		}
	}
	
	/**
	 * Retrieve the sesion bean data object from Portlet Session - Portlet Scope
	 * @param request - Portlet request object from doView or serveResource
	 * @param castTo - 
	 * @return - session bean object from session or null
	 */
	protected <T> T getSessionBeanObject(PortletRequest request, Class<T> castTo)
	{
		SadadPortalSessionBean obj = (SadadPortalSessionBean) request.getPortletSession().getAttribute(PortalConstant.PORTLET_SESSION_BEAN, PortletSession.PORTLET_SCOPE);
		// Clear any previous error or success messages
		if(obj != null && obj.getMessageToDisplay() != null)
			obj.setMessageToDisplay(null);
		// return the object after casting it to required class
		return castTo.cast(obj);
	}
	
	/**
	 * Stores the session bean data object in Portlet Session - Portlet Scope
	 * @param request - Portlet request object from doView or serveResource
	 * @param sesObj - session bean object to be stored in portlet session 
	 */
	protected void setSessionBeanObject(PortletRequest request, SadadPortalSessionBean sesObj)
	{
		request.getPortletSession().setAttribute(PortalConstant.PORTLET_SESSION_BEAN, sesObj, PortletSession.PORTLET_SCOPE);
	}
	
	/**
	 * Returns JSP file path.
	 * 
	 * @param request
	 *            Render request
	 * @param jspFile
	 *            JSP file name
	 * @return JSP file path
	 */
	protected static String getJspFilePath(String jspFolder, String jspFile)
	{
		StringBuilder filePath = new StringBuilder();
		if (jspFile.startsWith("core_"))
			filePath.append(JSP_CORE_FOLDER).append(jspFile).append(JSP_EXTENTION);
		else
			filePath.append(jspFolder).append(jspFile).append(JSP_EXTENTION);
		return filePath.toString();
	}
	
	/**
	 * Reads all the request attributes starting with param_ and populate the values in SessionBean object
	 * 
	 * @param request - PortletRequest object which contains the request parameter to process
	 * @param so - SadadPortalSessionBean object which needs to be populated with request parameters
	 * @return - SadadPortalSessionBean object after setting the request parameter in session object
	 */
	protected <T>T populateRequestParamsInSessionBean(PortletRequest request, SadadPortalSessionBean so, Class<T> castTo)
	{
		Enumeration<String> enm = request.getParameterNames();
		while (enm.hasMoreElements())
		{
			String attrName = enm.nextElement();
			if (attrName.startsWith(PortalConstant.REQUEST_PARAMETER_INITIALS))
			{
				String fieldName = attrName.substring(PortalConstant.REQUEST_PARAMETER_INITIALS.length());
				String attrValue = (String) request.getParameter(attrName);
				try
				{
					Field field = so.getClass().getDeclaredField(fieldName);
					field.setAccessible(true);
					field.set(so, attrValue);
				}
				catch (Exception e)
				{
					throw new IllegalStateException(e);
				}
			}
		}
		return castTo.cast(so);
	}
	
	protected String composeJsonResponse(SadadPortalSessionBean so)
	{
		char col = ':';
		char comma = ',';
		char quote = '"';
		char ob = '{';
		char cb = '}';
		StringBuilder response = new StringBuilder();
		response.append(ob);
		response.append(quote).append(PortalConstant.MESSAGE_TYPE).append(quote).append(col);
		response.append(quote).append(so.getMessageToDisplay().getMessageType().toString()).append(quote).append(comma);
		response.append(quote).append(PortalConstant.DISPLAY_MESSAGE).append(quote).append(col);
		response.append(quote).append(so.getMessageToDisplay().getDisplayMessage()).append(quote);
		response.append(cb);
		return response.toString();
	}
}