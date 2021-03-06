//
// Generated By:JAX-WS RI IBM 2.2.1-11/28/2011 08:28 AM(foreman)- (JAXB RI IBM 2.2.3-11/28/2011 06:21 AM(foreman)-)
//


package com.sadad.scm.common._1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * -Represents a Partner in SADAD systems   
 * 
 * <p>Java class for PartnerDetails_Type complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PartnerDetails_Type">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.sadad.com/scm/Common/1.0}Partner_Type">
 *       &lt;sequence>
 *         &lt;element name="Configurations" type="{http://www.sadad.com/scm/Common/1.0}PartnerConfiguration_Type" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="ServiceSubscription" type="{http://www.sadad.com/scm/Common/1.0}PartnerSubscriptions_Type" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PartnerDetails_Type", propOrder = {
    "configurations",
    "serviceSubscription"
})
@XmlSeeAlso({
    BillerDetailType.class,
    BankDetailType.class,
    SADADDetailType.class
})
public class PartnerDetailsType
    extends PartnerType
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(name = "Configurations")
    protected List<PartnerConfigurationType> configurations;
    @XmlElement(name = "ServiceSubscription")
    protected PartnerSubscriptionsType serviceSubscription;

    /**
     * Gets the value of the configurations property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the configurations property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getConfigurations().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PartnerConfigurationType }
     * 
     * 
     */
    public List<PartnerConfigurationType> getConfigurations() {
        if (configurations == null) {
            configurations = new ArrayList<PartnerConfigurationType>();
        }
        return this.configurations;
    }

    /**
     * Gets the value of the serviceSubscription property.
     * 
     * @return
     *     possible object is
     *     {@link PartnerSubscriptionsType }
     *     
     */
    public PartnerSubscriptionsType getServiceSubscription() {
        return serviceSubscription;
    }

    /**
     * Sets the value of the serviceSubscription property.
     * 
     * @param value
     *     allowed object is
     *     {@link PartnerSubscriptionsType }
     *     
     */
    public void setServiceSubscription(PartnerSubscriptionsType value) {
        this.serviceSubscription = value;
    }

}
