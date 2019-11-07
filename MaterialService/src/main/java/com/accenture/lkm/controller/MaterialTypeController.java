package com.accenture.lkm.controller;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.lkm.business.bean.MaterialTypeBean;
import com.accenture.lkm.service.MaterialTypeService;

@RestController
public class MaterialTypeController {

	@Autowired
	MaterialTypeService materialTypeService;

	public MaterialTypeController() {
		super();
	}
	
	@RequestMapping(value="/get/type/details", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<MaterialTypeBean>> getTypeDetails()
	{
		List<MaterialTypeBean> list=materialTypeService.getMaterialTypes();
		if(!list.isEmpty()) {
			return new ResponseEntity<Collection<MaterialTypeBean>>(list, HttpStatus.ACCEPTED);
		}else {
			return new ResponseEntity<Collection<MaterialTypeBean>>(list, HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value="/get/type/details/{categoryId}",method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<Collection<MaterialTypeBean>> getTypeBasedOnCategoryId(@PathVariable("categoryId") String categoryId)
	{
		List<MaterialTypeBean> list=materialTypeService.getMaterialTypes(categoryId);
		if(!list.isEmpty()) {
			return new ResponseEntity<Collection<MaterialTypeBean>>(list, HttpStatus.ACCEPTED);
		}else {
			return new ResponseEntity<Collection<MaterialTypeBean>>(list, HttpStatus.NOT_FOUND);
		}
	}
}
