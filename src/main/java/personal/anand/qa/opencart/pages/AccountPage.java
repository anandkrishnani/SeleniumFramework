package personal.anand.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import personal.anand.qa.opencart.constants.AppConstants;
import personal.anand.qa.opencart.utils.ElementUtils;

import java.util.ArrayList;
import java.util.List;

public class AccountPage {
    private WebDriver driver;
    private ElementUtils elementUtils;
    private By pageHeaders = By.xpath("//div[@id='content']/h2");
    private By searchField =By.name("search");
    private By searchButton=By.xpath("//div[@id='search']//button");


    public AccountPage(WebDriver driver) {
        this.driver = driver;
        elementUtils = new ElementUtils(driver);
    }


    public String getPageTitle() {
        String title = driver.getTitle();
        return title;

    }

    public List<String> getPageHeaders(){
        List<WebElement> pageHeaderList =elementUtils.getElements(pageHeaders, AppConstants.MEDIUM_TIMEOUT);
        List<String> pageHeaderTextList =new ArrayList<>();
        for (WebElement e : pageHeaderList){
            pageHeaderTextList.add(e.getText());
        }
        return pageHeaderTextList;
    }

    public SearchResultsPage doSearch(String searchKey){
        elementUtils.doSendKeys(searchField, searchKey, AppConstants.MEDIUM_TIMEOUT);
        elementUtils.doClick(searchButton);
        return new SearchResultsPage(driver);

    }

}
