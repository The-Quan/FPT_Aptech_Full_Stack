package StoreBook_2025.view;

import StoreBook_2025.controller.StoreBookController;
import StoreBook_2025.entity.Products;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class ViewProduct {
    StoreBookController<Products> controller = new StoreBookController<>();

    public void add() {
        Scanner sc = new Scanner(System.in);
        System.out.println("----- Add Product -----");
        System.out.print("ID: ");
        int id = Integer.parseInt(sc.nextLine());
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Description: ");
        String text = sc.nextLine();
        System.out.print("Price: ");
        Double price = sc.nextDouble();
        Products product = new Products(id, name, text, price);

        controller.add(product);
        System.out.println("add success");
    }

    public void update() {
        Scanner sc = new Scanner(System.in);
        System.out.println("----- Update Product -----");
        System.out.print("ID: ");
        int id = Integer.parseInt(sc.nextLine());
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Description: ");
        String text = sc.nextLine();
        System.out.print("Price: ");
        Double price = sc.nextDouble();
        Products product = new Products();
        product.setproduct_id(id);
        product.setName(name);
        product.setDescription(text);
        product.setPrice(price);

        controller.update(product);
        System.out.println("update success");
    }

    public void delete() {
        Scanner sc = new Scanner(System.in);
        System.out.println("----- Delete Product -----");
        System.out.print("ID: ");
        int id = Integer.parseInt(sc.nextLine());
        Products product = new Products();
        product.setproduct_id(id);
        controller.delete(product);
        System.out.println("delete success");
    }

    public void search() throws SQLException {
        System.out.println("----- Search -----");
        System.out.print("Enter ID: ");
        Scanner sc = new Scanner(System.in);
        int id = sc.nextInt();

        Products product = new Products();
        product.setproduct_id(id);
        StoreBookController<Products> customersStoreBookController = new StoreBookController<>();
        List<Products> productsList = customersStoreBookController.search(product);
        for (Products products : productsList) {
            System.out.println("Product ID: " + products.getproduct_id());
            System.out.println("Name: " + products.getName());
            System.out.println("Description: " + products.getDescription());
            System.out.println("Price: " + products.getPrice());
        }
    }

    public void getAll() throws SQLException {
        Products products = new Products();
        StoreBookController<Products> productsStoreBookController = new StoreBookController<>();
        List<Products> allProduct = productsStoreBookController.getAll(products);
        for (Products products1 : allProduct) {
            System.out.println("Product ID: " + products1.getproduct_id());
            System.out.println("Name: " + products1.getName());
            System.out.println("Description: " + products1.getDescription());
            System.out.println("Price: " + products1.getPrice());
            System.out.println("------------------------");
        }
    }
}
