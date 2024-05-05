package Slot_4.BaiTapCuaHang.model;

import Slot_4.BaiTapCuaHang.database.DateBaseCuaHang;
import Slot_4.BaiTapCuaHang.entity.Product;
import Slot_4.BaiTapThuVien.database.DatabaseThuVien;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;

public class Store implements StoreImpl{
    public final Connection connection;

    {
        try {
            connection = DateBaseCuaHang.DBCuaHang();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public final String addProduct = "insert into product values (?,?,?,?)";
    public final String deleteProduct = "DELETE FROM product WHERE product_id = ?";
    public final String searchProduct = "SELECT * FROM product WHERE product_id LIKE ? ";

    @Override
    public void addProduct(Product product) throws SQLException {
        PreparedStatement pstm = connection.prepareStatement(addProduct);
        pstm.setInt(1,product.getProduct_id());
        pstm.setString(2,product.getProduct_name());
        pstm.setDouble(3,product.getPrice());
        pstm.setBoolean(4,product.isStatus());
        pstm.executeUpdate();
    }

    @Override
    public void searchProduct(Product product) throws SQLException {
        PreparedStatement pstm = connection.prepareStatement(searchProduct);
        pstm.setInt(1,product.getProduct_id());
        ResultSet rs = pstm.executeQuery();
        while (rs.next()){
            Product product1 = new Product();
            product1.setProduct_id(rs.getInt(1));
            product1.setProduct_name(rs.getString(2));
            product1.setPrice(rs.getDouble(3));
            product1.setStatus(rs.getBoolean(4));
        }
    }

    @Override
    public void deleteProduct(Product product) throws SQLException {
        PreparedStatement pstm  = connection.prepareStatement(deleteProduct);
        pstm.setInt(1,product.getProduct_id());
        pstm.executeUpdate();
    }
}
