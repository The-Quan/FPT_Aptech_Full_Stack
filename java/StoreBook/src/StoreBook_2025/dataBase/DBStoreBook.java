package StoreBook_2025.dataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBStoreBook {
    public static Connection DBStoreBooks() throws SQLException {
        Connection conn = null;
        String hostname = "localhost";
        String dbname=  "storebook";
        
        String URL = "jdbc:mysql://" + hostname + ":3306/" + dbname;
        conn = DriverManager.getConnection(URL,"root", "");
        return conn;
    }

    public static void main(String[] args) throws SQLException {
        if(DBStoreBooks() != null){
            System.out.println("thanh cong");
        }
    }
}
