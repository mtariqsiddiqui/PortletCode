package com.sadad.portal.common.utils;

public enum BankSendBatchFileTypes
{
	BKCUTOFF("Payment Cutoff" , "BCUTRQ"),
	BKPMSETTLT("Payment IntraBank Instruction", "XADDRQ"),
	BKRCON("Payment Reconciliation" , "BKRCRQ"),
	BKRCUTOFF("Refund Cutoff", "RCUTRQ"),
	BKRFSETTL1("Refund IntraBank 1", "XADRRQ"),
	BKRFSETTL2("Refund IntraBank 2", "XACRRQ"),
	BKRRCON("Refund Reconciliation", "BKRRRQ");
	
	BankSendBatchFileTypes(final String name, final String value)
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