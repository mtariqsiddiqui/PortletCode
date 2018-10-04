package com.sadad.ebpp.portal.delegate.factory.clients;

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
import com.sadad.ebpp.wsdl.customer._1.CustomerBindingProxy;
import com.sadad.ebpp.wsdl.customer._1.CustomerFault;
import com.sadad.ebpp.wsdl.customer._1.CustomerPort;

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
	public static CustomerDelegateImpl getInstance()
	{
		if(instance == null)
		{
			instance = new CustomerDelegateImpl();
		}
		return instance;
	}
	
	@Override
	public CustProfileAssnRsType customerAssociation(CustProfileAssnRqType custProfileAssnReq) throws CustomerFault
	{
		CustProfileAssnRsType custProfileAssnRes = service.customerAssociation(custProfileAssnReq);
		return custProfileAssnRes;
	}

	@Override
	public CustProfileDisassnRsType customerDisassociation(CustProfileDisassnRqType customerDisassociationReq) throws CustomerFault
	{
		CustProfileDisassnRsType custProfileDisassnRes = service.customerDisassociation(customerDisassociationReq);
		return custProfileDisassnRes;
	}

	@Override
	public CustProfileInqRsType customerInquiry(CustProfileInqRqType customerInquiryReq) throws CustomerFault
	{
		CustProfileInqRsType custProfileInqRes = service.customerInquiry(customerInquiryReq);
		return custProfileInqRes;
	}

	@Override
	public ActivateRsType activate(ActivateRqType activateReq) throws CustomerFault
	{
		ActivateRsType activateRes = service.activate(activateReq);
		return activateRes;
	}

	@Override
	public DeactivateRsType deactivate(DeactivateRqType deactivateReq) throws CustomerFault
	{
		DeactivateRsType deactivateRes = service.deactivate(deactivateReq);
		return deactivateRes;
	}

	@Override
	public GetByKeyRsType getByKey(GetByKeyRqType getByKeyReq) throws CustomerFault
	{
		GetByKeyRsType getByKeyRes = service.getByKey(getByKeyReq);
		return getByKeyRes;
	}

	@Override
	public ListByAccountRsType listByAccount(ListByAccountRqType listByAccountReq) throws CustomerFault
	{
		ListByAccountRsType listByAccountRes = service.listByAccount(listByAccountReq);
		return listByAccountRes;
	}

	@Override
	public ListByBillRsType listByBill(ListByBillRqType listByBillReq) throws CustomerFault
	{
		ListByBillRsType listByBillRes = service.listByBill(listByBillReq);
		return listByBillRes;
	}
}