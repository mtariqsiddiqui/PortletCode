package com.sadad.portal.beans;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TemplateData
{
	private String templateIdentifier;
	private List<String> identifierValues;
	private Map<Long, Template> templates;

	public String getTemplateIdentifier()
	{
		return this.templateIdentifier;
	}

	public void setTemplateIdentifier(String templateIdentifier)
	{
		this.templateIdentifier = templateIdentifier;
	}

	public List<String> getIdentifierValues()
	{
		if (this.identifierValues == null)
			this.identifierValues = new ArrayList<String>();
		return this.identifierValues;
	}

	public Map<Long, Template> getTemplates()
	{
		if (this.templates == null)
			this.templates = new HashMap<Long, Template>();
		return this.templates;
	}
}
