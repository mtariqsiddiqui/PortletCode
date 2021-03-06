//
// Generated By:JAX-WS RI IBM 2.2.1-11/28/2011 08:28 AM(foreman)- (JAXB RI IBM 2.2.3-11/28/2011 06:21 AM(foreman)-)
//


package com.sadad.scm.common._1;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * -Represents a Biller in SADAD systems   
 * 
 * <p>Java class for BillerSummary_Type complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BillerSummary_Type">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.sadad.com/scm/Common/1.0}Partner_Type">
 *       &lt;sequence>
 *         &lt;element name="BillerVersion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BillerExpiryDate" type="{http://www.sadad.com/scm/Common/System/1.0}Date_SType"/>
 *         &lt;element name="SubscribeToHijri" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BillerSummary_Type", propOrder = {
    "billerVersion",
    "billerExpiryDate",
    "subscribeToHijri"
})
public class BillerSummaryType
    extends PartnerType
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(name = "BillerVersion")
    protected String billerVersion;
    @XmlElement(name = "BillerExpiryDate", required = true)
    protected XMLGregorianCalendar billerExpiryDate;
    @XmlElement(name = "SubscribeToHijri")
    protected boolean subscribeToHijri;

    /**
     * Gets the value of the billerVersion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBillerVersion() {
        return billerVersion;
    }

    /**
     * Sets the value of the billerVersion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBillerVersion(String value) {
        this.billerVersion = value;
    }

    /**
     * Gets the value of the billerExpiryDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getBillerExpiryDate() {
        return billerExpiryDate;
    }

    /**
     * Sets the value of the billerExpiryDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setBillerExpiryDate(XMLGregorianCalendar value) {
        this.billerExpiryDate = value;
    }

    /**
     * Gets the value of the subscribeToHijri property.
     * 
     */
    public boolean isSubscribeToHijri() {
        return subscribeToHijri;
    }

    /**
     * Sets the value of the subscribeToHijri property.
     * 
     */
    public void setSubscribeToHijri(boolean value) {
        this.subscribeToHijri = value;
    }

}
