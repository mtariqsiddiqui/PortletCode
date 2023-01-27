/**
 * 
 */
package com.sadad.portal.services.delegate.factory.implementation;

import com.sadad.ebpp.wsdl.accountquery._1.AccountQueryFault;
import com.sadad.portal.common.utils.RequestResponseLogger;
import com.sadad.schema.service.accountquery._1.GetByKeyRqType;
import com.sadad.schema.service.accountquery._1.GetByKeyRsType;
import com.sadad.schema.service.accountquery._1.ListByCustomerRqType;
import com.sadad.schema.service.accountquery._1.ListByCustomerRsType;
import com.sadad.schema.service.accountquery._1.ListByKeysRqType;
import com.sadad.schema.service.accountquery._1.ListByKeysRsType;

/**
 * @author Tariq Siddiqui
 * 
 */
public interface AccountQueryDelegate  extends RequestResponseLogger
{
	public GetByKeyRsType getByKey(GetByKeyRqType getByKeyRq) throws AccountQueryFault;

	public ListByKeysRsType listByKeys(ListByKeysRqType listByKeysRq) throws AccountQueryFault;

	public ListByCustomerRsType listByCustomer(ListByCustomerRqType listByCustomerRq) throws AccountQueryFault;
}