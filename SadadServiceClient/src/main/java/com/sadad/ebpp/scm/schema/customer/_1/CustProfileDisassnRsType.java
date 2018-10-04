//
// Generated By:JAX-WS RI IBM 2.2.1-11/25/2013 11:48 AM(foreman)- (JAXB RI IBM 2.2.3-11/25/2013 12:35 PM(foreman)-)
//


package com.sadad.ebpp.scm.schema.customer._1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import com.sadad.scm.common._1.BaseType;
import com.sadad.scm.common._1.PartyType;
import com.sadad.scm.common._1.StatusType;


/**
 * Customer Profile Association Response 
 * 
 * <p>Java class for CustProfileDisassnRs_Type complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CustProfileDisassnRs_Type">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.sadad.com/scm/Common/1.0}BaseType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.sadad.com/scm/Common/1.0}Status"/>
 *         &lt;element ref="{http://www.sadad.com/scm/Common/1.0}Payor"/>
 *         &lt;element ref="{http://www.sadad.com/EBPP/scm/schema/Customer/1.0}AccountDisassnStatus" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CustProfileDisassnRs_Type", propOrder = {
    "status",
    "payor",
    "accountDisassnStatus"
})
public class CustProfileDisassnRsType
    extends BaseType
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(name = "Status", namespace = "http://www.sadad.com/scm/Common/1.0", required = true)
    protected StatusType status;
    @XmlElement(name = "Payor", namespace = "http://www.sadad.com/scm/Common/1.0", required = true)
    protected PartyType payor;
    @XmlElement(name = "AccountDisassnStatus", required = true)
    protected List<AccountAssnStatusType> accountDisassnStatus;

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link StatusType }
     *     
     */
    public StatusType getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link StatusType }
     *     
     */
    public void setStatus(StatusType value) {
        this.status = value;
    }

    /**
     * Gets the value of the payor property.
     * 
     * @return
     *     possible object is
     *     {@link PartyType }
     *     
     */
    public PartyType getPayor() {
        return payor;
    }

    /**
     * Sets the value of the payor property.
     * 
     * @param value
     *     allowed object is
     *     {@link PartyType }
     *     
     */
    public void setPayor(PartyType value) {
        this.payor = value;
    }

    /**
     * Gets the value of the accountDisassnStatus property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the accountDisassnStatus property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAccountDisassnStatus().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AccountAssnStatusType }
     * 
     * 
     */
    public List<AccountAssnStatusType> getAccountDisassnStatus() {
        if (accountDisassnStatus == null) {
            accountDisassnStatus = new ArrayList<AccountAssnStatusType>();
        }
        return this.accountDisassnStatus;
    }

}
