package com.sadad.portal.helper;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.sadad.ebpp.schema.service.ibanmanagement._1.CreateIBANRqType;
import com.sadad.ebpp.schema.service.ibanmanagement._1.CreateIBANRsType;
import com.sadad.ebpp.schema.service.ibanmanagement._1.ListIBANRecordType;
import com.sadad.ebpp.schema.service.ibanmanagement._1.ListIBANRqType;
import com.sadad.ebpp.schema.service.ibanmanagement._1.ListIBANRsType;
import com.sadad.ebpp.schema.service.ibanmanagement._1.PendingIBANInfoType;
import com.sadad.ebpp.schema.service.ibanmanagement._1.ProcessIBANRqType;
import com.sadad.ebpp.schema.service.ibanmanagement._1.ProcessIBANRsType;
import com.sadad.ebpp.schema.service.ibanmanagement._1.ProcessIBANType;
import com.sadad.ebpp.schema.service.ibanmanagement._1.UpdateIBANRqType;
import com.sadad.ebpp.schema.service.ibanmanagement._1.UpdateIBANRsType;
import com.sadad.ebpp.wsdl.ibanmanagement._1.IBANManagementFault;
import com.sadad.portal.beans.IbanRecordBean;
import com.sadad.portal.beans.IbanRecordBean.IbanCurrentRecordBean;
import com.sadad.portal.beans.IbanRecordBean.IbanPendingRecordBean;
import com.sadad.portal.beans.IbanSessionDataBean;
import com.sadad.portal.constant.PortalConstant;
import com.sadad.portal.services.client.helper.PortalServiceCallHelper;
import com.sadad.scm.common._1.CustIdCType;
import com.sadad.scm.common._1.DateRangeCType;
import com.sadad.scm.common._1.IBANInfoType;
import com.sadad.scm.common._1.OfficialIdTypeCType;
import com.sadad.scm.error._1.ErrorType;
import com.sadad.scm.error._1.FaultType;
import com.sadad.scm.error._1.SeverityType;

/**
 * @author Tariq Siddiqui
 * 
 */
public class IbanHelper extends PortalServiceCallHelper
{
	private final static String CLASS_NAME = IbanHelper.class.getName();
	private static final Logger logger = Logger.getLogger(CLASS_NAME);

	/**
	 * Calls the backend webservice to create a new IBAN in database
	 * 
	 * @param sesObj
	 *            - IbanSessionDataBean populated with request parameters
	 * @return sesObj - IbanSessionDataBean populated with service response
	 */
	public IbanSessionDataBean callCreateIban(IbanSessionDataBean sesObj)
	{
		final String methodName = "callCreateIban";
		logger.entering(CLASS_NAME, methodName);
		try
		{
			if (sesObj.isIbanMaker() && sesObj.getBillerStatus().equalsIgnoreCase(PortalConstant.STATUS_ACTIVE)) // Check the user permission
			{
				CreateIBANRqType req = new CreateIBANRqType();
				req.setMessageHeader(getMessageHeaderType("CREATE_IBAN", sesObj.getRemoteUser(), sesObj.getLanguageCode()));
				IBANInfoType iit = new IBANInfoType();
				iit.setIBAN(sesObj.getIban());
				iit.setType("CUSTOMER");
				if (sesObj.getPartnerType().equalsIgnoreCase(PortalConstant.PARTNER_TYPE_BILLER))
					iit.setBillerKey(sesObj.getPartnerKey());
				else
					iit.setBillerKey(sesObj.getBillerId());
				iit.setCustomer(new CustIdCType());
				iit.getCustomer().setOfficialIdType(OfficialIdTypeCType.valueOf(sesObj.getCustomerIdType()));
				iit.getCustomer().setOfficialId(sesObj.getCustomerId());
				iit.setAccountType(sesObj.getAccountType());
				req.getIBANInfo().add(iit);

				CreateIBANRsType res = ibanService.createIBAN(req);
				if (res.getIBANStatus().get(0).getStatus() != null)
				{
					FaultType faultInfo = new FaultType();
					faultInfo.setType(ErrorType.BUSINESS);
					faultInfo.setCode(res.getIBANStatus().get(0).getStatus().getStatusCode());
					faultInfo.setDescription(res.getIBANStatus().get(0).getStatus().getStatusDesc());

					IBANManagementFault ft = new IBANManagementFault("", faultInfo);
					throw ft;
				}
				else
				{
					sesObj.setSettlementId(res.getIBANStatus().get(0).getIBANInfo().getSettlementID());
				}
			}
			else
			{
				FaultType faultInfo = new FaultType();
				faultInfo.setType(ErrorType.BUSINESS);
				if (! sesObj.isIbanMaker())
					faultInfo.setCode(401);
				else
					faultInfo.setCode(402);
				faultInfo.setDescription("Access denied.");

				IBANManagementFault ft = new IBANManagementFault("", faultInfo);
				throw ft;
			}
		}
		catch (IBANManagementFault e)
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
	 * Calls the backend webservice to retrieve list of IBAN from database
	 * 
	 * @param sesObj
	 *            - IbanSessionDataBean populated with request parameters
	 * @param sesObj
	 *            - IbanSessionDataBean populated with service response
	 */
	public IbanSessionDataBean callListIban(IbanSessionDataBean sesObj)
	{
		final String methodName = "callListIban";
		logger.entering(CLASS_NAME, methodName);
		try
		{
			ListIBANRqType req = new ListIBANRqType();
			req.setMessageHeader(getMessageHeaderType("LIST_IBAN", sesObj.getRemoteUser(), sesObj.getLanguageCode()));
			if(sesObj.getPartnerType().equalsIgnoreCase(PortalConstant.PARTNER_TYPE_SADAD))
				req.setBillerKey(sesObj.getBillerId());
			else
			{
				req.setBillerKey(sesObj.getPartnerKey());
				sesObj.setBillerId(sesObj.getPartnerKey());
			}
			if (sesObj.getIban() != null)
				req.setIBAN(sesObj.getIban());
			if (sesObj.getSettlementId() != null)
				req.setSettlementId(sesObj.getSettlementId());
			if (sesObj.getStatus() != null)
				req.setStatus(sesObj.getStatus());
			if(sesObj.getCustomerIdType() != null && sesObj.getCustomerId() != null)
			{
				req.setCustomer(new CustIdCType());
				req.getCustomer().setOfficialIdType(OfficialIdTypeCType.fromValue(sesObj.getCustomerIdType()));
				req.getCustomer().setOfficialId(sesObj.getCustomerId());
			}
			if (sesObj.getFromDate() != null || sesObj.getToDate() != null)
			{
				// if any one date is provided, apply search for that date
				if (sesObj.getFromDate() != null && sesObj.getToDate() == null)
					sesObj.setToDate(sesObj.getFromDate());
				if (sesObj.getFromDate() == null && sesObj.getToDate() != null)
					sesObj.setFromDate(sesObj.getToDate());

				req.setDateRange(new DateRangeCType());
				req.getDateRange().setFrom(sesObj.parseXmlFromDate(sesObj.getFromDate()));
				req.getDateRange().setTo(sesObj.parseXmlToDate(sesObj.getToDate()));

				// Swap dates if FROM is greater than TO
				if (req.getDateRange().getFrom().toGregorianCalendar().compareTo(req.getDateRange().getTo().toGregorianCalendar()) > 0)
				{
					req.getDateRange().setFrom(sesObj.parseXmlFromDate(sesObj.getToDate()));
					req.getDateRange().setTo(sesObj.parseXmlToDate(sesObj.getFromDate()));
					String ttd = sesObj.getToDate();
					sesObj.setToDate(sesObj.getFromDate());
					sesObj.setFromDate(ttd);
				}
			}
						
			// Start of Pagination Support
			if (sesObj.getPageNumber() == 0)
				sesObj.setPageNumber(1);
			if (sesObj.getFetchOperator() == '+')
				sesObj.setPageNumber(sesObj.getPageNumber() + 1);
			if (sesObj.getFetchOperator() == '-')
				sesObj.setPageNumber(sesObj.getPageNumber() - 1);
			if (sesObj.getPageNumber() == 0)
				sesObj.setPageNumber(1);
			if (sesObj.getTotalPages() > 0 && sesObj.getPageNumber() > sesObj.getTotalPages())
				sesObj.setPageNumber(sesObj.getTotalPages());
			if (sesObj.getPageNumber() > 0)
				req.setPage(sesObj.getPageNumber());
			// End of Pagination Support
			
			ListIBANRsType res = ibanService.listIBAN(req);
			if (res.getIBANRecord().size() > 0)
			{
				sesObj.getIbans().clear();
				for (ListIBANRecordType lirt : res.getIBANRecord())
				{
					IbanRecordBean record = new IbanRecordBean();
					String settlementId = null;
					
					if (lirt.getIBANInfo() != null)
					{
						record.setCurrentRecord(record.new IbanCurrentRecordBean());

						IBANInfoType iit = lirt.getIBANInfo();
						record.setBillerId(iit.getBillerKey());
						record.getCurrentRecord().setIban(iit.getIBAN());
						record.getCurrentRecord().setSettlementId(iit.getSettlementID());
						record.getCurrentRecord().setCustomerId(iit.getCustomer().getOfficialId());
						record.getCurrentRecord().setCustomerIdType(iit.getCustomer().getOfficialIdType().name());
						record.getCurrentRecord().setStatus(iit.getStatus());
						record.getCurrentRecord().setCreateDate(iit.getCreationDate().toString());
						
						settlementId = iit.getSettlementID();
					}
					if (lirt.getPendingIBANInfo().size() > 0)
					{
						record.setPendingRecord(record.new IbanPendingRecordBean());
						record.setApprovalRejectAllowed(true);
						PendingIBANInfoType piit = lirt.getPendingIBANInfo().get(0);
						record.setBillerId(piit.getBillerKey()!= null ? piit.getBillerKey() : record.getBillerId());
						record.getPendingRecord().setIban(piit.getIBAN()!= null ? piit.getIBAN() : record.getCurrentRecord().getIban());
						record.getPendingRecord().setSettlementId(piit.getSettlementID()!= null ? piit.getSettlementID() : record.getCurrentRecord().getSettlementId());
						record.getPendingRecord().setCustomerId(piit.getCustomer()!= null ? piit.getCustomer().getOfficialId() : record.getCurrentRecord().getCustomerId());
						record.getPendingRecord().setCustomerIdType(piit.getCustomer() != null ? piit.getCustomer().getOfficialIdType().name() : record.getCurrentRecord().getCustomerIdType());
						record.getPendingRecord().setStatus(piit.getStatus() != null ? piit.getStatus()+"/"+piit.getAction() : "PENDING/"+piit.getAction());
						record.getPendingRecord().setAction(piit.getAction());
						record.getPendingRecord().setCreateDate(piit.getCreationDate() != null ? piit.getCreationDate().toString() : record.getCurrentRecord().getCreateDate());
						record.getPendingRecord().setJustification((piit.getJustification() != null ? piit.getJustification() : ""));
						
						if (settlementId == null && piit.getSettlementID() != null)
							settlementId = piit.getSettlementID();
					}
					
					// Set the allow UPDATE / DEACTIVATE condition based on the record
					// Allow update, deactivate if there is not pending record and current record is in active mode
					if(record.getCurrentRecord() != null && record.getPendingRecord() == null && record.getCurrentRecord().getStatus().equalsIgnoreCase(PortalConstant.STATUS_ACTIVE))
						record.setProcessIbanAllowed(true);
					else
						record.setProcessIbanAllowed(false);
					
					sesObj.getIbans().put(settlementId, record);
				}
			}
			// Pagination Handling
			if(res.getPagination() != null)
			{
				if(res.getPagination().getTotalNumberOfPages() > 0)
					sesObj.setTotalPages(res.getPagination().getTotalNumberOfPages());
				if(res.getPagination().getTotalNumberOfPages() == 1)
					sesObj.setPageNumber(-1);
			}
		}
		catch (IBANManagementFault e)
		{
			if (e.getFaultInfo().getCode() == 13030) // ERROR:13030:The Page requested in the request is out of Page Ranges
				sesObj.setPageNumber(-1); // Setting -1 value will not display Fetch more data button on JSP page
			else
			{
				sesObj.transformS2ExceptionToS1(e.getFaultInfo());
				if (sesObj.getMessageToDisplay().getMessageType() == null)
					if (e.getFaultInfo().getType().equals(ErrorType.BUSINESS))
						sesObj.setErrorMessage(e.getFaultInfo().getDescription());
					else sesObj.setGenericErrorMessage();

				logger.logp(Level.SEVERE, CLASS_NAME, methodName, e.getMessage());
				if (logger.isLoggable(Level.FINEST))
					e.printStackTrace();
			}
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
	 * Calls the backend webservice to update an IBAN in database
	 * 
	 * @param sesObj
	 *            - IbanSessionDataBean populated with request parameters
	 * @return sesObj - IbanSessionDataBean populated with service response
	 */
	public IbanSessionDataBean callUpdateIban(IbanSessionDataBean sesObj)
	{
		final String methodName = "callUpdateIban";
		logger.entering(CLASS_NAME, methodName);
		try
		{
			if (sesObj.isIbanMaker()) // Check the user permission
			{
				UpdateIBANRqType req = new UpdateIBANRqType();
				req.setMessageHeader(getMessageHeaderType("UPDATE_IBAN", sesObj.getRemoteUser(), sesObj.getLanguageCode()));
				IBANInfoType iit = new IBANInfoType();
				iit.setIBAN(sesObj.getIban());
				iit.setSettlementID(sesObj.getSettlementId());
				if (!sesObj.getPartnerKey().equals("SADAD-001"))
					iit.setBillerKey(sesObj.getPartnerKey());
				else
					iit.setBillerKey(sesObj.getBillerId());
				iit.setCustomer(new CustIdCType());
				iit.getCustomer().setOfficialIdType(OfficialIdTypeCType.valueOf(sesObj.getCustomerIdType()));
				iit.getCustomer().setOfficialId(sesObj.getCustomerId());
				req.getIBANInfo().add(iit);

				UpdateIBANRsType res = ibanService.updateIBAN(req);
				if (res.getIBANStatus().size() > 0)
				{
					if (res.getIBANStatus().get(0).getStatus() != null)
					{
						FaultType faultInfo = new FaultType();
						faultInfo.setType(ErrorType.BUSINESS);
						faultInfo.setCode(res.getIBANStatus().get(0).getStatus().getStatusCode());
						faultInfo.setDescription(res.getIBANStatus().get(0).getStatus().getStatusDesc());
						if(faultInfo.getCode() == 14506)
							sesObj.getIbans().get(sesObj.getIbanKey()).setProcessIbanAllowed(false);
						IBANManagementFault ft = new IBANManagementFault("", faultInfo);
						throw ft;
					}
					else
					{
						IbanRecordBean record = sesObj.getIbans().get(sesObj.getIbanKey());
						IbanPendingRecordBean pRec = record.getPendingRecord();
						if(pRec == null)
							pRec = record.new IbanPendingRecordBean();
						pRec.setIban(res.getIBANStatus().get(0).getIBANInfo().getIBAN());
						pRec.setSettlementId(res.getIBANStatus().get(0).getIBANInfo().getSettlementID());
						pRec.setCustomerIdType(res.getIBANStatus().get(0).getIBANInfo().getCustomer().getOfficialIdType().name());
						pRec.setCustomerId(res.getIBANStatus().get(0).getIBANInfo().getCustomer().getOfficialId());
						pRec.setAccountType(res.getIBANStatus().get(0).getIBANInfo().getAccountType());
						pRec.setStatus(res.getIBANStatus().get(0).getIBANInfo().getStatus()+"/UPDATE");
						pRec.setCreateDate(record.getCurrentRecord().getCreateDate());
						record.setApprovalRejectAllowed(false);
						record.setProcessIbanAllowed(false);
						record.setPendingRecord(pRec);
						sesObj.getIbans().put(sesObj.getSettlementId(), record);
					}
				}
			}
			else
			{
				FaultType faultInfo = new FaultType();
				faultInfo.setType(ErrorType.BUSINESS);
				faultInfo.setCode(401);
				faultInfo.setDescription("Access denied.");

				IBANManagementFault ft = new IBANManagementFault("", faultInfo);
				throw ft;
			}
		}
		catch (IBANManagementFault e)
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
	 * Calls the backend webservice to update an IBAN in database
	 * 
	 * @param sesObj
	 *            - IbanSessionDataBean populated with request parameters
	 * @return sesObj - IbanSessionDataBean populated with service response
	 */
	public IbanSessionDataBean callProcessIban(IbanSessionDataBean sesObj)
	{
		final String methodName = "callProcessIban";
		logger.entering(CLASS_NAME, methodName);
		try
		{
			// Check the user permission Maker for ACTIVATE & DEACTIVATE and Checker for Approve & Reject
			if (sesObj.isIbanChecker() || sesObj.isIbanMaker())
			{
				ProcessIBANRqType req = new ProcessIBANRqType();
				req.setMessageHeader(getMessageHeaderType("PROCESS_IBAN", sesObj.getRemoteUser(), sesObj.getLanguageCode()));
				ProcessIBANType pit = new ProcessIBANType();
				pit.setSettlementId(sesObj.getSettlementId());
				pit.setJustification(sesObj.getJustification());

				// IBAN Maker can send Action ACTIVATE or DEACTIVATE Only
				if (sesObj.isIbanMaker() && (sesObj.getAction().equalsIgnoreCase(PortalConstant.ACTION_ACTIVATE) || sesObj.getAction().equalsIgnoreCase(PortalConstant.ACTION_DEACTIVATE)))
					pit.setAction(sesObj.getAction());
				// IBAN Checker can send Action APPROVE or REJECT Only
				else if (sesObj.isIbanChecker() && (sesObj.getAction().equalsIgnoreCase(PortalConstant.ACTION_APPROVE) || sesObj.getAction().equalsIgnoreCase(PortalConstant.ACTION_REJECT)))
					pit.setAction(sesObj.getAction());
				else
				{
					FaultType faultInfo = new FaultType();
					faultInfo.setType(ErrorType.BUSINESS);
					faultInfo.setCode(401);
					faultInfo.setDescription("Access denied.");

					IBANManagementFault ft = new IBANManagementFault("", faultInfo);
					throw ft;
				}
				req.getProcessIBAN().add(pit);
				ProcessIBANRsType res = ibanService.processIBAN(req);

				if (res.getProcessIBAN().size() > 0)
				{
					if (res.getProcessIBAN().get(0).getStatus() != null)
					{
						if (res.getProcessIBAN().get(0).getStatus().getSeverity().equals(SeverityType.ERROR))
						{
							FaultType faultInfo = new FaultType();
							faultInfo.setType(ErrorType.BUSINESS);
							faultInfo.setCode(res.getProcessIBAN().get(0).getStatus().getStatusCode());
							faultInfo.setDescription(res.getProcessIBAN().get(0).getStatus().getStatusDesc());
							if(faultInfo.getCode() == 14506)
								sesObj.getIbans().get(sesObj.getIbanKey()).setProcessIbanAllowed(false);
							IBANManagementFault ft = new IBANManagementFault("", faultInfo);
							throw ft;
						}
					}

					if(sesObj.getAction().equalsIgnoreCase(PortalConstant.ACTION_DEACTIVATE))
					{
						if (res.getProcessIBAN().get(0).getAction().equals(PortalConstant.ACTION_DEACTIVATE) && res.getProcessIBAN().get(0).getSettlementIdApprovalKey() != null)
						{
							//Displaying DEACTIVATION change as a difference
							IbanRecordBean record = sesObj.getIbans().get(sesObj.getIbanKey());
							IbanCurrentRecordBean cRec = record.getCurrentRecord();
							IbanPendingRecordBean pRec = record.getPendingRecord();
							if(pRec == null)
								pRec = record.new IbanPendingRecordBean();
							pRec.setIban(cRec.getIban());
							pRec.setSettlementId(cRec.getSettlementId());
							pRec.setCustomerIdType(cRec.getCustomerIdType());
							pRec.setCustomerId(cRec.getCustomerId());
							pRec.setAccountType(cRec.getAccountType());
							pRec.setStatus("PENDING/INACTIVE");
							pRec.setCreateDate(cRec.getCreateDate());
							record.setApprovalRejectAllowed(true);
							record.setProcessIbanAllowed(false);
							record.setPendingRecord(pRec);
							record.setCurrentRecord(cRec);
							sesObj.getIbans().put(sesObj.getIbanKey(), record);
						}
					}

					if(sesObj.getAction().equalsIgnoreCase(PortalConstant.ACTION_APPROVE))
					{
//						sesObj.getIbans().get(sesObj.getIbanKey()).getPendingRecord().setAction(IbanSessionDataBean.ACTION_APPROVE);
						sesObj.getIbans().get(sesObj.getIbanKey()).getPendingRecord().setSettlementId(res.getProcessIBAN().get(0).getSettlementId());
						sesObj.getIbans().get(sesObj.getIbanKey()).setApprovalRejectAllowed(false);
						
						IbanRecordBean rec = sesObj.getIbans().get(sesObj.getIbanKey());
						if(rec.getCurrentRecord() == null)
							rec.setCurrentRecord(rec.new IbanCurrentRecordBean());
						
						rec.getCurrentRecord().setIban(rec.getPendingRecord().getIban());
						rec.getCurrentRecord().setSettlementId(res.getProcessIBAN().get(0).getSettlementId());
						rec.getCurrentRecord().setCustomerId(rec.getPendingRecord().getCustomerId());
						rec.getCurrentRecord().setCustomerIdType(rec.getPendingRecord().getCustomerIdType());
						rec.getCurrentRecord().setCreateDate(rec.getPendingRecord().getCreateDate());
						// Fix defect # 4012
						if(rec.getPendingRecord().getStatus().equalsIgnoreCase("PENDING/DEACTIVATE"))
						{
							rec.getCurrentRecord().setStatus(PortalConstant.STATUS_INACTIVE);
							rec.getPendingRecord().setStatus(PortalConstant.STATUS_INACTIVE);
						}
						else
						{
							rec.getCurrentRecord().setStatus(PortalConstant.STATUS_ACTIVE);
							rec.getPendingRecord().setStatus(PortalConstant.STATUS_ACTIVE);
						}
						sesObj.getIbans().put(sesObj.getIbanKey(), rec);
					}

					if(sesObj.getAction().equalsIgnoreCase(PortalConstant.ACTION_REJECT))
					{
//						sesObj.getIbans().get(sesObj.getIbanKey()).getPendingRecord().setAction(IbanSessionDataBean.ACTION_REJECT);
						sesObj.getIbans().get(sesObj.getIbanKey()).getPendingRecord().setJustification(sesObj.getJustification());
						sesObj.getIbans().get(sesObj.getIbanKey()).setApprovalRejectAllowed(false);
						
						IbanRecordBean rec = sesObj.getIbans().get(sesObj.getIbanKey());
						if(rec.getCurrentRecord() == null)
						{
							rec.setCurrentRecord(rec.new IbanCurrentRecordBean());
							rec.getCurrentRecord().setIban(rec.getPendingRecord().getIban());
							rec.getCurrentRecord().setSettlementId(res.getProcessIBAN().get(0).getSettlementId());
							rec.getCurrentRecord().setCustomerId(rec.getPendingRecord().getCustomerId());
							rec.getCurrentRecord().setCustomerIdType(rec.getPendingRecord().getCustomerIdType());
							rec.getCurrentRecord().setCreateDate(rec.getPendingRecord().getCreateDate());
							// Fix defect # 3980 Change Status from INACTIVE to REJECTED
							rec.getCurrentRecord().setStatus(PortalConstant.STATUS_REJECTED);
							rec.getPendingRecord().setStatus(PortalConstant.STATUS_REJECTED);
							
							sesObj.getIbans().put(sesObj.getIbanKey(), rec);	
						}
						else
						{
							sesObj.getIbans().get(sesObj.getIbanKey()).getPendingRecord().setStatus(PortalConstant.STATUS_ACTIVE);		
						}
					}
				}
			}
			else
			{
				FaultType faultInfo = new FaultType();
				faultInfo.setType(ErrorType.BUSINESS);
				faultInfo.setCode(401);
				faultInfo.setDescription("Access denied.");

				IBANManagementFault ft = new IBANManagementFault("", faultInfo);
				throw ft;
			}
		}
		catch (IBANManagementFault e)
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
	 * Clear session object from server and restore the Screen-->Container 1, partner, partner and user type values back in object
	 * 
	 * @param sesObj
	 * @return
	 */
	public IbanSessionDataBean clearSessionBeanObject(IbanSessionDataBean sesObj)
	{
		return super.clearSessionBeanObject(sesObj, sesObj.getClass());
	}
}