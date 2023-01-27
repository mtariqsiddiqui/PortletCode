package com.sadad.portal.common.utils;

public enum BillerSendBatchFileTypes
{
	BILLER_ACR("Account Upload Confirmation", "ACONRQ"),
	BILLER_BCR("Bill Upload Confirmation" , "BCONRQ"),
	BILLER_PCR("Payment Upload Confirmation", "PCONRQ"),
	BILLER_RCR("Refund Upload Confirmation", "RCONRQ"),
	BILLER_BLRCON("Payment Reconciliation", "BLRCRQ"),
	BILLER_BLRRCON("Refund Reconciliation", "BLRRRQ"),
	BILLER_SPL("Payment SPL", "BSPLRQ"),
	BILLER_CRQ("Refund Bulk Notification", "RNOBRQ"),
	BILLER_BRQ("Refund Batch Notification", "RNUBRQ"),
	BILLER_PRQ("Payment Batch Notification", "PNUPRQ");

	BillerSendBatchFileTypes(final String name, final String value)
	{
		this.name = name;
		this.value = value;
	}

	private final String name;
	private final String value;

	public String getName()
	{
		return name;
	}

	public String getValue()
	{
		return value;
	}
}