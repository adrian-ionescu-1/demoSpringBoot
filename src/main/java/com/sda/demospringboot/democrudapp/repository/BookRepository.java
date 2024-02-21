package com.sda.demospringboot.democrudapp.repository;

import com.sda.demospringboot.democrudapp.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository // reprezinta o interfata care gestioneaza entitatea (book) pt a stoca si a manipula date prin CRUD in DB
// Spring data ne permite sa definim modalitati prin care putem sa executam un query de SQL:
// 1. folosind sintaxa de JPQL prin utilizarea adnotarii @Query
// 2. Query native prin utilizarea adnotarii @Query -> diferenta fiind prin setarea atributului boolean "nativeQuery" la valoarea true
public interface BookRepository extends JpaRepository<Book, Long> {
    // putem sa ne definim operatii CRUD custom

//    find all books by author
    List<Book> searchBookByAuthor(String author);
    List<Book> searchBookByAuthorAndPrice(String name, double price);
    List<Book> searchBookByName(String name);
    List<Book> searchBookByIsbn(String isbn);
}
