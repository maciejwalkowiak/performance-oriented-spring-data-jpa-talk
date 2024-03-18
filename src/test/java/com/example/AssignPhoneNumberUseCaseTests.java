package com.example;

import com.example.domain.PhoneNumber;
import org.junit.jupiter.api.Test;

import org.quickperf.sql.annotation.ExpectDelete;
import org.quickperf.sql.annotation.ExpectSelect;
import org.quickperf.sql.annotation.ExpectUpdate;
import org.springframework.beans.factory.annotation.Autowired;

@UseCaseTest
class AssignPhoneNumberUseCaseTests {

    @Autowired
    private AssignPhoneNumberUseCase useCase;

    @Test
    @ExpectSelect(1)
    @ExpectUpdate(1)
    @ExpectDelete(0)
    void execute() {
        useCase.execute("sender-id", new PhoneNumber("00334455", PhoneNumber.Type.HOME));
    }

}
