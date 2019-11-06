package com.accenture.lkm.business.bean;

import java.util.Date;

public class PurchaseBean {
	
	private String purchaseId;
	private String vendorName;
	private String materialCatergoryId;
	private String materialTypeId;
	private String brandName;
	private String untiId;
	private Integer quantity;
	private Double purchaseAmount;
	private Date purchaseDate;
	private String materialCategoryName;
	private String materialTypeName;
	private String unitName;
	public PurchaseBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PurchaseBean(String purchaseId, String vendorName, String materialCatergoryId, String materialTypeId,
			String brandName, String untiId, Integer quantity, Double purchaseAmount, Date purchaseDate,
			String materialCategoryName, String materialTypeName, String unitName) {
		super();
		this.purchaseId = purchaseId;
		this.vendorName = vendorName;
		this.materialCatergoryId = materialCatergoryId;
		this.materialTypeId = materialTypeId;
		this.brandName = brandName;
		this.untiId = untiId;
		this.quantity = quantity;
		this.purchaseAmount = purchaseAmount;
		this.purchaseDate = purchaseDate;
		this.materialCategoryName = materialCategoryName;
		this.materialTypeName = materialTypeName;
		this.unitName = unitName;
	}
	@Override
	public String toString() {
		return "PurchaseBean [purchaseId=" + purchaseId + ", vendorName=" + vendorName + ", materialCatergoryId="
				+ materialCatergoryId + ", materialTypeId=" + materialTypeId + ", brandName=" + brandName + ", untiId="
				+ untiId + ", quantity=" + quantity + ", purchaseAmount=" + purchaseAmount + ", purchaseDate="
				+ purchaseDate + ", materialCategoryName=" + materialCategoryName + ", materialTypeName="
				+ materialTypeName + ", unitName=" + unitName + "]";
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
	public String getUntiId() {
		return untiId;
	}
	public void setUntiId(String untiId) {
		this.untiId = untiId;
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
	public String getMaterialCategoryName() {
		return materialCategoryName;
	}
	public void setMaterialCategoryName(String materialCategoryName) {
		this.materialCategoryName = materialCategoryName;
	}
	public String getMaterialTypeName() {
		return materialTypeName;
	}
	public void setMaterialTypeName(String materialTypeName) {
		this.materialTypeName = materialTypeName;
	}
	public String getUnitName() {
		return unitName;
	}
	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}
	
	

}
