package jsonSimple;

import com.github.cliftonlabs.json_simple.JsonArray;
import com.github.cliftonlabs.json_simple.JsonObject;
import com.github.cliftonlabs.json_simple.Jsoner;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class Write_JSON_Simple {
    public static void main(String[] args) throws IOException {
        //Tạo ra dòng Ghi dữ liệu(Writer)
        BufferedWriter writer = Files.newBufferedWriter(Paths.get("employee.json")); //sử dụng để tạo đối tượng BufferedWriter ghi vào tệp có tên "employee.json"
        //Tạo đối tượng employee
        JsonObject employee = new JsonObject(); // tạo một đối tượng json
        employee.put("id",1);
        employee.put("name","Truong Gia Binh");
        employee.put("email","binh@gmail.com");
        employee.put("age",18);

//        employee.put("address","So 8 Ton That Thuyet");

        //Tạo ra đối tượng Address
        JsonObject address = new JsonObject();
        address.put("street","so 8 Ton That Thuyet");
        address.put("city","ha noi");
        address.put("zipcode",10000);

        //Thêm Address vào Object employee
        employee.put("address",address);

        //Tạo đối tượng project
        JsonArray projects = new JsonArray();//1-N(employee - projects)

        //Tạo đối tượng dự án số 1
        JsonObject pro1 = new JsonObject();
        pro1.put("title","Employee management");
        pro1.put("budget",5000);

        //Thêm project
        JsonObject pro2 = new JsonObject();
        pro2.put("title","push sale");
        pro2.put("budget",10000);

        JsonObject pro3 = new JsonObject();
        pro3.put("title","Shop ecommerce");
        pro3.put("budget",15000);
        //Add pro1,2 to projects

        projects.addAll(Arrays.asList(pro1,pro2,pro3));

        //Add projects to employee
        employee.put("projects",projects);

        //Ghi file json
        Jsoner.serialize(employee,writer);//ghi ra file json thong tin cua employee
        //sau khi ghi xong thi close dong  writer
        writer.close();
    }
}
