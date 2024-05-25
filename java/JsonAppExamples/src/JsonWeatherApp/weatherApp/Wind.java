package JsonWeatherApp.weatherApp;

import com.github.cliftonlabs.json_simple.JsonObject;
import java.math.BigDecimal;

public class Wind {
    private Double speed;
    private Integer deg;
    private Double gust;

    public Wind(JsonObject jsonObject) {
        this.speed = ((BigDecimal) jsonObject.get("speed")).doubleValue();
        this.deg = convertToInteger(jsonObject.get("deg"));
        this.gust = jsonObject.containsKey("gust") ? ((BigDecimal) jsonObject.get("gust")).doubleValue() : null;
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

    public Double getSpeed() {
        return speed;
    }

    public Integer getDeg() {
        return deg;
    }

    public Double getGust() {
        return gust;
    }
}
