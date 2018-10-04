//
// Generated By:JAX-WS RI IBM 2.2.1-11/28/2011 08:28 AM(foreman)- (JAXB RI IBM 2.2.3-11/28/2011 06:21 AM(foreman)-)
//


package com.sadad.ebpp.scm.schema.partnerprofileservice._1;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PartnerServiceSubscriptionsType_Type complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PartnerServiceSubscriptionsType_Type">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.sadad.com/scm/Common/1.0}PartnerKey"/>
 *         &lt;element ref="{http://www.sadad.com/EBPP/scm/schema/PartnerProfileService/1.0}ServiceID"/>
 *         &lt;element name="Subscribed" type="{http://www.sadad.com/scm/Common/System/1.0}C32_SType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PartnerServiceSubscriptionsType_Type", propOrder = {
    "partnerKey",
    "serviceID",
    "subscribed"
})
public class PartnerServiceSubscriptionsTypeType
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(name = "PartnerKey", namespace = "http://www.sadad.com/scm/Common/1.0", required = true)
    protected String partnerKey;
    @XmlElement(name = "ServiceID", required = true)
    protected String serviceID;
    @XmlElement(name = "Subscribed", required = true)
    protected String subscribed;

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
     * Gets the value of the serviceID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getServiceID() {
        return serviceID;
    }

    /**
     * Sets the value of the serviceID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setServiceID(String value) {
        this.serviceID = value;
    }

    /**
     * Gets the value of the subscribed property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubscribed() {
        return subscribed;
    }

    /**
     * Sets the value of the subscribed property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubscribed(String value) {
        this.subscribed = value;
    }

}
