package com.manitou.dispatch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.manitou.dispatch.entity.ReflexItemsDetails;

@Repository
public interface ReflexItemDetailsRepository extends JpaRepository<ReflexItemsDetails, Long>{

//	@Query(value="SELECT COUNT(*) FROM REFLEX_ITEMDETAILS WHERE INVOICE_CODE =:invoiceNum",nativeQuery = true)
//	public Integer getInvoiceItemCount(@Param("INVOICE_CODE") String invoiceNum);
}
