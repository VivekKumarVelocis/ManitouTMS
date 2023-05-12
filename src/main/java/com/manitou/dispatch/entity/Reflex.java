package com.manitou.dispatch.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="REFLEX")
public class Reflex extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String dispatchNo;
	
	private String companyName;
	private String companyAddress1;
	private String companyAddress2;
	private String companyCity;
	private String companyState;
	private String companyPincode;
	private String companyCountrycode;
	
	private String shippingtoName;
	private String shippingtoAddress1;
	private String shippingtoAddress2;
	private String shippingtoPlace;
	private String shippingtoState;
	private String shippingtoPincode;
	private String shippingtoCountrycode;
	private String shipmentNo;
	private String shipmentDate;
	
	private String consigneeName;
	private String consigneeAddress1;
	private String consigneeAddress2;
	private String consigneePlace;
	private String consigneeState;
	private String consigneePincode; 
	private String consigneCountrycode;

	 
	private String supplierName; 
	private String supplierCity;
	private String supplierAddress1;
	private String supplierAddress2;
	private String supplierState;
	private String supplierPincode; 
	private String supplierCountrycode;
	
	private String reasonOfTransport;
	private String transportationBy;
	private String deliveryDate; 
	private String preparationNr;
	private String deliveryNo; 

	@OneToMany(targetEntity=ParcelDetails.class,cascade=CascadeType.ALL, fetch=FetchType.EAGER)
//	@JoinTable(name="reflex_parcel")
	@JoinColumn(name="reflex_id")
	private List<ParcelDetails> parcelDetails;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDispatchNo() {
		return dispatchNo;
	}

	public void setDispatchNo(String dispatchNo) {
		this.dispatchNo = dispatchNo;
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

	public String getCompanyCountrycode() {
		return companyCountrycode;
	}

	public void setCompanyCountrycode(String companyCountrycode) {
		this.companyCountrycode = companyCountrycode;
	}

	public String getShippingtoName() {
		return shippingtoName;
	}

	public void setShippingtoName(String shippingtoName) {
		this.shippingtoName = shippingtoName;
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

	public String getShippingtoPincode() {
		return shippingtoPincode;
	}

	public void setShippingtoPincode(String shippingtoPincode) {
		this.shippingtoPincode = shippingtoPincode;
	}

	public String getShippingtoCountrycode() {
		return shippingtoCountrycode;
	}

	public void setShippingtoCountrycode(String shippingtoCountrycode) {
		this.shippingtoCountrycode = shippingtoCountrycode;
	}

	public String getShipmentNo() {
		return shipmentNo;
	}

	public void setShipmentNo(String shipmentNo) {
		this.shipmentNo = shipmentNo;
	}

	public String getShipmentDate() {
		return shipmentDate;
	}

	public void setShipmentDate(String shipmentDate) {
		this.shipmentDate = shipmentDate;
	}

	public String getConsigneeName() {
		return consigneeName;
	}

	public void setConsigneeName(String consigneeName) {
		this.consigneeName = consigneeName;
	}

	public String getConsigneeAddress1() {
		return consigneeAddress1;
	}

	public void setConsigneeAddress1(String consigneeAddress1) {
		this.consigneeAddress1 = consigneeAddress1;
	}

	public String getConsigneeAddress2() {
		return consigneeAddress2;
	}

	public void setConsigneeAddress2(String consigneeAddress2) {
		this.consigneeAddress2 = consigneeAddress2;
	}

	public String getConsigneePlace() {
		return consigneePlace;
	}

	public void setConsigneePlace(String consigneePlace) {
		this.consigneePlace = consigneePlace;
	}

	public String getConsigneeState() {
		return consigneeState;
	}

	public void setConsigneeState(String consigneeState) {
		this.consigneeState = consigneeState;
	}

	public String getConsigneePincode() {
		return consigneePincode;
	}

	public void setConsigneePincode(String consigneePincode) {
		this.consigneePincode = consigneePincode;
	}

	public String getConsigneCountrycode() {
		return consigneCountrycode;
	}

	public void setConsigneCountrycode(String consigneCountrycode) {
		this.consigneCountrycode = consigneCountrycode;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
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

	public String getSupplierCountrycode() {
		return supplierCountrycode;
	}

	public void setSupplierCountrycode(String supplierCountrycode) {
		this.supplierCountrycode = supplierCountrycode;
	}

	public String getReasonOfTransport() {
		return reasonOfTransport;
	}

	public void setReasonOfTransport(String reasonOfTransport) {
		this.reasonOfTransport = reasonOfTransport;
	}

	public String getTransportationBy() {
		return transportationBy;
	}

	public void setTransportationBy(String transportationBy) {
		this.transportationBy = transportationBy;
	}

	public String getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(String deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public String getPreparationNr() {
		return preparationNr;
	}

	public void setPreparationNr(String preparationNr) {
		this.preparationNr = preparationNr;
	}

	public String getDeliveryNo() {
		return deliveryNo;
	}

	public void setDeliveryNo(String deliveryNo) {
		this.deliveryNo = deliveryNo;
	}

	public List<ParcelDetails> getParcelDetails() {
		return parcelDetails;
	}

	public void setParcelDetails(List<ParcelDetails> parcelDetails) {
		this.parcelDetails = parcelDetails;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Reflex() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Reflex(Long id, String dispatchNo, String companyName, String companyAddress1, String companyAddress2,
			String companyCity, String companyState, String companyPincode, String companyCountrycode,
			String shippingtoName, String shippingtoAddress1, String shippingtoAddress2, String shippingtoPlace,
			String shippingtoState, String shippingtoPincode, String shippingtoCountrycode, String shipmentNo,
			String shipmentDate, String consigneeName, String consigneeAddress1, String consigneeAddress2,
			String consigneePlace, String consigneeState, String consigneePincode, String consigneCountrycode,
			String supplierName, String supplierCity, String supplierAddress1, String supplierAddress2,
			String supplierState, String supplierPincode, String supplierCountrycode, String reasonOfTransport,
			String transportationBy, String deliveryDate, String preparationNr, String deliveryNo,
			List<ParcelDetails> parcelDetails) {
		super();
		this.id = id;
		this.dispatchNo = dispatchNo;
		this.companyName = companyName;
		this.companyAddress1 = companyAddress1;
		this.companyAddress2 = companyAddress2;
		this.companyCity = companyCity;
		this.companyState = companyState;
		this.companyPincode = companyPincode;
		this.companyCountrycode = companyCountrycode;
		this.shippingtoName = shippingtoName;
		this.shippingtoAddress1 = shippingtoAddress1;
		this.shippingtoAddress2 = shippingtoAddress2;
		this.shippingtoPlace = shippingtoPlace;
		this.shippingtoState = shippingtoState;
		this.shippingtoPincode = shippingtoPincode;
		this.shippingtoCountrycode = shippingtoCountrycode;
		this.shipmentNo = shipmentNo;
		this.shipmentDate = shipmentDate;
		this.consigneeName = consigneeName;
		this.consigneeAddress1 = consigneeAddress1;
		this.consigneeAddress2 = consigneeAddress2;
		this.consigneePlace = consigneePlace;
		this.consigneeState = consigneeState;
		this.consigneePincode = consigneePincode;
		this.consigneCountrycode = consigneCountrycode;
		this.supplierName = supplierName;
		this.supplierCity = supplierCity;
		this.supplierAddress1 = supplierAddress1;
		this.supplierAddress2 = supplierAddress2;
		this.supplierState = supplierState;
		this.supplierPincode = supplierPincode;
		this.supplierCountrycode = supplierCountrycode;
		this.reasonOfTransport = reasonOfTransport;
		this.transportationBy = transportationBy;
		this.deliveryDate = deliveryDate;
		this.preparationNr = preparationNr;
		this.deliveryNo = deliveryNo;
		this.parcelDetails = parcelDetails;
	}

	@Override
	public String toString() {
		return "Reflex [id=" + id + ", dispatchNo=" + dispatchNo + ", companyName=" + companyName + ", companyAddress1="
				+ companyAddress1 + ", companyAddress2=" + companyAddress2 + ", companyCity=" + companyCity
				+ ", companyState=" + companyState + ", companyPincode=" + companyPincode + ", companyCountrycode="
				+ companyCountrycode + ", shippingtoName=" + shippingtoName + ", shippingtoAddress1="
				+ shippingtoAddress1 + ", shippingtoAddress2=" + shippingtoAddress2 + ", shippingtoPlace="
				+ shippingtoPlace + ", shippingtoState=" + shippingtoState + ", shippingtoPincode=" + shippingtoPincode
				+ ", shippingtoCountrycode=" + shippingtoCountrycode + ", shipmentNo=" + shipmentNo + ", shipmentDate="
				+ shipmentDate + ", consigneeName=" + consigneeName + ", consigneeAddress1=" + consigneeAddress1
				+ ", consigneeAddress2=" + consigneeAddress2 + ", consigneePlace=" + consigneePlace
				+ ", consigneeState=" + consigneeState + ", consigneePincode=" + consigneePincode
				+ ", consigneCountrycode=" + consigneCountrycode + ", supplierName=" + supplierName + ", supplierCity="
				+ supplierCity + ", supplierAddress1=" + supplierAddress1 + ", supplierAddress2=" + supplierAddress2
				+ ", supplierState=" + supplierState + ", supplierPincode=" + supplierPincode + ", supplierCountrycode="
				+ supplierCountrycode + ", reasonOfTransport=" + reasonOfTransport + ", transportationBy="
				+ transportationBy + ", deliveryDate=" + deliveryDate + ", preparationNr=" + preparationNr
				+ ", deliveryNo=" + deliveryNo + ", parcelDetails=" + parcelDetails + "]";
	}

	 

}
