package vitalyTests;


import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.AssertJUnit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import vitalyPages.VitalyDoctorPage;
import vitalyPages.VitalyLoginPage;


/**
 * Created by Vitaly on 28.11.2016.
 */
public class VitalyLoginTest {

    public VitalyLoginPage vitalyLoginPage;
    public VitalyDoctorPage vitalyDoctorPage;
    FirefoxDriver driver;


    @BeforeClass()
    public void setup() {

        System.setProperty("webdriver.gecko.driver", "resources//geckodriver.exe");
        driver = new FirefoxDriver();
        vitalyLoginPage = PageFactory.initElements(driver, VitalyLoginPage.class);
        vitalyDoctorPage = PageFactory.initElements(driver, VitalyDoctorPage.class);
    }

    @BeforeMethod(alwaysRun = true)
    public void gotoLoginPage() {
        driver.get("https://medisafe.com/");

    }

    @Test(groups = {"login ", "positive"})
    public void loginPositiveTest() {
        vitalyLoginPage.WaitUntilLoginPageIsLoaded();
        vitalyLoginPage.FillUserName("5555Doctor");
        vitalyLoginPage.FillPassword("LinkCare!!11");
        vitalyLoginPage.ClickLogIn();
        vitalyDoctorPage.waitUntilDoctorsPageIsLoaded();
        Assert.assertTrue("We are not on doctor`s page", vitalyDoctorPage.isOnDoctorPage());
        Assert.assertEquals("יציאה", vitalyDoctorPage.getTextFromExitLink());
        AssertJUnit.assertEquals("יציאה", vitalyDoctorPage.getTextFromExitLink());
        tearDown();
    }


    @Test(groups = {"login ", "negative"})
    public void loginNegativeTest() {
        vitalyLoginPage.WaitUntilLoginPageIsLoaded();
        vitalyLoginPage.FillUserName("123");
        vitalyLoginPage.FillPassword("456");
        vitalyLoginPage.ClickLogIn();
        Assert.assertEquals(vitalyDoctorPage.getTextFromExitLink(), "Login");
    }

    @Test(groups = {"login ", "negative"})
    public void loginNullUserNameTest() {
        vitalyLoginPage.WaitUntilLoginPageIsLoaded();
        vitalyLoginPage.FillUserName(" ");
        vitalyLoginPage.FillPassword("LinkCare!!11");
        vitalyLoginPage.ClickLogIn();
        Assert.assertEquals(vitalyDoctorPage.getTextFromExitLink(), "Login");
    }

    @Test(groups = {"login ", "negative"})
    public void loginNullPasswordTest() {
        vitalyLoginPage.WaitUntilLoginPageIsLoaded();
        vitalyLoginPage.FillUserName("5555Doctor");
        vitalyLoginPage.FillPassword("");
        vitalyLoginPage.ClickLogIn();
        Assert.assertEquals(vitalyDoctorPage.getTextFromExitLink(), "Login");
    }

    @AfterClass
    public void tearDown() {
        this.driver.quit();
    }

}
