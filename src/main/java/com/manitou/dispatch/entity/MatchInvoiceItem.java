package com.manitou.dispatch.entity;

import java.util.Comparator;
import java.util.Objects;

public class MatchInvoiceItem implements Comparator<MatchInvoiceItem> {
  
	private String itemCode;
	private String quantity;
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
	@Override
	public String toString() {
		return "MatchInvoiceItem [itemCode=" + itemCode + ", quantity=" + quantity + "]";
	}
	public MatchInvoiceItem(String itemCode, String quantity) {
		super();
		this.itemCode = itemCode;
		this.quantity = quantity;
	}
	public MatchInvoiceItem() {
		super();
		// TODO Auto-generated constructor stub
	} 
	
	 
	@Override
	public int hashCode() {
		return Objects.hash(itemCode, quantity);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MatchInvoiceItem other = (MatchInvoiceItem) obj;
		return Objects.equals(itemCode, other.itemCode) && Objects.equals(quantity, other.quantity);
	}
	@Override
	public int compare(MatchInvoiceItem o1, MatchInvoiceItem o2) {
		return o1.getItemCode().compareTo(o2.getItemCode());
	}
}
