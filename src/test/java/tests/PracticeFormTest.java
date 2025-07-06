package tests;

import helperMethods.ElementHelper;
import helperMethods.PageHelper;
import sharedData.SharedData;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.time.Duration;
import java.util.*;

public class PracticeFormTest extends SharedData {

    @Test
    public void testMethod() {

        ElementHelper elementHelper = new ElementHelper(driver);
        PageHelper pageHelper = new PageHelper(driver);

        WebElement formsMenu = driver.findElement(By.xpath("//h5[text() = 'Forms']"));
        elementHelper.clickJSElement(formsMenu);

        WebElement practiceFormSubmenu = driver.findElement(By.xpath("//span[text() = 'Practice Form']"));
        elementHelper.clickJSElement(practiceFormSubmenu);

        WebElement firstNameElement = driver.findElement(By.cssSelector("input[placeholder='First Name']"));
        elementHelper.fillElement(firstNameElement,"Gigel");

        WebElement lastNameElement = driver.findElement(By.cssSelector("input[placeholder='Last Name']"));
        elementHelper.fillElement(lastNameElement,"Banel");

        WebElement emailElement = driver.findElement(By.cssSelector("input[placeholder='name@example.com']"));
        elementHelper.fillElement(emailElement,"gigel.banel@email.com");

        WebElement mobileNoElement = driver.findElement(By.cssSelector("input[placeholder='Mobile Number']"));
        elementHelper.fillElement(mobileNoElement,"22222222222");

        WebElement subjectsElement = driver.findElement(By.id("subjectsInput"));
        List<String> subjectValues = Arrays.asList("Accounting", "Maths", "Arts");
        for(int index = 0; index<subjectValues.size(); index++){
            elementHelper.fillPressElement(subjectsElement,subjectValues.get(index),Keys.ENTER);
        }

        String genderValue = "Male";
        List<WebElement> genderElementList = driver.findElements(By.cssSelector("div[id = 'genterWrapper'] label[class='custom-control-label']"));
        switch (genderValue){
            case "Male":
                elementHelper.clickElement(genderElementList.get(0));
                break;
            case "Female":
                elementHelper.clickElement(genderElementList.get(1));
                break;
            case "Other":
                elementHelper.clickElement(genderElementList.get(2));
                break;
            default:
                System.out.println("Gender is not available");
        }

        //pt a da scroll in jos (daca valoare pozitiva , atunci face scroll la dr sau in jos)
        pageHelper.scrollPage(0,400);

        List<WebElement> hobbiesElementList = driver.findElements(By.cssSelector("div[id = 'hobbiesWrapper'] label[class='custom-control-label']"));
        List<String> hobbyValues = Arrays.asList("Reading", "Music");
        for(int index = 0; index<hobbiesElementList.size();index++){
            if(hobbyValues.contains(hobbiesElementList.get(index).getText())){
                elementHelper.clickJSElement(hobbiesElementList.get(index));
            }
        }

        WebElement fileUpload = driver.findElement(By.id("uploadPicture"));
        String uploadValue = "src/test/resources/pozacurs.jpeg";
        File file = new File(uploadValue);
        elementHelper.fillElement(fileUpload,file.getAbsolutePath());

        WebElement currentAddressElement = driver.findElement(By.id("currentAddress"));
        String addressValue = "Asta e adresaaaaaa";
        elementHelper.fillElement(currentAddressElement,addressValue);

        WebElement stateElement = driver.findElement(By.id("state"));
        elementHelper.clickJSElement(stateElement);
        WebElement stateInputElement = driver.findElement(By.id("react-select-3-input"));
        String stateValue = "NCR";
        elementHelper.fillPressElement(stateInputElement,stateValue,Keys.ENTER);

        WebElement cityElement = driver.findElement(By.id("city"));
        elementHelper.clickJSElement(cityElement);
        WebElement cityInputElement = driver.findElement(By.id("react-select-4-input"));
        String cityValue = "Noida";
        elementHelper.fillPressElement(cityInputElement,cityValue,Keys.ENTER);

        WebElement submitElement = driver.findElement(By.id("submit"));
        elementHelper.clickJSElement(submitElement);

        List<WebElement> tableDescriptionList = driver.findElements(By.xpath("//table//td[1]"));
        List<WebElement> tableValueList = driver.findElements(By.xpath("//table//td[2]"));

        elementHelper.validateElementEqualsText(tableDescriptionList.get(0),"Student Name");
        elementHelper.validateElementContainsText(tableValueList.get(0), firstNameElement.getText());
        elementHelper.validateElementContainsText(tableValueList.get(0), lastNameElement.getText());

        elementHelper.validateElementEqualsText(tableDescriptionList.get(1), "Student Email");
        elementHelper.validateElementEqualsText(tableValueList.get(1), "gigel.banel@email.com");

        elementHelper.validateElementEqualsText(tableDescriptionList.get(2), "Gender");
        elementHelper.validateElementEqualsText(tableValueList.get(2), genderValue);

        elementHelper.validateElementEqualsText(tableDescriptionList.get(3), "Mobile");
        elementHelper.validateElementEqualsText(tableValueList.get(3), "2222222222");

        String allSubjects = String.join(", ",subjectValues);
        elementHelper.validateElementEqualsText(tableDescriptionList.get(5),"Subjects");
        elementHelper.validateElementEqualsText(tableValueList.get(5),allSubjects);

        String allHobbies = String.join(", ",hobbyValues);
        elementHelper.validateElementEqualsText(tableDescriptionList.get(6),"Hobbies");
        elementHelper.validateElementEqualsText(tableValueList.get(6),allHobbies);

        String fileName = uploadValue.substring(19);
        elementHelper.validateElementEqualsText(tableDescriptionList.get(7), "Picture");
        elementHelper.validateElementEqualsText(tableValueList.get(7), fileName);

        elementHelper.validateElementEqualsText(tableDescriptionList.get(8), "Address");
        elementHelper.validateElementEqualsText(tableValueList.get(8), addressValue);

        elementHelper.validateElementEqualsText(tableDescriptionList.get(9), "State and City");
        elementHelper.validateElementContainsText(tableValueList.get(9),stateValue);
        elementHelper.validateElementContainsText(tableValueList.get(9),cityValue);
    }
}