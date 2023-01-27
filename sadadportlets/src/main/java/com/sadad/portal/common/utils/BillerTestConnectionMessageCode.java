
package com.sadad.portal.common.utils;

public enum BillerTestConnectionMessageCode
{
	ACONRQ("Account Confirmation", "ACONRQ"),
	BCONRQ("Bill Confirmation", "BCONRQ"),
	BLRCRQ("Biller Reconciliation", "BLRCRQ"),
	BLRRRQ("Biller Refund Reconciliation", "BLRRRQ"),
	BLTLRQ("BLTLRQ", "BLTLRQ"),
	EPVALRQ("EPVALRQ", "EPVALRQ"),
	FINQRQ("FINQRQ", "FINQRQ"),
	IINQRQ_SIH("IINQRQ_SIH", "IINQRQ_SIH"),
	IVALRQ("IVALRQ", "IVALRQ"),
	PCONRQ("Payment Confirmation", "PCONRQ"),
	PNOFGN("PNOFGN", "PNOFGN"),
	PNOFRQ("PNOFRQ", "PNOFRQ"),
	PNOTRQ("PNOTRQ", "PNOTRQ"),
	PNUPGN("PNUPGN", "PNUPGN"),
	PNUPRQ("PNUPRQ", "PNUPRQ"),
	RAADRQ("Refund Account Adjustment Report", "RAADRQ"),
	RCONRQ("RCONRQ", "RCONRQ"),
	RINQRQ("RINQRQ", "RINQRQ"),
	RNOBRQ("RNOBRQ", "RNOBRQ"),
	RNUBRQ("RNUBRQ", "RNUBRQ");
	
	BillerTestConnectionMessageCode(final String name, final String value)
	{
		this.name = name;
		this.value = value;
	}

	private final String name;
	private final String value;

	public String getName()
	{
		return name;
	}

	public String getValue()
	{
		return value;
	}
}