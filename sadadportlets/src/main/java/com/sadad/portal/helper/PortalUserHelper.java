/**
 * 
 */
package com.sadad.portal.helper;

import java.io.IOException;
import java.io.StringWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.portlet.ActionRequest;
import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ibm.portal.auth.exceptions.AuthenticationFailedException;
import com.ibm.portal.auth.exceptions.PasswordInvalidException;
import com.ibm.portal.auth.exceptions.UserIDInvalidException;
import com.ibm.portal.portlet.service.PortletServiceHome;
import com.ibm.portal.portlet.service.PortletServiceUnavailableException;
import com.ibm.portal.portlet.service.login.LoginHome;
import com.ibm.portal.state.EngineURL;
import com.ibm.portal.state.URLFactory;
import com.ibm.portal.state.accessors.action.engine.logout.LogoutActionAccessorController;
import com.ibm.portal.state.accessors.action.engine.logout.LogoutActionAccessorFactory;
import com.ibm.portal.state.accessors.exceptions.StateNotInRequestException;
import com.ibm.portal.state.accessors.selection.SelectionAccessorController;
import com.ibm.portal.state.accessors.selection.SelectionAccessorFactory;
import com.ibm.portal.state.accessors.url.URLAccessorFactory;
import com.ibm.portal.state.exceptions.CannotCloneDocumentModelException;
import com.ibm.portal.state.exceptions.CannotCreateDocumentException;
import com.ibm.portal.state.exceptions.CannotInstantiateAccessorException;
import com.ibm.portal.state.exceptions.OutputMediatorException;
import com.ibm.portal.state.exceptions.PostProcessorException;
import com.ibm.portal.state.exceptions.StateManagerException;
import com.ibm.portal.state.exceptions.UnknownAccessorTypeException;
import com.ibm.portal.state.service.PortalStateManagerService;
import com.ibm.portal.state.service.PortalStateManagerServiceHome;
import com.ibm.portal.um.AttributeDefinition;
import com.ibm.portal.um.Group;
import com.ibm.portal.um.Principal;
import com.ibm.portal.um.PumaController;
import com.ibm.portal.um.PumaLocator;
import com.ibm.portal.um.PumaProfile;
import com.ibm.portal.um.User;
import com.ibm.portal.um.exceptions.PumaAttributeException;
import com.ibm.portal.um.exceptions.PumaException;
import com.ibm.portal.um.exceptions.PumaMissingAccessRightsException;
import com.ibm.portal.um.exceptions.PumaModelException;
import com.ibm.portal.um.exceptions.PumaSystemException;
import com.ibm.portal.um.portletservice.PumaHome;
import com.sadad.portal.beans.PortalUserSessionDataBean;
import com.sadad.portal.common.utils.SadadLdapDefinedUserAttributeDefinitions;
import com.sadad.portal.constant.PortalConstant;
import com.sadad.portal.constant.SadadDynamicDataConfiguration;
import com.sadad.portal.exception.SadadGenericFault;
import com.sadad.portal.services.client.helper.PortalServiceCallHelper;
import com.sadad.scm.error._1.ErrorType;
import com.sadad.scm.error._1.FaultType;
import com.sadad.scm.error._1.SeverityType;

/**
 * @author Tariq Siddiqui
 *
 */
public class PortalUserHelper extends PortalServiceCallHelper
{
	private static final String CLASS_NAME = PortalUserHelper.class.getName();
	private static final Logger logger = Logger.getLogger(CLASS_NAME);

	private static LoginHome lh;
	private static PortletServiceHome psh4L;
	private static PortletServiceHome psh;
	private static PortalStateManagerServiceHome psmsh;


	private static List<String> USERS_PROFILE_ATTRS = new ArrayList<String>();
	private static List<String> USERS_LOGIN_CHECK_ATTRS = new ArrayList<String>();
	private static List<String> USERS_LIST_ATTRS = new ArrayList<String>();
	private static List<String> USERS_STATUS_ATTRS = new ArrayList<String>();
	private static List<String> GROUP_ATTRS = new ArrayList<String>();

	public static final String UID = "uid";
	public static final String PASSWORD_KEY = "userPassword";
	public static final String PASSWORD_CHANGE_DATE = "lastPasswordChange";
	public static final String FIRST_NAME_KEY = "cn";
	public static final String MIDDLE_NAME_KEY = "middleName";
	public static final String LAST_NAME_KEY = "sn";
	public static final String JOB_TITLE_KEY = "title"; // Multiple
	public static final String ORG_TYPE_KEY = "businessCategory"; // Multiple
	public static final String ORG_NAME_KEY = "o"; // Single
	public static final String ORG_ID_KEY = "OrgID"; // Single
	public static final String MOBILE_KEY = "mobile"; // Multiple
	public static final String PHONE_KEY = "telephoneNumber"; // Multiple
	public static final String FAX_KEY = "facsimileTelephoneNumber"; // Multiple
	public static final String EMAIL1_KEY = "mail"; // Single
	public static final String EMAIL2_KEY = "othermail"; // Single
	public static final String OFFICE_ADDRESS_KEY = "postalAddress"; // Multiple
	public static final String CITY_KEY = "city"; // Single
	public static final String ZIP_KEY = "postalCode"; // Multiple
	public static final String DISTRICT_KEY = "District"; // Single
	public static final String STATE_KEY = "st"; // Multiple
	public static final String COUNTRY_KEY = "countryName"; // Multiple
	public static final String PREF_LANG_KEY = "preferredLanguage"; // Single
	public static final String USER_STATUS_KEY = "userState"; // Single
	public static final String PWD_ACCOUNT_LOCKED_TIME = "pwdAccountLockedTime";
	public static final String TERMS_ACCEPTED_KEY = "TermsAccepted"; // Single

	public static final String STATUS_ACTIVE = "ACTIVE";
	public static final String STATUS_INACTIVE = "INACTIVE";

	static
	{
		USERS_PROFILE_ATTRS.add(UID);
		USERS_PROFILE_ATTRS.add(FIRST_NAME_KEY);
		USERS_PROFILE_ATTRS.add(MIDDLE_NAME_KEY);
		USERS_PROFILE_ATTRS.add(LAST_NAME_KEY);
		USERS_PROFILE_ATTRS.add(JOB_TITLE_KEY);
		USERS_PROFILE_ATTRS.add(ORG_TYPE_KEY);
		USERS_PROFILE_ATTRS.add(ORG_ID_KEY);
		USERS_PROFILE_ATTRS.add(ORG_NAME_KEY);
		USERS_PROFILE_ATTRS.add(MOBILE_KEY);
		USERS_PROFILE_ATTRS.add(PHONE_KEY);
		USERS_PROFILE_ATTRS.add(FAX_KEY);
		USERS_PROFILE_ATTRS.add(EMAIL1_KEY);
		USERS_PROFILE_ATTRS.add(EMAIL2_KEY);
		USERS_PROFILE_ATTRS.add(OFFICE_ADDRESS_KEY);
		USERS_PROFILE_ATTRS.add(CITY_KEY);
		USERS_PROFILE_ATTRS.add(ZIP_KEY);
		USERS_PROFILE_ATTRS.add(DISTRICT_KEY);
		USERS_PROFILE_ATTRS.add(STATE_KEY);
		USERS_PROFILE_ATTRS.add(COUNTRY_KEY);
		USERS_PROFILE_ATTRS.add(PREF_LANG_KEY);
		USERS_PROFILE_ATTRS.add(USER_STATUS_KEY);
		USERS_PROFILE_ATTRS.add(PWD_ACCOUNT_LOCKED_TIME);
		USERS_PROFILE_ATTRS.add(PASSWORD_KEY);

		USERS_LIST_ATTRS.add(UID);
		USERS_LIST_ATTRS.add(USER_STATUS_KEY);
		USERS_LIST_ATTRS.add(FIRST_NAME_KEY);
		USERS_LIST_ATTRS.add(LAST_NAME_KEY);

		USERS_STATUS_ATTRS.add(USER_STATUS_KEY);
		USERS_STATUS_ATTRS.add(PASSWORD_KEY);
		
		USERS_LOGIN_CHECK_ATTRS.add(TERMS_ACCEPTED_KEY);
		USERS_LOGIN_CHECK_ATTRS.add(PASSWORD_CHANGE_DATE);

		GROUP_ATTRS.add(FIRST_NAME_KEY);

		logger.logp(Level.CONFIG, CLASS_NAME, "static-block", "PortalUserHelper - Static code initializer executed.");

		try
		{
			final Context ctx = new InitialContext();
			psh = (PortletServiceHome) ctx.lookup(PumaHome.JNDI_NAME);
			psmsh = (PortalStateManagerServiceHome) ctx.lookup(PortalStateManagerServiceHome.JNDI_NAME);
			psh4L = (PortletServiceHome) ctx.lookup(LoginHome.JNDI_NAME);
			lh = (LoginHome) psh4L.getPortletService(LoginHome.class);

			if (psh != null)
				logger.logp(Level.CONFIG, CLASS_NAME, "static-code", "Portlet Service Home Initialized successfully.....");

			if (psmsh != null)
				logger.logp(Level.CONFIG, CLASS_NAME, "static-code", "Portal State Manager Service Home Initialized successfully.....");

			if (psh4L != null && lh != null)
				logger.logp(Level.CONFIG, CLASS_NAME, "static-code", "Portal Service Home and Login Home Initialized successfully.....");
		}
		catch (Exception ex)
		{
			logger.logp(Level.SEVERE, CLASS_NAME, "static-code_Exception", ex.getMessage());
			if (logger.isLoggable(Level.FINEST))
				ex.printStackTrace();
		}
	}

	public PortalUserSessionDataBean retrieveCurrentUserProfile(PortalUserSessionDataBean sesObj)
	{
		final String methodName = "retrieveCurrentUserProfile";
		logger.entering(CLASS_NAME, methodName);
		try
		{
			if (psh != null)
			{
				PumaHome service = (PumaHome) psh.getPortletService(PumaHome.class);
				PumaProfile pp = service.getProfile(sesObj.getRequest());
				PumaLocator pl = service.getLocator(sesObj.getRequest());
				User user = pp.getCurrentUser();
				Map<String, Object> userAttributes = getLdapAttributes(pp, user, USERS_PROFILE_ATTRS);
				sesObj.setAssignedGroups(getUserGroups(pp, pl, user));
				return mapAttributesToEntity(sesObj, userAttributes);
			}
			else
				logger.logp(Level.SEVERE, CLASS_NAME, methodName, "PortletServiceHome - psh is null");
		}
		catch (Exception e)
		{
			logger.logp(Level.SEVERE, CLASS_NAME, methodName, e.getMessage());
			if (logger.isLoggable(Level.FINEST))
				e.printStackTrace();
		}

		logger.exiting(CLASS_NAME, methodName);
		return sesObj;
	}
	
	public PortalUserSessionDataBean retrieveLoginCheckAttributes(PortalUserSessionDataBean sesObj)
	{
		final String methodName = "retrieveCurrentUserProfile";
		logger.entering(CLASS_NAME, methodName);
		try
		{
			if (psh != null)
			{
				PumaHome service = (PumaHome) psh.getPortletService(PumaHome.class);
				PumaProfile pp = service.getProfile(sesObj.getRequest());
				PumaLocator pl = service.getLocator(sesObj.getRequest());
				User user = pp.getCurrentUser();
				Map<String, Object> userAttributes = getLdapAttributes(pp, user, USERS_LOGIN_CHECK_ATTRS);
				sesObj.setAssignedGroups(getUserGroups(pp, pl, user));
				return mapAttributesToEntity(sesObj, userAttributes);
			}
			else
				logger.logp(Level.SEVERE, CLASS_NAME, methodName, "PortletServiceHome - psh is null");
		}
		catch (Exception e)
		{
			logger.logp(Level.SEVERE, CLASS_NAME, methodName, e.getMessage());
			if (logger.isLoggable(Level.FINEST))
				e.printStackTrace();
		}

		logger.exiting(CLASS_NAME, methodName);
		return sesObj;
	}

	public PortalUserSessionDataBean retrieveUserProfileById(PortalUserSessionDataBean sesObj)
	{
		final String methodName = "retrieveUserProfileById";
		logger.entering(CLASS_NAME, methodName);
		try
		{
			if (psh != null)
			{
				PumaHome service = (PumaHome) psh.getPortletService(PumaHome.class);
				PumaProfile pp = service.getProfile(sesObj.getRequest());
				PumaLocator pl = service.getLocator(sesObj.getRequest());
				
				if(sesObj.getUserId() == null)
					sesObj.setUserId(sesObj.getUserKey());

				User user = pl.findUserByIdentifier(sesObj.getUsers().get(sesObj.getUserKey()).getUserIdentifier());
				Map<String, Object> userAttributes = getLdapAttributes(pp, user, USERS_PROFILE_ATTRS);

				PortalUserSessionDataBean dObj = new PortalUserSessionDataBean();
				dObj = mapAttributesToEntity(dObj, userAttributes);
				dObj.setAssignedGroups(getUserGroups(pp, pl, user));
				sesObj.setAssignedGroups(dObj.getAssignedGroups()); // Fix defect # 3599
				sesObj.getUsers().put(sesObj.getUserKey(), dObj);
				
				if(logger.isLoggable(Level.CONFIG))
				{
					StringBuilder log = new StringBuilder();
					log.append("User Identifier is [").append(sesObj.getUsers().get(sesObj.getUserKey()).getUserIdentifier());
					log.append("], and ").append("User group membership is [").append(dObj.getAssignedGroups()).append("]");
					logger.logp(Level.CONFIG, CLASS_NAME, methodName, log.toString());
				}
			}
			else
				logger.logp(Level.SEVERE, CLASS_NAME, methodName, "PortletServiceHome - psh is null");
		}
		catch (Exception e)
		{
			logger.logp(Level.SEVERE, CLASS_NAME, "static-code_Exception", e.getMessage());
			if (logger.isLoggable(Level.FINEST))
				e.printStackTrace();
		}

		logger.exiting(CLASS_NAME, methodName);
		return sesObj;
	}

	public PortalUserSessionDataBean retrieveUsersList(PortalUserSessionDataBean sesObj) 
	{
		final String methodName = "retrieveUsersList";
		logger.entering(CLASS_NAME, methodName);
		try
		{
			if (!sesObj.getPartnerType().equalsIgnoreCase("sadad") && !sesObj.getPartnerKey().equalsIgnoreCase(sesObj.getOrganisationId()))
				throw new IllegalStateException("User is not authorised to perform query for other organisation.");

			if (psh != null)
			{
				PumaHome service = (PumaHome) psh.getPortletService(PumaHome.class);
				PumaProfile pp = service.getProfile(sesObj.getRequest());
				PumaLocator pl = service.getLocator(sesObj.getRequest());

				StringBuilder queryBuilder = new StringBuilder();
				queryBuilder.append("((").append(sesObj.getSearchCriteria()).append(" = '").append(sesObj.getSearchKeyword()).append("') and (").append(ORG_ID_KEY).append(" = '").append(sesObj.getOrganisationId()).append("'))");

				List<User> users = pl.findUsersByQuery(queryBuilder.toString());

				if (logger.isLoggable(Level.CONFIG))
				{
					StringBuilder log = new StringBuilder();;
					log.append("Search Criteria is ").append(queryBuilder.toString()).append(", and Result Count is " ).append(users.size());
					logger.logp(Level.CONFIG, CLASS_NAME, methodName, log.toString());
				}
				sesObj.getUsers().clear();
				if (users.size() > 0)
				{
					for (User user : users)
					{
						PortalUserSessionDataBean soUser = new PortalUserSessionDataBean();
						Map<String, Object> userAttributes = getLdapAttributes(pp, user, USERS_LIST_ATTRS);
						mapAttributesToEntity(soUser, userAttributes);
						sesObj.getUsers().put(soUser.getUserId(), soUser);
					}
				}
				else
				{
					String message = "No user found for the search criteria.";
					FaultType ft = new FaultType();
					ft.setType(ErrorType.BUSINESS);
					ft.setSeverity(SeverityType.ERROR);
					ft.setCode(400108);
					ft.setDescription(message);
					throw new SadadGenericFault(message, ft);
				}
			}
			else
				logger.logp(Level.SEVERE, CLASS_NAME, methodName, "PortletServiceHome - psh is null");
		}
		catch (SadadGenericFault e)
		{
			sesObj.transformS2ExceptionToS1(e.getFaultInfo());
			if(sesObj.getMessageToDisplay().getMessageType() == null)
				if (e.getFaultInfo().getType().equals(ErrorType.BUSINESS))
					sesObj.setErrorMessage(e.getFaultInfo().getDescription());
				else
					sesObj.setGenericErrorMessage();

			logger.logp(Level.SEVERE, CLASS_NAME, methodName, e.getMessage());
			if (logger.isLoggable(Level.FINEST))
				e.printStackTrace();
		}	
		catch (Exception e)
		{
			sesObj.setGenericErrorMessage();
			logger.logp(Level.SEVERE, CLASS_NAME, methodName, e.getMessage());
			if (logger.isLoggable(Level.FINEST))
				e.printStackTrace();
		}
		logger.exiting(CLASS_NAME, methodName);
		return sesObj;
	}

	private void changePassword(PortletRequest request, String userIdentifier, String newPassword) throws PumaAttributeException, PumaSystemException, PumaModelException, PumaMissingAccessRightsException, PortletServiceUnavailableException
	{
		final String methodName = "changePassword";
		logger.entering(CLASS_NAME, methodName);

		if (psh != null)
		{
			PumaHome service = (PumaHome) psh.getPortletService(PumaHome.class);
			PumaController pc = service.getController((ActionRequest) request);
			PumaLocator pl = service.getLocator(request);
			User user = pl.findUserByIdentifier(userIdentifier);
			Map<String, Object> attMap = new HashMap<String, Object>();

			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
			setAttributeValue(attMap, PASSWORD_CHANGE_DATE, sdf.format(new Date()));
			setAttributeValue(attMap, PASSWORD_KEY, newPassword);

			setLdapAttributes(pc, user, attMap);
		}
		else
			logger.logp(Level.SEVERE, CLASS_NAME, methodName, "PortletServiceHome - psh is null");

		logger.exiting(CLASS_NAME, methodName);
	}

	public PortalUserSessionDataBean changeSearchUserPassword(PortalUserSessionDataBean sesObj)
	{
		final String methodName = "changeSearchUserPassword";
		logger.entering(CLASS_NAME, methodName);

		try
		{
			if(sesObj.getUsers().get(sesObj.getUserKey()).getUserStatus().equalsIgnoreCase(STATUS_INACTIVE))
			{
				String message = "Access denied, the password cannot be changed for the inactive user.";
				FaultType ft = new FaultType();
				ft.setType(ErrorType.BUSINESS);
				ft.setSeverity(SeverityType.ERROR);
				ft.setCode(400109);
				ft.setDescription(message);
				throw new SadadGenericFault(message, ft);
			}
			changePassword(sesObj.getRequest(), sesObj.getUserIdentifier(), sesObj.getNewPassword());
			// Change the JSP page to Details page
			sesObj.getScreen().setContainer1("SearchProfileDetails.jsp");
			sesObj.navigate(PortalConstant.BACK);
		}
		
		catch (PumaException | PortletServiceUnavailableException e)
		{
			if (e.getMessage().indexOf("[LDAP: error code 19 - Error, Password in History]") > 0)
				sesObj.setErrorMessage(400110);
			else if (e.getMessage().indexOf("LDAP: error code 19 -") > 0)
				sesObj.setErrorMessage(400106);
			else
				sesObj.setGenericErrorMessage();

			logger.logp(Level.SEVERE, CLASS_NAME, methodName, e.getMessage());
			if (logger.isLoggable(Level.FINEST))
				e.printStackTrace();
		}
		catch (SadadGenericFault e)
		{
			sesObj.transformS2ExceptionToS1(e.getFaultInfo());
			if(sesObj.getMessageToDisplay().getMessageType() == null)
				if (e.getFaultInfo().getType().equals(ErrorType.BUSINESS))
					sesObj.setErrorMessage(e.getFaultInfo().getDescription());
				else
					sesObj.setGenericErrorMessage();

			logger.logp(Level.SEVERE, CLASS_NAME, methodName, e.getMessage());
			if (logger.isLoggable(Level.FINEST))
				e.printStackTrace();
		}	

		logger.exiting(CLASS_NAME, methodName);
		return sesObj;
	}
	
	public PortalUserSessionDataBean changeUserPasswordToActivate(PortalUserSessionDataBean sesObj)
	{
		final String methodName = "changeUserPasswordToActivate";
		logger.entering(CLASS_NAME, methodName);

		try
		{
			if (psh != null)
			{
				PumaHome service = (PumaHome) psh.getPortletService(PumaHome.class);
				PumaController pc = service.getController((ActionRequest) sesObj.getRequest());
				PumaLocator pl = service.getLocator(sesObj.getRequest());
				User user = pl.findUserByIdentifier(sesObj.getUsers().get(sesObj.getUserKey()).getUserIdentifier());

				changePassword(sesObj.getRequest(), sesObj.getUserIdentifier(), sesObj.getNewPassword());
				Map<String, Object> attMap = new HashMap<String, Object>();
				setAttributeValue(attMap, USER_STATUS_KEY, STATUS_ACTIVE);
				setLdapAttributes(pc, user, attMap);
				// Change the status manually here
				sesObj.getUsers().get(sesObj.getUserKey()).setUserStatus((String) attMap.get(USER_STATUS_KEY));

				// Change the JSP page to Details page
				sesObj.getScreen().setContainer1("SearchProfileDetails.jsp");
				sesObj.navigate(PortalConstant.BACK);
			}
			else
				logger.logp(Level.SEVERE, CLASS_NAME, methodName, "PortletServiceHome - psh is null");
		}
		catch (PumaException | PortletServiceUnavailableException e)
		{
			if (e.getMessage().indexOf("[LDAP: error code 19 - Error, Password in History]") > 0)
				sesObj.setErrorMessage(400110);
			else if (e.getMessage().indexOf("LDAP: error code 19 -") > 0)
				sesObj.setErrorMessage(400106);
			else
				sesObj.setGenericErrorMessage();

			logger.logp(Level.SEVERE, CLASS_NAME, methodName, e.getMessage());
			if (logger.isLoggable(Level.FINEST))
				e.printStackTrace();
		}

		logger.exiting(CLASS_NAME, methodName);
		return sesObj;
	}

	public PortalUserSessionDataBean changeUserPassword(PortletRequest request, PortletResponse response, PortalUserSessionDataBean sesObj)
	{
		final String methodName = "changeUserPassword";
		logger.entering(CLASS_NAME, methodName);

		try
		{
			if (lh != null)
				if (lh.getLoginService(request, response).checkPassword(sesObj.getUserId(), sesObj.getPassword().toCharArray()))
				{
					sesObj.setInfoMessage(400103);
					changePassword(sesObj.getRequest(), sesObj.getUserIdentifier(), sesObj.getNewPassword());
					sesObj.setInfoMessage(400102);
					sesObj.setNextPage(PortalConstant.SADAD_HOME_PAGE);
				}
				else
					throw new IllegalStateException();

		}
		catch (PasswordInvalidException | UserIDInvalidException | AuthenticationFailedException | IllegalStateException e)
		{
			sesObj.setErrorMessage(400101);
			logger.logp(Level.SEVERE, CLASS_NAME, methodName, e.getMessage());
			if (logger.isLoggable(Level.FINEST))
				e.printStackTrace();
		}
		catch (PumaException | PortletServiceUnavailableException e)
		{
			if (e.getMessage().indexOf("[LDAP: error code 19 - Error, Password in History]") > 0)
				sesObj.setErrorMessage(400110);
			else if (e.getMessage().indexOf("LDAP: error code 19 -") > 0)
				sesObj.setErrorMessage(400106);
			else
				sesObj.setGenericErrorMessage();

			logger.logp(Level.SEVERE, CLASS_NAME, methodName, e.getMessage());
			if (logger.isLoggable(Level.FINEST))
				e.printStackTrace();
		}

		logger.exiting(CLASS_NAME, methodName);
		return sesObj;
	}

	public PortalUserSessionDataBean changeUserStatus(PortalUserSessionDataBean sesObj)
	{
		final String methodName = "changeUserStatus";
		logger.entering(CLASS_NAME, methodName);
		try
		{
			if (psh != null)
			{
				PumaHome service = (PumaHome) psh.getPortletService(PumaHome.class);
				PumaController pc = service.getController((ActionRequest) sesObj.getRequest());
				PumaLocator pl = service.getLocator(sesObj.getRequest());
				User user = pl.findUserByIdentifier(sesObj.getUsers().get(sesObj.getUserKey()).getUserIdentifier());

				Map<String, Object> attMap = new HashMap<String, Object>();

				if (sesObj.getUsers().get(sesObj.getUserKey()).getUserStatus().equalsIgnoreCase(STATUS_ACTIVE))
				{
					setAttributeValue(attMap, USER_STATUS_KEY, STATUS_INACTIVE);
					setAttributeValue(attMap, PASSWORD_KEY, getInactivePassword());
				}
				else if (sesObj.getUsers().get(sesObj.getUserKey()).getUserStatus().equalsIgnoreCase(STATUS_INACTIVE))
				{
					setAttributeValue(attMap, USER_STATUS_KEY, STATUS_INACTIVE); // User will be activated after password change
					sesObj.getScreen().setContainer1("SearchProfileChangeInactivePasswordForm.jsp"); // Set new password for user
					sesObj.navigate(PortalConstant.NEXT);
				}

				setLdapAttributes(pc, user, attMap);
				// Change the status manually here
				sesObj.getUsers().get(sesObj.getUserKey()).setUserStatus((String) attMap.get(USER_STATUS_KEY));
			}
			else
				logger.logp(Level.SEVERE, CLASS_NAME, methodName, "PortletServiceHome - psh is null");
		}
		catch (Exception e)
		{
			logger.logp(Level.SEVERE, CLASS_NAME, methodName, e.getMessage());
			if (logger.isLoggable(Level.FINEST))
				e.printStackTrace();
			throw new IllegalStateException();
		}

		logger.exiting(CLASS_NAME, methodName);
		return sesObj;
	}
	
	public PortalUserSessionDataBean acceptTermsCondition(PortalUserSessionDataBean sesObj, PortletRequest request, PortletResponse response)
	{
		final String methodName = "acceptTermsCondition";
		logger.entering(CLASS_NAME, methodName);
		try
		{
			if (psh != null)
			{
				PumaHome service = (PumaHome) psh.getPortletService(PumaHome.class);
				PumaController pc = service.getController((ActionRequest) sesObj.getRequest());
				PumaLocator pl = service.getLocator(sesObj.getRequest());
				User user = pl.findUserByIdentifier(sesObj.getUserIdentifier());

				Map<String, Object> attMap = new HashMap<String, Object>();
				setAttributeValue(attMap, TERMS_ACCEPTED_KEY, "YES");
				setLdapAttributes(pc, user, attMap);

				sesObj = retrieveLoginCheckAttributes(sesObj);
			}
			else
				logger.logp(Level.SEVERE, CLASS_NAME, methodName, "PortletServiceHome - psh is null");
		}
		catch (Exception e)
		{
			logger.logp(Level.SEVERE, CLASS_NAME, methodName, e.getMessage());
			if (logger.isLoggable(Level.FINEST))
				e.printStackTrace();
			throw new IllegalStateException();
		}

		logger.exiting(CLASS_NAME, methodName);
		return sesObj;
	}

	public PortalUserSessionDataBean saveEditUserProfile(PortalUserSessionDataBean sesObj)
	{
		final String methodName = "saveEditUserProfile";
		logger.entering(CLASS_NAME, methodName);
		try
		{
			if (psh != null)
			{
				PumaHome service = (PumaHome) psh.getPortletService(PumaHome.class);
				PumaController pc = service.getController((ActionRequest) sesObj.getRequest());
				PumaLocator pl = service.getLocator(sesObj.getRequest());
				User user = pl.findUserByIdentifier(sesObj.getUserIdentifier());
				// Create a Map for Update
				Map<String, Object> attMap = new HashMap<String, Object>();
				// Populate map with desired key to be updated with session object values
				setAttributeValue(attMap, FIRST_NAME_KEY, sesObj.getFirstName());
				setAttributeValue(attMap, MIDDLE_NAME_KEY, sesObj.getMiddleName());
				setAttributeValue(attMap, LAST_NAME_KEY, sesObj.getLastName());
				setAttributeValue(attMap, JOB_TITLE_KEY, sesObj.getJobTitle());
				setAttributeValue(attMap, PHONE_KEY, sesObj.getPhoneNumber());
				setAttributeValue(attMap, FAX_KEY, sesObj.getFaxNumber());
				setAttributeValue(attMap, MOBILE_KEY, sesObj.getMobileNumber());
				setAttributeValue(attMap, EMAIL1_KEY, sesObj.getEmailAddress());
				setAttributeValue(attMap, EMAIL2_KEY, sesObj.getAlternateEmailAddress());
				setAttributeValue(attMap, OFFICE_ADDRESS_KEY, sesObj.getOfficeAddress());
				setAttributeValue(attMap, CITY_KEY, sesObj.getCity());
				setAttributeValue(attMap, ZIP_KEY, sesObj.getZipCode());
				setAttributeValue(attMap, DISTRICT_KEY, sesObj.getDistrict());
				setAttributeValue(attMap, STATE_KEY, sesObj.getState());
				setAttributeValue(attMap, PREF_LANG_KEY, sesObj.getPreferredLanguage());
				if((! sesObj.getUsers().isEmpty()) && (sesObj.getUserKey() != null))
				{
					if(sesObj.getUserId().equals(sesObj.getUserKey()))
					setAttributeValue(attMap, USER_STATUS_KEY, sesObj.getUsers().get(sesObj.getUserKey()).getUserStatus());
				}			

				// Push Changes to LDAP via PUMA API call
				setLdapAttributes(pc, user, attMap);

				// Change the status manually here by mapping attributes to entity
				sesObj = mapAttributesToEntity(sesObj, attMap);
				sesObj.setInfoMessage(400107);
			}
			else
				logger.logp(Level.SEVERE, CLASS_NAME, methodName, "PortletServiceHome - psh is null");
		}
		catch (PortletServiceUnavailableException e)
		{
			sesObj.setGenericErrorMessage();
			logger.logp(Level.SEVERE, CLASS_NAME, methodName, e.getMessage());
		}
		catch (PumaException e)
		{
			sesObj.setGenericErrorMessage();
			logger.logp(Level.SEVERE, CLASS_NAME, methodName, e.getMessage());
		}
		catch (Exception e)
		{
			sesObj.setGenericErrorMessage();
			logger.logp(Level.SEVERE, CLASS_NAME, methodName, e.getMessage());
		}
		logger.exiting(CLASS_NAME, methodName);
		return sesObj;
	}

	public PortalUserSessionDataBean createUserProfile(PortalUserSessionDataBean sesObj)
	{
		final String methodName = "createUserProfile";
		logger.entering(CLASS_NAME, methodName);
		
		if(sesObj.getMessageToDisplay() != null)
			sesObj.setMessageToDisplay(null); // Clear any previous attemp messages

		try
		{
			if (psh != null)
			{
				PumaHome service = (PumaHome) psh.getPortletService(PumaHome.class);
				PumaController pc = service.getController((ActionRequest) sesObj.getRequest());
				// Create a Map for Update
				Map<String, Object> attMap = new HashMap<String, Object>();
				// Populate map with desired key to be updated with session object values
				
				if(sesObj.getUserStatus().equalsIgnoreCase(STATUS_INACTIVE))
					setAttributeValue(attMap, PASSWORD_KEY, getInactivePassword());
				else if(sesObj.getUserStatus().equalsIgnoreCase(STATUS_ACTIVE))
					setAttributeValue(attMap, PASSWORD_KEY, sesObj.getPassword());
				
				setAttributeValue(attMap, FIRST_NAME_KEY, sesObj.getFirstName());
				setAttributeValue(attMap, MIDDLE_NAME_KEY, sesObj.getMiddleName());
				setAttributeValue(attMap, LAST_NAME_KEY, sesObj.getLastName());

				// organisation type is not populated from Web Form so set the currentt partner type as organisation type
				if (sesObj.getPartnerType().equalsIgnoreCase("bank") || sesObj.getPartnerType().equalsIgnoreCase("biller") || sesObj.getPartnerType().equalsIgnoreCase("aggregator")) 
				{
					sesObj.setOrganisationId(sesObj.getPartnerKey());
					sesObj.setOrganisationType(sesObj.getPartnerType());
				}

				setAttributeValue(attMap, ORG_TYPE_KEY, sesObj.getOrganisationType());
				setAttributeValue(attMap, ORG_ID_KEY, sesObj.getOrganisationId());
				setAttributeValue(attMap, ORG_NAME_KEY, sesObj.getOrganisationName());
				setAttributeValue(attMap, JOB_TITLE_KEY, sesObj.getJobTitle());
				setAttributeValue(attMap, PHONE_KEY, sesObj.getPhoneNumber());
				setAttributeValue(attMap, FAX_KEY, sesObj.getFaxNumber());
				setAttributeValue(attMap, MOBILE_KEY, sesObj.getMobileNumber());
				setAttributeValue(attMap, EMAIL1_KEY, sesObj.getEmailAddress());
				setAttributeValue(attMap, EMAIL2_KEY, sesObj.getAlternateEmailAddress());
				setAttributeValue(attMap, OFFICE_ADDRESS_KEY, sesObj.getOfficeAddress());
				setAttributeValue(attMap, CITY_KEY, sesObj.getCity());
				setAttributeValue(attMap, ZIP_KEY, sesObj.getZipCode());
				setAttributeValue(attMap, DISTRICT_KEY, sesObj.getDistrict());
				setAttributeValue(attMap, STATE_KEY, sesObj.getState());
				setAttributeValue(attMap, COUNTRY_KEY, sesObj.getCountry());
				setAttributeValue(attMap, PREF_LANG_KEY, sesObj.getPreferredLanguage());
				setAttributeValue(attMap, TERMS_ACCEPTED_KEY, "NO");
				setAttributeValue(attMap, PASSWORD_CHANGE_DATE, "2000-01-01");
				setAttributeValue(attMap, USER_STATUS_KEY, sesObj.getUserStatus());

				pc.createUser(sesObj.getUserId(), SadadDynamicDataConfiguration.SDS_SUB_ENTRY_USERS, attMap);
				assignGroupsPermissions(sesObj.getRequest(), sesObj.getUserIdentifier(), null, sesObj.getNewGroups());
				// Change the status manually here by mapping attributes to entity
				sesObj.setInfoMessage(400104);
			}
			else
				logger.logp(Level.SEVERE, CLASS_NAME, methodName, "PortletServiceHome - psh is null");
		}
		catch (PumaException | PortletServiceUnavailableException e)
		{
			if (e.getMessage().indexOf("LDAP: error code 19 -") > 0)
				sesObj.setErrorMessage(400106);
	
			if (e.getClass().getName().equals("com.ibm.wps.um.exceptions.impl.MemberAlreadyExistsExceptionImpl"))
				sesObj.setErrorMessage(400105);

			logger.logp(Level.SEVERE, CLASS_NAME, methodName, e.getMessage());
			if (logger.isLoggable(Level.FINEST))
				e.printStackTrace();
		}

		logger.exiting(CLASS_NAME, methodName);
		return sesObj;
	}
	
	private String assignGroupsPermissions(PortletRequest request, String userIdentifier, String userAssignedGroups, String userNewGroups) throws PortletServiceUnavailableException, PumaException
	{
		final String methodName = "assignGroupsPermissions";
		Object[] param = {userIdentifier, userAssignedGroups, userNewGroups};
		logger.entering(CLASS_NAME, methodName, param);
		String asgGroup = null;
		if (psh != null)
		{
			final String dn = "cn=GROUP_NAME," + SadadDynamicDataConfiguration.SDS_SUB_ENTRY_GROUPS;
			PumaHome service = (PumaHome) psh.getPortletService(PumaHome.class);
			PumaController pc = service.getController((ActionRequest) request);
			PumaLocator pl = service.getLocator(request);
			User user = pl.findUserByIdentifier(userIdentifier);
			List<User> userList = new ArrayList<User>();
			userList.add(user);

			Set<String> newGroupSet, assignedGroupSet;
			if (userAssignedGroups == null)
				assignedGroupSet = new LinkedHashSet<String>();
			else
				assignedGroupSet = new LinkedHashSet<String>(Arrays.asList(userAssignedGroups.split(",")).stream().map(String :: trim).collect(Collectors.toList()));

			if (userNewGroups == null)
				newGroupSet = new LinkedHashSet<String>();
			else
				newGroupSet = new LinkedHashSet<String>(Arrays.asList(userNewGroups.split(",")));

			// Groups to be added
			newGroupSet.removeAll(assignedGroupSet);
			for (String g : newGroupSet)
			{
				if (g != null && g.trim().length() > 0)
				{
					g = g.trim();
					g = dn.replaceFirst("GROUP_NAME", g.trim());
					logger.logp(Level.CONFIG, CLASS_NAME, methodName, "Adding group " + g);
					Group group = pl.findGroupByIdentifier(g);
					pc.addToGroup(group, userList);
				}
			}

			// Refreshing values in Set
			if (userNewGroups == null)
				newGroupSet = new LinkedHashSet<String>();
			else
				newGroupSet = new LinkedHashSet<String>(Arrays.asList(userNewGroups.split(",")));

			// Groups to be removed
			assignedGroupSet.removeAll(newGroupSet);
			for (String g : assignedGroupSet)
			{
				if (g != null && g.trim().length() > 0)
				{
					g = g.trim();
					if (g.equalsIgnoreCase("wpsadmins") || g.equalsIgnoreCase("wcmadmins"))
						continue;
					g = dn.replaceFirst("GROUP_NAME", g);
					logger.logp(Level.CONFIG, CLASS_NAME, methodName, "Removing group " + g);
					Group group = pl.findGroupByIdentifier(g);
					pc.removeFromGroup(group, userList);
				}
			}
			asgGroup = getUserGroups(pc, pl, user);
		}
		else
			logger.logp(Level.SEVERE, CLASS_NAME, methodName, "PortletServiceHome - psh is null");

		logger.exiting(CLASS_NAME, methodName);
		return asgGroup;
	}
	
	public PortalUserSessionDataBean assignGroupsPermissionsForSearchUsers(PortalUserSessionDataBean sesObj)
	{
		final String methodName = "assignGroupsPermissionsForSearchUsers";
		logger.entering(CLASS_NAME, methodName);
		try
		{
			String assignedGroups = assignGroupsPermissions(sesObj.getRequest(), 
					sesObj.getUsers().get(sesObj.getUserKey()).getUserIdentifier(), 
					sesObj.getUsers().get(sesObj.getUserKey()).getAssignedGroups(), 
					sesObj.getNewGroups());
			// Change value of assigned group manually
			sesObj.setAssignedGroups(assignedGroups);
			sesObj.getUsers().get(sesObj.getUserKey()).setAssignedGroups(assignedGroups);

			if(logger.isLoggable(Level.CONFIG))
			{
				StringBuilder log = new StringBuilder();
				log.append("assignedGroups return value is ").append(assignedGroups);
				logger.logp(Level.CONFIG, CLASS_NAME, methodName, log.toString());
				logger.logp(Level.CONFIG, CLASS_NAME, methodName, sesObj.toString());
			}
		}
		catch(PumaException e)
		{
			logger.logp(Level.SEVERE, CLASS_NAME, methodName, e.getMessage());
			if (logger.isLoggable(Level.FINEST))
				e.printStackTrace();
		}
		catch (Exception e)
		{
			logger.logp(Level.SEVERE, CLASS_NAME, methodName, e.getMessage());
			if (logger.isLoggable(Level.FINEST))
				e.printStackTrace();
			throw new IllegalStateException();
		}

		// Change the JSP page to Details page
		sesObj.getScreen().setContainer1("SearchProfileDetails.jsp");
		sesObj.navigate(PortalConstant.BACK);

		logger.exiting(CLASS_NAME, methodName);
		return sesObj;
	}
	
	public PortalUserSessionDataBean assignGroupsPermissionsForNewUsers(PortalUserSessionDataBean sesObj)
	{
		final String methodName = "assignGroupsPermissionsForSearchUsers";
		logger.entering(CLASS_NAME, methodName);
		try
		{
			String assignedGroups = assignGroupsPermissions(sesObj.getRequest(), sesObj.getUserIdentifier(), sesObj.getAssignedGroups(), sesObj.getNewGroups());
			// Change value of assigned group manually
			sesObj.setAssignedGroups(assignedGroups);
		}
		catch (PumaException e)
		{
			logger.logp(Level.SEVERE, CLASS_NAME, methodName, e.getMessage());
			if (logger.isLoggable(Level.FINEST))
				e.printStackTrace();
		}
		catch (Exception e)
		{
			logger.logp(Level.SEVERE, CLASS_NAME, methodName, e.getMessage());
			if (logger.isLoggable(Level.FINEST))
				e.printStackTrace();
			throw new IllegalStateException();
		}
		logger.exiting(CLASS_NAME, methodName);
		return sesObj;
	}

	/**
	 * Save User profile to LDAP
	 * 
	 * @param sesObj
	 * @return sesObj
	 */
	public PortalUserSessionDataBean saveSearchUserProfile(PortalUserSessionDataBean sesObj)
	{
		final String methodName = "saveSearchUserProfile";
		logger.entering(CLASS_NAME, methodName);

		if(sesObj.getUserId() == null)
			sesObj.setUserId(sesObj.getUserKey());

		// Saving values to LDAP
		sesObj = saveEditUserProfile(sesObj);
		// Refreshing all values from LDAP
		sesObj = retrieveUserProfileById(sesObj);
		// Updating the cache user list
		sesObj.getUsers().put(sesObj.getUserKey(), sesObj);

		// Change the JSP page to Details page
		sesObj.getScreen().setContainer1("SearchProfileDetails.jsp");
		sesObj.navigate(PortalConstant.BACK);

		logger.exiting(CLASS_NAME, methodName);
		return sesObj;
	}

	/**
	 * Map LDAP attributes to Entity for Portal UI
	 * 
	 * @param sesObj
	 * @param map
	 * @return PortalUserSessionDataBean
	 */
	private PortalUserSessionDataBean mapAttributesToEntity(PortalUserSessionDataBean sesObj, Map<?, ?> map)
	{
		if (map.containsKey(UID))
			sesObj.setUserId(getAttributeValue(map, UID));
		if (map.containsKey(FIRST_NAME_KEY))
			sesObj.setFirstName(getAttributeValue(map, FIRST_NAME_KEY));
		if (map.containsKey(LAST_NAME_KEY))
			sesObj.setLastName(getAttributeValue(map, LAST_NAME_KEY));
		if (map.containsKey(MIDDLE_NAME_KEY))
			sesObj.setMiddleName(getAttributeValue(map, MIDDLE_NAME_KEY));
		if (map.containsKey(USER_STATUS_KEY))
			sesObj.setUserStatus(getAttributeValue(map, USER_STATUS_KEY));
		if (map.containsKey(JOB_TITLE_KEY))
			sesObj.setJobTitle(getAttributeValue(map, JOB_TITLE_KEY));
		if (map.containsKey(ORG_TYPE_KEY))
			sesObj.setOrganisationType(getAttributeValue(map, ORG_TYPE_KEY));
		if (map.containsKey(ORG_ID_KEY))
			sesObj.setOrganisationId(getAttributeValue(map, ORG_ID_KEY));
		if (map.containsKey(ORG_NAME_KEY))
			sesObj.setOrganisationName(getAttributeValue(map, ORG_NAME_KEY));
		if (map.containsKey(MOBILE_KEY))
			sesObj.setMobileNumber(getAttributeValue(map, MOBILE_KEY));
		if (map.containsKey(PHONE_KEY))
			sesObj.setPhoneNumber(getAttributeValue(map, PHONE_KEY));
		if (map.containsKey(FAX_KEY))
			sesObj.setFaxNumber(getAttributeValue(map, FAX_KEY));
		if (map.containsKey(EMAIL1_KEY))
			sesObj.setEmailAddress(getAttributeValue(map, EMAIL1_KEY));
		if (map.containsKey(EMAIL2_KEY))
			sesObj.setAlternateEmailAddress(getAttributeValue(map, EMAIL2_KEY));
		if (map.containsKey(OFFICE_ADDRESS_KEY))
			sesObj.setOfficeAddress(getAttributeValue(map, OFFICE_ADDRESS_KEY));
		if (map.containsKey(PREF_LANG_KEY))
			sesObj.setPreferredLanguage(getAttributeValue(map, PREF_LANG_KEY));
		if (map.containsKey(CITY_KEY))
			sesObj.setCity(getAttributeValue(map, CITY_KEY));
		if (map.containsKey(ZIP_KEY))
			sesObj.setZipCode(getAttributeValue(map, ZIP_KEY));
		if (map.containsKey(DISTRICT_KEY))
			sesObj.setDistrict(getAttributeValue(map, DISTRICT_KEY));
		if (map.containsKey(STATE_KEY))
			sesObj.setState(getAttributeValue(map, STATE_KEY));
		if (map.containsKey(COUNTRY_KEY))
			sesObj.setCountry(getAttributeValue(map, COUNTRY_KEY));
		if (map.containsKey(TERMS_ACCEPTED_KEY))
			sesObj.setTermsAccepted(getAttributeValue(map, TERMS_ACCEPTED_KEY));
		if(map.containsKey(PASSWORD_CHANGE_DATE))
			sesObj.setLastPasswordChangeDate(getAttributeValue(map, PASSWORD_CHANGE_DATE));

		return sesObj;
	}

	/**
	 * 
	 * @param attributesMap
	 * @param key
	 * @return
	 */
	private static String getAttributeValue(Map<?, ?> attributesMap, String key)
	{
		Object v = attributesMap.get(key);
		if (v == null)
			return null;

		if (List.class.isAssignableFrom(v.getClass()))
		{
			List<?> vals = (List<?>) v;
			if (vals.size() > 0)
				return (String) vals.get(0);
		}
		else
			return (String) v;

		return null;
	}

	/**
	 * 
	 * @param attributes
	 * @param key
	 * @param value
	 * @param typeMap
	 */
	private static void setAttributeValue(Map<String, Object> attributes, String key, String value)
	{
		SadadLdapDefinedUserAttributeDefinitions definedAttribute = new SadadLdapDefinedUserAttributeDefinitions(key);
		if (!definedAttribute.getAttributeName().equalsIgnoreCase("KEY_NOT_FOUND"))
		{
			if (definedAttribute.getAttributeType().equalsIgnoreCase("String"))
			{
				if (definedAttribute.isMultiValued())
				{
					List<String> lVal = new ArrayList<String>();
					lVal.add(value);
					attributes.put(key, lVal);
				}
				else
					attributes.put(key, value);
			}
			else
				logger.warning("Non-String attributes are not supported by Portal.");
		}
		else
			logger.warning(key + " is not defined as user attribute in LDAP.");
	}

	/**
	 * Retreive the LDAP attribute for the given list of attribute names
	 * 
	 * @param pp
	 *            - Puma Profile
	 * @param p
	 *            - Principal (User or Group)
	 * @param attList
	 * @return LDAP Attributes Maps
	 * @throws PumaAttributeException
	 * @throws PumaSystemException
	 * @throws PumaModelException
	 * @throws PumaMissingAccessRightsException
	 */
	private Map<String, Object> getLdapAttributes(PumaProfile pp, Principal p, List<String> attList) throws PumaAttributeException, PumaSystemException, PumaModelException, PumaMissingAccessRightsException
	{
		Map<String, Object> attMap = pp.getAttributes(p, attList);
		return attMap;
	}

	private void setLdapAttributes(PumaController pc, Principal p, Map<String, ?> attMap) throws PumaAttributeException, PumaSystemException, PumaModelException, PumaMissingAccessRightsException
	{
		pc.setAttributes(p, attMap);
	}

	/**
	 * Retreive the user groups from LDAP
	 * 
	 * @param pp
	 *            - Puma Profile
	 * @param pl
	 *            - Puma Locator
	 * @return Array of Strings have group name
	 * @throws PumaSystemException
	 * @throws PumaModelException
	 * @throws PumaMissingAccessRightsException
	 * @throws PumaException
	 */
	private String getUserGroups(PumaProfile pp, PumaLocator pl, User u) throws PumaSystemException, PumaModelException, PumaMissingAccessRightsException, PumaException
	{
		List<Group> lst = pl.findGroupsByPrincipal(u, false);

		if (lst.isEmpty())
			return "";

		StringBuilder sb = new StringBuilder();
		for (Group g : lst)
		{
			Map<String, Object> gm = getLdapAttributes(pp, g, GROUP_ATTRS);
			sb.append(getAttributeValue(gm, FIRST_NAME_KEY)).append(", ");
		}
		return sb.toString().substring(0, sb.toString().lastIndexOf(','));
	}

	public void logOutUser(PortletRequest request, PortletResponse response)
	{
		final String methodName = "logOutUser";
		logger.entering(CLASS_NAME, methodName);

		PortalStateManagerService mgr = null;
		LogoutActionAccessorController logoutCtrl = null;
		try
		{
			HttpServletRequest servRequest = com.ibm.ws.portletcontainer.portlet.PortletUtils.getHttpServletRequest(request);
			HttpServletResponse servResponse = com.ibm.ws.portletcontainer.portlet.PortletUtils.getHttpServletResponse(response);
			mgr = psmsh.getPortalStateManagerService(servRequest, servResponse);
			URLAccessorFactory urlFactory = (URLAccessorFactory) mgr.getAccessorFactory(URLAccessorFactory.class);
			EngineURL url = urlFactory.newURL(servRequest, servResponse, com.ibm.portal.state.Constants.EMPTY_COPY);
			LogoutActionAccessorFactory logoutFct = (LogoutActionAccessorFactory) mgr.getAccessorFactory(LogoutActionAccessorFactory.class);
			logoutCtrl = logoutFct.newLogoutActionController(servRequest, url.getState());
			String logoutURL = url.writeDispose(new StringWriter()).toString();
			servResponse.sendRedirect(logoutURL);
		}
		catch (CannotCloneDocumentModelException | CannotCreateDocumentException | StateNotInRequestException | UnknownAccessorTypeException | CannotInstantiateAccessorException | PostProcessorException | OutputMediatorException
				| IOException | StateManagerException e)
		{
			logger.logp(Level.SEVERE, CLASS_NAME, methodName, e.getMessage());
			if (logger.isLoggable(Level.FINEST))
				e.printStackTrace();
		}
		finally
		{
			if (mgr != null)
				mgr.dispose();
			if (logoutCtrl != null)
				logoutCtrl.dispose();
		}
		logger.exiting(CLASS_NAME, methodName);
	}
	
	public String getRedirectURL(final String pageID, PortletRequest request, PortletResponse response)
	{
		final String methodName = "getRedirectURL";
		logger.entering(CLASS_NAME, methodName);
		try
		{
			HttpServletRequest servRequest = com.ibm.ws.portletcontainer.portlet.PortletUtils.getHttpServletRequest(request);
			HttpServletResponse servResponse = com.ibm.ws.portletcontainer.portlet.PortletUtils.getHttpServletResponse(response);

			final PortalStateManagerService service = psmsh.getPortalStateManagerService(servRequest, servResponse);
			final URLFactory urlFactory = service.getURLFactory();
			final SelectionAccessorFactory selFct = (SelectionAccessorFactory) service.getAccessorFactory(SelectionAccessorFactory.class);
			try
			{
				final EngineURL url = urlFactory.newURL(null);
				url.setProtected(Boolean.TRUE);
				final SelectionAccessorController selCtrl = selFct.getSelectionAccessorController(url.getState());
				try
				{
					selCtrl.setSelection(pageID);
					return url.toString();
				}
				finally
				{
					selCtrl.dispose();
				}
			}
			finally
			{
				urlFactory.dispose();
				service.dispose();
			}
		}
		catch (Exception e)
		{
			logger.logp(Level.SEVERE, CLASS_NAME, methodName, e.getMessage());
			if (logger.isLoggable(Level.FINEST))
				e.printStackTrace();
			return null;
		}
	}

	public boolean isPasswordExpired(String date)
	{
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		if (date == null || date.length() == 0)
			return true;

		try
		{
			Date changeTime = format.parse(date);
			Date today = new Date();
			long difference = today.getTime() - changeTime.getTime();
			long oneday = 24 * 60 * 60 * 1000;
			
			// TODO Add to Configuration for Control
			long duration = 60 * oneday; // 60 days
			if (difference > duration)
				return true;
		}
		catch (ParseException e)
		{}
		return false;
	}

	/**
	 * Clear session object from server and restore the Screen-->Container 1, partner, partner and user type values back in object
	 * 
	 * @param sesObj
	 * @return
	 */
	public PortalUserSessionDataBean clearSessionBeanObject(PortalUserSessionDataBean sesObj)
	{
		return super.clearSessionBeanObject(sesObj, sesObj.getClass());
	}
	
	/**
	 * Generate random password for INACTIVE user
	 * @return random password
	 */
	private String getInactivePassword()
	{
		int leftLimit = 33; // ASCII starting limit
		int rightLimit = 126; // ASCII ending limit
		int targetStringLength = 64; // length of password
		Random random = new Random();		
		return random.ints(leftLimit, rightLimit + 1)
				.limit(targetStringLength)
				.collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
				.toString();
	}
	
	@SuppressWarnings("unused")
	private void interogationOfMap(Map<?, ?> mfi)
	{
		StringBuilder sb = new StringBuilder();
		sb.append(System.getProperty("line.separator"));
		for (Entry<?, ?> entry : mfi.entrySet())
		{
			sb.append("Key = ").append(entry.getKey()).append("  ");
			sb.append("Key Class = ").append(entry.getKey().getClass().getName()).append("\t");
			sb.append("Value = ").append(entry.getValue()).append("  ");
			sb.append("Value Class = ").append(entry.getValue().getClass().getName()).append(System.getProperty("line.separator"));
		}
		logger.logp(Level.CONFIG, CLASS_NAME, "interogationOfMap", sb.toString());
	}

	@SuppressWarnings("unused")
	private void interogationOfLDAP(ActionRequest request)
	{
		final String methodName = "interogationOfLDAP";
		logger.entering(CLASS_NAME, methodName);
		try
		{
			if (psh != null)
			{
				PumaHome service = (PumaHome) psh.getPortletService(PumaHome.class);
				PumaProfile pp = service.getProfile(request);

				List<AttributeDefinition> atrDef = pp.getDefinedUserAttributeDefinitions();
				List<String> artNam = pp.getDefinedUserAttributeNames();

				System.out.println("Printing Attribute Definitions");
				for (AttributeDefinition ad : atrDef)
				{
					System.out.print("Attribute Name : " + ad.getName());
					System.out.print("\t| Attribute Type : " + ad.getType());
					System.out.print("\t| Attribute isMultiValued : " + ad.isMultiValued());
					System.out.print("\t| Attribute isRequired : " + ad.isRequired());
					System.out.print("\t| Attribute isReadOnly : " + ad.isReadOnly());
					System.out.println();
				}

				System.out.println("Printing Attribute Names");
				for (String an : artNam)
				{
					System.out.println("\t Attribute Name : " + an);
				}
			}
			else
				logger.logp(Level.SEVERE, CLASS_NAME, methodName, "PortletServiceHome - psh is null");
		}
		catch (Exception e)
		{
			logger.logp(Level.SEVERE, CLASS_NAME, methodName, e.getMessage());
			if (logger.isLoggable(Level.FINEST))
				e.printStackTrace();
		}
		logger.exiting(CLASS_NAME, methodName);
	}
}