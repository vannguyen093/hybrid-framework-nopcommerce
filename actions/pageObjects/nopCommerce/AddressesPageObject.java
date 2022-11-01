package pageObjects.nopCommerce;

import commons.BasePage;
import org.openqa.selenium.WebDriver;

public class AddressesPageObject extends BasePage {
    private WebDriver driver;

    public AddressesPageObject(WebDriver driver) {
        this.driver = driver;
    }
}
