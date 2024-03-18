package com.example.domain;

import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@Embeddable
public record PhoneNumber(String number, @Enumerated(EnumType.STRING) Type type) {
    public enum Type {
        HOME,
        WORK
    }
}
