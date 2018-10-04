package com.sadad.ebpp.portal.delegate.factory;

import com.sadad.ebpp.portal.delegate.factory.clients.AccountQueryDelegate;
import com.sadad.ebpp.portal.delegate.factory.clients.AccountQueryDelegateImpl;
import com.sadad.ebpp.portal.delegate.factory.clients.BillSearchDelegate;
import com.sadad.ebpp.portal.delegate.factory.clients.BillSearchDelegateImpl;
import com.sadad.ebpp.portal.delegate.factory.clients.CorePaymentDelegate;
import com.sadad.ebpp.portal.delegate.factory.clients.CorePaymentDelegateImpl;
import com.sadad.ebpp.portal.delegate.factory.clients.CustomerDelegate;
import com.sadad.ebpp.portal.delegate.factory.clients.CustomerDelegateImpl;
import com.sadad.ebpp.portal.delegate.factory.clients.PartnerProfileServiceDelegate;
import com.sadad.ebpp.portal.delegate.factory.clients.PartnerProfileServiceDelegateImpl;
import com.sadad.ebpp.portal.delegate.factory.clients.ReferenceDataServiceDelegate;
import com.sadad.ebpp.portal.delegate.factory.clients.ReferenceDataServiceDelegateImpl;

/**
 * @author Tariq Siddiqui
 * 
 */
public class ServiceDelegateFactoryImpl extends ServiceDelegateFactory
{
	@Override
	public PartnerProfileServiceDelegate getPartnerProfileServiceDelegate()
	{
		return PartnerProfileServiceDelegateImpl.getInstance();
	}

	@Override
	public AccountQueryDelegate getAccountQueryDelegate()
	{
		return AccountQueryDelegateImpl.getInstance();
	}

	@Override
	public BillSearchDelegate getBillSearchDelegate()
	{
		return BillSearchDelegateImpl.getInstance();
	}

	@Override
	public CustomerDelegate getCustomerDelegate()
	{
		return CustomerDelegateImpl.getInstance();
	}

	@Override
	public CorePaymentDelegate getCorePaymentDelegate()
	{
		return CorePaymentDelegateImpl.getInstance();
	}

	@Override
	public ReferenceDataServiceDelegate getReferenceDataServiceDelegate()
	{
		return ReferenceDataServiceDelegateImpl.getInstance();
	}
}