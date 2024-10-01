package personal.anand.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import personal.anand.qa.opencart.utils.ElementUtils;
import personal.anand.qa.opencart.utils.JavaScriptUtil;

import java.util.List;

public class SearchResultsPage {
    private WebDriver driver;
    private ElementUtils elementUtils;
    private JavaScriptUtil javaScriptUtil;
    private By searchresults= By.xpath("//div[@class='product-thumb']//h4/a");


    public SearchResultsPage(WebDriver driver){
        this.driver=driver;
        elementUtils=new ElementUtils(driver);
        javaScriptUtil=new JavaScriptUtil(driver);

    }
    public ProductInfoPage selectSearchresults(String searchOption){
        List<WebElement> searchList = elementUtils.getElements(searchresults);
        javaScriptUtil.scrollMiddlePageDown();
        for (WebElement e: searchList){
            if (e.getText().equals(searchOption)){
                e.click();
                break;
            }
        }
        return new ProductInfoPage(driver);

    }
}
