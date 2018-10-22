package com.dabbotorg.lavatie;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@EnableAutoConfiguration
@Configuration
@Slf4j
@SpringBootApplication
@ComponentScan(basePackages = "com.dabbotorg.lavatie")
public class LavatieApplication {

	public static void main(String[] args) {
		SpringApplication.run(LavatieApplication.class, args);
	}
}
