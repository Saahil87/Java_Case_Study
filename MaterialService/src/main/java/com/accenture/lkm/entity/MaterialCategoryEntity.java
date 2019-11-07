package com.accenture.lkm.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="material_category")
public class MaterialCategoryEntity {

	@Id
	@Column(name = "categoryId")
	private String categoryId;
	@Column(name = "categoryName")
	private String categoryName;
	public MaterialCategoryEntity() {
		super();
	}
	public MaterialCategoryEntity(String categoryId, String categoryName) {
		super();
		this.categoryId = categoryId;
		this.categoryName = categoryName;
	}
	public String getCategoryId() {
		return categoryId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	@Override
	public String toString() {
		return "MaterialCategoryEntity [categoryId=" + categoryId + ", categoryName=" + categoryName + "]";
	}
}
