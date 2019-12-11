package com.itrexgroup.vydrasergei.springboot.catalog.domain;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
@Entity
@Table(name = "books", schema = "catalog_mysql")
public class BookEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private long id = -1;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "author", nullable = false)
    private String author;

    @Column(name = "page")
    private int page;

    @ManyToMany(mappedBy = "books", fetch = FetchType.LAZY)
    private List<UserEntity> users;

    public BookEntity(String name, String author) {
        this.name = name;
        this.author = author;
    }

    public BookEntity(String name, String author, int page) {
        this.name = name;
        this.author = author;
        this.page = page;
    }

    public BookEntity(Long id, String name, String author) {
        this.id = id;
        this.name = name;
        this.author = author;
    }
}

