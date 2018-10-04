package com.sadad.portal.beans;

public class Message
{
	private MessageType messageType;
	private String displayMessage;

	public Message()
	{}
	
	public Message(MessageType messageType, String displayMessage)
	{
		super();
		this.messageType = messageType;
		this.displayMessage = displayMessage;
	}

	/**
	 * @return the messageType
	 */
	public MessageType getMessageType()
	{
		return messageType;
	}

	/**
	 * @param messageType the messageType to set
	 */
	public void setMessageType(MessageType messageType)
	{
		this.messageType = messageType;
	}

	/**
	 * @return the displayMessage
	 */
	public String getDisplayMessage()
	{
		return displayMessage;
	}

	/**
	 * @param displayMessage the displayMessage to set
	 */
	public void setDisplayMessage(String displayMessage)
	{
		this.displayMessage = displayMessage;
	}
}