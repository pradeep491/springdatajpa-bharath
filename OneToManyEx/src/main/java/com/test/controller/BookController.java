package com.test.controller;

import com.test.entities.Book;
import com.test.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookService bookService;

    @PostMapping("/savebook")
    public Book saveBook(@RequestBody Book book) {
        Book bookResponse = bookService.saveBook(book);
        return bookResponse;
    }
    @GetMapping("/{bookId}")
    public Book getBookDetails(@PathVariable int bookId) {
        Book bookResponse = bookService.findByBookId(bookId);

        return bookResponse;
    }
}
