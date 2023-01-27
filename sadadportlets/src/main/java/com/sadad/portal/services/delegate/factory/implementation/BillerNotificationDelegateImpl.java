/**
 * 
 */
package com.sadad.portal.services.delegate.factory.implementation;

import java.util.logging.Level;

import com.sadad.ebpp.scm.schema.billernotification._1.NotifyPaymentBulkRqType;
import com.sadad.ebpp.scm.schema.billernotification._1.NotifyPaymentBulkRsType;
import com.sadad.ebpp.scm.schema.billernotification._1.NotifyRefundRqType;
import com.sadad.ebpp.scm.schema.billernotification._1.NotifyRefundRsType;
import com.sadad.ebpp.wsdl.billernotification._1.BillerNotificationPort;
import com.sadad.ebpp.wsdl.billernotification._1.NotifyPaymentBulkFault;
import com.sadad.ebpp.wsdl.billernotification._1.NotifyRefundFault;
import com.sadad.portal.services.client.proxy.BillerNotificationBindingProxy;

/**
 * @author Tariq Siddiqui
 *
 */
public class BillerNotificationDelegateImpl implements BillerNotificationDelegate
{
	private static BillerNotificationDelegateImpl instance;
	private BillerNotificationBindingProxy proxy;
	private BillerNotificationPort service;

	private BillerNotificationDelegateImpl()
	{
		proxy = new BillerNotificationBindingProxy();
		service = proxy._getDescriptor().getProxy();
		proxy._getDescriptor().setEndpoint(SadadServicesEndPointUrls.BILLER_NOTIFICATION_SERVICE);
	}

	/**
	 * Returns the singleton instance of BillerNotificationDelegateImpl
	 * 
	 * @return
	 */
	public static BillerNotificationDelegateImpl getInstance()
	{
		if (instance == null)
		{
			instance = new BillerNotificationDelegateImpl();
		}
		return instance;
	}

	@Override
	public NotifyPaymentBulkRsType notifyPaymentBulk(NotifyPaymentBulkRqType req) throws NotifyPaymentBulkFault
	{
		logger.log(Level.FINEST, SadadServicesEndPointUrls.BILLER_NOTIFICATION_SERVICE);
		if (logger.isLoggable(Level.FINEST))
			logRequest("NotifyPaymentBulkRq", NotifyPaymentBulkRqType.class, req);

		NotifyPaymentBulkRsType res = service.notifyPaymentBulk(req);

		if (logger.isLoggable(Level.FINEST))
			logResponse("NotifyPaymentBulkRs", NotifyPaymentBulkRsType.class, res);

		return res;
	}

	@Override
	public NotifyRefundRsType notifyRefund(NotifyRefundRqType req) throws NotifyRefundFault
	{
		logger.log(Level.FINEST, SadadServicesEndPointUrls.BILLER_NOTIFICATION_SERVICE);
		if (logger.isLoggable(Level.FINEST))
			logRequest("NotifyRefundRq", NotifyRefundRqType.class, req);

		NotifyRefundRsType res = service.notifyRefund(req);

		if (logger.isLoggable(Level.FINEST))
			logResponse("NotifyRefundRs", NotifyRefundRsType.class, res); 

		return res;
	}
}