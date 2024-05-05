package Slot_4.BaiTapThuVien.view;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public void menu(){
        System.out.println("===== Menu =====");
        System.out.println("1. them sach");
        System.out.println("2. them student");
        System.out.println("3. tim kiem sach");
        System.out.println("4. cho sinh vien muon sach");
        System.out.println("5. sinh vien tra sach");
        System.out.println("6. hien thi danh sach sinh vien muon sach");
    }
    public void menuSearch(){
        System.out.println("===== Menu =======");
        System.out.println("1. search theo ten sach");
        System.out.println("2. search theo ten tac gia");
        System.out.println("3. search theo gia");
        System.out.println("0. exit");
    }
    public void start() throws SQLException {
        while (true){
            menu();
            System.out.println("lua chon cua ban:");
            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();
            switch (choice){
                case 1:
                    viewThuVien viewThuVien = new viewThuVien();
                    viewThuVien.createBook();
                    break;
                case 2:
                    viewStudent viewStudent = new viewStudent();
                    viewStudent.createStudent();
                case 3:
                    menuSearch();
                    System.out.println("lua chon cua ban:");
                    Scanner sc2 = new Scanner(System.in);
                    int choice2 = sc2.nextInt();
                    viewSearch viewSearch = new viewSearch();
                    switch (choice2){
                        case 1:
                            viewSearch.searchNameBook();
                            break;
                        case 2:
                            viewSearch.searchTacGia();
                            break;
                        case 3:
                            viewSearch.searchGia();
                            break;
                        case 0:
                            System.exit(0);
                        default:
                            System.out.println("vui long nhap lai");
                            break;
                    }
                    break;
                case 4:
                    viewBorrow viewBorrow = new viewBorrow();
                    viewBorrow.borrow();
                case 5:
                    viewBorrow viewBorrow1 = new viewBorrow();
                    viewBorrow1.returnBook();
                case 6:
                    viewAllBorrow viewAllBorrow = new viewAllBorrow();
                    viewAllBorrow.AllBorrow();
            }
        }
    }
}
