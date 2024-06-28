package com.test.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Story {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int storyId;

    @Column(name = "story_name")
    private String storyName;

}
