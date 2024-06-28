package com.test.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter

public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookId;

    @Column(name = "book_name")
    private String bookName;

    @OneToMany(cascade = CascadeType.ALL, fetch= FetchType.LAZY)
    @JoinColumn(name = "book_id",referencedColumnName="bookId")
    private List<Story> storyList = new ArrayList<>();
}
