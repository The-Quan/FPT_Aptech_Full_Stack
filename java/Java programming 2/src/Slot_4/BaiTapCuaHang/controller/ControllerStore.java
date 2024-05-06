package Slot_4.BaiTapCuaHang.controller;

import Slot_4.BaiTapCuaHang.entity.Product;
import Slot_4.BaiTapCuaHang.model.Store;

import java.sql.SQLException;
import java.util.List;

public class ControllerStore {
    Store store = new Store();
    public void addProduct(Product product) throws SQLException {
        store.addProduct(product);
    }
    public void deleteProduct(Product product) throws SQLException {
        store.deleteProduct(product);
    }
    public void searchProduct(Product product) throws SQLException {
        store.searchProduct(product);
    }
    public List<Product> allProduct(Product product2) throws SQLException {
         Store store1 = new Store();
        List<Product> products;
        products = store1.allProduct(product2);
        return products;
    }
}
