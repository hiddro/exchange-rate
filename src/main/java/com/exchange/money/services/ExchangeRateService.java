package com.exchange.money.services;

import com.exchange.money.models.dto.*;

import java.util.List;

public interface ExchangeRateService {

    ExchangeRateResponse calculateExchange(ExchangeRateRequest exchangeRateRequest);

    UpdateAmountResponse updateAmount(UpdateAmountRequest updateAmountRequest);

    List<CurrencyResponse> currencys();
}
