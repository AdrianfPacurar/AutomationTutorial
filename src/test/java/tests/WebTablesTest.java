package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class WebTablesTest {
    public WebDriver driver;

    @Test
    public void testMethod(){
        //deschidem o instanta de Chrome
        driver=new ChromeDriver();

        //accesam o pagina specifica
        driver.get("https://demoqa.com");

        //facem browser-ul sa fie in modul maximize
        driver.manage().window().maximize();
        WebElement elementName=driver.findElement(By.xpath("//h5[text()='Elements']"));
        elementName.click();

        WebElement webtablesubmenu=driver.findElement(By.xpath("//span[text()='Web Tables']"));
        webtablesubmenu.click();

        List<WebElement> tableList=driver.findElements(By.xpath("//div[@class='rt-tr -even' or @class='rt-tr -odd']"));
        int tableSize=3;
        Assert.assertEquals(tableList.size(), tableSize,"Expected table size:" +tableSize +" is not correct");

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

        tableList=driver.findElements(By.xpath("//div[@class='rt-tr -even' or @class='rt-tr -odd']"));
        Assert.assertEquals(tableList.size(), tableSize +1);
        Assert.assertTrue(tableList.get(tableSize).getText().contains(firstnameValue));
        Assert.assertTrue(tableList.get(tableSize).getText().contains(lastnameValue));
        Assert.assertTrue(tableList.get(tableSize).getText().contains(emailValue));
        Assert.assertTrue(tableList.get(tableSize).getText().contains(ageValue));
        Assert.assertTrue(tableList.get(tableSize).getText().contains(salaryValue));
        Assert.assertTrue(tableList.get(tableSize).getText().contains(departmentValue));





        //edit functinality

        WebElement editElement= driver.findElement(By.id("edit-record-4"));
        editElement.click();

        WebElement editfirstnameElement= driver.findElement(By.id("firstName"));
        String editfirstnameValue= "Adrian";
        editfirstnameElement.clear();
        editfirstnameElement.sendKeys(editfirstnameValue);

        WebElement editlasttnameElement= driver.findElement(By.id("lastName"));
        String editlastnameValue= "Pacurar";
        editlasttnameElement.clear();
        editlasttnameElement.sendKeys(editlastnameValue);

        WebElement editemailElement= driver.findElement(By.id("userEmail"));
        String editemailValue= "Pacurar@test.com";
        editemailElement.clear();
        editemailElement.sendKeys(editemailValue);

        WebElement editageElement= driver.findElement(By.id("age"));
        String editageValue= "39";
        editageElement.clear();
        editageElement.sendKeys(editageValue);

        WebElement editsalaryElement= driver.findElement(By.id("salary"));
        String editsalaryValue= "5000";
        editsalaryElement.clear();
        editsalaryElement.sendKeys(editsalaryValue);

        WebElement editdepartamentElement= driver.findElement(By.id("department"));
        String editdepartamentValue= "QA";
        editdepartamentElement.clear();
        editdepartamentElement.sendKeys(editdepartamentValue);

        // force click
        JavascriptExecutor executor = (JavascriptExecutor) driver;

        WebElement editLine = driver.findElement(By.id("submit"));
        executor.executeScript("arguments[0].click();", editLine);

        tableList=driver.findElements(By.xpath("//div[@class='rt-tr -even' or @class='rt-tr -odd']"));
        Assert.assertEquals(tableList.size(), tableSize +1);
        Assert.assertTrue(tableList.get(tableSize).getText().contains(editfirstnameValue));
        Assert.assertTrue(tableList.get(tableSize).getText().contains(editlastnameValue));
        Assert.assertTrue(tableList.get(tableSize).getText().contains(editemailValue));
        Assert.assertTrue(tableList.get(tableSize).getText().contains(editageValue));
        Assert.assertTrue(tableList.get(tableSize).getText().contains(editsalaryValue));
        Assert.assertTrue(tableList.get(tableSize).getText().contains(editdepartamentValue));



        // delete element

        WebElement deleteElement= driver.findElement(By.id("delete-record-4"));
        deleteElement.click();

        tableList=driver.findElements(By.xpath("//div[@class='rt-tr -even' or @class='rt-tr -odd']"));
        Assert.assertEquals(tableList.size(), tableSize );
//        driver.quit();
    }
}