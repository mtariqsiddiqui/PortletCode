/**
 * 
 */
package com.sadad.ebpp.portal.delegate.factory.clients;

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
import com.sadad.wsdl.corepayment._1.CorePaymentPort;
import com.sadad.wsdl.corepayment._1.CorePaymentPortProxy;
import com.sadad.wsdl.corepayment._1.PaymentFault;

/**
 * @author Muhammad.Siddiqui
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
		proxy._getDescriptor().setEndpoint(getEndPointUrl());
	}
	
	/**
	 * This method will return the endpoint URL after fetching it from WSRR
	 * @return endPointUrl
	 */
	private String getEndPointUrl()
	{
		// TODO - Get the URL from WSRR
		return "http://localhost:8093/mockCustomerBinding";
	}

	/**
	 * Returns the singleton instance of BillSearchDelegateImpl
	 * @return
	 */
	public static CorePaymentDelegateImpl getInstance()
	{
		if(instance == null)
		{
			instance = new CorePaymentDelegateImpl();
		}
		return instance;
	}
	
	
	@Override
	public ListByIdRsType listById(ListByIdRqType listByIdRq) throws PaymentFault
	{
		ListByIdRsType listByIdRs = service.listById(listByIdRq);
		return listByIdRs;
	}

	@Override
	public ListByPayorRsType listByPayor(ListByPayorRqType listByPayorRq) throws PaymentFault
	{
		ListByPayorRsType listByPayorRs = service.listByPayor(listByPayorRq); 
		return listByPayorRs;
	}

	@Override
	public ListByAccountRsType listByAccount(ListByAccountRqType listByAccountRq) throws PaymentFault
	{
		ListByAccountRsType listByAccountRs = service.listByAccount(listByAccountRq);
		return listByAccountRs;
	}

	@Override
	public ListByBillIdRsType listByBillId(ListByBillIdRqType listByBillIdRq) throws PaymentFault
	{
		ListByBillIdRsType listByBillIdRs = service.listByBillId(listByBillIdRq);
		return listByBillIdRs;
	}

	@Override
	public ListByBeneficiaryRsType listByBeneficiary(ListByBeneficiaryRqType listByBeneficiaryRq) throws PaymentFault
	{
		ListByBeneficiaryRsType listByBeneficiaryRs = service.listByBeneficiary(listByBeneficiaryRq);
		return listByBeneficiaryRs;
	}
}
