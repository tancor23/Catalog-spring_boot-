package com.itrexgroup.vydrasergei.catalog.service.imp;

import com.itrexgroup.vydrasergei.catalog.domain.UserEntity;
import com.itrexgroup.vydrasergei.catalog.repository.UserDao;
import com.itrexgroup.vydrasergei.catalog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImp implements UserService{

    private final UserDao userDao;

    @Autowired
    public UserServiceImp(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public UserEntity create(UserEntity userEntity) {
        return userDao.save(userEntity);
    }

    @Override
    public List<UserEntity> getAllUserEntity() {
        return userDao.findAll();
    }

    @Override
    public UserEntity getUserEntityByID(Long id) {
        Optional<UserEntity> userDaoById = userDao.findById(id);
        return userDaoById.orElseGet(UserEntity::new);
    }

    @Override
    public void delete(UserEntity userEntity) {
        userDao.delete(userEntity);
    }

    @Override
    public void update(UserEntity userEntity) {
        userDao.save(userEntity);
    }
}
