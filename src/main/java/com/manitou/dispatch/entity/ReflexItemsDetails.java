package com.manitou.dispatch.entity;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="REFLEX_ITEMDETAILS")
public class ReflexItemsDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String itemCode;
	private String hsnCode;
	private String itemDescription; 
	private String itemQty;
	private String orderNo;
	private String customerOrderNr;
	private String hazardousMaterial;
	private String itemNetWeight;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getItemCode() {
		return itemCode;
	}
	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}
	public String getHsnCode() {
		return hsnCode;
	}
	public void setHsnCode(String hsnCode) {
		this.hsnCode = hsnCode;
	}
	public String getItemDescription() {
		return itemDescription;
	}
	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}
	public String getItemQty() {
		return itemQty;
	}
	public void setItemQty(String itemQty) {
		this.itemQty = itemQty;
	}
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public String getCustomerOrderNr() {
		return customerOrderNr;
	}
	public void setCustomerOrderNr(String customerOrderNr) {
		this.customerOrderNr = customerOrderNr;
	}
	public String getHazardousMaterial() {
		return hazardousMaterial;
	}
	public void setHazardousMaterial(String hazardousMaterial) {
		this.hazardousMaterial = hazardousMaterial;
	}
	public String getItemNetWeight() {
		return itemNetWeight;
	}
	public void setItemNetWeight(String itemNetWeight) {
		this.itemNetWeight = itemNetWeight;
	}
	public ReflexItemsDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ReflexItemsDetails(Long id, String itemCode, String hsnCode, String itemDescription, String itemQty,
			String orderNo, String customerOrderNr, String hazardousMaterial, String itemNetWeight) {
		super();
		this.id = id;
		this.itemCode = itemCode;
		this.hsnCode = hsnCode;
		this.itemDescription = itemDescription;
		this.itemQty = itemQty;
		this.orderNo = orderNo;
		this.customerOrderNr = customerOrderNr;
		this.hazardousMaterial = hazardousMaterial;
		this.itemNetWeight = itemNetWeight;
	}
	@Override
	public String toString() {
		return "ReflexItemsDetails [id=" + id + ", itemCode=" + itemCode + ", hsnCode=" + hsnCode + ", itemDescription="
				+ itemDescription + ", itemQty=" + itemQty + ", orderNo=" + orderNo + ", customerOrderNr="
				+ customerOrderNr + ", hazardousMaterial=" + hazardousMaterial + ", itemNetWeight=" + itemNetWeight
				+ "]";
	}
 

	 
	
}
