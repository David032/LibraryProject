package com.sparta.dk.libraryproject.exceptions;

public class AuthorNotFoundException extends Exception {
    public AuthorNotFoundException(String name) {
        super("Could not find author " + name);
    }
}
