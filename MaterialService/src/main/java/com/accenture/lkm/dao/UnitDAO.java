package com.accenture.lkm.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.data.repository.query.Param;

import com.accenture.lkm.entity.UnitEntity;

@RepositoryDefinition(idClass=String.class, domainClass=UnitEntity.class)
public interface UnitDAO {
	
	public List<UnitEntity> findAll();
	@Query("select u from UnitEntity u where u.categoryEntity.categoryId = :categoryId")
	public List<UnitEntity> findByCategoryId(@Param("categoryId")String categoryId);
}
