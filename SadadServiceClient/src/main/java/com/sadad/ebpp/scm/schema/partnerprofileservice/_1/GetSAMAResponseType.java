//
// Generated By:JAX-WS RI IBM 2.2.1-11/28/2011 08:28 AM(foreman)- (JAXB RI IBM 2.2.3-11/28/2011 06:21 AM(foreman)-)
//


package com.sadad.ebpp.scm.schema.partnerprofileservice._1;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import com.sadad.scm.common._1.BaseType;
import com.sadad.scm.common._1.PartnerType;


/**
 * <p>Java class for GetSAMAResponse_Type complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetSAMAResponse_Type">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.sadad.com/scm/Common/1.0}BaseType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.sadad.com/scm/Common/1.0}Partner"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetSAMAResponse_Type", propOrder = {
    "partner"
})
public class GetSAMAResponseType
    extends BaseType
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(name = "Partner", namespace = "http://www.sadad.com/scm/Common/1.0", required = true)
    protected PartnerType partner;

    /**
     * Gets the value of the partner property.
     * 
     * @return
     *     possible object is
     *     {@link PartnerType }
     *     
     */
    public PartnerType getPartner() {
        return partner;
    }

    /**
     * Sets the value of the partner property.
     * 
     * @param value
     *     allowed object is
     *     {@link PartnerType }
     *     
     */
    public void setPartner(PartnerType value) {
        this.partner = value;
    }

}