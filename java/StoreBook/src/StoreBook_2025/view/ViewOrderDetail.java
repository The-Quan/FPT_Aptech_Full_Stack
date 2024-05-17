package StoreBook_2025.view;

import StoreBook_2025.controller.StoreBookController;
import StoreBook_2025.entity.OrderDetail;
import StoreBook_2025.entity.ShowOrderDetail;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class ViewOrderDetail {
    private final Scanner sc = new Scanner(System.in);
    public void addOrderdetail() throws IllegalAccessException {
        System.out.println("----- Order Detail -----");
        System.out.print("Enter order_id: ");
        int idOrder = Integer.parseInt(sc.nextLine());
        System.out.print("Enter customer_id: ");
        int idCustomer = Integer.parseInt(sc.nextLine());
        System.out.print("Enter product_id: ");
        int idProduct =  Integer.parseInt(sc.nextLine());
        System.out.print("Enter Total: ");
        double total = sc.nextDouble();
        Date date = new Date();

        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setOrder_id(idOrder);
        orderDetail.setCustomer_id(idCustomer);
        orderDetail.setProduct_id(idProduct);
        orderDetail.setDatetimes(date);
        orderDetail.setTotal(total);
        StoreBookController storeBookController = new StoreBookController();
        storeBookController.addOrderDetail(orderDetail);
    }
    public void showOrderDetail(){
        System.out.println("----- Show Order Detail ------");
        ShowOrderDetail showOrderDetail = new ShowOrderDetail();
        StoreBookController storeBookController = new StoreBookController();
        List<ShowOrderDetail> showOrderDetails = storeBookController.showOrderDetails(showOrderDetail);
        for (ShowOrderDetail storeBookController1: showOrderDetails){
            System.out.println("Order ID: " + storeBookController1.getOrder().getOrder_id());
            System.out.println("Customer ID: " + storeBookController1.getCustomer().getCustomerId());
            System.out.println("Customer Name: " + storeBookController1.getCustomer().getName());
            System.out.println("Product ID: "+ storeBookController1.getProduct().getproduct_id());
            System.out.println("Product Name: " + storeBookController1.getProduct().getName());
            System.out.println("Address: " + storeBookController1.getOrder().getAddress());
            System.out.println("Date: " + storeBookController1.getOrderDetail().getDatetimes());
            System.out.println("Total: " + storeBookController1.getOrderDetail().getTotal());
            System.out.println("---------------------");
        }
    }
}
