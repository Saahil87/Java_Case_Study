package com.accenture.lkm.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.lkm.business.bean.PurchaseBean;
import com.accenture.lkm.dao.ReportsDAOWrapper;

@Service
public class ReportsServiceImpl implements ReportsService {

	@Autowired
	ReportsDAOWrapper daoWrapper;
	
	
	
	public ReportsServiceImpl() {
		super();
	}



	@Override
	public List<PurchaseBean> getDateWisePurchaseRecords(Date fromDate,Date toDate) {
		// TODO Auto-generated method stub
		return daoWrapper.getDateWisePurchaseRecords(fromDate,toDate);
	}

	
	public List<PurchaseBean> getVendorWisePurchaseRecords(String vendorName)
	{
		return daoWrapper.getVendorWisePurchaseRecords(vendorName);
		
	}
	
	public List<PurchaseBean> getVendorAndPurchaseIdWiseRecords(String vendorName, String purchaseId)
	{
		return daoWrapper.getVendorAndPurchaseIdWiseRecords(vendorName,purchaseId);
		
	}
	
	public List<String> fetchPurchaseIds(String vendorName)
	{
		return daoWrapper.fetchPurchaseIds(vendorName);
		
	}



	
	
}
