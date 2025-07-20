package com.graphqlSpring.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.graphqlSpring.demo.entities.Book;
import com.graphqlSpring.demo.service.BookService;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner{

	@Autowired
	private BookService bookser;
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args){
		Book b = new Book();
		b.setTitle("RCb stories");
		b.setDescription("18 years history of a cup");;
		b.setPages(18);
		b.setPrice(181818);

		Book b2 = new Book();
		b2.setTitle("CSK stories");
		b2.setDescription("@ years ban");		b2.setPages(2);
		b2.setPrice(35674);

		
		Book b3 = new Book();
		b3.setTitle("MI");
		b3.setDescription("5 fixed cups");
		b3.setPages(5);
		b3.setPrice(70000);

		this.bookser.createBook(b);
		this.bookser.createBook(b2);
		this.bookser.createBook(b3);


		}

}
