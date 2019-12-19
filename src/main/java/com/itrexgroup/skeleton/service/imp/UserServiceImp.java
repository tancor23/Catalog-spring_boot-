package com.itrexgroup.skeleton.service.imp;

import com.itrexgroup.skeleton.entity.UserEntity;
import com.itrexgroup.skeleton.exception.UserNotFoundException;
import com.itrexgroup.skeleton.dao.UserDao;
import com.itrexgroup.skeleton.exception.UserNotUniqueLoginException;
import com.itrexgroup.skeleton.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

    private final UserDao userDao;

    @Autowired
    public UserServiceImp(UserDao userDao) {
        this.userDao = userDao;
    }

    @Transactional
    @Override
    public UserEntity create(UserEntity userEntity) {
        UserEntity userEntityByLogin = userDao.findUserEntityByLogin(userEntity.getLogin());
        if(userEntityByLogin!=null){
            throw new UserNotUniqueLoginException(userEntityByLogin.getLogin());
        }
        return userDao.save(userEntity);
    }

    @Override
    public List<UserEntity> getAllUserEntity() {
        return userDao.findAll();
    }

    @Override
    public UserEntity readById(Long id) {
        return userDao.findById(id).orElseThrow(() -> new UserNotFoundException(id));
    }

    @Transactional
    @Override
    public void delete(UserEntity userEntity) {
        userEntity.setStatus("stopped");
        userDao.save(userEntity);
    }

    @Transactional
    @Override
    public UserEntity update(UserEntity userEntity) {
        UserEntity userEntityByLogin = userDao.findUserEntityByLogin(userEntity.getLogin());
        if(userEntityByLogin!=null){
            throw new UserNotUniqueLoginException(userEntityByLogin.getLogin());
        }
        userDao.save(userEntity);
        return userEntity;
    }
}
