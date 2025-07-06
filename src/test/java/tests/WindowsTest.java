package tests;

import helperMethods.ElementHelper;
import helperMethods.TabHelper;
import sharedData.SharedData;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class WindowsTest extends SharedData {

    @Test
    public void testMethod(){

        ElementHelper elementHelper = new ElementHelper(driver);
        TabHelper tabHelper = new TabHelper(driver);

        WebElement alertsFramesWindowsMenu = driver.findElement(By.xpath("//h5[text() = 'Alerts, Frame & Windows']"));
        elementHelper.clickJSElement(alertsFramesWindowsMenu);

        WebElement browserWindowSubmenu = driver.findElement(By.xpath("//span[text() = 'Browser Windows']"));
        elementHelper.clickJSElement(browserWindowSubmenu);

        WebElement newTabButton = driver.findElement(By.id("tabButton"));
        elementHelper.clickJSElement(newTabButton);

        tabHelper.switchToSpecificTab(1);

        tabHelper.closeCurrentTab();

        tabHelper.switchToSpecificTab(0);

        WebElement newWindowButton = driver.findElement(By.id("windowButton"));
        elementHelper.clickJSElement(newWindowButton);

        tabHelper.switchToSpecificTab(1);
        tabHelper.closeCurrentTab();
        tabHelper.switchToSpecificTab(0);

    }
}