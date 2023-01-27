package com.sadad.portal.ebpp.accounts;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import com.sadad.portal.beans.Account;
import com.sadad.portal.beans.Association;
import com.sadad.portal.beans.Audit;
import com.sadad.portal.beans.Bill;
import com.sadad.portal.beans.BusinessRule;
import com.sadad.portal.beans.CoreEbppSessionBean;
import com.sadad.portal.beans.Customer;
import com.sadad.portal.beans.Payment;
import com.sadad.portal.beans.Refund;
import com.sadad.portal.beans.Screen;
import com.sadad.scm.common._1.AccountLifecycleEnums;
import com.sadad.scm.common._1.AccountSourceEnum;
import com.sadad.scm.common._1.PartyIdTypeType;
import com.sadad.scm.common._1.PartyLifecycleEnums;
import com.sadad.scm.common._1.PartyType;
import com.sadad.scm.common._1.PartyTypeType;
import com.sadad.scm.common._1.PaymentLifecycleEnums;

/**
 * @author Tariq Siddiqui
 * 
 */

public class QueryAccountSessionBean extends CoreEbppSessionBean 
{
	public QueryAccountSessionBean()
	{
		super();
	}
	
	public QueryAccountSessionBean(int test)
	{
		super();
		this.screen = new Screen();
		
		// Account Setup 
		this.account = new Account();
		this.account.setAccountNumber("100005978946");
		this.account.setBillerId("005");
		this.account.setServiceType("TSM");
		this.account.setAccountSource(AccountSourceEnum.AUPLRQ);
		this.account.setLifecycle(AccountLifecycleEnums.ACTIVE);	
		PartyType apt = new PartyType();
		apt.setPartyId("2295488664");
		apt.setPartyIdType(PartyIdTypeType.IQA);
		apt.setPartyName("Jamal Khan");
		apt.setPartyType(PartyTypeType.INDIVIDUAL);
		apt.setPartyStatus(PartyLifecycleEnums.ACTIVE);
		this.account.setBeneficiary(apt);
		this.account.setCreateDate(getXmlDate(0));
		//----------------------------------------------------------------
		
		// Customer Setup
		this.customer = new Customer();
		this.customer.setOfficialIdNumber("2295488664");
		this.customer.setOfficialIdType("IQA");
		this.customer.setCustomerStatus("ACTIVE");

		// Associations Setup
		Association asn = new Association();
		asn.setAccountNumber("966546789456");
		asn.setBillerId("001");
		asn.setOfficialIdNumber("2295488664");
		asn.setOfficialIdType("IQA");
		asn.setCustomerStatus("ACTIVE");
		asn.setAssociationType("BILLER");
		asn.setAssigningOrganization("STC");
		this.getAssociation().put("ASKEY_1", asn);
		asn = new Association();
		asn.setAccountNumber("96656009456");
		asn.setBillerId("005");
		asn.setOfficialIdNumber("2295488664");
		asn.setOfficialIdType("IQA");
		asn.setCustomerStatus("ACTIVE");
		asn.setAssociationType("BANK");
		asn.setAssigningOrganization("MOBILY");
		this.getAssociation().put("ASKEY_2", asn);
		asn = new Association();
		asn.setAccountNumber("100000546684");
		asn.setBillerId("005");
		asn.setOfficialIdNumber("2295488664");
		asn.setOfficialIdType("IQA");
		asn.setCustomerStatus("ACTIVE");
		asn.setAssociationType("BOTH");
		asn.setAssigningOrganization("MOBILY");
		this.getAssociation().put("ASKEY_3", asn);
		//----------------------------------------------------------------
		
		// Bills Setup
		Bill bl = new Bill();
		bl.setBillKey("B1");
		bl.setBillerId("001");
		bl.setServiceType("GSM");
		bl.setAccountNumber("966546789456");
		bl.setRquid("9d5e937a-0429-47ab-8687-0c3fb7394e76");
		bl.setBillNumber("BN#5498465");
		bl.setBillType("Recurring");
		bl.setBillCycle("1806-1807");
		bl.setBillStatus("ACTIVE");
		bl.setPaymentCount(0);
		bl.setOrigianlAmount(new BigDecimal(310.54).setScale(2, BigDecimal.ROUND_HALF_EVEN));
		bl.setNetAmount(new BigDecimal(310.54).setScale(2, BigDecimal.ROUND_HALF_EVEN));
		bl.setBillGeneratedDate(getXmlDate(0));
		bl.setBillCreateionDate(getXmlDate(0));
		bl.setDueDate(getXmlDate(20));
		bl.setExpiryDate(getXmlDate(35));
		this.getBills().put(bl.getBillKey(), bl);
		
		bl = new Bill();
		bl.setBillKey("B2");
		bl.setBillerId("005");
		bl.setServiceType("GSM");
		bl.setAccountNumber("966560089456");
		bl.setRquid("9d5e937a-0429-47ab-8687-as4643gdyh76");
		bl.setBillNumber("BN#5477995");
		bl.setBillType("Recurring");
		bl.setBillCycle("1806-1807");
		bl.setBillStatus("ACTIVE");
		bl.setPaymentCount(0);
		bl.setOrigianlAmount(new BigDecimal(418.94).setScale(2, BigDecimal.ROUND_HALF_EVEN));
		bl.setNetAmount(new BigDecimal(418.94).setScale(2, BigDecimal.ROUND_HALF_EVEN));
		bl.setBillGeneratedDate(getXmlDate(0));
		bl.setBillCreateionDate(getXmlDate(0));
		bl.setDueDate(getXmlDate(20));
		bl.setExpiryDate(getXmlDate(25));
		this.getBills().put(bl.getBillKey(), bl);
		//-----------------------------------------------------------------------------
		
		Payment 
		pm = new Payment();
		pm.setSadadNumber("SaDaD_33487946534");
		pm.setBankNumber("SMB_7687683764");
		pm.setReversalNumber("SMB_RVL_8789678678");
		pm.setGroupNumber("SMB_GRP_3456562435");
		pm.setBillerTransactionNumber("BLTR_0013446594");
		pm.setBillerId("001");
		pm.setBillNumber("BN#5477885");
		pm.setAccountNumber("966560089456");
		pm.setBillCycle("1805-1806");
		pm.setBankName("SAMBA");
		pm.setAccessChannel("WEB");
		pm.setCheckDigit("897328947");
		pm.setBranchCode("BRC_8513");
		pm.setDistrictCode("DC_987867");
		pm.setPaymentType("REGULAR");
		pm.setPaymentMethod("DEBIT_CARD");
		pm.setServiceId("SVC-4234");
		pm.setBeneficiaryId("2295488664");
		pm.setCustomerId("2295488664");
		pm.setRefundId("N_RFND_ID_ONE");	
		pm.setPaymentStatus(PaymentLifecycleEnums.COMPLETED);
		pm.setAmount(new BigDecimal(410.94).setScale(2, BigDecimal.ROUND_HALF_EVEN));
		pm.setProcessingDate(getXmlDate(-10));		
		this.getPayments().put(pm.getSadadNumber(), pm);
		
		pm = new Payment();
		pm.setSadadNumber("SaDaD_33423426004");
		pm.setBankNumber("SMB_7894697764");
		pm.setReversalNumber("SMB_RVL_8423254678");
		pm.setGroupNumber("SMB_GRP_3421325335");
		pm.setBillerTransactionNumber("BLTR_0114846594");
		pm.setBillerId("044");
		pm.setBillNumber("BN#5477787");
		pm.setAccountNumber("966560089546");
		pm.setBillCycle("1805-1806");
		pm.setBankName("SAMBA");
		pm.setAccessChannel("WEB");
		pm.setCheckDigit("897894647");
		pm.setBranchCode("BRC_8456");
		pm.setDistrictCode("DC_723467");
		pm.setPaymentType("REGULAR");
		pm.setPaymentMethod("DEBIT_CARD");
		pm.setServiceId("SVC-6514");
		pm.setBeneficiaryId("2295488664");
		pm.setCustomerId("2295488664");
		pm.setRefundId("N_RFND_ID_TNE");	
		pm.setPaymentStatus(PaymentLifecycleEnums.COMPLETED);
		pm.setAmount(new BigDecimal(510.94).setScale(2, BigDecimal.ROUND_HALF_EVEN));
		pm.setProcessingDate(getXmlDate(-10));
		this.getPayments().put(pm.getSadadNumber(), pm);
		
		pm = new Payment();
		pm.setSadadNumber("SaDaD_89465132104");
		pm.setBankNumber("SMB_9841321351");
		pm.setReversalNumber("SMB_RVL_8541645418");
		pm.setGroupNumber("SMB_GRP_9845132135");
		pm.setBillerTransactionNumber("BLTR_3546513214");
		pm.setBillerId("005");
		pm.setBillNumber("BN#55464217");
		pm.setAccountNumber("966568889546");
		pm.setBillCycle("1805-1806");
		pm.setBankName("SAMBA");
		pm.setAccessChannel("WEB");
		pm.setCheckDigit("878454647");
		pm.setBranchCode("BRC_8456");
		pm.setDistrictCode("DC_623467");
		pm.setPaymentType("REGULAR");
		pm.setPaymentMethod("DEBIT_CARD");
		pm.setServiceId("SVC-6542");
		pm.setBeneficiaryId("2295488664");
		pm.setCustomerId("2295488664");
		pm.setRefundId("N_RFND_ID_QWP");	
		pm.setPaymentStatus(PaymentLifecycleEnums.COMPLETED);
		pm.setAmount(new BigDecimal(810.64).setScale(2, BigDecimal.ROUND_HALF_EVEN));
		pm.setProcessingDate(getXmlDate(-10));		
		this.getPayments().put(pm.getSadadNumber(), pm);
		
		Refund 
		rf = new Refund();
		rf.setRefundId("09300005649874531654");
		rf.setBankId("INMASARI");
		rf.setBillerId("001");
		rf.setCustomerId("IQA2266455997");
		rf.setRefundType("ACCT");
		rf.setNotificationStatus(0);
		rf.setRefundTransactionNumber("RT_3847555");
		rf.setPaymentSptn("SD_3234234");
		rf.setAccountNumber("966504879516");
		rf.setRefundStatus("REFUND_APPROVED");
		rf.setAmount(new BigDecimal(607.64).setScale(2, BigDecimal.ROUND_HALF_EVEN));
		rf.setReconStatus(1);
		rf.setServiceId("RFD_SVC_ID");
		rf.setExpiryDate(getXmlDate(-10));
		this.getRefunds().put(rf.getRefundId(), rf);
		
		rf = new Refund();
		rf.setRefundId("09300005842184131654");
		rf.setBankId("INMASARI");
		rf.setBillerId("001");
		rf.setCustomerId("IQA2354685997");
		rf.setRefundType("ACCT");
		rf.setNotificationStatus(0);
		rf.setRefundTransactionNumber("RT_3845419");
		rf.setPaymentSptn("SD_3234234");
		rf.setAccountNumber("966507894516");
		rf.setRefundStatus("REFUND_APPROVED");
		rf.setAmount(new BigDecimal(767.00).setScale(2, BigDecimal.ROUND_HALF_EVEN));
		rf.setReconStatus(1);
		rf.setServiceId("RFD_SVC_ID");
		rf.setExpiryDate(getXmlDate(-32));
		this.getRefunds().put(rf.getRefundId(), rf);
		
		rf = new Refund();
		rf.setRefundId("09500000007843101301");
		rf.setBankId("INMASARI");
		rf.setBillerId("001");
		rf.setCustomerId("IQA2254658867");
		rf.setRefundType("ACCT");
		rf.setNotificationStatus(0);
		rf.setRefundTransactionNumber("RT_4510102");
		rf.setPaymentSptn("SD_1024574");
		rf.setAccountNumber("966507854210");
		rf.setRefundStatus("REFUND_APPROVED");
		rf.setAmount(new BigDecimal(250.00).setScale(2, BigDecimal.ROUND_HALF_EVEN));
		rf.setReconStatus(1);
		rf.setServiceId("RFD_SVC_ID");
		rf.setExpiryDate(getXmlDate(-20));
		this.getRefunds().put(rf.getRefundId(), rf);
		
		rf = new Refund();
		rf.setRefundId("09500744007843101301");
		rf.setBankId("INMASARI");
		rf.setBillerId("001");
		rf.setCustomerId("IQA2256578867");
		rf.setRefundType("ACCT");
		rf.setNotificationStatus(0);
		rf.setRefundTransactionNumber("RT_4510457");
		rf.setPaymentSptn("SD_1024574");
		rf.setAccountNumber("966507740020");
		rf.setRefundStatus("REFUND_APPROVED");
		rf.setAmount(new BigDecimal(350.00).setScale(2, BigDecimal.ROUND_HALF_EVEN));
		rf.setReconStatus(1);
		rf.setServiceId("RFD_SVC_ID");
		rf.setExpiryDate(getXmlDate(-5));
		this.getRefunds().put(rf.getRefundId(), rf);
		
		BusinessRule 
		br = new BusinessRule();
		br.setBillerId("005");
		br.setBillCategory("MPOS");
		br.setRuleType("PaymentValidation_OverPaymentAccessChannel");
		br.setRuleStatus("Active");
		this.getBusinessRules().add(br);

		br = new BusinessRule();
		br.setBillerId("005");
		br.setBillCategory("MPOS");
		br.setRuleType("PaymentValidation_UnderPaymentAccessChannel");
		br.setRuleStatus("Active");
		this.getBusinessRules().add(br);

		br = new BusinessRule();
		br.setBillerId("005");
		br.setBillCategory("");
		br.setRuleType("BillValidation_CustomerInitiatedPayment");
		br.setRuleStatus("Active");
		this.getBusinessRules().add(br);


		Audit 
		ad = new Audit();
		ad.setAuditDate(getXmlDate(-55));
		ad.setAuditAction("Created");
		ad.setAuditType("Biller");
		ad.setAuditSource("System");
		ad.setAuditOption("");
		this.getAudits().add(ad);
		
		ad = new Audit();
		ad.setAuditDate(getXmlDate(-50));
		ad.setAuditAction("Updated");
		ad.setAuditType("Biller");
		ad.setAuditSource("System");
		ad.setAuditOption("");
		this.getAudits().add(ad);
		
		ad = new Audit();
		ad.setAuditDate(getXmlDate(-45));
		ad.setAuditAction("Updated");
		ad.setAuditType("Bank");
		ad.setAuditSource("System");
		ad.setAuditOption("");
		this.getAudits().add(ad);
	}
	
	private XMLGregorianCalendar getXmlDate(int diff)
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
