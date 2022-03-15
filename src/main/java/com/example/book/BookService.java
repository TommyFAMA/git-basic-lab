package com.example.book;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class BookService {
   private List<Book> books;

   public BookService() {
        System.out.println("BookService() called...");
        books = new ArrayList<>();
        books.add(new Book(1,"Hacking with Spring Boot 2.3","Greg L. Turnquist"));
        books.add(new Book(2,"97 Things Every Java Programmer Should Know", "Kevlin Henney and Trisha Gee"));
        books.add(new Book(3,"Spring Boot: Up and Running","Greg L. Turnquist "));
   }

   public List<Book> list() {
      return books;
   }

   public Book get(int id) {
        for (Book i: books){
            if (i.getBookid()==id)
                return i;
        }
        return null; //book not found
   }
 }
