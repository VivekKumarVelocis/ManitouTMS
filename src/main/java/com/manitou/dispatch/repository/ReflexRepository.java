package com.manitou.dispatch.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.manitou.dispatch.entity.Reflex;
import com.manitou.dispatch.entity.ReflexParameterForMatching;

@Repository
public interface ReflexRepository extends JpaRepository<Reflex, Long> {

//	@Query("select new com.dispatch.entity.ReflexParameterForMatching(r.dispatchNo,p.parcelNo,d.itemCode,d.itemQty) FROM Reflex r INNER JOIN ParcelDetails p on  r.id=p.id  INNER JOIN ReflexItemsDetails d on d.id=p.id  WHERE r.dispatchNo IN (:dispatchNo)")
//	public List<ReflexParameterForMatching> findReflexDetailsForMatch(@Param("dispatchNo") Set<String> dispatchNo);

//	@Query("select new com.dispatch.entity.ReflexParameterForMatching(r.dispatchNo,p.parcelNo,d.itemCode,d.itemQty) FROM Reflex r,ParcelDetails p,ReflexItemsDetails d WHERE r.id=p.id and p.id=d.id and r.dispatchNo =:dispatchNo")
////	@Query("select new com.dispatch.entity.ReflexParameterForMatching(r.dispatchNo,p.parcelNo,d.itemCode,d.itemQty) FROM Reflex r,ParcelDetails p,ReflexItemsDetails d WHERE r.dispatchNo IN (:dispatchNo)")
//	public List<ReflexParameterForMatching> findReflexDetailsForMatch(@Param("dispatchNo") String dispatchNo);

	  
	@Query(value="select r.dispatch_no,p.parcel_no,d.item_code,d.item_qty FROM reflex r,parcel_details p,reflex_itemdetails d WHERE  r.id=p.reflex_id and p.id=d.parcel_id and r.dispatch_no =:dispatchNo",nativeQuery=true)
 	public List<Object[]> findReflexDetailsForMatch(@Param("dispatchNo") String dispatchNo);
	
	@Query(value = "select count(*) from reflex r,reflex_itemdetails d,parcel_details p where r.id=p.reflex_id and p.id=d.parcel_id and r.dispatch_no =:dispatchNo", nativeQuery = true)
	public Integer getReflexItemCount(@Param("dispatchNo") String dispatchNo);

	public List<Reflex> findByDispatchNo(String dipatchList);

//	@Query(nativeQuery =true,value = "SELECT * FROM Employee as e WHERE e.employeeName IN (:names)")  
//	 List<Employee> findByEmployeeName(@Param("names") List<String> names);
}
