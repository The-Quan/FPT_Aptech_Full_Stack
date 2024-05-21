package jsonWeather;

import com.github.cliftonlabs.json_simple.JsonArray;
import com.github.cliftonlabs.json_simple.JsonException;
import com.github.cliftonlabs.json_simple.JsonObject;
import com.github.cliftonlabs.json_simple.Jsoner;

import java.io.Reader;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;

public class Read_JsonWeather {
    public static void main(String[] args) throws JsonException {
        String URL = "{\n" +
                "  \"coord\": {\n" +
                "    \"lon\": 105.8412,\n" +
                "    \"lat\": 21.0245\n" +
                "  },\n" +
                "  \"weather\": [\n" +
                "    {\n" +
                "      \"id\": 802,\n" +
                "      \"main\": \"Clouds\",\n" +
                "      \"description\": \"scattered clouds\",\n" +
                "      \"icon\": \"03n\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"base\": \"stations\",\n" +
                "  \"main\": {\n" +
                "    \"temp\": 300.15,\n" +
                "    \"feels_like\": 303.58,\n" +
                "    \"temp_min\": 300.15,\n" +
                "    \"temp_max\": 300.15,\n" +
                "    \"pressure\": 1009,\n" +
                "    \"humidity\": 87,\n" +
                "    \"sea_level\": 1009,\n" +
                "    \"grnd_level\": 1007\n" +
                "  },\n" +
                "  \"visibility\": 10000,\n" +
                "  \"wind\": {\n" +
                "    \"speed\": 2.85,\n" +
                "    \"deg\": 136,\n" +
                "    \"gust\": 5.94\n" +
                "  },\n" +
                "  \"clouds\": {\n" +
                "    \"all\": 46\n" +
                "  },\n" +
                "  \"dt\": 1716299718,\n" +
                "  \"sys\": {\n" +
                "    \"type\": 1,\n" +
                "    \"id\": 9308,\n" +
                "    \"country\": \"VN\",\n" +
                "    \"sunrise\": 1716243420,\n" +
                "    \"sunset\": 1716290985\n" +
                "  },\n" +
                "  \"timezone\": 25200,\n" +
                "  \"id\": 1581130,\n" +
                "  \"name\": \"Hanoi\",\n" +
                "  \"cod\": 200\n" +
                "}";
        JsonObject parser = (JsonObject) Jsoner.deserialize(URL);
        String base = (String) parser.get("base");
        BigDecimal visibility = (BigDecimal) parser.get("visibility");
        BigDecimal dt = (BigDecimal) parser.get("dt");
        BigDecimal id = (BigDecimal) parser.get("id");
        BigDecimal timezone = (BigDecimal) parser.get("timezone");
        String name = (String) parser.get("name");
        BigDecimal cod = (BigDecimal) parser.get("cod");

        System.out.println("base: " + base+ "\n" +"visibility: " + visibility+ "\n" +"dt: " + dt+ "\n" +"timezone: " + timezone+ "\n" + "id: "+ id+ "\n" +"name: " + name + "\n"+"cod: "+ cod);

        Map<Object, Object> coord = (Map<Object, Object>) parser.get("coord");
        coord.forEach((key, value) -> System.out.println(key + ": " + value));

        JsonArray weather = (JsonArray) parser.get("weather");
        weather.forEach(entry -> {
            JsonObject weathers = (JsonObject) entry;
            System.out.println("id: " + weathers.get("id"));
            System.out.println("main: " + weathers.get("main"));
            System.out.println("description: " + weathers.get("description"));
            System.out.println("icon: " + weathers.get("icon"));
        });

        Map<Object, Object> main = (Map<Object, Object>) parser.get("main");
        main.forEach((key, value) -> System.out.println(key + ": " + value));

        Map<Object, Object> wind = (Map<Object, Object>) parser.get("main");
        wind.forEach((key, value) -> System.out.println(key + ": " + value));

        Map<Object, Object> clouds = (Map<Object, Object>) parser.get("clouds");
        clouds.forEach((key, value) -> System.out.println(key + ": " + value));

        Map<Object, Object> sys = (Map<Object, Object>) parser.get("sys");
        sys.forEach((key, value) -> System.out.println(key + ": " + value));

    }

}
