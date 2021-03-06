package com.itrexgroup.vydrasergei.springboot.catalog.service.imp;

import com.itrexgroup.vydrasergei.springboot.catalog.domain.UserBookEntity;
import com.itrexgroup.vydrasergei.springboot.catalog.domain.UserBookPKEntity;
import com.itrexgroup.vydrasergei.springboot.catalog.repository.UserBookDao;
import com.itrexgroup.vydrasergei.springboot.catalog.service.UserBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserBookServiceImp implements UserBookService {

    private final UserBookDao userBookDao;

    @Autowired
    public UserBookServiceImp(UserBookDao userBookDao) {
        this.userBookDao = userBookDao;
    }

    @Override
    public UserBookEntity create(UserBookEntity userBookEntity) {
        return userBookDao.save(userBookEntity);
    }

    @Override
    public UserBookEntity create(Long user_id, Long book_id) {
        UserBookEntity userBookEntity = new UserBookEntity(new UserBookPKEntity(user_id, book_id));
        return create(userBookEntity);
    }

    @Override
    public UserBookEntity getByIDs(Long user_id, Long book_id) {
        return userBookDao.findByIds(user_id, book_id).get(0);
    }

    @Override
    public void delete(UserBookEntity userBookEntity) {
        userBookDao.delete(userBookEntity);
    }

    @Override
    public void delete(Long user_id, Long book_id) {
        UserBookEntity userBookEntity = new UserBookEntity(new UserBookPKEntity(user_id, book_id));
        delete(userBookEntity);
    }

    @Override
    public boolean isExist(Long user_id, Long book_id) {
        return userBookDao.findByIds(user_id, book_id).size() > 0;
    }
}
