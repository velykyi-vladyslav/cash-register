package ua.lviv.velykyi.vladyslav.db.entity;

import java.math.BigDecimal;

public class Product extends Entity {
    //max 50
    private String name;

    private BigDecimal price;
    private long categoryId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", categoryId=" + categoryId + ", id=" + getId() +
                '}';
    }
}
