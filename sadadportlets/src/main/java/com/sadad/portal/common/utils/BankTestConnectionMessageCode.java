package com.sadad.portal.common.utils;

public enum BankTestConnectionMessageCode
{
	BSPLRQ("Bank SPL", "BSPLRQ"),
	BCUTRQ("Bank Cutoff" , "BCUTRQ"),
	BKRCRQ("Bank Reconciliation" , "BKRCRQ"),
	XADDRQ("Bank Settlement", "XADDRQ"),
	BSRLRQ("Refund SRL", "BSRLRQ"),
	RCUTRQ("Refund Cutoff", "RCUTRQ"),
	BKRRRQ("Refund Reconciliation", "BKRRRQ"),
	XADRRQ("Refund IntraBank 1", "XADRRQ"),
	XACRRQ("Refund IntraBank 2", "XACRRQ"),
	XAPFRQ("XAPFRQ", "XAPFRQ"),
	XARFRQ("XARFRQ", "XARFRQ");
	
	BankTestConnectionMessageCode(final String name, final String value)
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