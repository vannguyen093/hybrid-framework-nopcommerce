package pageObjects.nopCommerce;

import commons.BasePage;
import org.openqa.selenium.WebDriver;

public class OrdersPageObject extends BasePage {
    private WebDriver driver;

    public OrdersPageObject(WebDriver driver) {
        this.driver = driver;
    }
}
