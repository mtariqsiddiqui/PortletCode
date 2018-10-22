/**
 * 
 */
package com.sadad.portal.admin.sadad;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.PortletSession;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.sadad.portal.SadadGenericPortlet;
import com.sadad.portal.beans.SadadAdminSessionBean;
import com.sadad.portal.constant.PortalConstant;

/**
 * @author Tariq Siddiqui
 * 
 */
public class SadadAdminPortlet extends SadadGenericPortlet
{
	public static boolean RELOAD_DATA = true; // This variable becomes false once lookup data is added to global application scope

	private static final String CLASS_NAME = SadadAdminPortlet.class.getName();
	private static Logger logger = Logger.getLogger(CLASS_NAME);

	private static final String JSP_FOLDER = "/jsp/html/admin/sadad/"; // JSP folder name
	private static final String VIEW_JSP_INDEX = "SadadIndex";
	private static final String VIEW_JSP_SADAD_UPDATE_FORM = "SadadUpdateForm"; // JSP file name to be rendered on the view mode
	private static final String VIEW_JSP_SADAD_DETAILS = "SadadDetails"; // JSP file name to be rendered on the view mode

	private SadadAdminHelper sah = new SadadAdminHelper();
	private SadadAdminSessionBean saSesObj = null;

	@Override
	protected void doView(RenderRequest request, RenderResponse response) throws PortletException, IOException
	{
		final String methodName = "doView";
		logger.entering(CLASS_NAME, methodName);
		final PortletSession ps = request.getPortletSession();
		
		// Set the MIME type for the render response
		response.setContentType(request.getResponseContentType());

		saSesObj = (SadadAdminSessionBean) ps.getAttribute(PortalConstant.PORTLET_SESSION_BEAN, PortletSession.PORTLET_SCOPE);
		if(saSesObj == null)
		{
			saSesObj = sah.callGetSADAD(saSesObj);
			saSesObj.getScreen().setContainer1(getJspFilePath(JSP_FOLDER, VIEW_JSP_SADAD_DETAILS));
			saSesObj.getScreen().setContainer2(null);
		}
		else if (saSesObj.getMessageToDisplay() != null);
			saSesObj.setMessageToDisplay(null); 

		request.setAttribute(PortalConstant.PORTLET_SESSION_BEAN, saSesObj);
		ps.setAttribute(PortalConstant.PORTLET_SESSION_BEAN, saSesObj, PortletSession.PORTLET_SCOPE);

		// Invoke the JSP to render, replace with the actual jsp name
		PortletRequestDispatcher rd = getPortletContext().getRequestDispatcher(getJspFilePath(JSP_FOLDER, VIEW_JSP_INDEX));
		rd.include(request, response);
		
		// SadadPortalUtils.logSessionAttributesWithValues(request, methodName, logger);
		
		logger.exiting(CLASS_NAME, methodName);
	}

	@Override
	public void processAction(ActionRequest request, ActionResponse response) throws PortletException, IOException
	{
		final String methodName = "processAction";
		logger.entering(CLASS_NAME, methodName);

		logger.exiting(CLASS_NAME, methodName);
	}

	@Override
	public void serveResource(ResourceRequest request, ResourceResponse response) throws PortletException, IOException
	{
		final String methodName = "serveResource";
		logger.entering(CLASS_NAME, methodName);
		final PortletSession ps = request.getPortletSession();

		String jspResourceId = request.getResourceID();
		logger.logp(Level.INFO, CLASS_NAME, methodName, jspResourceId);

		// 1 - Get BeanObject from Session
		// 2 - Set the Same BeanObject in Helper
		// 3 - Call Helper WebService method
		// 4 - Set Same BeanObject in Session and Request

		saSesObj = (SadadAdminSessionBean) ps.getAttribute(PortalConstant.PORTLET_SESSION_BEAN, PortletSession.PORTLET_SCOPE);
		
		// Handling of Screen Rendering
		screenHandling(saSesObj, JSP_FOLDER, jspResourceId);
		
		if (jspResourceId.equals(VIEW_JSP_SADAD_DETAILS))
		{
			if(request.getParameter("reqAction") != null)
			{
				// reqAction is requested Action parameter to decide here which server to call
				if(request.getParameter("reqAction").equalsIgnoreCase("Save")) // Save button is pressed call update service
				{
					saSesObj = sah.callUpdateSADAD(request.getParameter("txtCurrentAccount"), request.getParameter("txtBankId"), saSesObj);
					RELOAD_DATA = true;
				}
				else if(request.getParameter("reqAction").equalsIgnoreCase("Cancel")) // Cancel button is pressed ; do nothing
				{}
			}
		}
		else if (jspResourceId.equals(VIEW_JSP_SADAD_UPDATE_FORM))
		{}

		// Setting the same session object in request Attribute and Portlet Session Attribute
		request.setAttribute(PortalConstant.PORTLET_SESSION_BEAN, saSesObj);
		ps.setAttribute(PortalConstant.PORTLET_SESSION_BEAN, saSesObj, PortletSession.PORTLET_SCOPE);
		
		response.setContentType("text/html; charset=UTF-8");
		PortletRequestDispatcher rd = getPortletContext().getRequestDispatcher(getJspFilePath(JSP_FOLDER, jspResourceId));
		rd.include(request, response);

		logger.exiting(CLASS_NAME, methodName);
	}
}