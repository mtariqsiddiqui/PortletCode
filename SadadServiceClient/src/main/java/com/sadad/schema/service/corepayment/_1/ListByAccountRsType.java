//
// Generated By:JAX-WS RI IBM 2.2.1-11/25/2013 11:48 AM(foreman)- (JAXB RI IBM 2.2.3-11/25/2013 12:35 PM(foreman)-)
//


package com.sadad.schema.service.corepayment._1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import com.sadad.scm.common._1.BaseType;
import com.sadad.scm.common._1.PaginationType;
import com.sadad.scm.common._1.PaymentInfoType;


/**
 * <p>Java class for ListByAccountRs_Type complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ListByAccountRs_Type">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.sadad.com/scm/Common/1.0}BaseType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.sadad.com/scm/Common/1.0}PaymentInfo" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://www.sadad.com/scm/Common/1.0}Pagination" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ListByAccountRs_Type", propOrder = {
    "paymentInfo",
    "pagination"
})
public class ListByAccountRsType
    extends BaseType
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(name = "PaymentInfo", namespace = "http://www.sadad.com/scm/Common/1.0")
    protected List<PaymentInfoType> paymentInfo;
    @XmlElement(name = "Pagination", namespace = "http://www.sadad.com/scm/Common/1.0")
    protected PaginationType pagination;

    /**
     * Gets the value of the paymentInfo property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the paymentInfo property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPaymentInfo().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PaymentInfoType }
     * 
     * 
     */
    public List<PaymentInfoType> getPaymentInfo() {
        if (paymentInfo == null) {
            paymentInfo = new ArrayList<PaymentInfoType>();
        }
        return this.paymentInfo;
    }

    /**
     * Gets the value of the pagination property.
     * 
     * @return
     *     possible object is
     *     {@link PaginationType }
     *     
     */
    public PaginationType getPagination() {
        return pagination;
    }

    /**
     * Sets the value of the pagination property.
     * 
     * @param value
     *     allowed object is
     *     {@link PaginationType }
     *     
     */
    public void setPagination(PaginationType value) {
        this.pagination = value;
    }

}
