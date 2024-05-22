package testJson;

import com.github.cliftonlabs.json_simple.JsonArray;
import com.github.cliftonlabs.json_simple.JsonObject;
import com.github.cliftonlabs.json_simple.Jsoner;

import java.io.BufferedWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

public class writeJson {
    public static void main(String[] args) throws IOException {
        BufferedWriter writer = Files.newBufferedWriter(Path.of("storeShoe.json"));

        JsonObject customer = new JsonObject();
        customer.put("id",1);
        customer.put("name", "binh");
        customer.put("email", "binh@gmail.com");
        customer.put("sdt","0948694563");

        JsonObject address = new JsonObject();
        address.put("street", "ho tay");
        address.put("city", "ha noi");
        address.put("zipcode", 10043);

        customer.put("address", address);

        JsonArray product = new JsonArray();

        JsonObject shoe = new JsonObject();
        shoe.put("id", 1);
        shoe.put("name", "jordan");
        shoe.put("price", 19.9);

        JsonObject shoe2 = new JsonObject();
        shoe2.put("id", 2);
        shoe2.put("name", "jordan2");
        shoe2.put("price", 19.9);

        JsonObject shoe3 = new JsonObject();
        shoe3.put("id", 3);
        shoe3.put("name", "jordan3");
        shoe3.put("price", 19.9);

        product.addAll(Arrays.asList(shoe, shoe2, shoe3));
        customer.put("product", product);


        Jsoner.serialize(customer,writer);
        writer.close();
    }
}
