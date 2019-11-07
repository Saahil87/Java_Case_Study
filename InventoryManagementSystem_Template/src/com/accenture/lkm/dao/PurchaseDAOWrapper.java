package com.accenture.lkm.dao;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.accenture.lkm.business.bean.PurchaseBean;
import com.accenture.lkm.entity.PurchaseEntity;
@Repository
@Transactional("txManager")
public class PurchaseDAOWrapper {

	@Autowired
	PurchaseDAO purchaseDAO;

	public PurchaseDAOWrapper() {
		super();
	}
	
	public PurchaseBean addPurchaseEntry(PurchaseBean purchaseBean) {
		PurchaseEntity purchaseEntity=new PurchaseEntity();
		BeanUtils.copyProperties(purchaseBean, purchaseEntity);
		PurchaseEntity ret=purchaseDAO.save(purchaseEntity);
		BeanUtils.copyProperties(ret, purchaseBean);
		return purchaseBean;
		
	}

}