package vitalyTests;


import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import vitalyPages.VitalyDoctorRegistrationPage;
import vitalyPages.VitalyLoginPage;


/**
 * Created by vitaliy on 23.11.2016.
 */
public class VitalyDoctorRegistrationTest {
    public static final String PASSWORD = "LinkCare!!11";
    private static final String FIRST_NAME = "Losyara";
    private static final String LAST_NAME = "}I{olud";
    public static final String USERNAME = FIRST_NAME + " " + LAST_NAME;
    private static final String EMAIL = LAST_NAME + "@yopmail.com";
    private static final String PERSONAL_ID = "216473595";
    private static final String CLINIC_NAME = "Makavka";
    private static final String BIRTHDAY = "12-12-1975";
    private static final String CONTACT_CELL = "0521111111";
    private static final String STREET = "Hehalutz";
    private static final String HOUSE_NUMBER = "30";
    private static final String CITY = "Haifa";
    public VitalyDoctorRegistrationPage vitalyDoctorRegistrationPage;
    public VitalyLoginPage vitalyLoginPage;
    public WebDriver driver;

    @BeforeClass()
    public void setup() {

        System.setProperty("webdriver.gecko.driver", "src\\test\\resources\\geckodriver.exe");
        driver = new FirefoxDriver();
        vitalyDoctorRegistrationPage = PageFactory.initElements(driver, VitalyDoctorRegistrationPage.class);
    }

    @BeforeMethod
    public void gotoLoginPage() {
        driver.get("http://dhclinicappv2stg.item-soft.co.il/SitePages/createUser.aspx?ReturnUrl=HomePage");

        // vitalyDoctorRegistrationPage.regClick();
    }

    @Test
    public void registrationDoctorPositive() {
        vitalyDoctorRegistrationPage.WaitRegPageIsLoaded();
        vitalyDoctorRegistrationPage.isOnRegistrationPage();
        vitalyDoctorRegistrationPage.waitUntilIsLoadedCusTime();
        vitalyDoctorRegistrationPage.fillUserNameField(USERNAME);
        vitalyDoctorRegistrationPage.fillFirstNameField(FIRST_NAME);
        vitalyDoctorRegistrationPage.fillLastNameField(LAST_NAME);
        vitalyDoctorRegistrationPage.fillEmailField(EMAIL);
        vitalyDoctorRegistrationPage.fillPasswordFields(PASSWORD);
        vitalyDoctorRegistrationPage.fillPersonalIdField(PERSONAL_ID);
        vitalyDoctorRegistrationPage.fillClinicNameTxtField(CLINIC_NAME);
        vitalyDoctorRegistrationPage.fillBirthdayTxtField(BIRTHDAY);
        vitalyDoctorRegistrationPage.fillContactCellTxtField(CONTACT_CELL);
        vitalyDoctorRegistrationPage.fillAdressFields(CITY, STREET, HOUSE_NUMBER);
        vitalyDoctorRegistrationPage.clickOnSaveNewDoctorButton();
    }
}
