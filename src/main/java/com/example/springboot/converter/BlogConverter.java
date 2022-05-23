package com.example.springboot.converter;


import com.example.springboot.dto.BlogDTO;
import com.example.springboot.entity.BlogEntity;
import com.example.springboot.repository.IBlogRepository;
import com.example.springboot.repository.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BlogConverter {

    @Autowired
    private IBlogRepository blogRepository;

    @Autowired
    private ICategoryRepository categoryRepository;

    public BlogDTO toDTO(BlogEntity blogEntity) {
        BlogDTO blogDTO = new BlogDTO();
        blogDTO.setId(blogEntity.getId());
        blogDTO.setTitle(blogEntity.getTitle());
        blogDTO.setThumbnail(blogEntity.getThumbnail());
        blogDTO.setShortDescription(blogEntity.getShortDescription());
        blogDTO.setContent(blogEntity.getContent());
        blogDTO.setCategoryId(blogEntity.getCategoryEntity().getId());
        blogDTO.setCreatedDate(blogEntity.getCreatedDate());
        blogDTO.setCreatedBy(blogEntity.getCreatedBy());
        blogDTO.setModifiedDate(blogEntity.getModifiedDate());
        blogDTO.setModifiedBy(blogEntity.getModifiedBy());
        return blogDTO;
    }

    public BlogEntity toEntity(BlogDTO blogDTO) {
        BlogEntity blogEntity = new BlogEntity();
        if (blogDTO.getId() != 0) {
            blogEntity.setId(blogDTO.getId());
            blogEntity.setCreatedDate(blogRepository.findOne(blogDTO.getId()).getCreatedDate());
        }
        blogEntity.setTitle(blogDTO.getTitle());
        blogEntity.setThumbnail(blogDTO.getThumbnail());
        blogEntity.setShortDescription(blogDTO.getShortDescription());
        blogEntity.setContent(blogDTO.getContent());
        blogEntity.setCategoryEntity(categoryRepository.findOne(blogDTO.getCategoryId()));
        return blogEntity;
    }
}
