package personal.anand.qa.opencart.factory;

import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Properties;

public class OptionsManager {

    private Properties properties;
    private ChromeOptions chromeOptions;

    public OptionsManager(Properties properties){
        this.properties=properties;

    }

    public ChromeOptions getChromeOptions() {
        chromeOptions = new ChromeOptions();
        if (Boolean.parseBoolean(properties.getProperty("headless"))) {
            chromeOptions.addArguments("--headless");
        }
        if (Boolean.parseBoolean(properties.getProperty("incognito"))) {
            chromeOptions.addArguments("--incognito");
        }
        return chromeOptions;
    }

    public ChromeOptions getRemoteChromeOptions() {
        chromeOptions = getChromeOptions();
        HashMap<String,Object> optionMap =new HashMap<String,Object>();
        optionMap.put("enableVNC",Boolean.parseBoolean(properties.getProperty("enableVNC")));
        chromeOptions.setCapability("selenoid:options", optionMap);
        return chromeOptions;
    }
}
