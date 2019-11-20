package RESTService.Response;

import org.json.simple.JSONObject;

public class Coord {
    private Double lat;
    private Double lon;

    public Double getLat() { return this.lat; }
    public void setLat(String lat) { this.setLat(Double.parseDouble(lat)); }
    public void setLat(Double lat) { this.lat = lat; }

    public Double getLon() { return this.lon; }
    public void setLon(String lon) { this.setLon(Double.parseDouble(lon)); }
    public void setLon(Double lon) { this.lon = lon; }

    public static Coord parseCoord(JSONObject json) {
        Coord coord = new Coord();

        coord.setLat(String.valueOf(json.get("lat")));
        coord.setLon(String.valueOf(json.get("lon")));

        return coord;
    }
}
