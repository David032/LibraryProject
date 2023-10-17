package com.sparta.dk.libraryproject;

import com.sparta.dk.libraryproject.controller.AuthorController;
import com.sparta.dk.libraryproject.model.entities.Author;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class RestTests {
    private WebTestClient testClient;
    @Autowired
    private AuthorController authorController;

    @BeforeEach
    void setup() {
        testClient = WebTestClient.bindToController(authorController).build();
    }

    @Test
    @DisplayName("Testing an API Endpoint")
    void testingAnApiEndpoint() {

    }

    @Test
    void checkThatTheStatusCodeIs200() {
        testClient
                .get()
                .uri("http://localhost:8080/authors")
                .exchange()
                .expectStatus()
                .is2xxSuccessful();
    }

    @Test
    void checkThatTheFirstAuthorIsPhil() {
        testClient
                .get()
                .uri("http://localhost:8080/author/1")
                .exchange()
                .expectBody(Author.class)
                .value(author -> assertEquals("Phil", author.getFullName()));
    }
}
