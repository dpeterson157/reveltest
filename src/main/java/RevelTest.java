import RESTService.Report.Report;
import RESTService.Request.OpenWeatherMap_Forecast;
import RESTService.Response.ForecastDetails;
import RESTService.Response.ForecastResponse;
import RESTService.Response.Weather;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.util.ArrayList;

public class RevelTest {

    public static void main(String[] args) {
        OpenWeatherMap_Forecast owm = new OpenWeatherMap_Forecast();
        String responseString = owm.execute().readEntity(String.class);

        JSONObject jo = null;
        try {
            Object obj = new JSONParser().parse(responseString);
            jo = (JSONObject) obj;
        } catch (Exception e) {}

        ForecastResponse fr = null;
        try {
            fr = ForecastResponse.parseResponse((jo));
            setTestValues(fr);
        } catch (Exception e) {}

        Report report = new Report();
        report.generate(fr);
    }

    // Use this function to set test values when the weather isn't cooperating.
    private static void setTestValues(ForecastResponse fr) {
        ArrayList<ForecastDetails> fdList = fr.getList();

        setTestConditions(fr, 0, "54.9", "Clear"); // sb phone
        setTestConditions(fr, 1, "65.0", "Rain"); // sb phone
        setTestConditions(fr, 2, "75.1", "Rain"); // sb phone
        setTestConditions(fr, 3, "65.0", "Clear"); // sb email
        setTestConditions(fr, 4, "75.0", "Clouds"); // sb email
        setTestConditions(fr, 5, "75.1", "Clear"); // sb text
        setTestConditions(fr, 6, "75.1", "Clouds"); // sb discretion
    }

    public static void setTestConditions(ForecastResponse fr, int index, String temperature, String conditions) {
        ArrayList<ForecastDetails> fdList = fr.getList();
        ForecastDetails fd = fdList.get(index);
        fd.getMain().setTemp(temperature);

        ArrayList<Weather> weatherList = fd.getWeather();
        weatherList.get(0).setMain(conditions);
        fd.setWeather(weatherList);

        fr.setList(fdList);
    }
}
