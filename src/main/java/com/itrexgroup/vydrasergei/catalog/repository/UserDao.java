package com.itrexgroup.vydrasergei.catalog.repository;

import com.itrexgroup.vydrasergei.catalog.domain.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<UserEntity, Long> {
}