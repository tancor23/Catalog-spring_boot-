package com.itrexgroup.skeleton.service.imp;

import com.itrexgroup.skeleton.domain.UserEntity;
import com.itrexgroup.skeleton.exception.NotFoundException;
import com.itrexgroup.skeleton.repository.UserDao;
import com.itrexgroup.skeleton.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImp implements UserService {

    private final UserDao userDao;

    @Autowired
    public UserServiceImp(UserDao userDao) {
        this.userDao = userDao;
    }

    //@Transactional
    @Override
    public UserEntity create(UserEntity userEntity) {
        return userDao.save(userEntity);
    }

    @Override
    public List<UserEntity> getAllUserEntity() {
        return userDao.findAll();
    }

    @Override
    public UserEntity readById(Long id) {
        return userDao.findById(id).orElseThrow(NotFoundException::new);
    }

    @Transactional
    @Override
    public void delete(UserEntity userEntity) {
        userEntity.setStatus("stopped");
        userDao.save(userEntity);
    }

    @Transactional
    @Override
    public void update(UserEntity userEntity) {
        userDao.save(userEntity);
    }
}
