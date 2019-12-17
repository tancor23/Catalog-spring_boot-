package com.itrexgroup.skeleton.service;

import com.itrexgroup.skeleton.entity.UserEntity;

import java.util.List;

public interface UserService {

    UserEntity create(UserEntity user);

    List<UserEntity> getAllUserEntity();

    UserEntity readById(Long id);

    void delete(UserEntity userEntity);

    void update(UserEntity userEntity);

}
