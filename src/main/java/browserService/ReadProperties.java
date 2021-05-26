package browserService;

import java.io.IOException;
import java.util.Properties;

public class ReadProperties {
    protected Properties properties;

    public ReadProperties() {
        properties = new Properties();
        try {
            properties.load(getClass().getClassLoader().getResourceAsStream("config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getURL(){
        return properties.getProperty("URL");
    }

    public String getApiURL(){
        return properties.getProperty("apiURL");
    }

    public String getBrowserName() {
        return properties.getProperty("browserType");
    }

    public int getTimeOut() {
        return Integer.parseInt(properties.getProperty("timeOut"));
    }

    public Boolean getHeadless() {
        return Boolean.parseBoolean(properties.getProperty("headless"));
    }
}
