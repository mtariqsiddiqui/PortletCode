//
// Generated By:JAX-WS RI IBM 2.2.1-11/28/2011 08:28 AM(foreman)- (JAXB RI IBM 2.2.3-11/28/2011 06:21 AM(foreman)-)
//


package com.sadad.ebpp.scm.schema.partnerconfigurationservice._1;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import com.sadad.scm.common._1.BaseType;
import com.sadad.scm.common._1.ConfigurationTemplateType;


/**
 * <p>Java class for UpdateConfigurationTemplateRq_Type complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="UpdateConfigurationTemplateRq_Type">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.sadad.com/scm/Common/1.0}BaseType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.sadad.com/scm/Common/1.0}ConfigurationName"/>
 *         &lt;element ref="{http://www.sadad.com/scm/Common/1.0}ConfigurationTemplate"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UpdateConfigurationTemplateRq_Type", propOrder = {
    "configurationName",
    "configurationTemplate"
})
public class UpdateConfigurationTemplateRqType
    extends BaseType
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(name = "ConfigurationName", namespace = "http://www.sadad.com/scm/Common/1.0", required = true)
    protected String configurationName;
    @XmlElement(name = "ConfigurationTemplate", namespace = "http://www.sadad.com/scm/Common/1.0", required = true)
    protected ConfigurationTemplateType configurationTemplate;

    /**
     * Gets the value of the configurationName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getConfigurationName() {
        return configurationName;
    }

    /**
     * Sets the value of the configurationName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setConfigurationName(String value) {
        this.configurationName = value;
    }

    /**
     * Gets the value of the configurationTemplate property.
     * 
     * @return
     *     possible object is
     *     {@link ConfigurationTemplateType }
     *     
     */
    public ConfigurationTemplateType getConfigurationTemplate() {
        return configurationTemplate;
    }

    /**
     * Sets the value of the configurationTemplate property.
     * 
     * @param value
     *     allowed object is
     *     {@link ConfigurationTemplateType }
     *     
     */
    public void setConfigurationTemplate(ConfigurationTemplateType value) {
        this.configurationTemplate = value;
    }

}
