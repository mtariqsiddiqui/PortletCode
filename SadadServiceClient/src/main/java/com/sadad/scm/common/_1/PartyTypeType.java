//
// Generated By:JAX-WS RI IBM 2.2.1-11/28/2011 08:28 AM(foreman)- (JAXB RI IBM 2.2.3-11/28/2011 06:21 AM(foreman)-)
//


package com.sadad.scm.common._1;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PartyType_Type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="PartyType_Type">
 *   &lt;restriction base="{http://www.sadad.com/scm/Common/System/1.0}NC32_SType">
 *     &lt;enumeration value="INDIVIDUAL"/>
 *     &lt;enumeration value="ORGANIZATION"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "PartyType_Type")
@XmlEnum
public enum PartyTypeType {

    INDIVIDUAL,
    ORGANIZATION;

    public String value() {
        return name();
    }

    public static PartyTypeType fromValue(String v) {
        return valueOf(v);
    }

}
