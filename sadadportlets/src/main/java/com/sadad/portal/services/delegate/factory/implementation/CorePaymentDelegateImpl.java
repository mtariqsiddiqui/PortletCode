/**
 * 
 */
package com.sadad.portal.services.delegate.factory.implementation;

import java.util.logging.Level;

import com.sadad.portal.services.client.proxy.CorePaymentPortProxy;
import com.sadad.schema.service.corepayment._1.CancelRqType;
import com.sadad.schema.service.corepayment._1.CancelRsType;
import com.sadad.schema.service.corepayment._1.ListByAccountRqType;
import com.sadad.schema.service.corepayment._1.ListByAccountRsType;
import com.sadad.schema.service.corepayment._1.ListByBeneficiaryRqType;
import com.sadad.schema.service.corepayment._1.ListByBeneficiaryRsType;
import com.sadad.schema.service.corepayment._1.ListByBillIdRqType;
import com.sadad.schema.service.corepayment._1.ListByBillIdRsType;
import com.sadad.schema.service.corepayment._1.ListByIdRqType;
import com.sadad.schema.service.corepayment._1.ListByIdRsType;
import com.sadad.schema.service.corepayment._1.ListByPayorRqType;
import com.sadad.schema.service.corepayment._1.ListByPayorRsType;
import com.sadad.schema.service.corepayment._1.ListSPLPaymentsRqType;
import com.sadad.schema.service.corepayment._1.ListSPLPaymentsRsType;
import com.sadad.schema.service.corepayment._1.UncancelRqType;
import com.sadad.schema.service.corepayment._1.UncancelRsType;
import com.sadad.wsdl.corepayment._1.CorePaymentPort;
import com.sadad.wsdl.corepayment._1.PaymentFault;

/**
 * @author Tariq Siddiqui
 * 
 */
public class CorePaymentDelegateImpl implements CorePaymentDelegate
{
	private static CorePaymentDelegateImpl instance;
	private CorePaymentPortProxy proxy;
	private CorePaymentPort service;

	private CorePaymentDelegateImpl()
	{
		proxy = new CorePaymentPortProxy();
		service = proxy._getDescriptor().getProxy();
		proxy._getDescriptor().setEndpoint(SadadServicesEndPointUrls.PAYMENT_SERVICE_ENDPOINT);
	}

	/**
	 * Returns the singleton instance of CorePaymentDelegateImpl
	 * 
	 * @return
	 */
	public static CorePaymentDelegateImpl getInstance()
	{
		if (instance == null)
		{
			instance = new CorePaymentDelegateImpl();
		}
		return instance;
	}

	@Override
	public ListByIdRsType listById(ListByIdRqType rq) throws PaymentFault
	{
		logger.log(Level.FINEST, SadadServicesEndPointUrls.PAYMENT_SERVICE_ENDPOINT);
		if(logger.isLoggable(Level.FINEST))
			logRequest("ListByIdRq", ListByIdRqType.class, rq);

		ListByIdRsType rs = service.listById(rq);

		if(logger.isLoggable(Level.FINEST)) 
			logResponse("ListByIdRs", ListByIdRsType.class, rs);

		return rs;
	}

	@Override
	public ListByPayorRsType listByPayor(ListByPayorRqType rq) throws PaymentFault
	{
		logger.log(Level.FINEST, SadadServicesEndPointUrls.PAYMENT_SERVICE_ENDPOINT);
		if(logger.isLoggable(Level.FINEST))
			logRequest("ListByPayorRq", ListByPayorRqType.class, rq);

		ListByPayorRsType rs = service.listByPayor(rq);

		if(logger.isLoggable(Level.FINEST)) 
			logResponse("ListByPayorRs", ListByPayorRsType.class, rs);
		
		return rs;
	}

	@Override
	public ListByAccountRsType listByAccount(ListByAccountRqType rq) throws PaymentFault
	{
		logger.log(Level.FINEST, SadadServicesEndPointUrls.PAYMENT_SERVICE_ENDPOINT);
		if(logger.isLoggable(Level.FINEST))
			logRequest("ListByAccountRq", ListByAccountRqType.class, rq);

		ListByAccountRsType rs = service.listByAccount(rq);
		
		if(logger.isLoggable(Level.FINEST)) 
			logResponse("ListByAccountRs", ListByAccountRsType.class, rs);

		return rs;
	}

	@Override
	public ListByBillIdRsType listByBillId(ListByBillIdRqType rq) throws PaymentFault
	{
		logger.log(Level.FINEST, SadadServicesEndPointUrls.PAYMENT_SERVICE_ENDPOINT);
		if(logger.isLoggable(Level.FINEST))
			logRequest("ListByBillIdRq", ListByBillIdRqType.class, rq);

		ListByBillIdRsType rs = service.listByBillId(rq);

		if(logger.isLoggable(Level.FINEST)) 
			logResponse("ListByBillIdRs", ListByBillIdRsType.class, rs);

		return rs;
	}

	@Override
	public ListByBeneficiaryRsType listByBeneficiary(ListByBeneficiaryRqType rq) throws PaymentFault
	{
		logger.log(Level.FINEST, SadadServicesEndPointUrls.PAYMENT_SERVICE_ENDPOINT);
		if(logger.isLoggable(Level.FINEST))
			logRequest("ListByBeneficiaryRq", ListByBeneficiaryRqType.class, rq);

		ListByBeneficiaryRsType rs = service.listByBeneficiary(rq);

		if(logger.isLoggable(Level.FINEST)) 
			logResponse("ListByBeneficiaryRs", ListByBeneficiaryRsType.class, rs);

		return rs;
	}

	@Override
	public ListSPLPaymentsRsType listSPLPayments(ListSPLPaymentsRqType rq) throws PaymentFault
	{
		logger.log(Level.FINEST, SadadServicesEndPointUrls.PAYMENT_SERVICE_ENDPOINT);
		if(logger.isLoggable(Level.FINEST))
			logRequest("ListSPLPaymentsRq", ListSPLPaymentsRqType.class, rq);

		ListSPLPaymentsRsType rs = service.listSPLPayments(rq);

		if(logger.isLoggable(Level.FINEST)) 
			logResponse("ListSPLPaymentsRs", ListSPLPaymentsRsType.class, rs);

		return rs;
	}

	@Override
	public CancelRsType cancel(CancelRqType rq) throws PaymentFault
	{
		logger.log(Level.FINEST, SadadServicesEndPointUrls.PAYMENT_SERVICE_ENDPOINT);
		if(logger.isLoggable(Level.FINEST))
			logRequest("CancelRq", CancelRqType.class, rq);

		CancelRsType rs = service.cancel(rq);

		if(logger.isLoggable(Level.FINEST)) 
			logResponse("CancelRs", CancelRsType.class, rs);

		return rs;
	}

	@Override
	public UncancelRsType uncancel(UncancelRqType rq) throws PaymentFault
	{
		logger.log(Level.FINEST, SadadServicesEndPointUrls.PAYMENT_SERVICE_ENDPOINT);
		if(logger.isLoggable(Level.FINEST))
			logRequest("UncancelRq", UncancelRqType.class, rq);

		UncancelRsType rs = service.uncancel(rq);

		if(logger.isLoggable(Level.FINEST)) 
			logResponse("UncancelRs", UncancelRsType.class, rs);
		
		return rs;
	}
}