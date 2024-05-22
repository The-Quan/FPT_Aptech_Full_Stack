package jsonSimple;

import com.github.cliftonlabs.json_simple.JsonArray;
import com.github.cliftonlabs.json_simple.JsonException;
import com.github.cliftonlabs.json_simple.JsonObject;
import com.github.cliftonlabs.json_simple.Jsoner;
import java.io.IOException;
import java.io.Reader;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

public class Read_JSON_Simple {
    public static void main(String[] args) throws IOException, JsonException {
        // tạo dòng Reader
        Reader reader = Files.newBufferedReader(Paths.get("employee.json"));

        // đọc object từ dòng (stream)
        JsonObject parser = (JsonObject) Jsoner.deserialize(reader); // deserialize (giải mã) dữ liệu từ một luồng đầu vào thành một đối tượng JsonObject.
        // deserialize là quá trình chuyển đổi dữ liệu từ định dạng chuỗi (string) hoặc một định dạng khác như JSON, XML,
        // hoặc nhị phân (binary) trở lại thành các đối tượng có thể được sử dụng trong mã nguồn.

        // read employee detail
        BigDecimal id = (BigDecimal) parser.get("id");
        String name = (String) parser.get("name");
        String email = (String) parser.get("email");
        BigDecimal age = (BigDecimal) parser.get("age");

        System.out.println(id + name + email + age);

        // read address
        Map<Object, Object> address = (Map<Object, Object>) parser.get("address");
        address.forEach((key, value) -> System.out.println(key + ": " + value));

        // read
        JsonArray project = (JsonArray) parser.get("projects");
        project.forEach(entry -> {
            JsonObject project1 = (JsonObject) entry;
            System.out.println(project1.get("title"));
            System.out.println(project1.get("budget"));
        });

        // đóng lại stream sau khi dung xong
        reader.close();
    }
}
