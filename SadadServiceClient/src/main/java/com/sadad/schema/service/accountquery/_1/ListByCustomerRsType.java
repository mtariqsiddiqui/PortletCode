//
// Generated By:JAX-WS RI IBM 2.2.1-11/28/2011 08:28 AM(foreman)- (JAXB RI IBM 2.2.3-11/28/2011 06:21 AM(foreman)-)
//


package com.sadad.schema.service.accountquery._1;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import com.sadad.scm.common._1.BaseType;
import com.sadad.scm.common._1.CustomerAccountsAssnType;
import com.sadad.scm.common._1.PaginationType;


/**
 * <p>Java class for ListByCustomerRs_Type complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ListByCustomerRs_Type">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.sadad.com/scm/Common/1.0}BaseType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.sadad.com/scm/Common/1.0}CustomerAccountsAssn"/>
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
@XmlType(name = "ListByCustomerRs_Type", propOrder = {
    "customerAccountsAssn",
    "pagination"
})
public class ListByCustomerRsType
    extends BaseType
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(name = "CustomerAccountsAssn", namespace = "http://www.sadad.com/scm/Common/1.0", required = true)
    protected CustomerAccountsAssnType customerAccountsAssn;
    @XmlElement(name = "Pagination", namespace = "http://www.sadad.com/scm/Common/1.0")
    protected PaginationType pagination;

    /**
     * Gets the value of the customerAccountsAssn property.
     * 
     * @return
     *     possible object is
     *     {@link CustomerAccountsAssnType }
     *     
     */
    public CustomerAccountsAssnType getCustomerAccountsAssn() {
        return customerAccountsAssn;
    }

    /**
     * Sets the value of the customerAccountsAssn property.
     * 
     * @param value
     *     allowed object is
     *     {@link CustomerAccountsAssnType }
     *     
     */
    public void setCustomerAccountsAssn(CustomerAccountsAssnType value) {
        this.customerAccountsAssn = value;
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
