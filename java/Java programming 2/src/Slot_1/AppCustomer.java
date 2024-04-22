package Slot_1;

import JDBC.MySQLConnectDB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class AppCustomer {
    public static void viewCustomer() throws SQLException {
        Connection connection = DBCustomer.DateBase();
        Statement stm = connection.createStatement();
        String query = "select * from customers";
        ResultSet rs = stm.executeQuery(query);
        while (rs.next()){
            int id = rs.getInt(1);
            String fname = rs.getString(2);
            String lname = rs.getString(3);
            String email = rs.getString(4);

            System.out.println("Id: " + id);
            System.out.println("first name: " + fname);
            System.out.println("last name: " + lname);
            System.out.println("email: " + email);
            System.out.println();
        }
    }

    public static void searchCustomer() throws SQLException {
        Connection connection = MySQLConnectDB.getMySQLConnecttion();
        Statement stm = connection.createStatement();
        System.out.print("tim kiem theo ID: ");
        Scanner sc = new Scanner(System.in);
        int id = sc.nextInt();
        String search = "SELECT * FROM customers WHERE customer_id =  " + id;
        ResultSet rs = stm.executeQuery(search);

        while (rs.next()){
            System.out.println();
            System.out.println("Ket qua tim thay");
            id = rs.getInt(1);
            String fname = rs.getString(2);
            String lname = rs.getString(3);
            String email = rs.getString(4);

            System.out.println("Id: " + id);
            System.out.println("first name: " + fname);
            System.out.println("last name: " + lname);
            System.out.println("email: " + email);
            System.out.println();
        }

    }

    public static void addCustomer() throws SQLException{
        System.out.println("vui long nhap thong tin ");
        Scanner sc = new Scanner(System.in);
        System.out.print("ID: ");
        int id = sc.nextInt();
        System.out.print("First Name: ");
        Scanner sc1 = new Scanner(System.in);
        String fname = sc1.nextLine();
        System.out.print("Last Name: ");
        Scanner sc2 = new Scanner(System.in);
        String lname = sc2.nextLine();
        System.out.print("Email: ");
        Scanner sc3 = new Scanner(System.in);
        String email = sc3.nextLine();

        Connection connection = MySQLConnectDB.getMySQLConnecttion();
        Statement stm = connection.createStatement();
        String query = "INSERT INTO customers (customer_id, first_name, last_name, email) " +
                "VALUES (" + id + ", '" + fname + "', '" + lname + "', '" + email + "')";
        int count = stm.executeUpdate(query);
        System.out.println("them ban ghi so " + count);

    }

    public static void deleteCustomer() throws SQLException{
        Connection connection = MySQLConnectDB.getMySQLConnecttion();
        Statement stm = connection.createStatement();
        System.out.print("Xoa khach hang theo ID: ");
        Scanner sc = new Scanner(System.in);
        int xoa = sc.nextInt();
        String delete = "DELETE FROM customers WHERE customer_id = "+xoa+" ";
        int count = stm.executeUpdate(delete);
        System.out.println("da xoa " + count + " ban ghi");
    }

    public static void updateCustomer() throws SQLException{
        Connection connection = MySQLConnectDB.getMySQLConnecttion();
        Statement stm = connection.createStatement();
        System.out.print("nhap ID: ");
        Scanner sc = new Scanner(System.in);
        int upDate = sc.nextInt();
        System.out.print("Sua first name: ");
        Scanner sc2 = new Scanner(System.in);
        String firstname = sc2.nextLine();
        System.out.print("Sua last name: ");
        Scanner sc3 = new Scanner(System.in);
        String lastname = sc3.nextLine();
        System.out.print("Sua email: ");
        Scanner sc4 = new Scanner(System.in);
        String email = sc4.nextLine();

        String upData = "UPDATE customers Set  first_name = '"+firstname+"', last_name =' "+lastname+"', email = '"+email+"'  Where customer_id = "+upDate+" ";
        int count = stm.executeUpdate(upData);
        System.out.println("da sua " + count + " ban ghi");
    }

    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);
        while (true){
            menu();
            int nhap = sc.nextInt();
            switch (nhap){
                case 1:
                     searchCustomer();
                    break;
                case 2:
                    addCustomer();
                    break;
                case 3:
                    updateCustomer();
                    break;
                case 4:
                    deleteCustomer();
                    break;
                case 5:
                   ;viewCustomer();
                    break;
                case 0:
                    sc.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Khong co lua chon nay: ");
                    break;
            }
        }
    }
    public static void menu(){
        System.out.println("-------- Menu -------");
        System.out.println("1. Tim kiem  ");
        System.out.println("2. Them");
        System.out.println("3. Sua ");
        System.out.println("4. Xoa ");
        System.out.println("5. Xem");
        System.out.println("0. Thoat");
        System.out.println();
        System.out.print("lua chon cua ban: ");
    }
}
