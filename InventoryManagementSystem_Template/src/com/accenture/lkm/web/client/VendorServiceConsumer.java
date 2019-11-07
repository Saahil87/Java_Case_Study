package com.accenture.lkm.web.client;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.accenture.lkm.business.bean.VendorBean;

@Service
public class VendorServiceConsumer {
	
	@Value("${VendorServiceConsumer.serviceURL}")
	private String serviceURL;
	
	@Value("${VendorServiceConsumer.apiURL}")
	private String apiURL;
	
	private RestTemplate template;
	
	private List<VendorBean> vendorBeans = new ArrayList<VendorBean>();
	
	
	
	public VendorServiceConsumer() {
		super();
		template = new RestTemplate();
	}


	public List<VendorBean> generateVendorList(){
		
			 hitGetVendorDetails();
		
		return vendorBeans;
	}
	
	private void hitGetVendorDetails() {
		try {
			
			System.out.println(serviceURL + apiURL);
			
			
			ResponseEntity<VendorBean[]> response = template.getForEntity(serviceURL + apiURL /*"http://javastreamims.devops.vendorservice.ci.34.254.177.151.xip.io/project/vendor/controller/getVendors"*/, VendorBean[].class);
			this.vendorBeans = Arrays.asList(response.getBody());
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		VendorServiceConsumer v = new VendorServiceConsumer();
		System.out.println(v.generateVendorList());
	}
	
	
}
