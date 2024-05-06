package Slot_4.BaiTapCuaHang.model;

import Slot_4.BaiTapCuaHang.entity.Product;

import java.sql.SQLException;
import java.util.List;

public interface StoreImpl {
    public void  addProduct(Product product) throws SQLException;
    public void searchProduct(Product product) throws SQLException;
    public void deleteProduct(Product product) throws SQLException;
    public List<Product> allProduct(Product product2) throws SQLException;
    public List<Product> showProductHet(Product product) throws SQLException;

}
