//
// Generated By:JAX-WS RI IBM 2.2.1-11/28/2011 08:28 AM(foreman)- (JAXB RI IBM 2.2.3-11/28/2011 06:21 AM(foreman)-)
//


package com.sadad.ebpp.scm.schema.partnerprofileservice._1;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import com.sadad.scm.common._1.BaseType;
import com.sadad.scm.common._1.PartnerConfigurationType;


/**
 * <p>Java class for CreatePartnerConfigurationRequest_Type complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CreatePartnerConfigurationRequest_Type">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.sadad.com/scm/Common/1.0}BaseType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.sadad.com/scm/Common/1.0}PartnerKey"/>
 *         &lt;element name="PartnerConfiguration" type="{http://www.sadad.com/scm/Common/1.0}PartnerConfiguration_Type"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CreatePartnerConfigurationRequest_Type", propOrder = {
    "partnerKey",
    "partnerConfiguration"
})
public class CreatePartnerConfigurationRequestType
    extends BaseType
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(name = "PartnerKey", namespace = "http://www.sadad.com/scm/Common/1.0", required = true)
    protected String partnerKey;
    @XmlElement(name = "PartnerConfiguration", required = true)
    protected PartnerConfigurationType partnerConfiguration;

    /**
     * Gets the value of the partnerKey property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPartnerKey() {
        return partnerKey;
    }

    /**
     * Sets the value of the partnerKey property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPartnerKey(String value) {
        this.partnerKey = value;
    }

    /**
     * Gets the value of the partnerConfiguration property.
     * 
     * @return
     *     possible object is
     *     {@link PartnerConfigurationType }
     *     
     */
    public PartnerConfigurationType getPartnerConfiguration() {
        return partnerConfiguration;
    }

    /**
     * Sets the value of the partnerConfiguration property.
     * 
     * @param value
     *     allowed object is
     *     {@link PartnerConfigurationType }
     *     
     */
    public void setPartnerConfiguration(PartnerConfigurationType value) {
        this.partnerConfiguration = value;
    }

}
