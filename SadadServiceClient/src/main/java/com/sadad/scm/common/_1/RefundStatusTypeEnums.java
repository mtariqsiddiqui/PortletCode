//
// Generated By:JAX-WS RI IBM 2.2.1-11/28/2011 08:28 AM(foreman)- (JAXB RI IBM 2.2.3-11/28/2011 06:21 AM(foreman)-)
//


package com.sadad.scm.common._1;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RefundStatusType_Enums.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="RefundStatusType_Enums">
 *   &lt;restriction base="{http://www.sadad.com/scm/Common/System/1.0}NC32_SType">
 *     &lt;enumeration value="REJECTED"/>
 *     &lt;enumeration value="PENDING"/>
 *     &lt;enumeration value="ACCEPTED"/>
 *     &lt;enumeration value="APPROVED"/>
 *     &lt;enumeration value="PROCESSING"/>
 *     &lt;enumeration value="PROCESSED"/>
 *     &lt;enumeration value="RECONCILED"/>
 *     &lt;enumeration value="PROCESSING_FAILED"/>
 *     &lt;enumeration value="EXPIRED"/>
 *     &lt;enumeration value="CANCELLED"/>
 *     &lt;enumeration value="REQUESTED_FAILED"/>
 *     &lt;enumeration value="FINAL_ATTEMPT_FAILED"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "RefundStatusType_Enums")
@XmlEnum
public enum RefundStatusTypeEnums {

    REJECTED,
    PENDING,
    ACCEPTED,
    APPROVED,
    PROCESSING,
    PROCESSED,
    RECONCILED,
    PROCESSING_FAILED,
    EXPIRED,
    CANCELLED,
    REQUESTED_FAILED,
    FINAL_ATTEMPT_FAILED;

    public String value() {
        return name();
    }

    public static RefundStatusTypeEnums fromValue(String v) {
        return valueOf(v);
    }

}
