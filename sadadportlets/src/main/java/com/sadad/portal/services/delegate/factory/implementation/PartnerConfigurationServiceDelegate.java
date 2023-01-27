package com.sadad.portal.services.delegate.factory.implementation;

import com.sadad.ebpp.scm.schema.partnerconfigurationservice._1.ActivateConfigurationRqType;
import com.sadad.ebpp.scm.schema.partnerconfigurationservice._1.ActivateConfigurationRsType;
import com.sadad.ebpp.scm.schema.partnerconfigurationservice._1.ActivateConfigurationTemplateRqType;
import com.sadad.ebpp.scm.schema.partnerconfigurationservice._1.ActivateConfigurationTemplateRsType;
import com.sadad.ebpp.scm.schema.partnerconfigurationservice._1.CreateConfigurationTemplateRqType;
import com.sadad.ebpp.scm.schema.partnerconfigurationservice._1.CreateConfigurationTemplateRsType;
import com.sadad.ebpp.scm.schema.partnerconfigurationservice._1.DeactivateConfigurationRqType;
import com.sadad.ebpp.scm.schema.partnerconfigurationservice._1.DeactivateConfigurationRsType;
import com.sadad.ebpp.scm.schema.partnerconfigurationservice._1.DeactivateConfigurationTemplateRqType;
import com.sadad.ebpp.scm.schema.partnerconfigurationservice._1.DeactivateConfigurationTemplateRsType;
import com.sadad.ebpp.scm.schema.partnerconfigurationservice._1.GetConfigurationRqType;
import com.sadad.ebpp.scm.schema.partnerconfigurationservice._1.GetConfigurationRsType;
import com.sadad.ebpp.wsdl.partnerconfigurationservice._1.PartnerConfigurationFault;
import com.sadad.portal.common.utils.RequestResponseLogger;

public interface PartnerConfigurationServiceDelegate  extends RequestResponseLogger
{
	public GetConfigurationRsType getConfiguration(GetConfigurationRqType getConfigurationRq) throws PartnerConfigurationFault;

	public CreateConfigurationTemplateRsType createConfigurationTemplate(CreateConfigurationTemplateRqType createConfigurationTemplateRq) throws PartnerConfigurationFault;

	public ActivateConfigurationRsType activateConfiguration(ActivateConfigurationRqType activateConfigurationRq) throws PartnerConfigurationFault;

	public DeactivateConfigurationRsType deactivateConfiguration(DeactivateConfigurationRqType deactivateConfigurationRq) throws PartnerConfigurationFault;

	public ActivateConfigurationTemplateRsType activateConfigurationTemplate(ActivateConfigurationTemplateRqType activateConfigurationTemplateRq) throws PartnerConfigurationFault;

	public DeactivateConfigurationTemplateRsType deactivateConfigurationTemplate(DeactivateConfigurationTemplateRqType deactivateConfigurationTemplateRq) throws PartnerConfigurationFault;
}
