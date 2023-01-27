package com.sadad.portal.common.utils;

public enum PrefferedLanguage
{
	ENGLISH("English", "en"), 
	ARABIC("Arabic", "ar");

	PrefferedLanguage(final String name, final String value)
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