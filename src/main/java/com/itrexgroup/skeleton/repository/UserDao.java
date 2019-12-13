package com.itrexgroup.skeleton.repository;

import com.itrexgroup.skeleton.domain.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<UserEntity, Long> {
}