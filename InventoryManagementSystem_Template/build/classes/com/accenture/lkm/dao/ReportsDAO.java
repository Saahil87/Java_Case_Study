package com.accenture.lkm.dao;

import java.util.Date;
import java.util.List;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.accenture.lkm.entity.PurchaseEntity;

@RepositoryDefinition(idClass=String.class, domainClass=PurchaseEntity.class)
@Transactional("txManager")
public interface ReportsDAO {

	@Query("select m from PurchaseEntity m where m.purchaseDate >=:date1 and m.purchaseDate <=:date2")
	public List<PurchaseEntity> getDateWisePurchaseRecords(@Param("date1")Date date1, @Param("date2")Date date2);
	
	@Query("select m from PurchaseEntity m where m.vendorName=:str")
	public List<PurchaseEntity> getVendorWisePurchaseRecords(@Param("str")String str);
	
	@Query("select m from PurchaseEntity m where m.vendorName=:str1 and m.purchaseId=:str2")
	public List<PurchaseEntity> getVendorAndPurchaseIdWiseRecords(@Param("str1")String str1,@Param("str2")String str2);
	
	@Query("select m.purchaseId from PurchaseEntity m")
	public List<String> fetchPurchaseIds();
}
