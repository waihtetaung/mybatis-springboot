package com.example.springbootmybatis.controller;

import com.example.springbootmybatis.entity.Product;
import com.example.springbootmybatis.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class ProductController {

    private final ProductService productService;

    @GetMapping
    List<Product> findAll(){
        return productService.findAll();
    }

    @GetMapping("/{id}")
    Product findById(@PathVariable("id")int id){
        return productService.findById(id);
    }

    @DeleteMapping("/{id}")
    public int deleteById(@PathVariable("id") int id){
        return productService.deleteById(id);
    }

    @PostMapping
    public int saveProduct(@RequestBody Product item){
        return productService.saveProduct(item);
    }

    @PutMapping("/{id}")
    public int updateProduct(@PathVariable("id") int id,@RequestBody Product item){
        return productService.updateProductById(id, item);
    }

    @GetMapping("/filter")
    public ResponseEntity<List<Map<String, Object>>> getProductWithCategory(
            @RequestParam(required = false) Boolean status,
            @RequestParam(required = false) String categoryName) {
        List<Map<String, Object>> filteredProducts = productService.getProductsWithCategory(status, categoryName);
        if (filteredProducts.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(filteredProducts, HttpStatus.OK);
    }
}
