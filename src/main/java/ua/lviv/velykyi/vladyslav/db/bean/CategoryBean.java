package ua.lviv.velykyi.vladyslav.db.bean;

import ua.lviv.velykyi.vladyslav.db.entity.Entity;

public class CategoryBean extends Entity {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "CategoriesBean{" +
                "name='" + name + '\'' +
                '}';
    }
}
