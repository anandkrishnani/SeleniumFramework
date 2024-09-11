package personal.anand.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import personal.anand.qa.opencart.constants.AppConstants;
import personal.anand.qa.opencart.utils.ElementUtils;

public class RegisterPage {
    private WebDriver driver;
    private ElementUtils elementUtils;

    public By header = By.tagName("h1");
    private By firstName = By.id("input-firstname");
    private By lastName = By.id("input-lastname");
    private By email = By.id("input-email");
    private By telephone = By.id("input-telephone");
    private By password = By.id("input-password");
    private By confirmPassword = By.id("input-confirm");
    private By privacyPolicyCheckbox = By.name("agree");
    private By continueButton = By.xpath("//*[@id=\"content\"]/form/div/div/input[2]");
    private By successHeader = By.tagName("h1");

    public RegisterPage(WebDriver driver){
        this.driver=driver;
        elementUtils=new ElementUtils(driver);

    }

    public String fillRegistrationPage(String firstName, String lastName, String email, String telephone, String password){
        elementUtils.doSendKeys(this.firstName, firstName, AppConstants.MEDIUM_TIMEOUT);
        elementUtils.doSendKeys(this.lastName, lastName);
        elementUtils.doSendKeys(this.email, email);
        elementUtils.doSendKeys(this.telephone, telephone);
        elementUtils.doSendKeys(this.password, password);
        elementUtils.doSendKeys(this.confirmPassword, password);
        elementUtils.doClick(privacyPolicyCheckbox);
        elementUtils.doClick(continueButton);
       return elementUtils.getText(successHeader);

    }
}
