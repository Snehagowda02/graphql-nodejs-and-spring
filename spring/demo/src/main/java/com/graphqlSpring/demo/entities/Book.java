package com.graphqlSpring.demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

// public record Book(int id, String title, String desc, double price, int pages) {
    
// }


@Entity
@Table(name= "project_books")
@Data
public class Book{

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    private String title;
    private String description;
    private double price;
    private int pages;
}
