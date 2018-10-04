/**
 * 
 */
package com.sadad.ebpp.portal.delegate.factory.clients;

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
import com.sadad.wsdl.corepayment._1.PaymentFault;

/**
 * @author Muhammad.Siddiqui
 * 
 */
public interface CorePaymentDelegate
{
	public ListByIdRsType listById(ListByIdRqType listByIdRq) throws PaymentFault;

	public ListByPayorRsType listByPayor(ListByPayorRqType listByPayorRq) throws PaymentFault;

	public ListByAccountRsType listByAccount(ListByAccountRqType listByAccountRq) throws PaymentFault;

	public ListByBillIdRsType listByBillId(ListByBillIdRqType listByBillIdRq) throws PaymentFault;

	public ListByBeneficiaryRsType listByBeneficiary(ListByBeneficiaryRqType listByBeneficiaryRq) throws PaymentFault;
}
