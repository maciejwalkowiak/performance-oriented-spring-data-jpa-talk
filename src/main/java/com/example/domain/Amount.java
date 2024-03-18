package com.example.domain;

import java.math.BigDecimal;
import java.util.Currency;

import jakarta.persistence.Embeddable;

@Embeddable
public record Amount(BigDecimal value, Currency currencyCode) {
    public static Amount of(int value, String code) {
        return new Amount(BigDecimal.valueOf(value), Currency.getInstance(code));
    }
}
