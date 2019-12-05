import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherGeneralInfo {
    private String main;
    private String description;

    public WeatherGeneralInfo(String main, String description) {
        this.main = main;
        this.description = description;
    }

    public WeatherGeneralInfo() {

    }
    public void setMain(String main) {
        this.main = main;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Main info: " + main + ", " +
                "Description: " + description;
    }
}
