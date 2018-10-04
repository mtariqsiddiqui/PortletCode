/**
 * 
 */
package com.sadad.ebpp.portal.delegate.factory.clients;

import com.sadad.ebpp.scm.schema.customer._1.ActivateRqType;
import com.sadad.ebpp.scm.schema.customer._1.ActivateRsType;
import com.sadad.ebpp.scm.schema.customer._1.CustProfileAssnRqType;
import com.sadad.ebpp.scm.schema.customer._1.CustProfileAssnRsType;
import com.sadad.ebpp.scm.schema.customer._1.CustProfileDisassnRqType;
import com.sadad.ebpp.scm.schema.customer._1.CustProfileDisassnRsType;
import com.sadad.ebpp.scm.schema.customer._1.CustProfileInqRqType;
import com.sadad.ebpp.scm.schema.customer._1.CustProfileInqRsType;
import com.sadad.ebpp.scm.schema.customer._1.DeactivateRqType;
import com.sadad.ebpp.scm.schema.customer._1.DeactivateRsType;
import com.sadad.ebpp.scm.schema.customer._1.GetByKeyRqType;
import com.sadad.ebpp.scm.schema.customer._1.GetByKeyRsType;
import com.sadad.ebpp.scm.schema.customer._1.ListByAccountRqType;
import com.sadad.ebpp.scm.schema.customer._1.ListByAccountRsType;
import com.sadad.ebpp.scm.schema.customer._1.ListByBillRqType;
import com.sadad.ebpp.scm.schema.customer._1.ListByBillRsType;
import com.sadad.ebpp.wsdl.customer._1.CustomerFault;

/**
 * @author Tariq Siddiqui
 * 
 */
public interface CustomerDelegate
{
	public CustProfileAssnRsType customerAssociation(CustProfileAssnRqType customerAssociationRq) throws CustomerFault;

	public CustProfileDisassnRsType customerDisassociation(CustProfileDisassnRqType customerDisassociationRq) throws CustomerFault;

	public CustProfileInqRsType customerInquiry(CustProfileInqRqType customerInquiryRq) throws CustomerFault;

	public ActivateRsType activate(ActivateRqType activateRq) throws CustomerFault;

	public DeactivateRsType deactivate(DeactivateRqType deactivateRq) throws CustomerFault;

	public GetByKeyRsType getByKey(GetByKeyRqType getByKeyRq) throws CustomerFault;

	public ListByAccountRsType listByAccount(ListByAccountRqType listByAccountRq) throws CustomerFault;

	public ListByBillRsType listByBill(ListByBillRqType listByBillRq) throws CustomerFault;
}