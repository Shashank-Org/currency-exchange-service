package com.example.currencyexchangeservice.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "currency_exchange")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CurrencyExchangeBean {

    @Id
    @Column(name = "id")
    private long id;

    @Column(name = "currency_from")
    private String currencyFrom;

    @Column(name = "currency_to")
    private String currencyTo;

    @Column(name = "rate")
    private double conversionMultiple;

    @Transient
    private int port;
}
