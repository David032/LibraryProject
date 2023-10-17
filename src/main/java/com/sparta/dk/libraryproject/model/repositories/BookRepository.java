package com.sparta.dk.libraryproject.model.repositories;

import com.sparta.dk.libraryproject.model.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
}