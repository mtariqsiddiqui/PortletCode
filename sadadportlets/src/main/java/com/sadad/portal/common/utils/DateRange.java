package com.sadad.portal.common.utils;

public enum DateRange
{
	EXACT("Exact", 0), 
	FOR_3_DAYS("3 Days", 3), 
	FOR_7_DAYS("7 Days", 7), 
	FOR_10_DAYS("10 Days", 10), 
	FOR_30_DAYS("30 Days", 30);

	DateRange(final String name, final int value)
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