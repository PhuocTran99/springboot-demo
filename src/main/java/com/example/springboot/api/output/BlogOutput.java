package com.example.springboot.api.output;

import com.example.springboot.dto.BlogDTO;

import java.util.List;

public class BlogOutput {
    private int page;
    private int totalPage;
    private List<BlogDTO> listDTO;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public List<BlogDTO> getListDTO() {
        return listDTO;
    }

    public void setListDTO(List<BlogDTO> listDTO) {
        this.listDTO = listDTO;
    }
}
