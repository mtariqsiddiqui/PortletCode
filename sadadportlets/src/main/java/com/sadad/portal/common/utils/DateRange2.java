package com.sadad.portal.common.utils;

public enum DateRange2
{
	EXACT("Exact", 0), 
	PLUS_2_DAYS("+2 Days", 2), 
	PLUS_5_DAYS("+5 Days", 5), 
	PLUS_10_DAYS("10 Days", 10), 
	PLUS_20_DAYS("20 Days", 20),	
	PLUS_30_DAYS("30 Days", 30);

	DateRange2(final String name, final int value)
	{
		this.name = name;
		this.value = value;
	}

	private final String name;
	private final int value;

	public String getName()
	{
		return name;
	}

	public int getValue()
	{
		return value;
	}
}