package com.example.book;

import java.util.ArrayList;
import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookService bookservice;

    @GetMapping
    public List<Book> list() {
        return bookservice.list();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getBook(@PathVariable int id) {
        Book b = bookservice.get(id);
        if (b != null)
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(b);
        else
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("Book not found!");
    }

    @PostMapping
    public void create(@RequestBody Book book) {
        bookservice.create(book);
    }

    @PutMapping
    public void update(@RequestBody Book book) {
        bookservice.update(book);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        bookservice.delete(id);
    }
}
