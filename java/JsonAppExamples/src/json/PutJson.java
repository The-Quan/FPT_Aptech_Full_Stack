package json;
import com.google.gson.JsonObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class PutJson {
    private static final String PUT_URL = "https://656ae3dcdac3630cf7276592.mockapi.io/json";

    public static void main(String[] args) {
        try {
            URL url = new URL(PUT_URL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("PUT");
            conn.setRequestProperty("Content-Type", "application/json; utf-8");
            conn.setRequestProperty("Accept", "application/json");
            conn.setDoOutput(true);

            // Create JSON Object
            JsonObject jsonInput = new JsonObject();
            jsonInput.addProperty("id", 1);
            jsonInput.addProperty("name", "John Doe");
            jsonInput.addProperty("address", "123 Main St");
            jsonInput.addProperty("email", "john.doe@example.com");

            // Write JSON input to OutputStreamWriter
            try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream(), "UTF-8"))) {
                writer.write(jsonInput.toString());
                writer.flush();
            }

            // Get response code
            int responseCode = conn.getResponseCode();
            System.out.println("PUT Response Code :: " + responseCode);

            // Read response from the server
            try (BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"))) {
                String inputLine;
                StringBuilder response = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }

                // Print the response
                System.out.println("Response: " + response);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
