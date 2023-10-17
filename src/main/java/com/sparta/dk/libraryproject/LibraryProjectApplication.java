package com.sparta.dk.libraryproject;

import com.sparta.dk.libraryproject.model.repositories.AuthorRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

@SpringBootApplication
public class LibraryProjectApplication {

    Logger logger = Logger.getLogger("my-logger");
    public static void main(String[] args) {
        SpringApplication.run(LibraryProjectApplication.class, args);
    }

    @Bean
    public CommandLineRunner runner (AuthorRepository authorRepository) {
        return args -> {
            logger.log(Level.INFO, authorRepository.findAll().get(0).toString());
            logger.log(Level.INFO, authorRepository.findById(1)
                    .get()
                    .getBookSet()
                    .toString());
        };
    }

}
