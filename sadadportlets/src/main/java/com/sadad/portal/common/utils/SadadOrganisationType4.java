package com.sadad.portal.common.utils;

public enum SadadOrganisationType4
{
	SADAD("SADAD", "sadad"),
//	SAMA("SAMA", "sama"),
	BANK ("Bank", "bank"),
	BILLER ("Biller", "biller"),
	AGGREGATOR("Aggregator", "aggregator");
//	PROVIDER("Provider", "provider");
	
	SadadOrganisationType4(final String name, final String value)
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