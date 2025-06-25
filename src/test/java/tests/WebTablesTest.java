package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import sharedData.SharedData;

import java.time.Duration;
import java.util.List;

public class WebTablesTest extends SharedData {


    @Test
    public void testMethod(){


        WebElement elementsMenu = driver.findElement(By.xpath("//h5[text()='Elements']"));
        elementsMenu.click();

        WebElement elementsSubMenu = driver.findElement(By.xpath("//span[text()='Web Tables']"));
        elementsSubMenu.click();



        List<WebElement> tableList = driver.findElements(By.xpath("//div[@class='rt-tr -even' or @class='rt-tr -odd']"));
        int tableSize = 3;
        Assert.assertEquals(tableList.size(), tableSize);

        //identificam un element
        WebElement addElement=driver.findElement(By.id("addNewRecordButton"));
        addElement.click();

        WebElement firstnameElement=driver.findElement(By.id("firstName"));
        String firstnameValue="Vlad";
        firstnameElement.sendKeys(firstnameValue);

        WebElement lastnameElement=driver.findElement(By.id("lastName"));
        String lastnameValue="Ardelean";
        lastnameElement.sendKeys(lastnameValue);

        WebElement emailElement=driver.findElement(By.id("userEmail"));
        String emailValue="test@test.com";
        emailElement.sendKeys(emailValue);

        WebElement ageElement=driver.findElement(By.id("age"));
        String ageValue="27";
        ageElement.sendKeys(ageValue);

        WebElement salaryElement=driver.findElement(By.id("salary"));
        String salaryValue="2500";
        salaryElement.sendKeys(salaryValue);

        WebElement departmentElement=driver.findElement(By.id("department"));
        String departmentValue="financiar";
        departmentElement.sendKeys(departmentValue);

        WebElement submitElement=driver.findElement(By.id("submit"));
        submitElement.click();

        tableList = driver.findElements(By.xpath("//div[@class='rt-tr -even' or @class='rt-tr -odd']"));
        Assert.assertEquals(tableList.size(), tableSize +1);

        //edit functionality
        WebElement editElement=driver.findElement(By.id("edit-record-4"));
        editElement.click();

        WebElement editFirstNameElement=driver.findElement(By.id("firstName"));
        String editFirstNameValue="Vlad";
        editFirstNameElement.clear();
        editFirstNameElement.sendKeys(editFirstNameValue);

        WebElement editLastNameElement=driver.findElement(By.id("lastName"));
        String editLastNameValue="Ardelean";
        editLastNameElement.clear();
        editLastNameElement.sendKeys(editLastNameValue);

        WebElement editUserEmailElement=driver.findElement(By.id("userEmail"));
        String editUserEmailValue="test@gmail.com";
        editUserEmailElement.clear();
        editUserEmailElement.sendKeys(editUserEmailValue);

        WebElement editAgeElement=driver.findElement(By.id("age"));
        String editAgeValue="25";
        editAgeElement.clear();
        editAgeElement.sendKeys(editAgeValue);

        WebElement editSalaryElement=driver.findElement(By.id("salary"));
        String editSalaryValue="2500";
        editSalaryElement.clear();
        editSalaryElement.sendKeys(editSalaryValue);

        WebElement editDepartmentElement=driver.findElement(By.id("department"));
        String editDepartmentValue="Financial";
        editDepartmentElement.clear();
        editDepartmentElement.sendKeys(editDepartmentValue);

        JavascriptExecutor executor = (JavascriptExecutor) driver;

        WebElement editLine = driver.findElement(By.id("submit"));
        executor.executeScript("arguments[0].click();", editLine);


        tableList = driver.findElements(By.xpath("//div[@class='rt-tr -even' or @class='rt-tr -odd']"));
        Assert.assertEquals(tableList.size(), tableSize +1);

        //delete element

        WebElement deleteElement=driver.findElement(By.id("delete-record-4"));
        deleteElement.click();

        tableList = driver.findElements(By.xpath("//div[@class='rt-tr -even' or @class='rt-tr -odd']"));
        Assert.assertEquals(tableList.size(), tableSize);

        driver.quit();
    }
}