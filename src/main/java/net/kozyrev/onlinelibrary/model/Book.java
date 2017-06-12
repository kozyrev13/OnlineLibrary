package net.kozyrev.onlinelibrary.model;

import javax.persistence.*;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String title;

    @Column
    private String author;

    @Column
    private Integer pages;

    @Column
    private Integer year;

    @Column
    private Integer quantity;
}
