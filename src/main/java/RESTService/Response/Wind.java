package RESTService.Response;

import org.json.simple.JSONObject;

public class Wind {
    private Double speed;
    private Double deg;

    public Double getSpeed() { return this.speed; }
    public void setSpeed(String speed) { this.setSpeed(Double.parseDouble(speed));}
    public void setSpeed(Double speed) { this.speed = speed; }

    public Double getDeg() { return this.deg; }
    public void setDeg(String deg) { this.setDeg(Double.parseDouble(deg));}
    public void setDeg(Double deg) { this.deg = deg; }

    public static Wind parseWind(JSONObject json) {
        Wind wind = new Wind();

        wind.setSpeed(String.valueOf(json.get("speed")));
        wind.setDeg(String.valueOf(json.get("deg")));

        return wind;
    }
}
