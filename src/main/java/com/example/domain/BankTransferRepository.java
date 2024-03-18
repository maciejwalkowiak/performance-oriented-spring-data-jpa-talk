package com.example.domain;

import java.util.List;

import org.springframework.data.repository.ListCrudRepository;

public interface BankTransferRepository extends ListCrudRepository<BankTransfer, String> {
    default BankTransfer findByIdOrThrow(String id) {
        return findById(id).orElseThrow();
    }

    List<BankTransfer> findBySenderId(String senderId);
}
