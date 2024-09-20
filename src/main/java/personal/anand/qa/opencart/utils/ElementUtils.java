package personal.anand.qa.opencart.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class ElementUtils {
    private WebDriver driver;

    public ElementUtils(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getElement(By locator) {
        return driver.findElement(locator);
    }

    public List<WebElement> getElements(By locator) {
        return driver.findElements(locator);
    }

    public int getElementCount(By locator){
        return getElements(locator).size();
    }

    public boolean isElementPresent(By locator, int expectedCount){
        if (getElementCount(locator)==expectedCount){
            return true;
        }
        return false;
    }

    public void doSendKeys(By locator, String value) {
        getElement(locator).clear();
        getElement(locator).sendKeys(value);
    }
    public void doSendKeys(By locator, String value, int duration) {
        getElement(locator,duration).clear();
        getElement(locator, duration).sendKeys(value);
    }

    public void doClick(By locator) {
        getElement(locator).click();
    }
    public void doClick(By locator, int duration) {
        getElement(locator, duration).click();
    }

    public void doClick(WebElement element){
        element.click();
    }

    public String getText(By locator) {
        return getElement(locator).getText();
    }

    public List<String> getTextList(By locator) {
        List<WebElement> webElementList = getElements(locator);
        List<String> StringList = new ArrayList<>();
        for (WebElement e : webElementList) {
            StringList.add(e.getText());
        }
        return StringList;
    }


    public boolean isDisplayed(By locator) {
        try {
            return getElement(locator).isDisplayed();
        }
        catch (NoSuchElementException e){
            return false;
        }
    }

    public String getElementAttribute(By locator, String attribute) {
        return getElement(locator).getAttribute(attribute);
    }
    public void getSearchboxValue (By searchField, By searchDropbox, String value, String matchValue ) {
        boolean flag = false;
        doSendKeys(searchField, value);
        List<WebElement> searchListElements = getElements(searchDropbox);
        if (searchListElements.size() == 0) {
            System.out.println("No match found");
            throw new RuntimeException("Search list is empty, no match found");
        }
        for (WebElement searchOptions : searchListElements) {
            if (searchOptions.getText().contains(matchValue)) {
                doClick(searchOptions);
                flag = true;
                break;
            }
        }
        if (flag) {
            System.out.println("value is matched");
        } else {
            System.out.println("No match found");
            throw new RuntimeException(" No match found");
        }
    }

    public void selectByVisibleText(By locator, String text){
        Select select=new Select(getElement(locator));
        select.selectByVisibleText(text);
    }

    public WebElement getElement(By locator, int timeout){
        WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public List<WebElement> getElements(By locator, int timeout){
        WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }
}
