package com.sparta.dk.libraryproject.service;

import com.sparta.dk.libraryproject.model.entities.Author;
import com.sparta.dk.libraryproject.model.entities.Book;
import com.sparta.dk.libraryproject.model.repositories.AuthorRepository;
import com.sparta.dk.libraryproject.model.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LibraryService {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    @Autowired
    public LibraryService(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    public List<Author> findAuthorsWithMoreThanOneBook() {
        ArrayList<Author> popularAuthors = new ArrayList<>();
        for (Author author: authorRepository.findAll()) {
            if (author.getBookSet().size() > 1) {
                popularAuthors.add(author);
            }
        }
        return popularAuthors;
    }

    public List<Book> findAutobiographies() {
        ArrayList<Book> autoBiographies = new ArrayList<>();
        for (Book book:bookRepository.findAll()) {
            if (book.getTitle().contains(book.getAuthor().getFullName())) {
                autoBiographies.add(book);
            }
        }
        return  autoBiographies;
    }
}
