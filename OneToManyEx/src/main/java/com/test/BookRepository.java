package com.test;

import com.test.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Long> {
    public Book findByBookId(int bookId);
}
