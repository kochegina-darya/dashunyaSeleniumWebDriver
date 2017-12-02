package vitalyPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FirstPage extends Page {

//Create Account Page Element

    @FindBy(id = "createaccount")
    WebElement formCreateAccount;
    @FindBy(id="FirstName")
    WebElement firstNamefield;
    @FindBy(id = "LastName")
    WebElement lastNamefield;
    @FindBy(id = "GmailAddress")
    WebElement gmailAddressfield;
    @FindBy(id = "Passwd")
    WebElement passwordfield;
    @FindBy(id = "PasswdAgain")
    WebElement passwordAgainfield;
    @FindBy(id = "BirthMonth")
    WebElement birthMonthfield;
    @FindBy(id = "BirthDay")
    WebElement birthDayfield;
    @FindBy(id = "BirthYear")
    WebElement birthYearfield;
    @FindBy(id = "Gender")
    WebElement genderfield;
    @FindBy(id = "submitbutton")
    WebElement submitbutton;

//Months Menu

    @FindBy(id = ":1")
    WebElement January;
    @FindBy(id = ":2")
    WebElement February;
    @FindBy(id = ":3")
    WebElement March;
    @FindBy(id = ":4")
    WebElement April;
    @FindBy(id = ":5")
    WebElement May;
    @FindBy(id = ":6")
    WebElement June;
    @FindBy(id = ":7")
    WebElement July;
    @FindBy(id = ":8")
    WebElement August;
    @FindBy(id = ":9")
    WebElement September;
    @FindBy(id = ":a")
    WebElement October;
    @FindBy(id = ":b")
    WebElement November;
    @FindBy(id = ":c")
    WebElement December;

//Gender Menu

    @FindBy(id = ":e")
    WebElement Female;
    @FindBy(id = ":f")
    WebElement Male;
    @FindBy(id = ":g")
    WebElement Other;
    @FindBy(id = ":h")
    WebElement Rather_not_say;


    public FirstPage(WebDriver driver) {
        super(driver);
        this.PAGE_URL = "https://accounts.google.com/SignUp?service=mail&continue=http%3A%2F%2Fmail.google.com%2Fmail%2F%3Fpc%3Dcarousel-about-en";
        PageFactory.initElements(driver, this);
    }

    public void WaitCreateForm() {
        waitUntilIsLoadedCustomTime(formCreateAccount, 5000);
    }

    public void FillFirstName(String firstName) { setElementText(firstNamefield, firstName); }

    public void FillLastName(String lastName) {
        setElementText(lastNamefield, lastName);
    }

    public void FillGmailAddress(String gmail) {
        setElementText(gmailAddressfield, gmail);
    }

    public void FillPassword(String password) { setElementText(passwordfield, password);}

    public void FillPasswordAgain(String password) {setElementText(passwordAgainfield, password);}

    public void SetBirthMonth() {
        selectSpanElement(birthMonthfield, month);
    }

    public void FillBirthDay(String day) {setElementText(birthDayfield, day);}

    public void FillBirthYear(String year) {setElementText(birthYearfield, year);}

    public void SetGender() {selectSpanElement(genderfield, Male);}

    public void ClickSubmitButton() {
        clickElement(submitbutton);
    }

    WebElement month;
    public WebElement SelectMonth(int m){
        switch (m) {
            case 1: month = January;
               break;
            case 2: month = February;
                break;
            case 3: month = March;
                break;
            case 4: month = April;
                break;
            case 5: month = May;
                break;
            case 6: month = June;
                break;
            case 7: month = July;
                break;
            case 8: month = August;
                break;
            case 9: month = September;
                break;
            case 10: month = October;
                break;
            case 11: month = November;
                break;
            case 12: month = December;
                break;
         }  return month;
    }
}
