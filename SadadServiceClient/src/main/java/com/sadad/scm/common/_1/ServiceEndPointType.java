//
// Generated By:JAX-WS RI IBM 2.2.1-11/28/2011 08:28 AM(foreman)- (JAXB RI IBM 2.2.3-11/28/2011 06:21 AM(foreman)-)
//


package com.sadad.scm.common._1;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * -Represents a Service End Point
 * 
 * <p>Java class for ServiceEndPoint_Type complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ServiceEndPoint_Type">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.sadad.com/scm/Common/1.0}PartnerKey"/>
 *         &lt;choice>
 *           &lt;element name="MQEndPoint" type="{http://www.sadad.com/scm/Common/1.0}MQEndPoint_Type"/>
 *           &lt;element name="SOAPEndPoint" type="{http://www.sadad.com/scm/Common/1.0}SOAPEndPoint_Type"/>
 *         &lt;/choice>
 *         &lt;element ref="{http://www.sadad.com/scm/Common/1.0}Platform" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ServiceEndPoint_Type", propOrder = {
    "partnerKey",
    "mqEndPoint",
    "soapEndPoint",
    "platform"
})
public class ServiceEndPointType
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(name = "PartnerKey", required = true)
    protected String partnerKey;
    @XmlElement(name = "MQEndPoint")
    protected MQEndPointType mqEndPoint;
    @XmlElement(name = "SOAPEndPoint")
    protected SOAPEndPointType soapEndPoint;
    @XmlElement(name = "Platform")
    protected PlatformSType platform;

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
     * Gets the value of the mqEndPoint property.
     * 
     * @return
     *     possible object is
     *     {@link MQEndPointType }
     *     
     */
    public MQEndPointType getMQEndPoint() {
        return mqEndPoint;
    }

    /**
     * Sets the value of the mqEndPoint property.
     * 
     * @param value
     *     allowed object is
     *     {@link MQEndPointType }
     *     
     */
    public void setMQEndPoint(MQEndPointType value) {
        this.mqEndPoint = value;
    }

    /**
     * Gets the value of the soapEndPoint property.
     * 
     * @return
     *     possible object is
     *     {@link SOAPEndPointType }
     *     
     */
    public SOAPEndPointType getSOAPEndPoint() {
        return soapEndPoint;
    }

    /**
     * Sets the value of the soapEndPoint property.
     * 
     * @param value
     *     allowed object is
     *     {@link SOAPEndPointType }
     *     
     */
    public void setSOAPEndPoint(SOAPEndPointType value) {
        this.soapEndPoint = value;
    }

    /**
     * Gets the value of the platform property.
     * 
     * @return
     *     possible object is
     *     {@link PlatformSType }
     *     
     */
    public PlatformSType getPlatform() {
        return platform;
    }

    /**
     * Sets the value of the platform property.
     * 
     * @param value
     *     allowed object is
     *     {@link PlatformSType }
     *     
     */
    public void setPlatform(PlatformSType value) {
        this.platform = value;
    }

}
