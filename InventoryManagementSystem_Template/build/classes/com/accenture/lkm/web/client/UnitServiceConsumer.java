package com.accenture.lkm.web.client;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.accenture.lkm.business.bean.UnitBean;

@Service
public class UnitServiceConsumer {
	@Value(value="${MaterialServiceConsumer.serviceURL}")
	private String serviceURL;
	
	@Value("${UnitServiceConsumer.apiURL}")
	private String apiURL;
	
	@Value("${UnitServiceConsumer.apiURLByCategoryId}")
	private String apiURLForById;
	
	private RestTemplate template;

	private List<UnitBean> unitBeans;
	
	private Map<String, String> map;
	
 	public UnitServiceConsumer() {
		super();
		template =new RestTemplate();
	}
	
	public List<UnitBean> getUnitBeanList(){
		if(unitBeans == null)
			hitGetUnitDetails();
		
		return unitBeans;
	}
	
	public Map<String, String> getUnitMap() {
		map = new HashMap<>();
		if(unitBeans == null)
			hitGetUnitDetails();
		
		for (UnitBean unitBean : unitBeans) {
			map.put(unitBean.getUnitId(), unitBean.getUnitName());
		}
		
		return map;
	}
	
	public List<UnitBean> getMaterialUnitByCategoryId(String categoryId){
		if(unitBeans == null)
			hitGetUnitDetails(categoryId);
		
		return unitBeans;
	}
	
	private void hitGetUnitDetails() {
		try {
			ResponseEntity<UnitBean[]> responseEntity = template.getForEntity(serviceURL + apiURL, UnitBean[].class);
			this.unitBeans = Arrays.asList(responseEntity.getBody());
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	private void hitGetUnitDetails(String categoryId) {
		try {
			ResponseEntity<UnitBean[]> responseEntity = template.getForEntity(serviceURL + apiURLForById + categoryId, UnitBean[].class);
			this.unitBeans = Arrays.asList(responseEntity.getBody());
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
}
