package datebaseJson;


import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class Application {
    public static void main(String[] args) throws SQLException, IOException {
        // list user from database
        List<User> users = ConnectionDB.getUser();
        // ghi user to json file
        String filePath = "user.json";
        JsonWriter.writeUserToJson(users,filePath);
        System.out.println(users);
        System.out.println("data has been written to " + filePath);
    }
}
