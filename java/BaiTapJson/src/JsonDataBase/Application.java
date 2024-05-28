package JsonDataBase;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;


import java.io.FileReader;
import java.io.IOException;

import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class Application {
    private static final String json_file_path = "students.json";
    private static List<Student> students = new ArrayList<>();
    public static void main(String[] args) {
        try {
            JsonParser jsonParser = new JsonParser();
            JsonArray studentArray = (JsonArray) jsonParser.parse(new FileReader(json_file_path));

            for (JsonElement obj : studentArray) {
                JsonObject jsonObject1 = (JsonObject) obj;
                int id =  jsonObject1.get("id").getAsInt();
                String name =  jsonObject1.get("name").getAsString();
                String address =  jsonObject1.get("address").getAsString();
                String email = jsonObject1.get("email").getAsString();
                String phone = jsonObject1.get("phone").getAsString();
                String dob = jsonObject1.get("DOB").getAsString();
                students.add(new Student(id,name,address,email,phone,dob));
            }
            Controler controler = new Controler();
            Scanner scanner = new Scanner(System.in);
            Student student = new Student();
            while (true) {
                System.out.println("1. Add new Student");
                System.out.println("2. Display all Students");
                System.out.println("3. Search by Name");
                System.out.println("4. Search by Email");
                System.out.println("5. Exit");
                int choice = scanner.nextInt();
                scanner.nextLine();  // Consume newline
                switch (choice) {
                    case 1:
                       controler.add(student);
                        break;
                    case 2:

                        break;
                    case 3:

                        break;
                    case 4:

                        break;
                    case 5:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid choice. Try again.");
                }
            }
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
    }
}
