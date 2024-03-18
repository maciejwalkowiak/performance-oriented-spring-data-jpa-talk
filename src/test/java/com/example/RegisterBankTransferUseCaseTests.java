package com.example;

import java.util.UUID;

import com.example.domain.Amount;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;

@UseCaseTest
class RegisterBankTransferUseCaseTests {

    @Autowired
    private RegisterBankTransferUseCase useCase;

    @Test
    void executes() {
        useCase.execute(UUID.randomUUID().toString(), "my reference", "sender-id", "receiver-id", Amount.of(10, "EUR"));
    }

}
