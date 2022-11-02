package pageObjects.liveGuru;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.liveGuru.MyAccountPageUI;

public class MyDashboardPageObject extends BasePage {
    private WebDriver driver;

    public MyDashboardPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public String getRegisterSuccessMessage() {
        waitForElementVisible(driver, MyAccountPageUI.SUCCESS_MESSAGE);
        return getElementText(driver, MyAccountPageUI.SUCCESS_MESSAGE);
    }

    public void clickToAccountButton() {
        waitForElementClickable(driver, MyAccountPageUI.ACCOUNT_BUTTON);
        clickToElement(driver, MyAccountPageUI.ACCOUNT_BUTTON);
    }

    public void clickToLogoutButton() {
        waitForElementClickable(driver, MyAccountPageUI.LOGOUT_BUTTON);
        clickToElement(driver, MyAccountPageUI.LOGOUT_BUTTON);
    }

    public String getHelloUserText() {
        waitForElementVisible(driver, MyAccountPageUI.HELLO_USER_MESSAGE);
        return getElementText(driver, MyAccountPageUI.HELLO_USER_MESSAGE);
    }
}
