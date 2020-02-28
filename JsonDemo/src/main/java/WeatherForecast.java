import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherForecast {
    private List<WeatherGeneralInfo> weatherGeneralInfo;
    private MainInfo mainInfo;
    private int visibility;
    private String name;

    public WeatherForecast(List<WeatherGeneralInfo> weatherGeneralInfo, MainInfo mainInfo, int visibility, String name) {
        this.weatherGeneralInfo = weatherGeneralInfo;
        this.mainInfo = mainInfo;
        this.visibility = visibility;
        this.name = name;
    }

    public WeatherForecast() {

    }
    @JsonSetter("weather")
    public void setWeatherGeneralInfo(List<WeatherGeneralInfo> weatherGeneralInfo) {
        this.weatherGeneralInfo = weatherGeneralInfo;
    }

    @JsonSetter("main")
    public void setMainInfo(MainInfo mainInfo) {
        this.mainInfo = mainInfo;
    }

    public void setVisibility(int visibility) {
        this.visibility = visibility;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "WeatherForecast: " + '\n' +
                "City name: " + name + '\n' +
                "Weather General Info: " + weatherGeneralInfo + '\n' +
                "Main info: " + mainInfo + '\n' +
                "Visibility: " + visibility + " m";
    }
}
