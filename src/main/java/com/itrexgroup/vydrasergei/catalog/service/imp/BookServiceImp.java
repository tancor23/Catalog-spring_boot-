package com.itrexgroup.vydrasergei.catalog.service.imp;

import com.itrexgroup.vydrasergei.catalog.domain.BookEntity;
import com.itrexgroup.vydrasergei.catalog.repository.BookDao;
import com.itrexgroup.vydrasergei.catalog.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImp implements BookService {

    private final BookDao bookDao;

    @Autowired
    public BookServiceImp(BookDao bookDAO) {
        this.bookDao = bookDAO;
    }

    @Override
    public BookEntity create(BookEntity bookEntity) {
        return bookDao.save(bookEntity);
    }

    @Override
    public List<BookEntity> getAllBookEntity() {
        return bookDao.findAll();
    }

    @Override
    public BookEntity getBookEntityByID(Long id) {
        Optional<BookEntity> bookDaoById = bookDao.findById(id);
        return bookDaoById.orElseGet(BookEntity::new);
    }

    @Override
    public void delete(BookEntity bookEntity) {
        bookDao.delete(bookEntity);
    }

    @Override
    public void update(BookEntity bookEntity) {
        bookDao.save(bookEntity);
    }
}
