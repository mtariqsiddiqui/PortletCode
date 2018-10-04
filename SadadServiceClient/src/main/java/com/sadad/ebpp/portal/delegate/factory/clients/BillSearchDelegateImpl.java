/**
 * 
 */
package com.sadad.ebpp.portal.delegate.factory.clients;

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
import com.sadad.ebpp.wsdl.billsearch._1.BillSearchPortProxy;

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
		proxy._getDescriptor().setEndpoint(getEndPointUrl());
	}
	
	/**
	 * This method will return the endpoint URL after fetching it from WSRR
	 * @return endPointUrl
	 */
	private String getEndPointUrl()
	{
		// TODO - Get the URL from WSRR
		return "http://localhost:8089/mockBillSearchBinding";
	}

	/**
	 * Returns the singleton instance of BillSearchDelegateImpl
	 * @return
	 */
	public static BillSearchDelegateImpl getInstance()
	{
		if(instance == null)
		{
			instance = new BillSearchDelegateImpl();
		}
		return instance;
	}

	@Override
	public GetByBillNumberRsType getByBillNumber(GetByBillNumberRqType getBillReq) throws BillSearchFault
	{
		GetByBillNumberRsType getByBillNumberRes = service.getByBillNumber(getBillReq);
		return getByBillNumberRes;
	}

	@Override
	public ListByAccountRsType listByAccount(ListByAccountRqType listByAccountReq) throws BillSearchFault
	{
		ListByAccountRsType listByAccountRes = service.listByAccount(listByAccountReq);
		return listByAccountRes;
	}

	@Override
	public ListByCustomerRsType listByCustomer(ListByCustomerRqType listByCustomerReq) throws BillSearchFault
	{
		ListByCustomerRsType listByCustomerRes = service.listByCustomer(listByCustomerReq);
		return listByCustomerRes;
	}

	@Override
	public ListByPaymentRsType listByPayment(ListByPaymentRqType listByPaymentReq) throws BillSearchFault
	{
		ListByPaymentRsType listByPaymentRes = service.listByPayment(listByPaymentReq);
		return listByPaymentRes;
	}
}
