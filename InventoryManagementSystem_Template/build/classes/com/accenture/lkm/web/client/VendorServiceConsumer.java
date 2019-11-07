package com.accenture.lkm.web.client;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.accenture.lkm.business.bean.VendorBean;

@Service
public class VendorServiceConsumer {
	
	@Value(value="${VendorServiceConsumer.serviceURL}")
	private String serviceURL = "http://javastreamims.devops.vendorservice.ci.34.250.151.150.xip.io/project/";
	
	@Value("${VendorServiceConsumer.apiURL}")
	private String apiURL = "vendor/controller/getVendors";
	
	private RestTemplate template;
	
	private List<VendorBean> vendorBeans;
	
	
	
	public VendorServiceConsumer() {
		super();
		template = new RestTemplate();
	}


	public List<VendorBean> generateVendorList(){
		if(vendorBeans == null) {
			 hitGetVendorDetails();
		}
		return vendorBeans;
	}
	
	private void hitGetVendorDetails() {
		try {
			ResponseEntity<VendorBean[]> response = template.getForEntity(serviceURL + apiURL, VendorBean[].class);
			this.vendorBeans = Arrays.asList(response.getBody());
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	 
}
