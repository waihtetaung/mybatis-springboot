package com.example.springbootmybatis.service;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;

public class QueryProvider {

    public String getProductsWithCategory(@Param("status") Boolean status, @Param("categoryName") String categoryName) {
        SQL sql = new SQL() {{
            SELECT("p.name AS product_name, c.name AS category_name, p.status");
            FROM("Product p");
            JOIN("Category c ON p.category_id = c.id");
            if (status != null) {
                WHERE("p.status = #{status}");
            }
            if (categoryName != null && !categoryName.isEmpty()) {
                WHERE("c.name = #{category_name}");
            }
        }};
        return sql.toString();
    }
}
