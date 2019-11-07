package com.accenture.lkm.web.client;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.accenture.lkm.business.bean.MaterialCategoryBean;

@Service
public class MaterialCategoryConsumer {
	
	@Value("${MaterialServiceConsumer.serviceURL}")
	private String serviceURL;
	
	@Value("${MaterialCategoryConsumer.apiURL}")
	private String apiURL;
	
	@Value("${MaterialCategoryConsumer.apiURLForById}")
	private String apiURLForById;
	
	private RestTemplate template;

	private List<MaterialCategoryBean> materialCategoryBeans = new ArrayList<MaterialCategoryBean>();
	
	private Map<String, String> map = new HashMap<>();

	public MaterialCategoryConsumer() {
		super();
		template = new RestTemplate();
	}

	public List<MaterialCategoryBean> generateMaterialCategoryBeanList(){
			hitGetMaterialCategories();
		
		return materialCategoryBeans;
	}
	
	public Map<String, String> getCategoryMap() {
			hitGetMaterialCategories();
		
		for (MaterialCategoryBean materialCategoryBean : materialCategoryBeans) {
			map.put(materialCategoryBean.getCategoryId(), materialCategoryBean.getCategoryName());
		}
		
		return map;
	}
	
	public List<MaterialCategoryBean> getMaterialCategoryId(String categoryId){
			hitGetMaterialCategories(categoryId);
		
		return materialCategoryBeans;
	}
	
	private void hitGetMaterialCategories() {
		try {
			ResponseEntity<MaterialCategoryBean[]> responseEntity = template.getForEntity(serviceURL + apiURL , MaterialCategoryBean[].class);
			this.materialCategoryBeans = Arrays.asList(responseEntity.getBody());
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	private void hitGetMaterialCategories(String categoryId) {
		try {
			ResponseEntity<MaterialCategoryBean[]> responseEntity = template.getForEntity(serviceURL + apiURLForById + categoryId, MaterialCategoryBean[].class);
			this.materialCategoryBeans = Arrays.asList(responseEntity.getBody());
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		MaterialCategoryConsumer m = new MaterialCategoryConsumer();
		System.out.println(m.generateMaterialCategoryBeanList());
	}
	
}
