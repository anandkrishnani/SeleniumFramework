package personal.anand.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import personal.anand.qa.opencart.base.BaseTest;
import personal.anand.qa.opencart.constants.AppConstants;
import personal.anand.qa.opencart.pages.SearchResultsPage;

public class LoginPageTest extends BaseTest {
    @Test
    public void loginPageTitleTest() {
        String title = loginPage.getPageTitle();
        Assert.assertEquals(title, AppConstants.LOGIN_PAGE_TITLE);

    }

    @Test(priority = Integer.MAX_VALUE)
    public void loginTest() {
        accountPage = loginPage.doLogin(prop.getProperty("login"), prop.getProperty("password"));
        Assert.assertEquals(accountPage.getPageTitle(), AppConstants.ACCOUNT_PAGE_TITLE);
    }


}
