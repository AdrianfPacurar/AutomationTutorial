package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AlertPage extends BasePage{

    public  AlertPage(WebDriver driver){
        super(driver);

    }

    @FindBy(id = "alertButton")
    private WebElement alertOkbuttonElement;
    @FindBy(id = "timerAlertButton")
    private WebElement alertWaitButtonElement;
    @FindBy(id = "confirmButton")
    private WebElement alertOkCancelElement;
    @FindBy(id = "promtButton")
    private WebElement alertPromptElement;

    public void dealAlertOk(){
        elementHelper.clickElement(alertOkbuttonElement);
        alertHelper.acceptAlert();
    }
    public void dealAlertTimer(){
        elementHelper.clickElement(alertWaitButtonElement);
        alertHelper.acceptAlert();
    }

    public void dealAlertCancel(){
        elementHelper.clickJSElement(alertOkCancelElement);
        alertHelper.dismissAlert();
    }

    public void dealAlertPrompt(String value){
        elementHelper.clickElement(alertPromptElement);

        alertHelper.fillAlert(value);
    }
}