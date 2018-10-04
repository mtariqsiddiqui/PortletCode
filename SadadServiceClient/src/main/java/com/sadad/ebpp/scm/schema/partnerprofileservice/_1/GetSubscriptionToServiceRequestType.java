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
import com.sadad.scm.common._1.PartnerKeyListType;
import com.sadad.scm.common._1.ServiceListType;


/**
 * <p>Java class for GetSubscriptionToServiceRequest_Type complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetSubscriptionToServiceRequest_Type">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.sadad.com/scm/Common/1.0}BaseType">
 *       &lt;sequence>
 *         &lt;element name="Services" type="{http://www.sadad.com/scm/Common/1.0}ServiceList_Type"/>
 *         &lt;element name="Partners" type="{http://www.sadad.com/scm/Common/1.0}PartnerKeyList_Type" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetSubscriptionToServiceRequest_Type", propOrder = {
    "services",
    "partners"
})
public class GetSubscriptionToServiceRequestType
    extends BaseType
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(name = "Services", required = true)
    protected ServiceListType services;
    @XmlElement(name = "Partners")
    protected PartnerKeyListType partners;

    /**
     * Gets the value of the services property.
     * 
     * @return
     *     possible object is
     *     {@link ServiceListType }
     *     
     */
    public ServiceListType getServices() {
        return services;
    }

    /**
     * Sets the value of the services property.
     * 
     * @param value
     *     allowed object is
     *     {@link ServiceListType }
     *     
     */
    public void setServices(ServiceListType value) {
        this.services = value;
    }

    /**
     * Gets the value of the partners property.
     * 
     * @return
     *     possible object is
     *     {@link PartnerKeyListType }
     *     
     */
    public PartnerKeyListType getPartners() {
        return partners;
    }

    /**
     * Sets the value of the partners property.
     * 
     * @param value
     *     allowed object is
     *     {@link PartnerKeyListType }
     *     
     */
    public void setPartners(PartnerKeyListType value) {
        this.partners = value;
    }

}
