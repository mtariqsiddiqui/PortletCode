//
// Generated By:JAX-WS RI IBM 2.2.1-11/25/2013 11:48 AM(foreman)- (JAXB RI IBM 2.2.3-11/25/2013 12:35 PM(foreman)-)
//


package com.sadad.schema.service.corepayment._1;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import com.sadad.scm.common._1.BaseType;
import com.sadad.scm.common._1.CustIdCType;
import com.sadad.scm.common._1.DateRangeCType;


/**
 * <p>Java class for ListByAccountRq_Type complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ListByAccountRq_Type">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.sadad.com/scm/Common/1.0}BaseType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.sadad.com/scm/Common/1.0}BankKey" minOccurs="0"/>
 *         &lt;element ref="{http://www.sadad.com/scm/Common/1.0}AccountKey"/>
 *         &lt;element ref="{http://www.sadad.com/scm/Common/1.0}BillerKey"/>
 *         &lt;element name="Payor" type="{http://www.sadad.com/scm/Common/1.0}CustId_CType" minOccurs="0"/>
 *         &lt;element name="Beneficiary" type="{http://www.sadad.com/scm/Common/1.0}CustId_CType" minOccurs="0"/>
 *         &lt;element ref="{http://www.sadad.com/scm/Common/1.0}Page" minOccurs="0"/>
 *         &lt;element name="DateRange" type="{http://www.sadad.com/scm/Common/1.0}DateRange_CType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ListByAccountRq_Type", propOrder = {
    "bankKey",
    "accountKey",
    "billerKey",
    "payor",
    "beneficiary",
    "page",
    "dateRange"
})
public class ListByAccountRqType
    extends BaseType
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(name = "BankKey", namespace = "http://www.sadad.com/scm/Common/1.0")
    protected String bankKey;
    @XmlElement(name = "AccountKey", namespace = "http://www.sadad.com/scm/Common/1.0", required = true)
    protected String accountKey;
    @XmlElement(name = "BillerKey", namespace = "http://www.sadad.com/scm/Common/1.0", required = true)
    protected String billerKey;
    @XmlElement(name = "Payor")
    protected CustIdCType payor;
    @XmlElement(name = "Beneficiary")
    protected CustIdCType beneficiary;
    @XmlElement(name = "Page", namespace = "http://www.sadad.com/scm/Common/1.0")
    protected Integer page;
    @XmlElement(name = "DateRange")
    protected DateRangeCType dateRange;

    /**
     * Gets the value of the bankKey property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBankKey() {
        return bankKey;
    }

    /**
     * Sets the value of the bankKey property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBankKey(String value) {
        this.bankKey = value;
    }

    /**
     * Gets the value of the accountKey property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAccountKey() {
        return accountKey;
    }

    /**
     * Sets the value of the accountKey property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccountKey(String value) {
        this.accountKey = value;
    }

    /**
     * Gets the value of the billerKey property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBillerKey() {
        return billerKey;
    }

    /**
     * Sets the value of the billerKey property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBillerKey(String value) {
        this.billerKey = value;
    }

    /**
     * Gets the value of the payor property.
     * 
     * @return
     *     possible object is
     *     {@link CustIdCType }
     *     
     */
    public CustIdCType getPayor() {
        return payor;
    }

    /**
     * Sets the value of the payor property.
     * 
     * @param value
     *     allowed object is
     *     {@link CustIdCType }
     *     
     */
    public void setPayor(CustIdCType value) {
        this.payor = value;
    }

    /**
     * Gets the value of the beneficiary property.
     * 
     * @return
     *     possible object is
     *     {@link CustIdCType }
     *     
     */
    public CustIdCType getBeneficiary() {
        return beneficiary;
    }

    /**
     * Sets the value of the beneficiary property.
     * 
     * @param value
     *     allowed object is
     *     {@link CustIdCType }
     *     
     */
    public void setBeneficiary(CustIdCType value) {
        this.beneficiary = value;
    }

    /**
     * Gets the value of the page property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getPage() {
        return page;
    }

    /**
     * Sets the value of the page property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setPage(Integer value) {
        this.page = value;
    }

    /**
     * Gets the value of the dateRange property.
     * 
     * @return
     *     possible object is
     *     {@link DateRangeCType }
     *     
     */
    public DateRangeCType getDateRange() {
        return dateRange;
    }

    /**
     * Sets the value of the dateRange property.
     * 
     * @param value
     *     allowed object is
     *     {@link DateRangeCType }
     *     
     */
    public void setDateRange(DateRangeCType value) {
        this.dateRange = value;
    }

}