package com.itrexgroup.skeleton.repository;

import com.itrexgroup.skeleton.domain.UserBookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserBookDao extends JpaRepository<UserBookEntity, Long> {

    @Query("select ub from UserBookEntity ub where ub.userBookPKEntity.userId = :userId and ub.userBookPKEntity.bookId = :bookId")
    List<UserBookEntity> findByIds(@Param("userId") Long userId, @Param("bookId") Long bookId);


}