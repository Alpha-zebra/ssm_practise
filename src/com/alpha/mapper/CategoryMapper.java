package com.alpha.mapper;

import com.alpha.pojo.Category;
import com.alpha.util.Page;

import java.util.List;

public interface CategoryMapper {
    public int add(Category category);
    public void delete(int id);
    public Category get(int id);
    public  int update(Category category);
    public List<Category> list();
    public List<Category> list(Page page);
    public int total();
    public int count();
}
