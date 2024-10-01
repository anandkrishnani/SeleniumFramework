package personal.anand.qa.opencart.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class JavaScriptUtil {
    private JavascriptExecutor js;

    public JavaScriptUtil(WebDriver driver){
        js = (JavascriptExecutor) driver;
    }


    public void scrollMiddlePageDown() {

        js.executeScript("window.scrollTo(0, document.body.scrollHeight/2);");
    }
}
