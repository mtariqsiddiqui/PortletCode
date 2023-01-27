/**
 * 
 */
package com.sadad.portal.services.delegate.factory.implementation;

import com.sadad.ebpp.scm.schema.billernotification._1.NotifyPaymentBulkRqType;
import com.sadad.ebpp.scm.schema.billernotification._1.NotifyPaymentBulkRsType;
import com.sadad.ebpp.scm.schema.billernotification._1.NotifyRefundRqType;
import com.sadad.ebpp.scm.schema.billernotification._1.NotifyRefundRsType;
import com.sadad.ebpp.wsdl.billernotification._1.NotifyPaymentBulkFault;
import com.sadad.ebpp.wsdl.billernotification._1.NotifyRefundFault;
import com.sadad.portal.common.utils.RequestResponseLogger;

/**
 * @author Tariq Siddiqui
 *
 */
public interface BillerNotificationDelegate extends RequestResponseLogger
{
	public NotifyPaymentBulkRsType notifyPaymentBulk(NotifyPaymentBulkRqType npbr) throws NotifyPaymentBulkFault;

	public NotifyRefundRsType notifyRefund(NotifyRefundRqType nrr) throws NotifyRefundFault;
}
