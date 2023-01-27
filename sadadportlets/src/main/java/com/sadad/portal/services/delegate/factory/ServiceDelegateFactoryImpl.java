package com.sadad.portal.services.delegate.factory;

import com.sadad.portal.services.delegate.factory.implementation.AccountQueryDelegate;
import com.sadad.portal.services.delegate.factory.implementation.AccountQueryDelegateImpl;
import com.sadad.portal.services.delegate.factory.implementation.AuditServiceDelegate;
import com.sadad.portal.services.delegate.factory.implementation.AuditServiceDelegateImpl;
import com.sadad.portal.services.delegate.factory.implementation.BillSearchDelegate;
import com.sadad.portal.services.delegate.factory.implementation.BillSearchDelegateImpl;
import com.sadad.portal.services.delegate.factory.implementation.BillerNotificationDelegate;
import com.sadad.portal.services.delegate.factory.implementation.BillerNotificationDelegateImpl;
import com.sadad.portal.services.delegate.factory.implementation.BulkUploadConfirmationAccountsServiceDelegateImpl;
import com.sadad.portal.services.delegate.factory.implementation.BulkUploadConfirmationBillsServiceDelegateImpl;
import com.sadad.portal.services.delegate.factory.implementation.BulkUploadConfirmationPaymentsServiceDelegateImpl;
import com.sadad.portal.services.delegate.factory.implementation.BulkUploadConfirmationServiceDelegate;
import com.sadad.portal.services.delegate.factory.implementation.BulkUploadConfirmationServiceTypeEnum;
import com.sadad.portal.services.delegate.factory.implementation.BulkUploadDelegate;
import com.sadad.portal.services.delegate.factory.implementation.BulkUploadDelegateImpl;
import com.sadad.portal.services.delegate.factory.implementation.CacheServiceDelegate;
import com.sadad.portal.services.delegate.factory.implementation.CacheServiceDelegateImpl;
import com.sadad.portal.services.delegate.factory.implementation.CorePaymentDelegate;
import com.sadad.portal.services.delegate.factory.implementation.CorePaymentDelegateImpl;
import com.sadad.portal.services.delegate.factory.implementation.CustomerDelegate;
import com.sadad.portal.services.delegate.factory.implementation.CustomerDelegateImpl;
import com.sadad.portal.services.delegate.factory.implementation.FileManagementServiceDelegate;
import com.sadad.portal.services.delegate.factory.implementation.FileManagementServiceDelegateImpl;
import com.sadad.portal.services.delegate.factory.implementation.IbanManagementDelegate;
import com.sadad.portal.services.delegate.factory.implementation.IbanManagementDelegateImpl;
import com.sadad.portal.services.delegate.factory.implementation.PartnerConfigurationServiceDelegate;
import com.sadad.portal.services.delegate.factory.implementation.PartnerConfigurationServiceDelegateImpl;
import com.sadad.portal.services.delegate.factory.implementation.PartnerManagementDelegate;
import com.sadad.portal.services.delegate.factory.implementation.PartnerManagementDelegateImpl;
import com.sadad.portal.services.delegate.factory.implementation.PartnerProfileServiceDelegate;
import com.sadad.portal.services.delegate.factory.implementation.PartnerProfileServiceDelegateImpl;
import com.sadad.portal.services.delegate.factory.implementation.ReconciliationCutoffServiceDelegate;
import com.sadad.portal.services.delegate.factory.implementation.ReconciliationCutoffServiceDelegateImpl;
import com.sadad.portal.services.delegate.factory.implementation.ReconciliationReportBankServiceDelegateImpl;
import com.sadad.portal.services.delegate.factory.implementation.ReconciliationReportBillerServiceDelegateImpl;
import com.sadad.portal.services.delegate.factory.implementation.ReconciliationReportServiceDelegate;
import com.sadad.portal.services.delegate.factory.implementation.ReconciliationReportServiceTypeEnum;
import com.sadad.portal.services.delegate.factory.implementation.ReferenceDataServiceDelegate;
import com.sadad.portal.services.delegate.factory.implementation.ReferenceDataServiceDelegateImpl;
import com.sadad.portal.services.delegate.factory.implementation.RefundManagementDelegate;
import com.sadad.portal.services.delegate.factory.implementation.RefundManagementDelegateImpl;
import com.sadad.portal.services.delegate.factory.implementation.RefundSearchDelegate;
import com.sadad.portal.services.delegate.factory.implementation.RefundSearchDelegateImpl;
import com.sadad.portal.services.delegate.factory.implementation.SettlementInstructuionsReportServiceDelegate;
import com.sadad.portal.services.delegate.factory.implementation.SettlementInstructuionsReportServiceDelegateImpl;
import com.sadad.portal.services.delegate.factory.implementation.TestConnectivityDelegate;
import com.sadad.portal.services.delegate.factory.implementation.TestConnectivityDelegateImpl;

/**
 * @author Tariq Siddiqui
 * 
 */
public class ServiceDelegateFactoryImpl extends ServiceDelegateFactory
{
	@Override
	public AccountQueryDelegate getAccountQueryDelegate()
	{
		return AccountQueryDelegateImpl.getInstance();
	}

	@Override
	public AuditServiceDelegate getAuditServiceDelegate()
	{
		return AuditServiceDelegateImpl.getInstance();
	}

	@Override
	public BillerNotificationDelegate getBillerNotificationDelegate()
	{
		return BillerNotificationDelegateImpl.getInstance();
	}

	@Override
	public BillSearchDelegate getBillSearchDelegate()
	{
		return BillSearchDelegateImpl.getInstance();
	}

	@Override
	public BulkUploadDelegate getBulkUploadDelegate()
	{
		return BulkUploadDelegateImpl.getInstance();
	}

	@Override
	public BulkUploadConfirmationServiceDelegate getBulkUploadConfirmationServiceDelegate(BulkUploadConfirmationServiceTypeEnum type)
	{
		switch (type)
		{
			case ACCOUNTS:
				return BulkUploadConfirmationAccountsServiceDelegateImpl.getInstance();
			case BILLS:
				return BulkUploadConfirmationBillsServiceDelegateImpl.getInstance();
			case PAYMENTS:
				return BulkUploadConfirmationPaymentsServiceDelegateImpl.getInstance();
		}
		return null;
	}

	@Override
	public CacheServiceDelegate getCacheServiceDelegate()
	{
		return CacheServiceDelegateImpl.getInstance();
	}

	@Override
	public CorePaymentDelegate getCorePaymentDelegate()
	{
		return CorePaymentDelegateImpl.getInstance();
	}

	@Override
	public CustomerDelegate getCustomerDelegate()
	{
		return CustomerDelegateImpl.getInstance();
	}

	@Override
	public FileManagementServiceDelegate getFileManagementServiceDelegate()
	{
		return FileManagementServiceDelegateImpl.getInstance();
	}

	@Override
	public IbanManagementDelegate getIbanManagementDelegate()
	{
		return IbanManagementDelegateImpl.getInstance();
	}

	@Override
	public PartnerConfigurationServiceDelegate getPartnerConfigurationServiceDelegate()
	{
		return PartnerConfigurationServiceDelegateImpl.getInstance();
	}
	
	@Override
	public PartnerManagementDelegate getPartnerManagementDelegate()
	{
		return PartnerManagementDelegateImpl.getInstance();
	}
	@Override
	public PartnerProfileServiceDelegate getPartnerProfileServiceDelegate()
	{
		return PartnerProfileServiceDelegateImpl.getInstance();
	}

	@Override
	public ReconciliationCutoffServiceDelegate getReconciliationCutoffServiceDelegate()
	{
		return ReconciliationCutoffServiceDelegateImpl.getInstance();
	}

	@Override
	public ReconciliationReportServiceDelegate getReconciliationReportServiceDelegate(ReconciliationReportServiceTypeEnum type)
	{
		switch (type)
		{
			case BANKS:
				return ReconciliationReportBankServiceDelegateImpl.getInstance();
			case BILLERS:
				return ReconciliationReportBillerServiceDelegateImpl.getInstance();
		}
		return null;
	}

	@Override
	public ReferenceDataServiceDelegate getReferenceDataServiceDelegate()
	{
		return ReferenceDataServiceDelegateImpl.getInstance();
	}

	@Override
	public RefundManagementDelegate getRefundManagementDelegate()
	{
		return RefundManagementDelegateImpl.getInstance();
	}

	@Override
	public RefundSearchDelegate getRefundSearchDelegate()
	{
		return RefundSearchDelegateImpl.getInstance();
	}

	@Override
	public SettlementInstructuionsReportServiceDelegate getSettlementInstructuionsReportServiceDelegate()
	{
		return SettlementInstructuionsReportServiceDelegateImpl.getInstance();
	}

	@Override
	public TestConnectivityDelegate getTestConnectivityDelegate()
	{
		return TestConnectivityDelegateImpl.getInstance();
	}
}