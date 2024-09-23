package personal.anand.qa.opencart.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import personal.anand.qa.opencart.errors.AppError;
import personal.anand.qa.opencart.exceptions.BrowserException;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

public class DriverFactory {
    private WebDriver driver;
    private static final Logger logger = LoggerFactory.getLogger(DriverFactory.class);
    Properties prop;
    private static ThreadLocal<WebDriver> tldriver = new ThreadLocal<WebDriver>();

    public WebDriver initDriver(Properties prop) {
        OptionsManager optionsManager = new OptionsManager(prop);
        if (Boolean.parseBoolean(prop.getProperty("remote"))) {
            try {
                tldriver.set(new RemoteWebDriver(new URL(prop.getProperty("remote-url")), optionsManager.getRemoteChromeOptions()));
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            }
        } else {
            switch (prop.getProperty("browser").toLowerCase().trim()) {
                case "chrome":
                    tldriver.set(new ChromeDriver(optionsManager.getChromeOptions()));
                    break;
                default:
                    logger.error("Browser {} is not a supported by this framework",prop.getProperty("browser"));
                    throw new BrowserException(AppError.INVALID_BROWSER);
            }
        }
        getDriver().manage().window().maximize();
        getDriver().manage().deleteAllCookies();
        getDriver().get(prop.getProperty("base-uri"));
        return getDriver();
    }

    public static WebDriver getDriver() {
        return tldriver.get();
    }

    public Properties initProp() {

        prop = new Properties();
        try {
            String envName = System.getProperty("env");
            FileInputStream file = null;
            logger.info("running on {} environment", envName);
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
                        logger.error("{} is not a valid environment",envName);
                        throw new BrowserException("Invalid environment");
                }
            }
            prop.load(file);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return prop;
    }

}
