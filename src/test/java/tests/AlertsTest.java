package tests;

import helperMethods.AlertHelper;
import helperMethods.ElementHelper;
import helperMethods.PageHelper;
import sharedData.SharedData;
import org.openqa.selenium.*;
import org.testng.annotations.Test;

import java.time.Duration;

public class AlertsTest extends SharedData {

    @Test
    public void testMethod() {

        ElementHelper elementHelper = new ElementHelper(driver);
        AlertHelper alertHelper = new AlertHelper(driver);
        PageHelper pageHelper = new PageHelper(driver);

        WebElement alertsFramesWindowsMenu = driver.findElement(By.xpath("//h5[text() = 'Alerts, Frame & Windows']"));
        elementHelper.clickJSElement(alertsFramesWindowsMenu);

        WebElement alertsElement = driver.findElement(By.xpath("//span[text() = 'Alerts']"));
        elementHelper.clickJSElement(alertsElement);

        WebElement alertOkButtonElement = driver.findElement(By.id("alertButton"));
        elementHelper.clickJSElement(alertOkButtonElement);

        alertHelper.acceptAlert();

        WebElement alertWaitButtonElement = driver.findElement(By.id("timerAlertButton"));
        elementHelper.clickJSElement(alertWaitButtonElement);

        alertHelper.acceptAlert();

        WebElement alertOkCancelElement = driver.findElement(By.id("confirmButton"));
        elementHelper.clickJSElement(alertOkCancelElement);

        alertHelper.dismissAlert();

        WebElement alertWithTextElement = driver.findElement(By.id("promtButton"));
        elementHelper.clickJSElement(alertWithTextElement);

        alertHelper.fillAlert("ceva text");

        pageHelper.scrollPage(0,400);
    }
}