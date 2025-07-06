package helperMethods;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AlertHelper {

    public WebDriver driver;

    public AlertHelper(WebDriver driver) {
        this.driver = driver;
    }

    public void waitAlert(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());
    }

    public void acceptAlert(){
        waitAlert();
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    public void dismissAlert(){
        waitAlert();
        Alert alertOkCancel = driver.switchTo().alert();
        alertOkCancel.dismiss();
    }

    public void fillAlert(String text){
        waitAlert();
        Alert alertWithText = driver.switchTo().alert();
        alertWithText.sendKeys(text);
        alertWithText.accept();
    }

}