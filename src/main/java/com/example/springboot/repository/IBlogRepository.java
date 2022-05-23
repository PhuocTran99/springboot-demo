package com.example.springboot.repository;

import com.example.springboot.entity.BlogEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBlogRepository extends JpaRepository<BlogEntity, Long> {
}
