package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;
import java.util.List;

public class PracticeFormPage extends BasePage{

    public PracticeFormPage(WebDriver driver){
        super(driver);
    }

    @FindBy(css = "input[placeholder='First Name']")
    private WebElement firstNameElement;
    @FindBy(css = "input[placeholder='Last Name']")
    private WebElement lastNameElement;
    @FindBy(css ="input[placeholder='name@example.com']" )
    private WebElement emailElement;
    @FindBy(css ="input[placeholder='Mobile Number']" )
    private WebElement phoneNumberElement;
    @FindBy(id ="subjectsInput" )
    private WebElement subjectsElement;
    @FindBy(css = "div[id='genterWrapper'] label[class='custom-control-label']")
    private List<WebElement> genderElementList;
    @FindBy(css = "div[id='hobbiesWrapper']>div>div>label[class='custom-control-label']")
    private List<WebElement> hobbiesElementList;
    @FindBy(id = "uploadPicture")
    private WebElement uploadElement;
    @FindBy(id ="currentAddress")
    private WebElement currentAddressElement;
    @FindBy(id = "state")
    private  WebElement stateElement;
    @FindBy(id = "react-select-3-input")
    private WebElement stateInputElement;
    @FindBy(id = "city")
    private WebElement cityElement;
    @FindBy(id = "react-select-4-input")
    private WebElement cityInputElement;
    @FindBy(id = "submit")
    private WebElement submitElement;
    @FindBy(xpath = "//table//td[1]")
    private List<WebElement> tableDescriptionList;
    @FindBy(xpath = "//table//td[2]")
    private List<WebElement> tableValueList;

    public void  fillEntireForm(String firstNameValue,  String lastNameValue,String emailValue,String phoneNumberValue,
                                List<String> subjectsValue, String genderValue, List<String> hobbyValue, String uploadValue,
                                String currentAddressValue, String stateValue,  String cityValue){

        elementHelper.fillElement(firstNameElement,firstNameValue);

        elementHelper.fillElement(lastNameElement,lastNameValue);

        elementHelper.fillElement(emailElement,emailValue);

        elementHelper.fillElement(phoneNumberElement,phoneNumberValue);

        for(int index = 0; index < subjectsValue.size(); index++) {
            elementHelper.fillPressElement(subjectsElement, subjectsValue.get(index), Keys.ENTER);
        }


        switch (genderValue) {
            case "Male":
                elementHelper.clickElement(genderElementList.get(0));
                break;
            case "Female":
                elementHelper.clickElement(genderElementList.get(1));
                break;
            case "Other":
                elementHelper.clickElement(genderElementList.get(2));
                break;

        }
        pageHelper.scrollPage(0, 400);

        for (int index = 0; index < hobbiesElementList.size(); index++){
            if (hobbyValue.contains(hobbiesElementList.get(index).getText())) {
                elementHelper.clickElement(hobbiesElementList.get(index));
            }
        }

        File file = new File(uploadValue);
        elementHelper.fillElement(uploadElement,file.getAbsolutePath());

        elementHelper.fillElement(currentAddressElement, currentAddressValue);

        JavascriptExecutor executor = (JavascriptExecutor) driver;

        elementHelper.clickJSElement(stateElement);

        elementHelper.fillPressElement(stateInputElement,stateValue, Keys.ENTER);

        elementHelper.fillPressElement(cityInputElement, cityValue, Keys.ENTER);

        elementHelper.clickElement(submitElement);
    }

    public void validateFormValues(String firstNameValue, String lastNameValue, String emailValue, String genderValue, String phoneNumberValue, List <String> subjectsValue,
                                   List<String> hobbyValue, String filename, String addressValue , String stateValue, String cityValue  ){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Validate Student Name section
        wait.until(ExpectedConditions.visibilityOf(tableDescriptionList.get(0)));
        elementHelper.validateElementEqualsText(tableDescriptionList.get(0), "Student Name");
        elementHelper.validateElementEqualsText(tableDescriptionList.get(0), "Student Name");
        elementHelper.validateElementContainsText(tableValueList.get(0), firstNameValue);
        elementHelper.validateElementContainsText(tableValueList.get(0), lastNameValue);

        elementHelper.validateElementEqualsText(tableDescriptionList.get(1), "Student Email");
        elementHelper.validateElementEqualsText(tableValueList.get(1), emailValue);

        elementHelper.validateElementEqualsText(tableDescriptionList.get(2), "Gender");
        elementHelper.validateElementEqualsText(tableValueList.get(2), genderValue);

        elementHelper.validateElementEqualsText(tableDescriptionList.get(3), "Mobile");
        elementHelper.validateElementEqualsText(tableValueList.get(3), phoneNumberValue);

        elementHelper.validateElementEqualsText(tableDescriptionList.get(5), "Subjects");
        elementHelper.validateElementEqualsText(tableValueList.get(5), String.join(", ", subjectsValue));

        elementHelper.validateElementEqualsText(tableDescriptionList.get(6), "Hobbies");
        elementHelper.validateElementEqualsText(tableValueList.get(6), String.join(", ",hobbyValue ));

        File file = new File(filename);

        elementHelper.validateElementEqualsText(tableDescriptionList.get(7), "Picture");
        elementHelper.validateElementEqualsText(tableValueList.get(7), file.getName());

        elementHelper.validateElementEqualsText(tableDescriptionList.get(8), "Address");
        elementHelper.validateElementEqualsText(tableValueList.get(8), addressValue);

        elementHelper.validateElementEqualsText(tableDescriptionList.get(9), "State and City");
        elementHelper.validateElementContainsText(tableValueList.get(9), stateValue);
        elementHelper.validateElementContainsText(tableValueList.get(9), cityValue);
    }
}