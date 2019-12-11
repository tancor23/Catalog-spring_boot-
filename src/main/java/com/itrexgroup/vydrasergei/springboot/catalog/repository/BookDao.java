package com.itrexgroup.vydrasergei.springboot.catalog.repository;

import com.itrexgroup.vydrasergei.springboot.catalog.domain.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookDao extends JpaRepository<BookEntity, Long> {
}