package com.atul.miniproject.Quotable;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class QuotableApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuotableApplication.class, args);
	}

}
