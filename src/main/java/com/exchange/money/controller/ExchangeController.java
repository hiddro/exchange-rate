package com.exchange.money.controller;

import com.exchange.money.models.dto.ExchangeRateRequest;
import com.exchange.money.models.dto.ExchangeRateResponse;
import com.exchange.money.models.dto.UpdateAmountRequest;
import com.exchange.money.models.dto.UpdateAmountResponse;
import com.exchange.money.services.ExchangeRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/exchange")
public class ExchangeController {

    @Autowired
    public ExchangeRateService exchangeRateService;

    @PostMapping("/calculate")
    public ResponseEntity<ExchangeRateResponse> calculate (@RequestBody ExchangeRateRequest exchangeRateRequest) {
        return new ResponseEntity<>(exchangeRateService.calculateExchange(exchangeRateRequest), HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity<UpdateAmountResponse> updateCurrency (@RequestBody UpdateAmountRequest updateAmountRequest) {
        return new ResponseEntity<>(exchangeRateService.updateAmount(updateAmountRequest), HttpStatus.OK);
    }
}
