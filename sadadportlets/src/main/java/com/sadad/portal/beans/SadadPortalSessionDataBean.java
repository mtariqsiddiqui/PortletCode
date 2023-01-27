package com.sadad.portal.beans;

/**
 * 
 */

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.portlet.PortletRequest;
import javax.xml.bind.DatatypeConverter;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import com.sadad.portal.common.cache.SadadListCache;
import com.sadad.portal.constant.PortalConstant;
import com.sadad.scm.error._1.FaultType;

/**
 * @author Tariq Siddiqui
 * 
 */
public abstract class SadadPortalSessionDataBean
{
	private static final String CLASS_NAME = SadadPortalSessionDataBean.class.getName();
	private static final Logger logger = Logger.getLogger(CLASS_NAME);

	private static final ResourceBundle rb_En = ResourceBundle.getBundle(PortalConstant.SADAD_COMMOM_RESOURCE, new Locale("en", "US"));
	private static final ResourceBundle rb_Ar = ResourceBundle.getBundle(PortalConstant.SADAD_COMMOM_RESOURCE, new Locale("ar", "SA"));

	protected Screen screen;
	protected String partnerKey; // partnerKey stored in LDAP OrgId attribute
	protected ArrayDeque<Screen> screens;
	protected Message messageToDisplay;
	protected String operation;
	protected String partnerType; // partnerType stored in LDAP businessCategory attribute
	protected String hashedPartnerKey; // hashedPartnerKey is introduced after Aggregator, used to carry MD5 hashed partnerKey mixed with SALT
	protected String userType; // userType possible values are admin and user based on LDAP Group membership of user
	// userGroups - added for IBAN Management - earlier userType was enough, leaving userType for as it is used in multiple places
	protected String userGroups; // CSV of user group based on LDAP Group membership of user
	protected String remoteUser;
	protected String languageCode;
	protected String jsonObj; // use to sends the response in JSON instead of JSP
	protected String cacheRefreshType;
	protected SadadListCache cacheObj;
	protected String cacheParent;
	protected PortletRequest request;
	protected String ltpaTokenValue; // Added for the fileToken - file download security

	protected SadadPortalSessionDataBean()
	{
		super();
		this.screen = new Screen();
	}

	/**
	 * @return the screen
	 */
	public Screen getScreen()
	{
		return screen;
	}

	/**
	 * @param screen
	 *            the screen to set
	 */
	public void setScreen(Screen screen)
	{
		this.screen = screen;
	}

	/**
	 * @return the partnerKey
	 */
	public String getPartnerKey()
	{
		return partnerKey;
	}

	/**
	 * @param partnerKey
	 *            the partnerKey to set
	 */
	public void setPartnerKey(String partnerKey)
	{
		this.partnerKey = partnerKey;
	}

	/**
	 * @return the screens
	 */
	public Deque<Screen> getScreens()
	{
		if (screens == null)
			screens = new ArrayDeque<>();
		return screens;
	}

	/**
	 * @return the messageToDisplay
	 */
	public Message getMessageToDisplay()
	{
		return messageToDisplay;
	}

	/**
	 * @return the operation
	 */
	public String getOperation()
	{
		return operation;
	}

	/**
	 * @param operation
	 *            the operation to set
	 */
	public void setOperation(String operation)
	{
		this.operation = operation;
	}

	/**
	 * @param messageToDisplay
	 *            the messageToDisplay to set
	 */
	public void setMessageToDisplay(Message messageToDisplay)
	{
		this.messageToDisplay = messageToDisplay;
	}

	/**
	 * @return the partnerType
	 */
	public String getPartnerType()
	{
		return partnerType;
	}

	/**
	 * @param partnerType
	 *            the partnerType to set
	 */
	public void setPartnerType(String partnerType)
	{
		this.partnerType = partnerType;
	}

	/**
	 * 
	 * @return the hashedPartnerKey mixed with SALT
	 */
	public String getHashedPartnerKey()
	{
		hashedPartnerKey = null;
		try
		{
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(PortalConstant.JSON_MIXIN_SALT.getBytes());
			md.update(this.partnerKey.getBytes());
			hashedPartnerKey = DatatypeConverter.printHexBinary(md.digest());
		}
		catch (NoSuchAlgorithmException e)
		{}
		return hashedPartnerKey;
	}

	/**
	 * @return the userType
	 */
	public String getUserType()
	{
		return userType;
	}

	/**
	 * @param userType
	 *            the userType to set
	 */
	public void setUserType(String userType)
	{
		this.userType = userType;
	}

	/**
	 * @return the userGroups
	 */
	public String getUserGroups()
	{
		return userGroups;
	}

	/**
	 * @param userGroups
	 *            the userGroups to set
	 */
	public void setUserGroups(String userGroups)
	{
		this.userGroups = userGroups;
	}

	/**
	 * @return the remoteUser
	 */
	public String getRemoteUser()
	{
		return remoteUser;
	}

	/**
	 * @param remoteUser
	 *            the remoteUser to set
	 */
	public void setRemoteUser(String remoteUser)
	{
		this.remoteUser = remoteUser;
	}

	/**
	 * @return the languageCode
	 */
	public String getLanguageCode()
	{
		return languageCode;
	}

	/**
	 * @param languageCode
	 *            the languageCode to set
	 */
	public void setLanguageCode(String languageCode)
	{
		this.languageCode = languageCode;
	}

	/**
	 * @return the jsonObj
	 */
	public String getJsonObj()
	{
		return jsonObj;
	}

	/**
	 * @param jsonObj
	 *            the jsonObj to set
	 */
	public void setJsonObj(String jsonObj)
	{
		this.jsonObj = jsonObj;
	}

	/**
	 * @return the cacheRefreshType
	 */
	public String getCacheRefreshType()
	{
		return cacheRefreshType;
	}

	/**
	 * @param cacheRefreshType
	 *            the cacheRefreshType to set
	 */
	public void setCacheRefreshType(String cacheRefreshType)
	{
		this.cacheRefreshType = cacheRefreshType;
	}

	/**
	 * @return the cacheObj
	 */
	public SadadListCache getCacheObj()
	{
		return cacheObj;
	}

	/**
	 * @param cacheObj
	 *            the cacheObj to set
	 */
	public void setCacheObj(SadadListCache cacheObj)
	{
		this.cacheObj = cacheObj;
	}

	/**
	 * @return the cacheParent
	 */
	public String getCacheParent()
	{
		return cacheParent;
	}

	/**
	 * @param cacheParent
	 *            the cacheParent to set
	 */
	public void setCacheParent(String cacheParent)
	{
		this.cacheParent = cacheParent;
	}

	/**
	 * @return the request
	 */
	public PortletRequest getRequest()
	{
		return request;
	}

	/**
	 * @param request
	 *            the request to set
	 */
	public void setRequest(PortletRequest request)
	{
		this.request = request;
	}

	public String getLtpaTokenValue()
	{
		return ltpaTokenValue;
	}

	public void setLtpaTokenValue(String ltpaTokenValue)
	{
		this.ltpaTokenValue = ltpaTokenValue;
	}

	/**
	 * In case of moving forward, it stores the screen element in deque and returns null and in case of moving back it return the top element of deque.
	 * 
	 * @param whereTo
	 * @return screen to render
	 */
	public Screen navigate(String whereTo)
	{
		Screen hereTo = null;
		if (whereTo.equalsIgnoreCase(PortalConstant.BACK))
			hereTo = getScreens().pop();
		else if (whereTo.equalsIgnoreCase(PortalConstant.NEXT))
		{
			Screen s = new Screen();
			s.setContainer1(getScreen().getContainer1());
			s.setContainer2(getScreen().getContainer2());
			getScreens().push(s);
		}
		else if (whereTo.equalsIgnoreCase(PortalConstant.REFRESH))
			hereTo = getScreens().peekFirst();
		else if (whereTo.equalsIgnoreCase(PortalConstant.FINISH))
			getScreens().clear();

		return hereTo;
	}

	/**
	 * Return the info message.
	 * 
	 * @param msg
	 */
	public void setInfoMessage(String msg)
	{
		Message infoMsg = new Message();
		infoMsg.setMessageType(MessageType.INFO);
		infoMsg.setDisplayMessage(msg);
		setMessageToDisplay(infoMsg);
	}

	/**
	 * Return the warning message.
	 * 
	 * @param msg
	 */
	public void setWarningMessage(String msg)
	{
		Message warnMsg = new Message();
		warnMsg.setMessageType(MessageType.WARNING);
		warnMsg.setDisplayMessage(msg);
		setMessageToDisplay(warnMsg);
	}

	/**
	 * Return the error message.
	 * 
	 * @param msg
	 */
	public void setErrorMessage(String msg)
	{
		Message errMsg = new Message();
		errMsg.setMessageType(MessageType.ERROR);
		errMsg.setDisplayMessage(msg);
		setMessageToDisplay(errMsg);
	}

	/**
	 * Set Success message for the give msg code.
	 * 
	 * @param msgCode
	 */
	public void setInfoMessage(long msgCode)
	{
		Message errMsg = new Message();
		errMsg.setMessageType(MessageType.INFO);
		String msg = null;
		try
		{
			if (this.getLanguageCode().equalsIgnoreCase("en"))
				msg = rb_En.getString(Long.toString(msgCode));

			if (this.getLanguageCode().equalsIgnoreCase("Ar"))
				msg = rb_Ar.getString(Long.toString(msgCode));
		}
		catch (NullPointerException npe)
		{

			if (this.getLanguageCode().equalsIgnoreCase("en"))
				msg = rb_En.getString("99999");

			if (this.getLanguageCode().equalsIgnoreCase("ar"))
				msg = rb_Ar.getString("99999");

			logger.logp(Level.WARNING, CLASS_NAME, "setInfoMessage", "FaultType - Code is NULL.");
		}
		catch (MissingResourceException mre)
		{
			msg = null;
			errMsg.setMessageType(null);
			logger.logp(Level.WARNING, CLASS_NAME, "setInfoMessage", "The Error Code Key < {0} > is not present in Resource bundle.", msgCode);
		}
		errMsg.setDisplayMessage(msg);
		setMessageToDisplay(errMsg);
	}

	/**
	 * Set Error message for the give msg code.
	 * 
	 * @param errorCode
	 */
	public void setErrorMessage(long errorCode)
	{
		Message errMsg = new Message();
		errMsg.setMessageType(MessageType.ERROR);
		String msg = null;
		try
		{
			if (this.getLanguageCode().equalsIgnoreCase("en"))
				msg = rb_En.getString(Long.toString(errorCode));

			if (this.getLanguageCode().equalsIgnoreCase("ar"))
				msg = rb_Ar.getString(Long.toString(errorCode));
		}
		catch (NullPointerException npe)
		{
			if (this.getLanguageCode().equalsIgnoreCase("en"))
				msg = rb_En.getString("99999");

			if (this.getLanguageCode().equalsIgnoreCase("ar"))
				msg = rb_Ar.getString("99999");

			logger.logp(Level.WARNING, CLASS_NAME, "setErrorMessage", "FaultType - Code is NULL.");
		}
		catch (MissingResourceException mre)
		{
			msg = null;
			errMsg.setMessageType(null);
			logger.logp(Level.WARNING, CLASS_NAME, "setErrorMessage", "The Error Code Key < {0} > is not present in Resource bundle.", errorCode);
		}
		errMsg.setDisplayMessage(msg);
		setMessageToDisplay(errMsg);
	}

	public void setGenericErrorMessage()
	{
		Message m = new Message();
		m.setMessageType(MessageType.ERROR);
		
		if (this.getLanguageCode().equalsIgnoreCase("en"))
			m.setDisplayMessage(rb_En.getString(PortalConstant.SADAD_GENERIC_ERROR));
		else if (this.getLanguageCode().equalsIgnoreCase("ar"))
			m.setDisplayMessage(rb_Ar.getString(PortalConstant.SADAD_GENERIC_ERROR));
		setMessageToDisplay(m);
	}

	public void setGenericInfoMessage()
	{
		Message m = new Message();
		m.setMessageType(MessageType.INFO);
		if (this.getLanguageCode().equalsIgnoreCase("en"))
			m.setDisplayMessage(rb_En.getString(PortalConstant.SADAD_GENERIC_INFO));
		else if (this.getLanguageCode().equalsIgnoreCase("ar"))
			m.setDisplayMessage(rb_Ar.getString(PortalConstant.SADAD_GENERIC_INFO));
		setMessageToDisplay(m);
	}

	/**
	 * Use to get the UUID when required in composing message request
	 * 
	 * @return
	 */
	public String getRandomGloballyUniqueIdentifier()
	{
		return UUID.randomUUID().toString();
	}

	/**
	 * Use to get the date in XML format
	 * 
	 * @param diff
	 *            - difference, pass 0 to get current date, -1 for yesterday and 1 for tomorrow
	 * @return
	 */
	public XMLGregorianCalendar getXmlDate(int diff)
	{
		XMLGregorianCalendar cd = null;
		try
		{
			cd = DatatypeFactory.newInstance().newXMLGregorianCalendar(LocalDate.now().plusDays(diff).toString() + "T00:00:00");
		}
		catch (DatatypeConfigurationException e)
		{
			logger.logp(Level.SEVERE, CLASS_NAME, "getXmlDate", e.getMessage());
			if (logger.isLoggable(Level.FINEST))
				e.printStackTrace();
		}
		return cd;
	}

	/**
	 * Use to get the date in XML format
	 * 
	 * @param diff
	 *            - difference, pass 1 to get current date, 0 for yesterday and 2 for tomorrow
	 * @return
	 */
	public XMLGregorianCalendar getNextDate(String date, int diff)
	{
		// Commented out the condition as Exact shoud not be plus one, it should be exactly the same date - IF(diff <= 0){diff = 1;}
		XMLGregorianCalendar cd = null;
		try
		{
			LocalDateTime lt = LocalDateTime.now().minusMinutes(15); // Minus 15 minutes to overcome if WAS server time is not sync Portal server precisely
			cd = DatatypeFactory.newInstance().newXMLGregorianCalendar(LocalDate.parse(date).plusDays(diff).toString() + "T24:00:00.000");
			if (cd.compare(DatatypeFactory.newInstance().newXMLGregorianCalendar(lt.toString())) > 0)
				cd = DatatypeFactory.newInstance().newXMLGregorianCalendar(lt.toString());
		}
		catch (DatatypeConfigurationException e)
		{
			logger.logp(Level.SEVERE, CLASS_NAME, "getNextDate", e.getMessage());
			if (logger.isLoggable(Level.FINEST))
				e.printStackTrace();
		}
		return cd;
	}

	/**
	 * Use to parse the String date in XML format
	 * 
	 * @param date
	 *            - String date in yyyy-MM-dd format
	 * @return return XMLGregorian date in yyyy-MM-dd format
	 */
	public XMLGregorianCalendar parseXmlFullDate(String date)
	{
		XMLGregorianCalendar xmlDate = null;
		try
		{
			xmlDate = DatatypeFactory.newInstance().newXMLGregorianCalendar(date);
		}
		catch (DatatypeConfigurationException e)
		{
			logger.logp(Level.SEVERE, CLASS_NAME, "parseXmlFullDate", e.getMessage());
			if (logger.isLoggable(Level.FINEST))
				e.printStackTrace();
		}
		return xmlDate;
	}

	/**
	 * Use to parse the String date in XML format
	 * 
	 * @param date
	 *            - String date in yyyy-MM-dd format
	 * @return return XMLGregorian date in yyyy-MM-ddThh:mm:ss format
	 */
	public XMLGregorianCalendar parseXmlDate(String date)
	{
		XMLGregorianCalendar xmlDate = null;
		try
		{
			xmlDate = DatatypeFactory.newInstance().newXMLGregorianCalendar(date + "T00:00:00.000");
		}
		catch (DatatypeConfigurationException e)
		{
			logger.logp(Level.SEVERE, CLASS_NAME, "parseXmlDate", e.getMessage());
			if (logger.isLoggable(Level.FINEST))
				e.printStackTrace();
		}
		return xmlDate;
	}

	/**
	 * Use to parse the String date in XML format with starting time of the day
	 * 
	 * @param date
	 *            - String date in yyyy-MM-dd format
	 * @return return XMLGregorian date in yyyy-MM-ddThh:mm:ss format with starting time of the day
	 */
	public XMLGregorianCalendar parseXmlFromDate(String date)
	{
		XMLGregorianCalendar xmlDate = null;
		try
		{
			xmlDate = DatatypeFactory.newInstance().newXMLGregorianCalendar(date + "T00:00:00.000");
		}
		catch (DatatypeConfigurationException e)
		{
			logger.logp(Level.SEVERE, CLASS_NAME, "parseXmlFromDate", e.getMessage());
			if (logger.isLoggable(Level.FINEST))
				e.printStackTrace();
		}
		return xmlDate;
	}

	/**
	 * Use to parse the String date in XML format with ending time of the day
	 * 
	 * @param date
	 *            - String date in yyyy-MM-dd format
	 * @return return XMLGregorian date in yyyy-MM-ddThh:mm:ss format with ending time of the day
	 */
	public XMLGregorianCalendar parseXmlToDate(String date)
	{
		XMLGregorianCalendar xmlDate = null;
		try
		{
			xmlDate = DatatypeFactory.newInstance().newXMLGregorianCalendar(date + "T24:00:00.000");
			// Minus 15 minutes to overcome if WAS server time is not sync Portal server precisely
			XMLGregorianCalendar currentTimestamp = DatatypeFactory.newInstance().newXMLGregorianCalendar(LocalDateTime.now().minusMinutes(15).toString());
			if (xmlDate.toGregorianCalendar().compareTo(currentTimestamp.toGregorianCalendar()) > 0)
				return currentTimestamp;
		}
		catch (DatatypeConfigurationException e)
		{
			logger.logp(Level.SEVERE, CLASS_NAME, "parseXmlToDate", e.getMessage());
			if (logger.isLoggable(Level.FINEST))
				e.printStackTrace();
		}
		return xmlDate;
	}

	/**
	 * Used to transform backend service exception into Portal exception.
	 * 
	 * @param ft
	 */
	public void transformS2ExceptionToS1(FaultType ft)
	{
		final String methodName = "transformS2ExceptionToS1";
		Message m = new Message();
		m.setMessageType(MessageType.ERROR);
		String msg = null;

		try
		{
			if (this.getLanguageCode().equalsIgnoreCase("en"))
				msg = rb_En.getString(Long.toString(ft.getCode()));
			if (this.getLanguageCode().equalsIgnoreCase("ar"))
				msg = rb_Ar.getString(Long.toString(ft.getCode()));
		}
		catch (NullPointerException npe)
		{
			if (this.getLanguageCode().equalsIgnoreCase("en"))
				msg = rb_En.getString("99999");
			if (this.getLanguageCode().equalsIgnoreCase("ar"))
				msg = rb_Ar.getString("99999");

			logger.logp(Level.WARNING, CLASS_NAME, methodName, "FaultType - Code is NULL.");
		}
		catch (MissingResourceException mre)
		{
			msg = null;
			m.setMessageType(null);
			logger.logp(Level.WARNING, CLASS_NAME, methodName, mre.getMessage());
			logger.logp(Level.WARNING, CLASS_NAME, methodName, "{0} - {1} is not present in Resource bundle.", new Object[] { ft.getCode(), ft.getDescription() });
		}
		catch (Exception e)
		{
			logger.logp(Level.SEVERE, CLASS_NAME, methodName, e.getMessage());
			if (logger.isLoggable(Level.FINEST))
				e.printStackTrace();
		}
		m.setDisplayMessage(msg);
		setMessageToDisplay(m);
	}

	/**
	 * String cleanup method for removing vulnerable javascript code.
	 * 
	 * @param s - input string to search for XSS attack attempt i.e <script> some vulnerable javascript code </script>
	 * @return - the cleaned string removed everything between first <script> and las </script>
	 */
	public String chopXssAttempt(String s)
	{
		if (s != null)
			return s.replaceAll("(\\<[Ss][Cc][Rr][Ii][Pp][Tt][\\s\\S]*\\<\\/[Ss][Cc][Rr][Ii][Pp][Tt]\\>)", "");
		return s;
	}
}