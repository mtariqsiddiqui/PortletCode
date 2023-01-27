package com.sadad.portal.beans;

import java.util.ArrayList;
import java.util.List;

public class ConfigAttribute
{
	private long configAttribId;
	private long attribId;
	private String attribName;
	private String description;
	private String defaultValue;
	private String configuredValue;
	private List<String> possibleValues;
	private boolean templateIdentifier;
	private boolean mandatory;
	private String status;
	private String validationExpression;

	public long getConfigAttribId()
	{
		return configAttribId;
	}

	public void setConfigAttribId(long configAttribId)
	{
		this.configAttribId = configAttribId;
	}

	public long getAttribId()
	{
		return attribId;
	}

	public void setAttribId(long attribId)
	{
		this.attribId = attribId;
	}

	public String getAttribName()
	{
		return attribName;
	}

	public void setAttribName(String attribName)
	{
		this.attribName = attribName;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public String getDefaultValue()
	{
		return defaultValue;
	}

	public void setDefaultValue(String defaultValue)
	{
		this.defaultValue = defaultValue;
	}

	public String getConfiguredValue()
	{
		return configuredValue;
	}

	public void setConfiguredValue(String value)
	{
		this.configuredValue = value;
	}

	public boolean isTemplateIdentifier()
	{
		return templateIdentifier;
	}

	public void setTemplateIdentifier(boolean b)
	{
		this.templateIdentifier = b;
	}

	public String getStatus()
	{
		return status;
	}

	public void setStatus(String status)
	{
		this.status = status;
	}

	public boolean isMandatory()
	{
		return mandatory;
	}

	public void setMandatory(boolean b)
	{
		this.mandatory = b;
	}

	public String getValidationExpression()
	{
		return validationExpression;
	}

	public void setValidationExpression(String validationExpression)
	{
		this.validationExpression = validationExpression;
	}

	public List<String> getPossibleValues()
	{
		if (possibleValues == null)
			possibleValues = new ArrayList<String>();
		return possibleValues;
	}
}