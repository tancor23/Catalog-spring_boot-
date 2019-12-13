package com.itrexgroup.vydrasergei.catalog.repository;

import com.itrexgroup.vydrasergei.catalog.domain.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookDao extends JpaRepository<BookEntity, Long> {
}