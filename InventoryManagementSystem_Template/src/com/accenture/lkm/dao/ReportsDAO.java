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

	@Query("select m from PurchaseEntity m where m.purchaseDate >=:fromDate and m.purchaseDate <=:toDate")
	public List<PurchaseEntity> getDateWisePurchaseRecords(@Param("fromDate")Date fromDate, @Param("toDate")Date toDate);
	
	@Query("select m from PurchaseEntity m where m.vendorName=:vendorName")
	public List<PurchaseEntity> getVendorWisePurchaseRecords(@Param("vendorName")String vendorName);
	
	@Query("select m from PurchaseEntity m where m.vendorName=:vendorName and m.purchaseId=:purchaseId")
	public List<PurchaseEntity> getVendorAndPurchaseIdWiseRecords(@Param("vendorName")String vendorName,@Param("purchaseId")String purchaseId);
	
	@Query("select m.purchaseId from PurchaseEntity m where m.vendorName=:vendorName")
	public List<String> fetchPurchaseIds(@Param("vendorName")String vendorName);
}