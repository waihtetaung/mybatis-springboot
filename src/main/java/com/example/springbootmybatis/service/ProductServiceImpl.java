package com.example.springbootmybatis.service;

import com.example.springbootmybatis.entity.Product;
import com.example.springbootmybatis.mapper.ProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{

    private final ProductMapper mapper;

    @Override
    public List<Product> findAll() {
        return mapper.findAll();
    }

    @Override
    public Product findById(int id) {
        return mapper.findById(id);
    }

    @Override
    public int deleteById(int id) {
        return mapper.deleteById(id);
    }

    @Override
    public int saveProduct(Product item) {
        return mapper.saveProduct(item);
    }

    @Override
    public int updateProductById(int id, Product item) {
        return mapper.updateProductById(id, item);
    }

    @Override
    public List<Map<String, Object>> getProductsWithCategory(Boolean status, String categoryName) {
        return mapper.getProductsWithCategory(status, categoryName);
    }


}
