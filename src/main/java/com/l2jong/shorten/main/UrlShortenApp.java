package com.l2jong.shorten.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.l2jong.shorten")
@EnableAutoConfiguration
public class UrlShortenApp {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(UrlShortenApp.class, args);
	}

}
