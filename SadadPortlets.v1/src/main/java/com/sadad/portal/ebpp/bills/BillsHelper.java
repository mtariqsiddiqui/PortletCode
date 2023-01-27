/**
 * 
 */
package com.sadad.portal.ebpp.bills;

import java.util.logging.Logger;

/**
 * @author Tariq Siddiqui
 * 
 */
public class BillsHelper
{
	private final static String CLASS_NAME = BillsHelper.class.getName();
	private static Logger logger = Logger.getLogger(CLASS_NAME);

	private QueryBillSessionBean queryBillObject = new QueryBillSessionBean(0);
	private RejectedBillsSessionBean rejectedBillsObject = new RejectedBillsSessionBean(0);

	/**
	 * @return the queryBillObject
	 */
	public QueryBillSessionBean getQueryBillObject()
	{
		return queryBillObject;
	}

	/**
	 * @param queryBillObject
	 *            the queryBillObject to set
	 */
	public void setQueryBillObject(QueryBillSessionBean queryBillObject)
	{
		this.queryBillObject = queryBillObject;
	}

	/**
	 * @return the rejectedBillsObject
	 */
	public RejectedBillsSessionBean getRejectedBillsObject()
	{
		return rejectedBillsObject;
	}

	/**
	 * @param rejectedBillsObject
	 *            the rejectedBillsObject to set
	 */
	public void setRejectedBillsObject(RejectedBillsSessionBean rejectedBillsObject)
	{
		this.rejectedBillsObject = rejectedBillsObject;
	}
}
