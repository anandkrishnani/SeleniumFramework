package personal.anand.qa.opencart.factory;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.HashMap;
import java.util.Properties;

public class OptionsManager {

    private Properties properties;
    private ChromeOptions chromeOptions;
    private FirefoxOptions firefoxOptions;

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
    public FirefoxOptions getFirefoxOptions() {
        firefoxOptions = new FirefoxOptions();
        if (Boolean.parseBoolean(properties.getProperty("headless"))) {
            chromeOptions.addArguments("--headless");
        }
        if (Boolean.parseBoolean(properties.getProperty("incognito"))) {
            chromeOptions.addArguments("--incognito");
        }
        return firefoxOptions;
    }

    public ChromeOptions getRemoteChromeOptions() {
        chromeOptions = getChromeOptions();
        HashMap<String,Object> optionMap =new HashMap<String,Object>();
        optionMap.put("enableVNC",Boolean.parseBoolean(properties.getProperty("enableVNC")));
        chromeOptions.setCapability("selenoid:options", optionMap);
        return chromeOptions;
    }
    public FirefoxOptions getRemoteFirefoxOptions() {
        firefoxOptions = getFirefoxOptions();
        HashMap<String,Object> optionMap =new HashMap<String,Object>();
        optionMap.put("enableVNC",Boolean.parseBoolean(properties.getProperty("enableVNC")));
        firefoxOptions.setCapability("selenoid:options", optionMap);
        return firefoxOptions;
    }
}
