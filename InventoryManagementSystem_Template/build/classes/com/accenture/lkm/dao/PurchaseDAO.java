package com.accenture.lkm.dao;

import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.transaction.annotation.Transactional;

import com.accenture.lkm.entity.PurchaseEntity;

@RepositoryDefinition(idClass=String.class, domainClass=PurchaseEntity.class)
@Transactional("txManager")
public interface PurchaseDAO {

	
	public PurchaseEntity save(PurchaseEntity purchaseEntity);
	
	
}
