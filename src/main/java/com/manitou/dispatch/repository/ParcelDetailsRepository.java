package com.manitou.dispatch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.manitou.dispatch.entity.ParcelDetails;

@Repository
public interface ParcelDetailsRepository extends JpaRepository<ParcelDetails, Long> {

}
