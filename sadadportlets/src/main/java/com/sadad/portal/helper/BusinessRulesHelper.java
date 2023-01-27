package com.sadad.portal.helper;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.sadad.ebpp.scm.schema.partnerconfigurationservice._1.ActivateConfigurationRqType;
import com.sadad.ebpp.scm.schema.partnerconfigurationservice._1.ActivateConfigurationTemplateRqType;
import com.sadad.ebpp.scm.schema.partnerconfigurationservice._1.CreateConfigurationTemplateRqType;
import com.sadad.ebpp.scm.schema.partnerconfigurationservice._1.DeactivateConfigurationRqType;
import com.sadad.ebpp.scm.schema.partnerconfigurationservice._1.DeactivateConfigurationTemplateRqType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.CreatePartnerConfigurationRequestType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.DeletePartnerConfigurationRequestType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.GetPartnerConfigurationRequestType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.GetPartnerConfigurationResponseType;
import com.sadad.ebpp.scm.schema.partnerprofileservice._1.UpdatePartnerConfigurationRequestType;
import com.sadad.ebpp.wsdl.partnerconfigurationservice._1.PartnerConfigurationFault;
import com.sadad.ebpp.wsdl.partnerprofileservice._1.PartnerProfileFaultMsg;
import com.sadad.portal.beans.BusinessRulesSessionDataBean;
import com.sadad.portal.beans.ConfigAttribute;
import com.sadad.portal.beans.PartnerConfiguration;
import com.sadad.portal.beans.Template;
import com.sadad.portal.common.cache.BusinessRulesListCache;
import com.sadad.portal.constant.PortalConstant;
import com.sadad.portal.services.client.helper.PortalServiceCallHelper;
import com.sadad.scm.common._1.ConfigurationStatusEnum;
import com.sadad.scm.common._1.ConfigurationTemplateDataType;
import com.sadad.scm.common._1.ConfigurationTemplateType;
import com.sadad.scm.common._1.ConfigurationType;
import com.sadad.scm.common._1.PartnerConfigurationAttributeType;
import com.sadad.scm.common._1.PartnerConfigurationAttributesType;
import com.sadad.scm.common._1.PartnerConfigurationTemplateType;
import com.sadad.scm.common._1.PartnerConfigurationType;
import com.sadad.scm.common._1.PartnerConfigurationsType;
import com.sadad.scm.common._1.TemplateAttributeType;
import com.sadad.scm.error._1.ErrorType;

public class BusinessRulesHelper extends PortalServiceCallHelper
{
	private final static String CLASS_NAME = BusinessRulesHelper.class.getName();
	private static final Logger logger = Logger.getLogger(CLASS_NAME);

	/**
	 * Calls the backend webservice to retrieve the partner configurations (business rules)
	 * 
	 * @param sesObj
	 * @return
	 */
	public BusinessRulesSessionDataBean callGetPartnerConfiguration(BusinessRulesSessionDataBean sesObj)
	{
		final String methodName = "callGetPartnerConfiguration";
		logger.entering(CLASS_NAME, methodName);

		try
		{
			GetPartnerConfigurationRequestType req = new GetPartnerConfigurationRequestType();
			req.setMessageHeader(getMessageHeaderType("GET_PARTNER_CONFIGURATION"));
			req.setPartnerKey(sesObj.getPartnerId());
			if(sesObj.getConfiguraitonName() != null)
				req.setConfigurationName(sesObj.getConfiguraitonName());
			req.setActiveOnly(true);
			req.setIncludePossibleValues(true);
			if(sesObj.getConfiguraitonName() == null) // Only clear for Initial Call, templates call should not clear the map
				sesObj.getPartnerConfiguration().clear(); // Initialize or Clear the configuration before service call for correct rendering

			GetPartnerConfigurationResponseType res = partnerProfileService.getPartnerConfiguration(req);
			for (PartnerConfigurationsType pct : res.getPartnerConfigurations())
			{
				ConfigurationType ct = pct.getConfiguration();
				PartnerConfiguration pc = new PartnerConfiguration();
				pc.setConfigId(ct.getId());
				pc.setConfigName(ct.getName());
				
				if(ct.getTemplatesData() != null)
				{
					ConfigurationTemplateDataType ctdt = ct.getTemplatesData();
					
					for (String iv : ctdt.getIdentifiers())
						pc.getIdentifierValues().add(iv);
				}

				for (PartnerConfigurationType pct1 : pct.getPartnerConfiguration())
				{
					// Attribute Based Configuration
					if (pct1.getAttributes() != null && pct1.getAttributes().getAttribute().size() > 0)
					{
						for (PartnerConfigurationAttributeType pcat : pct1.getAttributes().getAttribute())
						{
							// Update the Attribute with partner configured value and ID
							ConfigAttribute ca = new ConfigAttribute();
							ca.setConfigAttribId(pcat.getId());
							ca.setAttribId(pcat.getAttributeId());
							ca.setAttribName(pcat.getAttributeName());
							ca.setStatus(pcat.getStatus().value());
							for (String v : pcat.getValue())
							{
								ca.setConfiguredValue(v);
								pc.setConfigured("Configured");
							}
							
							if (pcat.getValue().size() > 1) // TODO - find out the multiple values issue and fix it
							{
								logger.logp(Level.ALL, CLASS_NAME, methodName, "Multiple values found against configuration attribute ", pcat.getAttributeName());
								logger.logp(Level.ALL, CLASS_NAME, methodName, "Multiple values found against configuration attribute - Configuration Name ", pct1.getConfigurationName());
							}
							pc.getAttributes().put(ca.getAttribId(), ca);
						}
					}
					// Template Based Configuration
					if (pct1.getTemplate() != null)
					{
						Template tmp = new Template();
						tmp.setTemplateId(pct1.getTemplate().getTemplateId());
						tmp.setTemplateName(pct1.getTemplate().getTemplateName());
						tmp.setPartnerTemplateIdentifier(pct1.getTemplate().getIdentifier());
						tmp.setPartnerConfigTemplateId(pct1.getTemplate().getId());
						pc.setConfigured(tmp.getPartnerTemplateIdentifier());
						// Fix for defect # 4655 | tk = templateKey ==> Config Template ID ~ Partner Config Template ID
						String tk = Integer.toString(pc.getTemplates().size()) + "~" + Long.toString(tmp.getTemplateId()); 
						pc.getTemplates().put(tk, tmp);
					}
				}
				
				if(pc.getConfigured() == null)
					pc.setConfigured("Not Configured");
				sesObj.getPartnerConfiguration().put(pc.getConfigId(), pc);
			}
		}
		catch (PartnerProfileFaultMsg e)
		{
			// Ignore PartnerProfileFaultMsg and render the screen.
//			sesObj.transformS2ExceptionToS1(e.getFaultInfo());
//			if (sesObj.getMessageToDisplay().getMessageType() == null)
//				if (e.getFaultInfo().getType().equals(ErrorType.BUSINESS))
//					sesObj.setErrorMessage(e.getFaultInfo().getDescription());
//				else
//					sesObj.setGenericErrorMessage();

			logger.logp(Level.SEVERE, CLASS_NAME, methodName, e.getMessage());
			if (logger.isLoggable(Level.FINEST))
				e.printStackTrace();
		}
		catch (Exception e)
		{
			sesObj.setGenericErrorMessage();
			logger.logp(Level.SEVERE, CLASS_NAME, methodName, e.getMessage());
			if (logger.isLoggable(Level.FINEST))
				e.printStackTrace();
		}
		logger.exiting(CLASS_NAME, methodName);
		return sesObj;
	}
	
	/**
	 * Calls the backend webservice to create the partner configurations (business rules)
	 * 
	 * @param sesObj
	 * @return
	 */
	public BusinessRulesSessionDataBean callCreatePartnerConfiguration(BusinessRulesSessionDataBean sesObj)
	{
		final String methodName = "callCreatePartnerConfiguration";
		logger.entering(CLASS_NAME, methodName);

		try
		{
			CreatePartnerConfigurationRequestType req = new CreatePartnerConfigurationRequestType();
			req.setMessageHeader(getMessageHeaderType("CREATE_PARTNER_CONFIGURATION"));
			req.setPartnerKey(sesObj.getPartnerId());
			PartnerConfigurationType pct = new PartnerConfigurationType();
			pct.setConfigurationId(sesObj.getConfigrationKey());
			pct.setConfigurationName(sesObj.getConfiguraitonName());
			// Setting Attribute Based Configuration here
			if(sesObj.getConfigType().equals("ATTRIBUTE Based"))
			{
				PartnerConfigurationAttributesType pcat = new PartnerConfigurationAttributesType();
				for (String r : sesObj.getPartnerConfigValues().split(BusinessRulesSessionDataBean.PARTNER_CONFIG_RECORD_SEPARATOR))
				{
					PartnerConfigurationAttributeType pcatt = new PartnerConfigurationAttributeType();
					String[] f = r.split(BusinessRulesSessionDataBean.PARTNER_CONFIG_FIELD_SEPARATOR);
					pcatt.setAttributeId(Long.valueOf(f[0]));
					pcatt.setAttributeName(f[1]);
					try // Ignore the attributes without values / unconfigured
					{
						pcatt.getValue().add(f[2]);
						pcat.getAttribute().add(pcatt);
					}
					catch (ArrayIndexOutOfBoundsException e)
					{/* Ignore the attributes without values / unconfigured */}
				}
				pct.setAttributes(pcat);
			}
			else // Setting Template Based Configuration here
			{
				PartnerConfigurationTemplateType pctt = new PartnerConfigurationTemplateType();
				pctt.setIdentifier(sesObj.getIdentifier());
				// Extracting values from 
				int i = sesObj.getPartnerConfigValues().indexOf('@');
				pctt.setTemplateId(Long.valueOf(sesObj.getPartnerConfigValues().substring(0, i)));
				pctt.setTemplateName(sesObj.getPartnerConfigValues().substring(i+1));
				pct.setTemplate(pctt);
			}
			req.setPartnerConfiguration(pct);
			partnerProfileService.createPartnerConfiguration(req);
			sesObj = callGetPartnerConfiguration(sesObj); // To reflects the update on the web page
		}
		catch (PartnerProfileFaultMsg e)
		{
			sesObj.transformS2ExceptionToS1(e.getFaultInfo());
			if (sesObj.getMessageToDisplay().getMessageType() == null)
				if (e.getFaultInfo().getType().equals(ErrorType.BUSINESS))
					sesObj.setErrorMessage(e.getFaultInfo().getDescription());
				else
					sesObj.setGenericErrorMessage();

			logger.logp(Level.SEVERE, CLASS_NAME, methodName, e.getMessage());
			if (logger.isLoggable(Level.FINEST))
				e.printStackTrace();
		}
		catch (Exception e)
		{
			sesObj.setGenericErrorMessage();
			logger.logp(Level.SEVERE, CLASS_NAME, methodName, e.getMessage());
			if (logger.isLoggable(Level.FINEST))
				e.printStackTrace();
		}
		logger.exiting(CLASS_NAME, methodName);
		return sesObj;
	}
	
	/**
	 * Calls the backend webservice to update the partner configurations (business rules)
	 * 
	 * @param sesObj
	 * @return
	 */
	public BusinessRulesSessionDataBean callUpdatePartnerConfiguration(BusinessRulesSessionDataBean sesObj)
	{
		final String methodName = "callUpdatePartnerConfiguration";
		logger.entering(CLASS_NAME, methodName);

		try
		{
			UpdatePartnerConfigurationRequestType req = new UpdatePartnerConfigurationRequestType();
			req.setMessageHeader(getMessageHeaderType("UPDATE_PARTNER_CONFIGURATION"));
			req.setPartnerKey(sesObj.getPartnerId());
			PartnerConfigurationType pct = new PartnerConfigurationType();
			pct.setConfigurationId(sesObj.getConfigrationKey());
			pct.setConfigurationName(sesObj.getConfiguraitonName());
			// There is no Update in case of Template, so only process Attribute Based Configuration here.
			PartnerConfigurationAttributesType pcat = new PartnerConfigurationAttributesType();
			for(String r : sesObj.getPartnerConfigValues().split(BusinessRulesSessionDataBean.PARTNER_CONFIG_RECORD_SEPARATOR))
			{
				PartnerConfigurationAttributeType pcatt = new PartnerConfigurationAttributeType();
				String[] f = r.split(BusinessRulesSessionDataBean.PARTNER_CONFIG_FIELD_SEPARATOR);
				if (sesObj.getPartnerConfiguration().get(sesObj.getConfigrationKey()).getAttributes().get(Long.valueOf(f[0])) != null)
					pcatt.setId(sesObj.getPartnerConfiguration().get(sesObj.getConfigrationKey()).getAttributes().get(Long.valueOf(f[0])).getConfigAttribId());
				pcatt.setAttributeId(Long.valueOf(f[0]));
				pcatt.setAttributeName(f[1]);
				try // Ignore the attributes without values / unconfigured
				{
					pcatt.getValue().add(f[2]);
					pcat.getAttribute().add(pcatt);
				}
				catch (ArrayIndexOutOfBoundsException e)
				{/* Ignore the attributes without values / unconfigured */}
			}
			pct.setAttributes(pcat);
			req.setPartnerConfiguration(pct);
			partnerProfileService.updatePartnerConfiguration(req);
			sesObj = callGetPartnerConfiguration(sesObj); // To reflects the update on the web page
		}
		catch (PartnerProfileFaultMsg e)
		{
			sesObj.transformS2ExceptionToS1(e.getFaultInfo());
			if (sesObj.getMessageToDisplay().getMessageType() == null)
				if (e.getFaultInfo().getType().equals(ErrorType.BUSINESS))
					sesObj.setErrorMessage(e.getFaultInfo().getDescription());
				else
					sesObj.setGenericErrorMessage();

			logger.logp(Level.SEVERE, CLASS_NAME, methodName, e.getMessage());
			if (logger.isLoggable(Level.FINEST))
				e.printStackTrace();
		}
		catch (Exception e)
		{
			sesObj.setGenericErrorMessage();
			logger.logp(Level.SEVERE, CLASS_NAME, methodName, e.getMessage());
			if (logger.isLoggable(Level.FINEST))
				e.printStackTrace();
		}
		logger.exiting(CLASS_NAME, methodName);
		return sesObj;
	}
	
	/**
	 * Calls the backend webservice to delete the partner configurations (business rules)
	 * 
	 * @param sesObj
	 * @return
	 */
	public BusinessRulesSessionDataBean callDeletePartnerConfiguration(BusinessRulesSessionDataBean sesObj)
	{
		final String methodName = "callDeletePartnerConfiguration";
		logger.entering(CLASS_NAME, methodName);

		try
		{
			DeletePartnerConfigurationRequestType req = new DeletePartnerConfigurationRequestType();
			req.setMessageHeader(getMessageHeaderType("DELETE_PARTNER_CONFIGURATION"));
			req.setPartnerKey(sesObj.getPartnerId());
			req.setConfigurationName(sesObj.getConfiguraitonName());
			// UN-CONFIGURE button on Attribute Details page is not sending param_partnerConfigValues, so check NULL before checking indexOf @
			int i = sesObj.getPartnerConfigValues() != null ? sesObj.getPartnerConfigValues().indexOf('@') : -1; //sesObj.getPartnerConfigValues().indexOf('@');
			if(i < 0) // Deleting Attribute Based Partners Rule Configuration
			{
				partnerProfileService.deletePartnerConfiguration(req);
				sesObj.getPartnerConfiguration().remove(sesObj.getConfigrationKey());
			}
			else // Deleting Template Based Partners Rule Configuration
			{
				req.setPartnerConfigId(Long.valueOf(sesObj.getPartnerConfigValues().substring(i+1)));
				partnerProfileService.deletePartnerConfiguration(req);
				long tk = Long.parseLong(sesObj.getPartnerConfigValues().substring(0,i));
				Template t = sesObj.getPartnerConfiguration().get(sesObj.getConfigrationKey()).getTemplates().get(tk); // FIXME - Code smell, do some testing to fix this problem. 
				sesObj.getPartnerConfiguration().get(sesObj.getConfigrationKey()).getTemplates().remove(tk, t);
				sesObj = callGetPartnerConfiguration(sesObj); // To reflects the update on the web page
			}
		}
		catch (PartnerProfileFaultMsg e)
		{
			sesObj.transformS2ExceptionToS1(e.getFaultInfo());
			if (sesObj.getMessageToDisplay().getMessageType() == null)
				if (e.getFaultInfo().getType().equals(ErrorType.BUSINESS))
					sesObj.setErrorMessage(e.getFaultInfo().getDescription());
				else
					sesObj.setGenericErrorMessage();

			logger.logp(Level.SEVERE, CLASS_NAME, methodName, e.getMessage());
			if (logger.isLoggable(Level.FINEST))
				e.printStackTrace();
		}
		catch (Exception e)
		{
			sesObj.setGenericErrorMessage();
			logger.logp(Level.SEVERE, CLASS_NAME, methodName, e.getMessage());
			if (logger.isLoggable(Level.FINEST))
				e.printStackTrace();
		}
		logger.exiting(CLASS_NAME, methodName);
		return sesObj;
	}
	
	public BusinessRulesSessionDataBean callPartnerConfigurationActivateOrDeActivate(BusinessRulesSessionDataBean sesObj)
	{
		final String methodName = "callPartnerConfigurationActivateOrDeActivate";
		logger.entering(CLASS_NAME, methodName);

		try
		{
			String status = null;
			if (sesObj.getStatus().equalsIgnoreCase("ACTIVE"))
			{
				DeactivateConfigurationRqType req = new DeactivateConfigurationRqType();
				req.setMessageHeader(getMessageHeaderType("DEACTIVATE_PARTNER_CONFIGURATION"));
				req.setConfigurationName(sesObj.getConfiguraitonName());
				partnerConfigService.deactivateConfiguration(req);
				status = "INACTIVE";
			}
			else if (sesObj.getStatus().equalsIgnoreCase("INACTIVE"))
			{
				ActivateConfigurationRqType req = new ActivateConfigurationRqType();
				req.setMessageHeader(getMessageHeaderType("ACTIVATE_PARTNER_CONFIGURATION"));
				req.setConfigurationName(sesObj.getConfiguraitonName());
				partnerConfigService.activateConfiguration(req);
				status = "ACTIVE";
			}

			String listType = (sesObj.getOrganisationType().equalsIgnoreCase(PortalConstant.PARTNER_TYPE_SADAD) ? PortalConstant.LOOKUP_SADAD_RULES_LIST
					: (sesObj.getOrganisationType().equalsIgnoreCase(PortalConstant.PARTNER_TYPE_BANK) ? PortalConstant.LOOKUP_BANK_RULES_LIST
							: (sesObj.getOrganisationType().equalsIgnoreCase(PortalConstant.PARTNER_TYPE_BILLER) ? PortalConstant.LOOKUP_BILLER_RULES_LIST : "")));

			BusinessRulesListCache uplc = new BusinessRulesListCache(sesObj.getConfigrationKey(), 0, status, listType);
			sesObj.setCacheObj(uplc);
			sesObj.setCacheRefreshType(listType);
		}
		catch (PartnerConfigurationFault e)
		{
			sesObj.transformS2ExceptionToS1(e.getFaultInfo());
			if (sesObj.getMessageToDisplay().getMessageType() == null)
				if (e.getFaultInfo().getType().equals(ErrorType.BUSINESS))
					sesObj.setErrorMessage(e.getFaultInfo().getDescription());
				else
					sesObj.setGenericErrorMessage();

			logger.logp(Level.SEVERE, CLASS_NAME, methodName, e.getMessage());
			if (logger.isLoggable(Level.FINEST))
				e.printStackTrace();
		}
		catch (Exception e)
		{
			sesObj.setGenericErrorMessage();
			logger.logp(Level.SEVERE, CLASS_NAME, methodName, e.getMessage());
			if (logger.isLoggable(Level.FINEST))
				e.printStackTrace();
		}
		logger.exiting(CLASS_NAME, methodName);
		return sesObj;
	}
	
	public BusinessRulesSessionDataBean callPartnerConfigurationTemplateActivateOrDeActivate(BusinessRulesSessionDataBean sesObj)
	{
		final String methodName = "callPartnerConfigurationTemplateActivateOrDeActivate";
		logger.entering(CLASS_NAME, methodName);

		try
		{
			String status = null;
			int i = sesObj.getPartnerConfigValues().indexOf('@');
			long tid = Long.valueOf(sesObj.getPartnerConfigValues().substring(0, i));
			String tname = sesObj.getPartnerConfigValues().substring(i+1);
			
			if(sesObj.getStatus().equalsIgnoreCase("ACTIVE"))
			{
				DeactivateConfigurationTemplateRqType req = new DeactivateConfigurationTemplateRqType();
				req.setMessageHeader(getMessageHeaderType("DEACTIVATE_PARTNER_CONFIGURATION_TEMPLATE"));
				req.setConfigurationName(sesObj.getConfiguraitonName());
				req.setTemplateName(tname);
				partnerConfigService.deactivateConfigurationTemplate(req);
				status = "INACTIVE";
			}
			else if(sesObj.getStatus().equalsIgnoreCase("INACTIVE"))
			{
				ActivateConfigurationTemplateRqType req = new ActivateConfigurationTemplateRqType();
				req.setMessageHeader(getMessageHeaderType("ACTIVATE_PARTNER_CONFIGURATION_TEMPLATE"));
				req.setConfigurationName(sesObj.getConfiguraitonName());
				req.setTemplateName(tname);
				partnerConfigService.activateConfigurationTemplate(req);
				status = "ACTIVE";
			}
			else // in case user did not select any radio button choice the status will be null
				return sesObj;
			
			String listType = "";
			if (sesObj.getOrganisationType().equalsIgnoreCase(PortalConstant.PARTNER_TYPE_SADAD))
				listType = PortalConstant.LOOKUP_SADAD_RULES_LIST;
			else if (sesObj.getOrganisationType().equalsIgnoreCase(PortalConstant.PARTNER_TYPE_BANK))
				listType = PortalConstant.LOOKUP_BANK_RULES_LIST;
			else if (sesObj.getOrganisationType().equalsIgnoreCase(PortalConstant.PARTNER_TYPE_BILLER))
				listType = PortalConstant.LOOKUP_BILLER_RULES_LIST;

			BusinessRulesListCache uplc = new BusinessRulesListCache(sesObj.getConfigrationKey(), tid, status, listType);
			sesObj.setCacheObj(uplc);
			sesObj.setCacheRefreshType(listType);
		}
		catch (PartnerConfigurationFault e)
		{
			sesObj.transformS2ExceptionToS1(e.getFaultInfo());
			if (sesObj.getMessageToDisplay().getMessageType() == null)
				if (e.getFaultInfo().getType().equals(ErrorType.BUSINESS))
					sesObj.setErrorMessage(e.getFaultInfo().getDescription());
				else
					sesObj.setGenericErrorMessage();

			logger.logp(Level.SEVERE, CLASS_NAME, methodName, e.getMessage());
			if (logger.isLoggable(Level.FINEST))
				e.printStackTrace();
		}
		catch (Exception e)
		{
			sesObj.setGenericErrorMessage();
			logger.logp(Level.SEVERE, CLASS_NAME, methodName, e.getMessage());
			if (logger.isLoggable(Level.FINEST))
				e.printStackTrace();
		}
		logger.exiting(CLASS_NAME, methodName);
		return sesObj;
	}
	
	public BusinessRulesSessionDataBean callCreateConfigurationTemplate(BusinessRulesSessionDataBean sesObj)
	{
		final String methodName = "callCreateConfigurationTemplate";
		logger.entering(CLASS_NAME, methodName);

		try
		{
			CreateConfigurationTemplateRqType req = new CreateConfigurationTemplateRqType();
			req.setMessageHeader(getMessageHeaderType("CREATE_CONFIGURATION_TEMPLATE"));
			req.setConfigurationName(sesObj.getConfiguraitonName());

			ConfigurationTemplateType ctt = new ConfigurationTemplateType();
			ctt.setTemplateName(sesObj.getTemplateName());
			ctt.setDescription(sesObj.getTemplateDescription());
			ctt.setStatus(ConfigurationStatusEnum.INACTIVE);
			for (String r : sesObj.getPartnerConfigValues().split(BusinessRulesSessionDataBean.PARTNER_CONFIG_RECORD_SEPARATOR))
			{
				TemplateAttributeType tat = new TemplateAttributeType();
				String[] f = r.split(BusinessRulesSessionDataBean.PARTNER_CONFIG_FIELD_SEPARATOR);
				tat.setAttributeId(Long.valueOf(f[0]));
				tat.setAttributeName(f[1]);
				tat.setValue(f[2]);
				ctt.getAttributes().add(tat);
			}
			req.setConfigurationTemplate(ctt);
			partnerConfigService.createConfigurationTemplate(req);
			BusinessRulesListCache.callGetConfigurationList(sesObj.getOrganisationType(), sesObj.getConfiguraitonName());
		}
		catch (PartnerConfigurationFault e)
		{
			sesObj.transformS2ExceptionToS1(e.getFaultInfo());
			if (sesObj.getMessageToDisplay().getMessageType() == null)
				if (e.getFaultInfo().getType().equals(ErrorType.BUSINESS))
					sesObj.setErrorMessage(e.getFaultInfo().getDescription());
				else
					sesObj.setGenericErrorMessage();

			logger.logp(Level.SEVERE, CLASS_NAME, methodName, e.getMessage());
			if (logger.isLoggable(Level.FINEST))
				e.printStackTrace();
		}
		catch (Exception e)
		{
			sesObj.setGenericErrorMessage();
			logger.logp(Level.SEVERE, CLASS_NAME, methodName, e.getMessage());
			if (logger.isLoggable(Level.FINEST))
				e.printStackTrace();
		}
		logger.exiting(CLASS_NAME, methodName);
		return sesObj;
	}
	
	/**
	 * Clear session object from server and restore the Screen-->Container 1, partner, partner and user type values back in object
	 * 
	 * @param sesObj
	 * @return
	 */
	public BusinessRulesSessionDataBean clearSessionBeanObject(BusinessRulesSessionDataBean sesObj)
	{
		return super.clearSessionBeanObject(sesObj, sesObj.getClass());
	}
}