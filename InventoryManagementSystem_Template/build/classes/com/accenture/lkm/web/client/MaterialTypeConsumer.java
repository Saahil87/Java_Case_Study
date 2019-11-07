package com.accenture.lkm.web.client;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.accenture.lkm.business.bean.MaterialTypeBean;
@Service
public class MaterialTypeConsumer {
	@Value(value="${MaterialServiceConsumer.serviceURL}")
	private String serviceURL;
	
	@Value("${MaterialTypeConsumer.apiURL}")
	private String apiURL;
	
	@Value("${MaterialTypeConsumer.apiURLByCategoryId}")
	private String apiURLForById;
	
	private RestTemplate template;

	private List<MaterialTypeBean> materialTypeBeans;
	
	private Map<String, String> map;

	public MaterialTypeConsumer() {
		super();
		template = new RestTemplate();
	}
	
	
	public List<MaterialTypeBean> generateMaterialTypeBeanList(){
		if(materialTypeBeans == null)
			hitGetMaterialTypes();
		
		return materialTypeBeans;
	}
	
	public Map<String, String> getTypeMap() {
		map = new HashMap<>();
		if(materialTypeBeans == null)
			hitGetMaterialTypes();
		
		for (MaterialTypeBean materialTypeBean : materialTypeBeans) {
			map.put(materialTypeBean.getTypeId(), materialTypeBean.getTypeName());
		}
		
		return map;
	}
	
	public List<MaterialTypeBean> getMaterialTypeId(String TypeId){
		if(materialTypeBeans == null)
			hitGetMaterialTypes(TypeId);
		
		return materialTypeBeans;
	}
	
	private void hitGetMaterialTypes() {
		try {
			ResponseEntity<MaterialTypeBean[]> responseEntity = template.getForEntity(serviceURL + apiURL, MaterialTypeBean[].class);
			this.materialTypeBeans = Arrays.asList(responseEntity.getBody());
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	private void hitGetMaterialTypes(String TypeId) {
		try {
			ResponseEntity<MaterialTypeBean[]> responseEntity = template.getForEntity(serviceURL + apiURLForById + TypeId, MaterialTypeBean[].class);
			this.materialTypeBeans = Arrays.asList(responseEntity.getBody());
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
}
