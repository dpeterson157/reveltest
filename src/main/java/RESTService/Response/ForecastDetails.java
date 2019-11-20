package RESTService.Response;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

public class ForecastDetails {
    private long dt;
    private Main main;
    private ArrayList<Weather> weather = new ArrayList<Weather>();
    private String clouds;
    private Wind wind;
    private int rain;
    private int snow;
    private Date dtTxt;

    public long getDt() { return this.dt; }
    public void setDt(String dt) { this.setDt(Long.parseLong(dt)); }
    public void setDt(long dt) { this.dt = dt; }

    public Main getMain() { return this.main; }
    public void setMain(JSONObject json) { this.setMain(Main.parseMain(json)); }
    public void setMain(Main main) { this.main = main; }

    public ArrayList<Weather> getWeather() { return this.weather; }
    public void setWeather(ArrayList<Weather> list) { this.weather = list; } // only included for testing

    public String getClouds() { return this.clouds; }
    public void setClouds(String clouds) { this.clouds = clouds; }

    public Wind getWind() { return  this.wind; }
    public void setWind(JSONObject json) { this.setWind(Wind.parseWind(json)); }
    public void setWind(Wind wind) { this.wind = wind; }

    public int getRain() { return this.rain; }
    public void setRain(String rain) { this.setRain(Integer.parseInt(rain)); }
    public void setRain(int rain) { this.rain = rain; }

    public int getSnow() { return this.snow; }
    public void setSnow(String snow) { this.setSnow(Integer.parseInt(snow)); }
    public void setSnow(int snow) { this.snow = snow; }

    public Date getDtTxt() { return this.dtTxt; }
    public void setDtTxt(String dtTxt) throws Exception
    {
        this.setDtTxt(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(dtTxt));
    }
    public void setDtTxt(Date dtTxt) { this.dtTxt = dtTxt; }

    public static ForecastDetails parseForecastDetails(JSONObject json) throws Exception
    {
        ForecastDetails fd = new ForecastDetails();

        // If certain weather details were not captured or recorded for a given day, they are
        // just not included in the message, which can cause NPE's. This is not the most elegant
        // of solutions, but it works for now.
        try { fd.setDt(String.valueOf(json.get("dt"))); } catch (Exception e) {}
        try { fd.setMain(Main.parseMain((JSONObject) json.get("main"))); } catch (Exception e) {}
        try { fd.setClouds(String.valueOf(json.get("clouds"))); } catch (Exception e) {}
        try { fd.setWind(Wind.parseWind((JSONObject) json.get("wind"))); } catch (Exception e) {}
        try { fd.setRain(String.valueOf(json.get("rain"))); } catch (Exception e) {}
        try { fd.setSnow(String.valueOf(json.get("snow"))); } catch (Exception e) {}
        try { fd.setDtTxt(String.valueOf(json.get("dt_txt"))); } catch (Exception e) {}

        if (json.get("weather") != null) {
            JSONArray jaWeather = (JSONArray) json.get("weather");
            Iterator jaw = jaWeather.iterator();
            while (jaw.hasNext()) {
                fd.weather.add(Weather.parseWeather((JSONObject) jaw.next()));
            }
        }

        return fd;
    }
}
