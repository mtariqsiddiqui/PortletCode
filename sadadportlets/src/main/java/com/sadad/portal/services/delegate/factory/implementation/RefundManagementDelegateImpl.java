/**
 * 
 */
package com.sadad.portal.services.delegate.factory.implementation;

import java.util.logging.Level;

import com.sadad.ebpp.scm.schema.refundmanagement._1.UpdatedRefundRqType;
import com.sadad.ebpp.scm.schema.refundmanagement._1.UpdatedRefundRsType;
import com.sadad.ebpp.wsdl.refundmanagement._1.RefundManagementServicePort;
import com.sadad.ebpp.wsdl.refundmanagement._1.UpdatedRefundFault;
import com.sadad.portal.services.client.proxy.RefundManagementServiceProxy;

/**
 * @author Tariq Siddiqui
 *
 */
public class RefundManagementDelegateImpl implements RefundManagementDelegate
{
	private static RefundManagementDelegateImpl instance;
	private RefundManagementServiceProxy proxy;
	private RefundManagementServicePort service;

	private RefundManagementDelegateImpl()
	{
		proxy = new RefundManagementServiceProxy();
		service = proxy._getDescriptor().getProxy();
		proxy._getDescriptor().setEndpoint(SadadServicesEndPointUrls.REFUND_UPDATE_SERVICE_ENDPOINT);
	}

	/**
	 * Returns the singleton instance of RefundManagementDelegateImpl
	 * 
	 * @return
	 */
	public static RefundManagementDelegateImpl getInstance()
	{
		if (instance == null)
		{
			instance = new RefundManagementDelegateImpl();
		}
		return instance;
	}

	@Override
	public UpdatedRefundRsType updateRefund(UpdatedRefundRqType req) throws UpdatedRefundFault
	{
		logger.log(Level.FINEST, SadadServicesEndPointUrls.REFUND_UPDATE_SERVICE_ENDPOINT);
		if(logger.isLoggable(Level.FINEST))
			logRequest("UpdatedRefundRq", UpdatedRefundRqType.class, req);

		UpdatedRefundRsType res = service.updateRefund(req);

		if(logger.isLoggable(Level.FINEST)) 
			logResponse("UpdatedRefundRs", UpdatedRefundRsType.class, res);

		return res;
	}
}
