package personal.anand.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import personal.anand.qa.opencart.base.BaseTest;
import personal.anand.qa.opencart.constants.AppConstants;
import personal.anand.qa.opencart.pages.AccountPage;

import java.util.List;

public class AccountPageTest extends BaseTest {

    private AccountPage accountPage;

    @BeforeClass
    public void accountPageSetup() {

        accountPage = loginPage.doLogin(prop.getProperty("login"), prop.getProperty("password"));

    }

    @Test
    public void accountPageTitleTest() {
        String title = accountPage.getPageTitle();
        Assert.assertEquals(title, AppConstants.ACCOUNT_PAGE_TITLE);

    }

    @Test
    public void accountHeadersTest() {
        List<String> pageHeaderList = accountPage.getPageHeaders();
        Assert.assertEquals(pageHeaderList, AppConstants.ACCOUNT_PAGE_HEADERS_LIST);
    }
    @DataProvider
    private Object[][] getSearchTestData(){

        return new Object[][]{
                {"Macbook",AppConstants.MACBOOK_AIR,AppConstants.MACBOOK_AIR_PRICE},
                {"Macbook",AppConstants.MACBOOK_PRO,AppConstants.MACBOOK_PRO_PRICE},
                {"imac",AppConstants.I_MAC,AppConstants.I_MAC_PRICE},
                {"Samsung",AppConstants.SAMSUNG_GALAXY_TAB_10_1,AppConstants.SAMSUNG_GALAXY_TAB_10_1_PRICE}


        };
    }

    @Test(dataProvider = "getSearchTestData",priority = Integer.MAX_VALUE)
    public void SearchTest(String searchKey, String product,String productPrice) {
        searchResultsPage = accountPage.doSearch(searchKey);
        productInfoPage = searchResultsPage.selectSearchresults(product);
        String actualProductName = productInfoPage.getProductName();
        String actualProductPrice=productInfoPage.getProductPrice();
        Assert.assertEquals(actualProductName, product);
        Assert.assertEquals(actualProductPrice, productPrice);

    }
}
