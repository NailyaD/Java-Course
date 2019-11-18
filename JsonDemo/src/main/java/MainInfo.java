import com.fasterxml.jackson.annotation.JsonProperty;

public class MainInfo {
    private int temp;
    private int pressure;
    private int humidity;
    @JsonProperty("temp_min")
    private int tempMin;
    @JsonProperty("temp_max")
    private int tempMax;

    public MainInfo(int temp, int pressure, int humidity, int tempMin, int tempMax) {
        this.temp = temp;
        this.pressure = pressure;
        this.humidity = humidity;
        this.tempMin = tempMin;
        this.tempMax = tempMax;
    }

    public MainInfo() {

    }

    public void setTemp(int temp) {
        this.temp = (int)(temp - 273.15);
    }

    public void setPressure(int pressure) {
        this.pressure = pressure;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public void setTempMin(int tempMin) {
        this.tempMin = (int)(tempMin - 273.15);
    }

    public void setTempMax(int tempMax) {
        this.tempMax = (int)(tempMax - 273.15);
    }

    @Override
    public String toString() {
        return  "Temperature: " + temp + "°C" +
                ", Pressure: " + pressure + " hPa" +
                ", Humidity: " + humidity + "%" +
                ", Minimum Temperature: " + tempMin + "°C" +
                ", Maximum Temperature: " + tempMax + "°C";
    }
}
