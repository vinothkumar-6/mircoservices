package com.getajob.microservices.currencyexchangeservice.controller;

import com.getajob.microservices.currencyexchangeservice.bean.CurrencyExchange;
import com.getajob.microservices.currencyexchangeservice.repository.CurrencyExchangeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class CurrencyExchangeController {

    private Logger logger = LoggerFactory.getLogger(CurrencyExchangeController.class);

    @Autowired
    private Environment environment;

    @Autowired
    private CurrencyExchangeRepository currencyExchangeRepository;

    @GetMapping("/currency-exchange-service/from/{from}/to/{to}")
    public CurrencyExchange retrieveExchangeValue(@PathVariable String from,
                                                  @PathVariable String to){

        logger.info("retrieveExchangeValue called with {} to {}", from,to);
     //  CurrencyExchange currencyExchange = new CurrencyExchange(1234L, "INR", "USD", BigDecimal.valueOf(50));
       String port = environment.getProperty("local.server.port");
        CurrencyExchange currencyExchange = currencyExchangeRepository.findByFromAndTo(from,to);
        if(currencyExchange ==null){
            throw new RuntimeException("Unable to Find data");
        }
        currencyExchange.setEnvironment(port);
        return currencyExchange;
    }
}
