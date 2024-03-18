package com.example;

import com.example.domain.PhoneNumber;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;

@UseCaseTest
class AssignPhoneNumberUseCaseTests {

    @Autowired
    private AssignPhoneNumberUseCase useCase;

    @Test
    void execute() {
        useCase.execute("sender-id", new PhoneNumber("00334455", PhoneNumber.Type.HOME));
    }

}
