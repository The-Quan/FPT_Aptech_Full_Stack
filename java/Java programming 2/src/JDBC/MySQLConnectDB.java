package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnectDB {
    public static Connection getMySQLConnecttion() throws SQLException {
        Connection Conn = null;
        String hostName = "localhost"; // 127.0.0.1
        String dbName = "employeefpt";
        String userName = "root";
        String password = "";

        // String connection (chuoi ket noi)
        String connectionURL = "jdbc:mysql://" + hostName + ":3306/" + dbName;
        Conn = DriverManager.getConnection(connectionURL,userName,password);
        return Conn;
    }

    public static void main(String[] args) throws SQLException {
        if(getMySQLConnecttion() != null){
            System.out.println("ket noi thanh cong");
        }

        //get connection (goi doi tuong connection de du dung)
        Connection connection = getMySQLConnecttion();
    }
}
