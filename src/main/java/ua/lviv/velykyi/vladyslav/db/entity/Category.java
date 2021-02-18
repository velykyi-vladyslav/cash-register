package ua.lviv.velykyi.vladyslav.db.entity;

public class Category extends Entity {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Category [name= " + name + "; id= " + getId() + "]";
    }
}
