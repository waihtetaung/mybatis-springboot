package com.example.springbootmybatis.mapper;

import com.example.springbootmybatis.entity.Product;
import com.example.springbootmybatis.service.QueryProvider;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface ProductMapper {

    @Select("SELECT * FROM Product")
    List<Product> findAll();

    @Select("SELECT * FROM Product WHERE id = #{id}")
    Product findById(@Param("id")int id);

    @Delete("DELETE FROM Product WHERE id = #{id}")
    int deleteById(@Param("id")int id);

    @Insert("INSERT INTO Product(id, name, status) VALUES (#{id}, #{name}, #{status})")
    int saveProduct(Product item);

    @Update("UPDATE Product SET name=#{product.name}, status=#{product.status} WHERE id=#{id}")
    int updateProductById(@Param("id") int id, @Param("product") Product product);

//    @Select("SELECT p.name AS product_name, c.name AS category_name, p.status " +
//            "FROM Product p " +
//            "JOIN Category c ON p.categoryId = c.id")
//    List<Map<String, Object>> getProductsWithCategory();

    @SelectProvider(type = QueryProvider.class, method = "getProductsWithCategory")
    List<Map<String, Object>> getProductsWithCategory(@Param("status") Boolean status, @Param("categoryName") String categoryName);

}
