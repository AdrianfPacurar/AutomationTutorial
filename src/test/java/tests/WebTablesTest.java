package tests;

import helperMethods.ElementHelper;
import sharedData.SharedData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class WebTablesTest extends SharedData {


    @Test
    public void testMethod() {

        ElementHelper elementHelper = new ElementHelper(driver);

        WebElement elementsMenu = driver.findElement(By.xpath("//h5[text() = 'Elements']"));
        elementHelper.clickJSElement(elementsMenu);

        WebElement webTableSubmenu = driver.findElement(By.xpath("//span[text() = 'Web Tables']"));
        elementHelper.clickJSElement(webTableSubmenu);


        int tableSize = 3;
        List<WebElement> tableList = driver.findElements(By.xpath("//div[@class = 'rt-tr -even' or @class = 'rt-tr -odd']"));
        elementHelper.validateListSize(tableList, tableSize);

        //Identificam un element
        WebElement addElement = driver.findElement(By.id("addNewRecordButton"));
        elementHelper.clickJSElement(addElement);

        WebElement firstNameElement = driver.findElement(By.id("firstName"));
        String firstNameValue = "Fanel";
        elementHelper.fillElement(firstNameElement,firstNameValue);

        WebElement lastNameElement = driver.findElement(By.id("lastName"));
        String lastNameValue = "Sandu";
        elementHelper.fillElement(lastNameElement,lastNameValue);

        WebElement emailElement = driver.findElement(By.id("userEmail"));
        String emailValue = "fanel.sandu@email.com";
        elementHelper.fillElement(emailElement,emailValue);

        WebElement ageElement = driver.findElement(By.id("age"));
        String ageValue = "22";
        elementHelper.fillElement(ageElement,ageValue);

        WebElement salaryElement = driver.findElement(By.id("salary"));
        String salaryValue = "5000";
        elementHelper.fillElement(salaryElement,salaryValue);

        WebElement departmentElement = driver.findElement(By.id("department"));
        String departmentValue = "IT";
        elementHelper.fillElement(departmentElement,departmentValue);

        WebElement addLine = driver.findElement(By.id("submit"));
        elementHelper.clickJSElement(addLine);

        tableList = driver.findElements(By.xpath("//div[@class = 'rt-tr -even' or @class = 'rt-tr -odd']"));
        elementHelper.validateListSize(tableList,tableSize+1);

        elementHelper.validateElementContainsText(tableList.get(tableSize),firstNameValue);
        elementHelper.validateElementContainsText(tableList.get(tableSize),lastNameValue);
        elementHelper.validateElementContainsText(tableList.get(tableSize),emailValue);
        elementHelper.validateElementContainsText(tableList.get(tableSize),ageValue);
        elementHelper.validateElementContainsText(tableList.get(tableSize),salaryValue);
        elementHelper.validateElementContainsText(tableList.get(tableSize),departmentValue);

        //Edit functionality
        WebElement editElement = driver.findElement(By.id("edit-record-4"));
        elementHelper.clickJSElement(editElement);

        WebElement editFirstNameElement = driver.findElement(By.id("firstName"));
        String editFirstNameValue = "Mihai";
        elementHelper.clearFillElement(editFirstNameElement,editFirstNameValue);

        WebElement editLastNameElement = driver.findElement(By.id("lastName"));
        String editLastNameValue = "Kerucov";
        elementHelper.clearFillElement(editLastNameElement,editLastNameValue);

        WebElement editEmailElement = driver.findElement(By.id("userEmail"));
        String editEmailValue = "mihai.kerucov@email.com";
        elementHelper.clearFillElement(editEmailElement,editEmailValue);

        WebElement editAgeElement = driver.findElement(By.id("age"));
        String editAgeValue = "55";
        elementHelper.clearFillElement(editAgeElement,editAgeValue);

        WebElement editSalaryElement = driver.findElement(By.id("salary"));
        String editSalaryValue = "11111";
        elementHelper.clearFillElement(editSalaryElement,editSalaryValue);

        WebElement editDepartmentElement = driver.findElement(By.id("department"));
        String editDepartmentValue = "HR";
        elementHelper.clearFillElement(editDepartmentElement,editDepartmentValue);

        WebElement editLine = driver.findElement(By.id("submit"));
        elementHelper.clickJSElement(editLine);

        tableList = driver.findElements(By.xpath("//div[@class = 'rt-tr -even' or @class = 'rt-tr -odd']"));
        elementHelper.validateListSize(tableList, tableSize+1);

        elementHelper.validateElementContainsText(tableList.get(tableSize), editFirstNameValue);
        elementHelper.validateElementContainsText(tableList.get(tableSize), editLastNameValue);
        elementHelper.validateElementContainsText(tableList.get(tableSize), editEmailValue);
        elementHelper.validateElementContainsText(tableList.get(tableSize), editAgeValue);
        elementHelper.validateElementContainsText(tableList.get(tableSize), editSalaryValue);
        elementHelper.validateElementContainsText(tableList.get(tableSize), editDepartmentValue);

        //Delete functionality
        WebElement deleteElement = driver.findElement(By.id("delete-record-4"));
        elementHelper.clickJSElement(deleteElement);

        tableList = driver.findElements(By.xpath("//div[@class = 'rt-tr -even' or @class = 'rt-tr -odd']"));
        elementHelper.validateListSize(tableList, tableSize);

    }
}