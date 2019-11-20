package RESTService.Response;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;

public class ForecastResponse {
    private int code;
    private Long message;
    private City city;
    private int cnt;
    private ArrayList<ForecastDetails> list = new ArrayList<ForecastDetails>();
    
    public int getCode() { return this.code; }
    public void setCode(String code) { this.setCode(Integer.parseInt(code)); }
    public void setCode(int code) { this.code = code; }
    
    public Long getMessage() { return this.message; }
    public void setMessage(String message) { this.setMessage(Long.parseLong(message)); }
    public void setMessage(Long message) { this.message = message; }
    
    public City getCity() { return this.city; }
    public void setCity(JSONObject city) { this.setCity(City.parseCity(city)); }
    public void setCity(City city) { this.city = city; }

    public int getCnt() { return this.cnt; }
    public void setCnt(String cnt) { this.setCnt(Integer.parseInt(cnt)); }
    public void setCnt(int cnt) { this.cnt = cnt; }

    public ArrayList<ForecastDetails> getList() { return this.list; }
    public void setList(ArrayList<ForecastDetails> list) { this.list = list; } // only included to set up test data

    public static ForecastResponse parseResponse(JSONObject json) throws Exception
    {
        ForecastResponse fr = new ForecastResponse();

        fr.setCode(String.valueOf(json.get("cod")));
        fr.setMessage(String.valueOf(json.get("message")));
        fr.setCity((JSONObject)json.get("city"));
        fr.setCnt(String.valueOf(json.get("cnt")));

        JSONArray jaList = (JSONArray)json.get("list");
        Iterator jai = jaList.iterator();

        while (jai.hasNext()) {
            fr.list.add(ForecastDetails.parseForecastDetails((JSONObject)jai.next()));
        }
        return fr;
    }
}
