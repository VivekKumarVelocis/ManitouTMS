package com.manitou.dispatch.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="INVOICE_ITEMDETAILS")
public class InvoiceItemDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String siNo;
	private String itemCode;
	private String itemDescription;
	private String hsnCode;
	private String quantity; 
	private String uqc;
	private String rate;
	 

	private String itemTotal;
	private String originCountry; 
	private String machineNo;
	private String engineNo;
	private String chasisNo;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getSiNo() {
		return siNo;
	}
	public void setSiNo(String siNo) {
		this.siNo = siNo;
	}
	public String getItemCode() {
		return itemCode;
	}
	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}
	public String getItemDescription() {
		return itemDescription;
	}
	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}
	public String getHsnCode() {
		return hsnCode;
	}
	public void setHsnCode(String hsnCode) {
		this.hsnCode = hsnCode;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public String getUqc() {
		return uqc;
	}
	public void setUqc(String uqc) {
		this.uqc = uqc;
	}
	public String getRate() {
		return rate;
	}
	public void setRate(String rate) {
		this.rate = rate;
	}
	public String getItemTotal() {
		return itemTotal;
	}
	public void setItemTotal(String itemTotal) {
		this.itemTotal = itemTotal;
	}
	public String getOriginCountry() {
		return originCountry;
	}
	public void setOriginCountry(String originCountry) {
		this.originCountry = originCountry;
	}
	public String getMachineNo() {
		return machineNo;
	}
	public void setMachineNo(String machineNo) {
		this.machineNo = machineNo;
	}
	public String getEngineNo() {
		return engineNo;
	}
	public void setEngineNo(String engineNo) {
		this.engineNo = engineNo;
	}
	public String getChasisNo() {
		return chasisNo;
	}
	public void setChasisNo(String chasisNo) {
		this.chasisNo = chasisNo;
	}
	public InvoiceItemDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	public InvoiceItemDetails(Long id, String siNo, String itemCode, String itemDescription, String hsnCode,
			String quantity, String uqc, String rate, String itemTotal, String originCountry, String machineNo,
			String engineNo, String chasisNo) {
		super();
		this.id = id;
		this.siNo = siNo;
		this.itemCode = itemCode;
		this.itemDescription = itemDescription;
		this.hsnCode = hsnCode;
		this.quantity = quantity;
		this.uqc = uqc;
		this.rate = rate;
		this.itemTotal = itemTotal;
		this.originCountry = originCountry;
		this.machineNo = machineNo;
		this.engineNo = engineNo;
		this.chasisNo = chasisNo;
	}
	@Override
	public String toString() {
		return "InvoiceItemDetails [id=" + id + ", siNo=" + siNo + ", itemCode=" + itemCode + ", itemDescription="
				+ itemDescription + ", hsnCode=" + hsnCode + ", quantity=" + quantity + ", uqc=" + uqc + ", rate="
				+ rate + ", itemTotal=" + itemTotal + ", originCountry=" + originCountry + ", machineNo=" + machineNo
				+ ", engineNo=" + engineNo + ", chasisNo=" + chasisNo + "]";
	}
	 
	
	
	
}
