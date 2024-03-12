package com.example.deploydocker.Controller;

import com.example.deploydocker.Model.Book;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class HelloWorldController {

    @GetMapping("/api/hello")
    public String hello() {
        return "Hello from Spring Boot!";
    }

    @GetMapping("/api/books")
    public List<Book> getBooks() {
        List<Book> books = new ArrayList<>();
        books.add(new Book(1, "Book 1", "Author 1"));
        books.add(new Book(2, "Book 2", "Author 2"));
        books.add(new Book(3, "Book 3", "Author 3"));
        return books;
    }

    @GetMapping("/api/books/{id}")
    public Book getBookById(@PathVariable int id) {
        // Assuming we have a list of books with known IDs
        List<Book> books = Arrays.asList(
                new Book(1, "Book 1", "Author 1"),
                new Book(2, "Book 2", "Author 2"),
                new Book(3, "Book 3", "Author 3")
        );

        // Find the book with the given ID
        return books.stream()
                .filter(book -> book.getId() == id)
                .findFirst()
                .orElse(null); // Return null if not found
    }
}