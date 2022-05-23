package com.example.springboot.converter;

import com.example.springboot.dto.CategoryDTO;
import com.example.springboot.entity.CategoryEntity;
import org.springframework.stereotype.Component;

@Component
public class CategoryConverter {

    public CategoryDTO toDTO(CategoryEntity categoryEntity) {
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setId(categoryEntity.getId());
        categoryDTO.setCode(categoryEntity.getCode());
        categoryDTO.setName(categoryDTO.getName());
        return categoryDTO;
    }
}
