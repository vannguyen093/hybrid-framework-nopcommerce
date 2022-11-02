package pageObjects.liveGuru.user;

import commons.BasePage;
import org.openqa.selenium.WebDriver;

public class AccountInforPageObject extends BasePage {
    private WebDriver driver;

    public AccountInforPageObject(WebDriver driver) {
        this.driver = driver;
    }
}
