package personal.anand.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import personal.anand.qa.opencart.constants.AppConstants;
import personal.anand.qa.opencart.utils.ElementUtils;

public class LoginPage {
    private WebDriver driver;
    private ElementUtils elementUtils;
    private By loginEmailAddress = By.name("email");
    private By password = By.name("password");
    private By loginButton= By.xpath("//input[@value ='Login']");
    private By registerLink=By.linkText("Register");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        elementUtils = new ElementUtils(driver);
    }


    public String getPageTitle() {
        String title = driver.getTitle();
        return title;

    }

    public AccountPage doLogin(String login, String password){
        elementUtils.doSendKeys(loginEmailAddress, login, AppConstants.MEDIUM_TIMEOUT);
        elementUtils.doSendKeys(this.password, password);
        elementUtils.doClick(loginButton);
        return new AccountPage(driver);

    }

    public RegisterPage navigateToRegisterPage(){
        elementUtils.doClick(registerLink, AppConstants.MEDIUM_TIMEOUT);
        return new RegisterPage(driver);

    }


}
