package JsonWeatherApp.weatherApp;

import com.github.cliftonlabs.json_simple.JsonObject;
import java.math.BigDecimal;

public class Weather {
    private Integer id;
    private String main;
    private String description;
    private String icon;

    public Weather(JsonObject jsonObject) {
        this.id = ((BigDecimal) jsonObject.get("id")).intValue();
        this.main = (String) jsonObject.get("main");
        this.description = (String) jsonObject.get("description");
        this.icon = (String) jsonObject.get("icon");
    }

    public Integer getId() {
        return id;
    }

    public String getMain() {
        return main;
    }

    public String getDescription() {
        return description;
    }

    public String getIcon() {
        return icon;
    }
}
