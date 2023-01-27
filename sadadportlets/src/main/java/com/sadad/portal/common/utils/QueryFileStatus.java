package com.sadad.portal.common.utils;

public enum QueryFileStatus
{
	ALL("All", "FAILED_TO_PARSE,DUPLICATE_RQUID,RECEIVED,HOLD,READY_TO_PROCESS,VALIDATING,FAILED_TO_VALIDATE,VALIDATED,INVALID,FAILED_TO_CHUNK,CHUNKING,RECORD_PROCESSING,FAILED_TO_PROCESS,PROCESSED,GENERATED,SENDING,SENT,FAILED_TO_SEND"),
	STAGINGFILE_ARRIVED("Arrived", "RECEIVED,HOLD"),
	STAGINGFILE_PROCESSED("Processed", "PROCESSED,GENERATED,SENDING,SENT,FAILED_TO_SEND"),
	STAGINGFILE_INPROCESS("In Process", "READY_TO_PROCESS,VALIDATING,FAILED_TO_VALIDATE,VALIDATED,INVALID,FAILED_TO_CHUNK,CHUNKING,RECORD_PROCESSING,FAILED_TO_PROCESS,PROCESSED"),
	STAGINGFILE_REJECTED("Rejected", "FAILED_TO_PARSE,DUPLICATE_RQUID");
	
	QueryFileStatus(final String name, final String value)
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
