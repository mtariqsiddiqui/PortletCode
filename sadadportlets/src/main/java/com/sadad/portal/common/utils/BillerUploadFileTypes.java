package com.sadad.portal.common.utils;


public enum BillerUploadFileTypes
{
	BILLER_AU("Account Upload", "AU"), 
	BILLER_BU("Bill Upload", "BU"), 
	BILLER_PU("Payment Upload", "PU"),
	BILLER_RU("Refund Upload", "RU");
	
	BillerUploadFileTypes(final String name, final String value)
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