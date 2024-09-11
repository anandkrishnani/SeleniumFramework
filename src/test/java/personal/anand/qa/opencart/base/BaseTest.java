package personal.anand.qa.opencart.base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import personal.anand.qa.opencart.factory.DriverFactory;
import personal.anand.qa.opencart.pages.AccountPage;
import personal.anand.qa.opencart.pages.LoginPage;

import java.util.Properties;

public class BaseTest {

    DriverFactory df;
    protected Properties prop;
    WebDriver driver;
    protected LoginPage loginPage;
    protected AccountPage accountPage;

    @BeforeTest
    public void setup() {
        df = new DriverFactory();
        prop = df.initProp();
        driver = df.initDriver(prop);
        loginPage=new LoginPage(driver);
    }

    @AfterTest
    public void teardown(){
        driver.quit();

    }

}
