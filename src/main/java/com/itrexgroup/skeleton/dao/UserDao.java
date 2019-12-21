package com.itrexgroup.skeleton.dao;

import com.itrexgroup.skeleton.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao extends JpaRepository<UserEntity, Long> {

    @Query("select e from UserEntity e where e.login =:login")
    List<UserEntity> findByLogin(@Param("login") String login);
}