package JsonWeatherApp.weatherApp;

import com.github.cliftonlabs.json_simple.JsonObject;
import java.math.BigDecimal;

public class Coord {
    private Double lon;
    private Double lat;

    public Coord(JsonObject jsonObject) {
        this.lon = ((BigDecimal) jsonObject.get("lon")).doubleValue();
        this.lat = ((BigDecimal) jsonObject.get("lat")).doubleValue();
    }

    public Double getLon() {
        return lon;
    }

    public Double getLat() {
        return lat;
    }
}
