/**
 * 
 */
package com.sadad.portal.beans;

import java.util.ArrayDeque;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.ResourceBundle;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import com.sadad.portal.constant.PortalConstant;

/**
 * @author Tariq Siddiqui
 * 
 */
public abstract class SadadPortalSessionBean
{
	private static final ResourceBundle rb = ResourceBundle.getBundle(PortalConstant.SADAD_COMMOM_RESOURCE);

	protected Screen screen;
	protected String partnerKey;
	protected ArrayDeque<Screen> screens;
	protected Message messageToDisplay;

	public SadadPortalSessionBean()
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
	public ArrayDeque<Screen> getScreens()
	{
		if (screens == null)
			screens = new ArrayDeque<Screen>();
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
	 * @param messageToDisplay
	 *            the messageToDisplay to set
	 */
	public void setMessageToDisplay(Message messageToDisplay)
	{
		this.messageToDisplay = messageToDisplay;
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

	public void setGenericErrorMessage()
	{
		Message m = new Message();
		m.setMessageType(MessageType.ERROR);
		m.setDisplayMessage(rb.getString(PortalConstant.SADAD_GENERIC_ERROR));
		setMessageToDisplay(m);
	}
	
	public void setGenericInfoMessage()
	{
		Message m = new Message();
		m.setMessageType(MessageType.INFO);
		m.setDisplayMessage(rb.getString(PortalConstant.SADAD_GENERIC_INFO));
		setMessageToDisplay(m);
	}
	
	/**
	 * Use to get the date in XML format
	 * @param diff - difference, pass 0 to get current date, -1 for yesterday and 1 for tomorrow
	 * @return
	 */
	protected XMLGregorianCalendar getXmlDate(int diff)
	{
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTime(new Date());
		gc.add(Calendar.DATE, diff);
		XMLGregorianCalendar cd = null;
		try
		{
			cd = DatatypeFactory.newInstance().newXMLGregorianCalendar(gc);
		}
		catch (DatatypeConfigurationException e)
		{
			e.printStackTrace();
		}
		return cd;
	}
}