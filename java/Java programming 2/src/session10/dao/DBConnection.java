package session10.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
public static Connection DataBase() throws SQLException{
    Connection conn = null;
    String URL = "jdbc:mysql://localhost:3306/employeefpt";
    conn = DriverManager.getConnection(URL,"root","");
    return conn;
}

    public static void main(String[] args) throws SQLException {
        if (DataBase() != null){
            System.out.println("ket noi thanh cong");
        }
    }
}
