/**
 * 
 */
package com.sadad.portal.services.delegate.factory.implementation;

import java.util.logging.Level;

import com.sadad.ebpp.scm.schema.billsearch._1.GetByBillNumberRqType;
import com.sadad.ebpp.scm.schema.billsearch._1.GetByBillNumberRsType;
import com.sadad.ebpp.scm.schema.billsearch._1.ListByAccountRqType;
import com.sadad.ebpp.scm.schema.billsearch._1.ListByAccountRsType;
import com.sadad.ebpp.scm.schema.billsearch._1.ListByCustomerRqType;
import com.sadad.ebpp.scm.schema.billsearch._1.ListByCustomerRsType;
import com.sadad.ebpp.scm.schema.billsearch._1.ListByPaymentRqType;
import com.sadad.ebpp.scm.schema.billsearch._1.ListByPaymentRsType;
import com.sadad.ebpp.wsdl.billsearch._1.BillSearchFault;
import com.sadad.ebpp.wsdl.billsearch._1.BillSearchPort;
import com.sadad.portal.services.client.proxy.BillSearchPortProxy;

/**
 * @author Tariq Siddiqui
 * 
 */
public class BillSearchDelegateImpl implements BillSearchDelegate
{
	private static BillSearchDelegateImpl instance;
	private BillSearchPortProxy proxy;
	private BillSearchPort service;

	private BillSearchDelegateImpl()
	{
		proxy = new BillSearchPortProxy();
		service = proxy._getDescriptor().getProxy();
		proxy._getDescriptor().setEndpoint(SadadServicesEndPointUrls.BILL_SERVICE_ENDPOINT);
	}

	/**
	 * Returns the singleton instance of BillSearchDelegateImpl
	 * 
	 * @return
	 */
	public static BillSearchDelegateImpl getInstance()
	{
		if (instance == null)
		{
			instance = new BillSearchDelegateImpl();
		}
		return instance;
	}

	@Override
	public GetByBillNumberRsType getByBillNumber(GetByBillNumberRqType rq) throws BillSearchFault
	{
		logger.log(Level.FINEST, SadadServicesEndPointUrls.BILL_SERVICE_ENDPOINT);
		if(logger.isLoggable(Level.FINEST))
			logRequest("GetByBillNumberRq", GetByBillNumberRqType.class, rq);
			
		GetByBillNumberRsType rs = service.getByBillNumber(rq);

		if(logger.isLoggable(Level.FINEST)) 
			logResponse("GetByBillNumberRs", GetByBillNumberRsType.class, rs);

		return rs;
	}

	@Override
	public ListByAccountRsType listByAccount(ListByAccountRqType rq) throws BillSearchFault
	{
		logger.log(Level.FINEST, SadadServicesEndPointUrls.BILL_SERVICE_ENDPOINT);
		if(logger.isLoggable(Level.FINEST))
			logRequest("ListByAccountRq", ListByAccountRqType.class, rq);
			
		ListByAccountRsType rs = service.listByAccount(rq);
		
		if(logger.isLoggable(Level.FINEST)) 
			logResponse("ListByAccountRs", ListByAccountRsType.class, rs);
		
		return rs;
	}

	@Override
	public ListByCustomerRsType listByCustomer(ListByCustomerRqType rq) throws BillSearchFault
	{
		logger.log(Level.FINEST, SadadServicesEndPointUrls.BILL_SERVICE_ENDPOINT);
		if(logger.isLoggable(Level.FINEST))
			logRequest("ListByCustomerRq", ListByCustomerRqType.class, rq);
			

		ListByCustomerRsType rs = service.listByCustomer(rq);
			
		if(logger.isLoggable(Level.FINEST)) 
			logResponse("ListByCustomerRs", ListByCustomerRsType.class, rs);
		
		return rs;
	}

	@Override
	public ListByPaymentRsType listByPayment(ListByPaymentRqType rq) throws BillSearchFault
	{
		logger.log(Level.FINEST, SadadServicesEndPointUrls.BILL_SERVICE_ENDPOINT);
		if(logger.isLoggable(Level.FINEST))
			logRequest("ListByPaymentRq", ListByPaymentRqType.class, rq);
			

		ListByPaymentRsType rs = service.listByPayment(rq);
			
		if(logger.isLoggable(Level.FINEST)) 
			logResponse("ListByPaymentRs", ListByPaymentRsType.class, rs);
		
		return rs;
	}
}