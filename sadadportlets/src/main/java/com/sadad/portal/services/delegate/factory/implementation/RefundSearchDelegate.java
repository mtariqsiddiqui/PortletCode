package com.sadad.portal.services.delegate.factory.implementation;

import com.sadad.schema.service.refundsearch._1.GetRefundRqType;
import com.sadad.schema.service.refundsearch._1.GetRefundRsType;
import com.sadad.schema.service.refundsearch._1.ListRefundRqType;
import com.sadad.schema.service.refundsearch._1.ListRefundRqTypePortal;
import com.sadad.schema.service.refundsearch._1.ListRefundRsType;
import com.sadad.schema.service.refundsearch._1.ListRefundRsTypePortal;
import com.sadad.ebpp.wsdl.refundsearch._1.RefundFault;
import com.sadad.portal.common.utils.RequestResponseLogger;

/**
 * 
 * @author Tariq Siddiqui
 * 
 */

public interface RefundSearchDelegate extends RequestResponseLogger
{
	public GetRefundRsType getRefund(GetRefundRqType getRefundRq) throws RefundFault;

	public ListRefundRsType listRefund(ListRefundRqType listRefundRq) throws RefundFault;

	public ListRefundRsTypePortal listRefundPortal(ListRefundRqTypePortal listRefundRqPortal) throws RefundFault;
}