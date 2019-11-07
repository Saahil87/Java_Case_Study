package com.accenture.lkm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class MaterialServiceApplication extends SpringBootServletInitializer {

	//private static final Logger logger = LoggerFactory.getLogger(MaterialServiceApplication.class);
	
	/*Added by KZN for deploying it as war on any server*/
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(MaterialServiceApplication.class);
	}		
	
	public static void main(String[] args) {
		SpringApplication.run(MaterialServiceApplication.class, args);
	}

}
