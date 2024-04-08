package com.getajob.microservices.currencyexchangeservice.repository;

import com.getajob.microservices.currencyexchangeservice.bean.CurrencyExchange;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyExchangeRepository extends JpaRepository<CurrencyExchange, Long> {

    public CurrencyExchange findByFromAndTo(String from, String to);
}
