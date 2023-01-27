package com.sadad.portal.common.utils;

public enum BillerQueryFileTypes
{
	BILLER_AU("Account Upload", "AUPLRQ"),
	BILLER_ACR("Account Confirmation", "ACONRQ"),
	BILLER_BU ("Bill Upload", "BUPLRQ"),
	BILLER_BCR("Bill Confirmation" , "BCONRQ"),
	BILLER_PU("Payment Upload" , "PUPLRQ"),
	BILLER_PCR("Payment Confirmation", "PCONRQ"),
	BILLER_SPL("Biller SPL", "BLTLRQ"),
	BILLER_NOTIF("Biller Notification", "PNUPRQ"),
	BILLER_BLRCON("Biller Reconciliation", "BLRCRQ"),
	BILLER_RU("Refund Upload", "RUPLRQ"),
	BILLER_RCR("Refund Confirmation", "RCONRQ"),
	BILLER_BLRRCON("Biller Refund Reconciliation", "BLRRRQ"),
	BILLER_RAADRQ("Refund Account Adjustment Report", "RAADRQ");
	
	BillerQueryFileTypes(final String name, final String value)
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