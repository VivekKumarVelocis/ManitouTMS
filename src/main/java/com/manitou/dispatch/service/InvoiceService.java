package com.manitou.dispatch.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.manitou.dispatch.entity.Invoice;
import com.manitou.dispatch.entity.Response;
 

@Service
public interface InvoiceService {

	public Invoice saveInvoiceData(Invoice invoice); 
	
	public Response getInvoiceData();
	
	public Response getInvoicebyInvoiceNo(String invoiceNum);
}
