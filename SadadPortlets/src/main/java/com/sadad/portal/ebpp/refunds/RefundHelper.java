/**
 * 
 */
package com.sadad.portal.ebpp.refunds;

import java.util.logging.Logger;

import com.sadad.portal.ebpp.customers.CustomerHelper;

/**
 * @author Tariq Siddiqui
 * 
 */
public class RefundHelper
{
	private final static String CLASS_NAME = CustomerHelper.class.getName();
	private static Logger logger = Logger.getLogger(CLASS_NAME);

	private QueryRefundSessionBean queryRefundObject = new QueryRefundSessionBean(0);

	/**
	 * @return the queryRefundObject
	 */
	public QueryRefundSessionBean getQueryRefundObject()
	{
		return queryRefundObject;
	}

	/**
	 * @param queryRefundObject the queryRefundObject to set
	 */
	public void setQueryRefundObject(QueryRefundSessionBean queryRefundObject)
	{
		this.queryRefundObject = queryRefundObject;
	}
}
