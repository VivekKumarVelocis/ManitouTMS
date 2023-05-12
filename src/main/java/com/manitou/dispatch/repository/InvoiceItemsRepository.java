package com.manitou.dispatch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.manitou.dispatch.entity.InvoiceItemDetails;

@Repository
public interface InvoiceItemsRepository extends JpaRepository<InvoiceItemDetails, Long> {

	@Query(value="SELECT DISTINCT invoice_num FROM INVOICE_ITEMDETAILS",nativeQuery = true)
	public List<String> getInvoiceNum();
	
	@Query(value="SELECT COUNT(*) FROM INVOICE_ITEMDETAILS WHERE invoice_num =:invoiceNum",nativeQuery = true)
	public Integer getInvoiceItemCount(@Param("invoiceNum") String invoiceNum);
}
