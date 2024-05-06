package Slot_4.BaiTapCuaHang.model;

import Slot_4.BaiTapCuaHang.database.DateBaseCuaHang;
import Slot_4.BaiTapCuaHang.entity.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
    public final String allProduct = "SELECT * FROM product";

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
            product.setProduct_id(rs.getInt(1));
            product.setProduct_name(rs.getString(2));
            product.setPrice(rs.getDouble(3));
            product.setStatus(rs.getBoolean(4));
        }
    }

    @Override
    public void deleteProduct(Product product) throws SQLException {
        PreparedStatement pstm  = connection.prepareStatement(deleteProduct);
        pstm.setInt(1,product.getProduct_id());
        pstm.executeUpdate();
    }

    @Override
    public List<Product> allProduct(Product product2) throws SQLException {
        List<Product> products = new ArrayList<>();
        PreparedStatement pstm = connection.prepareStatement(allProduct);
        ResultSet rs = pstm.executeQuery();
        while (rs.next()){
            Product product = new Product();
            product.setProduct_id(rs.getInt(1));
            product.setProduct_name(rs.getString(2));
            product.setPrice(rs.getDouble(3));
            product.setStatus(rs.getBoolean(4));
            products.add(product);
        }
        return products;
    }
}
