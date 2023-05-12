package com.manitou.dispatch.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.hibernate.annotations.NaturalId;

@Entity
public class Invoice extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String supplierGstin;
	private String supplierLegalName;
	private String supplierTradingName;
	private String supplierCity;
	private String supplierAddress1;
	private String supplierAddress2;
	private String supplierState;
	private String supplierPincode;
	private String supplierCountryCode;

	private String orderType;
	private String manitouOrderNo;
	private String packingListNo;
	private String shipmentNumber;
	private String custPoNumber;
	private String custPoDate;

	private String transporterName;

	@Column(name = "TRASNPORTER_GSTNO")
	private String transporterGSTNo;
	private String transporterState;
	private String transporterPin;
	private String transporterDocNo;
	private String transporterDocDate;
	private String transportDate;

	private String orderDate;

	private String billingName;
	private String billingTradeName;
	private String billingPOS;
	private String billingGstin;
	private String billingAddress1;
	private String billingAddress2;
	private String billingCity;
	private String billingState;
	private String billingCountryCode;
	private String billing_Phone;
	private String billing_Email;

	private String shippingtoName;
	private String shippingtoTradeName;
	private String shippingtoGstin;
	private String shippingtoAddress1;
	private String shippingtoAddress2;
	private String shippingtoPlace;
	private String shippingtoState;
	private String shippingtoStateCode;
	private String shippingtoCountryCode;
	private String shippingtoPincode;

	@NaturalId
	private String invoiceNum;
	private String invoiceDate;

	@Column(name = "INVOICE_QRCODE")
	private String invoiceQrCode;

	private String product_type;
	private String invoice_type_code;

	private String companyName;
	private String companyAddress1;
	private String companyAddress2;
	private String companyCity;
	private String companyState;
	private String companyPincode;

	private String portCode;
	private String currencyCode;
	private String cntCode;

	private String totalInvoiceValue;

	private String isMatched;
	private String exceptionMsg;

	@OneToMany(targetEntity = InvoiceItemDetails.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "invoice_num", referencedColumnName = "invoiceNum")
	private List<InvoiceItemDetails> items;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSupplierGstin() {
		return supplierGstin;
	}

	public void setSupplierGstin(String supplierGstin) {
		this.supplierGstin = supplierGstin;
	}

	public String getSupplierLegalName() {
		return supplierLegalName;
	}

	public void setSupplierLegalName(String supplierLegalName) {
		this.supplierLegalName = supplierLegalName;
	}

	public String getSupplierTradingName() {
		return supplierTradingName;
	}

	public void setSupplierTradingName(String supplierTradingName) {
		this.supplierTradingName = supplierTradingName;
	}

	public String getSupplierCity() {
		return supplierCity;
	}

	public void setSupplierCity(String supplierCity) {
		this.supplierCity = supplierCity;
	}

	public String getSupplierAddress1() {
		return supplierAddress1;
	}

	public void setSupplierAddress1(String supplierAddress1) {
		this.supplierAddress1 = supplierAddress1;
	}

	public String getSupplierAddress2() {
		return supplierAddress2;
	}

	public void setSupplierAddress2(String supplierAddress2) {
		this.supplierAddress2 = supplierAddress2;
	}

	public String getSupplierState() {
		return supplierState;
	}

	public void setSupplierState(String supplierState) {
		this.supplierState = supplierState;
	}

	public String getSupplierPincode() {
		return supplierPincode;
	}

	public void setSupplierPincode(String supplierPincode) {
		this.supplierPincode = supplierPincode;
	}

	public String getSupplierCountryCode() {
		return supplierCountryCode;
	}

	public void setSupplierCountryCode(String supplierCountryCode) {
		this.supplierCountryCode = supplierCountryCode;
	}

	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	public String getManitouOrderNo() {
		return manitouOrderNo;
	}

	public void setManitouOrderNo(String manitouOrderNo) {
		this.manitouOrderNo = manitouOrderNo;
	}

	public String getPackingListNo() {
		return packingListNo;
	}

	public void setPackingListNo(String packingListNo) {
		this.packingListNo = packingListNo;
	}

	public String getShipmentNumber() {
		return shipmentNumber;
	}

	public void setShipmentNumber(String shipmentNumber) {
		this.shipmentNumber = shipmentNumber;
	}

	public String getCustPoNumber() {
		return custPoNumber;
	}

	public void setCustPoNumber(String custPoNumber) {
		this.custPoNumber = custPoNumber;
	}

	public String getCustPoDate() {
		return custPoDate;
	}

	public void setCustPoDate(String custPoDate) {
		this.custPoDate = custPoDate;
	}

	public String getTransporterName() {
		return transporterName;
	}

	public void setTransporterName(String transporterName) {
		this.transporterName = transporterName;
	}

	public String getTransporterGSTNo() {
		return transporterGSTNo;
	}

	public void setTransporterGSTNo(String transporterGSTNo) {
		this.transporterGSTNo = transporterGSTNo;
	}

	public String getTransporterState() {
		return transporterState;
	}

	public void setTransporterState(String transporterState) {
		this.transporterState = transporterState;
	}

	public String getTransporterPin() {
		return transporterPin;
	}

	public void setTransporterPin(String transporterPin) {
		this.transporterPin = transporterPin;
	}

	public String getTransporterDocNo() {
		return transporterDocNo;
	}

	public void setTransporterDocNo(String transporterDocNo) {
		this.transporterDocNo = transporterDocNo;
	}

	public String getTransporterDocDate() {
		return transporterDocDate;
	}

	public void setTransporterDocDate(String transporterDocDate) {
		this.transporterDocDate = transporterDocDate;
	}

	public String getTransportDate() {
		return transportDate;
	}

	public void setTransportDate(String transportDate) {
		this.transportDate = transportDate;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public String getBillingName() {
		return billingName;
	}

	public void setBillingName(String billingName) {
		this.billingName = billingName;
	}

	public String getBillingTradeName() {
		return billingTradeName;
	}

	public void setBillingTradeName(String billingTradeName) {
		this.billingTradeName = billingTradeName;
	}

	public String getBillingPOS() {
		return billingPOS;
	}

	public void setBillingPOS(String billingPOS) {
		this.billingPOS = billingPOS;
	}

	public String getBillingGstin() {
		return billingGstin;
	}

	public void setBillingGstin(String billingGstin) {
		this.billingGstin = billingGstin;
	}

	public String getBillingAddress1() {
		return billingAddress1;
	}

	public void setBillingAddress1(String billingAddress1) {
		this.billingAddress1 = billingAddress1;
	}

	public String getBillingAddress2() {
		return billingAddress2;
	}

	public void setBillingAddress2(String billingAddress2) {
		this.billingAddress2 = billingAddress2;
	}

	public String getBillingCity() {
		return billingCity;
	}

	public void setBillingCity(String billingCity) {
		this.billingCity = billingCity;
	}

	public String getBillingState() {
		return billingState;
	}

	public void setBillingState(String billingState) {
		this.billingState = billingState;
	}

	public String getBillingCountryCode() {
		return billingCountryCode;
	}

	public void setBillingCountryCode(String billingCountryCode) {
		this.billingCountryCode = billingCountryCode;
	}

	public String getBilling_Phone() {
		return billing_Phone;
	}

	public void setBilling_Phone(String billing_Phone) {
		this.billing_Phone = billing_Phone;
	}

	public String getBilling_Email() {
		return billing_Email;
	}

	public void setBilling_Email(String billing_Email) {
		this.billing_Email = billing_Email;
	}

	public String getShippingtoName() {
		return shippingtoName;
	}

	public void setShippingtoName(String shippingtoName) {
		this.shippingtoName = shippingtoName;
	}

	public String getShippingtoTradeName() {
		return shippingtoTradeName;
	}

	public void setShippingtoTradeName(String shippingtoTradeName) {
		this.shippingtoTradeName = shippingtoTradeName;
	}

	public String getShippingtoGstin() {
		return shippingtoGstin;
	}

	public void setShippingtoGstin(String shippingtoGstin) {
		this.shippingtoGstin = shippingtoGstin;
	}

	public String getShippingtoAddress1() {
		return shippingtoAddress1;
	}

	public void setShippingtoAddress1(String shippingtoAddress1) {
		this.shippingtoAddress1 = shippingtoAddress1;
	}

	public String getShippingtoAddress2() {
		return shippingtoAddress2;
	}

	public void setShippingtoAddress2(String shippingtoAddress2) {
		this.shippingtoAddress2 = shippingtoAddress2;
	}

	public String getShippingtoPlace() {
		return shippingtoPlace;
	}

	public void setShippingtoPlace(String shippingtoPlace) {
		this.shippingtoPlace = shippingtoPlace;
	}

	public String getShippingtoState() {
		return shippingtoState;
	}

	public void setShippingtoState(String shippingtoState) {
		this.shippingtoState = shippingtoState;
	}

	public String getShippingtoStateCode() {
		return shippingtoStateCode;
	}

	public void setShippingtoStateCode(String shippingtoStateCode) {
		this.shippingtoStateCode = shippingtoStateCode;
	}

	public String getShippingtoCountryCode() {
		return shippingtoCountryCode;
	}

	public void setShippingtoCountryCode(String shippingtoCountryCode) {
		this.shippingtoCountryCode = shippingtoCountryCode;
	}

	public String getShippingtoPincode() {
		return shippingtoPincode;
	}

	public void setShippingtoPincode(String shippingtoPincode) {
		this.shippingtoPincode = shippingtoPincode;
	}

	public String getInvoiceNum() {
		return invoiceNum;
	}

	public void setInvoiceNum(String invoiceNum) {
		this.invoiceNum = invoiceNum;
	}

	public String getInvoiceDate() {
		return invoiceDate;
	}

	public void setInvoiceDate(String invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

	public String getInvoiceQrCode() {
		return invoiceQrCode;
	}

	public void setInvoiceQrCode(String invoiceQrCode) {
		this.invoiceQrCode = invoiceQrCode;
	}

	public String getProduct_type() {
		return product_type;
	}

	public void setProduct_type(String product_type) {
		this.product_type = product_type;
	}

	public String getInvoice_type_code() {
		return invoice_type_code;
	}

	public void setInvoice_type_code(String invoice_type_code) {
		this.invoice_type_code = invoice_type_code;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyAddress1() {
		return companyAddress1;
	}

	public void setCompanyAddress1(String companyAddress1) {
		this.companyAddress1 = companyAddress1;
	}

	public String getCompanyAddress2() {
		return companyAddress2;
	}

	public void setCompanyAddress2(String companyAddress2) {
		this.companyAddress2 = companyAddress2;
	}

	public String getCompanyCity() {
		return companyCity;
	}

	public void setCompanyCity(String companyCity) {
		this.companyCity = companyCity;
	}

	public String getCompanyState() {
		return companyState;
	}

	public void setCompanyState(String companyState) {
		this.companyState = companyState;
	}

	public String getCompanyPincode() {
		return companyPincode;
	}

	public void setCompanyPincode(String companyPincode) {
		this.companyPincode = companyPincode;
	}

	public String getPortCode() {
		return portCode;
	}

	public void setPortCode(String portCode) {
		this.portCode = portCode;
	}

	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	public String getCntCode() {
		return cntCode;
	}

	public void setCntCode(String cntCode) {
		this.cntCode = cntCode;
	}

	public String getTotalInvoiceValue() {
		return totalInvoiceValue;
	}

	public void setTotalInvoiceValue(String totalInvoiceValue) {
		this.totalInvoiceValue = totalInvoiceValue;
	}

	public List<InvoiceItemDetails> getItems() {
		return items;
	}

	public void setItems(List<InvoiceItemDetails> items) {
		this.items = items;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Invoice() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getIsMatched() {
		return isMatched;
	}

	public void setIsMatched(String isMatched) {
		this.isMatched = isMatched;
	}

	public String getExceptionMsg() {
		return exceptionMsg;
	}

	public void setExceptionMsg(String exceptionMsg) {
		this.exceptionMsg = exceptionMsg;
	}

	public Invoice(Long id, String supplierGstin, String supplierLegalName, String supplierTradingName,
			String supplierCity, String supplierAddress1, String supplierAddress2, String supplierState,
			String supplierPincode, String supplierCountryCode, String orderType, String manitouOrderNo,
			String packingListNo, String shipmentNumber, String custPoNumber, String custPoDate, String transporterName,
			String transporterGSTNo, String transporterState, String transporterPin, String transporterDocNo,
			String transporterDocDate, String transportDate, String orderDate, String billingName,
			String billingTradeName, String billingPOS, String billingGstin, String billingAddress1,
			String billingAddress2, String billingCity, String billingState, String billingCountryCode,
			String billing_Phone, String billing_Email, String shippingtoName, String shippingtoTradeName,
			String shippingtoGstin, String shippingtoAddress1, String shippingtoAddress2, String shippingtoPlace,
			String shippingtoState, String shippingtoStateCode, String shippingtoCountryCode, String shippingtoPincode,
			String invoiceNum, String invoiceDate, String invoiceQrCode, String product_type, String invoice_type_code,
			String companyName, String companyAddress1, String companyAddress2, String companyCity, String companyState,
			String companyPincode, String portCode, String currencyCode, String cntCode, String totalInvoiceValue,
			String isMatched, String exceptionMsg, List<InvoiceItemDetails> items) {
		super();
		this.id = id;
		this.supplierGstin = supplierGstin;
		this.supplierLegalName = supplierLegalName;
		this.supplierTradingName = supplierTradingName;
		this.supplierCity = supplierCity;
		this.supplierAddress1 = supplierAddress1;
		this.supplierAddress2 = supplierAddress2;
		this.supplierState = supplierState;
		this.supplierPincode = supplierPincode;
		this.supplierCountryCode = supplierCountryCode;
		this.orderType = orderType;
		this.manitouOrderNo = manitouOrderNo;
		this.packingListNo = packingListNo;
		this.shipmentNumber = shipmentNumber;
		this.custPoNumber = custPoNumber;
		this.custPoDate = custPoDate;
		this.transporterName = transporterName;
		this.transporterGSTNo = transporterGSTNo;
		this.transporterState = transporterState;
		this.transporterPin = transporterPin;
		this.transporterDocNo = transporterDocNo;
		this.transporterDocDate = transporterDocDate;
		this.transportDate = transportDate;
		this.orderDate = orderDate;
		this.billingName = billingName;
		this.billingTradeName = billingTradeName;
		this.billingPOS = billingPOS;
		this.billingGstin = billingGstin;
		this.billingAddress1 = billingAddress1;
		this.billingAddress2 = billingAddress2;
		this.billingCity = billingCity;
		this.billingState = billingState;
		this.billingCountryCode = billingCountryCode;
		this.billing_Phone = billing_Phone;
		this.billing_Email = billing_Email;
		this.shippingtoName = shippingtoName;
		this.shippingtoTradeName = shippingtoTradeName;
		this.shippingtoGstin = shippingtoGstin;
		this.shippingtoAddress1 = shippingtoAddress1;
		this.shippingtoAddress2 = shippingtoAddress2;
		this.shippingtoPlace = shippingtoPlace;
		this.shippingtoState = shippingtoState;
		this.shippingtoStateCode = shippingtoStateCode;
		this.shippingtoCountryCode = shippingtoCountryCode;
		this.shippingtoPincode = shippingtoPincode;
		this.invoiceNum = invoiceNum;
		this.invoiceDate = invoiceDate;
		this.invoiceQrCode = invoiceQrCode;
		this.product_type = product_type;
		this.invoice_type_code = invoice_type_code;
		this.companyName = companyName;
		this.companyAddress1 = companyAddress1;
		this.companyAddress2 = companyAddress2;
		this.companyCity = companyCity;
		this.companyState = companyState;
		this.companyPincode = companyPincode;
		this.portCode = portCode;
		this.currencyCode = currencyCode;
		this.cntCode = cntCode;
		this.totalInvoiceValue = totalInvoiceValue;
		this.isMatched = isMatched;
		this.exceptionMsg = exceptionMsg;
		this.items = items;
	}

	@Override
	public String toString() {
		return "Invoice [id=" + id + ", supplierGstin=" + supplierGstin + ", supplierLegalName=" + supplierLegalName
				+ ", supplierTradingName=" + supplierTradingName + ", supplierCity=" + supplierCity
				+ ", supplierAddress1=" + supplierAddress1 + ", supplierAddress2=" + supplierAddress2
				+ ", supplierState=" + supplierState + ", supplierPincode=" + supplierPincode + ", supplierCountryCode="
				+ supplierCountryCode + ", orderType=" + orderType + ", manitouOrderNo=" + manitouOrderNo
				+ ", packingListNo=" + packingListNo + ", shipmentNumber=" + shipmentNumber + ", custPoNumber="
				+ custPoNumber + ", custPoDate=" + custPoDate + ", transporterName=" + transporterName
				+ ", transporterGSTNo=" + transporterGSTNo + ", transporterState=" + transporterState
				+ ", transporterPin=" + transporterPin + ", transporterDocNo=" + transporterDocNo
				+ ", transporterDocDate=" + transporterDocDate + ", transportDate=" + transportDate + ", orderDate="
				+ orderDate + ", billingName=" + billingName + ", billingTradeName=" + billingTradeName
				+ ", billingPOS=" + billingPOS + ", billingGstin=" + billingGstin + ", billingAddress1="
				+ billingAddress1 + ", billingAddress2=" + billingAddress2 + ", billingCity=" + billingCity
				+ ", billingState=" + billingState + ", billingCountryCode=" + billingCountryCode + ", billing_Phone="
				+ billing_Phone + ", billing_Email=" + billing_Email + ", shippingtoName=" + shippingtoName
				+ ", shippingtoTradeName=" + shippingtoTradeName + ", shippingtoGstin=" + shippingtoGstin
				+ ", shippingtoAddress1=" + shippingtoAddress1 + ", shippingtoAddress2=" + shippingtoAddress2
				+ ", shippingtoPlace=" + shippingtoPlace + ", shippingtoState=" + shippingtoState
				+ ", shippingtoStateCode=" + shippingtoStateCode + ", shippingtoCountryCode=" + shippingtoCountryCode
				+ ", shippingtoPincode=" + shippingtoPincode + ", invoiceNum=" + invoiceNum + ", invoiceDate="
				+ invoiceDate + ", invoiceQrCode=" + invoiceQrCode + ", product_type=" + product_type
				+ ", invoice_type_code=" + invoice_type_code + ", companyName=" + companyName + ", companyAddress1="
				+ companyAddress1 + ", companyAddress2=" + companyAddress2 + ", companyCity=" + companyCity
				+ ", companyState=" + companyState + ", companyPincode=" + companyPincode + ", portCode=" + portCode
				+ ", currencyCode=" + currencyCode + ", cntCode=" + cntCode + ", totalInvoiceValue=" + totalInvoiceValue
				+ ", isMatched=" + isMatched + ", exceptionMsg=" + exceptionMsg + ", items=" + items + "]";
	}

	
	

}
