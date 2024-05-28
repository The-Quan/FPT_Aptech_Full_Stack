package JsonDataBase;
import com.github.cliftonlabs.json_simple.JsonArray;
import com.github.cliftonlabs.json_simple.JsonObject;
import com.github.cliftonlabs.json_simple.Jsoner;
import com.google.gson.Gson;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JsonDataBase {
    private static final String Url = "jdbc:mysql://localhost:3306/baitapjson";
    private static final String user = "root";
    private static final String password = "";


    public static void main(String[] args) throws IOException {
        try (Connection connection = DriverManager.getConnection(Url, user, password)) {
            String sql = "SELECT * FROM Student";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            List<Student> students = new ArrayList<>();
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
            JsonArray studentArray = new JsonArray();
            for (Student student : students) {
                studentArray.add(student.toString());
            }
            try (FileWriter file = new FileWriter("students.json")) {
                file.write(studentArray.toJson());
                file.flush();
            }
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }
}
