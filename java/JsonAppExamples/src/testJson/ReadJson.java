package testJson;

import com.github.cliftonlabs.json_simple.JsonArray;
import com.github.cliftonlabs.json_simple.JsonException;
import com.github.cliftonlabs.json_simple.JsonObject;
import com.github.cliftonlabs.json_simple.Jsoner;
import com.sun.jdi.Value;

import java.io.IOException;
import java.io.Reader;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.Key;
import java.util.Map;

public class ReadJson {
    public static void main(String[] args) throws JsonException, IOException {
        Reader reader = Files.newBufferedReader(Path.of("storeShoe.json"));

        JsonObject parser = (JsonObject) Jsoner.deserialize(reader);

        BigDecimal id = (BigDecimal) parser.get("id");
        String name = (String) parser.get("name");
        String email = (String) parser.get("email");
        String sdt = (String) parser.get("sdt");

        System.out.println("id: " + id);
        System.out.println("name: " + name);
        System.out.println("email: " + email);
        System.out.println("sdt: " + sdt);
        System.out.println();

        Map<Object, Object> address = (Map<Object, Object>) parser.get("address");
        address.forEach((Key, Value) -> System.out.println(Key + ": " + Value));
        System.out.println();

        JsonArray product = (JsonArray) parser.get("product");
        product.forEach(entry ->{
            JsonObject products = (JsonObject) entry;
            System.out.println(products.get("id"));
            System.out.println(products.get("name"));
            System.out.println(products.get("price"));
            System.out.println();
        });
        reader.close();
    }
}
