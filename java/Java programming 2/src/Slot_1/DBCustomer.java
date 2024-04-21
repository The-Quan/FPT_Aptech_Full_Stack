package Slot_1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBCustomer {
    public static Connection DateBase() throws SQLException{
        Connection conn = null;
        String hostName = "localhost";
        String dbName = "employeefpt";
        String userName = "root";
        String password = "";

        String URL = "jdbc:mysql://" + hostName + ":3306/" + dbName;
        conn = DriverManager.getConnection(URL, userName, password);
        return conn;
    }

    public static void main(String[] args) throws SQLException {
        if (DateBase() != null){
            System.out.println("ok");
        }
    }
}
