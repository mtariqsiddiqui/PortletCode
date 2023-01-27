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
import com.sadad.portal.beans.RejectedEbppSessionDataBean;
import com.sadad.portal.constant.PortalConstant;
import com.sadad.portal.helper.RejectedEbppHelper;

public class RejectedAccountsPortlet extends SadadGenericPortlet
{
	private static final String CLASS_NAME = RejectedAccountsPortlet.class.getName();
	private static final Logger logger = Logger.getLogger(CLASS_NAME);
	
	private static final String JSP_FOLDER = "/jsp/html/ebpp/accounts/"; // JSP folder name
	private static final String VIEW_JSP_INDEX = "RejectedAccountsIndex"; // JSP file name to be rendered on the view mode
	private static final String VIEW_JSP_REJECTED_ACCOUNT_FORM = "RejectedAccountForm"; // JSP file name to be rendered on the view mode

	private RejectedEbppHelper hlpObj = new RejectedEbppHelper();
	private RejectedEbppSessionDataBean sesObj;

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

		sesObj = getSessionBeanObject(request, RejectedEbppSessionDataBean.class);
		if (sesObj == null)
		{
			sesObj = new RejectedEbppSessionDataBean();
			sesObj.getScreen().setContainer1(getJspFilePath(JSP_FOLDER, VIEW_JSP_REJECTED_ACCOUNT_FORM));
			sesObj.getScreen().setContainer2(null);
			sesObj = populateUserDetailsInSessionBean(request, sesObj, RejectedEbppSessionDataBean.class);
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
		
		sesObj = getSessionBeanObject(request, RejectedEbppSessionDataBean.class);

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

		sesObj = getSessionBeanObject(request, RejectedEbppSessionDataBean.class);
		sesObj = populateRequestParamsInSessionBean(request, sesObj, RejectedEbppSessionDataBean.class);
		sesObj = callRequiredBackEndServiceOperation(sesObj, hlpObj, RejectedEbppSessionDataBean.class);
		
		// Handling of Screen Rendering
		screenHandling(sesObj, JSP_FOLDER, jspResourceId);

		// Setting the same session object in request Attribute and Portlet Session Attribute
		request.setAttribute(PortalConstant.PORTLET_SESSION_BEAN, sesObj);
		setSessionBeanObject(request, sesObj);

		// Error occurred during backend service call, render JSON error message
		if (sesObj.getMessageToDisplay() != null)
		{
			response.setContentType("application/json; charset=UTF-8");
			PrintWriter pw = response.getWriter();
			pw.print(composeJsonResponse(sesObj));
			pw.close();
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