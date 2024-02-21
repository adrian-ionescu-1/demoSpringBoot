package com.sda.demospringboot.democrudapp.service;

import com.sda.demospringboot.democrudapp.model.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {
    // HTTP verbs:  GET, POST, PUT, DELETE, PATCH
    // GET -> READ
    // POST -> CREATE
    // PUT/PATCH -> UPDATE
    // DELETE -> DELETE

    // this methods will call the default CRUD impl defined in CrudRepositoryInterface

    // READ all books from DB -> GET HTTP endpoint
    List<Book> readAllBooks();
    // READ data for a book by id ->GET (by id) HTTP endpoint
    Optional<Book> getBookById(Long id);
    // CREATE new book and save it to DB -> POST HTTP endpoint
    Book saveBook(Book book);
    // DELETE book by id -> DELETE (by id) HTTP endpoint
    void deleteBookById(Long id);
    // UPDATE a book -> PUT HTTP endpoint
    Book updateBook(Book book);
    // Custom CRUD methods defined
    List<Book> getAllBooksByName(String name);
    List<Book> getAllBooksByIsbn(String isbn);
}
