package com.sadad.portal.common.utils;

public enum ProfileSearchCriterion
{
	USERID("User ID", "uid"), 
	FIRSTNAME("First Name", "cn"), 
	LASTNAME("Last Name", "sn"), 
	PHONE("Phone Number", "telephoneNumber"), 
	EMAIL("Email Address", "mail"),
	JOBTITLE("Job Title", "title"),
	USERSTATUS("User Status", "userState");

	ProfileSearchCriterion(final String name, final String value)
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