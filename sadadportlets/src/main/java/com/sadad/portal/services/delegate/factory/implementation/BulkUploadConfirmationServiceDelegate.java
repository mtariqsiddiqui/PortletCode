/**
 * 
 */
package com.sadad.portal.services.delegate.factory.implementation;

import com.sadad.ebpp.scm.schema.bulkuploadconfirmationservice._1.GenerateBulkUploadConfirmationFileRqType;
import com.sadad.ebpp.scm.schema.bulkuploadconfirmationservice._1.GenerateBulkUploadConfirmationFileRsType;
import com.sadad.ebpp.wsdl.bulkuploadconfirmationservice._1.BulkUploadConfirmationFault;
import com.sadad.portal.common.utils.RequestResponseLogger;

/**
 * @author Tariq Siddiqui
 *
 */
public interface BulkUploadConfirmationServiceDelegate extends RequestResponseLogger
{
	public GenerateBulkUploadConfirmationFileRsType generateBulkUploadConfirmation(GenerateBulkUploadConfirmationFileRqType gbucfr) throws BulkUploadConfirmationFault;
}
