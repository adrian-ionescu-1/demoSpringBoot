package com.sda.demospringboot.democrudapp.service.impl;

import com.sda.demospringboot.democrudapp.model.Book;
import com.sda.demospringboot.democrudapp.repository.BookRepository;
import com.sda.demospringboot.democrudapp.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {
    // Apply dependency injection through constructor (or using @RequiredArgsConstruction annotation by making all the fields/objects FINAL) / setter
    // DI through constructor
    private BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> readAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Optional<Book> getBookById(Long id) {
        return bookRepository.findById(id);
    }

    @Override
    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public void deleteBookById(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public Book updateBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public List<Book> getAllBooksByName(String name) {
        return bookRepository.searchBookByName(name);
    }

    @Override
    public List<Book> getAllBooksByIsbn(String isbn) {
        return bookRepository.searchBookByIsbn(isbn);
    }
}
