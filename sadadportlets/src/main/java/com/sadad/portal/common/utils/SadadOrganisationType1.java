package com.sadad.portal.common.utils;

public enum SadadOrganisationType1
{
	SUBBILLER ("SubBiller", "subbiller");
	
	SadadOrganisationType1(final String name, final String value)
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