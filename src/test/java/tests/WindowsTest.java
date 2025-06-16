package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class WindowsTest {

    public WebDriver driver;

        @Test
        public void testMethod() {
            //deschidem o instanta de Chrome
            driver = new ChromeDriver();

            //accesam o pagina specifica
            driver.get("https://demoqa.com");

            //facem browser-ul sa fie in modul maximize
            driver.manage().window().maximize();
            WebElement alertFrame = driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
            alertFrame.click();

            WebElement webtablesubmenu = driver.findElement(By.xpath("//span[text()='Browser Windows']"));
            webtablesubmenu.click();

            WebElement elementnewTab=driver.findElement(By.id("tabButton"));
            elementnewTab.click();
            System.out.println(driver.getCurrentUrl());

            List<String> tabsList= new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(tabsList.get(1));
            System.out.println(driver.getCurrentUrl());

            driver.close();
            driver.switchTo().window(tabsList.get(0));
            System.out.println(driver.getCurrentUrl());

            // din cauza reclamei fortam siteul sa acceseze un URL specific
//            driver.navigate().to("https://demoqa.com/browser-windows");
            WebElement elementnewWindow=driver.findElement(By.id("windowButton"));
            elementnewWindow.click();
            System.out.println(driver.getCurrentUrl());

            List<String> windowsList= new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(windowsList.get(1));
            System.out.println(driver.getCurrentUrl());

            driver.close();
            driver.switchTo().window(tabsList.get(0));
            System.out.println(driver.getCurrentUrl());

//            driver.quit();











        }


}
