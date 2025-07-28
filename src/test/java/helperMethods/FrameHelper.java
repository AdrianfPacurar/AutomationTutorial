package helperMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FrameHelper {

    private WebDriver driver;

    public FrameHelper(WebDriver driver) {
        this.driver = driver;
    }

    public void switchFrameByElement(WebElement element){
        driver.switchTo().frame(element);
    }

    public void switchFrameByString(String frameName){
        driver.switchTo().frame(frameName);
    }

    public void switchToParent(){
        driver.switchTo().parentFrame();
    }

}