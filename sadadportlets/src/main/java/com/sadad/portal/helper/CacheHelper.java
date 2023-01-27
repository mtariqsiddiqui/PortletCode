package com.sadad.portal.helper;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.sadad.ebpp.scm.schema.cacheservice._1.GenericRefreshCacheRequestType;
import com.sadad.ebpp.scm.schema.cacheservice._1.RefreshCacheRequestType;
import com.sadad.ebpp.wsdl.cacheservice._1.CacheFaultMsg;
import com.sadad.portal.beans.CacheSessionDataBean;
import com.sadad.portal.services.client.helper.PortalServiceCallHelper;
import com.sadad.scm.error._1.ErrorType;

public class CacheHelper extends PortalServiceCallHelper
{
	private final static String CLASS_NAME = CacheHelper.class.getName();
	private static final Logger logger = Logger.getLogger(CLASS_NAME);

	/**
	 * Calls the backend webservice to refresh WAS Cache
	 * 
	 * @param sesObj
	 * @return
	 */
	public CacheSessionDataBean callRefreshCache(CacheSessionDataBean sesObj)
	{
		final String methodName = "callRefreshCache";
		logger.entering(CLASS_NAME, methodName);
		try
		{
			RefreshCacheRequestType req = new RefreshCacheRequestType();
			req.setMessageHeader(getMessageHeaderType("REFRESH_WAS_CACHE", sesObj.getRemoteUser(), sesObj.getLanguageCode()));
			req.setCacheName(sesObj.getCacheName());
			if(sesObj.getCacheKey() != null)
				req.setCacheKey(sesObj.getCacheKey());
			cacheService.refreshCache(req);
			// Service Call is successful
			sesObj.setGenericInfoMessage();
		}
		catch (CacheFaultMsg e)
		{
			sesObj.transformS2ExceptionToS1(e.getFaultInfo());
			if (sesObj.getMessageToDisplay().getMessageType() == null)
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

	/**
	 * 
	 * @param sesObj
	 * @return
	 */
	public CacheSessionDataBean callGenericRefreshCache(CacheSessionDataBean sesObj)
	{
		final String methodName = "callRefreshCache";
		logger.entering(CLASS_NAME, methodName);
		try
		{
			GenericRefreshCacheRequestType req = new GenericRefreshCacheRequestType();
			req.setMessageHeader(getMessageHeaderType("REFRESH_WAS_CACHE", sesObj.getRemoteUser(), sesObj.getLanguageCode()));
			if (sesObj.getCacheKey() != null)
				req.setCacheKey(sesObj.getCacheKey());
			if (sesObj.getCacheName() != null)
				req.setCacheName(sesObj.getCacheName());
			cacheService.genericRefreshCache(req);
			// Service Call is successful
			sesObj.setGenericInfoMessage();
		}
		catch (CacheFaultMsg e)
		{
			sesObj.transformS2ExceptionToS1(e.getFaultInfo());
			if (sesObj.getMessageToDisplay().getMessageType() == null)
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
}