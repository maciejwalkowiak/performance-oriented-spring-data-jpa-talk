package com.example.connections;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SampleService {
    private final AnotherService anotherService;
    private final PersonRepository personRepository;
    private final ExternalService externalService;

    public SampleService(AnotherService anotherService, PersonRepository personRepository, ExternalService externalService) {
        this.anotherService = anotherService;
        this.personRepository = personRepository;
        this.externalService = externalService;
    }

    @Transactional
    public void hello() {
        System.out.println(personRepository.findAll());
    }

    @Transactional
    public void withExternalServiceCall() {
        externalService.externalCall();
        System.out.println(personRepository.findAll());
    }

    @Transactional
    public void withExternalServiceCallAfter() {
        System.out.println(personRepository.findAll());
        externalService.externalCall();
    }

    @Transactional
    public void withNestedTransaction() {
        System.out.println(personRepository.findAll());
        anotherService.runsInNewTransaction();
    }
}
