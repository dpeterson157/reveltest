package RESTService.Response;

import org.json.simple.JSONObject;

public class City {
    private int id;
    private String name;
    private Coord coord;
    private String country;
    private int timezone;

    public int getId() { return this.id; }
    public void setId(String id) { this.setId(Integer.parseInt(id)); }
    public void setId(int id) { this.id = id; }

    public String getName() { return this.name; }
    public void setName(String name) { this.name = name; }

    public Coord getCoord() { return this.coord; }
    public void setCoord(JSONObject json) { this.setCoord(Coord.parseCoord(json));}
    public void setCoord(Coord coord) { this.coord = coord; }

    public String getCountry() { return this.country; }
    public void setCountry(String country) { this.country = country; }

    public int getTimezone() { return this.timezone; }
    public void setTimezone(String timezone) { this.setTimezone(Integer.parseInt(timezone));}
    public void setTimezone(int timezone) { this.timezone = timezone; }

    public static City parseCity(JSONObject json) {
        City city = new City();

        city.setId(String.valueOf(json.get("id")));
        city.setName((String)json.get("name"));
        city.setCoord(Coord.parseCoord((JSONObject)json.get("coord")));
        city.setCountry((String)json.get("country"));
        city.setTimezone(String.valueOf(json.get("timezone")));

        return city;
    }
}

