/**
 * 
 */
package com.sadad.portal.ebpp.payments;

import java.util.logging.Logger;

/**
 * @author Tariq Siddiqui
 * 
 */
public class PaymentsHelper
{
	private final static String CLASS_NAME = PaymentsHelper.class.getName();
	private static Logger logger = Logger.getLogger(CLASS_NAME);

	private QueryPaymentSessionBean queryPaymentObject = new QueryPaymentSessionBean(0);
	private RejectedPaymentsSessionBean rejectedPaymentsObject = new RejectedPaymentsSessionBean(0);

	/**
	 * @return the queryPaymentObject
	 */
	public QueryPaymentSessionBean getQueryPaymentObject()
	{
		return queryPaymentObject;
	}

	/**
	 * @param queryPaymentObject
	 *            the queryPaymentObject to set
	 */
	public void setQueryPaymentObject(QueryPaymentSessionBean queryPaymentObject)
	{
		this.queryPaymentObject = queryPaymentObject;
	}

	/**
	 * @return the rejectedPaymentsObject
	 */
	public RejectedPaymentsSessionBean getRejectedPaymentsObject()
	{
		return rejectedPaymentsObject;
	}

	/**
	 * @param rejectedPaymentsObject
	 *            the rejectedPaymentsObject to set
	 */
	public void setRejectedPaymentsObject(RejectedPaymentsSessionBean rejectedPaymentsObject)
	{
		this.rejectedPaymentsObject = rejectedPaymentsObject;
	}
}
