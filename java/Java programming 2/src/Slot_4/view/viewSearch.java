package Slot_4.view;

import Slot_4.controller.ControllerSearch;
import Slot_4.entity.NewBook;
import Slot_4.model.Search;
import Slot_4.model.SearchBook;
import com.sun.security.jgss.GSSUtil;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class viewSearch {
    ControllerSearch controllerSearch = new ControllerSearch();
    final Scanner sc;

    public viewSearch() {
        this.sc = new Scanner(System.in);
    }
    public void searchNameBook() throws SQLException {
        System.out.println("nhap ten sach");
        String nameBook = sc.nextLine();
        ControllerSearch controllerSearch1 = new ControllerSearch();
        List<NewBook> newBooks = controllerSearch1.searchName(nameBook);
        for (NewBook newBook1 : newBooks) {
            System.out.println("Ten sach: " + newBook1.getBookId());
            System.out.println("Ten tac gia: " + newBook1.getNameBook());
            System.out.println("Gia: " + newBook1.getGia());
            System.out.println("ngay nhap: " + newBook1.getNgayNhap());
            System.out.println("The loai: " + newBook1.getTrangThai());
            System.out.println();
        }
    }
       public void searchGia() throws SQLException {
            try {
                System.out.println("Nhap gia: ");
                double gia = sc.nextDouble();
                ControllerSearch controllerSearch1 =new ControllerSearch();
                List<NewBook> newBooks = controllerSearch1.searchGiaController(gia);
               for(NewBook newBook : newBooks){
                   System.out.println("Ten sach: "+ newBook.getNameBook());
                   System.out.println("Ten tac gia: "+newBook.getNameTacGia());
                   System.out.println("Gia: "+newBook.getGia());
                   System.out.println("ngay nhap: "+newBook.getNgayNhap());
                   System.out.println("Trang thai: "+newBook.getTrangThai());
                   System.out.println();
               }
            }catch (Exception e){
                e.printStackTrace();
            }
    }


    public void searchTacGia() throws SQLException {

        System.out.println("nhap ten tac gia:");
        String tacgia = sc.nextLine();

       ControllerSearch controllerSearch1 = new ControllerSearch();
       List<NewBook> newBooks = controllerSearch1.searchTacGia(tacgia);

       for (NewBook newBook1 : newBooks) {
           System.out.println("ma sach: " + newBook1.getBookId());
           System.out.println("Ten sach: " + newBook1.getNameBook());
           System.out.println("Ten tac gia: " + newBook1.getNameTacGia());
           System.out.println("Gia: " + newBook1.getGia());
           System.out.println("ngay nhap: " + newBook1.getNgayNhap());
           System.out.println("Trang thai: " + newBook1.getTrangThai());
           System.out.println();
       }
    }
}
