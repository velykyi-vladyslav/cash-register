package ua.lviv.velykyi.vladyslav.db.service;

import ua.lviv.velykyi.vladyslav.db.entity.Product;

import java.math.BigDecimal;
import java.util.List;

public interface ProductService {
    List<Product> findAll();
    Product findById(Long id);
    Product findByCategoryId(Long categoryId);
    Product findByPrice(BigDecimal price);
    Product findByName(String name);
    void update(Product product);
    void insert(Product product);
    void delete(Product product);
}
