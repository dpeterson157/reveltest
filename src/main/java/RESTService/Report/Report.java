package RESTService.Report;

import RESTService.Response.ForecastDetails;
import RESTService.Response.ForecastResponse;
import RESTService.Response.Weather;

import java.text.SimpleDateFormat;

public class Report {

    public void generate(ForecastResponse fr) {
        System.out.println(this.title(fr));

        for(ForecastDetails fd : fr.getList()) {
            System.out.println(this.record(fd));
        }
    }

    public String title(ForecastResponse fr) {
        String tmplt = "\nOutreach report for %s, %s:\n";
        return String.format(tmplt, fr.getCity().getName(), fr.getCity().getCountry());
    }

    public String record(ForecastDetails fd) {
        String tmplt = "Date/Time: %s \tTemp(F): %s \tConditions: %s \tOutreach: %s";

        SimpleDateFormat dateFmt = new SimpleDateFormat("yyyy/MM/dd HH:mm");
        String dateTime = dateFmt.format(fd.getDtTxt());

        String temperature = String.valueOf(fd.getMain().getTemp());

        Weather weather = (Weather) fd.getWeather().get(0);
        String conditions = weather.getMain();

        String outreach = outreachMethod(Double.parseDouble(temperature), conditions.toLowerCase());
        return String.format(tmplt, dateTime, temperature, conditions, outreach);
    }

    private String outreachMethod(Double temperature, String conditions) {
        if (conditions.equals("rain") || temperature < 55.0) {
            return "Phone call";
        }

        if (conditions.equals("clear") && temperature > 75.0) {
            return "Text message";
        }

        if (55.0 <= temperature && temperature <= 75.0) {
            return "Email";
        }

        return "Your discretion";
    }
}
