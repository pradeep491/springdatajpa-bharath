package com.test.service.impl;

import com.test.BookRepository;
import com.test.entities.Book;
import com.test.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository bookRepository;

    public Book saveBook(Book book) {
        book = bookRepository.save(book);
        return book;

    }

    public Book findByBookId(int bookId) {
        Book book = bookRepository.findByBookId(bookId);
        return book;
    }
}
