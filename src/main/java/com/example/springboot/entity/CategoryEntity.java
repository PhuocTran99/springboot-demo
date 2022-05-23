package com.example.springboot.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "category")
public class CategoryEntity extends AbstractEntity{

    @Column(name = "code")
    private String code;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "categoryEntity")
    private List<BlogEntity> blogEntities;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<BlogEntity> getBlogEntities() {
        return blogEntities;
    }

    public void setBlogEntities(List<BlogEntity> blogEntities) {
        this.blogEntities = blogEntities;
    }
}