package personal.anand.qa.opencart.base;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
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
    //protected SoftAssert softAssert;
    protected LoginPage loginPage;
    protected AccountPage accountPage;
    protected SearchResultsPage searchResultsPage;
    protected ProductInfoPage productInfoPage;

    @Step("Setup with browser : {0} and init the propeties")
    @Parameters({"browser"})
    @BeforeTest
    public void setup(String browserName) {
        df = new DriverFactory();
        prop = df.initProp();
        if(browserName!=null) {
            prop.setProperty("browser", browserName);
        }
        driver = df.initDriver(prop);
        loginPage=new LoginPage(driver);
    }

    @AfterTest
    public void tearDown(){
        driver.quit();

    }

}
