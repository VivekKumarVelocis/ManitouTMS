//package com.manitou.userauth.controller;
// 
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.manitou.userauth.entity.Invoice;
//import com.manitou.userauth.entity.Response;
//import com.manitou.userauth.proxy.DispatchProxy;
//
//@RestController
//@RequestMapping("/dispatch")
//public class DispatchFeignController {
//
//	@Autowired
//	DispatchProxy proxy;
//	
//	@GetMapping("/getInvoiceData")
//	public ResponseEntity<?> getInvoiceData() {
//		return proxy.getInvoiceData();
//	}
//	 
//	@PostMapping(value = "/saveInvoicedata")
//	public ResponseEntity<Response> saveInvoiceData( @RequestBody Invoice invoice){
//		return proxy.saveInvoiceData(invoice);
//	}
//}
