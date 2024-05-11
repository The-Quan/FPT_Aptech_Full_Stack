package session14_gennerrics;

import Slot_4.BaiTapCuaHang.view.Main;
import session14_gennerrics.controller.Controller;
import session14_gennerrics.entity.Customer;
import session14_gennerrics.entity.Order;
import session14_gennerrics.entity.OrderDetail;
import session14_gennerrics.entity.Product;
import session14_gennerrics.model.Model;

import java.util.ArrayList;
import java.util.Date;
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
        Controller<Order> order = new Controller<>(orderModel);
        Controller<OrderDetail> orderDetail = new Controller<>(orderDetailModel);


        Customer customer = new Customer(1);
        customer.setName("quan");
        customer.setAddress("bac kan");
        customer.setEmail("quan.com");
        customer.setPhone("0834076");

        Product product = new Product(2);
        product.setName("samsung");
        product.setDescription("new product");
        product.setPrice(55);

        Order order1 = new Order(4);
        order1.setCustomerid(1);
        order1.setCreateAt(new Date());
        order1.setPaymentType("transfer");
        order1.setOrderDetails(new ArrayList<>());

        OrderDetail orderDetail1 = new OrderDetail(1);
        orderDetail1.setOrderId(1);
        orderDetail1.setProductId(1);
        orderDetail1.setCreateAt(new Date());


        //step1: call controler
        controller.addEntityController(customer);
        productController.addEntityController(product);
        order.addEntityController(order1);
        orderDetail.addEntityController(orderDetail1);


        List<Customer> customers = controller.getAllEntity();
        List<Product> products = productController.getAllEntity();
        List<Order> orders = order.getAllEntity();
        List<OrderDetail> orderDetails = orderDetail.getAllEntity();

        System.out.println("----------- customer ----------");
        for (Customer customer1 : customers) {
            System.out.println(customer1.getName());
            System.out.println(customer1.getAddress());
            System.out.println(customer1.getEmail());
            System.out.println(customer1.getPhone());
        }
        System.out.println("-------- product -----------");
        for (Product product1 : products) {
            System.out.println(product1.getName());
            System.out.println(product1.getDescription());
            System.out.println(product1.getPrice());
        }
        System.out.println("---------- orders -----------");
        for (Order order2 : orders) {
            System.out.println(order2.getCustomerid());
            System.out.println(order2.getCreateAt());
            System.out.println(order2.getPaymentType());
            System.out.println(order2.getPaymentType());
        }
        System.out.println("----------- order detail ----------");
        for (OrderDetail orderDetail2 : orderDetails) {
            System.out.println(orderDetail2.getOrderId());
            System.out.println(orderDetail2.getProductId());
            System.out.println(orderDetail2.getCreateAt());
        }
    }
}
