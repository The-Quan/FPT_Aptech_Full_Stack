package JsonWeatherApp.weatherApp;

import com.github.cliftonlabs.json_simple.JsonObject;
import java.math.BigDecimal;

public class Clouds {
    private Integer all;

    public Clouds(JsonObject jsonObject) {
        this.all = convertToInteger(jsonObject.get("all"));
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

    public Integer getAll() {
        return all;
    }
}
