package com.graphqlSpring.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;
// import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;

import com.graphqlSpring.demo.entities.Book;
import com.graphqlSpring.demo.service.BookService;

import lombok.Data;

// @RestController
@Controller
@RequestMapping("/api")
public class BookController {
    @Autowired
    private BookService bookser;
    

    //getbyid

    // @GetMapping("/books/{bookId}")
    // @SchemaMapping // used for query, mutation, subscription as well
    @QueryMapping
     //instead of @RequestBody we should use @Argument
    public Book getByIdBook(@Argument Integer id){
    return bookser.getBookbyId(id);
    }

    // //getall
    // @GetMapping("/books")
    @QueryMapping("allBooks")
        public List<Book> findAll(){
            return bookser.getAll();
        }

    //create
    // @PostMapping("/create")
    @MutationMapping
    public Book createbook(@Argument BookInput book){
        Book b = new Book();
        b.setTitle(book.getTitle());
        b.setDescription(book.getDescription());
        b.setPages(book.getPages());
        b.setPrice(book.getPrice());
        return bookser.createBook(b);
    }

    
}

  @Data
 class BookInput{
        private String title;
        private String description;
        private double price;
        private int pages;
        

    }
