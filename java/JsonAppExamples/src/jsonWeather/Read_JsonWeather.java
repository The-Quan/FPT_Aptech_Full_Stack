package jsonWeather;


import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


public class Read_JsonWeather {
    private static final String keyApi = "3788f82a251a02fb59b91dec288d6e7c";
    private static final String urlApi = " https://api.openweathermap.org/data/2.5/weather?q=%s&appid=%s&units=metric";

    public static void main(String[] args) throws MalformedURLException {
        String city = "hanoi";
        try {
            String urlString = String.format(urlApi, city, keyApi);
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            int responseCode = connection.getResponseCode();
            if (responseCode == 200) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();
                while ((inputLine = reader.readLine()) != null) {
                    response.append(inputLine);
                }
                reader.close();

                JsonObject jsonResponse = JsonParser.parseString(response.toString()).getAsJsonObject();
                JsonObject main = jsonResponse.getAsJsonObject("main");
                JsonObject coord = jsonResponse.getAsJsonObject("coord");
                JsonObject clouds = jsonResponse.getAsJsonObject("clouds");
                JsonObject wind = jsonResponse.getAsJsonObject("wind");
                JsonObject sys = jsonResponse.getAsJsonObject("sys");
                JsonArray weather = jsonResponse.getAsJsonArray("weather");

                System.out.println("----- Main -----");
                main.entrySet().forEach((entry -> System.out.println(entry.getKey() + ": " + entry.getValue())));
                System.out.println("----- Coord -----");
                coord.entrySet().forEach((entry -> System.out.println(entry.getKey() + ": " + entry.getValue())));
                System.out.println("----- Clouds -----");
                clouds.entrySet().forEach((entry -> System.out.println(entry.getKey() + ": " + entry.getValue())));
                System.out.println("----- wind -----");
                wind.entrySet().forEach((entry -> System.out.println(entry.getKey() + ": " + entry.getValue())));
                System.out.println("----- Sys -----");
                sys.entrySet().forEach((entry -> System.out.println(entry.getKey() + ": " + entry.getValue())));
                System.out.println("----- weather -----");
                weather.forEach((entry -> {
                    JsonObject weather1 = (JsonObject) entry;
                    System.out.println("id: " + weather1.get("id"));
                    System.out.println("main: " + weather1.get("main"));
                    System.out.println("description: " + weather1.get("description"));
                    System.out.println("icon: " + weather1.get("icon"));


                }));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


}
