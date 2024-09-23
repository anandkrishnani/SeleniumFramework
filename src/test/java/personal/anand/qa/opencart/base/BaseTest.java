package personal.anand.qa.opencart.base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;
import personal.anand.qa.opencart.factory.DriverFactory;
import personal.anand.qa.opencart.pages.AccountPage;
import personal.anand.qa.opencart.pages.LoginPage;
import personal.anand.qa.opencart.pages.ProductInfoPage;
import personal.anand.qa.opencart.pages.SearchResultsPage;

import java.util.Properties;

public class BaseTest {

    DriverFactory df;
    protected Properties prop;
    WebDriver driver;
    protected SoftAssert softAssert;
    protected LoginPage loginPage;
    protected AccountPage accountPage;
    protected SearchResultsPage searchResultsPage;
    protected ProductInfoPage productInfoPage;

    @BeforeTest
    public void setup() {
        df = new DriverFactory();
        prop = df.initProp();
        driver = df.initDriver(prop);
        loginPage=new LoginPage(driver);
        softAssert = new SoftAssert();
    }

    @AfterTest
    public void teardown(){
        driver.quit();

    }

}
