package com.accenture.lkm.web.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.accenture.lkm.business.bean.MaterialCategoryBean;
import com.accenture.lkm.business.bean.MaterialTypeBean;
import com.accenture.lkm.business.bean.PurchaseBean;
import com.accenture.lkm.business.bean.UnitBean;
import com.accenture.lkm.business.bean.VendorBean;
import com.accenture.lkm.services.PurchaseService;
import com.accenture.lkm.web.client.MaterialCategoryConsumer;
import com.accenture.lkm.web.client.MaterialTypeConsumer;
import com.accenture.lkm.web.client.UnitServiceConsumer;
import com.accenture.lkm.web.client.VendorServiceConsumer;

@RestController
public class PurchaseEntryController {
	
	@Autowired
	private PurchaseService service;
	
	@Autowired
	private VendorServiceConsumer vendorServiceConsumer;
	
	@Autowired
	private MaterialCategoryConsumer categoryConsumer;
	
	@Autowired
	private MaterialTypeConsumer typeConsumer;
	
	@Autowired
	private UnitServiceConsumer unitConsumer;

	
	@RequestMapping(value="loadPurchaseEntryPage")
	public ModelAndView loadPurchaseEntryPage() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("purchaseBean", new PurchaseBean());
		mv.setViewName("PurchaseEntry");
		return mv;
	}
	
	
	public ModelAndView addPurchaseEntry(@Valid @ModelAttribute("purchaseBean")PurchaseBean purchaseBean, BindingResult result) {
		ModelAndView mv = new ModelAndView();
		if(result.hasErrors()) {
			mv.setViewName("PurchaseEntry");
			mv.addObject("error", result);
			
		}else {
			PurchaseBean bean = service.addPurchaseEntry(purchaseBean);
			String msg = "Purchase Entry Added with Purchase id as : "+bean.getPurchaseId();
			mv.addObject("successful", msg);
			mv.setViewName("PurchaseEntry");
		}
		return mv;
	}
	
	
	
	public ModelAndView fetchMaterialTypesAndMaterialUnitsList(PurchaseBean purchaseBean) {
		List<MaterialTypeBean> materialTypeBeans = typeConsumer.generateMaterialTypeBeanList();
		List<UnitBean> unitBeans = unitConsumer.getUnitBeanList();
		
		ModelAndView mv = new ModelAndView();
		
	}
	
	@ModelAttribute("generateVendorList")
	public List<VendorBean> generateVendorList() {
		return vendorServiceConsumer.generateVendorList();
	}
	
	@ModelAttribute("generateMaterialCategoryList")
	public List<MaterialCategoryBean> generateMaterialCategoryList(){
		return categoryConsumer.generateMaterialCategoryBeanList();
	}
	
	
	
	
}
