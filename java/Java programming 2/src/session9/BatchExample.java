package session9;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

//giao dịch theo lô(một tập hợp các truy vẫn) batch processing
public class BatchExample {
    public static void main(String[] args) throws SQLException {
        Connection connection = DBConnection.DataBase();
        Statement stm = connection.createStatement();
        //kiem tra giao dich tu dong
        connection.setAutoCommit(false);

        String query1 = "insert into orders values (4,1,'24/2/25')";
        stm.addBatch(query1);

        String query2 = "insert into order_detail values (4,3,3)";
        stm.addBatch(query2);

        String query3 = "update products set price = 500 where product_id = 1";
        stm.addBatch(query3);

        int[] count = stm.executeBatch();
        System.out.println(count[0]);
        System.out.println(count[1]);
        System.out.println(count[2]);
        connection.commit();
    }
}
