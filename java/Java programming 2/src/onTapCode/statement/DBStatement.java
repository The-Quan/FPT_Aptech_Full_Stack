package onTapCode.statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBStatement {
   public static Connection ketNoiDataBase() throws SQLException{
       Connection conn = null;
       String URL = "jdbc:mysql://localhost:3306/employeefpt";
       conn = DriverManager.getConnection(URL,"root","");
       return conn;
   }

    public static void main(String[] args) throws SQLException {
        if (ketNoiDataBase() != null ){
            System.out.println("ok");
        }else{
            System.out.println("ko thanh cong");
        }
    }
}
