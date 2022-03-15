package com.example.book;

import java.util.ArrayList;
import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books") // uses @RequestMapping to map web request to the List<Book> books.
public class BookController {

    @Autowired
    private BookService bookservice;

    @GetMapping
    public List<Book> list() {
        return bookservice.list();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getBook(@PathVariable int id){
        Book b = bookservice.get(id);
        if(b!=null)
            return ResponseEntity.status(HttpStatus.OK).body(b);
        else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Book not Found!");
    }

}
