package tests;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfAllElementsLocatedBy;

public class PracticeFormTest {
    public WebDriver driver;

    @Test
    public void testMethod() {
        driver = new ChromeDriver();
        driver.get("https://demoqa.com");

        driver.manage().window().maximize();
        WebElement elementName=driver.findElement(By.xpath("//h5[text()='Forms']"));
        elementName.click();

        WebElement webtablesubmenu=driver.findElement(By.xpath("//span[text()='Practice Form']"));
        webtablesubmenu.click();



        WebElement firstNameElement = driver.findElement(By.cssSelector("input[placeholder='First Name']"));
        String firstnameValue = "Moni";
        firstNameElement.sendKeys(firstnameValue);

        WebElement lastNameElement = driver.findElement(By.cssSelector("input[placeholder='Last Name']"));
        String lastNameValue = "Macaroni";
        lastNameElement.sendKeys(lastNameValue);

        WebElement emailElement = driver.findElement(By.cssSelector("input[placeholder='name@example.com']"));
        String emailValue = "moni@gmail.com";
        emailElement.sendKeys(emailValue);

        WebElement phoneNumberElement = driver.findElement(By.cssSelector("input[placeholder='Mobile Number']"));
        String phoneNumberValue = "0454355699";
        phoneNumberElement.sendKeys(phoneNumberValue);

        WebElement subjectsElement = driver.findElement(By.id("subjectsInput"));
        List<String> subjectsValue = Arrays.asList(" Accounting", "Arts", "Maths ");
        for (int index = 0; index < subjectsValue.size(); index++) {
            subjectsElement.sendKeys(subjectsValue.get(index));
            subjectsElement.sendKeys(Keys.ENTER);
        }


        String genderValue = "Female";
        List<WebElement> genderElementList = driver.findElements(By.cssSelector("div[id='genterWrapper']>div>div>label[class='custom-control-label']"));
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

        List<WebElement> hobbiesElementList = driver.findElements(By.cssSelector("div[id='hobbiesWrapper']>div>div>label[class='custom-control-label']"));
        List<String> hobbieValues = Arrays.asList("Reading", "Music");
        for (int index = 0; index < hobbiesElementList.size(); index++) {
            if (hobbieValues.contains(hobbiesElementList.get(index).getText())) {
                hobbiesElementList.get(index).click();
            }
        }

        WebElement uploadElement = driver.findElement(By.id("uploadPicture"));
        String uploadValue = "src/test/resources/pozacurs.jpeg";
        File file = new File(uploadValue);
        uploadElement.sendKeys(file.getAbsolutePath());

        WebElement currentAddressElement = driver.findElement(By.id("currentAddress"));
        String currentAddressValue = "Str. Campului, nr 20, et 5";
        currentAddressElement.sendKeys(currentAddressValue);

        JavascriptExecutor executor = (JavascriptExecutor) driver;

        WebElement stateElement = driver.findElement(By.id("state"));
        executor.executeScript("arguments[0].click();", stateElement);

        WebElement stateInputElement = driver.findElement(By.id("react-select-3-input"));
        String stateValue = "Uttar Pradesh";
        stateInputElement.sendKeys(stateValue);
        stateInputElement.sendKeys(Keys.ENTER);

        WebElement cityElement = driver.findElement(By.id("react-select-4-input"));
        executor.executeScript("arguments[0].click();", cityElement);

        WebElement cityInputElement = driver.findElement(By.id("react-select-4-input"));
        String cityValue = "Lucknow";
        cityInputElement.sendKeys(cityValue);
        cityInputElement.sendKeys(Keys.ENTER);

        WebElement submitElement = driver.findElement(By.id("submit"));
        executor.executeScript("arguments[0].click();", submitElement);



        //Wait explicit
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//table//td[1]")));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//table//td[2]")));
        //Wait implicit
        // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        List<WebElement> tableDescriptionList = driver.findElements(By.xpath("//table//td[1]"));
        List<WebElement> tableValueList = driver.findElements(By.xpath("//table//td[2]"));

        Assert.assertEquals(tableDescriptionList.get(0).getText(), "Student Name", "Student Name text is not displayed right in the table");
        Assert.assertTrue(tableValueList.get(0).getText().contains(firstnameValue), "First Name text is not displayed right in the table");
        Assert.assertTrue(tableValueList.get(0).getText().contains(lastNameValue), "Last Name text is not displayed right in the table");

        Assert.assertEquals(tableDescriptionList.get(1).getText(), "Student Email", "Student Email text is not displayed right in the table");
        Assert.assertEquals(tableValueList.get(1).getText(), emailValue, "Student email text is not displayed right in the table");

        Assert.assertEquals(tableDescriptionList.get(2).getText(), "Gender", "Gender text is not displayed right in the table");
        Assert.assertEquals(tableValueList.get(2).getText(), genderValue, "Gender text is not displayed right in the table");

        Assert.assertEquals(tableDescriptionList.get(3).getText(), "Mobile", "Mobile text is not displayed right in the table");
        Assert.assertEquals(tableValueList.get(3).getText(), phoneNumberValue, "Mobile text is not displayed right in the table");

//        Assert.assertEquals(tableDescriptionList.get(5).getText(), "Subjects", "Subjects text is not displayed right in the table");
//        Assert.assertEquals(tableValueList.get(5).getText(), subjectsValue, "Subjects text is not displayed right in the table");

        Assert.assertEquals(tableDescriptionList.get(6).getText(), "Hobbies", "Hobbies text is not displayed right in the table");
        Assert.assertEquals(tableValueList.get(6).getText(), hobbieValues, "Hobbies text is not displayed right in the table");

//        Assert.assertEquals(tableDescriptionList.get(7).getText(), "Picture", "Picture text is not displayed right in the table");
//        Assert.assertEquals(tableValueList.get(7).getText(), uploadValue, "Picture text is not displayed right in the table");

        Assert.assertEquals(tableDescriptionList.get(8).getText(), "Address", "Address text is not displayed right in the table");
        Assert.assertEquals(tableValueList.get(8).getText(), currentAddressValue, "Address text is not displayed right in the table");

        Assert.assertEquals(tableDescriptionList.get(9).getText(), "State and City", "Student Name text is not displayed right in the table");
        Assert.assertTrue(tableValueList.get(9).getText().contains(stateValue), "State text is not displayed right in the table");
        Assert.assertTrue(tableValueList.get(9).getText().contains(cityValue), "City text is not displayed right in the table");

//        driver.quit();


    }

}
