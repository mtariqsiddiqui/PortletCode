/**
 * 
 */
package com.sadad.portal.services.delegate.factory.implementation;

import java.util.ResourceBundle;

/**
 * @author Tariq Siddiqui
 * 
 */
public final class SadadServicesEndPointUrls
{
	// Private Constructor, the class is not meant to be initialized
	private SadadServicesEndPointUrls()
	{
		throw new IllegalStateException("SadadServicesEndPointUrls is a utility class, should be used in a static manner.");
	}
	// SadadServicesEndPointUrls file is located under ${USER_INSTALL_ROOT}/PortalServer/config
	// ( portal.properties.dir ) property defined under JVM Custom properties
	static final ResourceBundle rb = ResourceBundle.getBundle("com.sadad.SadadServicesEndPointUrls");

	// The DUMMY_SERVICE_ENDPOINT is introduced to tackle multiple code of stream while fixing issues in Trunk
	static final String DUMMY_SERVICE_ENDPOINT = "http://wasbatvip.sadad.com:9080/DummyServiceComponent/NotAnActualService/";

	public static final String ACCOUNT_SERVICE_ENDPOINT = rb.getString("AccountService.EndPoint");

	public static final String AUDIT_SERVICE_ENDPOINT = rb.getString("AuditService.EndPoint");

	public static final String BILLER_NOTIFICATION_SERVICE = rb.getString("BillerNotificationService.EndPoint");

	public static final String BILL_SERVICE_ENDPOINT = rb.getString("BillService.EndPoint");

	public static final String BULK_UPLOAD_SERVICE_ENDPOINT = rb.getString("BulkUploadService.EndPoint");

	public static final String BULK_UPLOAD_CONFIRMATION_ACCOUNTS_SERVICE_ENDPOINT = rb.getString("BulkUploadConfirmationAccountsService.EndPoint");
	public static final String BULK_UPLOAD_CONFIRMATION_BILLS_SERVICE_ENDPOINT = rb.getString("BulkUploadConfirmationBillsService.EndPoint");
	public static final String BULK_UPLOAD_CONFIRMATION_PAYMENTS_SERVICE_ENDPOINT = rb.getString("BulkUploadConfirmationPaymentsService.EndPoint");

	public static final String CACHE_SERVICE_ENDPOINT = rb.getString("CacheService.EndPoint");

	public static final String CUSTOMER_SERVICE_ENDPOINT = rb.getString("CustomerService.EndPoint");

	public static final String FILE_MANAGEMENT_SERVICE_ENDPOINT = rb.getString("FileManagementService.EndPoint");

	public static final String IBAN_MANAGEMENT_SERVICE_ENDPOINT = rb.getString("IbanManagementService.EndPoint");

	public static final String PARTNER_CONFIGURATION_SERVICE_ENDPOINT = rb.getString("PartnerConfigurationService.EndPoint");

	public static final String PARTNER_MANAGEMENT_SERVICE_ENDPOINT = rb.getString("PartnerManagementService.EndPoint");

	public static final String PARTNER_PROFILE_SERVICE_ENDPOINT = rb.getString("PartnerProfileService.EndPoint");

	public static final String PAYMENT_SERVICE_ENDPOINT = rb.getString("PaymentService.EndPoint");

	public static final String RECONCILIATION_CUTOFF_SERVICE_ENDPOINT = rb.getString("ReconciliationCutoffService.EndPoint");

	public static final String RECONCILIATION_REPORT_BANK_SERVICE_ENDPOINT = rb.getString("ReconciliationReportBankService.EndPoint");
	public static final String RECONCILIATION_REPORT_BILLER_SERVICE_ENDPOINT = rb.getString("ReconciliationReportBillerService.EndPoint");

	public static final String REFERENCE_DATA_SERVICE_ENDPOINT = rb.getString("ReferenceDataService.EndPoint");

	public static final String REFUND_SERVICE_ENDPOINT = rb.getString("RefundService.EndPoint");
	public static final String REFUND_UPDATE_SERVICE_ENDPOINT = rb.getString("RefundUpdateService.EndPoint");

	public static final String SETTLEMENT_INSTRUCTUIONS_REPORT_SERVICE_ENDPOINT = rb.getString("SettlementInstructuionsReportService.EndPoint");

	public static final String TEST_CONNECTIVITY_SERVICE_ENDPOINT = rb.getString("TestConnectivityService.EndPoint");

	// JMS_CONNECTION_ID for sending jms messages will have comma separated values of multiple
	public static final String JMS_CONNECTION_ID = rb.getString("JMS_CONNECTION_ID");
}