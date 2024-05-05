package Slot_4.BaiTapCuaHang.controller;

import Slot_4.BaiTapCuaHang.entity.Product;
import Slot_4.BaiTapCuaHang.model.Store;

import java.sql.SQLException;

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
}
