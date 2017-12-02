package vitalyPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Vitaly on 10.12.2016.
 */
public class VitalyDoctorPage extends Page{
    @FindBy(id = "ctl00_DisplayImportantLinks1_myMenu")
    WebElement DoctorsRightMenu;
    @FindBy(id = "Top1_HeadLoginStatus")
    WebElement ExitLink;

    //Methods
    public VitalyDoctorPage(WebDriver driver) {
        super(driver);
        baseUrl = "http://dhclinicappv2stg.item-soft.co.il/Login.aspx";
        this.PAGE_URL = baseUrl + "/SitePages/createUser.aspx?ReturnUrl=HomePage";
        PageFactory.initElements(driver, this);
    }
    public void waitUntilDoctorsPageIsLoaded() {
        waitUntilIsLoadedCustomTime(DoctorsRightMenu, 10);
    }

    public boolean isOnDoctorPage() {
        return exists(ExitLink);
    }

    public String getTextFromExitLink() {
        return ExitLink.getText();
    }
}
