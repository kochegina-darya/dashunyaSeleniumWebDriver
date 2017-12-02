package vitalyPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Vitaly on 23.11.2016.
 */
public class VitalyDoctorRegistrationPage extends Page {

    //Fields
    @FindBy(id = "MainContent_LoginUser_RegisterHyperLink")
    WebElement RegButton;
    @FindBy(id = "MainContent_RegisterUser_CreateUserStepContainer_UserName")
    WebElement UserName;
    @FindBy(id = "MainContent_RegisterUser_CreateUserStepContainer_firstNameTxt")
    WebElement FirstName;
    @FindBy(id = "MainContent_RegisterUser_CreateUserStepContainer_lastNameTxt")
    WebElement LastName;
    @FindBy(id = "MainContent_RegisterUser_CreateUserStepContainer_Email")
    WebElement Email;
    @FindBy(id = "MainContent_RegisterUser_CreateUserStepContainer_Password")
    WebElement Passord;
    @FindBy(id = "MainContent_RegisterUser_CreateUserStepContainer_ConfirmPassword")
    WebElement RepeatThePassword;
    @FindBy(id = "MainContent_RegisterUser_CreateUserStepContainer_PersonalIdTxt")
    WebElement PersonalId;
    @FindBy(id = "MainContent_RegisterUser_CreateUserStepContainer_AddressTxt")
    WebElement Street;
    @FindBy(id = "MainContent_RegisterUser_CreateUserStepContainer_HouseNumberTxt")
    WebElement HouseNumber;
    @FindBy(id = "MainContent_RegisterUser_CreateUserStepContainer_CityTxt")
    WebElement City;
    @FindBy(id = "MainContent_AddNewUser")
    WebElement addDoctorButton;
    @FindBy(id = "MainContent_RegisterUser_CreateUserStepContainer_clinicNameTxt")
    WebElement clinicNameTxt;
    @FindBy(id = "ctl00_MainContent_RegisterUser_CreateUserStepContainer_birthdayTxt_dateInput")
    WebElement birthdayTxt;
    @FindBy(id = "ctl00_MainContent_RegisterUser_CreateUserStepContainer_ContactCellTxt")
    WebElement contactCellTxt;




    //Methods
    public VitalyDoctorRegistrationPage(WebDriver driver) {
        super(driver);
        baseUrl = "http://dhclinicappv2stg.item-soft.co.il/Login.aspx";
        this.PAGE_URL = baseUrl + "/SitePages/createUser.aspx?ReturnUrl=HomePage";
        PageFactory.initElements(driver, this);
    }

    public void regClick() {
        RegButton.click();
    }
    public void waitUntilIsLoadedCusTime() {
        waitUntilIsLoadedCustomTime(UserName, 10);
    }

    public void fillUserNameField(String userName) {
        setElementText(UserName, userName);
    }

    public void fillFirstNameField(String firstName) {
        setElementText(FirstName, firstName);
    }

    public void fillLastNameField(String lastName) {
        setElementText(LastName, lastName);
    }

    public void fillEmailField(String email) {
        setElementText(Email, email);
    }

    public void fillClinicNameTxtField(String clinicName) {
        setElementText(clinicNameTxt, clinicName);
    }

    public void fillBirthdayTxtField(String birthday) {
        setElementText(birthdayTxt, birthday);
    }

    public void fillContactCellTxtField(String contactCell) {
        setElementText(contactCellTxt, contactCell);
    }

    public void WaitRegPageIsLoaded() {
        waitUntilIsLoadedCustomTime(addDoctorButton, 10);
    }

    public boolean isOnRegistrationPage() {
        return exists(addDoctorButton);
    }

    public void fillPasswordFields(String password) {
        setElementText(Passord, password);
        setElementText(RepeatThePassword, password);
    }

    public void fillPersonalIdField(String id) {
        setElementText(PersonalId, id);

    }

    public void fillAdressFields(String city, String street, String houseNumber) {
        setElementText(City, city);
        setElementText(Street, street);
        setElementText(HouseNumber, houseNumber);
    }

    public void clickOnSaveNewDoctorButton() {
        clickElement(addDoctorButton);
    }

    public void DoctorRegisttation(String username, String firstname, String lastname, String email, String password, String id,
                                   String city, String street, String housenumber, String clinicName, String birthday, String cell) {
        WaitRegPageIsLoaded();
        isOnRegistrationPage();
        fillUserNameField(username);
        fillFirstNameField(firstname);
        fillLastNameField(lastname);
        fillEmailField(email);
        fillPasswordFields(password);
        fillPersonalIdField(id);
        fillClinicNameTxtField(clinicName);
        fillBirthdayTxtField(birthday);
        fillContactCellTxtField(cell);
        fillAdressFields(city, street, housenumber);
        clickOnSaveNewDoctorButton();
    }


}
