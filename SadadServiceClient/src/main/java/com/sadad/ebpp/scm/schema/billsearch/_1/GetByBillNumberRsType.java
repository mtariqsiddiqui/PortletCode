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
 * <p>Java class for GetByBillNumberRs_Type complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetByBillNumberRs_Type">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.sadad.com/scm/Common/1.0}BaseType">
 *       &lt;sequence>
 *         &lt;element name="Bill" type="{http://www.sadad.com/EBPP/scm/schema/BillSearch/1.0}ExtBill_Type"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetByBillNumberRs_Type", propOrder = {
    "bill"
})
public class GetByBillNumberRsType
    extends BaseType
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(name = "Bill", required = true)
    protected ExtBillType bill;

    /**
     * Gets the value of the bill property.
     * 
     * @return
     *     possible object is
     *     {@link ExtBillType }
     *     
     */
    public ExtBillType getBill() {
        return bill;
    }

    /**
     * Sets the value of the bill property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExtBillType }
     *     
     */
    public void setBill(ExtBillType value) {
        this.bill = value;
    }

}