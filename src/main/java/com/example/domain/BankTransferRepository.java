package com.example.domain;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;

public interface BankTransferRepository extends ListCrudRepository<BankTransfer, String> {
    default BankTransfer findByIdOrThrow(String id) {
        return findById(id).orElseThrow();
    }

    //@Query("from BankTransfer b join fetch b.sender join fetch b.receiver where b.id = :senderId")
    @EntityGraph(attributePaths = {"sender", "receiver"})
    List<BankTransfer> findBySenderId(String senderId);
}
