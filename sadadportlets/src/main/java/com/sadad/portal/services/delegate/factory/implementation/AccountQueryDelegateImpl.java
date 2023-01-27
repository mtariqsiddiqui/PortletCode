/**
 * 
 */
package com.sadad.portal.services.delegate.factory.implementation;

import java.util.logging.Level;

import com.sadad.ebpp.wsdl.accountquery._1.AccountQueryFault;
import com.sadad.ebpp.wsdl.accountquery._1.AccountQueryPort;
import com.sadad.portal.services.client.proxy.AccountQueryPortProxy;
import com.sadad.schema.service.accountquery._1.GetByKeyRqType;
import com.sadad.schema.service.accountquery._1.GetByKeyRsType;
import com.sadad.schema.service.accountquery._1.ListByCustomerRqType;
import com.sadad.schema.service.accountquery._1.ListByCustomerRsType;
import com.sadad.schema.service.accountquery._1.ListByKeysRqType;
import com.sadad.schema.service.accountquery._1.ListByKeysRsType;

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
		proxy._getDescriptor().setEndpoint(SadadServicesEndPointUrls.ACCOUNT_SERVICE_ENDPOINT);
	}

	/**
	 * Returns the singleton instance of AccountQueryDelegateImpl
	 * 
	 * @return
	 */
	public static AccountQueryDelegateImpl getInstance()
	{
		if (instance == null)
		{
			instance = new AccountQueryDelegateImpl();
		}
		return instance;
	}

	@Override
	public GetByKeyRsType getByKey(GetByKeyRqType rq) throws AccountQueryFault
	{
		logger.log(Level.FINEST, SadadServicesEndPointUrls.ACCOUNT_SERVICE_ENDPOINT);
		if(logger.isLoggable(Level.FINEST))
			logRequest("GetByKeyRq", GetByKeyRqType.class, rq);
			
		GetByKeyRsType rs = service.getByKey(rq);
			
		if(logger.isLoggable(Level.FINEST)) 
			logResponse("GetByKeyRs", GetByKeyRsType.class, rs);
		
		return rs;
	}

	@Override
	public ListByKeysRsType listByKeys(ListByKeysRqType rq) throws AccountQueryFault
	{
		logger.log(Level.FINEST, SadadServicesEndPointUrls.ACCOUNT_SERVICE_ENDPOINT);
		if(logger.isLoggable(Level.FINEST))
			logRequest("ListByKeysRq", ListByKeysRqType.class, rq);
			
		ListByKeysRsType rs = service.listByKeys(rq);
			
		if(logger.isLoggable(Level.FINEST)) 
			logResponse("ListByKeysRs", ListByKeysRsType.class, rs);
		
		return rs;
	}

	@Override
	public ListByCustomerRsType listByCustomer(ListByCustomerRqType rq) throws AccountQueryFault
	{
		logger.log(Level.FINEST, SadadServicesEndPointUrls.ACCOUNT_SERVICE_ENDPOINT);
		if(logger.isLoggable(Level.FINEST))
			logRequest("ListByCustomerRq", ListByCustomerRqType.class, rq);
			
		ListByCustomerRsType rs = service.listByCustomer(rq);
			
		if(logger.isLoggable(Level.FINEST)) 
			logResponse("ListByCustomerRs", ListByCustomerRsType.class, rs);
		
		return rs;
	}
}