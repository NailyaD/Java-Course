import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.URL;

public class WeatherDemo {
    public static void main(String[] args) throws Exception {
        String urlString = "http://api.openweathermap.org/data/2.5/weather?id=2950159&appid=b7a37987a8cf75738baa1d0ae59b9d4c";
        ObjectMapper mapper = new ObjectMapper();
        WeatherForecast wf = mapper.readValue(new URL(urlString), WeatherForecast.class);
        System.out.println(wf);
    }
}
