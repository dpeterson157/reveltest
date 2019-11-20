package RESTService.Request;

import javax.ws.rs.client.ClientBuilder;

public class OpenWeatherMap_Forecast extends OpenWeatherMap {
    public OpenWeatherMap_Forecast () {
        this.client = ClientBuilder.newClient();
        this.target = client.target( this.getBaseUir() + "forecast")
                .queryParam("q", "minneapolis,us")
                .queryParam("units", "imperial")
                .queryParam("appid", this.getApiKey());
    }
}
