//
// Generated By:JAX-WS RI IBM 2.2.1-11/28/2011 08:28 AM(foreman)- (JAXB RI IBM 2.2.3-11/28/2011 06:21 AM(foreman)-)
//


package com.sadad.scm.common._1;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ServiceRegistryMsg complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ServiceRegistryMsg">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="event" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="oldSRObject" type="{http://www.sadad.com/scm/Common/1.0}SRObject" minOccurs="0"/>
 *         &lt;element name="newSRObject" type="{http://www.sadad.com/scm/Common/1.0}SRObject" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ServiceRegistryMsg", propOrder = {
    "event",
    "oldSRObject",
    "newSRObject"
})
public class ServiceRegistryMsg
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    protected String event;
    protected SRObject oldSRObject;
    protected SRObject newSRObject;

    /**
     * Gets the value of the event property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEvent() {
        return event;
    }

    /**
     * Sets the value of the event property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEvent(String value) {
        this.event = value;
    }

    /**
     * Gets the value of the oldSRObject property.
     * 
     * @return
     *     possible object is
     *     {@link SRObject }
     *     
     */
    public SRObject getOldSRObject() {
        return oldSRObject;
    }

    /**
     * Sets the value of the oldSRObject property.
     * 
     * @param value
     *     allowed object is
     *     {@link SRObject }
     *     
     */
    public void setOldSRObject(SRObject value) {
        this.oldSRObject = value;
    }

    /**
     * Gets the value of the newSRObject property.
     * 
     * @return
     *     possible object is
     *     {@link SRObject }
     *     
     */
    public SRObject getNewSRObject() {
        return newSRObject;
    }

    /**
     * Sets the value of the newSRObject property.
     * 
     * @param value
     *     allowed object is
     *     {@link SRObject }
     *     
     */
    public void setNewSRObject(SRObject value) {
        this.newSRObject = value;
    }

}
