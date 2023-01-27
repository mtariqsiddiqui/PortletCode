package com.sadad.portal.common.utils;

import java.util.ResourceBundle;

public class SadadLdapDefinedUserAttributeDefinitions
{
	static final ResourceBundle rb = ResourceBundle.getBundle("nl/ldap/LDAP_Attributes_Definition");
	static final short ATTRIBUTE_TYPE = 0;
	static final short MULTI_VALUED = 1;
	static final short REQUIRED = 2;
	static final short READ_ONLY = 3;

	private String attributeName;
	private String attributeType;
	private boolean isMultiValued;
	private boolean isRequired;
	private boolean isReadOnly;

	public SadadLdapDefinedUserAttributeDefinitions(String key)
	{
		String[] definition;
		if (rb.containsKey(key))
		{
			definition = rb.getString(key).split(",");
			
			this.setAttributeName(key);
			this.setAttributeType(definition[ATTRIBUTE_TYPE]);
			this.setMultiValued(Boolean.parseBoolean(definition[MULTI_VALUED]));
			this.setRequired(Boolean.parseBoolean(definition[REQUIRED]));
			this.setReadOnly(Boolean.parseBoolean(definition[READ_ONLY]));
		}
		else
			this.setAttributeName("KEY_NOT_FOUND");
	}

	public String getAttributeName()
	{
		return attributeName;
	}

	public void setAttributeName(String attributeName)
	{
		this.attributeName = attributeName;
	}

	public String getAttributeType()
	{
		return attributeType;
	}

	public void setAttributeType(String attributeType)
	{
		this.attributeType = attributeType;
	}

	public boolean isMultiValued()
	{
		return isMultiValued;
	}

	public void setMultiValued(boolean isMultiValued)
	{
		this.isMultiValued = isMultiValued;
	}

	public boolean isRequired()
	{
		return isRequired;
	}

	public void setRequired(boolean isRequired)
	{
		this.isRequired = isRequired;
	}

	public boolean isReadOnly()
	{
		return isReadOnly;
	}

	public void setReadOnly(boolean isReadOnly)
	{
		this.isReadOnly = isReadOnly;
	}

	@Override
	public String toString()
	{
		return "SadadLdapDefinedUserAttributeDefinitions [" + (attributeName != null ? "attributeName=" + attributeName + ", " : "") + (attributeType != null ? "attributeType=" + attributeType + ", " : "") + "isMultiValued=" + isMultiValued
				+ ", isRequired=" + isRequired + ", isReadOnly=" + isReadOnly + "]";
	}
}
