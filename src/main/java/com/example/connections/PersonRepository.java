package com.example.connections;

import org.springframework.data.repository.ListCrudRepository;

public interface PersonRepository extends ListCrudRepository<Person, String> {
}
