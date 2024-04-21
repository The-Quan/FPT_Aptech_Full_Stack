package JDBC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MyApplication {
    public static void main(String[] args) throws SQLException {
       getALlConnection();
//      createCustomers();

    }

    public static void createCustomers() throws SQLException{
        Connection connection = MySQLConnectDB.getMySQLConnecttion();
        Statement stm = connection.createStatement();
        String query = "INSERT INTO customers(customer_id, first_name, last_name,  email)" + "values(9, 'nguyen', 'van a', 'a@gamil.com')";
        // execute executeUpdata(): create, updata, delete
       int  count = stm.executeUpdate(query);
        System.out.println("them ban ghi so " + count);
    }
    public static void getALlConnection() throws SQLException{
        // gọi đối tượng connection
        Connection connection = MySQLConnectDB.getMySQLConnecttion();
        //tạo Statement (thi hành thao tác)

        Statement stm = connection.createStatement();

        // câu lệnh truy vẫn (sql engine)
        String query = "select * from customers";
        //thực thi truy vẫn, trả về kết quả từ database cho đt resultset
        ResultSet rs = stm.executeQuery(query);

        // đọc bản ghi trên Resulset
        while (rs.next()){
            int cusId = rs.getInt(1);
//            int cusID = rs.getInt("customer_id");
            String FirstName = rs.getString(2);
            String LastName = rs.getString(3);
            String Email = rs.getString(4);

            System.out.println("=========================");
            System.out.println("customers Id: " + cusId);
            System.out.println("firstName: " + FirstName);
            System.out.println("lastName: " + LastName);
            System.out.println("email: " + Email);
        }
        // close connection
        connection.close();
    }
}
