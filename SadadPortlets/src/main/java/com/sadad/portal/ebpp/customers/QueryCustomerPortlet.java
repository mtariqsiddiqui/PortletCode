package com.sadad.portal.ebpp.customers;

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

public class QueryCustomerPortlet extends SadadGenericPortlet
{
	private static final String CLASS_NAME = QueryCustomerPortlet.class.getName();
	private static Logger logger = Logger.getLogger(CLASS_NAME);

	public static final String JSP_FOLDER = "/jsp/html/ebpp/customers/"; // JSP folder name
	private static final String VIEW_JSP_INDEX = "QueryCustomerIndex"; // JSP file name to be rendered on the view mode
	private static final String VIEW_JSP_QUERY_CUSTOMER_FORM = "QueryCustomerForm"; // JSP file name to be rendered on the view mode

	private static final String VIEW_JSP_CORE_ACCOUNT_SUMMARY = "core_AccountSummary"; // JSP file name to be rendered on the view mode
	private static final String VIEW_JSP_CORE_ACCOUNT_DETAILS = "core_AccountDetails"; // JSP file name to be rendered on the view mode
	private static final String VIEW_JSP_CORE_BILLER_SUMMARY = "core_BillerSummary"; // JSP file name to be rendered on the view mode
	private static final String VIEW_JSP_CORE_BILLS_SUMMARY = "core_BillsSummary"; // JSP file name to be rendered on the view mode
	private static final String VIEW_JSP_CORE_BILLS_DETAILS = "core_BillsDetails"; // JSP file name to be rendered on the view mode
	private static final String VIEW_JSP_CORE_CSUTOMER_SUMMARY = "core_CustomerSummary"; // JSP file name to be rendered on the view mode
	private static final String VIEW_JSP_CORE_CSUTOMER_DETAILS = "core_CustomerDetails"; // JSP file name to be rendered on the view mode
	private static final String VIEW_JSP_CORE_ASSOCIATIONS_SUMMARY = "core_AssociationsSummary"; // JSP file name to be rendered on the view mode
	private static final String VIEW_JSP_CORE_ASSOCIATIONS_DETAILS = "core_AssociationsDetails"; // JSP file name to be rendered on the view mode
	private static final String VIEW_JSP_CORE_PAYMENTS_SUMMARY = "core_PaymentsSummary"; // JSP file name to be rendered on the view mode
	private static final String VIEW_JSP_CORE_PAYMENTS_DETAILS = "core_PaymentsDetails"; // JSP file name to be rendered on the view mode
	private static final String VIEW_JSP_CORE_REFUND_SUMMARY = "core_RefundsSummary"; // JSP file name to be rendered on the view mode
	private static final String VIEW_JSP_CORE_REFUND_DETAILS = "core_RefundsDetails"; // JSP file name to be rendered on the view mode
	private static final String VIEW_JSP_CORE_AUDIT_SUMMARY = "core_AuditSummary"; // JSP file name to be rendered on the view mode
	private static final String VIEW_JSP_CORE_BUISNESS_RULES_SUMMARY = "core_BusinessRulesSummary"; // JSP file name to be rendered on the view mode

	private CustomerHelper ch = new CustomerHelper();
	private QueryCustomerSessionBean qcSesObj;

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

		qcSesObj = (QueryCustomerSessionBean) request.getPortletSession().getAttribute(PortalConstant.PORTLET_SESSION_BEAN, PortletSession.PORTLET_SCOPE);
		if (qcSesObj == null)
		{
			qcSesObj = ch.getQueryCustomerObject();
			qcSesObj.getScreen().setContainer1(getJspFilePath(JSP_FOLDER, VIEW_JSP_QUERY_CUSTOMER_FORM));
			qcSesObj.getScreen().setContainer2(null);
			request.getPortletSession().setAttribute(PortalConstant.PORTLET_SESSION_BEAN, qcSesObj, PortletSession.PORTLET_SCOPE);
		}

		// Setting attributes in Request scope
		request.setAttribute(PortalConstant.PORTLET_SESSION_BEAN, qcSesObj);
		
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
	public void processAction(ActionRequest request, ActionResponse response) throws PortletException, java.io.IOException
	{
		final String methodName = "processAction";
		logger.entering(CLASS_NAME, methodName);
		
		qcSesObj = (QueryCustomerSessionBean) request.getPortletSession().getAttribute(PortalConstant.PORTLET_SESSION_BEAN, PortletSession.PORTLET_SCOPE);

		String whereTo = request.getParameter("fpWhereTo");
		if(whereTo.equals(PortalConstant.BACK))
			qcSesObj.setScreen(qcSesObj.navigate(whereTo));
		else if(whereTo.equals(PortalConstant.FINISH))
			qcSesObj = null;
		
		request.getPortletSession().setAttribute(PortalConstant.PORTLET_SESSION_BEAN, qcSesObj, PortletSession.PORTLET_SCOPE);		
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

		qcSesObj = (QueryCustomerSessionBean) request.getPortletSession().getAttribute(PortalConstant.PORTLET_SESSION_BEAN, PortletSession.PORTLET_SCOPE);
		ch.setQueryCustomerObject(qcSesObj);

		if (jspResourceId.equals(VIEW_JSP_QUERY_CUSTOMER_FORM))
		{}
		else if (jspResourceId.equals(VIEW_JSP_CORE_ACCOUNT_SUMMARY))
		{
			//ch.getByKey(request.getParameter("txtPartnerKey"), request.getParameter("txtAccountKey"));			
			qcSesObj.setPartnerKey(qcSesObj.getAccount().getBillerId());
			qcSesObj.setAccountNumber(qcSesObj.getAccount().getAccountNumber());
		}
		else if (jspResourceId.equals(VIEW_JSP_CORE_ACCOUNT_DETAILS))
		{}
		else if (jspResourceId.equals(VIEW_JSP_CORE_BILLER_SUMMARY))
		{}
		else if (jspResourceId.equals(VIEW_JSP_CORE_BILLS_SUMMARY))
		{}
		else if (jspResourceId.equals(VIEW_JSP_CORE_BILLS_DETAILS))
		{
			qcSesObj.setBillKey(request.getParameter("fpBillNumber"));
		}
		else if (jspResourceId.equals(VIEW_JSP_CORE_CSUTOMER_SUMMARY))
		{}
		else if (jspResourceId.equals(VIEW_JSP_CORE_CSUTOMER_DETAILS))
		{}
		else if (jspResourceId.equals(VIEW_JSP_CORE_ASSOCIATIONS_SUMMARY))
		{}
		else if (jspResourceId.equals(VIEW_JSP_CORE_ASSOCIATIONS_DETAILS))
		{}
		else if (jspResourceId.equals(VIEW_JSP_CORE_PAYMENTS_SUMMARY))
		{}
		else if (jspResourceId.equals(VIEW_JSP_CORE_PAYMENTS_DETAILS))
		{
			qcSesObj.setPaymentKey(request.getParameter("rpPaymentKey"));
		}
		else if (jspResourceId.equals(VIEW_JSP_CORE_REFUND_SUMMARY))
		{}
		else if (jspResourceId.equals(VIEW_JSP_CORE_REFUND_DETAILS))
		{
			qcSesObj.setRefundKey(request.getParameter("rpRefundKey"));
		}
		else if (jspResourceId.equals(VIEW_JSP_CORE_AUDIT_SUMMARY))
		{
			System.out.println(qcSesObj.getAudits());
		}
		else if (jspResourceId.equals(VIEW_JSP_CORE_BUISNESS_RULES_SUMMARY))
		{
			System.out.println(qcSesObj.getBusinessRules());
		}
		
		// Handling of Screen Rendering
		screenHandling(qcSesObj, JSP_FOLDER, jspResourceId);

		// Setting the same session object in request Attribute and Portlet Session Attribute
		request.setAttribute(PortalConstant.PORTLET_SESSION_BEAN, qcSesObj);
		request.getPortletSession().setAttribute(PortalConstant.PORTLET_SESSION_BEAN, qcSesObj, PortletSession.PORTLET_SCOPE);

		response.setContentType("text/html");
		PortletRequestDispatcher rd = getPortletContext().getRequestDispatcher(getJspFilePath(JSP_FOLDER, jspResourceId));
		rd.include(request, response);

		logger.exiting(CLASS_NAME, methodName);
	}
}
