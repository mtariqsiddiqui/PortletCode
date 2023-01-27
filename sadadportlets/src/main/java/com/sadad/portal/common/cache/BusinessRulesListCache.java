package com.sadad.portal.common.cache;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.datatype.DatatypeConfigurationException;

import com.sadad.ebpp.scm.schema.partnerconfigurationservice._1.GetConfigurationRqType;
import com.sadad.ebpp.scm.schema.partnerconfigurationservice._1.GetConfigurationRsType;
import com.sadad.ebpp.wsdl.partnerconfigurationservice._1.PartnerConfigurationFault;
import com.sadad.portal.beans.ConfigAttribute;
import com.sadad.portal.beans.Configuration;
import com.sadad.portal.beans.Template;
import com.sadad.portal.beans.TemplateData;
import com.sadad.portal.constant.PortalConstant;
import com.sadad.portal.services.client.helper.PortalServiceCallHelper;
import com.sadad.scm.common._1.ConfigurationAttributeType;
import com.sadad.scm.common._1.ConfigurationTemplateDataType;
import com.sadad.scm.common._1.ConfigurationTemplateType;
import com.sadad.scm.common._1.ConfigurationType;
import com.sadad.scm.common._1.TemplateAttributeType;
import java.util.Collections;

/**
 * @author Tariq Siddiqui
 *
 */
public class BusinessRulesListCache extends PortalServiceCallHelper implements SadadListCache
{
	private static final String CLASS_NAME = BusinessRulesListCache.class.getName();
	private static final Logger logger = Logger.getLogger(CLASS_NAME);

	public static boolean CACHE_REFRESH_FLAG = true;

	private long configId;
	private long templateId;
	private String status;
	private String listType;
	
	public BusinessRulesListCache(long configId, long templateId, String status, String listType)
	{
		super();
		this.configId = configId;
		this.templateId = templateId;
		this.status = status;
		this.listType = listType;
	}

	public long getConfigId()
	{
		return configId;
	}

	public void setConfigId(long configId)
	{
		this.configId = configId;
	}

	public long getTemplateId()
	{
		return templateId;
	}

	public void setTemplateId(long templateId)
	{
		this.templateId = templateId;
	}

	public String getStatus()
	{
		return status;
	}

	public void setStatus(String status)
	{
		this.status = status;
	}

	public String getListType()
	{
		return listType;
	}

	public void setListType(String listType)
	{
		this.listType = listType;
	}

	private static Map<Long, Configuration> bankRules = new HashMap<>();
	private static int bankRulesHashCode = bankRules.hashCode();
	private static Map<Long, Configuration> billerRules = new HashMap<>();
	private static int billerRulesHashCode = billerRules.hashCode();
	private static Map<Long, Configuration> sadadRules = new HashMap<>();
	private static int sadadRulesHashCode = sadadRules.hashCode();
	private static Map<Long, Configuration> aggregatorRules = new HashMap<>();
	private static int aggregatorRulesHashCode = aggregatorRules.hashCode();
	private static Map<Long, Configuration> subBillerRules = new HashMap<>();
	private static int subBillerRulesHashCode = subBillerRules.hashCode();

	public static int getBankRulesHashCode()
	{
		return bankRulesHashCode;
	}

	public static int getBillerRulesHashCode()
	{
		return billerRulesHashCode;
	}

	public static int getSadadRulesHashCode()
	{
		return sadadRulesHashCode;
	}

	public static int getAggregatorRulesHashCode()
	{
		return aggregatorRulesHashCode;
	}

	public static int getSubBillerRulesHashCode()
	{
		return subBillerRulesHashCode;
	}
	
	public static Map<Long, Configuration> getBankRules()
	{
		final String methodName = "getBankRules";
		if (CACHE_REFRESH_FLAG || bankRules.size() == 0)
		{
			try
			{
				bankRules = new HashMap<Long, Configuration>();
				callGetConfigurationList("BANK", null);
				CACHE_REFRESH_FLAG = false;
			}
			catch (PartnerConfigurationFault e)
			{
				logger.logp(Level.SEVERE, CLASS_NAME, methodName, e.getFaultInfo().getDescription());
				if (logger.isLoggable(Level.FINEST))
					e.printStackTrace();
			}
			catch (DatatypeConfigurationException e)
			{
				logger.logp(Level.SEVERE, CLASS_NAME, methodName, e.getMessage());
				if (logger.isLoggable(Level.FINEST))
					e.printStackTrace();
			}
			catch (Exception e)
			{
				logger.logp(Level.SEVERE, CLASS_NAME, methodName, e.getMessage());
				if (logger.isLoggable(Level.FINEST))
					e.printStackTrace();
			}
		}
		bankRulesHashCode = bankRules.hashCode();
		return bankRules;
	}

	public static Map<Long, Configuration> getBillerRules()
	{
		final String methodName = "getBillerRules";
		if (CACHE_REFRESH_FLAG || billerRules.size() == 0)
		{
			try
			{
				billerRules = new HashMap<Long, Configuration>();
				callGetConfigurationList("BILLER", null);
				CACHE_REFRESH_FLAG = false;
			}
			catch (PartnerConfigurationFault e)
			{
				logger.logp(Level.SEVERE, CLASS_NAME, methodName, e.getFaultInfo().getDescription());
				if (logger.isLoggable(Level.FINEST))
					e.printStackTrace();
			}
			catch (DatatypeConfigurationException e)
			{
				logger.logp(Level.SEVERE, CLASS_NAME, methodName, e.getMessage());
				if (logger.isLoggable(Level.FINEST))
					e.printStackTrace();
			}
			catch (Exception e)
			{
				logger.logp(Level.SEVERE, CLASS_NAME, methodName, e.getMessage());
				if (logger.isLoggable(Level.FINEST))
					e.printStackTrace();
			}
		}
		billerRulesHashCode = billerRules.hashCode();
		return billerRules;
	}
	
	public static Map<Long, Configuration> getSubBillerRules()
	{
		final String methodName = "getSubBillerRules";
		if (CACHE_REFRESH_FLAG || subBillerRules.size() == 0)
		{
			try
			{
				subBillerRules = new HashMap<Long, Configuration>();
				callGetConfigurationList("SUBBILLER", null);
				CACHE_REFRESH_FLAG = false;
			}
			catch (PartnerConfigurationFault e)
			{
				logger.logp(Level.SEVERE, CLASS_NAME, methodName, e.getFaultInfo().getDescription());
				if (logger.isLoggable(Level.FINEST))
					e.printStackTrace();
			}
			catch (DatatypeConfigurationException e)
			{
				logger.logp(Level.SEVERE, CLASS_NAME, methodName, e.getMessage());
				if (logger.isLoggable(Level.FINEST))
					e.printStackTrace();
			}
			catch (Exception e)
			{
				logger.logp(Level.SEVERE, CLASS_NAME, methodName, e.getMessage());
				if (logger.isLoggable(Level.FINEST))
					e.printStackTrace();
			}
		}
		subBillerRulesHashCode = subBillerRules.hashCode();
		return subBillerRules;
	}
	
	public static Map<Long, Configuration> getAggregatorRules()
	{
		final String methodName = "getAggregatorRules";
		if (CACHE_REFRESH_FLAG || aggregatorRules.size() == 0)
		{
			try
			{
				aggregatorRules = new HashMap<Long, Configuration>();
				callGetConfigurationList("AGGREGATOR", null);
				CACHE_REFRESH_FLAG = false;
			}
			catch (PartnerConfigurationFault e)
			{
				logger.logp(Level.SEVERE, CLASS_NAME, methodName, e.getFaultInfo().getDescription());
				if (logger.isLoggable(Level.FINEST))
					e.printStackTrace();
			}
			catch (DatatypeConfigurationException e)
			{
				logger.logp(Level.SEVERE, CLASS_NAME, methodName, e.getMessage());
				if (logger.isLoggable(Level.FINEST))
					e.printStackTrace();
			}
			catch (Exception e)
			{
				logger.logp(Level.SEVERE, CLASS_NAME, methodName, e.getMessage());
				if (logger.isLoggable(Level.FINEST))
					e.printStackTrace();
			}
		}
		aggregatorRulesHashCode = aggregatorRules.hashCode();
		return aggregatorRules;
	}
	
	public static Map<Long, Configuration> getSadadRules()
	{
		final String methodName = "getSadadRules";
		if (CACHE_REFRESH_FLAG || sadadRules.size() == 0)
		{
			try
			{
				sadadRules = new HashMap<Long, Configuration>();
				callGetConfigurationList("SADAD", null);
				CACHE_REFRESH_FLAG = false;
			}
			catch (PartnerConfigurationFault e)
			{
				logger.logp(Level.SEVERE, CLASS_NAME, methodName, e.getFaultInfo().getDescription());
				if (logger.isLoggable(Level.FINEST))
					e.printStackTrace();
			}
			catch (DatatypeConfigurationException e)
			{
				logger.logp(Level.SEVERE, CLASS_NAME, methodName, e.getMessage());
				if (logger.isLoggable(Level.FINEST))
					e.printStackTrace();
			}
			catch (Exception e)
			{
				logger.logp(Level.SEVERE, CLASS_NAME, methodName, e.getMessage());
				if (logger.isLoggable(Level.FINEST))
					e.printStackTrace();
			}
		}
		sadadRulesHashCode = sadadRules.hashCode();
		return sadadRules;
	}

	public static void callGetConfigurationList(String configType, String configName) throws DatatypeConfigurationException, PartnerConfigurationFault
	{
		final String methodName = "callGetConfigurationByType";
		logger.entering(CLASS_NAME, methodName);

		GetConfigurationRqType req = new GetConfigurationRqType();
		req.setMessageHeader(getMessageHeaderType("PARTNER_CONFIGURATION_BY_TYPE"));
		req.setConfigurationType(configType.toUpperCase());
		if(configName != null)
			req.setConfigurationName(configName);
		GetConfigurationRsType res = partnerConfigService.getConfiguration(req);

		for (ConfigurationType ct : res.getConfiguration())
		{
			Configuration c = new Configuration();
			c.setConfigId(ct.getId());
			c.setConfigName(ct.getName());
			c.setDescription(ct.getDescription());
			c.setStatus(ct.getStatus().value());
			// Configuration Attributes
			for (ConfigurationAttributeType cat : ct.getAttributes())
			{
				ConfigAttribute ca = new ConfigAttribute();
				ca.setAttribId(cat.getId());
				ca.setAttribName(cat.getName());
				ca.setDescription(cat.getDescription());
				ca.setDefaultValue(cat.getDefaultValue());
				ca.setTemplateIdentifier(cat.isIsTemplateIdentifier());
				ca.setMandatory(cat.isIsMandatory());
				ca.setValidationExpression(cat.getValidationExp());
				for (String pv : cat.getPossibleValue())
					ca.getPossibleValues().add(pv);

				c.getAttributes().put(cat.getId(), ca);
			}

			// Template Data
			if (ct.getTemplatesData() != null)
			{
				TemplateData td = new TemplateData();
				ConfigurationTemplateDataType ctdt = ct.getTemplatesData();
				td.setTemplateIdentifier(ctdt.getIdentifierName());
				for (String iv : ctdt.getIdentifiers())
					td.getIdentifierValues().add(iv);

				for (ConfigurationTemplateType ctt : ctdt.getTemplates())
				{
					Template t = new Template();
					t.setTemplateId(ctt.getId());
					t.setTemplateName(ctt.getTemplateName());
					t.setDescription(ctt.getDescription());
					t.setStatus(ctt.getStatus().value());

					for (TemplateAttributeType tat : ctt.getAttributes())
					{
						ConfigAttribute ca = new ConfigAttribute();
						ca.setConfigAttribId(tat.getId());
						ca.setAttribId(tat.getAttributeId());
						ca.setAttribName(tat.getAttributeName());
						ca.setDefaultValue(tat.getValue());
						ca.setStatus(tat.getStatus().value());
						t.getTemplateAttributes().put(ca.getAttribId(), ca);
					}
					td.getTemplates().put(t.getTemplateId(), t);
				}
				c.setTemplateData(td);
			}

			if (configType.equalsIgnoreCase(PortalConstant.PARTNER_TYPE_BANK))
			{
				bankRules.put(c.getConfigId(), c);
				bankRulesHashCode = bankRules.hashCode();
			}
			else if (configType.equalsIgnoreCase(PortalConstant.PARTNER_TYPE_BILLER))
			{
				billerRules.put(c.getConfigId(), c);
				billerRulesHashCode = billerRules.hashCode();
			}
			else if (configType.equalsIgnoreCase(PortalConstant.PARTNER_TYPE_SADAD))
			{
				sadadRules.put(c.getConfigId(), c);
				sadadRulesHashCode = sadadRules.hashCode();
			}
			else if (configType.equalsIgnoreCase(PortalConstant.PARTNER_TYPE_AGGREGATOR))
			{
				aggregatorRules.put(c.getConfigId(), c);
				aggregatorRulesHashCode = aggregatorRules.hashCode();
			}
			else if (configType.equalsIgnoreCase(PortalConstant.PARTNER_TYPE_SUBBILLER))
			{
				subBillerRules.put(c.getConfigId(), c);
				subBillerRulesHashCode = subBillerRules.hashCode();
			}
		}
		logger.exiting(CLASS_NAME, methodName);
	}

	public static Map<Long, Configuration> updteBusinessRulesListCache(BusinessRulesListCache brlc, String listType)
	{
		if(listType.equalsIgnoreCase(PortalConstant.LOOKUP_BANK_RULES_LIST))
		{
			Configuration c = bankRules.get(brlc.getConfigId());
			if(brlc.getTemplateId() > 0 )
			{
				Template t = c.getTemplateData().getTemplates().get(brlc.getTemplateId());
				t.setStatus(brlc.getStatus());
				c.getTemplateData().getTemplates().put(brlc.getTemplateId(), t);
			}
			else
				c.setStatus(brlc.getStatus());
			
			bankRules.put(brlc.getConfigId(), c);
			bankRulesHashCode = bankRules.hashCode();
			return bankRules;
		}			
		else if(listType.equalsIgnoreCase(PortalConstant.LOOKUP_BILLER_RULES_LIST))
		{
			Configuration c = billerRules.get(brlc.getConfigId());
			if(brlc.getTemplateId() > 0 )
			{
				Template t = c.getTemplateData().getTemplates().get(brlc.getTemplateId());
				t.setStatus(brlc.getStatus());
				c.getTemplateData().getTemplates().put(brlc.getTemplateId(), t);
			}
			else
				c.setStatus(brlc.getStatus());
			
			billerRules.put(brlc.getConfigId(), c);
			billerRulesHashCode = billerRules.hashCode();
			return billerRules;
		}
		else if(listType.equalsIgnoreCase(PortalConstant.LOOKUP_SADAD_RULES_LIST))
		{
			Configuration c = sadadRules.get(brlc.getConfigId());
			if(brlc.getTemplateId() > 0 )
			{
				Template t = c.getTemplateData().getTemplates().get(brlc.getTemplateId());
				t.setStatus(brlc.getStatus());
				c.getTemplateData().getTemplates().put(brlc.getTemplateId(), t);
			}
			else
				c.setStatus(brlc.getStatus());
			
			sadadRules.put(brlc.getConfigId(), c);
			sadadRulesHashCode = sadadRules.hashCode();
			return sadadRules;
		}
		else if(listType.equalsIgnoreCase(PortalConstant.LOOKUP_AGGREGATOR_RULES_LIST))
		{
			Configuration c = aggregatorRules.get(brlc.getConfigId());
			if(brlc.getTemplateId() > 0 )
			{
				Template t = c.getTemplateData().getTemplates().get(brlc.getTemplateId());
				t.setStatus(brlc.getStatus());
				c.getTemplateData().getTemplates().put(brlc.getTemplateId(), t);
			}
			else
				c.setStatus(brlc.getStatus());
			
			aggregatorRules.put(brlc.getConfigId(), c);
			aggregatorRulesHashCode = aggregatorRules.hashCode();
			return aggregatorRules;
		}
		else if(listType.equalsIgnoreCase(PortalConstant.LOOKUP_SUBBILLER_RULES_LIST))
		{
			Configuration c = subBillerRules.get(brlc.getConfigId());
			if(brlc.getTemplateId() > 0 )
			{
				Template t = c.getTemplateData().getTemplates().get(brlc.getTemplateId());
				t.setStatus(brlc.getStatus());
				c.getTemplateData().getTemplates().put(brlc.getTemplateId(), t);
			}
			else
				c.setStatus(brlc.getStatus());
			
			subBillerRules.put(brlc.getConfigId(), c);
			subBillerRulesHashCode = subBillerRules.hashCode();
			return subBillerRules;
		}
		return Collections.emptyMap();
	}
}