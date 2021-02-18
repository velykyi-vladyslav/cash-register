package ua.lviv.velykyi.vladyslav.db.service;


import ua.lviv.velykyi.vladyslav.db.entity.Category;

import java.util.List;

public interface CategoryService {
    List<Category> findAll();
    Category findByName(String name);
    void update(Category category);
    void insert(Category category);
    void delete(String name);
}
