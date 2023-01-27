package com.sadad.portal.common.utils;


public enum BankUploadFileTypes
{
	BANK_SPL("SADAD Payment Log (SPL)", "SPL"),
	BANK_SRL("SADAD Refund Log (SRL)", "SRL");
	
	BankUploadFileTypes(final String name, final String value)
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