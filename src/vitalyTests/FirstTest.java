package vitalyTests;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import vitalyPages.FirstPage;
import vitalyPages.StartPage;

public class FirstTest {

        FirefoxDriver driver;
        public FirstPage firstPage;
        public StartPage startPage;

        @BeforeClass()
        public void setup() {
                System.setProperty("webdriver.gecko.driver", "resources//geckodriver.exe");
                driver = new FirefoxDriver();
                driver.get("https://www.google.com/intl/ru/gmail/about/#");
                startPage = PageFactory.initElements(driver, StartPage.class);
                firstPage = PageFactory.initElements(driver, FirstPage.class);
        }

        @Test
        public void LoginPositiveTest(){

                String parentHandle = driver.getWindowHandle();
                startPage.ClickCreateAccountButton();
                driver.getWindowHandles();
                for(String childHandle : driver.getWindowHandles()) {
                        if(!childHandle.equals(parentHandle)) {
                                driver.switchTo().window(childHandle);
                        }
                }
      }

        @Test
        public void loginNegativeTest() {

                firstPage.WaitCreateForm();
                firstPage.FillFirstName("");
                firstPage.FillLastName("45khgff6");
                firstPage.FillGmailAddress("zxcvbnmjjhhh");
                firstPage.FillPassword("456hgfyb");
                firstPage.FillPasswordAgain("456hgfyb");
                firstPage.SelectMonth(12);
                firstPage.SetBirthMonth();
                firstPage.FillBirthDay("25");
                firstPage.FillBirthYear("1996");
                firstPage.SetGender();
                firstPage.ClickSubmitButton();
        }

        @AfterClass
        public void tearDown() { this.driver.quit(); }
}