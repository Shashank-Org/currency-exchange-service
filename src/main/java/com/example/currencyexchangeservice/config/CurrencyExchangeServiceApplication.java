package com.example.currencyexchangeservice.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import brave.sampler.Sampler;

@SpringBootApplication
@ComponentScan(basePackages = "com.example.currencyexchangeservice.controller")
@EntityScan(basePackages = "com.example.currencyexchangeservice.domain")
@EnableJpaRepositories(basePackages = "com.example.currencyexchangeservice.repository")
//@EnableDiscoveryClient
public class CurrencyExchangeServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(CurrencyExchangeServiceApplication.class, args);
    }
    
  //adding sleuth to this app for enable distributed tracing
    @Bean
    public Sampler defaultSampler() {
    	return Sampler.ALWAYS_SAMPLE;
    }
}
