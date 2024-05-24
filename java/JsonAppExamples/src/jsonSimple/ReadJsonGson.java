package jsonSimple;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ReadJsonGson {
    public static void main(String[] args) throws IOException {
        // tạo dòng ghi(Stream writer)
        BufferedWriter writer = Files.newBufferedWriter(Paths.get("employee.json"));

        // tạo đối tượng employee thông qua map
        Map<String, Object> employee =  new HashMap<>();
        employee.put("id", 1);
        employee.put("name", "khac thanh");
        employee.put("email", "than@gmail.com");
        employee.put("age", 18);

        // tạo đối tượng Addres
        Map<String, Object> address = new HashMap<>();
        address.put("street", "ho tung mau");
        address.put("city", "hanoi");
        address.put("zipcode", 1000);

        // gán đối tượng tượng cho employee
        employee.put("address", address);

        Map<String, Object> pro1 = new HashMap<>();
        pro1.put("title", "java and json");
        pro1.put("budget", 2000);

        Map<String, Object> pro2 = new HashMap<>();
        pro2.put("title", "java and json2");
        pro2.put("budget", 20002);

        // gán project cho employee
        employee.put("project", Arrays.asList(pro1,pro2));

        // tạo đối tượng Gson
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        writer.write(gson.toJson(employee));
        writer.close();
    }
}
