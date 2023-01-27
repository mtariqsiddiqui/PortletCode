/**
 * 
 */
package com.sadad.portal.common.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.portlet.PortletRequest;
import com.ibm.portal.portlet.service.PortletServiceHome;
import com.ibm.portal.portlet.service.PortletServiceUnavailableException;
import com.ibm.portal.um.Group;
import com.ibm.portal.um.PumaLocator;
import com.ibm.portal.um.PumaProfile;
import com.ibm.portal.um.User;
import com.ibm.portal.um.exceptions.PumaException;
import com.ibm.portal.um.portletservice.PumaHome;

/**
 * @author Tariq Siddiqui
 * 
 */
public class SadadPumaUtils
{
	private static final String CLASS_NAME = SadadPumaUtils.class.getName();
	private static final Logger logger = Logger.getLogger(CLASS_NAME);
	private static ArrayList<String> USER_ATTRS = new ArrayList<String>();
	private static ArrayList<String> GROUP_ATTRS = new ArrayList<String>();

	static
	{
		USER_ATTRS.add("sn");
		USER_ATTRS.add("uid");
		USER_ATTRS.add("OrgID");
		USER_ATTRS.add("TermsAccepted");
		USER_ATTRS.add("lastPasswordChange");
		USER_ATTRS.add("businessCategory");
		GROUP_ATTRS.add("cn");
		
		logger.logp(Level.CONFIG, CLASS_NAME, "static-block", "SadadPumaUtils - Static code initializer executed.");
	}
	
	public static String[] whoAmI(PortletServiceHome psh, PortletRequest request)
	{
		final String methodName = "whoAmI";
		logger.entering(CLASS_NAME, methodName);

		try
		{
			if (psh != null)
			{
				PumaHome service;
				service = (PumaHome) psh.getPortletService(PumaHome.class);
				PumaLocator pl = service.getLocator(request);
				PumaProfile pp = service.getProfile(request);
				User user = pp.getCurrentUser();

				Map<String, Object> ua = pp.getAttributes(user, USER_ATTRS);

				String[] s = { ua.get("OrgID").toString(), // index 0 - Organisation ID - SADAD-001, SAMBASARI, 001, 005 etc. 
							   ua.get("businessCategory").toString().substring(1, ua.get("businessCategory").toString().length() - 1).toLowerCase(), // index 1 - Organisation Type - sadad, bank or biller
							   "userType", // index 2 - User Type Admin or User SadadAdmins, BankAdmins and BillerAdmins are admin, whereas SadadUsers, BankUsers and BillerUsers are user
							   "userGroups" }; // index 3 - CSV list of groups which user have membership

				List<Group> lst = pl.findGroupsByPrincipal(user, false);
				if(! lst.isEmpty())
				{
					StringBuilder sb = new StringBuilder();
					for (Group g : lst)
					{
						Map<String, Object> gm = pp.getAttributes(g, GROUP_ATTRS);
						sb.append(gm.get("cn").toString()).append(',');
					}
					String gmo = sb.toString().substring(0, sb.toString().lastIndexOf(','));
					if(gmo.indexOf("Admins") > -1)
						s[2] = "admin";
					else
						s[2] = "user";

					s[3] = gmo;
				}				
				logger.exiting(CLASS_NAME, methodName);
				return s;
			}
		}
		catch (PortletServiceUnavailableException e)
		{
			logger.logp(Level.SEVERE, CLASS_NAME, methodName, e.getMessage());
			if (logger.isLoggable(Level.FINEST))
				e.printStackTrace();
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
		}

		logger.exiting(CLASS_NAME, methodName);
		return null;
	}
	
	public static void whatCanIDo(PortletServiceHome psh, PortletRequest request)
	{
		final String methodName = "whatCanIDo";
		logger.entering(CLASS_NAME, methodName);
		
		try
		{
			if (psh != null)
			{
				PumaHome service;
				service = (PumaHome) psh.getPortletService(PumaHome.class);
				PumaLocator pl = service.getLocator(request);
				PumaProfile pp = service.getProfile(request);

				boolean paramBoolean = false;
				pl.findGroupsByPrincipal(pp.getCurrentUser(), paramBoolean);
			}
		}
		catch (PumaException e)
		{
			logger.logp(Level.SEVERE, CLASS_NAME, methodName, e.getMessage());
			if (logger.isLoggable(Level.FINEST))
				e.printStackTrace();
			throw new IllegalStateException(e);
		}
		catch (PortletServiceUnavailableException e)
		{
			logger.logp(Level.SEVERE, CLASS_NAME, methodName, e.getMessage());
			if (logger.isLoggable(Level.FINEST))
				e.printStackTrace();
			throw new IllegalStateException(e);
		}
		logger.exiting(CLASS_NAME, methodName);
	}
}