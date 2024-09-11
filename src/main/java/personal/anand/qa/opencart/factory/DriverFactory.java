package personal.anand.qa.opencart.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DriverFactory {
    private WebDriver driver;

    public WebDriver initDriver(Properties prop) {
        switch (prop.getProperty("browser").toLowerCase().trim()) {
            case "chrome":
                driver = new ChromeDriver();
                break;
            default:
                break;
        }
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get(prop.getProperty("base-uri"));
        return driver;
    }

    public Properties initProp() {

        try {
            FileInputStream file = new FileInputStream("src/test/resources/config/config.properties");
            Properties prop = new Properties();
            prop.load(file);
            return prop;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
