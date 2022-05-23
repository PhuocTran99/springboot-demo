package com.example.springboot.service;

import com.example.springboot.dto.BlogDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {
    BlogDTO save(BlogDTO blogDTO);
    void delete(long[] ids);
    List<BlogDTO> findAll(Pageable pageable);
    int totalItem();
}
