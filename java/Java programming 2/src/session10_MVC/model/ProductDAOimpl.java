package session10_MVC.model;

import session10_MVC.dao.DBConnection;
import session10_MVC.entity.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductDAOimpl implements ProductDAO{
    private static final Connection connection;

    static {
        try {
            connection = DBConnection.DataBase();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private final String SQL_CREATE_PRODUCT = "insert into products values(?,?,?,?)";
    private final String SQL_GET_PRODUCT_BY_ID =  "select * from products where product_id = ?";
    private static final String SQL_GET_ALL_PRODUCT = "select * from products";
    private final String SQL_UPDATE_PRODUCT ="UPDATE products SET product_name = ? WHERE product_id = ? ";
    private final String SQL_DELETE_PRODUCT = "delete from products where product_id= ?";

    public ProductDAOimpl() throws SQLException {
    }

    @Override
    public void createProduct(Product product) throws SQLException {
        PreparedStatement pstm = connection.prepareStatement(SQL_CREATE_PRODUCT);
        pstm.setInt(1,product.getProduct_id());
        pstm.setString(2,product.getProductName());
        pstm.setString(3,product.getProductDesc());
        pstm.setDouble(4,product.getPrice());

        System.out.println("da them " + pstm.executeUpdate() +" product ");
    }

    @Override
    public Product getProductById(int prodId) throws SQLException {
        Product product = new Product();
        PreparedStatement pstm = connection.prepareStatement(SQL_GET_PRODUCT_BY_ID);
        pstm.setInt(1,prodId);
        ResultSet rs = pstm.executeQuery();
        if (rs.next()) {
            product = new Product();
            product.setProduct_id(rs.getInt("product_id"));
            product.setProductName(rs.getString("product_name"));
            product.setProductDesc(rs.getString("description"));
            product.setPrice(rs.getDouble("price"));
        }
        return product;
    }

    @Override
    public ArrayList<Product> getAllProduct() throws SQLException {
        ArrayList<Product> allProducts = new ArrayList<>();
        PreparedStatement pstm = connection.prepareStatement(SQL_GET_ALL_PRODUCT);
        ResultSet rs = pstm.executeQuery();
            while (rs.next()){
                Product product = new Product();
                product.setProduct_id(rs.getInt("product_id"));
                product.setProductName(rs.getString("product_name"));
                product.setProductDesc(rs.getString("description"));
                product.setPrice(rs.getDouble("price"));
                allProducts.add(product);
            }
        rs.close();
        pstm.close();
        return allProducts;

    }

    @Override
    public void updateProduct(Product product) throws SQLException {
        PreparedStatement pstm = connection.prepareStatement(SQL_UPDATE_PRODUCT);
        pstm.setString(1,product.getProductName());
        pstm.setInt(2,product.getProduct_id());
        pstm.executeUpdate();
    }

    @Override
    public boolean deleteProduct(int prodId) throws SQLException {
        PreparedStatement pstm = connection.prepareStatement(SQL_DELETE_PRODUCT);
        pstm.setInt(1, prodId);
        pstm.executeUpdate();
        int rowsAffected = pstm.executeUpdate(); // Execute the SQL statement
        return rowsAffected > 0;
    }
}
