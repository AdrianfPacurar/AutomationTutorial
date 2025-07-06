package tests;

import helperMethods.ElementHelper;
import helperMethods.FrameHelper;
import sharedData.SharedData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class FrameTest extends SharedData {

    @Test
    public void testMethod() {

        ElementHelper elementHelper = new ElementHelper(driver);
        FrameHelper frameHelper = new FrameHelper(driver);

        WebElement alertsFramesWindowsMenu = driver.findElement(By.xpath("//h5[text() = 'Alerts, Frame & Windows']"));
        elementHelper.clickJSElement(alertsFramesWindowsMenu);

        WebElement framesElement = driver.findElement(By.xpath("//span[text() = 'Frames']"));
        elementHelper.clickJSElement(framesElement);

        frameHelper.switchFrameByElement(driver.findElement(By.xpath("//iframe[@id='frame1']")));

        elementHelper.printTextElement(driver.findElement(By.id("sampleHeading")));

        frameHelper.switchToParent();

        frameHelper.switchFrameByString("frame2");

        elementHelper.printTextElement(driver.findElement(By.id("sampleHeading")));

        frameHelper.switchToParent();

    }
}