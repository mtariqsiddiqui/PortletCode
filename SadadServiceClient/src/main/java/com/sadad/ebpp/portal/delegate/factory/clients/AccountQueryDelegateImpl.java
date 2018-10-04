/**
 * 
 */
package com.sadad.ebpp.portal.delegate.factory.clients;

import com.sadad.ebpp.wsdl.accountquery._1.AccountQueryFault;
import com.sadad.ebpp.wsdl.accountquery._1.AccountQueryPort;
import com.sadad.ebpp.wsdl.accountquery._1.AccountQueryPortProxy;
import com.sadad.schema.service.accountquery._1.GetByKeyRqType;
import com.sadad.schema.service.accountquery._1.GetByKeyRsType;
import com.sadad.schema.service.accountquery._1.ListByCustomerRqType;
import com.sadad.schema.service.accountquery._1.ListByCustomerRsType;

/**
 * @author Tariq Siddiqui
 * 
 */
public class AccountQueryDelegateImpl implements AccountQueryDelegate
{
	private static AccountQueryDelegateImpl instance;
	private AccountQueryPortProxy proxy;
	private AccountQueryPort service;
	
	private AccountQueryDelegateImpl()
	{
		proxy = new AccountQueryPortProxy();
		service = proxy._getDescriptor().getProxy();
		proxy._getDescriptor().setEndpoint(getEndPointUrl());
	}
	
	/**
	 * This method will return the endpoint URL after fetching it from WSRR
	 * @return endPointUrl
	 */
	private String getEndPointUrl()
	{
		// TODO - Get the URL from WSRR
		return "http://localhost:8091/mockAccountQueryBinding";
	}

	/**
	 * Returns the singleton instance of BillSearchDelegateImpl
	 * @return
	 */
	public static AccountQueryDelegateImpl getInstance()
	{
		if(instance == null)
		{
			instance = new AccountQueryDelegateImpl();
		}
		return instance;
	}
	
	@Override
	public GetByKeyRsType getByKey(GetByKeyRqType getByKeyRq) throws AccountQueryFault
	{
		GetByKeyRsType getByKeyRs = service.getByKey(getByKeyRq);
		return getByKeyRs;
	}

	@Override
	public ListByCustomerRsType listByCustomer(ListByCustomerRqType listByCustomerRq) throws AccountQueryFault
	{
		ListByCustomerRsType listByCustomerResponse = service.listByCustomer(listByCustomerRq); 
		return listByCustomerResponse;
	}
}