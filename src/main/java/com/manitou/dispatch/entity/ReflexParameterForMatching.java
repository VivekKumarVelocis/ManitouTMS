package com.manitou.dispatch.entity;

public class ReflexParameterForMatching {

	private String dispatchNo;
	private String parcelNo;
	private String itemCode;
	private String itemQty;
	
	
	
	public String getDispatchNo() {
		return dispatchNo;
	}
	public void setDispatchNo(String dispatchNo) {
		this.dispatchNo = dispatchNo;
	}
	public String getParcelNo() {
		return parcelNo;
	}
	public void setParcelNo(String parcelNo) {
		this.parcelNo = parcelNo;
	}
	public String getItemCode() {
		return itemCode;
	}
	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}
	public String getItemQty() {
		return itemQty;
	}
	public void setItemQty(String itemQty) {
		this.itemQty = itemQty;
	}
	public ReflexParameterForMatching() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ReflexParameterForMatching(String dispatchNo, String parcelNo, String itemCode, String itemQty) {
		super();
		this.dispatchNo = dispatchNo;
		this.parcelNo = parcelNo;
		this.itemCode = itemCode;
		this.itemQty = itemQty;
	}
	@Override
	public String toString() {
		return "ReflexParameterForMatching [dispatchNo=" + dispatchNo + ", parcelNo=" + parcelNo + ", itemCode="
				+ itemCode + ", itemQty=" + itemQty + "]";
	}
	
	
}
