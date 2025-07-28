package tests;

import org.openqa.selenium.*;
import org.testng.annotations.Test;
import pages.FormsPage;
import pages.IndexPage;
import pages.PracticeFormPage;
import sharedData.SharedData;

import java.util.Arrays;
import java.util.List;

public class PracticeFormTest extends SharedData {


    @Test
    public void TestMethod() {

        IndexPage indexPage = new IndexPage(getDriver());
        indexPage.interactWithFormsMenu();

        FormsPage formsPage = new FormsPage(getDriver());
        formsPage.interactWithPracticeFormSubMenu();


        String firstNameValue = "Vladut";
        String lastNameValue = "Ardelean";
        String emailValue = "vardy@gmail.com";
        String phoneNumberValue = "0454355665";
        List<String> subjectsValue = Arrays.asList("Accounting", "Arts", "Maths");
        String genderValue = "Female";
        List<String> hobbyValue = Arrays.asList("Sports", "Reading");
        String uploadValue = "src/test/resources/pozacurs.jpeg";
        String currentAddressValue = "Str Caprioarei nr. 15 , apt. 17";
        JavascriptExecutor executor = (JavascriptExecutor) getDriver();
        String stateValue = "Uttar Pradesh";
        String cityValue = "Agra";

        PracticeFormPage practiceFormPage = new PracticeFormPage(getDriver());
        practiceFormPage.fillEntireForm(firstNameValue, lastNameValue, emailValue, phoneNumberValue, subjectsValue, genderValue,
                hobbyValue, uploadValue, currentAddressValue, stateValue,cityValue);

        practiceFormPage.validateFormValues(firstNameValue,lastNameValue, emailValue, genderValue, phoneNumberValue, subjectsValue, hobbyValue, uploadValue, currentAddressValue, stateValue, cityValue);

    }
}