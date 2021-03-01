package ua.lviv.velykyi.vladyslav.db.service.impl;


import org.apache.log4j.Logger;
import ua.lviv.velykyi.vladyslav.db.bean.CategoryBean;
import ua.lviv.velykyi.vladyslav.db.bean.EmployeeBean;
import ua.lviv.velykyi.vladyslav.db.dao.impl.CategoryDAO;
import ua.lviv.velykyi.vladyslav.db.entity.Category;
import ua.lviv.velykyi.vladyslav.db.entity.Employee;
import ua.lviv.velykyi.vladyslav.db.service.CategoryService;

import java.util.ArrayList;
import java.util.List;

public class CategoryServiceImpl implements CategoryService {
    private static final Logger log = Logger.getLogger(CategoryServiceImpl.class);
    private CategoryDAO dao;

    public CategoryServiceImpl() {
        dao = new CategoryDAO();
    }

    @Override
    public List<Category> findAll() {
        return dao.findAll();
    }

    @Override
    public Category findByName(String name) {
        return dao.findAll()
                .stream()
                .filter(category -> category.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Category findById(long id) {
        return dao.findAll()
                .stream()
                .filter(category -> category.getId()==id)
                .findFirst()
                .orElse(null);
    }

    //id thing check
    @Override
    public void update(Category category) {
        dao.update(category);
    }

    @Override
    public void insert(Category category) {
        dao.insert(category);
        log.info("category has been inserted");
    }

    @Override
    public void delete(String name) {
        Category neededCategory = dao.findAll()
                .stream()
                .filter(category -> category.getName().equals(name))
                .findFirst()
                .orElse(null);

        if (neededCategory == null) {
            log.info("No such category");
        } else {
            dao.delete(neededCategory);
            log.info("Category successfully has been deleted");
        }
    }

    public List<CategoryBean> getBeanList() {
        List<Category> categories = dao.findAll();
        List<CategoryBean> categoryBeans = new ArrayList<>();

        for (Category c : categories) {
            CategoryBean categoryBean = new CategoryBean();

            categoryBean.setName(c.getName());
            categoryBeans.add(categoryBean);
        }
        return categoryBeans;
    }

}
