package pageObjects.liveGuru.user;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.liveGuru.user.LoginPageUI;

public class UserLoginPageObject extends BasePage {
    private WebDriver driver;

    public UserLoginPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public RegisterPageObject clickToCreateAnAccountButton() {
        waitForElementClickable(driver, LoginPageUI.CREATE_AN_ACCOUNT_BUTTON);
        clickToElement(driver, LoginPageUI.CREATE_AN_ACCOUNT_BUTTON);
        return PageGeneratorManager.getRegisterPage(driver);
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

    public UserMyDashboardPageObject loginAsUser(String email, String password) {
        inputToEmailTextbox(email);
        inputPasswordTextbox(password);
        clickToLoginButton();
        return PageGeneratorManager.getMyAccountDashboardPage(driver);
    }
}
