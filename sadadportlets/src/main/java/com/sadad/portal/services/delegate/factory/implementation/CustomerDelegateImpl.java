package com.sadad.portal.services.delegate.factory.implementation;

import java.util.logging.Level;

import com.sadad.ebpp.scm.schema.customer._1.ActivateRqType;
import com.sadad.ebpp.scm.schema.customer._1.ActivateRsType;
import com.sadad.ebpp.scm.schema.customer._1.CustProfileAssnRqType;
import com.sadad.ebpp.scm.schema.customer._1.CustProfileAssnRsType;
import com.sadad.ebpp.scm.schema.customer._1.CustProfileDisassnRqType;
import com.sadad.ebpp.scm.schema.customer._1.CustProfileDisassnRsType;
import com.sadad.ebpp.scm.schema.customer._1.CustProfileInqRqType;
import com.sadad.ebpp.scm.schema.customer._1.CustProfileInqRsType;
import com.sadad.ebpp.scm.schema.customer._1.DeactivateRqType;
import com.sadad.ebpp.scm.schema.customer._1.DeactivateRsType;
import com.sadad.ebpp.scm.schema.customer._1.GetByKeyRqType;
import com.sadad.ebpp.scm.schema.customer._1.GetByKeyRsType;
import com.sadad.ebpp.scm.schema.customer._1.ListByAccountRqType;
import com.sadad.ebpp.scm.schema.customer._1.ListByAccountRsType;
import com.sadad.ebpp.scm.schema.customer._1.ListByBillRqType;
import com.sadad.ebpp.scm.schema.customer._1.ListByBillRsType;
import com.sadad.ebpp.wsdl.customer._1.CustomerFault;
import com.sadad.ebpp.wsdl.customer._1.CustomerPort;
import com.sadad.portal.services.client.proxy.CustomerBindingProxy;

/**
 * @author Tariq Siddiqui
 * 
 */
public class CustomerDelegateImpl implements CustomerDelegate
{
	private static CustomerDelegateImpl instance;
	private CustomerBindingProxy proxy;
	private CustomerPort service;

	private CustomerDelegateImpl()
	{
		proxy = new CustomerBindingProxy();
		service = proxy._getDescriptor().getProxy();
		proxy._getDescriptor().setEndpoint(SadadServicesEndPointUrls.CUSTOMER_SERVICE_ENDPOINT);
	}

	/**
	 * Returns the singleton instance of CustomerDelegateImpl
	 * 
	 * @return
	 */
	public static CustomerDelegateImpl getInstance()
	{
		if (instance == null)
		{
			instance = new CustomerDelegateImpl();
		}
		return instance;
	}

	@Override
	public CustProfileAssnRsType customerAssociation(CustProfileAssnRqType rq) throws CustomerFault
	{
		logger.log(Level.FINEST, SadadServicesEndPointUrls.CUSTOMER_SERVICE_ENDPOINT);
		if(logger.isLoggable(Level.FINEST))
			logRequest("CustProfileAssnRq", CustProfileAssnRqType.class, rq);
		
		CustProfileAssnRsType rs = service.customerAssociation(rq);
		
		if(logger.isLoggable(Level.FINEST)) 
			logResponse("CustProfileAssnRs", CustProfileAssnRsType.class, rs);
		
		return rs;
	}

	@Override
	public CustProfileDisassnRsType customerDisassociation(CustProfileDisassnRqType rq) throws CustomerFault
	{
		logger.log(Level.FINEST, SadadServicesEndPointUrls.CUSTOMER_SERVICE_ENDPOINT);
		if(logger.isLoggable(Level.FINEST))
			logRequest("CustProfileDisassnRq", CustProfileDisassnRqType.class, rq);
		
		CustProfileDisassnRsType rs = service.customerDisassociation(rq);
		
		if(logger.isLoggable(Level.FINEST)) 
			logResponse("CustProfileDisassnRs", CustProfileDisassnRsType.class, rs);
		
		return rs;
	}

	@Override
	public CustProfileInqRsType customerInquiry(CustProfileInqRqType rq) throws CustomerFault
	{
		logger.log(Level.FINEST, SadadServicesEndPointUrls.CUSTOMER_SERVICE_ENDPOINT);
		if(logger.isLoggable(Level.FINEST))
			logRequest("CustProfileInqRq", CustProfileInqRqType.class, rq);
		
		CustProfileInqRsType rs = service.customerInquiry(rq);
		
		if(logger.isLoggable(Level.FINEST)) 
			logResponse("CustProfileInqRs", CustProfileInqRsType.class, rs);

		return rs;
	}

	@Override
	public ActivateRsType activate(ActivateRqType rq) throws CustomerFault
	{
		logger.log(Level.FINEST, SadadServicesEndPointUrls.CUSTOMER_SERVICE_ENDPOINT);
		if(logger.isLoggable(Level.FINEST))
			logRequest("ActivateRq", ActivateRqType.class, rq);
			
		ActivateRsType rs = service.activate(rq);
	
		if(logger.isLoggable(Level.FINEST)) 
			logResponse("ActivateRs", ActivateRsType.class, rs);

		return rs;
	}

	@Override
	public DeactivateRsType deactivate(DeactivateRqType rq) throws CustomerFault
	{
		logger.log(Level.FINEST, SadadServicesEndPointUrls.CUSTOMER_SERVICE_ENDPOINT);
		if(logger.isLoggable(Level.FINEST))
			logRequest("DeactivateRq", DeactivateRqType.class, rq);
			
		DeactivateRsType rs = service.deactivate(rq);
			
		if(logger.isLoggable(Level.FINEST)) 
			logResponse("DeactivateRs", DeactivateRsType.class, rs);

		return rs;
	}

	@Override
	public GetByKeyRsType getByKey(GetByKeyRqType rq) throws CustomerFault
	{
		logger.log(Level.FINEST, SadadServicesEndPointUrls.CUSTOMER_SERVICE_ENDPOINT);
		if (logger.isLoggable(Level.FINEST))
			logRequest("GetByKeyRq", GetByKeyRqType.class, rq);
		
		GetByKeyRsType rs = service.getByKey(rq);
		
		if (logger.isLoggable(Level.FINEST))
			logResponse("GetByKeyRs", GetByKeyRsType.class, rs);
		
		return rs;
	}

	@Override
	public ListByAccountRsType listByAccount(ListByAccountRqType rq) throws CustomerFault
	{
		logger.log(Level.FINEST, SadadServicesEndPointUrls.CUSTOMER_SERVICE_ENDPOINT);
		if(logger.isLoggable(Level.FINEST))
			logRequest("ListByAccountRq", ListByAccountRqType.class, rq);
			
		ListByAccountRsType rs = service.listByAccount(rq);
			
		if(logger.isLoggable(Level.FINEST)) 
			logResponse("ListByAccountRs", ListByAccountRsType.class, rs);

		return rs;
	}

	@Override
	public ListByBillRsType listByBill(ListByBillRqType rq) throws CustomerFault
	{
		logger.log(Level.FINEST, SadadServicesEndPointUrls.CUSTOMER_SERVICE_ENDPOINT);
		if(logger.isLoggable(Level.FINEST))
			logRequest("ListByBillRq", ListByBillRqType.class, rq);
			
		ListByBillRsType rs = service.listByBill(rq);
			
		if(logger.isLoggable(Level.FINEST)) 
			logResponse("ListByBillRs", ListByBillRsType.class, rs);

		return rs;
	}
}