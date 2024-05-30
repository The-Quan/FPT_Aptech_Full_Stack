package baithithuchanh;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class Manager {
    private static final String FILE_PATH = "Student.json";
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private static final Type STUDENT_LIST_TYPE = new TypeToken<List<baithithuchanh.Student>>() {}.getType();

    public static List<baithithuchanh.Student> readStudentsFromFile() {
        List<baithithuchanh.Student> students = new ArrayList<>();
        try (FileReader reader = new FileReader(FILE_PATH)) {
            students = gson.fromJson(reader, STUDENT_LIST_TYPE);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return students != null ? students : new ArrayList<>();
    }

    public static void writeStudentsToFile(List<Student> students) {
        try (FileWriter writer = new FileWriter(FILE_PATH)) {
            gson.toJson(students, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}