package json;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class PostJson {
    private static final String POST_URL = "https://656ae3dcdac3630cf7276592.mockapi.io/json";

    public static void main(String[] args) {
        try {
            URL url = new URL(POST_URL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json; utf-8");
            conn.setRequestProperty("Accept", "application/json");
            conn.setDoOutput(true);

            // Create JSON Object
            JsonObject jsonInput = new JsonObject();
            jsonInput.addProperty("id", 11);
            jsonInput.addProperty("name", "binh"); // Thêm tên vào đây
            jsonInput.addProperty("address", "hanoi"); // Thêm địa chỉ vào đây
            jsonInput.addProperty("email", "binh@gmail.com"); // Thêm email vào đây

            // Write JSON input to OutputStreamWriter
            try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream(), "UTF-8"))) {
                writer.write(jsonInput.toString());
                writer.flush();
            }

            // Get response code
            int responseCode = conn.getResponseCode();
            System.out.println("POST Response Code :: " + responseCode);

            // Read response from the server
            if (responseCode == HttpURLConnection.HTTP_CREATED) { // 201
                try (BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"))) {
                    String inputLine;
                    StringBuilder response = new StringBuilder();

                    while ((inputLine = in.readLine()) != null) {
                        response.append(inputLine);
                    }

                    // Print the response
                    System.out.println("Response: " + response);

                    // Parse the JSON response
                    JsonObject jsonResponse = JsonParser.parseString(response.toString()).getAsJsonObject();
                    System.out.println("id: " + jsonResponse.get("id").getAsString());
                    System.out.println("name: " + jsonResponse.get("name").getAsString());
                    System.out.println("address: " + jsonResponse.get("address").getAsString());
                    System.out.println("email: " + jsonResponse.get("email").getAsString());
                }
            } else {
                System.out.println("POST request not worked");
                try (BufferedReader in = new BufferedReader(new InputStreamReader(conn.getErrorStream(), "UTF-8"))) {
                    String inputLine;
                    StringBuilder response = new StringBuilder();

                    while ((inputLine = in.readLine()) != null) {
                        response.append(inputLine);
                    }

                    // Print the error response
                    System.out.println("Error Response: " + response.toString());
                }
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
