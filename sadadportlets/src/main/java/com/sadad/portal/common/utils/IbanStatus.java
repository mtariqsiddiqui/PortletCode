package com.sadad.portal.common.utils;

public enum IbanStatus
{
	ACTIVE("Active", "ACTIVE"),
	INACTIVE("Inactive", "INACTIVE");

	IbanStatus(final String name, final String value)
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