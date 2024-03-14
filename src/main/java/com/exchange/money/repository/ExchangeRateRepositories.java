package com.exchange.money.repository;

import com.exchange.money.models.entity.ExchangeRate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ExchangeRateRepositories extends JpaRepository<ExchangeRate, Integer> {
    Optional<ExchangeRate> findByCurrency(String currency);
}
