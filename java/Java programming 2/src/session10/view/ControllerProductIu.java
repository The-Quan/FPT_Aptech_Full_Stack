package session10.view;

import session10.controller.ControllerProduct;
import session10.entity.Product;
import session10.model.ProductDAOimpl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class ControllerProductIu {
    ControllerProduct controller = new ControllerProduct();
    private final Scanner sc;

    public ControllerProductIu() throws SQLException {
        this.sc = new Scanner(System.in);
    }
    public void createProductIu() throws SQLException {
        System.out.println("vui long nhap thong tin");
        System.out.println("nhap ID: ");
        int product_id = sc.nextInt();
        sc.nextLine();
        System.out.println("nhap product name: ");
        String product_name = sc.nextLine();
        System.out.println("nhap product desc: ");
        String product_desc = sc.nextLine();
        System.out.println("nhap price: ");
        double price = sc.nextDouble();

        Product product = new Product(product_id, product_name, product_desc, price);
         controller.productCreateController(product);
    }
    public void updateProductIu() throws SQLException {
        System.out.println("nhap id");
        int Id = sc.nextInt();
        sc.nextLine();
        System.out.println("sua ten san pham");
        String name = sc.nextLine();


        Product product = new Product();
        product.setProduct_id(Id);
        product.setProductName(name);
        controller.productUpdateController(product);
        System.out.println("name da duoc doi thanh " + product.getProductName());

    }
    public void deleteProductIu() throws SQLException {
        System.out.println("nhap id: ");
        int id = sc.nextInt();
        Product product = new Product();
        product.setProduct_id(id);
        controller.productDeleteController(product);
        System.out.println("da xoa san pham co ID = " + product.getProduct_id());
    }
    public void getAllProductIu() throws SQLException {
        ProductDAOimpl productDAO = new ProductDAOimpl();
        ArrayList<Product> allProducts = productDAO.getAllProduct();
        for (Product product : allProducts) {
            System.out.println("Product ID: " + product.getProduct_id());
            System.out.println("Product Name: " + product.getProductName());
            System.out.println("Product Description: " + product.getProductDesc());
            System.out.println("Price: " + product.getPrice());
            System.out.println("--------------------------------------");
        }
        controller.getAllProduct();
    }
}
