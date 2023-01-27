/**
 * 
 */
package com.sadad.portal.services.delegate.factory.implementation;

import com.sadad.ebpp.scm.schema.billsearch._1.GetByBillNumberRqType;
import com.sadad.ebpp.scm.schema.billsearch._1.GetByBillNumberRsType;
import com.sadad.ebpp.scm.schema.billsearch._1.ListByAccountRqType;
import com.sadad.ebpp.scm.schema.billsearch._1.ListByAccountRsType;
import com.sadad.ebpp.scm.schema.billsearch._1.ListByCustomerRqType;
import com.sadad.ebpp.scm.schema.billsearch._1.ListByCustomerRsType;
import com.sadad.ebpp.scm.schema.billsearch._1.ListByPaymentRqType;
import com.sadad.ebpp.scm.schema.billsearch._1.ListByPaymentRsType;
import com.sadad.ebpp.wsdl.billsearch._1.BillSearchFault;
import com.sadad.portal.common.utils.RequestResponseLogger;

/**
 * @author Tariq Siddiqui
 * 
 */
public interface BillSearchDelegate extends RequestResponseLogger
{
	public GetByBillNumberRsType getByBillNumber(GetByBillNumberRqType getBillReq) throws BillSearchFault;

	public ListByAccountRsType listByAccount(ListByAccountRqType listByAccountReq) throws BillSearchFault;

	public ListByCustomerRsType listByCustomer(ListByCustomerRqType listByCustomerReq) throws BillSearchFault;

	public ListByPaymentRsType listByPayment(ListByPaymentRqType listByPaymentReq) throws BillSearchFault;
}