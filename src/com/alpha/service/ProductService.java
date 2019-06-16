package com.alpha.service;

import com.alpha.pojo.Product;

import java.util.List;

public interface ProductService {

    List<Product> list();

    void add(Product product);

    void delete(int id);

    Product get(int id);

    void update(Product product);
}
