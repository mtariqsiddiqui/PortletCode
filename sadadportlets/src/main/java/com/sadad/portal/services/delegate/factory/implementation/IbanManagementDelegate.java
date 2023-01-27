package com.sadad.portal.services.delegate.factory.implementation;

import com.sadad.ebpp.schema.service.ibanmanagement._1.CreateIBANRqType;
import com.sadad.ebpp.schema.service.ibanmanagement._1.CreateIBANRsType;
import com.sadad.ebpp.schema.service.ibanmanagement._1.ListIBANRqType;
import com.sadad.ebpp.schema.service.ibanmanagement._1.ListIBANRsType;
import com.sadad.ebpp.schema.service.ibanmanagement._1.ProcessIBANRqType;
import com.sadad.ebpp.schema.service.ibanmanagement._1.ProcessIBANRsType;
import com.sadad.ebpp.schema.service.ibanmanagement._1.UpdateIBANRqType;
import com.sadad.ebpp.schema.service.ibanmanagement._1.UpdateIBANRsType;
import com.sadad.ebpp.wsdl.ibanmanagement._1.IBANManagementFault;
import com.sadad.portal.common.utils.RequestResponseLogger;

public interface IbanManagementDelegate extends RequestResponseLogger
{
	public CreateIBANRsType createIBAN(CreateIBANRqType createIBANRq) throws IBANManagementFault;

	public ListIBANRsType listIBAN(ListIBANRqType req) throws IBANManagementFault;

	public ProcessIBANRsType processIBAN(ProcessIBANRqType processIBANRq) throws IBANManagementFault;

	public UpdateIBANRsType updateIBAN(UpdateIBANRqType updateIBANRq) throws IBANManagementFault;
}