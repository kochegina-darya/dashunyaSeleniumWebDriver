package vitalyPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StartPage extends Page {

    @FindBy(xpath = "//a[text()='СОЗДАТЬ АККАУНТ']")
    WebElement createAccountbutton;

    public StartPage(WebDriver driver) {
        super(driver);
        this.PAGE_URL = "https://www.google.com/intl/ru/gmail/about/#";
        PageFactory.initElements(driver, this);
    }

    public void ClickCreateAccountButton() {
        waitUntilIsLoaded(createAccountbutton);
        clickElement(createAccountbutton);
    }
}
