package com.graphqlSpring.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.graphqlSpring.demo.entities.Book;
import com.graphqlSpring.demo.repo.BookRepo;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepo bookrep;

    @Override
    public Book getBookbyId(Integer bookID) {
        // Optional<Book> optional =  bookrep.findById(bookID);
        // return optional.get();
        return bookrep.findById(bookID).orElseThrow( () -> new RuntimeException("book id not foumg"));
    }

    @Override
    public Book createBook(Book book) {
        return bookrep.save(book);
    }

    @Override
    public List<Book> getAll() {
        return bookrep.findAll();
    }
    
}
