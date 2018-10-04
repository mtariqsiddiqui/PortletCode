/**
 * 
 */
package com.sadad.ebpp.portal.delegate.factory.clients;

import com.sadad.ebpp.wsdl.accountquery._1.AccountQueryFault;
import com.sadad.schema.service.accountquery._1.GetByKeyRqType;
import com.sadad.schema.service.accountquery._1.GetByKeyRsType;
import com.sadad.schema.service.accountquery._1.ListByCustomerRqType;
import com.sadad.schema.service.accountquery._1.ListByCustomerRsType;

/**
 * @author Tariq Siddiqui
 * 
 */
public interface AccountQueryDelegate
{
	public GetByKeyRsType getByKey(GetByKeyRqType getByKeyRq) throws AccountQueryFault;

	public ListByCustomerRsType listByCustomer(ListByCustomerRqType listByCustomerRq) throws AccountQueryFault;
}