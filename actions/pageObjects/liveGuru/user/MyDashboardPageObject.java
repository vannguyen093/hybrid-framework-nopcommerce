package pageObjects.liveGuru.user;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.liveGuru.user.MyDashboardtPageUI;

public class MyDashboardPageObject extends BasePage {
    private WebDriver driver;

    public MyDashboardPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public String getRegisterSuccessMessage() {
        waitForElementVisible(driver, MyDashboardtPageUI.SUCCESS_MESSAGE);
        return getElementText(driver, MyDashboardtPageUI.SUCCESS_MESSAGE);
    }

    public String getHelloUserText() {
        waitForElementVisible(driver, MyDashboardtPageUI.HELLO_USER_MESSAGE);
        return getElementText(driver, MyDashboardtPageUI.HELLO_USER_MESSAGE);
    }
}
