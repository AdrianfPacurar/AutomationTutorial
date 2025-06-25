package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import sharedData.SharedData;

import java.time.Duration;

public class FramesTest extends SharedData {



    @Test
    public void AlertsTestMethod() {


        WebElement alertsMenu = driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
        alertsMenu.click();

        WebElement framesElement = driver.findElement(By.xpath("//span[text()='Frames']"));
        framesElement.click();

        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='frame1']")));

        WebElement firstBlockElement = driver.findElement(By.id("sampleHeading"));
        System.out.println(firstBlockElement.getText());

        driver.switchTo().parentFrame();

        driver.switchTo().frame("frame2");

        WebElement secondBlockElement = driver.findElement(By.id("sampleHeading"));
        System.out.println(secondBlockElement.getText());

        driver.switchTo().parentFrame();

        driver.quit();

    }
}