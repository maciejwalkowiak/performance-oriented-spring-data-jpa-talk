package com.example.connections;

import com.example.AppTestConfiguration;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.context.annotation.Import;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Import(AppTestConfiguration.class)
class SampleControllerTests {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void hello() {
        restTemplate.getForEntity("/hello", Void.class);
    }

    @Test
    void external() {
        restTemplate.getForEntity("/external", Void.class);
    }

    @Test
    void externalAfter() {
        restTemplate.getForEntity("/external-after", Void.class);
    }

    @Test
    void nested() {
        restTemplate.getForEntity("/nested", Void.class);
    }

}
