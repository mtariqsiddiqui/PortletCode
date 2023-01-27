package com.sadad.portal.portlets.ebpp.accounts;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Logger;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.sadad.portal.SadadGenericPortlet;
import com.sadad.portal.beans.CoreEbppSessionDataBean;
import com.sadad.portal.constant.PortalConstant;
import com.sadad.portal.helper.CoreEbppHelper;

/**
 * @author Tariq Siddiqui
 * 
 */
public class QueryAccountPortlet extends SadadGenericPortlet
{
	private static final String CLASS_NAME = QueryAccountPortlet.class.getName();
	private static final Logger logger = Logger.getLogger(CLASS_NAME);

	private static final String JSP_FOLDER = "/jsp/html/ebpp/accounts/"; // JSP folder name
	private static final String VIEW_JSP_INDEX = "QueryAccountIndex"; // JSP file name to be rendered on the view mode
	private static final String VIEW_JSP_QUERY_ACCOUNT_FORM = "QueryAccountForm"; // JSP file name to be rendered on the view mode
    
	private String jspFolderWithPermission = null;
	private CoreEbppHelper hlpObj = new CoreEbppHelper(); 
	private CoreEbppSessionDataBean sesObj;
	
	/**
	 * Serve up the <code>view</code> mode.
	 * 
	 * @see javax.portlet.GenericPortlet#doView(javax.portlet.RenderRequest, javax.portlet.RenderResponse)
	 */
	@Override
	public void doView(RenderRequest request, RenderResponse response) throws PortletException, IOException
	{
		final String methodName = "doView";
		logger.entering(CLASS_NAME, methodName);
		// Set the MIME type for the render response
		response.setContentType(request.getResponseContentType());

		sesObj = getSessionBeanObject(request, CoreEbppSessionDataBean.class);
		if (sesObj == null)
		{
			sesObj = new CoreEbppSessionDataBean();
			sesObj = populateUserDetailsInSessionBean(request, sesObj, CoreEbppSessionDataBean.class);
			jspFolderWithPermission = permissionHandling(sesObj, JSP_FOLDER, VIEW_JSP_QUERY_ACCOUNT_FORM);
			sesObj.getScreen().setContainer1(getJspFilePath(JSP_FOLDER, VIEW_JSP_QUERY_ACCOUNT_FORM));
			sesObj.getScreen().setContainer2(null);
		}
				
		// Setting attributes in Request scope
		request.setAttribute(PortalConstant.PORTLET_SESSION_BEAN, sesObj);
		setSessionBeanObject(request, sesObj);
		
		// Invoke the JSP to render
		PortletRequestDispatcher rd = getPortletContext().getRequestDispatcher(getJspFilePath(JSP_FOLDER, VIEW_JSP_INDEX));
		rd.include(request, response);
		logger.exiting(CLASS_NAME, methodName);
	}

	/**
	 * Process an action request.
	 * 
	 * @see javax.portlet.Portlet#processAction(javax.portlet.ActionRequest, javax.portlet.ActionResponse)
	 */
	@Override
	public void processAction(ActionRequest request, ActionResponse response) throws PortletException, IOException
	{
		final String methodName = "processAction";
		logger.entering(CLASS_NAME, methodName);
		
		sesObj = getSessionBeanObject(request, CoreEbppSessionDataBean.class);

		String whereTo = request.getParameter("fpWhereTo");
		if(whereTo.equals(PortalConstant.BACK))
			sesObj.setScreen(sesObj.navigate(whereTo));
		else if(whereTo.equals(PortalConstant.FINISH))
			sesObj = null;
		
		setSessionBeanObject(request, sesObj);		
		logger.exiting(CLASS_NAME, methodName);
	}

	/**
	 * Process a serve Resource request.
	 * 
	 * @see javax.portlet.Portlet#serveResource(javax.portlet.ResourceRequest, javax.portlet.ResourceResponse)
	 */
	@Override
	public void serveResource(ResourceRequest request, ResourceResponse response) throws PortletException, IOException
	{
		final String methodName = "serveResource";
		String jspResourceId = request.getResourceID();
		logger.entering(CLASS_NAME, methodName, jspResourceId);

		sesObj = getSessionBeanObject(request, CoreEbppSessionDataBean.class);
		sesObj = populateRequestParamsInSessionBean(request, sesObj, CoreEbppSessionDataBean.class);
		sesObj = callRequiredBackEndServiceOperation(sesObj, hlpObj, CoreEbppSessionDataBean.class);
	
		jspFolderWithPermission = permissionHandling(sesObj, JSP_FOLDER, jspResourceId);

		// Handling of Screen Rendering
		screenHandling(sesObj, jspFolderWithPermission, jspResourceId);

		// Setting the same session object in request Attribute and Portlet Session Attribute
		request.setAttribute(PortalConstant.PORTLET_SESSION_BEAN, sesObj);
		setSessionBeanObject(request, sesObj);

		// Error occurred during backend service call, render JSON error message
		if (sesObj.getMessageToDisplay() != null || sesObj.getJsonObj() != null)
		{
			response.setContentType("application/json; charset=UTF-8");
			PrintWriter pw = response.getWriter();
			if(sesObj.getMessageToDisplay() != null)
				pw.print(composeJsonResponse(sesObj));
			else
				pw.print(sesObj.getJsonObj());
			pw.close();
			sesObj.setJsonObj(null); // set jsonObj to null so in next request it should not come here.
		}
		// Backend service call response completed successfully, render JSP
		else
		{
			response.setContentType("text/html; charset=UTF-8");
			PortletRequestDispatcher rd = getPortletContext().getRequestDispatcher(getJspFilePath(JSP_FOLDER, jspResourceId));
			rd.include(request, response);
		}
		logger.exiting(CLASS_NAME, methodName);
	}
}