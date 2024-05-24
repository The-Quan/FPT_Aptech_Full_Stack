package datebaseJson;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class JsonWriter {
    public static void writeUserToJson(List<User> users, String filePath) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        FileWriter writer = new FileWriter(filePath);
        gson.toJson(users,writer);
        writer.close();
    }
}
