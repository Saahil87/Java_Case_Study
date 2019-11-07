package com.accenture.lkm.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="MaterialTypeEntity")
public class MaterialTypeEntity {
	
	@Id
	@Column(name="type_id")
	private String typeId;
	@Column(name="type_name")
	private String typeName;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="categoryId")
	//@Column(name="category_entity")
	private MaterialCategoryEntity categoryEntity;
	
	public MaterialTypeEntity() {
		super();
	}

	public String getTypeId() {
		return typeId;
	}

	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public MaterialCategoryEntity getCategoryEntity() {
		return categoryEntity;
	}

	public void setCategoryEntity(MaterialCategoryEntity categoryEntity) {
		this.categoryEntity = categoryEntity;
	}

	@Override
	public String toString() {
		return "MaterialTypeEntity [typeId=" + typeId + ", typeName=" + typeName + ", categoryEntity=" + categoryEntity
				+ "]";
	}
	
	

}
