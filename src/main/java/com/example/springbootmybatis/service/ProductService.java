package com.example.springbootmybatis.service;

import com.example.springbootmybatis.entity.Product;

import java.util.List;
import java.util.Map;

public interface ProductService {

    List<Product> findAll();
    Product findById(int id);
    int deleteById(int id);
    int saveProduct(Product item);
    int updateProductById(int id, Product item);
    List<Map<String, Object>> getProductsWithCategory(Boolean status, String categoryName);

}
