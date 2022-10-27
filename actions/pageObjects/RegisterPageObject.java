package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.RegisterPageUI;

public class RegisterPageObject extends BasePage {
    private WebDriver driver;

    public RegisterPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void clickToRegisterButton() {
        waitForElementClickable(driver, RegisterPageUI.REGISTER_BUTTON);
        clickToElement(driver, RegisterPageUI.REGISTER_BUTTON);
    }

    public String getErrorAtFirstNameTextbox() {
        waitForAllElementVisible(driver, RegisterPageUI.FIRST_NAME_ERROR_MESSAGE);
        return getElementText(driver, RegisterPageUI.FIRST_NAME_ERROR_MESSAGE);
    }

    public String getErrorAtLastNameTextbox() {
        waitForAllElementVisible(driver, RegisterPageUI.LAST_NAME_ERROR_MESSAGE);
        return getElementText(driver, RegisterPageUI.LAST_NAME_ERROR_MESSAGE);
    }

    public String getErrorAtEmailTextbox() {
        waitForAllElementVisible(driver, RegisterPageUI.EMAIL_ERROR_MESSAGE);
        return getElementText(driver, RegisterPageUI.EMAIL_ERROR_MESSAGE);
    }

    public String getErrorAtPasswordTextbox() {
        waitForAllElementVisible(driver, RegisterPageUI.PASSWORD_ERROR_MESSAGE);
        return getElementText(driver, RegisterPageUI.PASSWORD_ERROR_MESSAGE);
    }

    public String getErrorAtConfirmPasswordTextbox() {
        waitForAllElementVisible(driver, RegisterPageUI.CONFIRM_PASSWORD_ERROR_MESSAGE);
        return getElementText(driver, RegisterPageUI.CONFIRM_PASSWORD_ERROR_MESSAGE);
    }

    public void inputToFirstNameTextbox(String firstName) {
        waitForAllElementVisible(driver, RegisterPageUI.FIRST_NAME_TEXTBOX);
        sendkeysToElement(driver, RegisterPageUI.FIRST_NAME_TEXTBOX, firstName);
    }

    public void inputToLastNameTextbox(String lastName) {
        waitForAllElementVisible(driver, RegisterPageUI.LAST_NAME_TEXTBOX);
        sendkeysToElement(driver, RegisterPageUI.LAST_NAME_TEXTBOX, lastName);
    }

    public void inputToEmailTextbox(String email) {
        waitForAllElementVisible(driver, RegisterPageUI.EMAIL_TEXTBOX);
        sendkeysToElement(driver, RegisterPageUI.EMAIL_TEXTBOX, email);
    }

    public void inputToPasswordTextbox(String password) {
        waitForAllElementVisible(driver, RegisterPageUI.PASSWORD_TEXTBOX);
        sendkeysToElement(driver, RegisterPageUI.PASSWORD_TEXTBOX, password);
    }

    public void inputToConfirmPasswordTextbox(String password) {
        waitForAllElementVisible(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX);
        sendkeysToElement(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX, password);
    }

    public String getSuccessMessage() {
        waitForAllElementVisible(driver, RegisterPageUI.SUCCESS_MESSAGE);
        return getElementText(driver, RegisterPageUI.SUCCESS_MESSAGE);
    }

    public void clickToLogOutLink() {
        waitForElementClickable(driver, RegisterPageUI.LOGOUT_LINK);
        clickToElement(driver, RegisterPageUI.LOGOUT_LINK);
    }

    public String getErrorAtExistingEmail() {
        waitForAllElementVisible(driver, RegisterPageUI.EXISTING_EMAIL_ERROR_MESSAGE);
        return getElementText(driver, RegisterPageUI.EXISTING_EMAIL_ERROR_MESSAGE);
    }
}
