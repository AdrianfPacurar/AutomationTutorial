package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FormsPage extends BasePage{

    public FormsPage(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//span[text()='Practice Form']")
    private WebElement formsSubMenu;

    public void interactWithPracticeFormSubMenu(){
        elementHelper.clickElement(formsSubMenu);
    }
}