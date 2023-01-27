package com.sadad.portal.beans;

import java.util.HashMap;
import java.util.Map;

import com.sadad.portal.common.utils.JsonBuilder;

public class BusinessRulesSessionDataBean extends SadadPortalSessionDataBean
{
	public static final String PARTNER_CONFIG_FIELD_SEPARATOR = "#_FIELD_SEPARATOR_#";
	public static final String PARTNER_CONFIG_RECORD_SEPARATOR = "#_RECORD_SEPARATOR_#";

	private String partnerId;
	private String organisationType;
	private boolean includePossibleValues;
	private String configuraitonName;
	private long configrationKey;
	private String identifier;
	private String configType;
	private boolean activeOnly;
	private Map<Long, PartnerConfiguration> partnerConfiguration;
	private String status;
	private String templateName;
	private String templateDescription;
	private boolean clearSecondContainer;

	/**
	 * PartnerConfigValues will contain the concatenated value for Create, Update, Activate or DeActivate PartnerConfiguration
	 * partnerConfigValue will use PARTNER_CONFIG_VALUE_SEPARATOR as its value separator.
	 * partnerConfigValues will be populated using JavaScript method before HTML form submission
	 * partnerConfigValues will contains the following, | is used as separator in example below.
	 * In case of Attribute Based Config Type
	 * partnerConfigValues = AttributeId | AttributeName | AttributeValue
	 * In case of Template Based Config Type
	 * partnerConfigValues = TemplateId  | TemplateName
	 * 
	 */
	private String partnerConfigValues;
	
	public String getPartnerId()
	{
		return partnerId;
	}

	public void setPartnerId(String partnerId)
	{
		this.partnerId = partnerId;
	}

	public String getOrganisationType()
	{
		return organisationType;
	}

	public void setOrganisationType(String organisationType)
	{
		this.organisationType = organisationType;
	}

	public boolean isIncludePossibleValues()
	{
		return includePossibleValues;
	}

	public void setIncludePossibleValues(boolean includePossibleValues)
	{
		this.includePossibleValues = includePossibleValues;
	}

	public String getConfiguraitonName()
	{
		return configuraitonName;
	}

	public void setConfiguraitonName(String configuraitonName)
	{
		this.configuraitonName = configuraitonName;
	}

	public String getIdentifier()
	{
		return identifier;
	}

	public void setIdentifier(String identifier)
	{
		this.identifier = identifier;
	}

	public String getConfigType()
	{
		return configType;
	}

	public void setConfigType(String configType)
	{
		this.configType = configType;
	}

	public boolean isActiveOnly()
	{
		return activeOnly;
	}

	public void setActiveOnly(boolean activeOnly)
	{
		this.activeOnly = activeOnly;
	}

	public long getConfigrationKey()
	{
		return configrationKey;
	}

	public void setConfigrationKey(long configrationKey)
	{
		this.configrationKey = configrationKey;
	}

	public Map<Long, PartnerConfiguration> getPartnerConfiguration()
	{
		if (this.partnerConfiguration == null)
			this.partnerConfiguration = new HashMap<Long, PartnerConfiguration>();
		return this.partnerConfiguration;
	}

	public String getPartnerConfigValues()
	{
		return partnerConfigValues;
	}

	public void setPartnerConfigValues(String partnerConfigValues)
	{
		this.partnerConfigValues = partnerConfigValues;
	}
	
	public String getStatus()
	{
		return status;
	}

	public void setStatus(String status)
	{
		this.status = status;
	}

	public String getTemplateName()
	{
		return templateName;
	}

	public void setTemplateName(String templateName)
	{
		this.templateName = templateName;
	}

	public String getTemplateDescription()
	{
		return templateDescription;
	}

	public boolean isClearSecondContainer()
	{
		return clearSecondContainer;
	}
	
	public void setClearSecondContainer(boolean clearSecondContainer)
	{
		this.clearSecondContainer = clearSecondContainer;
	}

	public void setTemplateDescription(String templateDescription)
	{
		this.templateDescription = templateDescription;
	}

	public String getPARTNER_CONFIG_FIELD_SEPARATOR()
	{
		return PARTNER_CONFIG_FIELD_SEPARATOR;
	}
	
	public String getPARTNER_CONFIG_RECORD_SEPARATOR()
	{
		return PARTNER_CONFIG_RECORD_SEPARATOR;
	}
	
	public String getJsonString()
	{
		PartnerConfiguration pc = getPartnerConfiguration().get(configrationKey);
		if (pc != null)
			return JsonBuilder.toJson(pc);
		else
			return "";
	}
}