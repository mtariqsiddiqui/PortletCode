package com.sadad.portal.beans;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sadad.portal.common.utils.JsonBuilder;

/**
 * @author Tariq Siddiqui
 * 
 */
public class PartnerConfiguration
{
	private long configId;
	private String configName;
	private String configured;
	private List<String> identifierValues;
	private Map<Long, ConfigAttribute> attributes;
	private Map<String, Template> templates;

	public long getConfigId()
	{
		return this.configId;
	}

	public void setConfigId(long configId)
	{
		this.configId = configId;
	}

	public String getConfigName()
	{
		return this.configName;
	}

	public void setConfigName(String configName)
	{
		this.configName = configName;
	}

	public String getConfigured()
	{
		return this.configured;
	}

	public void setConfigured(String configured)
	{
		if (this.configured == null || configured.equalsIgnoreCase("Configured") || configured.equalsIgnoreCase("Not Configured"))
			this.configured = configured;
		else
			this.configured = (this.configured + ", " + configured);
	}

	public List<String> getIdentifierValues()
	{
		if (this.identifierValues == null)
			this.identifierValues = new ArrayList<String>();

		return this.identifierValues;
	}

	public Map<Long, ConfigAttribute> getAttributes()
	{
		if (this.attributes == null)
			this.attributes = new HashMap<Long, ConfigAttribute>();
		return this.attributes;
	}

	public Map<String, Template> getTemplates()
	{
		if (this.templates == null)
			this.templates = new HashMap<String, Template>();
		return this.templates;
	}

	public String getJsonString()
	{
		return JsonBuilder.toJson(this);
	}
}