//
// Generated By:JAX-WS RI IBM 2.2.1-11/28/2011 08:28 AM(foreman)- (JAXB RI IBM 2.2.3-11/28/2011 06:21 AM(foreman)-)
//


package com.sadad.scm.common._1;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PartyIdType_Type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="PartyIdType_Type">
 *   &lt;restriction base="{http://www.sadad.com/scm/Common/System/1.0}NC32_SType">
 *     &lt;enumeration value="NAT"/>
 *     &lt;enumeration value="IQA"/>
 *     &lt;enumeration value="BIS"/>
 *     &lt;enumeration value="ACT"/>
 *     &lt;enumeration value="SID"/>
 *     &lt;enumeration value="BTL"/>
 *     &lt;enumeration value="BED"/>
 *     &lt;enumeration value="BIE"/>
 *     &lt;enumeration value="SED"/>
 *     &lt;enumeration value="PAS"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "PartyIdType_Type")
@XmlEnum
public enum PartyIdTypeType {

    NAT,
    IQA,
    BIS,
    ACT,
    SID,
    BTL,
    BED,
    BIE,
    SED,
    PAS;

    public String value() {
        return name();
    }

    public static PartyIdTypeType fromValue(String v) {
        return valueOf(v);
    }

}
