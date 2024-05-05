package Slot_4.BaiTapThuVien.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Wrapper;

public class DatabaseThuVien {
    public static Connection KetNoiDatebaseThuVien() throws SQLException {
        Connection conn = null;
        String URL = "jdbc:mysql://localhost:3306/thuvien";
        conn = DriverManager.getConnection(URL,"root","");
        return conn;
    }

    public static void main(String[] args) throws SQLException {
        if (KetNoiDatebaseThuVien() != null){
            System.out.println("ket noi thanh cong");
        }
    }

}
