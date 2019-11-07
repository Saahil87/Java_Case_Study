package com.accenture.lkm.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.data.repository.query.Param;

import com.accenture.lkm.entity.MaterialTypeEntity;


@RepositoryDefinition(idClass=String.class, domainClass=MaterialTypeEntity.class)
public interface MaterialTypeDAO {
	
	public List<MaterialTypeEntity> findAll();
	@Query("select u from MaterialTypeEntity u where u.categoryEntity.categoryId = :categoryId")
	public List<MaterialTypeEntity> findByCategoryId(@Param("categoryId")String categoryId);
}