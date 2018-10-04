//
// Generated By:JAX-WS RI IBM 2.2.1-11/25/2013 11:48 AM(foreman)- (JAXB RI IBM 2.2.3-11/25/2013 12:35 PM(foreman)-)
//


package com.sadad.ebpp.scm.schema.customer._1;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import com.sadad.scm.common._1.StatusType;


/**
 *  Status response from each account
 * 			
 * 
 * <p>Java class for AccountAssnStatus_Type complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AccountAssnStatus_Type">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.sadad.com/EBPP/scm/schema/Customer/1.0}AccountAssnInqStatus_Type">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.sadad.com/scm/Common/1.0}Status"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AccountAssnStatus_Type", propOrder = {
    "status"
})
public class AccountAssnStatusType
    extends AccountAssnInqStatusType
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(name = "Status", namespace = "http://www.sadad.com/scm/Common/1.0", required = true)
    protected StatusType status;

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

}
