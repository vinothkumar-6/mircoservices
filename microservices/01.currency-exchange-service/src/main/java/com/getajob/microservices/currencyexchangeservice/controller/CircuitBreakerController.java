package com.getajob.microservices.currencyexchangeservice.controller;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CircuitBreakerController {

    private final Logger logger = LoggerFactory.getLogger(CircuitBreakerController.class);

    @GetMapping("/sample-api")
    //@Retry(name="sample-api", fallbackMethod = "hardCodedMethod")
    @CircuitBreaker(name="sample-api", fallbackMethod = "hardCodedMethod")
    public String sampleAPI(){
        logger.info("sample api call received");
        ResponseEntity<String> responseEntity= new RestTemplate().getForEntity("http://localhost8080/helloApi",String.class);
        return responseEntity.getBody();
    }
    public String hardCodedMethod(Exception ex){
        return "fallback-response";
    }
}
