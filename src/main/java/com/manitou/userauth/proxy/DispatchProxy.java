//package com.manitou.userauth.proxy;
//
//import org.springframework.cloud.openfeign.FeignClient;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//
//import com.manitou.userauth.entity.Invoice;
//import com.manitou.userauth.entity.Response;
// 
//
//@FeignClient(value = "dispatch", url = "http://localhost:8004")
//public interface DispatchProxy {
//	
//    @GetMapping(value = "/dispatch/getInvoiceData")
//    ResponseEntity<Response> getInvoiceData();
//    
//    @PostMapping(value = "/dispatch/saveInvoicedata")
//    ResponseEntity<Response> saveInvoiceData(Invoice invoice);
//      
//}