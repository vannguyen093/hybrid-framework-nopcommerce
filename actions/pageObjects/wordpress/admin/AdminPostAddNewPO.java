package pageObjects.wordpress.admin;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.wordpress.admin.AdminPostAddNewPageUI;

public class AdminPostAddNewPO extends BasePage {
    WebDriver driver;

    public AdminPostAddNewPO(WebDriver driver) {
        this.driver = driver;
    }

    public void enterToPostTitle(String postTitle) {
        waitForElementVisible(driver, AdminPostAddNewPageUI.TITLE_TEXTBOX, postTitle);
        sendkeysToElement(driver, AdminPostAddNewPageUI.TITLE_TEXTBOX, postTitle);
    }

    public void enterToPostBody(String postBody) {
        waitForElementClickable(driver, AdminPostAddNewPageUI.BODY_BUTTON);
        clickToElement(driver, AdminPostAddNewPageUI.BODY_BUTTON);

        waitForElementVisible(driver, AdminPostAddNewPageUI.BODY_TEXTAREA);
        sendkeysToElement(driver, AdminPostAddNewPageUI.BODY_TEXTAREA, postBody);
    }

    public void clickToPulishPrimaryButton() {
        waitForElementClickable(driver, AdminPostAddNewPageUI.PUBLISH_PRIMARY_BUTTON);
        clickToElement(driver, AdminPostAddNewPageUI.PUBLISH_PRIMARY_BUTTON);
    }

    public void clickToPulishSecondaryButton() {
        waitForElementClickable(driver, AdminPostAddNewPageUI.PUBLISH_SECONDARY_BUTTON);
        clickToElement(driver, AdminPostAddNewPageUI.PUBLISH_SECONDARY_BUTTON);
    }

    public boolean isPostPublishedMessageDisplayed(String postPublishMessage) {
        waitForElementVisible(driver, AdminPostAddNewPageUI.PUBLISHED_MESSAGE, postPublishMessage);
        return isElementDisplayed(driver, AdminPostAddNewPageUI.PUBLISHED_MESSAGE, postPublishMessage);
    }

    public AdminPostSearchPO openSearchPostPageUrl(String searchPostUrl) {
        openPageUrl(driver, searchPostUrl);
        return PageGenerateManager.getAdminPostSearchPage(driver);
    }
}
