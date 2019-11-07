package com.accenture.lkm.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="purchase")
public class PurchaseEntity {
	
	@Id
	private String purchaseId;
	private String vendorName;
	private String materialCatergoryId;
	private String materialTypeId;
	private String brandName;
	private String unitId;
	private Integer quantity;
	private Double purchaseAmount;
	@Temporal(TemporalType.DATE)
	private Date purchaseDate;
	@Override
	public String toString() {
		return "PurchaseEntity [purchaseId=" + purchaseId + ", vendorName=" + vendorName + ", materialCatergoryId="
				+ materialCatergoryId + ", materialTypeId=" + materialTypeId + ", brandName=" + brandName + ", unitId="
				+ unitId + ", quantity=" + quantity + ", purchaseAmount=" + purchaseAmount + ", purchaseDate="
				+ purchaseDate + "]";
	}
	public PurchaseEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getPurchaseId() {
		return purchaseId;
	}
	public void setPurchaseId(String purchaseId) {
		this.purchaseId = purchaseId;
	}
	public String getVendorName() {
		return vendorName;
	}
	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}
	public String getMaterialCatergoryId() {
		return materialCatergoryId;
	}
	public void setMaterialCatergoryId(String materialCatergoryId) {
		this.materialCatergoryId = materialCatergoryId;
	}
	public String getMaterialTypeId() {
		return materialTypeId;
	}
	public void setMaterialTypeId(String materialTypeId) {
		this.materialTypeId = materialTypeId;
	}
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	public String getUnitId() {
		return unitId;
	}
	public void setUnitId(String unitId) {
		this.unitId = unitId;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Double getPurchaseAmount() {
		return purchaseAmount;
	}
	public void setPurchaseAmount(Double purchaseAmount) {
		this.purchaseAmount = purchaseAmount;
	}
	public Date getPurchaseDate() {
		return purchaseDate;
	}
	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
	
	

}