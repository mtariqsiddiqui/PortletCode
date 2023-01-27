/**
 * 
 */
package com.sadad.portal.services.delegate.factory.implementation;

import com.sadad.portal.common.utils.RequestResponseLogger;
import com.sadad.schema.service.corepayment._1.CancelRqType;
import com.sadad.schema.service.corepayment._1.CancelRsType;
import com.sadad.schema.service.corepayment._1.ListByAccountRqType;
import com.sadad.schema.service.corepayment._1.ListByAccountRsType;
import com.sadad.schema.service.corepayment._1.ListByBeneficiaryRqType;
import com.sadad.schema.service.corepayment._1.ListByBeneficiaryRsType;
import com.sadad.schema.service.corepayment._1.ListByBillIdRqType;
import com.sadad.schema.service.corepayment._1.ListByBillIdRsType;
import com.sadad.schema.service.corepayment._1.ListByIdRqType;
import com.sadad.schema.service.corepayment._1.ListByIdRsType;
import com.sadad.schema.service.corepayment._1.ListByPayorRqType;
import com.sadad.schema.service.corepayment._1.ListByPayorRsType;
import com.sadad.schema.service.corepayment._1.ListSPLPaymentsRqType;
import com.sadad.schema.service.corepayment._1.ListSPLPaymentsRsType;
import com.sadad.schema.service.corepayment._1.UncancelRqType;
import com.sadad.schema.service.corepayment._1.UncancelRsType;
import com.sadad.wsdl.corepayment._1.PaymentFault;

/**
 * @author Tariq Siddiqui
 * 
 */
public interface CorePaymentDelegate extends RequestResponseLogger
{
	public ListByIdRsType listById(ListByIdRqType listByIdRq) throws PaymentFault;

	public ListByPayorRsType listByPayor(ListByPayorRqType listByPayorRq) throws PaymentFault;

	public ListByAccountRsType listByAccount(ListByAccountRqType listByAccountRq) throws PaymentFault;

	public ListByBillIdRsType listByBillId(ListByBillIdRqType listByBillIdRq) throws PaymentFault;

	public ListByBeneficiaryRsType listByBeneficiary(ListByBeneficiaryRqType listByBeneficiaryRq) throws PaymentFault;

	public ListSPLPaymentsRsType listSPLPayments(ListSPLPaymentsRqType listSPLPaymentsRq) throws PaymentFault;

	public CancelRsType cancel(CancelRqType cancelRq) throws PaymentFault;

	public UncancelRsType uncancel(UncancelRqType uncancelRq) throws PaymentFault;
}