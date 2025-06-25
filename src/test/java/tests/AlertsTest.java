package tests;

import helperMethods.AlertHelper;
import helperMethods.ElementHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import sharedData.SharedData;

public class AlertsTest extends SharedData {


    @Test
    public void AlertsTestMethod(){

        ElementHelper elementHelper = new ElementHelper(driver);
        AlertHelper alertHelper = new AlertHelper(driver);


        WebElement alertsMenu = driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
        elementHelper.clickJSElement(alertsMenu);

        WebElement alertsElement = driver.findElement(By.xpath("//span[text()='Alerts']"));
        elementHelper.clickJSElement(alertsElement);

        WebElement alertOkbuttonElement = driver.findElement(By.id("alertButton"));
        elementHelper.clickElement(alertOkbuttonElement);

        alertHelper.acceptAlert();
        //pt cancel .dismiss();

        WebElement alertWaitButtonElement = driver.findElement(By.id("timerAlertButton"));
        elementHelper.clickElement(alertWaitButtonElement);

        //wait explicit pentru alerta
        alertHelper.acceptAlert();

        WebElement alertOkCancelElement = driver.findElement(By.id("confirmButton"));
        elementHelper.clickJSElement(alertOkCancelElement);

        alertHelper.dismissAlert();

        WebElement alertPromptElement = driver.findElement(By.id("promtButton"));
        elementHelper.clickElement(alertPromptElement);

        alertHelper.fillAlert("Vlad");

    }

}