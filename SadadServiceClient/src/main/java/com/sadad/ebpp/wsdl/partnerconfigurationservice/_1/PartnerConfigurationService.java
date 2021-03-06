//
// Generated By:JAX-WS RI IBM 2.2.1-11/28/2011 08:28 AM(foreman)- (JAXB RI IBM 2.2.3-11/28/2011 06:21 AM(foreman)-)
//


package com.sadad.ebpp.wsdl.partnerconfigurationservice._1;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;
import com.sadad.ebpp.scm.schema.partnerconfigurationservice._1.ActivateConfigurationRqType;
import com.sadad.ebpp.scm.schema.partnerconfigurationservice._1.ActivateConfigurationRsType;
import com.sadad.ebpp.scm.schema.partnerconfigurationservice._1.ActivateConfigurationTemplateRqType;
import com.sadad.ebpp.scm.schema.partnerconfigurationservice._1.ActivateConfigurationTemplateRsType;
import com.sadad.ebpp.scm.schema.partnerconfigurationservice._1.CreateConfigurationRqType;
import com.sadad.ebpp.scm.schema.partnerconfigurationservice._1.CreateConfigurationRsType;
import com.sadad.ebpp.scm.schema.partnerconfigurationservice._1.CreateConfigurationTemplateRqType;
import com.sadad.ebpp.scm.schema.partnerconfigurationservice._1.CreateConfigurationTemplateRsType;
import com.sadad.ebpp.scm.schema.partnerconfigurationservice._1.DeactivateConfigurationRqType;
import com.sadad.ebpp.scm.schema.partnerconfigurationservice._1.DeactivateConfigurationRsType;
import com.sadad.ebpp.scm.schema.partnerconfigurationservice._1.DeactivateConfigurationTemplateRqType;
import com.sadad.ebpp.scm.schema.partnerconfigurationservice._1.DeactivateConfigurationTemplateRsType;
import com.sadad.ebpp.scm.schema.partnerconfigurationservice._1.GetConfigurationRqType;
import com.sadad.ebpp.scm.schema.partnerconfigurationservice._1.GetConfigurationRsType;
import com.sadad.ebpp.scm.schema.partnerconfigurationservice._1.GetConfigurationTemplateRqType;
import com.sadad.ebpp.scm.schema.partnerconfigurationservice._1.GetConfigurationTemplateRsType;
import com.sadad.ebpp.scm.schema.partnerconfigurationservice._1.UpdateConfigurationRqType;
import com.sadad.ebpp.scm.schema.partnerconfigurationservice._1.UpdateConfigurationRsType;
import com.sadad.ebpp.scm.schema.partnerconfigurationservice._1.UpdateConfigurationTemplateRqType;
import com.sadad.ebpp.scm.schema.partnerconfigurationservice._1.UpdateConfigurationTemplateRsType;

@WebService(name = "PartnerConfigurationService", targetNamespace = "http://www.sadad.com/EBPP/wsdl/PartnerConfigurationService/1.0")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@XmlSeeAlso({
    com.sadad.scm.common._1.ObjectFactory.class,
    com.sadad.ebpp.scm.schema.partnerconfigurationservice._1.ObjectFactory.class,
    com.sadad.scm.error._1.ObjectFactory.class,
    com.sadad.scm.common.system._1.ObjectFactory.class
})
public interface PartnerConfigurationService {


    /**
     * 
     * @param getConfigurationRq
     * @return
     *     returns com.sadad.ebpp.scm.schema.partnerconfigurationservice._1.GetConfigurationRsType
     * @throws PartnerConfigurationFault
     */
    @WebMethod(operationName = "GetConfiguration", action = "http://www.sadad.com/EBPP/wsdl/PartnerConfigurationService/1.0/GetConfiguration")
    @WebResult(name = "GetConfigurationRs", targetNamespace = "http://www.sadad.com/EBPP/scm/schema/PartnerConfigurationService/1.0", partName = "GetConfigurationRs")
    public GetConfigurationRsType getConfiguration(
        @WebParam(name = "GetConfigurationRq", targetNamespace = "http://www.sadad.com/EBPP/scm/schema/PartnerConfigurationService/1.0", partName = "GetConfigurationRq")
        GetConfigurationRqType getConfigurationRq)
        throws PartnerConfigurationFault
    ;

    /**
     * 
     * @param createConfigurationRq
     * @return
     *     returns com.sadad.ebpp.scm.schema.partnerconfigurationservice._1.CreateConfigurationRsType
     * @throws PartnerConfigurationFault
     */
    @WebMethod(operationName = "CreateConfiguration", action = "http://www.sadad.com/EBPP/wsdl/PartnerConfigurationService/1.0/CreateConfiguration")
    @WebResult(name = "CreateConfigurationRs", targetNamespace = "http://www.sadad.com/EBPP/scm/schema/PartnerConfigurationService/1.0", partName = "CreateConfigurationRs")
    public CreateConfigurationRsType createConfiguration(
        @WebParam(name = "CreateConfigurationRq", targetNamespace = "http://www.sadad.com/EBPP/scm/schema/PartnerConfigurationService/1.0", partName = "CreateConfigurationRq")
        CreateConfigurationRqType createConfigurationRq)
        throws PartnerConfigurationFault
    ;

    /**
     * 
     * @param updateConfigurationRq
     * @return
     *     returns com.sadad.ebpp.scm.schema.partnerconfigurationservice._1.UpdateConfigurationRsType
     * @throws PartnerConfigurationFault
     */
    @WebMethod(operationName = "UpdateConfiguration", action = "http://www.sadad.com/EBPP/wsdl/PartnerConfigurationService/1.0/UpdateConfiguration")
    @WebResult(name = "UpdateConfigurationRs", targetNamespace = "http://www.sadad.com/EBPP/scm/schema/PartnerConfigurationService/1.0", partName = "UpdateConfigurationRs")
    public UpdateConfigurationRsType updateConfiguration(
        @WebParam(name = "UpdateConfigurationRq", targetNamespace = "http://www.sadad.com/EBPP/scm/schema/PartnerConfigurationService/1.0", partName = "UpdateConfigurationRq")
        UpdateConfigurationRqType updateConfigurationRq)
        throws PartnerConfigurationFault
    ;

    /**
     * 
     * @param activateConfigurationRq
     * @return
     *     returns com.sadad.ebpp.scm.schema.partnerconfigurationservice._1.ActivateConfigurationRsType
     * @throws PartnerConfigurationFault
     */
    @WebMethod(operationName = "ActivateConfiguration", action = "http://www.sadad.com/EBPP/wsdl/PartnerConfigurationService/1.0/ActivateConfiguration")
    @WebResult(name = "ActivateConfigurationRs", targetNamespace = "http://www.sadad.com/EBPP/scm/schema/PartnerConfigurationService/1.0", partName = "ActivateConfigurationRs")
    public ActivateConfigurationRsType activateConfiguration(
        @WebParam(name = "ActivateConfigurationRq", targetNamespace = "http://www.sadad.com/EBPP/scm/schema/PartnerConfigurationService/1.0", partName = "ActivateConfigurationRq")
        ActivateConfigurationRqType activateConfigurationRq)
        throws PartnerConfigurationFault
    ;

    /**
     * 
     * @param deactivateConfigurationRq
     * @return
     *     returns com.sadad.ebpp.scm.schema.partnerconfigurationservice._1.DeactivateConfigurationRsType
     * @throws PartnerConfigurationFault
     */
    @WebMethod(operationName = "DeactivateConfiguration", action = "http://www.sadad.com/EBPP/wsdl/PartnerConfigurationService/1.0/DeactivateConfiguration")
    @WebResult(name = "DeactivateConfigurationRs", targetNamespace = "http://www.sadad.com/EBPP/scm/schema/PartnerConfigurationService/1.0", partName = "DeactivateConfigurationRs")
    public DeactivateConfigurationRsType deactivateConfiguration(
        @WebParam(name = "DeactivateConfigurationRq", targetNamespace = "http://www.sadad.com/EBPP/scm/schema/PartnerConfigurationService/1.0", partName = "DeactivateConfigurationRq")
        DeactivateConfigurationRqType deactivateConfigurationRq)
        throws PartnerConfigurationFault
    ;

    /**
     * 
     * @param getConfigurationTemplateRq
     * @return
     *     returns com.sadad.ebpp.scm.schema.partnerconfigurationservice._1.GetConfigurationTemplateRsType
     * @throws PartnerConfigurationFault
     */
    @WebMethod(operationName = "GetConfigurationTemplate", action = "http://www.sadad.com/EBPP/wsdl/PartnerConfigurationService/1.0/GetConfigurationTemplate")
    @WebResult(name = "GetConfigurationTemplateRs", targetNamespace = "http://www.sadad.com/EBPP/scm/schema/PartnerConfigurationService/1.0", partName = "GetConfigurationTemplateRs")
    public GetConfigurationTemplateRsType getConfigurationTemplate(
        @WebParam(name = "GetConfigurationTemplateRq", targetNamespace = "http://www.sadad.com/EBPP/scm/schema/PartnerConfigurationService/1.0", partName = "GetConfigurationTemplateRq")
        GetConfigurationTemplateRqType getConfigurationTemplateRq)
        throws PartnerConfigurationFault
    ;

    /**
     * 
     * @param createConfigurationTemplateRq
     * @return
     *     returns com.sadad.ebpp.scm.schema.partnerconfigurationservice._1.CreateConfigurationTemplateRsType
     * @throws PartnerConfigurationFault
     */
    @WebMethod(operationName = "CreateConfigurationTemplate", action = "http://www.sadad.com/EBPP/wsdl/PartnerConfigurationService/1.0/CreateConfigurationTemplate")
    @WebResult(name = "CreateConfigurationTemplateRs", targetNamespace = "http://www.sadad.com/EBPP/scm/schema/PartnerConfigurationService/1.0", partName = "CreateConfigurationTemplateRs")
    public CreateConfigurationTemplateRsType createConfigurationTemplate(
        @WebParam(name = "CreateConfigurationTemplateRq", targetNamespace = "http://www.sadad.com/EBPP/scm/schema/PartnerConfigurationService/1.0", partName = "CreateConfigurationTemplateRq")
        CreateConfigurationTemplateRqType createConfigurationTemplateRq)
        throws PartnerConfigurationFault
    ;

    /**
     * 
     * @param updateConfigurationTemplateRq
     * @return
     *     returns com.sadad.ebpp.scm.schema.partnerconfigurationservice._1.UpdateConfigurationTemplateRsType
     * @throws PartnerConfigurationFault
     */
    @WebMethod(operationName = "UpdateConfigurationTemplate", action = "http://www.sadad.com/EBPP/wsdl/PartnerConfigurationService/1.0/UpdateConfigurationTemplate")
    @WebResult(name = "UpdateConfigurationTemplateRs", targetNamespace = "http://www.sadad.com/EBPP/scm/schema/PartnerConfigurationService/1.0", partName = "UpdateConfigurationTemplateRs")
    public UpdateConfigurationTemplateRsType updateConfigurationTemplate(
        @WebParam(name = "UpdateConfigurationTemplateRq", targetNamespace = "http://www.sadad.com/EBPP/scm/schema/PartnerConfigurationService/1.0", partName = "UpdateConfigurationTemplateRq")
        UpdateConfigurationTemplateRqType updateConfigurationTemplateRq)
        throws PartnerConfigurationFault
    ;

    /**
     * 
     * @param activateConfigurationTemplateRq
     * @return
     *     returns com.sadad.ebpp.scm.schema.partnerconfigurationservice._1.ActivateConfigurationTemplateRsType
     * @throws PartnerConfigurationFault
     */
    @WebMethod(operationName = "ActivateConfigurationTemplate", action = "http://www.sadad.com/EBPP/wsdl/PartnerConfigurationService/1.0/ActivateConfigurationTemplate")
    @WebResult(name = "ActivateConfigurationTemplateRs", targetNamespace = "http://www.sadad.com/EBPP/scm/schema/PartnerConfigurationService/1.0", partName = "ActivateConfigurationTemplateRs")
    public ActivateConfigurationTemplateRsType activateConfigurationTemplate(
        @WebParam(name = "ActivateConfigurationTemplateRq", targetNamespace = "http://www.sadad.com/EBPP/scm/schema/PartnerConfigurationService/1.0", partName = "ActivateConfigurationTemplateRq")
        ActivateConfigurationTemplateRqType activateConfigurationTemplateRq)
        throws PartnerConfigurationFault
    ;

    /**
     * 
     * @param deactivateConfigurationTemplateRq
     * @return
     *     returns com.sadad.ebpp.scm.schema.partnerconfigurationservice._1.DeactivateConfigurationTemplateRsType
     * @throws PartnerConfigurationFault
     */
    @WebMethod(operationName = "DeactivateConfigurationTemplate", action = "http://www.sadad.com/EBPP/wsdl/PartnerConfigurationService/1.0/DeactivateConfigurationTemplate")
    @WebResult(name = "DeactivateConfigurationTemplateRs", targetNamespace = "http://www.sadad.com/EBPP/scm/schema/PartnerConfigurationService/1.0", partName = "DeactivateConfigurationTemplateRs")
    public DeactivateConfigurationTemplateRsType deactivateConfigurationTemplate(
        @WebParam(name = "DeactivateConfigurationTemplateRq", targetNamespace = "http://www.sadad.com/EBPP/scm/schema/PartnerConfigurationService/1.0", partName = "DeactivateConfigurationTemplateRq")
        DeactivateConfigurationTemplateRqType deactivateConfigurationTemplateRq)
        throws PartnerConfigurationFault
    ;

}
