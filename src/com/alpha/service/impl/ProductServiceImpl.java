package com.alpha.service.impl;

import com.alpha.mapper.ProductMapper;
import com.alpha.pojo.Product;
import com.alpha.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductMapper productMapper;

    @Override
    public List<Product> list() {
        return productMapper.list();
    }

    @Override
    public void add(Product product) {
        productMapper.add(product);
    }

    @Override
    public void delete(int id) {
        productMapper.delete(id);
    }

    @Override
    public Product get(int id) {
        Product product=productMapper.get(id);
        return product;
    }

    @Override
    public void update(Product product) {
        productMapper.update(product);
    }
}
