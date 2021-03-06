package com.itrexgroup.vydrasergei.springboot.catalog.service;

import com.itrexgroup.vydrasergei.springboot.catalog.domain.BookEntity;

import java.util.List;

public interface BookService {

    BookEntity create(BookEntity bookEntity);

    List<BookEntity> getAllBookEntity();

    BookEntity getBookEntityByID(Long id);

    void delete(BookEntity bookEntity);

    void update(BookEntity bookEntity);
}
