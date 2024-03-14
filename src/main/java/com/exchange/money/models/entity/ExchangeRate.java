package com.exchange.money.models.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_exchange_rate")
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ExchangeRate {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 5, nullable = false)
    private String currency;

    @Column(nullable = false)
    private Double amount;

}
