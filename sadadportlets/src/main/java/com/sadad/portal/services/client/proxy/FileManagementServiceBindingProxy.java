package com.sadad.portal.services.client.proxy;

import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.transform.Source;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Dispatch;
import javax.xml.ws.Service;
import javax.xml.ws.soap.SOAPBinding;

import com.sadad.ebpp.scm.schema.filemanagementservice._1.CheckDuplicateFileRqType;
import com.sadad.ebpp.scm.schema.filemanagementservice._1.CheckDuplicateFileRsType;
import com.sadad.ebpp.scm.schema.filemanagementservice._1.GetFileNameRqType;
import com.sadad.ebpp.scm.schema.filemanagementservice._1.GetFileNameRsType;
import com.sadad.ebpp.scm.schema.filemanagementservice._1.GetFilePathRqType;
import com.sadad.ebpp.scm.schema.filemanagementservice._1.GetFilePathRsType;
import com.sadad.ebpp.scm.schema.filemanagementservice._1.GetFileProcessingSummaryRqType;
import com.sadad.ebpp.scm.schema.filemanagementservice._1.GetFileProcessingSummaryRsType;
import com.sadad.ebpp.scm.schema.filemanagementservice._1.MarkFileRqType;
import com.sadad.ebpp.scm.schema.filemanagementservice._1.MarkFileRsType;
import com.sadad.ebpp.scm.schema.filemanagementservice._1.PersistFileRqType;
import com.sadad.ebpp.scm.schema.filemanagementservice._1.PersistFileRsType;
import com.sadad.ebpp.scm.schema.filemanagementservice._1.SearchFilesAdvancedRqType;
import com.sadad.ebpp.scm.schema.filemanagementservice._1.SearchFilesRqType;
import com.sadad.ebpp.scm.schema.filemanagementservice._1.SearchFilesRsType;
import com.sadad.ebpp.scm.schema.filemanagementservice._1.UpdateFileStatusRqType;
import com.sadad.ebpp.scm.schema.filemanagementservice._1.UpdateFileStatusRsType;
import com.sadad.ebpp.wsdl.filemanagementservice._1.FileManagementFault;
import com.sadad.ebpp.wsdl.filemanagementservice._1.FileManagementService;
import com.sadad.ebpp.wsdl.filemanagementservice._1.FileManagementServicePort;

public class FileManagementServiceBindingProxy
{

	protected Descriptor _descriptor;

	public class Descriptor
	{
		private FileManagementService _service = null;
		private FileManagementServicePort _proxy = null;
		private Dispatch<Source> _dispatch = null;

		public Descriptor()
		{
			init();
		}

		public Descriptor(URL wsdlLocation, QName serviceName)
		{
			_service = new FileManagementService(wsdlLocation, serviceName);
			initCommon();
		}

		public void init()
		{
			_service = null;
			_proxy = null;
			_dispatch = null;
			_service = new FileManagementService();
			initCommon();
		}

		private void initCommon()
		{
			_proxy = _service.getFileManagementServicePort();
		}

		public FileManagementServicePort getProxy()
		{
			return _proxy;
		}

		public Dispatch<Source> getDispatch()
		{
			if (_dispatch == null)
			{
				QName portQName = new QName("http://www.sadad.com/EBPP/wsdl/FileManagementService/1.0", "FileManagementServiceBinding");
				_dispatch = _service.createDispatch(portQName, Source.class, Service.Mode.MESSAGE);

				String proxyEndpointUrl = getEndpoint();
				BindingProvider bp = (BindingProvider) _dispatch;
				String dispatchEndpointUrl = (String) bp.getRequestContext().get(BindingProvider.ENDPOINT_ADDRESS_PROPERTY);
				if (!dispatchEndpointUrl.equals(proxyEndpointUrl))
					bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, proxyEndpointUrl);
			}
			return _dispatch;
		}

		public String getEndpoint()
		{
			BindingProvider bp = (BindingProvider) _proxy;
			return (String) bp.getRequestContext().get(BindingProvider.ENDPOINT_ADDRESS_PROPERTY);
		}

		public void setEndpoint(String endpointUrl)
		{
			BindingProvider bp = (BindingProvider) _proxy;
			bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, endpointUrl);

			if (_dispatch != null)
			{
				bp = (BindingProvider) _dispatch;
				bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, endpointUrl);
			}
		}

		public void setMTOMEnabled(boolean enable)
		{
			SOAPBinding binding = (SOAPBinding) ((BindingProvider) _proxy).getBinding();
			binding.setMTOMEnabled(enable);
		}
	}

	public FileManagementServiceBindingProxy()
	{
		_descriptor = new Descriptor();
		_descriptor.setMTOMEnabled(false);
	}

	public FileManagementServiceBindingProxy(URL wsdlLocation, QName serviceName)
	{
		_descriptor = new Descriptor(wsdlLocation, serviceName);
		_descriptor.setMTOMEnabled(false);
	}

	public Descriptor _getDescriptor()
	{
		return _descriptor;
	}

	public GetFileNameRsType getFileName(GetFileNameRqType getFileNameRq) throws FileManagementFault
	{
		return _getDescriptor().getProxy().getFileName(getFileNameRq);
	}

	public PersistFileRsType persistFile(PersistFileRqType persistFileRq) throws FileManagementFault
	{
		return _getDescriptor().getProxy().persistFile(persistFileRq);
	}

	public UpdateFileStatusRsType updateFileStatus(UpdateFileStatusRqType updateFileStatusRq) throws FileManagementFault
	{
		return _getDescriptor().getProxy().updateFileStatus(updateFileStatusRq);
	}

	public GetFilePathRsType getFilePath(GetFilePathRqType getFilePathRq) throws FileManagementFault
	{
		return _getDescriptor().getProxy().getFilePath(getFilePathRq);
	}

	public CheckDuplicateFileRsType checkDuplicateFile(CheckDuplicateFileRqType checkDuplicateFileRq) throws FileManagementFault
	{
		return _getDescriptor().getProxy().checkDuplicateFile(checkDuplicateFileRq);
	}

	public SearchFilesRsType searchFiles(SearchFilesRqType searchFilesRq) throws FileManagementFault
	{
		return _getDescriptor().getProxy().searchFiles(searchFilesRq);
	}

	public SearchFilesRsType searchFilesAdvanced(SearchFilesAdvancedRqType searchFilesAdvancedRq) throws FileManagementFault
	{
		return _getDescriptor().getProxy().searchFilesAdvanced(searchFilesAdvancedRq);
	}

	public MarkFileRsType markFile(MarkFileRqType markFileRq) throws FileManagementFault
	{
		return _getDescriptor().getProxy().markFile(markFileRq);
	}

	public GetFileProcessingSummaryRsType getFileProcessingSummary(GetFileProcessingSummaryRqType getFileProcessingSummaryRq) throws FileManagementFault
	{
		return _getDescriptor().getProxy().getFileProcessingSummary(getFileProcessingSummaryRq);
	}

}