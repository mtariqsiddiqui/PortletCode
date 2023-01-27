package com.sadad.portal.services.delegate.factory;

import com.sadad.portal.services.delegate.factory.implementation.AccountQueryDelegate;
import com.sadad.portal.services.delegate.factory.implementation.AuditServiceDelegate;
import com.sadad.portal.services.delegate.factory.implementation.BillSearchDelegate;
import com.sadad.portal.services.delegate.factory.implementation.BillerNotificationDelegate;
import com.sadad.portal.services.delegate.factory.implementation.BulkUploadConfirmationServiceDelegate;
import com.sadad.portal.services.delegate.factory.implementation.BulkUploadConfirmationServiceTypeEnum;
import com.sadad.portal.services.delegate.factory.implementation.BulkUploadDelegate;
import com.sadad.portal.services.delegate.factory.implementation.CacheServiceDelegate;
import com.sadad.portal.services.delegate.factory.implementation.CorePaymentDelegate;
import com.sadad.portal.services.delegate.factory.implementation.CustomerDelegate;
import com.sadad.portal.services.delegate.factory.implementation.FileManagementServiceDelegate;
import com.sadad.portal.services.delegate.factory.implementation.IbanManagementDelegate;
import com.sadad.portal.services.delegate.factory.implementation.PartnerConfigurationServiceDelegate;
import com.sadad.portal.services.delegate.factory.implementation.PartnerManagementDelegate;
import com.sadad.portal.services.delegate.factory.implementation.PartnerProfileServiceDelegate;
import com.sadad.portal.services.delegate.factory.implementation.ReconciliationCutoffServiceDelegate;
import com.sadad.portal.services.delegate.factory.implementation.ReconciliationReportServiceDelegate;
import com.sadad.portal.services.delegate.factory.implementation.ReconciliationReportServiceTypeEnum;
import com.sadad.portal.services.delegate.factory.implementation.ReferenceDataServiceDelegate;
import com.sadad.portal.services.delegate.factory.implementation.RefundManagementDelegate;
import com.sadad.portal.services.delegate.factory.implementation.RefundSearchDelegate;
import com.sadad.portal.services.delegate.factory.implementation.SettlementInstructuionsReportServiceDelegate;
import com.sadad.portal.services.delegate.factory.implementation.TestConnectivityDelegate;

/**
 * @author Tariq Siddiqui
 * 
 */
public abstract class ServiceDelegateFactory
{
	/** Singleton instance. */
	private static ServiceDelegateFactory instance;

	/** Default Constructor. */
	protected ServiceDelegateFactory()
	{}

	/**
	 * This method get the configuration object from the ConfigurationCache class. This method returns the singleton instance of the target Delegate factory implementation using the configuration object which takes the CONFIGURATION_KEY as
	 * input. The Delegate factory implementation will be determined at runtime based on a configuration property file having the CONFIGURATION_KEY.
	 * 
	 * @return ServiceDelegateFactory the singleton instance of the factory.
	 */
	public static ServiceDelegateFactory getInstance()
	{
		// Determine the factory implementation and return it.
		if (instance == null)
		{
			try
			{
				instance = (ServiceDelegateFactory) Class.forName(ServiceDelegateFactoryImpl.class.getName()).newInstance();
			}
			catch (IllegalAccessException e)
			{
				throw new RuntimeException("IllegalAccessException", e);
			}
			catch (InstantiationException e)
			{
				throw new RuntimeException("InstantiationException", e);
			}
			catch (ClassNotFoundException classNotFoundException)
			{
				throw new RuntimeException("ClassNotFoundException", classNotFoundException);
			}
		}
		return instance;
	}

	/**
	 * This method abstracts the type of Delegate to be instantiated. The implementation should be provided by the subclass.
	 * 
	 */

	public abstract AccountQueryDelegate getAccountQueryDelegate();

	public abstract AuditServiceDelegate getAuditServiceDelegate();

	public abstract BillerNotificationDelegate getBillerNotificationDelegate();

	public abstract BillSearchDelegate getBillSearchDelegate();

	public abstract BulkUploadDelegate getBulkUploadDelegate();

	public abstract BulkUploadConfirmationServiceDelegate getBulkUploadConfirmationServiceDelegate(BulkUploadConfirmationServiceTypeEnum type);

	public abstract CacheServiceDelegate getCacheServiceDelegate();

	public abstract CorePaymentDelegate getCorePaymentDelegate();

	public abstract CustomerDelegate getCustomerDelegate();

	public abstract FileManagementServiceDelegate getFileManagementServiceDelegate();

	public abstract IbanManagementDelegate getIbanManagementDelegate();

	public abstract PartnerConfigurationServiceDelegate getPartnerConfigurationServiceDelegate();

	public abstract PartnerManagementDelegate getPartnerManagementDelegate();

	public abstract PartnerProfileServiceDelegate getPartnerProfileServiceDelegate();

	public abstract ReconciliationCutoffServiceDelegate getReconciliationCutoffServiceDelegate();

	public abstract ReconciliationReportServiceDelegate getReconciliationReportServiceDelegate(ReconciliationReportServiceTypeEnum type);

	public abstract ReferenceDataServiceDelegate getReferenceDataServiceDelegate();

	public abstract RefundManagementDelegate getRefundManagementDelegate();

	public abstract RefundSearchDelegate getRefundSearchDelegate();

	public abstract SettlementInstructuionsReportServiceDelegate getSettlementInstructuionsReportServiceDelegate();

	public abstract TestConnectivityDelegate getTestConnectivityDelegate();
}
