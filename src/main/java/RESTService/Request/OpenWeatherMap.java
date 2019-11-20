package RESTService.Request;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;

public abstract class OpenWeatherMap {
    private final String DFLT_APIKEY = "8f1409558f3fb084cae301073be4ce97"; // my personal api key
    private final String DFLT_BASEURI = "http://api.openweathermap.org/data/2.5/";

    protected Client client;
    protected WebTarget target;
    private String apiKey;
    private String baseUri;
    private String requestName;

    public OpenWeatherMap() {
        this.apiKey = DFLT_APIKEY;
        this.baseUri = DFLT_BASEURI;
    }

    public Response execute() {
        return this.target.request(MediaType.APPLICATION_JSON).get();
    }

    public String getApiKey() { return this.apiKey; }
    public void setApiKey(String key) { this.apiKey = key; }

    public String getBaseUir() { return  this.baseUri; }
    public void  setBaseUri(String uri) { this.baseUri = uri; }

    public String getRequestName() { return  this.requestName; }
    public void setRequestName(String name) { this.requestName = name; }
}
