package com.sparta.dk.libraryproject.controller;

import com.sparta.dk.libraryproject.model.entities.Author;
import com.sparta.dk.libraryproject.model.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static java.lang.Boolean.*;

@RestController
public class AuthorController {
    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @GetMapping("/author/{id}")
    public Optional<Author> getAuthorById(@PathVariable int id) {
        return authorRepository.findById(id);
    }

    @GetMapping("/authors")
    public List<Author> getAuthors(@RequestParam(name = "name", required = false) String name) {

        return name != null ? authorRepository.findAuthorsByFullName(name) : authorRepository.findAll();
    }

    @PatchMapping("/author/{id}")
    public Author SaveAuthor(@RequestBody Author newAuthor, @PathVariable int id) {
        Author author = authorRepository.findById(id).get();
        author.setFullName(newAuthor.getFullName());
        return authorRepository.save(author);
    }

    @DeleteMapping("/author/{id}")
    public boolean DeleteAuthor(@PathVariable int id) {
        authorRepository.delete(authorRepository.findById(id).get());
        return authorRepository.findById(id).isEmpty() ? TRUE : FALSE;
    }

    @PutMapping("/author")
    public Author AddAuthor(@RequestBody Author newAuthor) {
        return authorRepository.save(newAuthor);
    }
}
