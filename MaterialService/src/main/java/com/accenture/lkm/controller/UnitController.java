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

import com.accenture.lkm.business.bean.UnitBean;
import com.accenture.lkm.service.UnitService;

@RestController
public class UnitController {

	@Autowired
	private UnitService unitService;

	public UnitController() {
		super();
	}
	
	
	@RequestMapping(value="/get/units", method=RequestMethod.GET, consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<UnitBean>> getUnits()
	{
		
		List<UnitBean> list=unitService.getUnits();
		if(!list.isEmpty()) {
			return new ResponseEntity<Collection<UnitBean>>(list, HttpStatus.ACCEPTED);
		}else {
			return new ResponseEntity<Collection<UnitBean>>(list, HttpStatus.NOT_FOUND);
		}
		
	}
	
	
	@RequestMapping(value="/get/units/{categoryId}", method=RequestMethod.GET, consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<UnitBean>> getUnitsByCategoryId(@PathVariable("categoryId") String categoryId)
	{
		List<UnitBean> list=unitService.getUnits(categoryId);
		if(!list.isEmpty()) {
			return new ResponseEntity<Collection<UnitBean>>(list, HttpStatus.ACCEPTED);
		}else {
			return new ResponseEntity<Collection<UnitBean>>(list, HttpStatus.NOT_FOUND);
		}
	}
	
	
	
	
	
	
	
}
