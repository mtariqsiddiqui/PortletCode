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
 * -Represents a Bank in SADAD systems   
 * 
 * <p>Java class for BankSummary_Type complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BankSummary_Type">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.sadad.com/scm/Common/1.0}Partner_Type">
 *       &lt;sequence>
 *         &lt;element name="SARIEBankKey" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BankSummary_Type", propOrder = {
    "sarieBankKey"
})
public class BankSummaryType
    extends PartnerType
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(name = "SARIEBankKey")
    protected String sarieBankKey;

    /**
     * Gets the value of the sarieBankKey property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSARIEBankKey() {
        return sarieBankKey;
    }

    /**
     * Sets the value of the sarieBankKey property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSARIEBankKey(String value) {
        this.sarieBankKey = value;
    }

}
