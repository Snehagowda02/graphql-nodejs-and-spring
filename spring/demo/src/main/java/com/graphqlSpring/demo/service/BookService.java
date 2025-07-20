package com.graphqlSpring.demo.service;

import java.util.List;

import com.graphqlSpring.demo.entities.Book;

public interface BookService {

    Book getBookbyId(Integer bookID);

    Book createBook(Book book);

    List<Book> getAll();
}
