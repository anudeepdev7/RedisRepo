package com.example.demoredis.repo;

import com.example.demoredis.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepo {

    private static final String PRODUCT_KEY = "product";

    @Autowired
    private RedisTemplate redisTemplate;

    public Product save(Product product) {
        redisTemplate.opsForHash().put(PRODUCT_KEY, product.getId(), product);
        return product;
    }

    public List<Product> findAll() {
       return redisTemplate.opsForHash().values(PRODUCT_KEY);
    }

    public Product findById(int id) {
        return (Product) redisTemplate.opsForHash().get(PRODUCT_KEY, id);
    }

    public void deleteById(int id) {
        redisTemplate.opsForHash().delete(PRODUCT_KEY, id);
    }
}
