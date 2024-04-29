package session10.controller;

import session10.entity.Product;
import session10.model.ProductDAOimpl;

import java.sql.SQLException;

public class ControllerProduct {
    ProductDAOimpl productDAOimpl = new ProductDAOimpl();
    public void productUpdateController (Product product) throws SQLException {
        productDAOimpl.updateProduct(product);
    }
    public void productDeleteController(Product product) throws SQLException{
        productDAOimpl.deleteProduct(product.getProduct_id());
    }
    public void productCreateController(Product product) throws SQLException{
        productDAOimpl.createProduct(product);
    }
    public void getAllProduct() throws SQLException {
       productDAOimpl.getAllProduct();
    }
    public ControllerProduct() throws SQLException {
    }
}
