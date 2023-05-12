package com.manitou.dispatch.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.manitou.dispatch.constants.ManitouConstants;
import com.manitou.dispatch.entity.Invoice;
import com.manitou.dispatch.entity.Response;
import com.manitou.dispatch.service.InvoiceService;
 	

@RestController
public class InvoiceController {

	private static final Logger logger = LoggerFactory.getLogger(InvoiceController.class);

	@Autowired
	private InvoiceService invService;

 
	 
	@PostMapping(value = "/saveInvoicedata")
	public ResponseEntity<Response> saveInvoiceData(@Valid @RequestBody Invoice invoice) {
		try {
			logger.info("saveInvoiceData()::::::::: method called to save the Invoice data");

			Invoice savedInvoiceData = invService.saveInvoiceData(invoice);

			if(savedInvoiceData==null) {
				return ResponseEntity.ok(Response.error(ManitouConstants.DATA_NOT_SAVED));
			}else {
				return ResponseEntity.ok(Response.ok(savedInvoiceData));
			}
		
		} catch (Exception e) {
			logger.error("Exception in saveInvoiceData() method :::" + e.getMessage());
			e.printStackTrace();
			return ResponseEntity.ok(Response.error(e.getMessage()));
		}

	}
	
	@GetMapping("/getInvoiceData")
	public ResponseEntity<Response> getInvoiceData(){
		try {
			logger.info("getInvoiceData():::::::::::: method called to get invoice data");
			
			Response response = invService.getInvoiceData();
			
			if(response.getStatus()==ManitouConstants.FAILURE) {
				return ResponseEntity.ok(Response.error("No Record Found"));
			}else {
				return ResponseEntity.ok(Response.ok(response));
			}
		} catch (Exception e) {
			logger.error("Error in getInvoiceData() method :::: " + e.getMessage());
			e.printStackTrace();
			return ResponseEntity.ok(Response.error(e.getMessage()));
		}
	}
	
	@PostMapping("/getInvoicebyInvoiceNo")
	public ResponseEntity<Response> getInvoicebyInvoiceNo(@RequestParam("invoiceNum") String invoiceNum){
		try {
			logger.info("getInvoicebyInvoiceNo():::::::::::: method called to get invoice data on the basis of invoice number");
			
			Response response = invService.getInvoicebyInvoiceNo(invoiceNum);
			
			if(response.getStatus()==ManitouConstants.FAILURE) {
				
				return ResponseEntity.ok(Response.error("No Record Found for invoice number "+invoiceNum));
			}else {
				return ResponseEntity.ok(Response.ok(response));
			}
		} catch (Exception e) {
			logger.error("Error in getInvoiceData() method :::: " + e.getMessage());
			e.printStackTrace();
			return ResponseEntity.ok(Response.error(e.getMessage()));
		}
	}
}
