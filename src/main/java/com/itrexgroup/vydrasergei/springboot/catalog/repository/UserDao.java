package com.itrexgroup.vydrasergei.springboot.catalog.repository;

import com.itrexgroup.vydrasergei.springboot.catalog.domain.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<UserEntity, Long> {
}