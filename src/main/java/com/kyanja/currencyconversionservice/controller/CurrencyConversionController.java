package com.kyanja.currencyconversionservice.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import com.kyanja.currencyconversionservice.model.CurrencyConversionBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CurrencyConversionController {


    @Autowired
    private CurrencyExchangeServiceProxy proxy;


    @GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
    //where {from} and {to} represents the column
    //return a bean back
    public CurrencyConversionBean convertCurrency(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity) {
        //setting variables to currency exchange service
//        Map<String, String> uriVariables = new HashMap<>();
//        uriVariables.put("from", from);
//        uriVariables.put("to", to);
    //calling the currency-exchange-service by using rest template
//        ResponseEntity<CurrencyConversionBean> responseEntity = new RestTemplate().getForEntity("http://localhost:8082/currency-exchange/from/{from}/to/{to}", CurrencyConversionBean.class, uriVariables);
//        CurrencyConversionBean response = responseEntity.getBody();

        //creating a new response bean and getting the response back and taking it into Bean
//        return new CurrencyConversionBean(response.getId(), from, to, response.getConversionMultiple(), quantity, quantity.multiply(response.getConversionMultiple()), response.getPort());

        //calling the currency-exchange-service by using Spring Cloud - Synchronous Communication with Feign
        CurrencyConversionBean currencyConversionBean = proxy.convertCurrency(from,to);

        return new CurrencyConversionBean(currencyConversionBean.getId(), from, to, currencyConversionBean.getConversionMultiple(), quantity, quantity.multiply(currencyConversionBean.getConversionMultiple()), currencyConversionBean.getPort());
    }


}
