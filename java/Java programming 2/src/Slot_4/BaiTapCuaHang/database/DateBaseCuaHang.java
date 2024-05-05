package Slot_4.BaiTapCuaHang.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DateBaseCuaHang {
    public static final String URL = "jdbc:mysql://localhost:3306/cuahang";
    public static final String USERNAME = "root";
    public static final String PASSWORD = "";
    public static Connection DBCuaHang() throws SQLException {
        return DriverManager.getConnection(URL,USERNAME,PASSWORD);
    }
    public static void main(String[] args) throws SQLException {
        if (DBCuaHang() != null){
            System.out.println("ok");
        }
    }
}
