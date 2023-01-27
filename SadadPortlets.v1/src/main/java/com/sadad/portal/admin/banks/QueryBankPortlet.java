package com.sadad.portal.admin.banks;

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
import com.sadad.portal.beans.BankDetail;
import com.sadad.portal.beans.BankSessionBean;
import com.sadad.portal.constant.PortalConstant;

public class QueryBankPortlet extends SadadGenericPortlet
{
	private static final String CLASS_NAME = QueryBankPortlet.class.getName();
	private static Logger logger = Logger.getLogger(CLASS_NAME);
	
	private static final String JSP_FOLDER = "/jsp/html/admin/banks/"; // JSP folder name
	private static final String VIEW_JSP_INDEX = "BankIndex";
	private static final String VIEW_JSP_QUERY_BANK_FORM = "QueryBankForm"; // JSP file name to be rendered on the view mode
	private static final String VIEW_JSP_QUERY_BANK_LIST = "QueryBankList";
	private static final String VIEW_JSP_QUERY_BANK_DETAILS = "QueryBankDetails";
	private static final String VIEW_JSP_QUERY_BANK_UPDATE_FORM = "QueryBankUpdateForm";
	
	private BankHelper bh = new BankHelper();
	private BankSessionBean bSesObj;
	
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
		
		bSesObj = (BankSessionBean) request.getPortletSession().getAttribute(PortalConstant.PORTLET_SESSION_BEAN, PortletSession.PORTLET_SCOPE);
		if(bSesObj == null)
		{
			bSesObj = bh.getBankObject();
			bSesObj.getScreen().setContainer1(getJspFilePath(JSP_FOLDER, VIEW_JSP_QUERY_BANK_FORM));
			bSesObj.getScreen().setContainer2(null);
			request.getPortletSession().setAttribute(PortalConstant.PORTLET_SESSION_BEAN, bSesObj, PortletSession.PORTLET_SCOPE);
		}
		
		// Setting attributes in Request scope
		request.setAttribute(PortalConstant.PORTLET_SESSION_BEAN, bSesObj);

		// Invoke the JSP to render, replace with the actual jsp name
		PortletRequestDispatcher rd = getPortletContext().getRequestDispatcher(getJspFilePath(JSP_FOLDER, VIEW_JSP_INDEX));
		rd.include(request, response);

//		SadadPortalUtils.logSessionAttributesWithValues(request, methodName, logger);

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
		
		bSesObj = (BankSessionBean) request.getPortletSession().getAttribute(PortalConstant.PORTLET_SESSION_BEAN, PortletSession.PORTLET_SCOPE);

		String whereTo = request.getParameter("fpWhereTo");
		if(whereTo.equals(PortalConstant.BACK))
			bSesObj.setScreen(bSesObj.navigate(whereTo));
		else if(whereTo.equals(PortalConstant.FINISH))
			bSesObj = null;

		request.getPortletSession().setAttribute(PortalConstant.PORTLET_SESSION_BEAN, bSesObj, PortletSession.PORTLET_SCOPE);

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
		logger.entering(CLASS_NAME, methodName);

		String jspResourceId = request.getResourceID();

		logger.logp(Level.INFO, CLASS_NAME, methodName, jspResourceId);

		// 1 - Get BeanObject from Session
		// 2 - Set the Same BeanObject in Helper
		// 3 - Call Helper WebService method
		// 4 - Set Same BeanObject in Session and Request
		
		bSesObj = (BankSessionBean) request.getPortletSession().getAttribute(PortalConstant.PORTLET_SESSION_BEAN, PortletSession.PORTLET_SCOPE);
		bh.setBankObject(bSesObj);

		if(jspResourceId.equals(VIEW_JSP_QUERY_BANK_FORM))
		{
//			bh.callListPaymentType(request.getParameter("txtPartnerKey"));
		}
		else if (jspResourceId.equals(VIEW_JSP_QUERY_BANK_LIST))
		{
			String bankId = request.getParameter("txtBankId");
			if(bankId != null && bankId.trim().length() > 0)
			{
				bSesObj.setPartnerKey(bankId);
				bSesObj.setSelectedBank(new BankDetail());
				bSesObj.getSelectedBank().setBankId(bankId);
			}
			else
			{
				bankId = null;
				bSesObj.setSelectedBank(null);
			}
		}
		else if (jspResourceId.equals(VIEW_JSP_QUERY_BANK_DETAILS))
		{
			if(request.getParameter("reqAction") != null)
			{
				// reqAction is requested Action parameter to decide here which server to call
				if(request.getParameter("reqAction").equalsIgnoreCase("Save")) // Save button is pressed call update service
				{
					bh.callUpdateBank(request.getParameter("txtBankId"), request.getParameter("txtBankName"), request.getParameter("txtDescription"), 
							request.getParameter("txtSuspenceAccount"), request.getParameter("txtRefundAccount"), request.getParameter("txtSarieKey"));
				}
				else if(request.getParameter("reqAction").equalsIgnoreCase("Cancel")) // Cancel button is pressed ; do nothing
				{}
				else if(request.getParameter("reqAction").equalsIgnoreCase("toggleStatus")) // Activate / Deactivate button pressed
				{
					bh.callActivateOrDeActivateBank();
				}
			}
			else
			{
				bh.callGetBankByKey(request.getParameter("txtBankId"));
			}
		}
		else if (jspResourceId.equals(VIEW_JSP_QUERY_BANK_UPDATE_FORM))
		{}
		
		// Handling of Screen Rendering
		screenHandling(bSesObj, JSP_FOLDER, jspResourceId);
		
		// Setting the same session object in request Attribute and Portlet Session Attribute
		request.setAttribute(PortalConstant.PORTLET_SESSION_BEAN, bSesObj);
		request.getPortletSession().setAttribute(PortalConstant.PORTLET_SESSION_BEAN, bSesObj, PortletSession.PORTLET_SCOPE);
		
		response.setContentType("text/html; charset=UTF-8");
		PortletRequestDispatcher rd = getPortletContext().getRequestDispatcher(getJspFilePath(JSP_FOLDER, jspResourceId));
		rd.include(request, response);

		logger.exiting(CLASS_NAME, methodName);
	}	
}