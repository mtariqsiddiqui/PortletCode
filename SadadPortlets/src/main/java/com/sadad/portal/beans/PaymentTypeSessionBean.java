/**
 * 
 */
package com.sadad.portal.beans;

import java.util.ArrayList;

/**
 * @author Yameen Haji
 * 
 */
public class PaymentTypeSessionBean extends SadadPortalSessionBean
{
	private ArrayList<PaymentTypeDetail> paymentTypeList;
	private PaymentTypeSessionBean paymentType;
	private PaymentTypeDetail selectedPaymentType;

	public PaymentTypeSessionBean()
	{
		super();
	}

	/**
	 * @return the paymentType
	 */
	public PaymentTypeSessionBean getPaymentType()
	{
		return paymentType;
	}

	/**
	 * @param paymentType the paymentType to set
	 */
	public void setPaymentType(PaymentTypeSessionBean paymentType)
	{
		this.paymentType = paymentType;
	}
		
	/**
	 * @return the paymentTypeList
	 */
	public ArrayList<PaymentTypeDetail> getPaymentTypeList()
	{
		return paymentTypeList;
	}

	/**
	 * @param paymentTypeList the paymentTypeList to set
	 */
	public void setPaymentTypeList(ArrayList<PaymentTypeDetail> paymentTypeList)
	{
		this.paymentTypeList = paymentTypeList;
	}
	
	/**
	 * @return the selectedPaymentType
	 */
	public PaymentTypeDetail getSelectedPaymentType()
	{
		return selectedPaymentType;
	}
	
	/**
	 * @param selectedPaymentType the selectedPaymentType to set
	 */
	public void setSelectedPaymentType(PaymentTypeDetail selectedPaymentType)
	{
		this.selectedPaymentType = selectedPaymentType;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "PaymentTypeSessionBean [paymentTypeList=" + paymentTypeList + ", paymentType=" + paymentType + ", selectedPaymentType=" + selectedPaymentType + "]";
	}
}