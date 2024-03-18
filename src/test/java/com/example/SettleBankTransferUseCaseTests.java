package com.example;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;

@UseCaseTest
class SettleBankTransferUseCaseTests {

    @Autowired
    private SettleBankTransferUseCase useCase;

    @Test
    void executes() {
        useCase.execute("bank-transfer-id");
    }

}
