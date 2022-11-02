package pageObjects.liveGuru;

import commons.BasePage;
import org.openqa.selenium.WebDriver;

public class BillingAgreementsPageObject extends BasePage {
    private WebDriver driver;

    public BillingAgreementsPageObject(WebDriver driver) {
        this.driver = driver;
    }
}
