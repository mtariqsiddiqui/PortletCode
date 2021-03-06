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


/**
 * <p>Java class for PaymentAmount_Type complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PaymentAmount_Type">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.sadad.com/scm/Common/1.0}Amount"/>
 *         &lt;element ref="{http://www.sadad.com/scm/Common/1.0}LifecycleState"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PaymentAmount_Type", propOrder = {
    "amount",
    "lifecycleState"
})
public class PaymentAmountType
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(name = "Amount", required = true)
    protected BigDecimal amount;
    @XmlElement(name = "LifecycleState", required = true)
    protected PaymentLifecycleEnums lifecycleState;

    /**
     * Gets the value of the amount property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getAmount() {
        return amount;
    }

    /**
     * Sets the value of the amount property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setAmount(BigDecimal value) {
        this.amount = value;
    }

    /**
     * Gets the value of the lifecycleState property.
     * 
     * @return
     *     possible object is
     *     {@link PaymentLifecycleEnums }
     *     
     */
    public PaymentLifecycleEnums getLifecycleState() {
        return lifecycleState;
    }

    /**
     * Sets the value of the lifecycleState property.
     * 
     * @param value
     *     allowed object is
     *     {@link PaymentLifecycleEnums }
     *     
     */
    public void setLifecycleState(PaymentLifecycleEnums value) {
        this.lifecycleState = value;
    }

}
