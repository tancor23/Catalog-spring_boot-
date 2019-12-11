package com.itrexgroup.vydrasergei.springboot.catalog.service;

import com.itrexgroup.vydrasergei.springboot.catalog.domain.UserBookEntity;

public interface UserBookService {

    UserBookEntity create(UserBookEntity user);

    UserBookEntity create(Long user_id, Long book_id);

    UserBookEntity getByIDs(Long user_id, Long book_id);

    void delete(UserBookEntity userBookEntity);

    void delete(Long user_id, Long book_id);

    boolean isExist(Long user_id, Long book_id);
}
