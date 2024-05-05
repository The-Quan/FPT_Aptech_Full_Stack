package session10.controller;

import session10.entity.Product;
import session10.model.ProductDAOimpl;

import java.sql.SQLException;
import java.util.ArrayList;

public class ControllerProduct {
    ProductDAOimpl productDAOimpl = new ProductDAOimpl();

    public ControllerProduct() throws SQLException {
    }

    public void productUpdateController (Product product) throws SQLException {
        productDAOimpl.updateProduct(product);
    }
    public void productDeleteController(Product product) throws SQLException{
        productDAOimpl.deleteProduct(product.getProduct_id());
    }
    public void productCreateController(Product product) throws SQLException{
        productDAOimpl.createProduct(product);
    }
    public ArrayList<Product> getAllProduct() throws SQLException {
        ArrayList<Product> gellProduct = productDAOimpl.getAllProduct();
        return gellProduct;
    }
}
