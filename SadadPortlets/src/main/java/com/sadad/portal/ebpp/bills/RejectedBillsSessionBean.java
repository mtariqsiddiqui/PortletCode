/**
 * 
 */
package com.sadad.portal.ebpp.bills;

import java.util.ArrayList;
import java.util.List;

import com.sadad.portal.beans.Bill;
import com.sadad.portal.beans.RejectedEbppSessionBean;
import com.sadad.portal.beans.Screen;

/**
 * @author Tariq Siddiqui
 *
 */
public class RejectedBillsSessionBean extends RejectedEbppSessionBean
{
	private List<Bill> rejectedBills;

	public RejectedBillsSessionBean()
	{
		super();
	}

	public RejectedBillsSessionBean(int test)
	{
		this.screen = new Screen();		
		this.setPartnerKey("001");
		this.setEbppEntityKey("87456465784");
		
		Bill 
		bl = new Bill(); bl.setBillNumber("0201454096"); bl.setErrorCode("20003"); bl.setErrorDesc("Bill Number Not Found"); bl.setFileName("/sfs/biller/001/upload/001-BUPLRQ-20180119-1.xml"); this.getRejectedBills().add(bl);		
		bl = new Bill(); bl.setBillNumber("2014540697"); bl.setErrorCode("20003"); bl.setErrorDesc("Bill Number Not Found"); bl.setFileName("/sfs/biller/001/upload/001-BUPLRQ-20180119-1.xml"); this.getRejectedBills().add(bl);
		bl = new Bill(); bl.setBillNumber("2014540698"); bl.setErrorCode("20003"); bl.setErrorDesc("Bill Number Not Found"); bl.setFileName("/sfs/biller/001/upload/001-BUPLRQ-20180119-1.xml"); this.getRejectedBills().add(bl);
		bl = new Bill(); bl.setBillNumber("2014540699"); bl.setErrorCode("20003"); bl.setErrorDesc("Bill Number Not Found"); bl.setFileName("/sfs/biller/001/upload/001-BUPLRQ-20180119-1.xml"); this.getRejectedBills().add(bl);
		bl = new Bill(); bl.setBillNumber("2014540700"); bl.setErrorCode("20003"); bl.setErrorDesc("Bill Number Not Found"); bl.setFileName("/sfs/biller/001/upload/001-BUPLRQ-20180119-1.xml"); this.getRejectedBills().add(bl);
		bl = new Bill(); bl.setBillNumber("2014540701"); bl.setErrorCode("20003"); bl.setErrorDesc("Bill Number Not Found"); bl.setFileName("/sfs/biller/001/upload/001-BUPLRQ-20180119-1.xml"); this.getRejectedBills().add(bl);
		bl = new Bill(); bl.setBillNumber("2014540702"); bl.setErrorCode("20003"); bl.setErrorDesc("Bill Number Not Found"); bl.setFileName("/sfs/biller/001/upload/001-BUPLRQ-20180119-1.xml"); this.getRejectedBills().add(bl);
		bl = new Bill(); bl.setBillNumber("2014540703"); bl.setErrorCode("20003"); bl.setErrorDesc("Bill Number Not Found"); bl.setFileName("/sfs/biller/001/upload/001-BUPLRQ-20180119-1.xml"); this.getRejectedBills().add(bl);
		bl = new Bill(); bl.setBillNumber("2014540704"); bl.setErrorCode("20003"); bl.setErrorDesc("Bill Number Not Found"); bl.setFileName("/sfs/biller/001/upload/001-BUPLRQ-20180119-1.xml"); this.getRejectedBills().add(bl);
		bl = new Bill(); bl.setBillNumber("2014540705"); bl.setErrorCode("20003"); bl.setErrorDesc("Bill Number Not Found"); bl.setFileName("/sfs/biller/001/upload/001-BUPLRQ-20180119-1.xml"); this.getRejectedBills().add(bl);
		bl = new Bill(); bl.setBillNumber("2014540706"); bl.setErrorCode("20003"); bl.setErrorDesc("Bill Number Not Found"); bl.setFileName("/sfs/biller/001/upload/001-BUPLRQ-20180119-1.xml"); this.getRejectedBills().add(bl);
		bl = new Bill(); bl.setBillNumber("2014540707"); bl.setErrorCode("20003"); bl.setErrorDesc("Bill Number Not Found"); bl.setFileName("/sfs/biller/001/upload/001-BUPLRQ-20180119-1.xml"); this.getRejectedBills().add(bl);
		bl = new Bill(); bl.setBillNumber("2014540708"); bl.setErrorCode("20003"); bl.setErrorDesc("Bill Number Not Found"); bl.setFileName("/sfs/biller/001/upload/001-BUPLRQ-20180119-1.xml"); this.getRejectedBills().add(bl);
		bl = new Bill(); bl.setBillNumber("2014540709"); bl.setErrorCode("20003"); bl.setErrorDesc("Bill Number Not Found"); bl.setFileName("/sfs/biller/001/upload/001-BUPLRQ-20180119-1.xml"); this.getRejectedBills().add(bl);
		bl = new Bill(); bl.setBillNumber("2014540710"); bl.setErrorCode("20003"); bl.setErrorDesc("Bill Number Not Found"); bl.setFileName("/sfs/biller/001/upload/001-BUPLRQ-20180119-1.xml"); this.getRejectedBills().add(bl);
		bl = new Bill(); bl.setBillNumber("2014540711"); bl.setErrorCode("20003"); bl.setErrorDesc("Bill Number Not Found"); bl.setFileName("/sfs/biller/001/upload/001-BUPLRQ-20180119-1.xml"); this.getRejectedBills().add(bl);
		bl = new Bill(); bl.setBillNumber("2014540712"); bl.setErrorCode("20003"); bl.setErrorDesc("Bill Number Not Found"); bl.setFileName("/sfs/biller/001/upload/001-BUPLRQ-20180119-1.xml"); this.getRejectedBills().add(bl);
		bl = new Bill(); bl.setBillNumber("2014540713"); bl.setErrorCode("20003"); bl.setErrorDesc("Bill Number Not Found"); bl.setFileName("/sfs/biller/001/upload/001-BUPLRQ-20180119-1.xml"); this.getRejectedBills().add(bl);
		bl = new Bill(); bl.setBillNumber("2014540714"); bl.setErrorCode("20003"); bl.setErrorDesc("Bill Number Not Found"); bl.setFileName("/sfs/biller/001/upload/001-BUPLRQ-20180119-1.xml"); this.getRejectedBills().add(bl);
		bl = new Bill(); bl.setBillNumber("2014540715"); bl.setErrorCode("20003"); bl.setErrorDesc("Bill Number Not Found"); bl.setFileName("/sfs/biller/001/upload/001-BUPLRQ-20180119-1.xml"); this.getRejectedBills().add(bl);
		bl = new Bill(); bl.setBillNumber("2014540716"); bl.setErrorCode("20003"); bl.setErrorDesc("Bill Number Not Found"); bl.setFileName("/sfs/biller/001/upload/001-BUPLRQ-20180119-1.xml"); this.getRejectedBills().add(bl);
		bl = new Bill(); bl.setBillNumber("2014540717"); bl.setErrorCode("20003"); bl.setErrorDesc("Bill Number Not Found"); bl.setFileName("/sfs/biller/001/upload/001-BUPLRQ-20180119-1.xml"); this.getRejectedBills().add(bl);
	}


	/**
	 * @return the rejectedBills
	 */
	public List<Bill> getRejectedBills()
	{
		if(rejectedBills == null)
			rejectedBills = new ArrayList<Bill>();
		return rejectedBills;
	}
}