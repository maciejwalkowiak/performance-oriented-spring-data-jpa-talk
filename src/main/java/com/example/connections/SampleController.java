package com.example.connections;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {
    private final SampleService sampleService;
    private final ExternalService externalService;

    public SampleController(SampleService sampleService, ExternalService externalService) {
        this.sampleService = sampleService;
        this.externalService = externalService;
    }

    @GetMapping("/hello")
    void hello() {
        sampleService.hello();
        externalService.externalCall();
    }

    @GetMapping("/external")
    void external() {
        sampleService.withExternalServiceCall();
    }

    @GetMapping("/external-after")
    void externalAfter() {
        sampleService.withExternalServiceCallAfter();
    }

    @GetMapping("/nested")
    void nested() {
        sampleService.withNestedTransaction();
    }
}
