package pageObjects.liveGuru;

import commons.BasePage;
import org.openqa.selenium.WebDriver;

public class AddressBookPageObject extends BasePage {
    private WebDriver driver;

    public AddressBookPageObject(WebDriver driver) {
        this.driver = driver;
    }
}
