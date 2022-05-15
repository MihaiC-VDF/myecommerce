package com.vodafone.myecommerce;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;


@SpringBootApplication
public class MyecommerceApplication extends SpringBootServletInitializer {

	@Autowired
	public MyecommerceApplication(){};

	public static void main(String[] args) {
		SpringApplication.run(MyecommerceApplication.class, args);
	}

}
