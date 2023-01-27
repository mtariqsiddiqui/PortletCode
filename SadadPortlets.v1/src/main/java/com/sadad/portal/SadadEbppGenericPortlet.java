/**
 * 
 */
package com.sadad.portal;

import com.sadad.portal.beans.CoreEbppSessionBean;
import com.sadad.portal.helper.CoreEbppHelper;

/**
 * @author Tariq Siddiqui
 *
 */
public abstract class SadadEbppGenericPortlet extends SadadGenericPortlet
{
	protected final String VIEW_JSP_CORE_ACCOUNT_SUMMARY = "core_AccountSummary"; // JSP file name to be rendered on the view mode
	protected final String VIEW_JSP_CORE_ACCOUNT_DETAILS = "core_AccountDetails"; // JSP file name to be rendered on the view mode
	protected final String VIEW_JSP_CORE_BILLER_SUMMARY = "core_BillerSummary"; // JSP file name to be rendered on the view mode
	protected final String VIEW_JSP_CORE_BILLS_SUMMARY = "core_BillsSummary"; // JSP file name to be rendered on the view mode
	protected final String VIEW_JSP_CORE_BILLS_DETAILS = "core_BillsDetails"; // JSP file name to be rendered on the view mode
	protected final String VIEW_JSP_CORE_CUSTOMER_SUMMARY = "core_CustomerSummary"; // JSP file name to be rendered on the view mode
	protected final String VIEW_JSP_CORE_CUSTOMER_DETAILS = "core_CustomerDetails"; // JSP file name to be rendered on the view mode
	protected final String VIEW_JSP_CORE_ASSOCIATIONS_SUMMARY_LIST_ACCOUNTS = "core_AssociationsSummaryListAccounts"; // JSP file name to be rendered on the view mode
	protected final String VIEW_JSP_CORE_ASSOCIATIONS_DETAILS_ACCOUNT = "core_AssociationsDetailsByAccount"; // JSP file name to be rendered on the view mode
	protected final String VIEW_JSP_CORE_ASSOCIATIONS_SUMMARY_LIST_CUSTOMERS = "core_AssociationsSummaryListCustomers"; // JSP file name to be rendered on the view mode
	protected final String VIEW_JSP_CORE_ASSOCIATIONS_DETAILS_CUSTOMER = "core_AssociationsDetailsByCustomer"; // JSP file name to be rendered on the view mode
	protected final String VIEW_JSP_CORE_PAYMENTS_SUMMARY = "core_PaymentsSummary"; // JSP file name to be rendered on the view mode
	protected final String VIEW_JSP_CORE_PAYMENTS_DETAILS = "core_PaymentsDetails"; // JSP file name to be rendered on the view mode
	protected final String VIEW_JSP_CORE_REFUND_SUMMARY = "core_RefundsSummary"; // JSP file name to be rendered on the view mode
	protected final String VIEW_JSP_CORE_REFUND_DETAILS = "core_RefundsDetails"; // JSP file name to be rendered on the view mode
	protected final String VIEW_JSP_CORE_AUDIT_SUMMARY = "core_AuditSummary"; // JSP file name to be rendered on the view mode
	protected final String VIEW_JSP_CORE_BUISNESS_RULES_SUMMARY = "core_BusinessRulesSummary"; // JSP file name to be rendered on the view mode
	protected final CoreEbppHelper ch = new CoreEbppHelper(); // CoreEbppHelper object for calling backend services.
	
	/**
	 * 
	 * @param jspResourceId
	 * @param sesObj
	 * @return
	 */
	protected CoreEbppSessionBean serveCoreResources(String jspResourceId, CoreEbppSessionBean sesObj)
	{
		if (jspResourceId.equals(VIEW_JSP_CORE_ACCOUNT_SUMMARY))
		{
			sesObj = ch.callAccountService_GetByKey(sesObj);
		}
		else if (jspResourceId.equals(VIEW_JSP_CORE_ACCOUNT_DETAILS))
		{}
		else if (jspResourceId.equals(VIEW_JSP_CORE_BILLER_SUMMARY))
		{}
		else if (jspResourceId.equals(VIEW_JSP_CORE_BILLS_SUMMARY))
		{}
		else if (jspResourceId.equals(VIEW_JSP_CORE_BILLS_DETAILS))
		{}
		else if (jspResourceId.equals(VIEW_JSP_CORE_CUSTOMER_SUMMARY))
		{
			sesObj = ch.callCustomerService_GetByKey(sesObj);
		}
		else if (jspResourceId.equals(VIEW_JSP_CORE_CUSTOMER_DETAILS))
		{}
		else if (jspResourceId.equals(VIEW_JSP_CORE_ASSOCIATIONS_SUMMARY_LIST_ACCOUNTS))
		{
			sesObj = ch.callAccountService_ListByCustomer(sesObj);
		}
		else if (jspResourceId.equals(VIEW_JSP_CORE_ASSOCIATIONS_DETAILS_ACCOUNT))
		{}
		else if (jspResourceId.equals(VIEW_JSP_CORE_ASSOCIATIONS_SUMMARY_LIST_CUSTOMERS))
		{
			sesObj = ch.callCustomerService_ListByAccount(sesObj);
		}
		else if (jspResourceId.equals(VIEW_JSP_CORE_ASSOCIATIONS_DETAILS_CUSTOMER))
		{}		
		else if (jspResourceId.equals(VIEW_JSP_CORE_PAYMENTS_SUMMARY))
		{}
		else if (jspResourceId.equals(VIEW_JSP_CORE_PAYMENTS_DETAILS))
		{}
		else if (jspResourceId.equals(VIEW_JSP_CORE_REFUND_SUMMARY))
		{}
		else if (jspResourceId.equals(VIEW_JSP_CORE_REFUND_DETAILS))
		{}
		else if (jspResourceId.equals(VIEW_JSP_CORE_AUDIT_SUMMARY))
		{}
		else if (jspResourceId.equals(VIEW_JSP_CORE_BUISNESS_RULES_SUMMARY))
		{}
		
		return sesObj;
	}
}