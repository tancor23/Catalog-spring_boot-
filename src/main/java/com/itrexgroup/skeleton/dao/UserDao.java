package com.itrexgroup.skeleton.dao;

import com.itrexgroup.skeleton.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<UserEntity, Long> {
}