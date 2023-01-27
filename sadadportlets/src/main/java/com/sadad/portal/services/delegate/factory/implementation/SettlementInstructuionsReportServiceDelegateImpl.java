package com.sadad.portal.services.delegate.factory.implementation;

import java.util.logging.Level;

import com.sadad.ebpp.scm.schema.settlement.settlementinstructuionsreportservice._1.SettlementInstructuionsReportRqType;
import com.sadad.ebpp.scm.schema.settlement.settlementinstructuionsreportservice._1.SettlementInstructuionsReportRsType;
import com.sadad.ebpp.wsdl.settlement.settlementinstructuionsreportservice._1.SettlementInstructuionsReportFault;
import com.sadad.ebpp.wsdl.settlement.settlementinstructuionsreportservice._1.SettlementInstructuionsReportService;
import com.sadad.portal.services.client.proxy.SettlementInstructuionsReportServicePortProxy;

public class SettlementInstructuionsReportServiceDelegateImpl implements SettlementInstructuionsReportServiceDelegate
{
	private static SettlementInstructuionsReportServiceDelegateImpl instance;
	private SettlementInstructuionsReportServicePortProxy proxy;
	private SettlementInstructuionsReportService service;

	private SettlementInstructuionsReportServiceDelegateImpl()
	{
		proxy = new SettlementInstructuionsReportServicePortProxy();
		service = proxy._getDescriptor().getProxy();
		proxy._getDescriptor().setEndpoint(SadadServicesEndPointUrls.SETTLEMENT_INSTRUCTUIONS_REPORT_SERVICE_ENDPOINT);
	}

	/**
	 * Returns the singleton instance of SettlementInstructuionsReportServiceDelegateImpl
	 * 
	 * @return
	 */
	public static SettlementInstructuionsReportServiceDelegateImpl getInstance()
	{
		if (instance == null)
		{
			instance = new SettlementInstructuionsReportServiceDelegateImpl();
		}
		return instance;
	}

	@Override
	public SettlementInstructuionsReportRsType generateSettlementInstructuionsReport(SettlementInstructuionsReportRqType req) throws SettlementInstructuionsReportFault
	{
		logger.log(Level.FINEST, SadadServicesEndPointUrls.SETTLEMENT_INSTRUCTUIONS_REPORT_SERVICE_ENDPOINT);
		if (logger.isLoggable(Level.FINEST))
			logRequest("SettlementInstructuionsReportRq", SettlementInstructuionsReportRqType.class, req);

		SettlementInstructuionsReportRsType res = service.generateSettlementInstructuionsReport(req);

		if (logger.isLoggable(Level.FINEST))
			logResponse("SettlementInstructuionsReportRs", SettlementInstructuionsReportRsType.class, res); 

		return res;
	}
}