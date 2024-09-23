package personal.anand.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import personal.anand.qa.opencart.constants.AppConstants;
import personal.anand.qa.opencart.utils.ElementUtils;

import java.util.HashMap;
import java.util.List;

public class ProductInfoPage {

    private WebDriver driver;
    private ElementUtils elementUtils;
    private By productName = By.tagName("h1");
    private By productPrice = By.xpath("//li/h2");
    private By addToCartButton = By.xpath("//button[@id='button-cart']");
    private By addtoCartMsg = By.cssSelector(".alert-success");
    private By productMetaData = By.xpath("(//div[@id='content']//h1/following-sibling::ul)[1]/li");


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

    public String addToCart() {
        elementUtils.doClick(addToCartButton);
        return elementUtils.getElement(addtoCartMsg, AppConstants.MEDIUM_TIMEOUT).getText();
    }

    public HashMap<String, String> getProductMetaData() {
        HashMap<String, String> productInfoMap = new HashMap<>();
        List<WebElement> ProductMetaDataList = elementUtils.getElements(productMetaData, AppConstants.MEDIUM_TIMEOUT);
        for (WebElement e : ProductMetaDataList) {
            String metaData[] = e.getText().split(":");
            productInfoMap.put(metaData[0].trim(), metaData[1].trim());
        }
        return productInfoMap;
    }
}
