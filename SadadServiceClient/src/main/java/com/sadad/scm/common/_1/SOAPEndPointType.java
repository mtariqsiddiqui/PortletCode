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
 * -Represents a Service MQ End Point
 * 
 * <p>Java class for SOAPEndPoint_Type complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SOAPEndPoint_Type">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.sadad.com/scm/Common/1.0}BaseEndPoint_Type">
 *       &lt;sequence>
 *         &lt;element name="EndPointType" type="{http://www.sadad.com/scm/Common/System/1.0}C255_SType"/>
 *         &lt;element name="Address" type="{http://www.sadad.com/scm/Common/System/1.0}C2048_SType"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SOAPEndPoint_Type", propOrder = {
    "endPointType",
    "address"
})
public class SOAPEndPointType
    extends BaseEndPointType
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(name = "EndPointType", required = true)
    protected String endPointType;
    @XmlElement(name = "Address", required = true)
    protected String address;

    /**
     * Gets the value of the endPointType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEndPointType() {
        return endPointType;
    }

    /**
     * Sets the value of the endPointType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEndPointType(String value) {
        this.endPointType = value;
    }

    /**
     * Gets the value of the address property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets the value of the address property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddress(String value) {
        this.address = value;
    }

}
