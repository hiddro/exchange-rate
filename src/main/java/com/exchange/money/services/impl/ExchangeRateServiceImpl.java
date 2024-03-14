package com.exchange.money.services.impl;

import com.exchange.money.models.dto.ExchangeRateRequest;
import com.exchange.money.models.dto.ExchangeRateResponse;
import com.exchange.money.models.dto.UpdateAmountRequest;
import com.exchange.money.models.dto.UpdateAmountResponse;
import com.exchange.money.models.entity.ExchangeRate;
import com.exchange.money.repository.ExchangeRateRepositories;
import com.exchange.money.services.ExchangeRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExchangeRateServiceImpl implements ExchangeRateService {

    @Autowired
    public ExchangeRateRepositories exchangeRateRepositories;

    @Override
    public ExchangeRateResponse calculateExchange(ExchangeRateRequest exchangeRateRequest) {

        return exchangeRateRepositories.findByCurrency(exchangeRateRequest.getCurrencyDestin())
                .map(ex -> {
                    return ExchangeRateResponse.builder()
                            .amount(exchangeRateRequest.getAmount())
                            .amountExchange(exchangeRateRequest.getAmount() * ex.getAmount())
                            .currencyOrigin(exchangeRateRequest.getCurrencyOrigin())
                            .currencyDestin(exchangeRateRequest.getCurrencyDestin())
                            .exchangeRate(ex.getAmount())
                            .build();
                }).orElseThrow(() -> {
                    throw new RuntimeException("No se encontró tipo de cambio para la moneda de destino: " + exchangeRateRequest.getCurrencyDestin());
                });
    }

    @Override
    public UpdateAmountResponse updateAmount(UpdateAmountRequest updateAmountRequest) {
        return exchangeRateRepositories.findByCurrency(updateAmountRequest.getCurrency())
                .map(ex -> {
                    ExchangeRate exchange = exchangeRateRepositories.save(ExchangeRate.builder()
                            .id(ex.getId())
                            .amount(updateAmountRequest.getNewAmount())
                            .currency(ex.getCurrency())
                            .build());

                    return UpdateAmountResponse.builder()
                            .amount(updateAmountRequest.getNewAmount())
                            .oldAmount(ex.getAmount())
                            .currency(ex.getCurrency())
                            .build();
                })
                .orElseThrow(() -> {
                    throw new RuntimeException("No se encontró tipo de cambio para la moneda de destino: " + updateAmountRequest.getCurrency());
                });
    }
}
