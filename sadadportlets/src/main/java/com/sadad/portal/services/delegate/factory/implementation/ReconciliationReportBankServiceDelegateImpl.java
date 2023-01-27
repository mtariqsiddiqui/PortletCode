package com.sadad.portal.services.delegate.factory.implementation;

import java.util.logging.Level;

import com.sadad.ebpp.scm.schema.reconciliation.reconciliationreportcommon._1.ReconciliationReportRqType;
import com.sadad.ebpp.scm.schema.reconciliation.reconciliationreportcommon._1.ReconciliationReportRsType;
import com.sadad.ebpp.wsdl.reconciliation.reconciliationreportservice._1.ReconciliationReportFault;
import com.sadad.ebpp.wsdl.reconciliation.reconciliationreportservice._1.ReconciliationReportService;
import com.sadad.portal.services.client.proxy.ReconciliationReportServicePortProxy;

public class ReconciliationReportBankServiceDelegateImpl implements ReconciliationReportServiceDelegate
{
	private static ReconciliationReportBankServiceDelegateImpl instance;
	private ReconciliationReportServicePortProxy proxy;
	private ReconciliationReportService service;

	private ReconciliationReportBankServiceDelegateImpl()
	{
		proxy = new ReconciliationReportServicePortProxy();
		service = proxy._getDescriptor().getProxy();
		proxy._getDescriptor().setEndpoint(SadadServicesEndPointUrls.RECONCILIATION_REPORT_BANK_SERVICE_ENDPOINT);
	}

	/**
	 * Returns the singleton instance of ReconciliationReportBankServiceDelegateImpl
	 * 
	 * @return
	 */
	public static ReconciliationReportBankServiceDelegateImpl getInstance()
	{
		if (instance == null)
		{
			instance = new ReconciliationReportBankServiceDelegateImpl();
		}
		return instance;
	}

	@Override
	public ReconciliationReportRsType generateReconciliationReport(ReconciliationReportRqType req) throws ReconciliationReportFault
	{
		logger.log(Level.FINEST, SadadServicesEndPointUrls.RECONCILIATION_REPORT_BANK_SERVICE_ENDPOINT);
		if (logger.isLoggable(Level.FINEST))
			logRequest("ReconciliationReportRq", ReconciliationReportRqType.class, req);

		ReconciliationReportRsType res  = service.generateReconciliationReport(req);

		if (logger.isLoggable(Level.FINEST))
			logResponse("ReconciliationReportRs", ReconciliationReportRsType.class, res); 
		return res;
	}
}