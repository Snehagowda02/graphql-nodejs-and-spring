package com.graphqlSpring.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.graphqlSpring.demo.entities.Book;

public interface BookRepo extends JpaRepository<Book, Integer> {
    
}
