package com.exchange.money.controller;

import com.exchange.money.models.dto.*;
import com.exchange.money.services.ExchangeRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
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

    @GetMapping("/currency")
    public ResponseEntity<List<CurrencyResponse>> listCurrencys () {
        return new ResponseEntity<>(exchangeRateService.currencys(), HttpStatus.OK);
    }
}
