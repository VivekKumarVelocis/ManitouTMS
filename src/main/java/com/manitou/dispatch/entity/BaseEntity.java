package com.manitou.dispatch.entity;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Optional;
 
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate; 

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

///**
// * added by Vivek Kumar. baseEntity entity are transformed to columns on the database table
// */
@MappedSuperclass
//@JsonIgnoreProperties(value= {"createdBy", "updatedBy"})
public class BaseEntity implements Serializable {
	
	
	
	/**
	 * added by kishan pandey. 
	 */
	
	private static final long serialVersionUID = 1L;

		
	@CreatedBy
	@Basic
	@Column(name="CREATEDBY", nullable=false, insertable=true, updatable=true)
	private String createdBy;
	
	@CreatedDate
	@Basic
	@Column(name="CREATEDON", nullable=false, insertable=true, updatable=true)
	private String createdOn;
	
	@LastModifiedBy
	@Basic
	@Column(name="UPDATEDBY", nullable=true, insertable=true, updatable=true)
	private String updatedBy;
	
	@LastModifiedDate
	@Basic
	@Column(name="UPDATEDON", nullable=true, insertable=true, updatable=true)
	private String updatedOn;

		
	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(String createdOn) {
		this.createdOn = createdOn;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public String getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(String updatedOn) {
		this.updatedOn = updatedOn;
	}
	
	
	 @PrePersist
	    public void prePersist() {
	       // String createdByUser = ExtractToken.getUsernameFromToken();
	      //  this.createdBy = createdByUser;
	        this.createdOn = getCreatedOnData();
	        //this.updatedOn = new Date();
	    }

	    @PreUpdate
	    public void preUpdate() {
	       // String modifiedByUser = ExtractToken.getUsernameFromToken();
	       // this.updatedBy = modifiedByUser;
	        this.updatedOn = getCreatedOnData();
	    }

	    
	    
	    
		private String getCreatedOnData() {
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
			   LocalDateTime now = LocalDateTime.now();  
			  
			   return dtf.format(now);
		}

	
		
		
		

}
