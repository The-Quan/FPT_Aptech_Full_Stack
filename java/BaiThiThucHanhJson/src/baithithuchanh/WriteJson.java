package baithithuchanh;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WriteJson {
    public static void main(String[] args) {
        // Tạo danh sách sinh viên
        List<Student> students = new ArrayList<>();

        // Thêm sinh viên vào danh sách
        Student student1 = new Student("1", "Truong Gia Binh");
        student1.addSubject(new Subject("Math", new int[]{10, 9, 8}));
        student1.addSubject(new Subject("Physics", new int[]{7, 8, 9}));
        students.add(student1);

        Student student2 = new Student("2", "Le Truong Tung");
        student2.addSubject(new Subject("Chemistry", new int[]{8, 9, 10}));
        student2.addSubject(new Subject("Biology", new int[]{7, 7, 8}));
        students.add(student2);

        // Sử dụng Gson để chuyển danh sách sinh viên thành chuỗi JSON
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(students);

        // Ghi chuỗi JSON vào file
        try (FileWriter writer = new FileWriter("Student.json")) {
            writer.write(json);
            System.out.println("File JSON đã được tạo thành công.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}