package JsonWeatherApp.weatherApp;

import com.github.cliftonlabs.json_simple.JsonObject;
import java.math.BigDecimal;

public class Sys {
    private Integer type;
    private Integer id;
    private String country;
    private Integer sunrise;
    private Integer sunset;

    public Sys(JsonObject jsonObject) {
        this.type = jsonObject.containsKey("type") ? convertToInteger(jsonObject.get("type")) : null;
        this.id = jsonObject.containsKey("id") ? convertToInteger(jsonObject.get("id")) : null;
        this.country = (String) jsonObject.get("country");
        this.sunrise = convertToInteger(jsonObject.get("sunrise"));
        this.sunset = convertToInteger(jsonObject.get("sunset"));
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

    public Integer getType() {
        return type;
    }

    public Integer getId() {
        return id;
    }

    public String getCountry() {
        return country;
    }

    public Integer getSunrise() {
        return sunrise;
    }

    public Integer getSunset() {
        return sunset;
    }
}
