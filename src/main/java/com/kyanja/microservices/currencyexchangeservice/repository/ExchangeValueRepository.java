package com.kyanja.microservices.currencyexchangeservice.repository;

import com.kyanja.microservices.currencyexchangeservice.model.ExchangeValueModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExchangeValueRepository extends JpaRepository<ExchangeValueModel, Long> {


    ExchangeValueModel findByFromAndTo(String from, String to);

    ExchangeValueModel findByFrom (String from);
}
