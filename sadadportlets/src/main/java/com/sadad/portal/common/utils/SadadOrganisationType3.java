package com.sadad.portal.common.utils;

public enum SadadOrganisationType3
{
	SADAD("SADAD", "sadad"),
	BANK ("Bank", "bank"),
	BILLER ("Biller", "biller");
	
	SadadOrganisationType3(final String name, final String value)
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
