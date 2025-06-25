package tests;

import helperMethods.PageHelper;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import sharedData.SharedData;

import java.io.File;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class PracticeFormTest extends SharedData {


    @Test
    public void TestMethod() {

        PageHelper pageHelper = new PageHelper(driver);


        WebElement formsMenu = driver.findElement(By.xpath("//h5[text()='Forms']"));
        formsMenu.click();

        WebElement formsSubMenu = driver.findElement(By.xpath("//span[text()='Practice Form']"));
        formsSubMenu.click();

        //wait implicit = pui un timeframe de 10s , iar daca se computeaza in sub 10s nu asteapta toate cele 10s
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement firstNameElement = driver.findElement(By.cssSelector("input[placeholder='First Name']"));
        String firstnameValue = "Vladut";
        firstNameElement.sendKeys(firstnameValue);

        WebElement lastNameElement = driver.findElement(By.cssSelector("input[placeholder='Last Name']"));
        String lastNameValue = "Ardelean";
        lastNameElement.sendKeys(lastNameValue);

        WebElement emailElement = driver.findElement(By.cssSelector("input[placeholder='name@example.com']"));
        String emailValue = "vardy@gmail.com";
        emailElement.sendKeys(emailValue);

        WebElement phoneNumberElement = driver.findElement(By.cssSelector("input[placeholder='Mobile Number']"));
        String phoneNumberValue = "0454355665";
        phoneNumberElement.sendKeys(phoneNumberValue);

        WebElement subjectsElement = driver.findElement(By.id("subjectsInput"));
        List<String> subjectsValue = Arrays.asList("Accounting", "Arts", "Maths");
        for(int index = 0; index < subjectsValue.size(); index++) {
            subjectsElement.sendKeys(subjectsValue.get(index));
            subjectsElement.sendKeys(Keys.ENTER);
        }

        String genderValue = "Female";
        List<WebElement> genderElementList = driver.findElements(By.cssSelector("div[id='genterWrapper'] label[class='custom-control-label']"));
        switch (genderValue) {
            case "Male":
                genderElementList.get(0).click();
                break;
            case "Female":
                genderElementList.get(1).click();
                break;
            case "Other":
                genderElementList.get(2).click();
                break;

        }
        //valorea pozitiva duce scrollul in jos,valoarea negativa duce scrollul in sus
        pageHelper.scrollPage(0, 400);

        List<WebElement> hobbiesElementList = driver.findElements(By.cssSelector("div[id='hobbiesWrapper']>div>div>label[class='custom-control-label']"));
        List<String> hobbyValue = Arrays.asList("Reading", "Sports");
        for (int index = 0; index < hobbiesElementList.size(); index++){
            if (hobbyValue.contains(hobbiesElementList.get(index).getText())) {
                hobbiesElementList.get(index).click();
            }
        }

        WebElement uploadElement = driver.findElement(By.id("uploadPicture"));
        String uploadValue = "src/test/resources/pozacurs.JPEG";
        File file = new File(uploadValue);
        uploadElement.sendKeys(file.getAbsolutePath());

        WebElement currentAddressElement = driver.findElement(By.id("currentAddress"));
        String currentAddressValue = "Str Caprioarei nr. 15 , apt. 17";
        currentAddressElement.sendKeys(currentAddressValue);

        JavascriptExecutor executor = (JavascriptExecutor) driver;

        WebElement stateElement = driver.findElement(By.id("state"));
        executor.executeScript("arguments[0].click;", stateElement);

        WebElement stateInputElement = driver.findElement(By.id("react-select-3-input"));
        String stateValue = "Uttar Pradesh";
        stateInputElement.sendKeys(stateValue);
        stateInputElement.sendKeys(Keys.ENTER);

        WebElement cityInputElement = driver.findElement(By.id("react-select-4-input"));
        String cityValue = "Agra";
        cityInputElement.sendKeys(cityValue);
        cityInputElement.sendKeys(Keys.ENTER);

        WebElement submitElement = driver.findElement(By.id("submit"));
        submitElement.click();

        List<WebElement> tableDescriptionList = driver.findElements(By.xpath("//table//td[1]"));
        List<WebElement> tableValueList = driver.findElements(By.xpath("//table//td[2]"));

        Assert.assertEquals(tableDescriptionList.get(0).getText(), "Student Name", "Student Name text is not displayed right in the table");
        Assert.assertTrue(tableValueList.get(0).getText().contains(firstnameValue), "First name text is not displayed right in the table");
        Assert.assertTrue(tableValueList.get(0).getText().contains(lastNameValue), "Last name text is not displayed right in the table");

        Assert.assertEquals(tableDescriptionList.get(1).getText(), "Student Email", "Student email text is not displayed right in the table");
        Assert.assertEquals(tableValueList.get(1).getText(), emailValue, "Student email text is not displayed right in the table");

        Assert.assertEquals(tableDescriptionList.get(2).getText(), "Gender", "Gender text is not displayed right in the table");
        Assert.assertEquals(tableValueList.get(2).getText(), genderValue, "Gender text is not displayed right in the table");

        Assert.assertEquals(tableDescriptionList.get(3).getText(), "Mobile", "Mobile text is not displayed right in the table");
        Assert.assertEquals(tableValueList.get(3).getText(), phoneNumberValue, "Mobile text is not displayed right in the table");

        driver.quit();


    }
}