//
// Generated By:JAX-WS RI IBM 2.2.1-11/28/2011 08:28 AM(foreman)- (JAXB RI IBM 2.2.3-11/28/2011 06:21 AM(foreman)-)
//


package com.sadad.scm.common._1;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for BillAmountsData_Type complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BillAmountsData_Type">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="BillKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element ref="{http://www.sadad.com/scm/Common/1.0}BillType"/>
 *         &lt;element ref="{http://www.sadad.com/scm/Common/1.0}BillLifecycle"/>
 *         &lt;element ref="{http://www.sadad.com/scm/Common/1.0}GenerationDate" minOccurs="0"/>
 *         &lt;element ref="{http://www.sadad.com/scm/Common/1.0}ExpiryDate" minOccurs="0"/>
 *         &lt;element name="BillIdentifier" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element ref="{http://www.sadad.com/scm/Common/1.0}BillCategory"/>
 *         &lt;element ref="{http://www.sadad.com/scm/Common/1.0}MinPartialAmt" minOccurs="0"/>
 *         &lt;element ref="{http://www.sadad.com/scm/Common/1.0}BillAmounts"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BillAmountsData_Type", propOrder = {
    "billKey",
    "billType",
    "billLifecycle",
    "generationDate",
    "expiryDate",
    "billIdentifier",
    "billCategory",
    "minPartialAmt",
    "billAmounts"
})
public class BillAmountsDataType
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(name = "BillKey")
    protected long billKey;
    @XmlElement(name = "BillType", required = true)
    protected BillTypeEnums billType;
    @XmlElement(name = "BillLifecycle", required = true)
    protected BillLifecycleEnums billLifecycle;
    @XmlElement(name = "GenerationDate")
    protected XMLGregorianCalendar generationDate;
    @XmlElement(name = "ExpiryDate")
    protected XMLGregorianCalendar expiryDate;
    @XmlElement(name = "BillIdentifier", required = true)
    protected String billIdentifier;
    @XmlElement(name = "BillCategory", required = true)
    protected String billCategory;
    @XmlElement(name = "MinPartialAmt")
    protected BigDecimal minPartialAmt;
    @XmlElement(name = "BillAmounts", required = true)
    protected BillAmountsType billAmounts;

    /**
     * Gets the value of the billKey property.
     * 
     */
    public long getBillKey() {
        return billKey;
    }

    /**
     * Sets the value of the billKey property.
     * 
     */
    public void setBillKey(long value) {
        this.billKey = value;
    }

    /**
     * Gets the value of the billType property.
     * 
     * @return
     *     possible object is
     *     {@link BillTypeEnums }
     *     
     */
    public BillTypeEnums getBillType() {
        return billType;
    }

    /**
     * Sets the value of the billType property.
     * 
     * @param value
     *     allowed object is
     *     {@link BillTypeEnums }
     *     
     */
    public void setBillType(BillTypeEnums value) {
        this.billType = value;
    }

    /**
     * Gets the value of the billLifecycle property.
     * 
     * @return
     *     possible object is
     *     {@link BillLifecycleEnums }
     *     
     */
    public BillLifecycleEnums getBillLifecycle() {
        return billLifecycle;
    }

    /**
     * Sets the value of the billLifecycle property.
     * 
     * @param value
     *     allowed object is
     *     {@link BillLifecycleEnums }
     *     
     */
    public void setBillLifecycle(BillLifecycleEnums value) {
        this.billLifecycle = value;
    }

    /**
     * Gets the value of the generationDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getGenerationDate() {
        return generationDate;
    }

    /**
     * Sets the value of the generationDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setGenerationDate(XMLGregorianCalendar value) {
        this.generationDate = value;
    }

    /**
     * Gets the value of the expiryDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getExpiryDate() {
        return expiryDate;
    }

    /**
     * Sets the value of the expiryDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setExpiryDate(XMLGregorianCalendar value) {
        this.expiryDate = value;
    }

    /**
     * Gets the value of the billIdentifier property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBillIdentifier() {
        return billIdentifier;
    }

    /**
     * Sets the value of the billIdentifier property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBillIdentifier(String value) {
        this.billIdentifier = value;
    }

    /**
     * Gets the value of the billCategory property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBillCategory() {
        return billCategory;
    }

    /**
     * Sets the value of the billCategory property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBillCategory(String value) {
        this.billCategory = value;
    }

    /**
     * Gets the value of the minPartialAmt property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getMinPartialAmt() {
        return minPartialAmt;
    }

    /**
     * Sets the value of the minPartialAmt property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setMinPartialAmt(BigDecimal value) {
        this.minPartialAmt = value;
    }

    /**
     * Gets the value of the billAmounts property.
     * 
     * @return
     *     possible object is
     *     {@link BillAmountsType }
     *     
     */
    public BillAmountsType getBillAmounts() {
        return billAmounts;
    }

    /**
     * Sets the value of the billAmounts property.
     * 
     * @param value
     *     allowed object is
     *     {@link BillAmountsType }
     *     
     */
    public void setBillAmounts(BillAmountsType value) {
        this.billAmounts = value;
    }

}