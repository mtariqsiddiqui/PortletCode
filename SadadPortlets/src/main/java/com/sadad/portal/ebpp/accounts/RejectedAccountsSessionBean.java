/**
 * 
 */
package com.sadad.portal.ebpp.accounts;

import java.util.ArrayList;
import java.util.List;

import com.sadad.portal.beans.Account;
import com.sadad.portal.beans.RejectedEbppSessionBean;
import com.sadad.portal.beans.Screen;

/**
 * @author Tariq Siddiqui
 * 
 */
public class RejectedAccountsSessionBean extends RejectedEbppSessionBean
{
	private List<Account> rejectedAccounts;

	public RejectedAccountsSessionBean()
	{
		super();
	}

	public RejectedAccountsSessionBean(int test)
	{
		this.screen = new Screen();		
		this.setPartnerKey("001");
		this.setEbppEntityKey("966456465784");
		
		Account 
		ac = new Account(); ac.setAccountNumber("02014540696"); ac.setErrorCode("20003"); ac.setErrorDesc("Account Number Not Found"); ac.setFileName("/sfs/biller/001/upload/001-AUPLRQ-20180119-1.xml"); this.getRejectedAccounts().add(ac);		
		ac = new Account(); ac.setAccountNumber("2014540697"); ac.setErrorCode("20003"); ac.setErrorDesc("Account Number Not Found"); ac.setFileName("/sfs/biller/001/upload/001-AUPLRQ-20180119-1.xml"); this.getRejectedAccounts().add(ac);
		ac = new Account(); ac.setAccountNumber("2014540698"); ac.setErrorCode("20003"); ac.setErrorDesc("Account Number Not Found"); ac.setFileName("/sfs/biller/001/upload/001-AUPLRQ-20180119-1.xml"); this.getRejectedAccounts().add(ac);
		ac = new Account(); ac.setAccountNumber("2014540699"); ac.setErrorCode("20003"); ac.setErrorDesc("Account Number Not Found"); ac.setFileName("/sfs/biller/001/upload/001-AUPLRQ-20180119-1.xml"); this.getRejectedAccounts().add(ac);
		ac = new Account(); ac.setAccountNumber("2014540700"); ac.setErrorCode("20003"); ac.setErrorDesc("Account Number Not Found"); ac.setFileName("/sfs/biller/001/upload/001-AUPLRQ-20180119-1.xml"); this.getRejectedAccounts().add(ac);
		ac = new Account(); ac.setAccountNumber("2014540701"); ac.setErrorCode("20003"); ac.setErrorDesc("Account Number Not Found"); ac.setFileName("/sfs/biller/001/upload/001-AUPLRQ-20180119-1.xml"); this.getRejectedAccounts().add(ac);
		ac = new Account(); ac.setAccountNumber("2014540702"); ac.setErrorCode("20003"); ac.setErrorDesc("Account Number Not Found"); ac.setFileName("/sfs/biller/001/upload/001-AUPLRQ-20180119-1.xml"); this.getRejectedAccounts().add(ac);
		ac = new Account(); ac.setAccountNumber("2014540703"); ac.setErrorCode("20003"); ac.setErrorDesc("Account Number Not Found"); ac.setFileName("/sfs/biller/001/upload/001-AUPLRQ-20180119-1.xml"); this.getRejectedAccounts().add(ac);
		ac = new Account(); ac.setAccountNumber("2014540704"); ac.setErrorCode("20003"); ac.setErrorDesc("Account Number Not Found"); ac.setFileName("/sfs/biller/001/upload/001-AUPLRQ-20180119-1.xml"); this.getRejectedAccounts().add(ac);
		ac = new Account(); ac.setAccountNumber("2014540705"); ac.setErrorCode("20003"); ac.setErrorDesc("Account Number Not Found"); ac.setFileName("/sfs/biller/001/upload/001-AUPLRQ-20180119-1.xml"); this.getRejectedAccounts().add(ac);
		ac = new Account(); ac.setAccountNumber("2014540706"); ac.setErrorCode("20003"); ac.setErrorDesc("Account Number Not Found"); ac.setFileName("/sfs/biller/001/upload/001-AUPLRQ-20180119-1.xml"); this.getRejectedAccounts().add(ac);
		ac = new Account(); ac.setAccountNumber("2014540707"); ac.setErrorCode("20003"); ac.setErrorDesc("Account Number Not Found"); ac.setFileName("/sfs/biller/001/upload/001-AUPLRQ-20180119-1.xml"); this.getRejectedAccounts().add(ac);
		ac = new Account(); ac.setAccountNumber("2014540708"); ac.setErrorCode("20003"); ac.setErrorDesc("Account Number Not Found"); ac.setFileName("/sfs/biller/001/upload/001-AUPLRQ-20180119-1.xml"); this.getRejectedAccounts().add(ac);
		ac = new Account(); ac.setAccountNumber("2014540709"); ac.setErrorCode("20003"); ac.setErrorDesc("Account Number Not Found"); ac.setFileName("/sfs/biller/001/upload/001-AUPLRQ-20180119-1.xml"); this.getRejectedAccounts().add(ac);
		ac = new Account(); ac.setAccountNumber("2014540710"); ac.setErrorCode("20003"); ac.setErrorDesc("Account Number Not Found"); ac.setFileName("/sfs/biller/001/upload/001-AUPLRQ-20180119-1.xml"); this.getRejectedAccounts().add(ac);
		ac = new Account(); ac.setAccountNumber("2014540711"); ac.setErrorCode("20003"); ac.setErrorDesc("Account Number Not Found"); ac.setFileName("/sfs/biller/001/upload/001-AUPLRQ-20180119-1.xml"); this.getRejectedAccounts().add(ac);
		ac = new Account(); ac.setAccountNumber("2014540712"); ac.setErrorCode("20003"); ac.setErrorDesc("Account Number Not Found"); ac.setFileName("/sfs/biller/001/upload/001-AUPLRQ-20180119-1.xml"); this.getRejectedAccounts().add(ac);
		ac = new Account(); ac.setAccountNumber("2014540713"); ac.setErrorCode("20003"); ac.setErrorDesc("Account Number Not Found"); ac.setFileName("/sfs/biller/001/upload/001-AUPLRQ-20180119-1.xml"); this.getRejectedAccounts().add(ac);
		ac = new Account(); ac.setAccountNumber("2014540714"); ac.setErrorCode("20003"); ac.setErrorDesc("Account Number Not Found"); ac.setFileName("/sfs/biller/001/upload/001-AUPLRQ-20180119-1.xml"); this.getRejectedAccounts().add(ac);
		ac = new Account(); ac.setAccountNumber("2014540715"); ac.setErrorCode("20003"); ac.setErrorDesc("Account Number Not Found"); ac.setFileName("/sfs/biller/001/upload/001-AUPLRQ-20180119-1.xml"); this.getRejectedAccounts().add(ac);
		ac = new Account(); ac.setAccountNumber("2014540716"); ac.setErrorCode("20003"); ac.setErrorDesc("Account Number Not Found"); ac.setFileName("/sfs/biller/001/upload/001-AUPLRQ-20180119-1.xml"); this.getRejectedAccounts().add(ac);
		ac = new Account(); ac.setAccountNumber("2014540717"); ac.setErrorCode("20003"); ac.setErrorDesc("Account Number Not Found"); ac.setFileName("/sfs/biller/001/upload/001-AUPLRQ-20180119-1.xml"); this.getRejectedAccounts().add(ac);
	}

	/**
	 * @return the rejectedAccounts
	 */
	public List<Account> getRejectedAccounts()
	{
		if (rejectedAccounts == null)
			rejectedAccounts = new ArrayList<Account>();
		return rejectedAccounts;
	}
}
