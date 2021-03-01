package ua.lviv.velykyi.vladyslav.db.service.impl;

import org.apache.log4j.Logger;
import ua.lviv.velykyi.vladyslav.db.bean.ProductsBean;
import ua.lviv.velykyi.vladyslav.db.dao.impl.ProductDAO;
import ua.lviv.velykyi.vladyslav.db.entity.Product;
import ua.lviv.velykyi.vladyslav.db.service.CategoryService;
import ua.lviv.velykyi.vladyslav.db.service.ProductService;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
                .filter(receipt -> receipt.getCategoryId() == categoryId)
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
    public int getQuantity(Product product) {
        return findByName(product.getName()).getQuantity();
    }

    @Override
    public boolean isPresent(Product product) {
        return dao.findAll().stream().anyMatch(p -> p.getName().equals(product.getName()));
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

    @Override
    public boolean delete(String name, int count) {
        List<Product> products = dao.findAll().stream()
                .filter(e -> e.getName()
                        .equals(name))
                .collect(Collectors.toList());
        if (count > products.size()) {
            return false;
        }
        for (int i = 0; i < count; i++) {
            dao.delete(products.get(i));
        }
        return true;
    }

    public List<ProductsBean> getBeanList() {
        List<Product> products = dao.findAll();
        List<ProductsBean> productsBeans = new ArrayList<>();
        CategoryService categoryService = new CategoryServiceImpl();

        for (Product p : products) {
            ProductsBean productsBean = new ProductsBean();
            productsBean.setId(p.getId());
            productsBean.setName(p.getName());
            productsBean.setPrice(p.getPrice().toString());
            productsBean.setCategory(categoryService.findById(p.getCategoryId()).getName());
            productsBean.setQuantity(String.valueOf(p.getQuantity()));
            productsBeans.add(productsBean);
        }
        return productsBeans;
    }
}
