package com.sadad.portal.portlets.users.profile;

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
import com.sadad.portal.beans.PortalUserSessionDataBean;
import com.sadad.portal.constant.PortalConstant;
import com.sadad.portal.helper.PortalUserHelper;

/**
 * @author Tariq Siddiqui
 * 
 */
public class AcceptTermsConditionsPortlet extends SadadGenericPortlet
{
	private static final String CLASS_NAME = AcceptTermsConditionsPortlet.class.getName();
	private static final Logger logger = Logger.getLogger(CLASS_NAME);
	
	private static final String JSP_FOLDER = "/jsp/html/users/accepttermscondition/"; // JSP folder name
	private static final String VIEW_JSP_INDEX = "AcceptTermsConditionIndex"; // JSP file name to be rendered on the view mode
	private static final String VIEW_JSP_EDIT_PROFILE_FORM = "AcceptTermsConditionForm";

	private PortalUserHelper hlpObj = new PortalUserHelper();
	private PortalUserSessionDataBean sesObj;

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

		sesObj = getSessionBeanObject(request, PortalUserSessionDataBean.class);
		if (sesObj == null)
		{
			sesObj = new PortalUserSessionDataBean();
			sesObj.getScreen().setContainer1(getJspFilePath(JSP_FOLDER, VIEW_JSP_EDIT_PROFILE_FORM));
			sesObj.getScreen().setContainer2(null);
			sesObj = populateUserDetailsInSessionBean(request, sesObj, PortalUserSessionDataBean.class);
		}

		sesObj.setRequest(request);
//		sesObj.setUserId(request.getRemoteUser());
		sesObj = hlpObj.retrieveCurrentUserProfile(sesObj); // Call to retrieve the information from LDAP

		// Setting attributes in Request scope
		request.setAttribute(PortalConstant.PORTLET_SESSION_BEAN, sesObj);
		setSessionBeanObject(request, sesObj);

		// Invoke the JSP to render, replace with the actual jsp name
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

		sesObj = getSessionBeanObject(request, PortalUserSessionDataBean.class);
		sesObj = populateRequestParamsInSessionBean(request, sesObj, PortalUserSessionDataBean.class);

		// txtOperation defined hidden field on Change Password JSP Form
		if (request.getParameter("txtOperation").equalsIgnoreCase("decline"))
			hlpObj.logOutUser(request, response);

		if (request.getParameter("txtOperation").equalsIgnoreCase("accept"))
		{
			sesObj = hlpObj.acceptTermsCondition(sesObj, request, response);
			
			if (hlpObj.isPasswordExpired(sesObj.getLastPasswordChangeDate()))
				response.sendRedirect(hlpObj.getRedirectURL(PortalConstant.SADAD_CHANGE_PASSWORD_AT_LOGIN_PAGE, request, response));
			else
				response.sendRedirect(hlpObj.getRedirectURL(PortalConstant.SADAD_HOME_PAGE, request, response));
		}

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

		sesObj = getSessionBeanObject(request, PortalUserSessionDataBean.class);
		sesObj = populateRequestParamsInSessionBean(request, sesObj, PortalUserSessionDataBean.class);
		sesObj = callRequiredBackEndServiceOperation(sesObj, hlpObj, PortalUserSessionDataBean.class);

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
