//
// Generated By:JAX-WS RI IBM 2.2.1-11/28/2011 08:28 AM(foreman)- (JAXB RI IBM 2.2.3-11/28/2011 06:21 AM(foreman)-)
//


package com.sadad.scm.common._1;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PartyLifecycle_Enums.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="PartyLifecycle_Enums">
 *   &lt;restriction base="{http://www.sadad.com/scm/Common/System/1.0}NC32_SType">
 *     &lt;enumeration value="ACTIVE"/>
 *     &lt;enumeration value="INACTIVE"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "PartyLifecycle_Enums")
@XmlEnum
public enum PartyLifecycleEnums {

    ACTIVE,
    INACTIVE;

    public String value() {
        return name();
    }

    public static PartyLifecycleEnums fromValue(String v) {
        return valueOf(v);
    }

}
