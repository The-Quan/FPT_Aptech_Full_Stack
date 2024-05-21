package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBase {
    public static Connection DBAddressBooks() throws SQLException {
        Connection conn2 = null;
        String hostname = "localhost";
        String dbname ="baithithuchanh";

        String URL = "jdbc:mysql://" + hostname + ":3306/" + dbname;
        conn2 = DriverManager.getConnection(URL,"root","");
        return conn2;
    }

    public static void main(String[] args) throws SQLException {
        if (DBAddressBooks() != null){
            System.out.println("ok");;
        }
    }
}
