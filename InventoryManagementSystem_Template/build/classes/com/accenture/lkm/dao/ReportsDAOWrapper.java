package com.accenture.lkm.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.accenture.lkm.business.bean.PurchaseBean;
import com.accenture.lkm.entity.PurchaseEntity;

public class ReportsDAOWrapper  {
	
	@Autowired
	ReportsDAO reportsDAO;

	

	public ReportsDAOWrapper() {
		super();
	}


	public List<PurchaseBean> getDateWisePurchaseRecords(Date fromDate, Date toDate) {
		// TODO Auto-generated method stub
		List<PurchaseEntity> purchaseEntities=new ArrayList<>();
		purchaseEntities=reportsDAO.getDateWisePurchaseRecords(fromDate, toDate);
		List<PurchaseBean> purchaseBeans=new ArrayList<>();
		for(PurchaseEntity entity:purchaseEntities) {
			PurchaseBean bean=new PurchaseBean();
			BeanUtils.copyProperties(entity, bean);
			purchaseBeans.add(bean);
		}
		
		return purchaseBeans;
	}

	
	public List<PurchaseBean> getVendorWisePurchaseRecords(String vendorName) {
		// TODO Auto-generated method stub
		List<PurchaseEntity> purchaseEntities=new ArrayList<>();
		purchaseEntities=reportsDAO.getVendorWisePurchaseRecords(vendorName);
		List<PurchaseBean> purchaseBeans=new ArrayList<>();
		for(PurchaseEntity entity:purchaseEntities) {
			PurchaseBean bean=new PurchaseBean();
			BeanUtils.copyProperties(entity, bean);
			purchaseBeans.add(bean);
		}
		return purchaseBeans;
	}

	
	public List<PurchaseBean> getVendorAndPurchaseIdWiseRecords(String vendorName, String purchaseId) {
		// TODO Auto-generated method stub
		List<PurchaseEntity> purchaseEntities=new ArrayList<>();
		purchaseEntities=reportsDAO.getVendorAndPurchaseIdWiseRecords(vendorName, purchaseId);
		List<PurchaseBean> purchaseBeans=new ArrayList<>();
		for(PurchaseEntity entity:purchaseEntities) {
			PurchaseBean bean=new PurchaseBean();
			BeanUtils.copyProperties(entity, bean);
			purchaseBeans.add(bean);
		}
		return purchaseBeans;
	}

	
	public List<String> fetchPurchaseIds(String vendorName) {
		// TODO Auto-generated method stub
		List<String> list=new ArrayList<>();
		list=reportsDAO.fetchPurchaseIds(vendorName);
		return list;
	}

}
