package com.sadad.portal.beans;

import java.math.BigDecimal;

public class SadadPaymentLog
{
	private String interatorKey;
	/**
	 * @return the interatorKey
	 */
	public String getInteratorKey()
	{
		return interatorKey;
	}

	/**
	 * @param interatorKey the interatorKey to set
	 */
	public void setInteratorKey(String interatorKey)
	{
		this.interatorKey = interatorKey;
	}

	private String paymentKey;
	private BigDecimal amount;
	private String bankNumber;
	private String status;

	/**
	 * @return the paymentKey
	 */
	public String getPaymentKey()
	{
		return paymentKey;
	}

	/**
	 * @param paymentKey
	 *            the paymentKey to set
	 */
	public void setPaymentKey(String paymentKey)
	{
		this.paymentKey = paymentKey;
	}

	/**
	 * @return the amount
	 */
	public BigDecimal getAmount()
	{
		return amount;
	}

	/**
	 * @param amount
	 *            the amount to set
	 */
	public void setAmount(BigDecimal amount)
	{
		this.amount = amount;
	}

	/**
	 * @return the bankNumber
	 */
	public String getBankNumber()
	{
		return bankNumber;
	}

	/**
	 * @param bankNumber
	 *            the bankNumber to set
	 */
	public void setBankNumber(String bankNumber)
	{
		this.bankNumber = bankNumber;
	}

	/**
	 * @return the status
	 */
	public String getStatus()
	{
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(String status)
	{
		this.status = status;
	}
}