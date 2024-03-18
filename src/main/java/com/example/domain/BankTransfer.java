package com.example.domain;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Version;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@DynamicUpdate
public class BankTransfer {
    public enum State {
        CREATED,
        SETTLED
    }
    @Id
    private String id;

    private String reference;

    @ManyToOne(fetch = FetchType.LAZY)
    private Account sender;

    @ManyToOne(fetch = FetchType.LAZY)
    private Account receiver;

    @Embedded
    private Amount amount;

    @Enumerated(EnumType.STRING)
    private State state;

    @Version
    private Long version;

    public BankTransfer() {
    }

    public BankTransfer(String id, String reference, Account sender, Account receiver, Amount amount) {
        this.id = id;
        this.reference = reference;
        this.sender = sender;
        this.receiver = receiver;
        this.amount = amount;
        this.state = State.CREATED;
    }

    public void settle() {
        this.state = State.SETTLED;
    }

    public String getId() {
        return id;
    }

    public Account getSender() {
        return sender;
    }

    public Account getReceiver() {
        return receiver;
    }

    public Amount getAmount() {
        return amount;
    }

    public State getState() {
        return state;
    }

    public String getReference() {
        return reference;
    }
}
