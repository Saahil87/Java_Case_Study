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


	public List<PurchaseBean> getDateWisePurchaseRecords(Date date1, Date date2) {
		// TODO Auto-generated method stub
		List<PurchaseEntity> purchaseEntities=new ArrayList<>();
		purchaseEntities=reportsDAO.getDateWisePurchaseRecords(date1, date2);
		List<PurchaseBean> purchaseBeans=new ArrayList<>();
		for(PurchaseEntity entity:purchaseEntities) {
			PurchaseBean bean=new PurchaseBean();
			BeanUtils.copyProperties(entity, bean);
			purchaseBeans.add(bean);
		}
		
		return purchaseBeans;
	}

	
	public List<PurchaseBean> getVendorWisePurchaseRecords(String str) {
		// TODO Auto-generated method stub
		List<PurchaseEntity> purchaseEntities=new ArrayList<>();
		purchaseEntities=reportsDAO.getVendorWisePurchaseRecords(str);
		List<PurchaseBean> purchaseBeans=new ArrayList<>();
		for(PurchaseEntity entity:purchaseEntities) {
			PurchaseBean bean=new PurchaseBean();
			BeanUtils.copyProperties(entity, bean);
			purchaseBeans.add(bean);
		}
		return purchaseBeans;
	}

	
	public List<PurchaseBean> getVendorAndPurchaseIdWiseRecords(String str1, String str2) {
		// TODO Auto-generated method stub
		List<PurchaseEntity> purchaseEntities=new ArrayList<>();
		purchaseEntities=reportsDAO.getVendorAndPurchaseIdWiseRecords(str1, str2);
		List<PurchaseBean> purchaseBeans=new ArrayList<>();
		for(PurchaseEntity entity:purchaseEntities) {
			PurchaseBean bean=new PurchaseBean();
			BeanUtils.copyProperties(entity, bean);
			purchaseBeans.add(bean);
		}
		return purchaseBeans;
	}

	
	public List<String> fetchPurchaseIds() {
		// TODO Auto-generated method stub
		List<String> list=new ArrayList<>();
		list=reportsDAO.fetchPurchaseIds();
		return list;
	}

}
