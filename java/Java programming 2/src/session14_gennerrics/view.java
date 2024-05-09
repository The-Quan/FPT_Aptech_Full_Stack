package session14_gennerrics;

import Slot_4.BaiTapCuaHang.view.Main;
import session14_gennerrics.controller.Controller;
import session14_gennerrics.entity.Customer;
import session14_gennerrics.entity.Order;
import session14_gennerrics.entity.OrderDetail;
import session14_gennerrics.entity.Product;
import session14_gennerrics.model.Model;

import java.util.List;

public class view {
    public static void main(String[] args) {
        // create model
        Model<Customer> customerModel = new Model<>();
        Model<Product> productModel = new Model<>();
        Model<Order> orderModel = new Model<>();
        Model<OrderDetail> orderDetailModel = new Model<>();
        // create controler
        Controller<Customer> controller = new Controller<>(customerModel);
        Controller<Product> productController = new Controller<>(productModel);


        Customer customer = new Customer(1);
        customer.setName("quan");
        customer.setAddress("bac kan");
        customer.setEmail("quan.com");
        customer.setPhone("0834076");

        Product product = new Product(2);
        product.setName("samsung");
        product.setDescription("new product");
        product.setPrice(55);

        //step1: call controler
        controller.addEntityController(customer);
        productController.addEntityController(product);


        List<Customer> customers = controller.getAllEntity();
        List<Product> products = productController.getAllEntity();

        for(Customer customer1 : customers ){
            System.out.println(customer1.getName());
        }
        for(Product product1 : products ){
            System.out.println(product1.getName());
        }
    }
}
