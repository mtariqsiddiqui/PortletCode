package com.sadad.portal.common.utils;

public enum SaudiArabiaRegions
{
	SA_BA("Al Bahah", "SA.BA"),
	SA_HS("Al Hudud-ash-Shamaliyah","SA.HS"),
	SA_JF("Al Jawf", "SA.JF"),
	SA_MD("Al Madinah","SA.MD"),
	SA_QS("Al Qasim","SA.QS"),
	SA_RI("Ar Riyadh","SA.RI"),
	SA_SH("Ash Sharqiyah","SA.SH"),
	SA_AS("Asir", "SA.AS"),
	SA_HA("Hail", "SA.HA"),
	SA_JZ("Jizan", "SA.JZ"),
	SA_MK("Makkah", "SA.MK"),
	SA_NJ("Najran", "SA.NJ"),
	SA_TB("Tabuk", "SA.TB");
	
	SaudiArabiaRegions(final String name, final String value)
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