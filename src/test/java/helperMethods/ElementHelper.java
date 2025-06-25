package helperMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ElementHelper {
    public WebDriver driver;

    public ElementHelper(WebDriver driver) {
        this.driver = driver;
    }

    public void clickJSElement(WebElement element){
        element.click();
    }

    public void clickElement(WebElement element){
        element.click();
    }
}