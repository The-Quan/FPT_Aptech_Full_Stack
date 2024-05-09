import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class  Cach_ket_noi_Database {
    public static Connection DataBaseKetNoi() throws SQLException{
        // cách 1
       /* Connection conn = null;
        String URL = "jdbc:mysql://localhost:3306/employeefpt";
        conn = DriverManager.getConnection(URL,"root","");
        return conn; */

        // cách 2
        Connection conn2 = null;
        String hostname = "localhost";
        String dbname ="storebook";

        String URL = "jdbc:mysql://" + hostname + ":3306/" + dbname;
        conn2 = DriverManager.getConnection(URL,"root","");
        return conn2;

        /* cách 3
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
        }*/

    }

   // thử xem có kết nối thành công hay không
    public static void main(String[] args) throws SQLException {
        if (DataBaseKetNoi() != null){
            System.out.println("ok");
        }
    }
}
