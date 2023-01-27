package com.sadad.portal.common.utils;

public enum BankQueryFileTypes
{
	BKSPL("Bank SPL", "BSPLRQ"),
	BKCUTOFF("Bank Cutoff" , "BCUTRQ"),
	BKRCON("Bank Reconciliation" , "BKRCRQ"),
	BKSETTL("Bank Settlement", "XADDRQ"),
	BKSRL("Refund SRL", "BSRLRQ"),
	BKRCUTOFF("Refund Cutoff", "RCUTRQ"),
	BKRRCON("Refund Reconciliation", "BKRRRQ"),
	BKRFSETTL1("Refund IntraBank 1", "XADRRQ"),
	BKRFSETTL2("Refund IntraBank 2", "XACRRQ"),
	BKRFSETTL1CONF("Refund IntraBank 1 Confirmation", "XFRRRQ"),
	BKRFSETTL2CONF("Refund IntraBank 2 Confirmation", "XFCRRQ");
	
	BankQueryFileTypes(final String name, final String value)
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