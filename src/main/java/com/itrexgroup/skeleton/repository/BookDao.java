package com.itrexgroup.skeleton.repository;

import com.itrexgroup.skeleton.domain.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookDao extends JpaRepository<BookEntity, Long> {
}