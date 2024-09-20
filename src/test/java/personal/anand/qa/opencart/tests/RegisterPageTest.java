package personal.anand.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import personal.anand.qa.opencart.base.BaseTest;
import personal.anand.qa.opencart.constants.AppConstants;
import personal.anand.qa.opencart.pages.RegisterPage;

public class RegisterPageTest extends BaseTest {
    private RegisterPage registerPage;

    @BeforeClass
    public void registerPageSetup() {
        registerPage = loginPage.navigateToRegisterPage();
    }

    @DataProvider
    public Object[][] getRegisterAccountData() {
        return new Object[][]
                {
                        {"Rahul","Bhandaari","98456832","1234"}

                };

    }

    /**
     * Generate random email.
     * @return email string.
     */
    public String generateRandomEmail(){
        return "qa"+System.currentTimeMillis()+"@gmail.com";
    }

    @Test(dataProvider = "getRegisterAccountData")
    public void registerAccountTest(String fName, String lName, String telephone, String password) {
        String successMessageActual =registerPage.fillRegistrationPage(fName, lName, generateRandomEmail(), telephone, password);
        Assert.assertEquals(successMessageActual, AppConstants.REGISTRATION_ACCOUNT_CREATION);

    }
}
