package com.manitou.dispatch.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "PARCEL_DETAILS")
public class ParcelDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String parcelNo;
	private String parcelGrossWeight;
	private String parcelHeight;
	private String parcelWidth;
	private String parcelLength;
	private String parcelPac;
	private String parcelBarCode;
	private String location;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "parcel_id")
	private List<ReflexItemsDetails> items = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getParcelGrossWeight() {
		return parcelGrossWeight;
	}

	public void setParcelGrossWeight(String parcelGrossWeight) {
		this.parcelGrossWeight = parcelGrossWeight;
	}

	public String getParcelHeight() {
		return parcelHeight;
	}

	public void setParcelHeight(String parcelHeight) {
		this.parcelHeight = parcelHeight;
	}

	public String getParcelWidth() {
		return parcelWidth;
	}

	public void setParcelWidth(String parcelWidth) {
		this.parcelWidth = parcelWidth;
	}

	public String getParcelLength() {
		return parcelLength;
	}

	public void setParcelLength(String parcelLength) {
		this.parcelLength = parcelLength;
	}

	public String getParcelPac() {
		return parcelPac;
	}

	public void setParcelPac(String parcelPac) {
		this.parcelPac = parcelPac;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getParcelNo() {
		return parcelNo;
	}

	public void setParcelNo(String parcelNo) {
		this.parcelNo = parcelNo;
	}

	public List<ReflexItemsDetails> getItems() {
		return items;
	}

	public void setItems(List<ReflexItemsDetails> items) {
		this.items = items;
	}

	public ParcelDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ParcelDetails(Long id, String parcelGrossWeight, String parcelHeight, String parcelWidth,
			String parcelLength, String parcelPac, String location, String parcelNo, List<ReflexItemsDetails> items) {
		super();
		this.id = id;
		this.parcelGrossWeight = parcelGrossWeight;
		this.parcelHeight = parcelHeight;
		this.parcelWidth = parcelWidth;
		this.parcelLength = parcelLength;
		this.parcelPac = parcelPac;
		this.location = location;
		this.parcelNo = parcelNo;
		this.items = items;
	}

	public String getParcelBarCode() {
		return parcelBarCode;
	}

	public void setParcelBarCode(String parcelBarCode) {
		this.parcelBarCode = parcelBarCode;
	}

}
