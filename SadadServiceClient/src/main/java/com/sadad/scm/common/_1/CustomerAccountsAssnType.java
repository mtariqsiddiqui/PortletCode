//
// Generated By:JAX-WS RI IBM 2.2.1-11/28/2011 08:28 AM(foreman)- (JAXB RI IBM 2.2.3-11/28/2011 06:21 AM(foreman)-)
//


package com.sadad.scm.common._1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Customer-Accounts association
 * 
 * <p>Java class for CustomerAccountsAssn_Type complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CustomerAccountsAssn_Type">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.sadad.com/scm/Common/1.0}Customer"/>
 *         &lt;element ref="{http://www.sadad.com/scm/Common/1.0}AssociatedAccount" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CustomerAccountsAssn_Type", propOrder = {
    "customer",
    "associatedAccount"
})
public class CustomerAccountsAssnType
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(name = "Customer", required = true)
    protected PartyType customer;
    @XmlElement(name = "AssociatedAccount")
    protected List<AssociatedAccountType> associatedAccount;

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
     * Gets the value of the associatedAccount property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the associatedAccount property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAssociatedAccount().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AssociatedAccountType }
     * 
     * 
     */
    public List<AssociatedAccountType> getAssociatedAccount() {
        if (associatedAccount == null) {
            associatedAccount = new ArrayList<AssociatedAccountType>();
        }
        return this.associatedAccount;
    }

}
