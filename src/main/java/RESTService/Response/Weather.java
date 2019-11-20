package RESTService.Response;

import org.json.simple.JSONObject;

import javax.persistence.criteria.CriteriaBuilder;

public class Weather {
    private int id;
    private String main;
    private String description;
    private String icon;

    public int getId() { return this.id; }
    public void setId(String id) { this.setId(Integer.parseInt(id)); }
    public void setId(int id) { this.id = id; }

    public String getMain() { return this.main; }
    public void setMain(String main) { this.main = main; }

    public String getDescription(String description) { return this.description; }
    public void setDescription(String description ) { this.description = description; }

    public String getIcon() { return this.icon; }
    public void setIcon(String icon ) { this.icon = icon; }

    public static Weather parseWeather(JSONObject json) {
        Weather weather = new Weather();

        weather.setId(String.valueOf(json.get("id")));
        weather.setMain((String)json.get("main"));
        weather.setDescription((String)json.get("description"));
        weather.setIcon((String)json.get("icon"));

        return weather;
    }
}
