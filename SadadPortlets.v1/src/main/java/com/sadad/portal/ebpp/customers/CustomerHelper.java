/**
 * 
 */
package com.sadad.portal.ebpp.customers;

import java.util.logging.Logger;

/**
 * @author Tariq Siddiqui
 *
 */
public class CustomerHelper
{
	private final static String CLASS_NAME = CustomerHelper.class.getName();
	private static Logger logger = Logger.getLogger(CLASS_NAME);
	
	private QueryCustomerSessionBean queryCustomerObject = new QueryCustomerSessionBean(0);

	/**
	 * @return the queryCustomerObject
	 */
	public QueryCustomerSessionBean getQueryCustomerObject()
	{
		return queryCustomerObject;
	}

	/**
	 * @param queryCustomerObject the queryCustomerObject to set
	 */
	public void setQueryCustomerObject(QueryCustomerSessionBean queryCustomerObject)
	{
		this.queryCustomerObject = queryCustomerObject;
	}
}
