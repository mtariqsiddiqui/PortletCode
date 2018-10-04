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
 * <p>Java class for AssociatedCustomer_Type complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AssociatedCustomer_Type">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.sadad.com/scm/Common/1.0}Customer"/>
 *         &lt;element ref="{http://www.sadad.com/scm/Common/1.0}AssnType"/>
 *         &lt;element ref="{http://www.sadad.com/scm/Common/1.0}AssociatedBy"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AssociatedCustomer_Type", propOrder = {
    "customer",
    "assnType",
    "associatedBy"
})
public class AssociatedCustomerType
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(name = "Customer", required = true)
    protected PartyType customer;
    @XmlElement(name = "AssnType", required = true)
    protected AssnTypeEnum assnType;
    @XmlElement(name = "AssociatedBy", required = true)
    protected AssociatedByType associatedBy;

    /**
     * Gets the value of the customer property.
     * 
     * @return
     *     possible object is
     *     {@link PartyType }
     *     
     */
    public PartyType getCustomer() {
        return customer;
    }

    /**
     * Sets the value of the customer property.
     * 
     * @param value
     *     allowed object is
     *     {@link PartyType }
     *     
     */
    public void setCustomer(PartyType value) {
        this.customer = value;
    }

    /**
     * Gets the value of the assnType property.
     * 
     * @return
     *     possible object is
     *     {@link AssnTypeEnum }
     *     
     */
    public AssnTypeEnum getAssnType() {
        return assnType;
    }

    /**
     * Sets the value of the assnType property.
     * 
     * @param value
     *     allowed object is
     *     {@link AssnTypeEnum }
     *     
     */
    public void setAssnType(AssnTypeEnum value) {
        this.assnType = value;
    }

    /**
     * Gets the value of the associatedBy property.
     * 
     * @return
     *     possible object is
     *     {@link AssociatedByType }
     *     
     */
    public AssociatedByType getAssociatedBy() {
        return associatedBy;
    }

    /**
     * Sets the value of the associatedBy property.
     * 
     * @param value
     *     allowed object is
     *     {@link AssociatedByType }
     *     
     */
    public void setAssociatedBy(AssociatedByType value) {
        this.associatedBy = value;
    }

}
