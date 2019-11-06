package com.accenture.lkm.services;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;

import com.accenture.lkm.business.bean.PurchaseBean;
import com.accenture.lkm.dao.PurchaseDAOWrapper;

public class PurchaseServiceImpl implements PurchaseService {

	@Autowired
	PurchaseDAOWrapper daoWrapper;

	public PurchaseServiceImpl() {
		super();
	}

	@Override
	public PurchaseBean addPurchaseEntry(PurchaseBean purchaseBean) {
		// TODO Auto-generated method stub
		return daoWrapper.addPurchaseEntry(purchaseBean);
	}

	public String purchaseIdGenerator(PurchaseBean purchaseBean) {
		

		SimpleDateFormat simpleDateformat = new SimpleDateFormat("MMMddEEE");
		
		Random randomGenerator = new Random();
	

		String purchaseId = "P_" + purchaseBean.getVendorName().substring(0, 3) + "_"
				+ simpleDateformat.format(purchaseBean.getPurchaseDate()) +"_"
				+ purchaseBean.getMaterialCatergoryId()+"_"+(randomGenerator.nextInt(101));
		
		return purchaseId;

	}
}
