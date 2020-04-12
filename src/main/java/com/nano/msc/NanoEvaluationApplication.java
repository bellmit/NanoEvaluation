package com.nano.msc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.util.TimeZone;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@ComponentScan("com.nano.msc")
public class NanoEvaluationApplication {

	public static void main(String[] args) {
		SpringApplication.run(NanoEvaluationApplication.class, args);
	}

}
