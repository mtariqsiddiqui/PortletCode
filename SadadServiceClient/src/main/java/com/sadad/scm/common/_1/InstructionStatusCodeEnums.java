//
// Generated By:JAX-WS RI IBM 2.2.1-11/28/2011 08:28 AM(foreman)- (JAXB RI IBM 2.2.3-11/28/2011 06:21 AM(foreman)-)
//


package com.sadad.scm.common._1;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for InstructionStatusCode_Enums.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="InstructionStatusCode_Enums">
 *   &lt;restriction base="{http://www.sadad.com/scm/Common/System/1.0}NC18_SType">
 *     &lt;enumeration value="GENERATED"/>
 *     &lt;enumeration value="SENT"/>
 *     &lt;enumeration value="RETRY"/>
 *     &lt;enumeration value="DELIVERED"/>
 *     &lt;enumeration value="FAILED"/>
 *     &lt;enumeration value="RETRY"/>
 *     &lt;enumeration value="SUCCESS"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "InstructionStatusCode_Enums")
@XmlEnum
public enum InstructionStatusCodeEnums {

    GENERATED,
    SENT,
    RETRY,
    DELIVERED,
    FAILED,
    SUCCESS;

    public String value() {
        return name();
    }

    public static InstructionStatusCodeEnums fromValue(String v) {
        return valueOf(v);
    }

}
