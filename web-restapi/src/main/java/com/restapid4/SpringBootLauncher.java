package com.restapid4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
//annotation for enabling swagger2
@EnableSwagger2
public class SpringBootLauncher {
	
	public static void main(String[] args) {
		
		SpringApplication.run(SpringBootLauncher.class,args);
	}
}
