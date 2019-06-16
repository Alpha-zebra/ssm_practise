package com.alpha.mapper;

import com.alpha.pojo.Product;

import java.util.List;

public interface ProductMapper {
    List<Product> list();

    void add(Product product);

    void delete(int id);

    Product get(int id);

    void update(Product product);
}
