package com.sparta.dk.libraryproject;

import com.sparta.dk.libraryproject.model.repositories.AuthorRepository;
import com.sparta.dk.libraryproject.model.repositories.BookRepository;
import com.sparta.dk.libraryproject.service.LibraryService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class LibraryProjectApplicationTests {

    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private LibraryService libraryService;

    @Test
    @DisplayName("Check that there are 4 authors")
    void checkForFiveAuthors() {
        assertEquals(5,authorRepository.findAll().size());
    }

    @Test
    @DisplayName("Check there is an author called Manish")
    void checkThereIsAnAuthorCalledManish() {
        authorRepository.findAuthorsByFullName("Manish")
                .forEach(author-> assertTrue(author.getFullName().equals("Manish")) );
    }
    


}
