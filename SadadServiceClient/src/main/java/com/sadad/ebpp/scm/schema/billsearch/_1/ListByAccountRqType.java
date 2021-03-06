//
// Generated By:JAX-WS RI IBM 2.2.1-11/25/2013 11:48 AM(foreman)- (JAXB RI IBM 2.2.3-11/25/2013 12:35 PM(foreman)-)
//


package com.sadad.ebpp.scm.schema.billsearch._1;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import com.sadad.scm.common._1.BaseType;


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
 *         &lt;element ref="{http://www.sadad.com/scm/Common/1.0}BillerKey"/>
 *         &lt;element ref="{http://www.sadad.com/scm/Common/1.0}AccountKey"/>
 *         &lt;element name="Status" type="{http://www.sadad.com/EBPP/scm/schema/BillSearch/1.0}ListBillStatus_Type" minOccurs="0"/>
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
    "billerKey",
    "accountKey",
    "status"
})
public class ListByAccountRqType
    extends BaseType
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(name = "BillerKey", namespace = "http://www.sadad.com/scm/Common/1.0", required = true)
    protected String billerKey;
    @XmlElement(name = "AccountKey", namespace = "http://www.sadad.com/scm/Common/1.0", required = true)
    protected String accountKey;
    @XmlElement(name = "Status")
    protected ListBillStatusType status;

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
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link ListBillStatusType }
     *     
     */
    public ListBillStatusType getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link ListBillStatusType }
     *     
     */
    public void setStatus(ListBillStatusType value) {
        this.status = value;
    }

}
