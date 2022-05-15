package com.vodafone.myecommerce;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
//@EnableSwagger2
public class MyecommerceApplication {

	@Autowired
	public MyecommerceApplication(){};

	public static void main(String[] args) {
		SpringApplication.run(MyecommerceApplication.class, args);
	}

}
