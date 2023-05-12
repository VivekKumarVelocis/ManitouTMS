package com.manitou.dispatch.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.manitou.dispatch.entity.Invoice;
import com.manitou.dispatch.entity.InvoiceParametersForMatching; 

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
 
	@Query("SELECT T FROM Invoice T where T.invoiceNum =:invoiceNum")
	Invoice findByInvoiceNum(@Param("invoiceNum") String invoiceNum);
	
 

	@Query("select new com.manitou.dispatch.entity.InvoiceParametersForMatching(i.invoiceNum,p.itemCode,p.quantity,i.packingListNo) FROM Invoice i JOIN i.items p WHERE i.invoiceNum =:invoiceNum")
	public List<InvoiceParametersForMatching> findInviceDetailsForMatch(@Param("invoiceNum") String invoiceNum);
 
	
	@Query(value=" UPDATE invoice SET is_matched =:is_matched,exception_msg =:exception_msg WHERE invoice_num =:invoice_num ",nativeQuery = true)
	@Modifying
	@Transactional
	void updateMsgAndFlag(@Param("is_matched") String is_matched,@Param("exception_msg") String exception_msg,@Param("invoice_num") String invoice_num);
}
