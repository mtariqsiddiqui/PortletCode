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
 * -Represents a Refund in SADAD systems   
 * 
 * <p>Java class for Refund_Type complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Refund_Type">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.sadad.com/scm/Common/1.0}RefundKey"/>
 *         &lt;element ref="{http://www.sadad.com/scm/Common/1.0}SadadRefundKey" minOccurs="0"/>
 *         &lt;element ref="{http://www.sadad.com/scm/Common/1.0}PartnerRefKey" minOccurs="0"/>
 *         &lt;element ref="{http://www.sadad.com/scm/Common/1.0}PaymentKey" minOccurs="0"/>
 *         &lt;element ref="{http://www.sadad.com/scm/Common/1.0}RefundPIN" minOccurs="0"/>
 *         &lt;element ref="{http://www.sadad.com/scm/Common/1.0}BankKey" minOccurs="0"/>
 *         &lt;element ref="{http://www.sadad.com/scm/Common/1.0}BillerKey" minOccurs="0"/>
 *         &lt;element ref="{http://www.sadad.com/scm/Common/1.0}AccessChannel" minOccurs="0"/>
 *         &lt;element ref="{http://www.sadad.com/scm/Common/1.0}BranchCode" minOccurs="0"/>
 *         &lt;element ref="{http://www.sadad.com/scm/Common/1.0}DistrictCode" minOccurs="0"/>
 *         &lt;element ref="{http://www.sadad.com/scm/Common/1.0}PartnerTransDate" minOccurs="0"/>
 *         &lt;element ref="{http://www.sadad.com/scm/Common/1.0}Amount" minOccurs="0"/>
 *         &lt;element ref="{http://www.sadad.com/scm/Common/1.0}DueDate" minOccurs="0"/>
 *         &lt;element ref="{http://www.sadad.com/scm/Common/1.0}EffDate" minOccurs="0"/>
 *         &lt;element ref="{http://www.sadad.com/scm/Common/1.0}RefundType" minOccurs="0"/>
 *         &lt;element ref="{http://www.sadad.com/scm/Common/1.0}Payor" minOccurs="0"/>
 *         &lt;element ref="{http://www.sadad.com/scm/Common/1.0}Beneficiary" minOccurs="0"/>
 *         &lt;element ref="{http://www.sadad.com/scm/Common/1.0}BankAcct" minOccurs="0"/>
 *         &lt;element ref="{http://www.sadad.com/scm/Common/1.0}ServiceCode" minOccurs="0"/>
 *         &lt;element ref="{http://www.sadad.com/scm/Common/1.0}CreateDate" minOccurs="0"/>
 *         &lt;element ref="{http://www.sadad.com/scm/Common/1.0}ExpiryDate" minOccurs="0"/>
 *         &lt;element ref="{http://www.sadad.com/scm/Common/1.0}RefundStatusType" minOccurs="0"/>
 *         &lt;element ref="{http://www.sadad.com/scm/Common/1.0}CollectionStatusType" minOccurs="0"/>
 *         &lt;element ref="{http://www.sadad.com/scm/Common/1.0}DisplayStatus" minOccurs="0"/>
 *         &lt;element ref="{http://www.sadad.com/scm/Common/1.0}CustMobileNumber" minOccurs="0"/>
 *         &lt;element ref="{http://www.sadad.com/scm/Common/1.0}RefundLifecycle" minOccurs="0"/>
 *         &lt;element ref="{http://www.sadad.com/scm/Common/1.0}BillerRefundStatus" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Refund_Type", propOrder = {
    "refundKey",
    "sadadRefundKey",
    "partnerRefKey",
    "paymentKey",
    "refundPIN",
    "bankKey",
    "billerKey",
    "accessChannel",
    "branchCode",
    "districtCode",
    "partnerTransDate",
    "amount",
    "dueDate",
    "effDate",
    "refundType",
    "payor",
    "beneficiary",
    "bankAcct",
    "serviceCode",
    "createDate",
    "expiryDate",
    "refundStatusType",
    "collectionStatusType",
    "displayStatus",
    "custMobileNumber",
    "refundLifecycle",
    "billerRefundStatus"
})
public class RefundType
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(name = "RefundKey", required = true)
    protected String refundKey;
    @XmlElement(name = "SadadRefundKey")
    protected String sadadRefundKey;
    @XmlElement(name = "PartnerRefKey")
    protected String partnerRefKey;
    @XmlElement(name = "PaymentKey")
    protected String paymentKey;
    @XmlElement(name = "RefundPIN")
    protected String refundPIN;
    @XmlElement(name = "BankKey")
    protected String bankKey;
    @XmlElement(name = "BillerKey")
    protected String billerKey;
    @XmlElement(name = "AccessChannel")
    protected String accessChannel;
    @XmlElement(name = "BranchCode")
    protected String branchCode;
    @XmlElement(name = "DistrictCode")
    protected String districtCode;
    @XmlElement(name = "PartnerTransDate")
    protected XMLGregorianCalendar partnerTransDate;
    @XmlElement(name = "Amount")
    protected BigDecimal amount;
    @XmlElement(name = "DueDate")
    protected XMLGregorianCalendar dueDate;
    @XmlElement(name = "EffDate")
    protected XMLGregorianCalendar effDate;
    @XmlElement(name = "RefundType")
    protected RefundTypeEnums refundType;
    @XmlElement(name = "Payor")
    protected PartyType payor;
    @XmlElement(name = "Beneficiary")
    protected PartyType beneficiary;
    @XmlElement(name = "BankAcct")
    protected String bankAcct;
    @XmlElement(name = "ServiceCode")
    protected String serviceCode;
    @XmlElement(name = "CreateDate")
    protected XMLGregorianCalendar createDate;
    @XmlElement(name = "ExpiryDate")
    protected XMLGregorianCalendar expiryDate;
    @XmlElement(name = "RefundStatusType")
    protected RefundStatusTypeEnums refundStatusType;
    @XmlElement(name = "CollectionStatusType")
    protected CollectionStatusTypeEnums collectionStatusType;
    @XmlElement(name = "DisplayStatus")
    protected StatusType displayStatus;
    @XmlElement(name = "CustMobileNumber")
    protected String custMobileNumber;
    @XmlElement(name = "RefundLifecycle")
    protected RefundLifecycleEnums refundLifecycle;
    @XmlElement(name = "BillerRefundStatus")
    protected BillerRefundStatusEnums billerRefundStatus;

    /**
     * Gets the value of the refundKey property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRefundKey() {
        return refundKey;
    }

    /**
     * Sets the value of the refundKey property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRefundKey(String value) {
        this.refundKey = value;
    }

    /**
     * Gets the value of the sadadRefundKey property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSadadRefundKey() {
        return sadadRefundKey;
    }

    /**
     * Sets the value of the sadadRefundKey property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSadadRefundKey(String value) {
        this.sadadRefundKey = value;
    }

    /**
     * Gets the value of the partnerRefKey property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPartnerRefKey() {
        return partnerRefKey;
    }

    /**
     * Sets the value of the partnerRefKey property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPartnerRefKey(String value) {
        this.partnerRefKey = value;
    }

    /**
     * Gets the value of the paymentKey property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPaymentKey() {
        return paymentKey;
    }

    /**
     * Sets the value of the paymentKey property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPaymentKey(String value) {
        this.paymentKey = value;
    }

    /**
     * Gets the value of the refundPIN property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRefundPIN() {
        return refundPIN;
    }

    /**
     * Sets the value of the refundPIN property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRefundPIN(String value) {
        this.refundPIN = value;
    }

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
     * Gets the value of the accessChannel property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAccessChannel() {
        return accessChannel;
    }

    /**
     * Sets the value of the accessChannel property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccessChannel(String value) {
        this.accessChannel = value;
    }

    /**
     * Gets the value of the branchCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBranchCode() {
        return branchCode;
    }

    /**
     * Sets the value of the branchCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBranchCode(String value) {
        this.branchCode = value;
    }

    /**
     * Gets the value of the districtCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDistrictCode() {
        return districtCode;
    }

    /**
     * Sets the value of the districtCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDistrictCode(String value) {
        this.districtCode = value;
    }

    /**
     * Gets the value of the partnerTransDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getPartnerTransDate() {
        return partnerTransDate;
    }

    /**
     * Sets the value of the partnerTransDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setPartnerTransDate(XMLGregorianCalendar value) {
        this.partnerTransDate = value;
    }

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
     * Gets the value of the dueDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDueDate() {
        return dueDate;
    }

    /**
     * Sets the value of the dueDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDueDate(XMLGregorianCalendar value) {
        this.dueDate = value;
    }

    /**
     * Gets the value of the effDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getEffDate() {
        return effDate;
    }

    /**
     * Sets the value of the effDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setEffDate(XMLGregorianCalendar value) {
        this.effDate = value;
    }

    /**
     * Gets the value of the refundType property.
     * 
     * @return
     *     possible object is
     *     {@link RefundTypeEnums }
     *     
     */
    public RefundTypeEnums getRefundType() {
        return refundType;
    }

    /**
     * Sets the value of the refundType property.
     * 
     * @param value
     *     allowed object is
     *     {@link RefundTypeEnums }
     *     
     */
    public void setRefundType(RefundTypeEnums value) {
        this.refundType = value;
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
     * Gets the value of the beneficiary property.
     * 
     * @return
     *     possible object is
     *     {@link PartyType }
     *     
     */
    public PartyType getBeneficiary() {
        return beneficiary;
    }

    /**
     * Sets the value of the beneficiary property.
     * 
     * @param value
     *     allowed object is
     *     {@link PartyType }
     *     
     */
    public void setBeneficiary(PartyType value) {
        this.beneficiary = value;
    }

    /**
     * Gets the value of the bankAcct property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBankAcct() {
        return bankAcct;
    }

    /**
     * Sets the value of the bankAcct property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBankAcct(String value) {
        this.bankAcct = value;
    }

    /**
     * Gets the value of the serviceCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getServiceCode() {
        return serviceCode;
    }

    /**
     * Sets the value of the serviceCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setServiceCode(String value) {
        this.serviceCode = value;
    }

    /**
     * Gets the value of the createDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getCreateDate() {
        return createDate;
    }

    /**
     * Sets the value of the createDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setCreateDate(XMLGregorianCalendar value) {
        this.createDate = value;
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
     * Gets the value of the refundStatusType property.
     * 
     * @return
     *     possible object is
     *     {@link RefundStatusTypeEnums }
     *     
     */
    public RefundStatusTypeEnums getRefundStatusType() {
        return refundStatusType;
    }

    /**
     * Sets the value of the refundStatusType property.
     * 
     * @param value
     *     allowed object is
     *     {@link RefundStatusTypeEnums }
     *     
     */
    public void setRefundStatusType(RefundStatusTypeEnums value) {
        this.refundStatusType = value;
    }

    /**
     * Gets the value of the collectionStatusType property.
     * 
     * @return
     *     possible object is
     *     {@link CollectionStatusTypeEnums }
     *     
     */
    public CollectionStatusTypeEnums getCollectionStatusType() {
        return collectionStatusType;
    }

    /**
     * Sets the value of the collectionStatusType property.
     * 
     * @param value
     *     allowed object is
     *     {@link CollectionStatusTypeEnums }
     *     
     */
    public void setCollectionStatusType(CollectionStatusTypeEnums value) {
        this.collectionStatusType = value;
    }

    /**
     * Gets the value of the displayStatus property.
     * 
     * @return
     *     possible object is
     *     {@link StatusType }
     *     
     */
    public StatusType getDisplayStatus() {
        return displayStatus;
    }

    /**
     * Sets the value of the displayStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link StatusType }
     *     
     */
    public void setDisplayStatus(StatusType value) {
        this.displayStatus = value;
    }

    /**
     * Gets the value of the custMobileNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustMobileNumber() {
        return custMobileNumber;
    }

    /**
     * Sets the value of the custMobileNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustMobileNumber(String value) {
        this.custMobileNumber = value;
    }

    /**
     * Gets the value of the refundLifecycle property.
     * 
     * @return
     *     possible object is
     *     {@link RefundLifecycleEnums }
     *     
     */
    public RefundLifecycleEnums getRefundLifecycle() {
        return refundLifecycle;
    }

    /**
     * Sets the value of the refundLifecycle property.
     * 
     * @param value
     *     allowed object is
     *     {@link RefundLifecycleEnums }
     *     
     */
    public void setRefundLifecycle(RefundLifecycleEnums value) {
        this.refundLifecycle = value;
    }

    /**
     * Gets the value of the billerRefundStatus property.
     * 
     * @return
     *     possible object is
     *     {@link BillerRefundStatusEnums }
     *     
     */
    public BillerRefundStatusEnums getBillerRefundStatus() {
        return billerRefundStatus;
    }

    /**
     * Sets the value of the billerRefundStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link BillerRefundStatusEnums }
     *     
     */
    public void setBillerRefundStatus(BillerRefundStatusEnums value) {
        this.billerRefundStatus = value;
    }

}
