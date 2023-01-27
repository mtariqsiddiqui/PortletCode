/**
 * 
 */
package com.sadad.portal.portlets.operations.files;

import java.io.IOException;
import java.io.PrintWriter;
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
import com.sadad.portal.beans.BatchFilesSessionDataBean;
import com.sadad.portal.constant.PortalConstant;
import com.sadad.portal.helper.BatchFilesHelper;

/**
 * @author Tariq Siddiqui
 *
 */
public class RegenerateBatchFilesPortlet extends SadadGenericPortlet
{
	private static final String CLASS_NAME = RegenerateBatchFilesPortlet.class.getName();
	private static final Logger logger = Logger.getLogger(CLASS_NAME);

	private static final String JSP_FOLDER = "/jsp/html/operatorations/regenerateBatchFiles/"; // JSP folder name
	private static final String VIEW_JSP_INDEX = "RegenerateBatchFilesIndex";
	private static final String VIEW_JSP_FORM = "RegenerateBatchFilesQueryForm"; // JSP file name to be rendered on the view mode

	private BatchFilesHelper hlpObj = new BatchFilesHelper();
	private BatchFilesSessionDataBean sesObj;

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

		sesObj = getSessionBeanObject(request, BatchFilesSessionDataBean.class);
		if (sesObj == null)
		{
			sesObj = new BatchFilesSessionDataBean();
			sesObj.getScreen().setContainer1(getJspFilePath(JSP_FOLDER, VIEW_JSP_FORM));
			sesObj.getScreen().setContainer2(null);
			sesObj = populateUserDetailsInSessionBean(request, sesObj, BatchFilesSessionDataBean.class);
		}

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

		sesObj = getSessionBeanObject(request, BatchFilesSessionDataBean.class);

		String whereTo = request.getParameter("fpWhereTo");
		if (whereTo.equals(PortalConstant.BACK))
			sesObj.setScreen(sesObj.navigate(whereTo));
		else if (whereTo.equals(PortalConstant.FINISH))
			sesObj = null;

		request.getPortletSession().setAttribute(PortalConstant.PORTLET_SESSION_BEAN, sesObj, PortletSession.PORTLET_SCOPE);

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

		sesObj = getSessionBeanObject(request, BatchFilesSessionDataBean.class);
		sesObj = populateRequestParamsInSessionBean(request, sesObj, BatchFilesSessionDataBean.class);
		sesObj = callRequiredBackEndServiceOperation(sesObj, hlpObj, BatchFilesSessionDataBean.class);

		// Handling of Screen Rendering
		screenHandling(sesObj, JSP_FOLDER, jspResourceId);

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
