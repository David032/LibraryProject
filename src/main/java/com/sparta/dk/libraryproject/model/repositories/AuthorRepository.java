package com.sparta.dk.libraryproject.model.repositories;

import com.sparta.dk.libraryproject.model.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {
    List<Author> findAuthorsByFullName(String name);
    List<Author> findAuthorsByFullNameStartingWith(String letter);

    Optional<Author> findAuthorByFullName(String fullName);
}