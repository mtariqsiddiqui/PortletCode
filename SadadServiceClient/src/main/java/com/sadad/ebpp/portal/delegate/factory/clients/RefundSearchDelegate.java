package com.sadad.ebpp.portal.delegate.factory.clients;

import com.sadad.schema.service.refundsearch._1.GetRefundRqType;
import com.sadad.schema.service.refundsearch._1.GetRefundRsType;
import com.sadad.schema.service.refundsearch._1.ListRefundRqType;
import com.sadad.schema.service.refundsearch._1.ListRefundRsType;
import com.sadad.wsdl.refundsearch._1.RefundFault;

/**
 * 
 * @author Tariq Siddiqui
 * 
 */

public interface RefundSearchDelegate
{
	public GetRefundRsType getRefund(GetRefundRqType getRefundRq) throws RefundFault;

	public ListRefundRsType listRefund(ListRefundRqType listRefundRq) throws RefundFault;
}
