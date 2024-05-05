package Slot_4.BaiTapThuVien.view;

import Slot_4.BaiTapThuVien.controller.ControllerBorrow;
import Slot_4.BaiTapThuVien.entity.Borrow;

import java.sql.SQLException;
import java.util.Date;
import java.util.Scanner;

public class viewBorrow {
    ControllerBorrow controllerBorrow = new ControllerBorrow();
    final Scanner sc;

    public viewBorrow() {
        this.sc = new Scanner(System.in);
    }

    public void borrow() throws SQLException {
        System.out.println("----- Borrow ------");
        System.out.println("nhap student id: ");
        int student_id = Integer.parseInt(sc.nextLine());
        System.out.println("nhap book id: ");
        int book_id = Integer.parseInt(sc.nextLine());
        System.out.println("chon Status(1. muon): ");
        int status = Integer.parseInt(sc.nextLine());
        System.out.println("nhap ngay tra: ");
        String returnBook = sc.nextLine();
        Borrow borrow = new Borrow(student_id,book_id,status,new Date(),returnBook);
        controllerBorrow.borrow(borrow);
        System.out.println("=== thanh cong ===");
    }
    public void returnBook() throws SQLException {
        System.out.println("----- return -----");
        System.out.println("nhap student id: ");
        int studentID = Integer.parseInt(sc.nextLine());
        System.out.println("nhap book id: ");
        int bookID = Integer.parseInt(sc.nextLine());
        System.out.println("nhap status (0. tra)");
        int status = Integer.parseInt(sc.nextLine());

        Borrow borrow = new Borrow();
        borrow.setStudent_id(studentID);
        borrow.setBook_id(bookID);
        borrow.setStatus(status);

        ControllerBorrow controllerBorrow1 = new ControllerBorrow();
        controllerBorrow1.returnBook(borrow);
        System.out.println("-----thanh cong------");
    }
}
