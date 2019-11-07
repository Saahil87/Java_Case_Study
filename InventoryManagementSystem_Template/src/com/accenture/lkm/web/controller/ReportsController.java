package com.accenture.lkm.web.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.accenture.lkm.business.bean.DateWisePurchaseReportBean;
import com.accenture.lkm.business.bean.PurchaseBean;
import com.accenture.lkm.business.bean.VendorBean;
import com.accenture.lkm.services.ReportsService;
import com.accenture.lkm.web.client.MaterialCategoryConsumer;
import com.accenture.lkm.web.client.MaterialTypeConsumer;
import com.accenture.lkm.web.client.UnitServiceConsumer;
import com.accenture.lkm.web.client.VendorServiceConsumer;

@RestController
public class ReportsController {
	
	
	@Autowired
	private ReportsService reportService;
	
	@Autowired
	private VendorServiceConsumer vendorServiceConsumer;
	
	@Autowired
	private MaterialCategoryConsumer categoryConsumer;
	
	@Autowired
	private MaterialTypeConsumer typeConsumer;
	
	@Autowired
	private UnitServiceConsumer unitConsumer;


	
	@RequestMapping(value="loadDateWisePurchaseReportPage")
	public ModelAndView loadDateWisePurchaseReportPage() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("dateWisePurchaseReportBean", new DateWisePurchaseReportBean());
		mv.setViewName("PurchaseReportDateWise");
		return mv;
	}
	
	@RequestMapping(value="loadVendorWisePurchaseReportPage")
	public ModelAndView loadVendorWisePurchaseReportPage() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("purchaseBean", new PurchaseBean());
		mv.setViewName("VendorPurchasedItemReport");
		return mv;
	}
	
	@RequestMapping(value="getDateWisePurchaseReportPage", method=RequestMethod.POST)
	public ModelAndView getDateWisePurchaseReportPage(@Valid @ModelAttribute("dateWisePurchaseReportBean")DateWisePurchaseReportBean dateWisePurchaseReportBean, BindingResult result) {
		//get something
		ModelAndView mv = new ModelAndView();
		List<PurchaseBean> purchaseBeans = reportService.getDateWisePurchaseRecords(dateWisePurchaseReportBean.getFromDate(), dateWisePurchaseReportBean.getToDate());
		
		for (PurchaseBean bean : purchaseBeans) {

			bean.setMaterialCategoryName(categoryConsumer.getCategoryMap().get(bean.getMaterialCatergoryId()));

			bean.setMaterialTypeName(typeConsumer.getTypeMap().get(bean.getMaterialTypeId()));

			bean.setUnitName(unitConsumer.getUnitMap().get(bean.getunitId()));

			}
		
		if(result.hasErrors()) {
			mv.addObject("error", result);
			mv.setViewName("PurchaseReportDateWise");
		}else {
		mv.addObject("dateWisePurchaseRecords", purchaseBeans);
		mv.setViewName("PurchaseReportDateWise");
		}
		return mv;
	}
	
	@RequestMapping(value="getVendorWisePurchaseReportPage", method=RequestMethod.POST)
	public ModelAndView getVendorWisePurchaseReportPage(@ModelAttribute("purchaseBean")PurchaseBean purchaseBean) {
		//get something
		ModelAndView mv = new ModelAndView();
		List<PurchaseBean> purchaseBeans = reportService.getVendorWisePurchaseRecords(purchaseBean.getVendorName());
		
		for (PurchaseBean bean : purchaseBeans) {

			bean.setMaterialCategoryName(categoryConsumer.getCategoryMap().get(bean.getMaterialCatergoryId()));

			bean.setMaterialTypeName(typeConsumer.getTypeMap().get(bean.getMaterialTypeId()));

			bean.setUnitName(unitConsumer.getUnitMap().get(bean.getunitId()));

			}
		
		mv.addObject("vendorWisePurchaseRecords", purchaseBeans);
		mv.setViewName("VendorPurchasedItemReport");
		return mv;
	}
	
	@ModelAttribute("generateVendorList")
	public List<VendorBean> generateVendorList() {
		return vendorServiceConsumer.generateVendorList();
	}
	
	
}
