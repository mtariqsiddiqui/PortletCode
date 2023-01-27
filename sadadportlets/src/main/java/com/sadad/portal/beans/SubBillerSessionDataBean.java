package com.sadad.portal.beans;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;

import javax.xml.bind.DatatypeConverter;

import com.sadad.portal.constant.PortalConstant;

public class SubBillerSessionDataBean extends SadadAuditEnablingSessionDataBean
{
	private String aggregatorId;
//	private String aggregatorStatus;
	private String billerId;
	private String hashedPartnerKey;
	private String billerNameEnglish;
	private String billerNameArabic;
	private String legalIdType;
	private String legalIdNumber;
	private String businessCategory;
	private String billingAccountBankId;
	private String ibanNumber;
	private String tradeLicenseExpiryDate;
	private String shortName;
	private String address;
	private String landline;
	private String mobile;
	private String email;
	private String status;
	private String vatNumber;
	private String justification;
	private SubBillerSessionDataBean selectedSubBiller;

	private HashMap<String, SubBillerSessionDataBean> subBillerMap = new HashMap<String, SubBillerSessionDataBean>();

	public String getAggregatorId()
	{
		// if the user is an aggregator, then aggregatorId should be its parnerKey value from LDAP
		if (partnerType.equalsIgnoreCase(PortalConstant.PARTNER_TYPE_AGGREGATOR))
			aggregatorId = partnerKey;
		return aggregatorId;
	}

	public void setAggregatorId(String aggregatorId)
	{
		this.aggregatorId = aggregatorId;
	}

//	public String getAggregatorStatus()
//	{
//		return aggregatorStatus;
//	}
//	
//	public void setAggregatorStatus(String aggregatorStatus)
//	{
//		this.aggregatorStatus = aggregatorStatus;
//	}
	
	public String getBillerId()
	{
		return billerId;
	}

	public void setBillerId(String billerId)
	{
		this.billerId = billerId;
	}

	public String getHashedPartnerKey()
	{
		// if(hashedPartnerKey != null) return hashedPartnerKey;
		hashedPartnerKey = null;
		if (partnerType.equalsIgnoreCase(PortalConstant.PARTNER_TYPE_AGGREGATOR))
		{
			this.aggregatorId = super.getPartnerKey();
			hashedPartnerKey = super.getHashedPartnerKey();
		}
		else if (partnerType.equalsIgnoreCase(PortalConstant.PARTNER_TYPE_SADAD))
		{
			try
			{
				MessageDigest md = MessageDigest.getInstance("MD5");
				md.update(PortalConstant.JSON_MIXIN_SALT.getBytes());
				md.update(this.aggregatorId.getBytes()); // Get the selected Aggregator ID instead of Partner Key
				hashedPartnerKey = DatatypeConverter.printHexBinary(md.digest());
			}
			catch (NoSuchAlgorithmException e)
			{}
		}
		return hashedPartnerKey;
	}

	public String getBillerNameEnglish()
	{
		return billerNameEnglish;
	}

	public void setBillerNameEnglish(String billerNameEnglish)
	{
		this.billerNameEnglish = billerNameEnglish;
	}

	public String getBillerNameArabic()
	{
		return billerNameArabic;
	}

	public void setBillerNameArabic(String billerNameArabic)
	{
		this.billerNameArabic = billerNameArabic;
	}

	public String getLegalIdType()
	{
		return legalIdType;
	}

	public void setLegalIdType(String legalIdType)
	{
		this.legalIdType = legalIdType;
	}

	public String getLegalIdNumber()
	{
		return legalIdNumber;
	}

	public void setLegalIdNumber(String legalIdNumber)
	{
		this.legalIdNumber = legalIdNumber;
	}

	public String getBusinessCategory()
	{
		return businessCategory;
	}

	public void setBusinessCategory(String businessCategory)
	{
		this.businessCategory = businessCategory;
	}

	public String getBillingAccountBankId()
	{
		return billingAccountBankId;
	}

	public void setBillingAccountBankId(String billingAccountBankId)
	{
		this.billingAccountBankId = billingAccountBankId;
	}

	public String getIbanNumber()
	{
		return ibanNumber;
	}

	public void setIbanNumber(String ibanNumber)
	{
		this.ibanNumber = ibanNumber;
	}

	public String getTradeLicenseExpiryDate()
	{
		if(tradeLicenseExpiryDate != null)
			tradeLicenseExpiryDate = tradeLicenseExpiryDate.substring(0, 10);
		return tradeLicenseExpiryDate;
	}

	public void setTradeLicenseExpiryDate(String tradeLicenseExpiryDate)
	{
		this.tradeLicenseExpiryDate = tradeLicenseExpiryDate;
	}

	public String getShortName()
	{
		return shortName;
	}

	public void setShortName(String shortName)
	{
		this.shortName = shortName;
	}

	public String getAddress()
	{
		return address;
	}

	public void setAddress(String address)
	{
		this.address = address;
	}

	public String getLandline()
	{
		return landline;
	}

	public void setLandline(String landline)
	{
		this.landline = landline;
	}

	public String getMobile()
	{
		return mobile;
	}

	public void setMobile(String mobile)
	{
		this.mobile = mobile;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public String getStatus()
	{
		return status;
	}

	public void setStatus(String status)
	{
		this.status = status;
	}

	public String getVatNumber()
	{
		return vatNumber;
	}

	public void setVatNumber(String vatNumber)
	{
		this.vatNumber = vatNumber;
	}

	public String getJustification()
	{
		return justification;
	}

	public void setJustification(String justification)
	{
		this.justification = justification;
	}

	public SubBillerSessionDataBean getSelectedSubBiller()
	{
		return selectedSubBiller;
	}

	public void setSelectedSubBiller(SubBillerSessionDataBean selectedSubBiller)
	{
		this.selectedSubBiller = selectedSubBiller;
	}

	public HashMap<String, SubBillerSessionDataBean> getSubBillerMap()
	{
		if (subBillerMap != null)
			return subBillerMap;
		else return new HashMap<String, SubBillerSessionDataBean>();
	}
}