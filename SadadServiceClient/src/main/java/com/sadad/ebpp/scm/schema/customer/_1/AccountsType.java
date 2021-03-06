//
// Generated By:JAX-WS RI IBM 2.2.1-11/25/2013 11:48 AM(foreman)- (JAXB RI IBM 2.2.3-11/25/2013 12:35 PM(foreman)-)
//


package com.sadad.ebpp.scm.schema.customer._1;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import com.sadad.scm.common._1.AccountIdType;


/**
 * <p>Java class for Accounts_Type complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Accounts_Type">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.sadad.com/scm/Common/1.0}RecordNumber"/>
 *         &lt;element ref="{http://www.sadad.com/scm/Common/1.0}Account"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Accounts_Type", propOrder = {
    "recordNumber",
    "account"
})
public class AccountsType
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(name = "RecordNumber", namespace = "http://www.sadad.com/scm/Common/1.0")
    protected long recordNumber;
    @XmlElement(name = "Account", namespace = "http://www.sadad.com/scm/Common/1.0", required = true)
    protected AccountIdType account;

    /**
     * Gets the value of the recordNumber property.
     * 
     */
    public long getRecordNumber() {
        return recordNumber;
    }

    /**
     * Sets the value of the recordNumber property.
     * 
     */
    public void setRecordNumber(long value) {
        this.recordNumber = value;
    }

    /**
     * Gets the value of the account property.
     * 
     * @return
     *     possible object is
     *     {@link AccountIdType }
     *     
     */
    public AccountIdType getAccount() {
        return account;
    }

    /**
     * Sets the value of the account property.
     * 
     * @param value
     *     allowed object is
     *     {@link AccountIdType }
     *     
     */
    public void setAccount(AccountIdType value) {
        this.account = value;
    }

}
