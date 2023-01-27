package com.sadad.portal.common.utils;

public enum SadadOrganisationType5
{
	SADAD("SADAD", "sadad"),
//	SAMA("SAMA", "sama"),
	BANK ("Bank", "bank"),
	BILLER ("Biller", "biller"),
	SUBBILLER ("SubBiller", "subbiller"),
	AGGREGATOR("Aggregator", "aggregator");
//	PROVIDER("Provider", "provider");
	
	SadadOrganisationType5(final String name, final String value)
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