package personal.anand.qa.opencart.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Properties;

public class DriverFactory {
    private WebDriver driver;
    private static final Logger logger = LoggerFactory.getLogger(DriverFactory.class);
    Properties prop;

    public WebDriver initDriver(Properties prop) {
        if(Boolean.parseBoolean(prop.getProperty("remote"))){
            try {
                driver=new RemoteWebDriver(new URL(prop.getProperty("remote-url")),setChromeOptions());
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            }
        }
        else
        {
            switch (prop.getProperty("browser").toLowerCase().trim()) {
                case "chrome":
                    driver = new ChromeDriver();
                    break;
                default:
                    break;
            }
        }
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get(prop.getProperty("base-uri"));
        return driver;
    }

    public Properties initProp() {

        prop = new Properties();
        try {
            String envName = System.getProperty("env");
            FileInputStream file = null;
            logger.info("running on {} environment",envName);
            if (envName == null) {
                file = new FileInputStream("src/test/resources/config/qaconfig.properties");

            } else {
                switch (envName.toLowerCase().trim()) {
                    case "qa":
                        file = new FileInputStream("src/test/resources/config/qaconfig.properties");
                        break;
                    case "prod":
                        file = new FileInputStream("src/test/resources/config/config.properties");
                        break;
                    default:
                        break;
                }
            }
            prop.load(file);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return prop;
    }
    private ChromeOptions setChromeOptions() {
        ChromeOptions options =new ChromeOptions();
        HashMap<String,Object> optionMap =new HashMap<String,Object>();
        optionMap.put("enableVNC",Boolean.parseBoolean(prop.getProperty("enableVNC")));
        options.setCapability("selenoid:options", optionMap);
        return options;
    }

}
