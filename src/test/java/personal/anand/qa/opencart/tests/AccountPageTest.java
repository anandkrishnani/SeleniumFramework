package personal.anand.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;

import org.testng.annotations.Test;
import personal.anand.qa.opencart.base.BaseTest;
import personal.anand.qa.opencart.constants.AppConstants;
import personal.anand.qa.opencart.pages.AccountPage;

import java.util.List;

public class AccountPageTest extends BaseTest {

    private AccountPage accountPage;

    @BeforeClass
    public void accountPageSetup(){

        accountPage= loginPage.doLogin(prop.getProperty("login"), prop.getProperty("password"));

    }

    @Test
    public void accountPageTitleTest() {
        String title =accountPage.getPageTitle();
        Assert.assertEquals(title, AppConstants.ACCOUNT_PAGE_TITLE);

    }
    @Test
    public void accountHeadersTest(){
       List<String> pageHeaderList= accountPage.getPageHeaders();
       Assert.assertEquals(pageHeaderList, AppConstants.ACCOUNT_PAGE_HEADERS_LIST);
    }
}
