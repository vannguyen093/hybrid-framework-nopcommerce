package pageObjects.liveGuru;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.liveGuru.LoginPageUI;

public class LoginPageObject extends BasePage {
    private WebDriver driver;

    public LoginPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void clickToCreateAnAccountButton() {
        waitForElementClickable(driver, LoginPageUI.CREATE_AN_ACCOUNT_BUTTON);
        clickToElement(driver, LoginPageUI.CREATE_AN_ACCOUNT_BUTTON);
    }

    public void inputToEmailTextbox(String email) {
        waitForElementVisible(driver, LoginPageUI.EMAIL_TEXTBOX);
        sendkeysToElement(driver, LoginPageUI.EMAIL_TEXTBOX, email);
    }

    public void inputPasswordTextbox(String password) {
        waitForElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
        sendkeysToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, password);
    }

    public void clickToLoginButton() {
        waitForElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
        clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
    }
}
