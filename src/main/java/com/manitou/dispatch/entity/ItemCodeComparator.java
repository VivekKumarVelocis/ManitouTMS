package com.manitou.dispatch.entity;

import java.util.Comparator;

public class ItemCodeComparator   implements Comparator{

	public int compare(Object o1,Object o2){  
		MatchInvoiceItem s1=(MatchInvoiceItem)o1;  
		MatchInvoiceItem s2=(MatchInvoiceItem)o2;  
		  
		return s1.getItemCode().compareTo(s2.getItemCode());    
		}  
}
