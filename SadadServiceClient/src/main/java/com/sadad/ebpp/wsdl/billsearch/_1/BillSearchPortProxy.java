package com.sadad.ebpp.wsdl.billsearch._1;

import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.transform.Source;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Dispatch;
import javax.xml.ws.Service;
import javax.xml.ws.soap.SOAPBinding;
import com.sadad.ebpp.scm.schema.billsearch._1.GetByBillNumberRqType;
import com.sadad.ebpp.scm.schema.billsearch._1.GetByBillNumberRsType;
import com.sadad.ebpp.scm.schema.billsearch._1.ListByAccountRqType;
import com.sadad.ebpp.scm.schema.billsearch._1.ListByAccountRsType;
import com.sadad.ebpp.scm.schema.billsearch._1.ListByCustomerRqType;
import com.sadad.ebpp.scm.schema.billsearch._1.ListByCustomerRsType;
import com.sadad.ebpp.scm.schema.billsearch._1.ListByPaymentRqType;
import com.sadad.ebpp.scm.schema.billsearch._1.ListByPaymentRsType;

public class BillSearchPortProxy{

    protected Descriptor _descriptor;

    public class Descriptor {
        private com.sadad.ebpp.wsdl.billsearch._1.BillSearch _service = null;
        private com.sadad.ebpp.wsdl.billsearch._1.BillSearchPort _proxy = null;
        private Dispatch<Source> _dispatch = null;

        public Descriptor() {
            init();
        }

        public Descriptor(URL wsdlLocation, QName serviceName) {
            _service = new com.sadad.ebpp.wsdl.billsearch._1.BillSearch(wsdlLocation, serviceName);
            initCommon();
        }

        public void init() {
            _service = null;
            _proxy = null;
            _dispatch = null;
            _service = new com.sadad.ebpp.wsdl.billsearch._1.BillSearch();
            initCommon();
        }

        private void initCommon() {
            _proxy = _service.getBillSearchPort();
        }

        public com.sadad.ebpp.wsdl.billsearch._1.BillSearchPort getProxy() {
            return _proxy;
        }

        public Dispatch<Source> getDispatch() {
            if (_dispatch == null ) {
                QName portQName = new QName("http://www.sadad.com/EBPP/wsdl/BillSearch/1.0", "BillSearchPort");
                _dispatch = _service.createDispatch(portQName, Source.class, Service.Mode.MESSAGE);

                String proxyEndpointUrl = getEndpoint();
                BindingProvider bp = (BindingProvider) _dispatch;
                String dispatchEndpointUrl = (String) bp.getRequestContext().get(BindingProvider.ENDPOINT_ADDRESS_PROPERTY);
                if (!dispatchEndpointUrl.equals(proxyEndpointUrl))
                    bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, proxyEndpointUrl);
            }
            return _dispatch;
        }

        public String getEndpoint() {
            BindingProvider bp = (BindingProvider) _proxy;
            return (String) bp.getRequestContext().get(BindingProvider.ENDPOINT_ADDRESS_PROPERTY);
        }

        public void setEndpoint(String endpointUrl) {
            BindingProvider bp = (BindingProvider) _proxy;
            bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, endpointUrl);

            if (_dispatch != null ) {
                bp = (BindingProvider) _dispatch;
                bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, endpointUrl);
            }
        }

        public void setMTOMEnabled(boolean enable) {
            SOAPBinding binding = (SOAPBinding) ((BindingProvider) _proxy).getBinding();
            binding.setMTOMEnabled(enable);
        }
    }

    public BillSearchPortProxy() {
        _descriptor = new Descriptor();
        _descriptor.setMTOMEnabled(false);
    }

    public BillSearchPortProxy(URL wsdlLocation, QName serviceName) {
        _descriptor = new Descriptor(wsdlLocation, serviceName);
        _descriptor.setMTOMEnabled(false);
    }

    public Descriptor _getDescriptor() {
        return _descriptor;
    }

    public GetByBillNumberRsType getByBillNumber(GetByBillNumberRqType getByBillNumberRq) throws BillSearchFault {
        return _getDescriptor().getProxy().getByBillNumber(getByBillNumberRq);
    }

    public ListByAccountRsType listByAccount(ListByAccountRqType listByAccountRq) throws BillSearchFault {
        return _getDescriptor().getProxy().listByAccount(listByAccountRq);
    }

    public ListByCustomerRsType listByCustomer(ListByCustomerRqType listByCustomerRq) throws BillSearchFault {
        return _getDescriptor().getProxy().listByCustomer(listByCustomerRq);
    }

    public ListByPaymentRsType listByPayment(ListByPaymentRqType listByPaymentRq) throws BillSearchFault {
        return _getDescriptor().getProxy().listByPayment(listByPaymentRq);
    }

}