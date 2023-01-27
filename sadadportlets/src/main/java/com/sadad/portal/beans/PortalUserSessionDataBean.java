/**
 * 
 */
package com.sadad.portal.beans;

import java.util.HashMap;

import com.sadad.portal.constant.SadadDynamicDataConfiguration;

/**
 * @author Tariq Siddiqui
 *
 */
public class PortalUserSessionDataBean extends SadadPortalSessionDataBean
{
	private String userId;
	private String password;
	private String newPassword;
	private String firstName;
	private String middleName;
	private String lastName;
	private String givenName;
	private String organisationType;
	private String organisationId;
	private String organisationName;
	private String jobTitle;
	private String mobileNumber;
	private String phoneNumber;
	private String faxNumber;
	private String emailAddress;
	private String alternateEmailAddress;
	private String userStatus;
	private String officeAddress;
	private String city;
	private String zipCode;
	private String district;
	private String state;
	private String country;
	private String preferredLanguage;
	private String assignedGroups;
	private String[] assignableGroups;
	private String newGroups;
	private boolean userLocked;
	private String userKey;
	private HashMap<String, PortalUserSessionDataBean> users;
	private String searchCriteria;
	private String searchKeyword;
	private String lastPasswordChangeDate;
	private String termsAccepted;
	private String nextPage;
		
	public String getUserId()
	{
		return userId;
	}

	public void setUserId(String userId)
	{
		this.userId = userId;
	}
	
	public String  getUserIdentifier()
	{
		return "uid=" + userId + "," + SadadDynamicDataConfiguration.SDS_SUB_ENTRY_USERS;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public String getNewPassword()
	{
		return newPassword;
	}

	public void setNewPassword(String newPassword)
	{
		this.newPassword = newPassword;
	}

	public String getFirstName()
	{
		return chopXssAttempt(firstName);
	}

	public void setFirstName(String firstName)
	{
		this.firstName = chopXssAttempt(firstName);
	}

	public String getMiddleName()
	{
		return chopXssAttempt(middleName);
	}

	public void setMiddleName(String middleName)
	{
		this.middleName = chopXssAttempt(middleName);
	}

	public String getLastName()
	{
		return chopXssAttempt(lastName);
	}

	public void setLastName(String lastName)
	{
		this.lastName = chopXssAttempt(lastName);
	}
	
	public String getGivenName()
	{
		return chopXssAttempt(givenName);
	}
	
	public void setGivenName(String givenName)
	{
		this.givenName = chopXssAttempt(givenName);
	}

	public String getOrganisationType()
	{
		return organisationType.toUpperCase();
	}

	public void setOrganisationType(String organisationType)
	{
		this.organisationType = organisationType;
		// As SADAD-001 is not loaded into the Partner Cache, we are setting OrgId and OrgName explicitly
		if(this.organisationType.equalsIgnoreCase("sadad"))
		{
			this.organisationId = "SADAD-001";
			this.organisationName = "Sadad";
		}
	}

	public String getOrganisationId()
	{
		return organisationId;
	}

	public void setOrganisationId(String organisationId)
	{
		this.organisationId = organisationId;
	}

	public String getOrganisationName()
	{
		return organisationName;
	}

	public void setOrganisationName(String organisationName)
	{
		this.organisationName = organisationName;
	}

	public String getJobTitle()
	{
		return chopXssAttempt(jobTitle);
	}

	public void setJobTitle(String jobTitle)
	{
		this.jobTitle = chopXssAttempt(jobTitle);
	}

	public String getMobileNumber()
	{
		return chopXssAttempt(mobileNumber);
	}

	public void setMobileNumber(String mobileNumber)
	{
		this.mobileNumber = chopXssAttempt(mobileNumber);
	}

	public String getPhoneNumber()
	{
		return chopXssAttempt(phoneNumber);
	}

	public void setPhoneNumber(String phoneNumber)
	{
		this.phoneNumber = chopXssAttempt(phoneNumber);
	}

	public String getFaxNumber()
	{
		return chopXssAttempt(faxNumber);
	}

	public void setFaxNumber(String faxNumber)
	{
		this.faxNumber = chopXssAttempt(faxNumber);
	}

	public String getEmailAddress()
	{
		return chopXssAttempt(emailAddress);
	}

	public void setEmailAddress(String emailAddress)
	{
		this.emailAddress = chopXssAttempt(emailAddress);
	}

	public String getAlternateEmailAddress()
	{
		return chopXssAttempt(alternateEmailAddress);
	}

	public void setAlternateEmailAddress(String alternateEmailAddress)
	{
		this.alternateEmailAddress = chopXssAttempt(alternateEmailAddress);
	}

	public String getUserStatus()
	{
		return userStatus;
	}

	public void setUserStatus(String userStatus)
	{
		this.userStatus = userStatus;
	}

	public String getOfficeAddress()
	{
		return chopXssAttempt(officeAddress);
	}

	public void setOfficeAddress(String officeAddress)
	{
		this.officeAddress = chopXssAttempt(officeAddress);
	}

	public String getCity()
	{
		return chopXssAttempt(city);
	}

	public void setCity(String city)
	{
		this.city = chopXssAttempt(city);
	}

	public String getZipCode()
	{
		return chopXssAttempt(zipCode);
	}

	public void setZipCode(String zipCode)
	{
		this.zipCode = chopXssAttempt(zipCode);
	}

	public String getDistrict()
	{
		return chopXssAttempt(district);
	}

	public void setDistrict(String district)
	{
		this.district = chopXssAttempt(district);
	}

	public String getState()
	{
		if(state == null)
			state = "SA.RI";
		return chopXssAttempt(state);
	}

	public void setState(String state)
	{
		this.state = chopXssAttempt(state);
	}

	public String getCountry()
	{
		if(country == null)
			country = "Saudi Arabia";
		return chopXssAttempt(country);
	}

	public void setCountry(String country)
	{
		this.country = chopXssAttempt(country);
	}

	public String getPreferredLanguage()
	{
		return chopXssAttempt(preferredLanguage);
	}

	public void setPreferredLanguage(String preferredLanguage)
	{
		this.preferredLanguage = chopXssAttempt(preferredLanguage);
	}

	public String getAssignedGroups()
	{
		return assignedGroups;
	}

	public void setAssignedGroups(String assignedGroups)
	{
		this.assignedGroups = assignedGroups;
	}
	
	public String getNewGroups()
	{
		return newGroups;
	}

	public void setNewGroups(String newGroups)
	{
		this.newGroups = newGroups;
	}

	public boolean isUserLocked()
	{
		return userLocked;
	}

	public void setUserLocked(boolean userLocked)
	{
		this.userLocked = userLocked;
	}
	
	public String getUserKey()
	{
		return userKey;
	}

	public void setUserKey(String userKey)
	{
		this.userKey = userKey;
	}

	public HashMap<String, PortalUserSessionDataBean> getUsers()
	{
		if (users == null)
			users = new HashMap<String, PortalUserSessionDataBean>();
		return users;
	}

	public String getSearchCriteria()
	{
		return searchCriteria;
	}

	public void setSearchCriteria(String searchCriteria)
	{
		this.searchCriteria = searchCriteria;
	}

	public String getSearchKeyword()
	{
		return searchKeyword;
	}

	public void setSearchKeyword(String searchKeyword)
	{
		this.searchKeyword = searchKeyword;
	}

	public String getLastPasswordChangeDate()
	{
		return lastPasswordChangeDate;
	}

	public void setLastPasswordChangeDate(String lastPasswordChangeDate)
	{
		this.lastPasswordChangeDate = lastPasswordChangeDate;
	}

	public String getTermsAccepted()
	{
		return termsAccepted;
	}

	public void setTermsAccepted(String termsAccepted)
	{
		this.termsAccepted = termsAccepted;
	}

	public String getNextPage()
	{
		return nextPage;
	}

	public void setNextPage(String nextPage)
	{
		this.nextPage = nextPage;
	}

	public String[] getAssignableGroups()
	{
		if(this.organisationType.equalsIgnoreCase("biller"))
			assignableGroups = SadadDynamicDataConfiguration.GROUPS_FOR_BILLER;
		else if(this.organisationType.equalsIgnoreCase("bank"))
			assignableGroups = SadadDynamicDataConfiguration.GROUPS_FOR_BANK;
		else if(this.organisationType.equalsIgnoreCase("sadad"))
			assignableGroups = SadadDynamicDataConfiguration.GROUPS_FOR_SADAD;
		else if(this.organisationType.equalsIgnoreCase("aggregator"))
			assignableGroups = SadadDynamicDataConfiguration.GROUPS_FOR_AGGREGATOR;
		return assignableGroups;
	}
	
	public String assignableGroups(String orgType)
	{
		String[] ag = null;
		if(orgType.equalsIgnoreCase("biller"))
			ag = SadadDynamicDataConfiguration.GROUPS_FOR_BILLER;
		else if(orgType.equalsIgnoreCase("bank"))
			ag = SadadDynamicDataConfiguration.GROUPS_FOR_BANK;
		else if(orgType.equalsIgnoreCase("sadad"))
			ag = SadadDynamicDataConfiguration.GROUPS_FOR_SADAD;
		else if(orgType.equalsIgnoreCase("aggregator"))
			ag = SadadDynamicDataConfiguration.GROUPS_FOR_AGGREGATOR;
		
		StringBuilder sb = new StringBuilder();
		sb.append('[');
		for(String g : ag)
		{
			sb.append('\'');
			sb.append(g);
			sb.append('\'');
			sb.append(',');
		}
		sb.append(']');
		return sb.toString();
	}
}