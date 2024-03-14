package com.exchange.money.models.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ExchangeRateResponse {

    private Double amount;

    private Double amountExchange;

    private String currencyOrigin;

    private String currencyDestin;

    private Double exchangeRate;
}
