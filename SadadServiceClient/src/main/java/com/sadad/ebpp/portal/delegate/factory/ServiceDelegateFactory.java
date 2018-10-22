package com.sadad.ebpp.portal.delegate.factory;

import com.sadad.ebpp.portal.delegate.factory.clients.AccountQueryDelegate;
import com.sadad.ebpp.portal.delegate.factory.clients.BillSearchDelegate;
import com.sadad.ebpp.portal.delegate.factory.clients.CorePaymentDelegate;
import com.sadad.ebpp.portal.delegate.factory.clients.CustomerDelegate;
import com.sadad.ebpp.portal.delegate.factory.clients.PartnerProfileServiceDelegate;
import com.sadad.ebpp.portal.delegate.factory.clients.ReferenceDataServiceDelegate;
import com.sadad.ebpp.portal.delegate.factory.clients.RefundSearchDelegate;

/**
 * @author Tariq Siddiqui
 * 
 */
public abstract class ServiceDelegateFactory
{
	/** Singleton instance. */
	private static ServiceDelegateFactory instance;

	/** Default Constructor. */
	protected ServiceDelegateFactory()
	{}

	/**
	 * This method get the configuration object from the ConfigurationCache class. 
	 * This method returns the singleton instance of the target Delegate factory implementation using the configuration object which takes the CONFIGURATION_KEY as
	 * input. The Delegate factory implementation will be determined at runtime based on a configuration property file having the CONFIGURATION_KEY.
	 * 
	 * @return ServiceDelegateFactory the singleton instance of the factory.
	 */
	public static ServiceDelegateFactory getInstance()
	{
		// Determine the factory implementation and return it.
		if (instance == null)
		{
			try
			{
				instance = (ServiceDelegateFactory) Class.forName(ServiceDelegateFactoryImpl.class.getName()).newInstance();
			}
			catch (IllegalAccessException e)
			{
				throw new RuntimeException("IllegalAccessException", e);
			}
			catch (InstantiationException e)
			{
				throw new RuntimeException("InstantiationException", e);
			}
			catch (ClassNotFoundException classNotFoundException)
			{
				throw new RuntimeException("ClassNotFoundException", classNotFoundException);
			}
		}
		return instance;
	}

	/**
	 * This method abstracts the type of Delegate to be instantiated.The implementation should be provided by the subclass.
	 * 
	 */

	public abstract PartnerProfileServiceDelegate getPartnerProfileServiceDelegate();
	
	public abstract AccountQueryDelegate getAccountQueryDelegate();
	
	public abstract BillSearchDelegate getBillSearchDelegate();
	
	public abstract CustomerDelegate getCustomerDelegate();
	
	public abstract CorePaymentDelegate getCorePaymentDelegate(); 
	
	public abstract ReferenceDataServiceDelegate getReferenceDataServiceDelegate();
	
	public abstract RefundSearchDelegate getRefundSearchDelegate();
}
