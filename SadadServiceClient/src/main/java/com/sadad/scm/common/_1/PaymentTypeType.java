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
 * <p>Java class for PaymentType_Type complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PaymentType_Type">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.sadad.com/scm/Common/1.0}PaymentTypeCode"/>
 *         &lt;element ref="{http://www.sadad.com/scm/Common/1.0}IsPrepaid"/>
 *         &lt;element ref="{http://www.sadad.com/scm/Common/1.0}IsDefault"/>
 *         &lt;element ref="{http://www.sadad.com/scm/Common/1.0}CanCustomerInitiate"/>
 *         &lt;element ref="{http://www.sadad.com/scm/Common/1.0}TimeLimit"/>
 *         &lt;element ref="{http://www.sadad.com/scm/Common/1.0}CanReverse"/>
 *         &lt;element name="AllowedAccessChannel" type="{http://www.sadad.com/scm/Common/1.0}AccessChannelList_Type" minOccurs="0"/>
 *         &lt;element name="Status" type="{http://www.sadad.com/scm/Common/1.0}ConfigurationStatus_Enum" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PaymentType_Type", propOrder = {
    "paymentTypeCode",
    "isPrepaid",
    "isDefault",
    "canCustomerInitiate",
    "timeLimit",
    "canReverse",
    "allowedAccessChannel",
    "status"
})
public class PaymentTypeType
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(name = "PaymentTypeCode", required = true)
    protected String paymentTypeCode;
    @XmlElement(name = "IsPrepaid", defaultValue = "false")
    protected boolean isPrepaid;
    @XmlElement(name = "IsDefault", defaultValue = "false")
    protected boolean isDefault;
    @XmlElement(name = "CanCustomerInitiate", defaultValue = "false")
    protected boolean canCustomerInitiate;
    @XmlElement(name = "TimeLimit", required = true)
    protected TimeLimitEnum timeLimit;
    @XmlElement(name = "CanReverse", defaultValue = "false")
    protected boolean canReverse;
    @XmlElement(name = "AllowedAccessChannel")
    protected AccessChannelListType allowedAccessChannel;
    @XmlElement(name = "Status")
    protected ConfigurationStatusEnum status;

    /**
     * Gets the value of the paymentTypeCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPaymentTypeCode() {
        return paymentTypeCode;
    }

    /**
     * Sets the value of the paymentTypeCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPaymentTypeCode(String value) {
        this.paymentTypeCode = value;
    }

    /**
     * Gets the value of the isPrepaid property.
     * 
     */
    public boolean isIsPrepaid() {
        return isPrepaid;
    }

    /**
     * Sets the value of the isPrepaid property.
     * 
     */
    public void setIsPrepaid(boolean value) {
        this.isPrepaid = value;
    }

    /**
     * Gets the value of the isDefault property.
     * 
     */
    public boolean isIsDefault() {
        return isDefault;
    }

    /**
     * Sets the value of the isDefault property.
     * 
     */
    public void setIsDefault(boolean value) {
        this.isDefault = value;
    }

    /**
     * Gets the value of the canCustomerInitiate property.
     * 
     */
    public boolean isCanCustomerInitiate() {
        return canCustomerInitiate;
    }

    /**
     * Sets the value of the canCustomerInitiate property.
     * 
     */
    public void setCanCustomerInitiate(boolean value) {
        this.canCustomerInitiate = value;
    }

    /**
     * Gets the value of the timeLimit property.
     * 
     * @return
     *     possible object is
     *     {@link TimeLimitEnum }
     *     
     */
    public TimeLimitEnum getTimeLimit() {
        return timeLimit;
    }

    /**
     * Sets the value of the timeLimit property.
     * 
     * @param value
     *     allowed object is
     *     {@link TimeLimitEnum }
     *     
     */
    public void setTimeLimit(TimeLimitEnum value) {
        this.timeLimit = value;
    }

    /**
     * Gets the value of the canReverse property.
     * 
     */
    public boolean isCanReverse() {
        return canReverse;
    }

    /**
     * Sets the value of the canReverse property.
     * 
     */
    public void setCanReverse(boolean value) {
        this.canReverse = value;
    }

    /**
     * Gets the value of the allowedAccessChannel property.
     * 
     * @return
     *     possible object is
     *     {@link AccessChannelListType }
     *     
     */
    public AccessChannelListType getAllowedAccessChannel() {
        return allowedAccessChannel;
    }

    /**
     * Sets the value of the allowedAccessChannel property.
     * 
     * @param value
     *     allowed object is
     *     {@link AccessChannelListType }
     *     
     */
    public void setAllowedAccessChannel(AccessChannelListType value) {
        this.allowedAccessChannel = value;
    }

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link ConfigurationStatusEnum }
     *     
     */
    public ConfigurationStatusEnum getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link ConfigurationStatusEnum }
     *     
     */
    public void setStatus(ConfigurationStatusEnum value) {
        this.status = value;
    }

}
