package Slot_4.BaiTapCuaHang.model;

import Slot_4.BaiTapCuaHang.entity.Product;

import java.sql.SQLException;

public interface StoreImpl {
    public void  addProduct(Product product) throws SQLException;
    public void searchProduct(Product product) throws SQLException;
    public void deleteProduct(Product product) throws SQLException;

}
