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
import com.accenture.lkm.web.client.VendorServiceConsumer;

@RestController
public class ReportsController {
	
	
	@Autowired
	private ReportsService reportService;
	
	@Autowired
	private VendorServiceConsumer vendorServiceConsumer;
	

	
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
		mv.addObject("vendorBean", new VendorBean());
		mv.setViewName("VendorPurchasedItemReport");
		return mv;
	}
	
	@RequestMapping(value="getDateWisePurchaseReportPage", method=RequestMethod.POST)
	public ModelAndView getDateWisePurchaseReportPage(@Valid @ModelAttribute("dateWisePurchaseReportBean")DateWisePurchaseReportBean dateWisePurchaseReportBean, BindingResult result) {
		//get something
		ModelAndView mv = new ModelAndView();
		List<PurchaseBean> purchaseBeans = reportService.getDateWisePurchaseRecords(dateWisePurchaseReportBean.getFromDate(), dateWisePurchaseReportBean.getToDate());
		mv.addObject("dateWisePurchaseRecords", purchaseBeans);
		mv.setViewName("PurchaseReportDateWise");
		return mv;
	}
	
	@RequestMapping(value="getVendorWisePurchaseReportPage", method=RequestMethod.POST)
	public ModelAndView getVendorWisePurchaseReportPage(@Valid @ModelAttribute("purchaseBean")PurchaseBean purchaseBean) {
		//get something
		ModelAndView mv = new ModelAndView();
		List<PurchaseBean> purchaseBeans = reportService.getVendorWisePurchaseRecords(purchaseBean.getVendorName());
		mv.addObject("vendorWisePurchaseRecords", purchaseBeans);
		mv.setViewName("VendorPurchasedItemReport");
		return mv;
	}
	
	@ModelAttribute("generateVendorList")
	public List<VendorBean> generateVendorList() {
		return vendorServiceConsumer.generateVendorList();
	}
	
	@ModelAttribute("listOfPurchaseBeans")
	public List<PurchaseBean> fetchMaterialCategoryTypeandUnitNames(List<PurchaseBean> purchaseBeans){
		return purchaseBeans;
	}
	
}
