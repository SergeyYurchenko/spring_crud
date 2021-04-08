package com.javamaster.spring_crud.repository;

import com.javamaster.spring_crud.model.News;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewsRepository extends JpaRepository<News,Long> {
}
