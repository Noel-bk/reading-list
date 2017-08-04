package com.noel.readinglist.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class Book {

    @Id
    @GeneratedValue
    private Long id;

    private String reader;

    private String isbn;

    private String title;

    private String author;

    private String description;

}
