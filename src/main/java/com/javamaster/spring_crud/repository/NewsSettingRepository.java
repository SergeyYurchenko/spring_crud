package com.javamaster.spring_crud.repository;

import com.javamaster.spring_crud.model.NewsSetting;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewsSettingRepository extends JpaRepository<NewsSetting, Long> {
}
