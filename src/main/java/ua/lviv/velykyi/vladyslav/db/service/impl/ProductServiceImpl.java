package ua.lviv.velykyi.vladyslav.db.service.impl;

import org.apache.log4j.Logger;
import ua.lviv.velykyi.vladyslav.db.dao.impl.ProductDAO;
import ua.lviv.velykyi.vladyslav.db.entity.Product;
import ua.lviv.velykyi.vladyslav.db.service.ProductService;

import java.math.BigDecimal;
import java.util.List;

public class ProductServiceImpl implements ProductService {
    private static final Logger log = Logger.getLogger(EmployeeServiceImpl.class);
    private ProductDAO dao;

    public ProductServiceImpl() {
        dao = new ProductDAO();
    }

    @Override
    public List<Product> findAll() {
        return dao.findAll();
    }

    @Override
    public Product findById(Long id) {
        return dao.findAll()
                .stream()
                .filter(receipt -> receipt.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Product findByCategoryId(Long categoryId) {
        return dao.findAll()
                .stream()
                .filter(receipt -> receipt.getCategoryId()==categoryId)
                .findFirst()
                .orElse(null);
    }

    @Override
    public Product findByPrice(BigDecimal price) {
        return dao.findAll()
                .stream()
                .filter(receipt -> receipt.getPrice().equals(price))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Product findByName(String name) {
        return dao.findAll()
                .stream()
                .filter(receipt -> receipt.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void update(Product product) {
        dao.update(product);
    }

    @Override
    public void insert(Product product) {
        dao.insert(product);
    }

    @Override
    public void delete(Product product) {
        dao.delete(product);
    }


}
