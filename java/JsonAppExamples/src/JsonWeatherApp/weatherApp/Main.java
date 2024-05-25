package JsonWeatherApp.weatherApp;

import com.github.cliftonlabs.json_simple.JsonObject;
import java.math.BigDecimal;

public class Main {
    private Double temp;
    private Double feelsLike;
    private Double tempMin;
    private Double tempMax;
    private Integer pressure;
    private Integer humidity;
    private Integer seaLevel;
    private Integer grndLevel;

    public Main(JsonObject jsonObject) {
        this.temp = ((BigDecimal) jsonObject.get("temp")).doubleValue();
        this.feelsLike = ((BigDecimal) jsonObject.get("feels_like")).doubleValue();
        this.tempMin = ((BigDecimal) jsonObject.get("temp_min")).doubleValue();
        this.tempMax = ((BigDecimal) jsonObject.get("temp_max")).doubleValue();
        this.pressure = convertToInteger(jsonObject.get("pressure"));
        this.humidity = convertToInteger(jsonObject.get("humidity"));
        this.seaLevel = jsonObject.containsKey("sea_level") ? convertToInteger(jsonObject.get("sea_level")) : null;
        this.grndLevel = jsonObject.containsKey("grnd_level") ? convertToInteger(jsonObject.get("grnd_level")) : null;
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

    public Double getTemp() {
        return temp;
    }

    public Double getFeelsLike() {
        return feelsLike;
    }

    public Double getTempMin() {
        return tempMin;
    }

    public Double getTempMax() {
        return tempMax;
    }

    public Integer getPressure() {
        return pressure;
    }

    public Integer getHumidity() {
        return humidity;
    }

    public Integer getSeaLevel() {
        return seaLevel;
    }

    public Integer getGrndLevel() {
        return grndLevel;
    }
}
