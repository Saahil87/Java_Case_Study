package com.accenture.lkm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.lkm.business.bean.MaterialCategoryBean;
import com.accenture.lkm.service.MaterialService;

@RestController
public class MaterialController {

	//private static final Logger logger = LoggerFactory.getLogger(MaterialController.class);
	
	
	/*
	 * Autowire the MaterialService object
	 * 
	 * */
	
	// Your Code Here
	@Autowired
	private MaterialService materialService;
	
	
	@GetMapping("/")
	public String index() {
		return "Welcome to Spring Boot Material Service API!";
	}
	
	
	/* 
	 * Method - getMaterialCategories()
	 * Fetch all the material categories details using MaterialService and store it inside a List
	 * Return a ResponseEntity object passing the list of material categories
	 * 
	 */
		
	@GetMapping(value = "/material/controller/getMaterialCategories", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<MaterialCategoryBean>> getMaterialCategories() {
				
		// Your Code Here
		
		List<MaterialCategoryBean> list=materialService.getMaterialCategories();
		if(!list.isEmpty())
			return new ResponseEntity<List<MaterialCategoryBean>>(list,HttpStatus.ACCEPTED);
		else		
		
		return new ResponseEntity<List<MaterialCategoryBean>>(list,HttpStatus.NOT_FOUND);
	}

	
	/* 
	 * Method - getMaterialCategoryById()
	 * Fetch a single MaterialCategoryBean using MaterialService object and passing --> categoryId
	 * Return a ResponseEntity object passing the MaterialCategoryBean object
	 * 
	 */
			
	@GetMapping(value = "/material/controller/getMaterialCategoryById/{categoryId}", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<MaterialCategoryBean> getMaterialCategoryById(@PathVariable("categoryId") String categoryId) {

		// Your Code Here
		MaterialCategoryBean materialCategoryBean=materialService.getMaterialCategoryById(categoryId);
		
		if(materialCategoryBean!=null)
		return new ResponseEntity<MaterialCategoryBean>(materialCategoryBean, HttpStatus.ACCEPTED);
		else
		return new ResponseEntity<MaterialCategoryBean>(materialCategoryBean, HttpStatus.NOT_FOUND);
	}
	
	
}
