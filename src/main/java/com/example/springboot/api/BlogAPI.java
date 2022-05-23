package com.example.springboot.api;

import com.example.springboot.api.output.BlogOutput;
import com.example.springboot.dto.BlogDTO;
import com.example.springboot.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
public class BlogAPI {

    @Autowired
    private IBlogService blogService;

    // Showing data and Pagination
    @GetMapping("/api-blog")
    public BlogOutput showBlog(@RequestParam(value = "page") int page,
                               @RequestParam(value = "limit") int limit) {
        BlogOutput blogOutput = new BlogOutput();
        blogOutput.setPage(page);
        Pageable pageable = new PageRequest(page - 1, limit);
        blogOutput.setListDTO(blogService.findAll(pageable));
        blogOutput.setTotalPage((int) Math.ceil((double) blogService.totalItem() / limit));
        return blogOutput;
    }

    @PostMapping("/api-blog")
    public BlogDTO createBlog(@RequestBody BlogDTO blogDTO) {
        return blogService.save(blogDTO);
    }

    @PutMapping("/api-blog")
    public BlogDTO updateBlog(@RequestBody BlogDTO blogDTO) {
        return blogService.save(blogDTO);
    }

    @DeleteMapping("/api-blog")
    public void deleteBlog(@RequestBody long[] ids) {
        blogService.delete(ids);
    }
}