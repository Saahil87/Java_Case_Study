package com.accenture.lkm.web.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.accenture.lkm.business.bean.LoginBean;
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
@SessionAttributes({"materialTypeBeans","unitBeans"})
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
	public ModelAndView loadPurchaseEntryPage(HttpSession session) {
		ModelAndView mv = new ModelAndView();
		String name = (String) session.getAttribute("username");
		mv.addObject("username", name);
		mv.addObject("purchaseBean", new PurchaseBean());
		mv.setViewName("PurchaseEntry");
		return mv;
	}
	
	@RequestMapping(value="addPurchaseEntry", method=RequestMethod.POST)
	public ModelAndView addPurchaseEntry(@Valid @ModelAttribute("purchaseBean")PurchaseBean purchaseBean, BindingResult result, HttpSession session) {
		ModelAndView mv = new ModelAndView();
		
		if(result.hasErrors()) {
			mv.setViewName("PurchaseEntry");
		}
		else {
			
				mv.setViewName("welcome");
				PurchaseBean bean = service.addPurchaseEntry(purchaseBean);
				String msg = "Purchase Entry Added with Purchase id as : "+bean.getPurchaseId();
				mv.addObject("successful", msg);
				mv.setViewName("PurchaseEntry");
			
		}
		return mv;
	}
	
	
	//Something is up here 
	
	@RequestMapping(value="fetchMaterialTypesAndMaterialUnitsList", method=RequestMethod.POST)
	public ModelAndView fetchMaterialTypesAndMaterialUnitsList(@ModelAttribute("purchaseBean")PurchaseBean purchaseBean) {
		List<MaterialTypeBean> materialTypeBeans = typeConsumer.getMaterialTypeId(purchaseBean.getMaterialCatergoryId());
		List<UnitBean> unitBeans = unitConsumer.getMaterialUnitByCategoryId(purchaseBean.getMaterialCatergoryId());

		ModelAndView mv = new ModelAndView();
		mv.addObject("materialTypeBeans", materialTypeBeans);
		mv.addObject("unitBeans" , unitBeans);
		mv.setViewName("PurchaseEntry");
		return mv;
		
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
