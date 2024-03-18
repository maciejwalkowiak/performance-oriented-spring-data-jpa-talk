package com.example.connections;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.hibernate.annotations.UuidGenerator;

@Entity
public class Person {

    @Id
    @UuidGenerator
    private String id;
}
