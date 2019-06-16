package com.alpha.service.impl;

import com.alpha.mapper.CategoryMapper;
import com.alpha.pojo.Category;
import com.alpha.service.CategoryService;
import com.alpha.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryMapper categoryMapper;
    @Override
    public List<Category> list() {
        System.out.println("------------------->");
        System.out.println(categoryMapper);
        return categoryMapper.list();
    }

    @Override
    public void add(Category c) {
        categoryMapper.add(c);
    }

    @Override
    public void delete(Category c) {
        categoryMapper.delete(c.getId());

    }

    @Override
    public Category get(int id) {
        return categoryMapper.get(id);
    }

    @Override
    public void update(Category c) {
        categoryMapper.update(c);
    }



    @Override
    public int total() {
        return categoryMapper.total();
    }

    @Override
    public List<Category> list(Page page) {
        return categoryMapper.list(page);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,rollbackForClassName = "Exception")
    public void addTwo() {
        Category c1=new Category();
        c1.setName("short name");
        categoryMapper.add(c1);

        Category c2=new Category();
        c2.setName("123456789012345678901234567890_long name");
        categoryMapper.add(c2);
    }

    @Override
    public void deleteAll() {

        List<Category> cs=list();
        cs.forEach(c->{
            categoryMapper.delete(c.getId());
        });
    }
}
