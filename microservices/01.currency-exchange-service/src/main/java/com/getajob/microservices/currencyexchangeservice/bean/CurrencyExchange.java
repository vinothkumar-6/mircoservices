package com.getajob.microservices.currencyexchangeservice.bean;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import jakarta.persistence.Id;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Entity
public class CurrencyExchange {
    @Id
    private long id;
    @Column(name="currency_from")
    private String from;
    @Column(name="currency_to")
    private String to;
    private BigDecimal conversionMutiple;

    private String environment;

    public CurrencyExchange() {
    }

    public CurrencyExchange(long id, String from, String to, BigDecimal conversionMutiple) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.conversionMutiple = conversionMutiple;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public BigDecimal getConversionMutiple() {
        return conversionMutiple;
    }

    public void setConversionMutiple(BigDecimal conversionMutiple) {
        this.conversionMutiple = conversionMutiple;
    }

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }
}
