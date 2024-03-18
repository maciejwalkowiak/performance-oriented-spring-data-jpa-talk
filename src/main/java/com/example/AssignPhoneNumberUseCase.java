package com.example;

import com.example.domain.Account;
import com.example.domain.AccountRepository;
import com.example.domain.PhoneNumber;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AssignPhoneNumberUseCase {
    private final AccountRepository accountRepository;

    public AssignPhoneNumberUseCase(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Transactional
    public void execute(String accountId, PhoneNumber phoneNumber) {
        Account account = accountRepository.findByIdOrThrow(accountId);
        account.addPhoneNumber(phoneNumber);
        accountRepository.save(account);

    }
}
