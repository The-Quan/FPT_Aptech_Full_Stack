package session10.model;

import session10.entity.Product;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ProductDAO {
    public void createProduct(Product product) throws SQLException;
    public Product getProductById(int prodId) throws SQLException;
    public ArrayList<Product> getAllProduct() throws SQLException;
    public void updateProduct(Product product) throws SQLException;
    public boolean deleteProduct(int prodId) throws SQLException;
}
