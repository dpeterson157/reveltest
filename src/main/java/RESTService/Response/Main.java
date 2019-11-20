package RESTService.Response;

import org.json.simple.JSONObject;

public class Main {
    private Double temp;
    private Double tempMin;
    private Double tempMax;
    private Double pressure;
    private Double seaLevel;
    private Double grndLevel;
    private int humidity;
    private Double tempKf;

    public Double getTemp() { return this.temp; }
    public void setTemp(String temp) {this.setTemp(Double.parseDouble(temp)); }
    public void setTemp(Double temp) { this.temp = temp; }

    public Double getTempMin() { return this.tempMin; }
    public void setTempMin(String temp_min) {this.setTempMin(Double.parseDouble(temp_min)); }
    public void setTempMin(Double temp_min) { this.tempMin = temp_min; }

    public Double getTempMax() { return this.tempMax; }
    public void setTempMax(String temp_max) {this.setTempMax(Double.parseDouble(temp_max)); }
    public void setTempMax(Double tempMax) { this.tempMax = tempMax; }

    public Double getPressure() { return this.pressure; }
    public void setPressure(String pressure) {this.setPressure(Double.parseDouble(pressure)); }
    public void setPressure(Double pressure) { this.pressure = pressure; }

    public Double getSeaLevel() { return this.seaLevel; }
    public void setSeaLevel(String seaLevel) {this.setSeaLevel(Double.parseDouble(seaLevel)); }
    public void setSeaLevel(Double seaLevel) { this.seaLevel = seaLevel; }

    public Double getGrndLevel() { return this.grndLevel; }
    public void setGrndLevel(String grndLevel) {this.setGrndLevel(Double.parseDouble(grndLevel)); }
    public void setGrndLevel(Double grndLevel) { this.grndLevel = grndLevel; }

    public int getHumidity() { return this.humidity; }
    public void setHumidity(String humidity) {this.setHumidity(Integer.parseInt(humidity)); }
    public void setHumidity(int humidity) { this.humidity = humidity; }

    public Double getTempKf() { return this.tempKf; }
    public void setTempKf(String tempKf) {this.setTempKf(Double.parseDouble(tempKf)); }
    public void setTempKf(Double tempKf) { this.tempKf = tempKf; }

    public static Main parseMain(JSONObject json) {
        Main main = new Main();

        main.setTemp(String.valueOf(json.get("temp")));
        main.setTempMin(String.valueOf(json.get("temp_min")));
        main.setTempMax(String.valueOf(json.get("temp_max")));
        main.setPressure(String.valueOf(json.get("pressure")));
        main.setSeaLevel(String.valueOf(json.get("sea_level")));
        main.setGrndLevel(String.valueOf(json.get("grnd_level")));
        main.setHumidity(String.valueOf(json.get("humidity")));
        main.setTempKf(String.valueOf(json.get("temp_kf")));

        return main;
    }
}
