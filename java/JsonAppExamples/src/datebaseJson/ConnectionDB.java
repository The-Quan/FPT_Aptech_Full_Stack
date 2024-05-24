package datebaseJson;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

// connection to mysql
// get data from table
public class ConnectionDB {
    private static final String URL = "jdbc:mysql://localhost:3306/employeefpt";

    private static final String User = "root";
    private static final String Password ="";

    public static List<User> getUser() throws SQLException {
        List<User> user = new ArrayList<>();

        Connection conn = DriverManager.getConnection(URL, User, Password);
        Statement stm = conn.createStatement();
        ResultSet resultSet = stm.executeQuery("select * from user");
        while (resultSet.next()){
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String email = resultSet.getString("email");
            user.add(new User(id, name, email));
        }
        return user;
    }

}
