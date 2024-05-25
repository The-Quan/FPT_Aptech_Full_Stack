package jsonWeather;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class DeleteJson {
    private static final String DELETE_ID = "1";
    private static final String DELETE_URL = "https://656ae3dcdac3630cf7276592.mockapi.io/json/%s"; // URL của tài nguyên cần xóa
    private static String URL = String.format(DELETE_URL,DELETE_ID);

    public static void main(String[] args){
        try {
            URL url = new URL(URL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("DELETE");
            conn.setRequestProperty("Accept", "application/json");

            // Get response code
            int responseCode = conn.getResponseCode();
            System.out.println("DELETE Response Code :: " + responseCode);

            // Read response from the server
            if (responseCode == HttpURLConnection.HTTP_OK || responseCode == HttpURLConnection.HTTP_NO_CONTENT) { // 200 hoặc 204
                try (BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"))) {
                    String inputLine;
                    StringBuilder response = new StringBuilder();

                    while ((inputLine = in.readLine()) != null) {
                        response.append(inputLine);
                    }

                    // Print the response
                    System.out.println("Response: " + response);
                }
            } else {
                System.out.println("DELETE request not worked");
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
