package com.atul.prod_ready_features;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ProdReadyFeaturesApplication {

	public static void main(String[] args) {
        System.out.println("Starting prod ready features ...");
		SpringApplication.run(ProdReadyFeaturesApplication.class, args);
	}

}
