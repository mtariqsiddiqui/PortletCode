package com.sadad.ebpp.portal.delegate.factory.clients;

import com.sadad.schema.service.refundsearch._1.GetRefundRqType;
import com.sadad.schema.service.refundsearch._1.GetRefundRsType;
import com.sadad.schema.service.refundsearch._1.ListRefundRqType;
import com.sadad.schema.service.refundsearch._1.ListRefundRsType;
import com.sadad.wsdl.refundsearch._1.RefundFault;
import com.sadad.wsdl.refundsearch._1.RefundSearchPort;
import com.sadad.wsdl.refundsearch._1.RefundSearchPortProxy;

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
		proxy._getDescriptor().setEndpoint(getEndPointUrl());
	}

	/**
	 * This method will return the endpoint URL after fetching it from WSRR
	 * 
	 * @return endPointUrl
	 */
	private String getEndPointUrl()
	{
		// TODO - Get the URL from WSRR
		return "http://localhost:8089/mockRefundSearchBinding";
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
	public GetRefundRsType getRefund(GetRefundRqType getRefundRq) throws RefundFault
	{
		GetRefundRsType getRefundRs = service.getRefund(getRefundRq);
		return getRefundRs;
	}

	@Override
	public ListRefundRsType listRefund(ListRefundRqType listRefundRq) throws RefundFault
	{
		ListRefundRsType listRefundRs = service.listRefund(listRefundRq);
		return listRefundRs;
	}
}
