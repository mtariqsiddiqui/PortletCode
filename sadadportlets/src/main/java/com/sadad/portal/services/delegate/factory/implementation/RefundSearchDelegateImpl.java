package com.sadad.portal.services.delegate.factory.implementation;

import java.util.logging.Level;

import com.sadad.portal.services.client.proxy.RefundSearchPortProxy;
import com.sadad.schema.service.refundsearch._1.GetRefundRqType;
import com.sadad.schema.service.refundsearch._1.GetRefundRsType;
import com.sadad.schema.service.refundsearch._1.ListRefundRqType;
import com.sadad.schema.service.refundsearch._1.ListRefundRqTypePortal;
import com.sadad.schema.service.refundsearch._1.ListRefundRsType;
import com.sadad.schema.service.refundsearch._1.ListRefundRsTypePortal;
import com.sadad.ebpp.wsdl.refundsearch._1.RefundFault;
import com.sadad.ebpp.wsdl.refundsearch._1.RefundSearchPort;

/**
 * 
 * @author Tariq Siddiqui
 * 
 */

public class RefundSearchDelegateImpl implements RefundSearchDelegate
{
	private static RefundSearchDelegateImpl instance;
	private RefundSearchPortProxy proxy;
	private RefundSearchPort service;

	private RefundSearchDelegateImpl()
	{
		proxy = new RefundSearchPortProxy();
		service = proxy._getDescriptor().getProxy();
		proxy._getDescriptor().setEndpoint(SadadServicesEndPointUrls.REFUND_SERVICE_ENDPOINT);
	}

	/**
	 * Returns the singleton instance of RefundSearchDelegateImpl
	 * 
	 * @return
	 */
	public static RefundSearchDelegateImpl getInstance()
	{
		if (instance == null)
		{
			instance = new RefundSearchDelegateImpl();
		}
		return instance;
	}

	@Override
	public GetRefundRsType getRefund(GetRefundRqType rq) throws RefundFault
	{
		logger.log(Level.FINEST, SadadServicesEndPointUrls.REFUND_SERVICE_ENDPOINT);
		if(logger.isLoggable(Level.FINEST))
			logRequest("GetRefundRq", GetRefundRqType.class, rq);

		GetRefundRsType rs = service.getRefund(rq);

		if(logger.isLoggable(Level.FINEST)) 
			logResponse("GetRefundRs", GetRefundRsType.class, rs);

		return rs;
	}

	@Override
	public ListRefundRsType listRefund(ListRefundRqType rq) throws RefundFault
	{
		logger.log(Level.FINEST, SadadServicesEndPointUrls.REFUND_SERVICE_ENDPOINT);
		if(logger.isLoggable(Level.FINEST))
			logRequest("ListRefundRq", ListRefundRqType.class, rq);

		ListRefundRsType rs = service.listRefund(rq);

		if(logger.isLoggable(Level.FINEST)) 
			logResponse("ListRefundRs", ListRefundRsType.class, rs);

		return rs;
	}

	@Override
	public ListRefundRsTypePortal listRefundPortal(ListRefundRqTypePortal rq) throws RefundFault
	{
		logger.log(Level.FINEST, SadadServicesEndPointUrls.REFUND_SERVICE_ENDPOINT);
		if (logger.isLoggable(Level.FINEST))
			logRequest("ListRefundRqPortal", ListRefundRqTypePortal.class, rq);
		
		ListRefundRsTypePortal rs = service.listRefundPortal(rq);
		
		if (logger.isLoggable(Level.FINEST))
			logResponse("ListRefundRsPortal", ListRefundRsTypePortal.class, rs);
		
		return rs;
	}
}