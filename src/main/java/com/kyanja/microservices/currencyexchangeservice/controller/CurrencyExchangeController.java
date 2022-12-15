package com.kyanja.microservices.currencyexchangeservice.controller;

import com.kyanja.microservices.currencyexchangeservice.model.ExchangeValue;
import com.kyanja.microservices.currencyexchangeservice.model.ExchangeValueModel;
import com.kyanja.microservices.currencyexchangeservice.service.ExchangeValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;



@RestController
public class CurrencyExchangeController
{


    @Autowired
    private Environment environment;

    @Autowired
    ExchangeValueService exchangeValueService;

//
//    @GetMapping("/currency-exchange/from/{from}/to/{to}")       //where {from} and {to} are path variable
//    public ExchangeValue retrieveExchangeValue(@PathVariable String from, @PathVariable String to)  //from map to USD and to map to INR
//    {
//        //taking the exchange value
//        ExchangeValue exchangeValue= new ExchangeValue (1000L, from, to, BigDecimal.valueOf(65));
//         //picking port from the environment
//        exchangeValue.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
//        return exchangeValue;
//    }

    @GetMapping("/currency-exchange/from/{from}/to/{to}")       //where {from} and {to} are path variable
    ExchangeValueModel retrieveExchangeValue(@PathVariable String from, @PathVariable String to)   //from map to USD and to map to INR
    {
        ExchangeValueModel exchangeValue = exchangeValueService.findByFromAndTo(from, to);
    //setting the port
        exchangeValue.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
        return exchangeValue;
    }
}