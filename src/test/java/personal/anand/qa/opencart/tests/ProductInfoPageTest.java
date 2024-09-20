package personal.anand.qa.opencart.tests;

import org.hamcrest.core.StringContains;
import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import personal.anand.qa.opencart.base.BaseTest;
import personal.anand.qa.opencart.pages.LoginPage;
import personal.anand.qa.opencart.pages.SearchResultsPage;

import java.security.AlgorithmConstraints;

public class ProductInfoPageTest extends BaseTest {

    @BeforeClass
    public void productInfoPageSetup() {
        accountPage = loginPage.doLogin(prop.getProperty("login"), prop.getProperty("password"));

    }


    @Test()
    public void addToCartTest() {
        searchResultsPage = accountPage.doSearch("macbook");
        productInfoPage = searchResultsPage.selectSearchresults("MacBook Air");
        String alertMsg = productInfoPage.addToCart("MacBook Air");
        Assert.assertTrue(alertMsg.contains(String.format("Success: You have added %s to your shopping cart!","MacBook Air")));



    }
}
