package com.sadad.portal.beans;

import java.util.HashMap;
import java.util.Map;

public class Template
{
	private long templateId;
	private String templateName;
	private String description;
	private String status;
	private Map<Long, ConfigAttribute> templateAttributes;
	private String partnerTemplateIdentifier;
	private long partnerConfigTemplateId;

	public long getTemplateId()
	{
		return this.templateId;
	}

	public void setTemplateId(long templateId)
	{
		this.templateId = templateId;
	}

	public String getTemplateName()
	{
		return this.templateName;
	}

	public void setTemplateName(String templateName)
	{
		this.templateName = templateName;
	}

	public String getDescription()
	{
		return this.description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public String getStatus()
	{
		return this.status;
	}

	public void setStatus(String status)
	{
		this.status = status;
	}

	public String getPartnerTemplateIdentifier()
	{
		return this.partnerTemplateIdentifier;
	}

	public void setPartnerTemplateIdentifier(String partnerTemplateIdentifier)
	{
		this.partnerTemplateIdentifier = partnerTemplateIdentifier;
	}

	public long getPartnerConfigTemplateId()
	{
		return this.partnerConfigTemplateId;
	}

	public void setPartnerConfigTemplateId(long partnerConfigTemplateId)
	{
		this.partnerConfigTemplateId = partnerConfigTemplateId;
	}

	public Map<Long, ConfigAttribute> getTemplateAttributes()
	{
		if (this.templateAttributes == null)
			this.templateAttributes = new HashMap<Long, ConfigAttribute>();
		return this.templateAttributes;
	}
}
