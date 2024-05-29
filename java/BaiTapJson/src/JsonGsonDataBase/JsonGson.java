package JsonGsonDataBase;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class JsonGson {
    private static final String JSON_FILE_PATH = "students.json";
    private static Gson gson = new Gson();
    private static List<Student> students;
    private static final Connection connection;

    static {
        try {
            connection = Database.gsonDB();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static Scanner sc = new Scanner(System.in);
    private static void addNewStudent(Student student) throws SQLException {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        sc.nextLine();  // Consume newline
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Address: ");
        String address = sc.nextLine();
        System.out.print("Enter Email: ");
        String email = sc.nextLine();
        System.out.print("Enter Phone: ");
        String phone = sc.nextLine();
        System.out.print("Enter DOB (YYYY-MM-DD): ");
        String dob = sc.nextLine();

        Student newStudent1 = new Student(id, name, address, email, phone, dob);
        students.add(newStudent1);

        try (connection) {
            String sql = "INSERT INTO Student (ID, name, address, email, phone, DOB) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, newStudent1.getId());
            statement.setString(2, newStudent1.getName());
            statement.setString(3, newStudent1.getAddress());
            statement.setString(4, newStudent1.getEmail());
            statement.setString(5, newStudent1.getPhone());
            statement.setString(6, newStudent1.getDob());
            statement.executeUpdate();
            System.out.println("Student added to database successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        updateJsonFile();
        System.out.println("Student added successfully.");
    }

    private static void displayAllStudents() {
        for (Student student : students) {
            System.out.println(student.id);
            System.out.println(student.name);
            System.out.println(student.email);
            System.out.println(student.address);
            System.out.println(student.phone);
            System.out.println(student.dob);
            System.out.println("-------------");
        }
    }

    private static void searchByName() {
        System.out.print("Enter Name to search: ");
        String name = sc.nextLine();

        boolean found = false;
        for (Student student : students) {
            if (student != null && student.getName() != null && student.getName().equalsIgnoreCase(name)) {
                System.out.println(student.getId());
                System.out.println(student.getName());
                System.out.println(student.getEmail());
                System.out.println(student.getAddress());
                System.out.println(student.getPhone());
                System.out.println(student.getDob());
                found = true;
                break; // Assuming you want to find the first match only
            }
        }
        if (!found) {
            System.out.println("No matching student found");
        }
    }

    private static void searchByEmail() {
        System.out.print("Enter Email to search: ");
        String email = sc.nextLine();
        boolean found = false;
        for (Student student : students) {
            if (student != null && student.getEmail() != null && student.getEmail().equalsIgnoreCase(email)) {
                System.out.println(student.getId());
                System.out.println(student.getName());
                System.out.println(student.getEmail());
                System.out.println(student.getAddress());
                System.out.println(student.getPhone());
                System.out.println(student.getDob());
                found = true;
                break; // Assuming you want to find the first match only
            }
        }
        if (!found) {
            System.out.println("No matching student found");
        }
    }

    private static void updateJsonFile() {
        try (FileWriter writer = new FileWriter(JSON_FILE_PATH)) {
            gson.toJson(students, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        try {
            Type studentListType = new TypeToken<List<Student>>() {}.getType();
            students = gson.fromJson(new FileReader(JSON_FILE_PATH), studentListType);
            Scanner scanner = new Scanner(System.in);
            Student student = new Student();
            while (true) {
                System.out.println("1. Add new Student");
                System.out.println("2. Display all Students");
                System.out.println("3. Search by Name");
                System.out.println("4. Search by Email");
                System.out.println("5. Exit");
                System.out.print("Enter: ");
                int choice = scanner.nextInt();
                scanner.nextLine();  // Consume newline

                switch (choice) {
                    case 1:
                        addNewStudent(student);
                        break;
                    case 2:
                        displayAllStudents();
                        break;
                    case 3:
                        searchByName();
                        break;
                    case 4:
                        searchByEmail();
                        break;
                    case 5:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid choice. Try again.");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
