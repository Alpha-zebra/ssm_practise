package com.alpha.service;

import com.alpha.pojo.Category;
import com.alpha.util.Page;

import java.util.List;

public interface CategoryService {
    List<Category> list();

    void add(Category c);

    void delete(Category c);

    Category get(int id);

    void update(Category c);
    int total();
    List<Category> list(Page page);

    void addTwo();
    void deleteAll();
}
