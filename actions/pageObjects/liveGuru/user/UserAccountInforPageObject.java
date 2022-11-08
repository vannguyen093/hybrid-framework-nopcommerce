package pageObjects.liveGuru.user;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.liveGuru.user.AccountInfoPageUI;

public class UserAccountInforPageObject extends BasePage {
    private WebDriver driver;

    public UserAccountInforPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public String getValueAtFirstNameTextbox() {
        waitForElementVisible(driver, AccountInfoPageUI.DYNAMIC_LOCATOR_AT_ACCOUNT_INFO_PAGE,"firstname");
        return getElementAttribute(driver, AccountInfoPageUI.DYNAMIC_LOCATOR_AT_ACCOUNT_INFO_PAGE,"value","firstname");
    }

    public String getValueAtLastNameTextbox() {
        waitForElementVisible(driver, AccountInfoPageUI.DYNAMIC_LOCATOR_AT_ACCOUNT_INFO_PAGE,"lastname");
        return getElementAttribute(driver, AccountInfoPageUI.DYNAMIC_LOCATOR_AT_ACCOUNT_INFO_PAGE,"value","lastname");
    }

    public String getValueAtEmailTextbox() {
        waitForElementVisible(driver, AccountInfoPageUI.DYNAMIC_LOCATOR_AT_ACCOUNT_INFO_PAGE,"email");
        return getElementAttribute(driver, AccountInfoPageUI.DYNAMIC_LOCATOR_AT_ACCOUNT_INFO_PAGE,"value","email");
    }
}
