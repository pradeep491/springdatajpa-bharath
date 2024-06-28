package com.test.service;

import com.test.entities.Book;
import org.springframework.stereotype.Component;

@Component
public interface BookService {
    public Book saveBook(Book book);
    public Book findByBookId(int bookId);
}
