package session10_MVC.model;

import session10_MVC.entity.Product;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ProductDAO {
    public void createProduct(Product product) throws SQLException;
    public Product getProductById(int prodId) throws SQLException;
    public ArrayList<Product> getAllProduct() throws SQLException;
    public void updateProduct(Product product) throws SQLException;
    public boolean deleteProduct(int prodId) throws SQLException;
}
