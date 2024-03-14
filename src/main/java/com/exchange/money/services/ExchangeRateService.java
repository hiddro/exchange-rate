package com.exchange.money.services;

import com.exchange.money.models.dto.ExchangeRateRequest;
import com.exchange.money.models.dto.ExchangeRateResponse;
import com.exchange.money.models.dto.UpdateAmountRequest;
import com.exchange.money.models.dto.UpdateAmountResponse;

public interface ExchangeRateService {

    ExchangeRateResponse calculateExchange(ExchangeRateRequest exchangeRateRequest);

    UpdateAmountResponse updateAmount(UpdateAmountRequest updateAmountRequest);
}
