package pageObjects.liveGuru.user;

import commons.BasePage;
import org.openqa.selenium.WebDriver;

public class MyOrderPageObject extends BasePage {
    private WebDriver driver;

    public MyOrderPageObject(WebDriver driver) {
        this.driver = driver;
    }
}
