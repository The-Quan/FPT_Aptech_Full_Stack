package Slot_4.view;

import Slot_4.controller.ControllerBook;
import Slot_4.entity.NewBook;

import java.sql.SQLException;
import java.util.Date;
import java.util.Scanner;

public class viewThuVien {
    ControllerBook controllerBook = new ControllerBook();
    final Scanner sc;

    public viewThuVien() {
        this.sc = new Scanner(System.in);
    }

    public void createBook() throws SQLException {
        System.out.println("========== them sach ===========");
        System.out.println("nhap id sach:");
        int id = Integer.parseInt(sc.nextLine());
        System.out.println("nhap ten sach:");
        String nameBook = sc.nextLine();
        System.out.println("nhap ten tac gia:");
        String nameTacGia = sc.nextLine();
        System.out.println("nhap gia sach:");
        double gia = sc.nextDouble();
        sc.nextLine();
        System.out.println("trang thai:");
        String trangThai = sc.nextLine();
        NewBook newBook = new NewBook(id ,nameBook,nameTacGia,gia,new Date(),trangThai);
        controllerBook.createBook(newBook);
        System.out.println("====> thanh cong");
    }
}
