//
// Generated By:JAX-WS RI IBM 2.2.1-11/28/2011 08:28 AM(foreman)- (JAXB RI IBM 2.2.3-11/28/2011 06:21 AM(foreman)-)
//


package com.sadad.scm.common._1;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for BillerBillStatus_Enums.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="BillerBillStatus_Enums">
 *   &lt;restriction base="{http://www.sadad.com/scm/Common/System/1.0}NC32_SType">
 *     &lt;enumeration value="BILL_PAID"/>
 *     &lt;enumeration value="BILL_PARTIALLY_PAID"/>
 *     &lt;enumeration value="BILL_OVER_PAID"/>
 *     &lt;enumeration value="BILL_UNPAID"/>
 *     &lt;enumeration value="BILL_DEACTIVATE"/>
 *     &lt;enumeration value="BILL_NEW"/>
 *     &lt;enumeration value="BILL_UPDATED"/>
 *     &lt;enumeration value="BILL_ANY"/>
 *     &lt;enumeration value="BILL_EXPIRED"/>
 *     &lt;enumeration value="BILL_CREATE"/>
 *     &lt;enumeration value="ACCOUNT_ACTIVATE"/>
 *     &lt;enumeration value="ACCOUNT_DEACTIVATE"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "BillerBillStatus_Enums")
@XmlEnum
public enum BillerBillStatusEnums {

    BILL_PAID,
    BILL_PARTIALLY_PAID,
    BILL_OVER_PAID,
    BILL_UNPAID,
    BILL_DEACTIVATE,
    BILL_NEW,
    BILL_UPDATED,
    BILL_ANY,
    BILL_EXPIRED,
    BILL_CREATE,
    ACCOUNT_ACTIVATE,
    ACCOUNT_DEACTIVATE;

    public String value() {
        return name();
    }

    public static BillerBillStatusEnums fromValue(String v) {
        return valueOf(v);
    }

}
