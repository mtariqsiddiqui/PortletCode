/**
 * 
 */
package com.sadad.portal.ebpp.payments;

import java.util.ArrayList;
import java.util.List;

import com.sadad.portal.beans.Payment;
import com.sadad.portal.beans.RejectedEbppSessionBean;
import com.sadad.portal.beans.Screen;

/**
 * @author Tariq Siddiqui
 *
 */
public class RejectedPaymentsSessionBean extends RejectedEbppSessionBean
{
	private List<Payment> rejectedPayments;


	public RejectedPaymentsSessionBean()
	{
		super();
	}

	public RejectedPaymentsSessionBean(int test)
	{
		this.screen = new Screen();		
		this.setPartnerKey("001");
		this.setEbppEntityKey("SD_0201454096");
		
		Payment 
		pl = new Payment(); pl.setSadadNumber("SD_0201454096"); pl.setErrorCode("20003"); pl.setErrorDesc("Payment Number Not Found"); pl.setFileName("/sfs/biller/001/upload/001-PUPLRQ-20180119-1.xml"); this.getRejectedPayments().add(pl);		
		pl = new Payment(); pl.setSadadNumber("SD_2014540697"); pl.setErrorCode("20003"); pl.setErrorDesc("Payment Number Not Found"); pl.setFileName("/sfs/biller/001/upload/001-PUPLRQ-20180119-1.xml"); this.getRejectedPayments().add(pl);
		pl = new Payment(); pl.setSadadNumber("SD_2014540698"); pl.setErrorCode("20003"); pl.setErrorDesc("Payment Number Not Found"); pl.setFileName("/sfs/biller/001/upload/001-PUPLRQ-20180119-1.xml"); this.getRejectedPayments().add(pl);
		pl = new Payment(); pl.setSadadNumber("SD_2014540699"); pl.setErrorCode("20003"); pl.setErrorDesc("Payment Number Not Found"); pl.setFileName("/sfs/biller/001/upload/001-PUPLRQ-20180119-1.xml"); this.getRejectedPayments().add(pl);
		pl = new Payment(); pl.setSadadNumber("SD_2014540700"); pl.setErrorCode("20003"); pl.setErrorDesc("Payment Number Not Found"); pl.setFileName("/sfs/biller/001/upload/001-PUPLRQ-20180119-1.xml"); this.getRejectedPayments().add(pl);
		pl = new Payment(); pl.setSadadNumber("SD_2014540701"); pl.setErrorCode("20003"); pl.setErrorDesc("Payment Number Not Found"); pl.setFileName("/sfs/biller/001/upload/001-PUPLRQ-20180119-1.xml"); this.getRejectedPayments().add(pl);
		pl = new Payment(); pl.setSadadNumber("SD_2014540702"); pl.setErrorCode("20003"); pl.setErrorDesc("Payment Number Not Found"); pl.setFileName("/sfs/biller/001/upload/001-PUPLRQ-20180119-1.xml"); this.getRejectedPayments().add(pl);
		pl = new Payment(); pl.setSadadNumber("SD_2014540703"); pl.setErrorCode("20003"); pl.setErrorDesc("Payment Number Not Found"); pl.setFileName("/sfs/biller/001/upload/001-PUPLRQ-20180119-1.xml"); this.getRejectedPayments().add(pl);
		pl = new Payment(); pl.setSadadNumber("SD_2014540704"); pl.setErrorCode("20003"); pl.setErrorDesc("Payment Number Not Found"); pl.setFileName("/sfs/biller/001/upload/001-PUPLRQ-20180119-1.xml"); this.getRejectedPayments().add(pl);
		pl = new Payment(); pl.setSadadNumber("SD_2014540705"); pl.setErrorCode("20003"); pl.setErrorDesc("Payment Number Not Found"); pl.setFileName("/sfs/biller/001/upload/001-PUPLRQ-20180119-1.xml"); this.getRejectedPayments().add(pl);
		pl = new Payment(); pl.setSadadNumber("SD_2014540706"); pl.setErrorCode("20003"); pl.setErrorDesc("Payment Number Not Found"); pl.setFileName("/sfs/biller/001/upload/001-PUPLRQ-20180119-1.xml"); this.getRejectedPayments().add(pl);
		pl = new Payment(); pl.setSadadNumber("SD_2014540707"); pl.setErrorCode("20003"); pl.setErrorDesc("Payment Number Not Found"); pl.setFileName("/sfs/biller/001/upload/001-PUPLRQ-20180119-1.xml"); this.getRejectedPayments().add(pl);
		pl = new Payment(); pl.setSadadNumber("SD_2014540708"); pl.setErrorCode("20003"); pl.setErrorDesc("Payment Number Not Found"); pl.setFileName("/sfs/biller/001/upload/001-PUPLRQ-20180119-1.xml"); this.getRejectedPayments().add(pl);
		pl = new Payment(); pl.setSadadNumber("SD_2014540709"); pl.setErrorCode("20003"); pl.setErrorDesc("Payment Number Not Found"); pl.setFileName("/sfs/biller/001/upload/001-PUPLRQ-20180119-1.xml"); this.getRejectedPayments().add(pl);
		pl = new Payment(); pl.setSadadNumber("SD_2014540710"); pl.setErrorCode("20003"); pl.setErrorDesc("Payment Number Not Found"); pl.setFileName("/sfs/biller/001/upload/001-PUPLRQ-20180119-1.xml"); this.getRejectedPayments().add(pl);
		pl = new Payment(); pl.setSadadNumber("SD_2014540711"); pl.setErrorCode("20003"); pl.setErrorDesc("Payment Number Not Found"); pl.setFileName("/sfs/biller/001/upload/001-PUPLRQ-20180119-1.xml"); this.getRejectedPayments().add(pl);
		pl = new Payment(); pl.setSadadNumber("SD_2014540712"); pl.setErrorCode("20003"); pl.setErrorDesc("Payment Number Not Found"); pl.setFileName("/sfs/biller/001/upload/001-PUPLRQ-20180119-1.xml"); this.getRejectedPayments().add(pl);
		pl = new Payment(); pl.setSadadNumber("SD_2014540713"); pl.setErrorCode("20003"); pl.setErrorDesc("Payment Number Not Found"); pl.setFileName("/sfs/biller/001/upload/001-PUPLRQ-20180119-1.xml"); this.getRejectedPayments().add(pl);
		pl = new Payment(); pl.setSadadNumber("SD_2014540714"); pl.setErrorCode("20003"); pl.setErrorDesc("Payment Number Not Found"); pl.setFileName("/sfs/biller/001/upload/001-PUPLRQ-20180119-1.xml"); this.getRejectedPayments().add(pl);
		pl = new Payment(); pl.setSadadNumber("SD_2014540715"); pl.setErrorCode("20003"); pl.setErrorDesc("Payment Number Not Found"); pl.setFileName("/sfs/biller/001/upload/001-PUPLRQ-20180119-1.xml"); this.getRejectedPayments().add(pl);
		pl = new Payment(); pl.setSadadNumber("SD_2014540716"); pl.setErrorCode("20003"); pl.setErrorDesc("Payment Number Not Found"); pl.setFileName("/sfs/biller/001/upload/001-PUPLRQ-20180119-1.xml"); this.getRejectedPayments().add(pl);
		pl = new Payment(); pl.setSadadNumber("SD_2014540717"); pl.setErrorCode("20003"); pl.setErrorDesc("Payment Number Not Found"); pl.setFileName("/sfs/biller/001/upload/001-PUPLRQ-20180119-1.xml"); this.getRejectedPayments().add(pl);
	}

	/**
	 * @return the rejectedPayments
	 */
	public List<Payment> getRejectedPayments()
	{
		if(rejectedPayments == null)
			rejectedPayments = new ArrayList<Payment>();
		return rejectedPayments;
	}
	
	
}
