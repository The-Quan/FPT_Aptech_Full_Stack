package JsonWeatherApp.weatherApp;

import java.util.ArrayList;
import java.util.List;
import com.github.cliftonlabs.json_simple.JsonArray;
import com.github.cliftonlabs.json_simple.JsonObject;
import java.math.BigDecimal;

public class Example {
    private Coord coord;
    private List<Weather> weather = new ArrayList<>();
    private String base;
    private Main main;
    private Integer visibility;
    private Wind wind;
    private Clouds clouds;
    private Integer dt;
    private Sys sys;
    private Integer timezone;
    private Integer id;
    private String name;
    private Integer cod;

    public Example(JsonObject jsonObject) {
        this.coord = new Coord((JsonObject) jsonObject.get("coord"));

        JsonArray weatherArray = (JsonArray) jsonObject.get("weather");
        for (Object weatherObj : weatherArray) {
            this.weather.add(new Weather((JsonObject) weatherObj));
        }

        this.base = (String) jsonObject.get("base");
        this.main = new Main((JsonObject) jsonObject.get("main"));
        this.visibility = convertToInteger(jsonObject.get("visibility"));
        this.wind = new Wind((JsonObject) jsonObject.get("wind"));
        this.clouds = new Clouds((JsonObject) jsonObject.get("clouds"));
        this.dt = convertToInteger(jsonObject.get("dt"));
        this.sys = new Sys((JsonObject) jsonObject.get("sys"));
        this.timezone = convertToInteger(jsonObject.get("timezone"));
        this.id = convertToInteger(jsonObject.get("id"));
        this.name = (String) jsonObject.get("name");
        this.cod = convertToInteger(jsonObject.get("cod"));
    }

    private Integer convertToInteger(Object value) {
        if (value instanceof BigDecimal) {
            return ((BigDecimal) value).intValue();
        } else if (value instanceof Long) {
            return ((Long) value).intValue();
        } else {
            return (Integer) value;
        }
    }

    public Coord getCoord() {
        return coord;
    }

    public List<Weather> getWeather() {
        return weather;
    }

    public String getBase() {
        return base;
    }

    public Main getMain() {
        return main;
    }

    public Integer getVisibility() {
        return visibility;
    }

    public Wind getWind() {
        return wind;
    }

    public Clouds getClouds() {
        return clouds;
    }

    public Integer getDt() {
        return dt;
    }

    public Sys getSys() {
        return sys;
    }

    public Integer getTimezone() {
        return timezone;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getCod() {
        return cod;
    }
}
