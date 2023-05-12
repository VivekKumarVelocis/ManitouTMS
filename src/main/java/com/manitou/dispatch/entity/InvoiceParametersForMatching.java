package com.manitou.dispatch.entity;

public class InvoiceParametersForMatching {
	
	private String invoiceNum;
	private String itemCode;
	private String quantity;
	private String packingListNo;
	
	
	public String getInvoiceNum() {
		return invoiceNum;
	}


	public void setInvoiceNum(String invoiceNum) {
		this.invoiceNum = invoiceNum;
	}


	public String getItemCode() {
		return itemCode;
	}


	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}


	public String getQuantity() {
		return quantity;
	}


	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}


	public String getPackingListNo() {
		return packingListNo;
	}


	public void setPackingListNo(String packingListNo) {
		this.packingListNo = packingListNo;
	}


	@Override
	public String toString() {
		return "InvoiceParametersForMatching [invoiceNum=" + invoiceNum + ", itemCode=" + itemCode + ", quantity="
				+ quantity + ", packingListNo=" + packingListNo + "]";
	}


	public InvoiceParametersForMatching() {
		super();
		// TODO Auto-generated constructor stub
	}


	public InvoiceParametersForMatching(String invoiceNum, String itemCode, String quantity, String packingListNo) {
		super();
		this.invoiceNum = invoiceNum;
		this.itemCode = itemCode;
		this.quantity = quantity;
		this.packingListNo = packingListNo;
	}
	

	
	
	 
}
