package com.mfpe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class AuditAuthorizationApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuditAuthorizationApplication.class, args);
	}

}
