/**
 * 
 */
package com.sadad.portal.services.delegate.factory.implementation;

import com.sadad.ebpp.wsdl.bulkuploadquery._1.BulkQueryFault;
import com.sadad.portal.common.utils.RequestResponseLogger;
import com.sadad.schema.service.bulkuploadquery._1.GetRejectedRqType;
import com.sadad.schema.service.bulkuploadquery._1.GetRejectedRsType;
import com.sadad.schema.service.bulkuploadquery._1.ListRejectedRqType;
import com.sadad.schema.service.bulkuploadquery._1.ListRejectedRsType;

/**
 * @author Tariq Siddiqui
 * 
 */
public interface BulkUploadDelegate extends RequestResponseLogger
{
	public GetRejectedRsType getRejected(GetRejectedRqType getRejectedRq) throws BulkQueryFault;

	public ListRejectedRsType listRejected(ListRejectedRqType listRejectedRq) throws BulkQueryFault;
}
