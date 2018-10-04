package com.sadad.portal.ebpp.accounts;

import java.io.IOException;
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
import com.sadad.portal.constant.PortalConstant;

public class RejectedAccountsPortlet extends SadadGenericPortlet
{
	private static final String CLASS_NAME = RejectedAccountsPortlet.class.getName();
	private static Logger logger = Logger.getLogger(CLASS_NAME);
	
	private static final String JSP_FOLDER = "/jsp/html/ebpp/accounts/"; // JSP folder name
	private static final String VIEW_JSP_INDEX = "RejectedAccountsIndex"; // JSP file name to be rendered on the view mode
	private static final String VIEW_JSP_FORM = "RejectedAccountForm"; // JSP file name to be rendered on the view mode
	private static final String VIEW_JSP_ADV_FORM = "RejectedAccountAdvanceForm"; // JSP file name to be rendered on the view mode
	private static final String VIEW_JSP_REJECTED_LIST = "RejectedAccountsList"; // JSP file name to be rendered on the view mode
	
	private AccountsHelper ah = new AccountsHelper();
	private RejectedAccountsSessionBean raSesObj;
	
	/**
	 * @see javax.portlet.Portlet#init()
	 */
	@Override
	public void init() throws PortletException
	{
		super.init();
	}

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

		raSesObj = (RejectedAccountsSessionBean) request.getPortletSession().getAttribute(PortalConstant.PORTLET_SESSION_BEAN, PortletSession.PORTLET_SCOPE);
		if (raSesObj == null)
		{
			raSesObj = ah.getRejectedAccountsObject();
			raSesObj.getScreen().setContainer1(getJspFilePath(JSP_FOLDER, VIEW_JSP_FORM));
			request.getPortletSession().setAttribute(PortalConstant.PORTLET_SESSION_BEAN, raSesObj, PortletSession.PORTLET_SCOPE);
		}

		// Setting attributes in Request scope
		request.setAttribute(PortalConstant.PORTLET_SESSION_BEAN, raSesObj);

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
	public void processAction(ActionRequest request, ActionResponse response) throws PortletException, java.io.IOException
	{
		final String methodName = "processAction";
		logger.entering(CLASS_NAME, methodName);
		
		logger.exiting(CLASS_NAME, methodName);	
	}

	/**
	 * Process a serve Resource request.
	 * 
	 * @see javax.portlet.Portlet#serveResource(javax.portlet.ResourceRequest, javax.portlet.ResourceResponse)
	 */
	@Override
	public void serveResource(ResourceRequest request, ResourceResponse response) throws PortletException, java.io.IOException
	{
		final String methodName = "serveResource";
		String jspResourceId = request.getResourceID();
		logger.entering(CLASS_NAME, methodName, jspResourceId);

		// 1 - Get BeanObject from Session
		// 2 - Set the Same BeanObject in Helper
		// 3 - Call Helper WebService method
		// 4 - Set Same BeanObject in Session and Request

		raSesObj = (RejectedAccountsSessionBean) request.getPortletSession().getAttribute(PortalConstant.PORTLET_SESSION_BEAN, PortletSession.PORTLET_SCOPE);
		ah.setRejectedAccountsObject(raSesObj);

		if (jspResourceId.equals(VIEW_JSP_FORM))
		{}
		else if (jspResourceId.equals(VIEW_JSP_ADV_FORM))
		{}
		else if (jspResourceId.equals(VIEW_JSP_REJECTED_LIST))
		{}

		// Handling of Screen Rendering
		screenHandling(raSesObj, JSP_FOLDER, jspResourceId);

		// Setting the same session object in request Attribute and Portlet Session Attribute
		request.setAttribute(PortalConstant.PORTLET_SESSION_BEAN, raSesObj);
		request.getPortletSession().setAttribute(PortalConstant.PORTLET_SESSION_BEAN, raSesObj, PortletSession.PORTLET_SCOPE);

		response.setContentType("text/html");
		PortletRequestDispatcher rd = getPortletContext().getRequestDispatcher(getJspFilePath(JSP_FOLDER, jspResourceId));
		rd.include(request, response);

		logger.exiting(CLASS_NAME, methodName);
	}
}
