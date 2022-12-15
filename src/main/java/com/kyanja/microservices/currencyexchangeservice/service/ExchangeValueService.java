package com.kyanja.microservices.currencyexchangeservice.service;


import com.kyanja.microservices.currencyexchangeservice.model.ExchangeValueModel;
import com.kyanja.microservices.currencyexchangeservice.repository.ExchangeValueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ExchangeValueService {

    @Autowired
    private ExchangeValueRepository repository;


    public ExchangeValueModel findByFromAndTo(String from, String to) {
        return repository.findByFromAndTo(from,to);
    }

    ExchangeValueModel findByFrom(String from) {
        return repository.findByFrom(from);
    }


}
