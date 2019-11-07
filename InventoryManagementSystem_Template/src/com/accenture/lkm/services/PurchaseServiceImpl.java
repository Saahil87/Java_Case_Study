package com.accenture.lkm.services;

import java.text.SimpleDateFormat;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.lkm.business.bean.PurchaseBean;
import com.accenture.lkm.dao.PurchaseDAOWrapper;

@Service
public class PurchaseServiceImpl implements PurchaseService {

	@Autowired
	PurchaseDAOWrapper daoWrapper;

	public PurchaseServiceImpl() {
		super();
	}

	@Override
	public PurchaseBean addPurchaseEntry(PurchaseBean purchaseBean) {
		purchaseBean.setPurchaseId(purchaseIdGenerator(purchaseBean));
		return daoWrapper.addPurchaseEntry(purchaseBean);
	}

	private String purchaseIdGenerator(PurchaseBean purchaseBean) {
		SimpleDateFormat simpleDateformat = new SimpleDateFormat("MMMddEEE");
		Random randomGenerator = new Random();
		String purchaseId = "P_" + purchaseBean.getVendorName().substring(0, 3).toUpperCase() + "_"
				+ simpleDateformat.format(purchaseBean.getPurchaseDate()) +"_"
				+ purchaseBean.getMaterialCatergoryId()+"_"+(randomGenerator.nextInt(101));
		return purchaseId;
	}
}