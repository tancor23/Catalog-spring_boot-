package com.itrexgroup.vydrasergei.springboot.catalog.service;

import com.itrexgroup.vydrasergei.springboot.catalog.domain.UserEntity;

import java.util.List;

public interface UserService {

    UserEntity create(UserEntity user);

    List<UserEntity> getAllUserEntity();

    UserEntity getUserEntityByID(Long id);

    void delete(UserEntity userEntity);

    void update(UserEntity userEntity);

}
