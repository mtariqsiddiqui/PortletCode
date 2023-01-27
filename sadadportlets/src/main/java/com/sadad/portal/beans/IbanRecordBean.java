package com.sadad.portal.beans;

public class IbanRecordBean
{
	private String billerId;
	private boolean processIbanAllowed;
	private boolean approvalRejectAllowed;
	private IbanCurrentRecordBean currentRecord;
	private IbanPendingRecordBean pendingRecord;

	public String getBillerId()
	{
		return billerId;
	}

	public void setBillerId(String billerId)
	{
		this.billerId = billerId;
	}

	public boolean isProcessIbanAllowed()
	{
		return processIbanAllowed;
	}

	public void setProcessIbanAllowed(boolean processIbanAllowed)
	{
		this.processIbanAllowed = processIbanAllowed;
	}
	
	public boolean isApprovalRejectAllowed()
	{
		return approvalRejectAllowed;
	}

	public void setApprovalRejectAllowed(boolean approvalRejectAllowed)
	{
		this.approvalRejectAllowed = approvalRejectAllowed;
	}
	
	public IbanCurrentRecordBean getCurrentRecord()
	{
		return currentRecord;
	}

	public void setCurrentRecord(IbanCurrentRecordBean currentRecord)
	{
		this.currentRecord = currentRecord;
	}

	public IbanPendingRecordBean getPendingRecord()
	{
		return pendingRecord;
	}

	public void setPendingRecord(IbanPendingRecordBean pendingRecord)
	{
		this.pendingRecord = pendingRecord;
	}

	public class IbanCurrentRecordBean
	{
		private String iban;
		private String settlementId;
		private String customerIdType;
		private String customerId;
		private String accountType;
		private String status;
		private String createDate;

		public String getIban()
		{
			return iban;
		}

		public void setIban(String iban)
		{
			this.iban = iban;
		}

		public String getSettlementId()
		{
			return settlementId;
		}

		public void setSettlementId(String settlementId)
		{
			this.settlementId = settlementId;
		}

		public String getCustomerIdType()
		{
			return customerIdType;
		}

		public void setCustomerIdType(String customerIdType)
		{
			this.customerIdType = customerIdType;
		}

		public String getCustomerId()
		{
			return customerId;
		}

		public void setCustomerId(String customerId)
		{
			this.customerId = customerId;
		}

		public String getAccountType()
		{
			return accountType;
		}

		public void setAccountType(String accountType)
		{
			this.accountType = accountType;
		}

		public String getStatus()
		{
			return status;
		}

		public void setStatus(String status)
		{
			this.status = status;
		}

		public String getCreateDate()
		{
			return createDate;
		}

		public void setCreateDate(String createDate)
		{
			this.createDate = createDate;
		}
	}

	public class IbanPendingRecordBean extends IbanCurrentRecordBean
	{
		private String action;
		private String justification;

		public String getAction()
		{
			return action;
		}

		public void setAction(String action)
		{
			this.action = action;
		}

		public String getJustification()
		{
			return justification;
		}

		public void setJustification(String justification)
		{
			this.justification = justification;
		}
	}

}
