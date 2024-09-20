package personal.anand.qa.opencart.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import personal.anand.qa.opencart.constants.AppConstants;
import personal.anand.qa.opencart.utils.ElementUtils;

public class ProductInfoPage {

    private WebDriver driver;
    private ElementUtils elementUtils;
    private By productName = By.tagName("h1");
    private By productPrice = By.xpath("//li/h2");
    private By addToCartButton = By.xpath("//button[@id='button-cart']");
    private By addtoCartMsg = By.cssSelector(".alert-success");


    public ProductInfoPage(WebDriver driver) {
        this.driver = driver;
        elementUtils = new ElementUtils(driver);

    }

    public String getProductName() {
        return elementUtils.getText(productName);
    }

    public String getProductPrice() {
        return elementUtils.getText(productPrice);
    }

    public String addToCart(String product) {
        elementUtils.doClick(addToCartButton);
        //Alert alert = driver.switchTo().alert();
        return elementUtils.getElement(addtoCartMsg, AppConstants.MEDIUM_TIMEOUT).getText();
    }
}
