//
// Generated By:JAX-WS RI IBM 2.2.1-11/28/2011 08:28 AM(foreman)- (JAXB RI IBM 2.2.3-11/28/2011 06:21 AM(foreman)-)
//


package com.sadad.scm.common._1;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * -any currency amounts that are distinctly represented in the bill?s due amount
 * 
 * <p>Java class for BillSummAmt_CType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BillSummAmt_CType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.sadad.com/scm/Common/1.0}CurAmt"/>
 *         &lt;element ref="{http://www.sadad.com/scm/Common/1.0}BillSummAmtCode" minOccurs="0"/>
 *         &lt;element ref="{http://www.sadad.com/scm/Common/1.0}BillSummAmtType"/>
 *         &lt;element ref="{http://www.sadad.com/scm/Common/1.0}ShortDesc" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BillSummAmt_CType", propOrder = {
    "curAmt",
    "billSummAmtCode",
    "billSummAmtType",
    "shortDesc"
})
public class BillSummAmtCType
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(name = "CurAmt", required = true)
    protected BigDecimal curAmt;
    @XmlElement(name = "BillSummAmtCode")
    protected String billSummAmtCode;
    @XmlElement(name = "BillSummAmtType", required = true)
    protected String billSummAmtType;
    @XmlElement(name = "ShortDesc")
    protected List<ShortMsgType> shortDesc;

    /**
     * Gets the value of the curAmt property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getCurAmt() {
        return curAmt;
    }

    /**
     * Sets the value of the curAmt property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setCurAmt(BigDecimal value) {
        this.curAmt = value;
    }

    /**
     * Gets the value of the billSummAmtCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBillSummAmtCode() {
        return billSummAmtCode;
    }

    /**
     * Sets the value of the billSummAmtCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBillSummAmtCode(String value) {
        this.billSummAmtCode = value;
    }

    /**
     * Gets the value of the billSummAmtType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBillSummAmtType() {
        return billSummAmtType;
    }

    /**
     * Sets the value of the billSummAmtType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBillSummAmtType(String value) {
        this.billSummAmtType = value;
    }

    /**
     * Gets the value of the shortDesc property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the shortDesc property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getShortDesc().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ShortMsgType }
     * 
     * 
     */
    public List<ShortMsgType> getShortDesc() {
        if (shortDesc == null) {
            shortDesc = new ArrayList<ShortMsgType>();
        }
        return this.shortDesc;
    }

}
