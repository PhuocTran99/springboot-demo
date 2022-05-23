package com.example.springboot.service.impl;


import com.example.springboot.converter.BlogConverter;
import com.example.springboot.dto.BlogDTO;
import com.example.springboot.entity.BlogEntity;
import com.example.springboot.repository.IBlogRepository;
import com.example.springboot.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BlogService implements IBlogService {

    @Autowired
    private BlogConverter blogConverter;

    @Autowired
    private IBlogRepository blogRepository;

    @Override
    public BlogDTO save(BlogDTO blogDTO) {
        return blogConverter.toDTO(blogRepository.save(blogConverter.toEntity(blogDTO)));
    }

    @Override
    public void delete(long[] ids) {
        for (long id : ids) {
            blogRepository.delete(id);
        }
    }

    @Override
    public List<BlogDTO> findAll(Pageable pageable) {
        List<BlogDTO> result = new ArrayList<>();
        List<BlogEntity> entities = blogRepository.findAll(pageable).getContent();
        for (BlogEntity entity : entities) {
            result.add(blogConverter.toDTO(entity));
        }
        return null;
    }

    @Override
    public int totalItem() {
        return (int) blogRepository.count();
    }
}
