package com.sadad.portal.beans;

import java.util.HashMap;
import java.util.Map;

import com.sadad.portal.common.utils.JsonBuilder;

public class Configuration
{
	private long configId;
	private String configName;
	private String description;
	private Map<Long, ConfigAttribute> attributes;
	private TemplateData templateData;
	private String configType;
	private String status;
	
	public long getConfigId()
	{
		return configId;
	}

	public void setConfigId(long configId)
	{
		this.configId = configId;
	}

	public String getConfigName()
	{
		return configName;
	}

	public void setConfigName(String configName)
	{
		this.configName = configName;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public TemplateData getTemplateData()
	{
		return templateData;
	}

	public void setTemplateData(TemplateData templateData)
	{
		this.templateData = templateData;
	}

	public String getConfigType()
	{
		if(this.templateData == null)
			this.configType = "ATTRIBUTE Based";
		else
			this.configType = "TEMPLATE Based";
		return this.configType;
	}

	public String getStatus()
	{
		return status;
	}

	public void setStatus(String status)
	{
		this.status = status;
	}

	public Map<Long, ConfigAttribute> getAttributes()
	{
		if (this.attributes == null)
			this.attributes = new HashMap<Long, ConfigAttribute>();
		return this.attributes;
	}

	public String getJsonString()
	{
		return JsonBuilder.toJson(this);
	}
}