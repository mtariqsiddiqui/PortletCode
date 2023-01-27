package com.sadad.portal.services.delegate.factory.implementation;

import java.util.logging.Level;

import com.sadad.ebpp.scm.schema.reconciliation.reconciliationcutoffservice._1.ReconciliationCutoffRqType;
import com.sadad.ebpp.scm.schema.reconciliation.reconciliationcutoffservice._1.ReconciliationCutoffRsType;
import com.sadad.ebpp.wsdl.reconciliation.reconciliationcutoffservice._1.ReconciliationCutoffService;
import com.sadad.ebpp.wsdl.reconciliation.reconciliationcutoffservice._1.ReconciliationReportFault;
import com.sadad.portal.services.client.proxy.ReconciliationCutoffServicePortProxy;

public class ReconciliationCutoffServiceDelegateImpl implements ReconciliationCutoffServiceDelegate
{
	private static ReconciliationCutoffServiceDelegateImpl instance;
	private ReconciliationCutoffServicePortProxy proxy;
	private ReconciliationCutoffService service;

	private ReconciliationCutoffServiceDelegateImpl()
	{
		proxy = new ReconciliationCutoffServicePortProxy();
		service = proxy._getDescriptor().getProxy();
		proxy._getDescriptor().setEndpoint(SadadServicesEndPointUrls.RECONCILIATION_CUTOFF_SERVICE_ENDPOINT);
	}

	/**
	 * Returns the singleton instance of ReconciliationCutoffServiceDelegateImpl
	 * 
	 * @return
	 */
	public static ReconciliationCutoffServiceDelegateImpl getInstance()
	{
		if (instance == null)
		{
			instance = new ReconciliationCutoffServiceDelegateImpl();
		}
		return instance;
	}

	@Override
	public ReconciliationCutoffRsType generateReconciliationReport(ReconciliationCutoffRqType req) throws ReconciliationReportFault
	{
		logger.log(Level.FINEST, SadadServicesEndPointUrls.RECONCILIATION_CUTOFF_SERVICE_ENDPOINT);
		if (logger.isLoggable(Level.FINEST))
			logRequest("ReconciliationCutoffRq", ReconciliationCutoffRqType.class, req);

		ReconciliationCutoffRsType res = service.generateReconciliationReport(req);

		if (logger.isLoggable(Level.FINEST))
			logResponse("ReconciliationCutoffRs", ReconciliationCutoffRsType.class, res); 

		return res;
	}
}