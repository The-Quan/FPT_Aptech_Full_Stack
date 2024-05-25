package JsonWeatherApp.weatherApp;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;

import com.github.cliftonlabs.json_simple.JsonObject;
import com.github.cliftonlabs.json_simple.Jsoner;

public class WeatherApp {
    public static void main(String[] args) {
        String apiKey = "7c64a73a6425d6d05389234c8e5161d5";
        String city = "Hanoi";
        String urlString = "https://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=" + apiKey + "&units=metric";

        try {
            URI uri = new URI(urlString);
            URL url = uri.toURL();
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            InputStreamReader reader = new InputStreamReader(connection.getInputStream());

            JsonObject jsonObject = (JsonObject) Jsoner.deserialize(reader);
            Example example = new Example(jsonObject);

            // Display data
            System.out.println("Location: " + example.getName() + ", " + example.getSys().getCountry());
            System.out.println("Coordinates: " + example.getCoord().getLat() + ", " + example.getCoord().getLon());
            System.out.println("Weather: " + example.getWeather().get(0).getMain() + " (" + example.getWeather().get(0).getDescription() + ")");
            System.out.println("Temperature: " + example.getMain().getTemp() + "C, Feels like: " + example.getMain().getFeelsLike() + "K");
            System.out.println("Pressure: " + example.getMain().getPressure() + " hPa");
            System.out.println("Humidity: " + example.getMain().getHumidity() + "%");
            System.out.println("Wind: " + example.getWind().getSpeed() + " m/s, " + example.getWind().getDeg() + "°");
            System.out.println("Cloudiness: " + example.getClouds().getAll() + "%");
            System.out.println("Sunrise: " + example.getSys().getSunrise());
            System.out.println("Sunset: " + example.getSys().getSunset());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
