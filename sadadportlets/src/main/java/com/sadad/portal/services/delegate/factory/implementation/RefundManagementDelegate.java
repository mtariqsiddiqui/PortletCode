package com.sadad.portal.services.delegate.factory.implementation;

import com.sadad.ebpp.scm.schema.refundmanagement._1.UpdatedRefundRqType;
import com.sadad.ebpp.scm.schema.refundmanagement._1.UpdatedRefundRsType;
import com.sadad.ebpp.wsdl.refundmanagement._1.UpdatedRefundFault;
import com.sadad.portal.common.utils.RequestResponseLogger;

/**
 * 
 * @author Tariq Siddiqui
 * 
 */
public interface RefundManagementDelegate extends RequestResponseLogger 
{
	public UpdatedRefundRsType updateRefund(UpdatedRefundRqType updatedRefundRq) throws UpdatedRefundFault;
}
