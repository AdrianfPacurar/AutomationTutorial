package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class WebTablePage extends BasePage{

    public WebTablePage(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//div[@class='rt-tr -even' or @class='rt-tr -odd']")
    private List<WebElement> tableList;
    @FindBy(id ="addNewRecordButton" )
    private WebElement addElement;
    @FindBy(id ="firstName" )
    private WebElement firstnameElement;
    @FindBy(id ="lastName" )
    private WebElement lastnameElement;
    @FindBy(id ="userEmail" )
    private WebElement emailElement;
    @FindBy(id ="age" )
    private  WebElement ageElement;
    @FindBy(id ="salary" )
    private WebElement salaryElement;
    @FindBy(id ="department" )
    private WebElement departmentElement;
    @FindBy(id = "submit")
    private WebElement submitElement;
    @FindBy(id = "edit-record-4")
    private WebElement editElement;
    @FindBy(id ="firstName" )
    private WebElement editFirstNameElement;
    @FindBy(id ="lastName" )
    private WebElement editLastNameElement;
    @FindBy(id ="userEmail" )
    private WebElement editUserEmailElement;
    @FindBy(id ="age" )
    private  WebElement editAgeElement;
    @FindBy(id ="salary" )
    private WebElement editSalaryElement;
    @FindBy(id ="department" )
    private WebElement editDepartmentElement;
    @FindBy(id ="delete-record-4" )
    private  WebElement deleteElement;

    public void addNewEntry( int tableSize,String firstNameValue,String lastNameValue, String emailValue, String ageValue,String salaryValue, String departmentValue ){
        elementHelper.validateListSize(tableList, tableSize);

        clickAddButton();
        fillFirstName(firstNameValue);
        fillLastName(lastNameValue);
        fillEmail(emailValue);
        fillAge(ageValue);
        fillSalary(salaryValue);
        fillDepartment(departmentValue);
        clickSubmit();
        elementHelper.validateListSize(tableList, tableSize+1);
        elementHelper.validateElementContainsText(tableList.get(tableSize),firstNameValue);
        elementHelper.validateElementContainsText(tableList.get(tableSize),lastNameValue);
        elementHelper.validateElementContainsText(tableList.get(tableSize),emailValue);
        elementHelper.validateElementContainsText(tableList.get(tableSize),ageValue);
        elementHelper.validateElementContainsText(tableList.get(tableSize),salaryValue);
        elementHelper.validateElementContainsText(tableList.get(tableSize),departmentValue);
    }

    public void editNewEntry( int tableSize,String editFirstNameValue,String editLastNameValue, String editEmailValue, String editAgeValue,String editSalaryValue, String editDepartmentValue ){
        elementHelper.validateListSize(tableList, tableSize+1);

        clickEditButton();
        fillEditFirstName(editFirstNameValue);
        fillLEditastName(editLastNameValue);
        fillEditEmail(editEmailValue);
        fillEditAge(editAgeValue);
        fillEditSalary(editSalaryValue);
        fillEditDepartment(editDepartmentValue);
        clickSubmit();

        elementHelper.validateListSize(tableList, tableSize+1);

        elementHelper.validateElementContainsText(tableList.get(tableSize), editFirstNameValue);
        elementHelper.validateElementContainsText(tableList.get(tableSize), editLastNameValue);
        elementHelper.validateElementContainsText(tableList.get(tableSize), editEmailValue);
        elementHelper.validateElementContainsText(tableList.get(tableSize), editAgeValue);
        elementHelper.validateElementContainsText(tableList.get(tableSize), editSalaryValue);
        elementHelper.validateElementContainsText(tableList.get(tableSize), editDepartmentValue);
    }
    public void deleteNewEntry(int tableSize){
        clickDeleteButton();
        elementHelper.validateListSize(tableList, tableSize);
    }

    //1.facem 3 motode pentru add, edit, delete
    //2.facem o metoda individuala pentru actiune = construim add, edit, delete

    public void clickAddButton(){
        elementHelper.clickElement(addElement);
    }
    public void fillFirstName(String firstNameValue){
        elementHelper.fillElement(firstnameElement,firstNameValue);
    }
    public void fillLastName(String lastNameValue){
        elementHelper.fillElement(lastnameElement, lastNameValue);
    }
    public void fillEmail(String emailValue){
        elementHelper.fillElement(emailElement, emailValue);
    }
    public void fillAge(String ageValue){
        elementHelper.fillElement(ageElement, ageValue);
    }
    public void fillSalary(String salaryValue){
        elementHelper.fillElement(salaryElement, salaryValue);
    }
    public void fillDepartment(String departmentValue){
        elementHelper.fillElement(departmentElement, departmentValue);
    }
    public void clickSubmit(){
        elementHelper.clickElement(submitElement);
    }
    public void clickEditButton(){
        elementHelper.clickElement(editElement);
    }
    public void fillEditFirstName(String firstNameValue){
        elementHelper.clearFillElement(editFirstNameElement,firstNameValue);
    }
    public void fillLEditastName(String lastNameValue){
        elementHelper.clearFillElement(editLastNameElement, lastNameValue);
    }
    public void fillEditEmail(String emailValue){
        elementHelper.clearFillElement(editUserEmailElement, emailValue);
    }
    public void fillEditAge(String ageValue){
        elementHelper.clearFillElement(editAgeElement, ageValue);
    }
    public void fillEditSalary(String salaryValue){
        elementHelper.clearFillElement(editSalaryElement, salaryValue);
    }
    public void fillEditDepartment(String departmentValue){
        elementHelper.clearFillElement(editDepartmentElement, departmentValue);
    }
    public void clickDeleteButton(){
        elementHelper.clickElement(deleteElement);
    }
}