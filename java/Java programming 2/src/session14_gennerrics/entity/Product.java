package session14_gennerrics.entity;

import Slot_4.BaiTapCuaHang.model.StoreImpl;

public class Product extends Entity<Integer>{
    private String name;
    private String description;
    private double price;

    public Product(Integer id) {
        super(id);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}
