package JsonGsonDataBase;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Database {
    public static Connection gsonDB() throws SQLException {
        String jdbcURL = "jdbc:mysql://localhost:3306/baitapjson";
        String dbUser = "root";
        String dbPassword = "";
        List<Student> students = new ArrayList<>();
        Connection connection = null;
        connection = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);

        try {
            String sql = "SELECT * FROM Student";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                int id = resultSet.getInt("ID");
                String name = resultSet.getString("name");
                String address = resultSet.getString("address");
                String email = resultSet.getString("email");
                String phone = resultSet.getString("phone");
                String dob = resultSet.getString("DOB");
                Student student = new Student(id, name, address, email, phone, dob);
                students.add(student);
            }

            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            try (FileWriter writer = new FileWriter("students.json")) {
                gson.toJson(students, writer);
            }

        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static void main(String[] args) throws SQLException {
        if (gsonDB() != null){
            System.out.println("ok");
        }else{
            System.out.println("ko thanh cong");
        }
    }
}
