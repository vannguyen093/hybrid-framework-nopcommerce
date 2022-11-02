package commons;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.liveGuru.*;
import pageObjects.nopCommerce.admin.AdminLoginPageObject;
import pageObjects.nopCommerce.user.UserAddressesPageObject;
import pageObjects.nopCommerce.user.UserCustomerInfoPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserOrdersPageObject;
import pageObjects.nopCommerce.PageGeneratorManager;
import pageUIs.nopCommerce.admin.AdminBasePageUI;
import pageUIs.nopCommerce.user.UserBasePageUI;

import java.util.List;
import java.util.Set;

public class BasePage {

    public static BasePage getBasePageObject(){
        return new BasePage();
    }

    public void openPageUrl(WebDriver driver, String url) {
        driver.get(url);
    }

    public String getPageTitle(WebDriver driver) {
        return driver.getTitle();
    }

    public String getPageUrl(WebDriver driver) {
        return driver.getCurrentUrl();
    }

    public String getPageSourceCode(WebDriver driver) {
        return driver.getPageSource();
    }

    public void backToPage(WebDriver driver) {
        driver.navigate().back();
    }

    public void forwardToPage(WebDriver driver) {
        driver.navigate().forward();
    }

    public void refreshCurrentPage(WebDriver driver) {
        driver.navigate().refresh();
    }

    public Alert waitForAlertPresence(WebDriver driver) {
        WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
        return explicitWait.until(ExpectedConditions.alertIsPresent());
    }

    public void acceptAlert(WebDriver driver) {
        waitForAlertPresence(driver).accept();
    }

    public void cancelAlert(WebDriver driver) {
        waitForAlertPresence(driver).dismiss();
    }

    public String getAlertText(WebDriver driver) {
        return waitForAlertPresence(driver).getText();
    }

    public void sendKeysToAlert(WebDriver driver, String textValue) {
        waitForAlertPresence(driver).sendKeys(textValue);
    }

    public void switchToWindowByID(WebDriver driver, String parentID) {
        Set<String> allWindows = driver.getWindowHandles();
        for (String runWindow : allWindows) {
            if (!runWindow.equals(parentID)) {
                driver.switchTo().window(runWindow);
                break;
            }
        }
    }

    public void switchToWindowByTitle(WebDriver driver, String title) {
        Set<String> allWindows = driver.getWindowHandles();
        for (String runWindows : allWindows) {
            driver.switchTo().window(runWindows);
            String currentWin = driver.getTitle();
            if (currentWin.equals(title)) {
                break;
            }
        }
    }

    public void closeAllWindowsWithoutParent(WebDriver driver, String parentID) {
        Set<String> allWindows = driver.getWindowHandles();
        for (String runWindows : allWindows) {
            if (!runWindows.equals(parentID)) {
                driver.switchTo().window(runWindows);
                driver.close();
            }
        }
        driver.switchTo().window(parentID);
    }

    private By getByLocator(String locatorType) {
        By by = null;
        if (locatorType.startsWith("id=")||locatorType.startsWith("ID=")||locatorType.startsWith("Id=")){
            by = By.id(locatorType.substring(3));
        } else if (locatorType.startsWith("class=")||locatorType.startsWith("Class=")||locatorType.startsWith("CLASS=")){
            by = By.className(locatorType.substring(6));
        } else if (locatorType.startsWith("name=")||locatorType.startsWith("NAME=")||locatorType.startsWith("Name=")){
            by = By.name(locatorType.substring(5));
        } else if (locatorType.startsWith("css=")||locatorType.startsWith("CSS=")||locatorType.startsWith("Css=")){
            by = By.cssSelector(locatorType.substring(4));
        } else if (locatorType.startsWith("xpath=")||locatorType.startsWith("Xpath=")||locatorType.startsWith("XPATH=")){
            by = By.xpath(locatorType.substring(6));
        } else {
            throw new RuntimeException("Locator type not supported");
        }
        return by;
    }

    private WebElement getWebElement(WebDriver driver, String locatorType) {
        return driver.findElement(getByLocator(locatorType));
    }

    private List<WebElement> getListWebElements(WebDriver driver, String locatorType) {
        return driver.findElements(getByLocator(locatorType));
    }

    public void clickToElement(WebDriver driver, String locatorType) {
        getWebElement(driver, locatorType).click();
    }

    public void sendkeysToElement(WebDriver driver, String locatorType, String textValue) {
        WebElement element = getWebElement(driver, locatorType);
        element.clear();
        element.sendKeys(textValue);
    }


    public void selectItemInDefaultDropdown(WebDriver driver, String locatorType, String textItem) {
        Select select = new Select(getWebElement(driver, locatorType));
        select.selectByValue(textItem);
    }

    public String getFirstSelectedItemDefaultDropdown(WebDriver driver, String locatorType) {
        Select select = new Select(getWebElement(driver, locatorType));
        return select.getFirstSelectedOption().getText();
    }

    public boolean isDropdownMultiple(WebDriver driver, String locatorType) {
        Select select = new Select(getWebElement(driver, locatorType));
        return select.isMultiple();
    }

    public void selectItemInCustomDropdown(WebDriver driver, String parentLocator, String childItemLocator, String expectedItem) {
        getWebElement(driver, parentLocator).click();
        sleepInSecond(1);

        WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
        List<WebElement> allItems = explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByLocator(childItemLocator)));

        for (WebElement item : allItems) {
            if (item.getText().trim().equals(expectedItem)) {
                JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
                jsExecutor.executeScript("arguments[0].scrollIntoView(true);", item);
                sleepInSecond(1);
                item.click();
                sleepInSecond(1);
                break;
            }
        }
    }

    public void sleepInSecond(long timeInSecond) {
        try {
            Thread.sleep(timeInSecond * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String getElementAttribute(WebDriver driver, String locatorType, String attributeName) {
        return getWebElement(driver, locatorType).getAttribute(attributeName);
    }

    public String getElementText(WebDriver driver, String locatorType) {
        return getWebElement(driver, locatorType).getText();
    }

    public String getElementCssValue(WebDriver driver, String locatorType, String propertyName) {
        return getWebElement(driver, locatorType).getCssValue(propertyName);
    }

    public String convertRbgaToHex(String rgbaValue) {
        return Color.fromString(rgbaValue).asHex();
    }

    public int getElementSize(WebDriver driver, String locatorType) {
        return getListWebElements(driver, locatorType).size();
    }

    public void checkToDefaultCheckboxRadio(WebDriver driver, String locatorType) {
        WebElement element = getWebElement(driver, locatorType);
        if (!element.isSelected()) {
            element.click();
        }
    }

    public void uncheckToDefaultCheckboxRadio(WebDriver driver, String locatorType) {
        WebElement element = getWebElement(driver, locatorType);
        if (element.isSelected()) {
            element.click();
        }
    }

    public boolean isElementDisplayed(WebDriver driver, String locatorType) {
        return getWebElement(driver, locatorType).isDisplayed();
    }

    public boolean isElementEnabled(WebDriver driver, String locatorType) {
        return getWebElement(driver, locatorType).isEnabled();
    }

    public boolean isElementSelected(WebDriver driver, String locatorType) {
        return getWebElement(driver, locatorType).isSelected();
    }

    public void switchToFrameIframe(WebDriver driver, String locatorType) {
        driver.switchTo().frame(getWebElement(driver, locatorType));
    }

    public void switchToDefaultContent(WebDriver driver) {
        driver.switchTo().defaultContent();
    }

    public void hoverMouseToElement(WebDriver driver, String locatorType) {
        Actions action = new Actions(driver);
        action.moveToElement(getWebElement(driver, locatorType)).perform();
    }

    public void scrollToBottomPage(WebDriver driver) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }

    public void highlightElement(WebDriver driver, String locatorType) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        WebElement element = getWebElement(driver, locatorType);
        String originalStyle = element.getAttribute("style");
        jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", "border: 2px solid red; border-style: dashed;");
        sleepInSecond(1);
        jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", originalStyle);
    }

    public void clickToElementByJS(WebDriver driver, String locatorType) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].click();", getWebElement(driver, locatorType));
    }

    public void scrollToElement(WebDriver driver, String locatorType) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", getWebElement(driver, locatorType));
    }

    public void removeAttributeInDOM(WebDriver driver, String locatorType, String attributeRemove) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", getWebElement(driver, locatorType));
    }

    public boolean areJQueryAndJSLoadedSuccess(WebDriver driver) {
        WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

        ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                try {
                    return ((Long) jsExecutor.executeScript("return jQuery.active") == 0);
                } catch (Exception e) {
                    return true;
                }
            }
        };

        ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return jsExecutor.executeScript("return document.readyState").toString().equals("complete");
            }
        };

        return explicitWait.until(jQueryLoad) && explicitWait.until(jsLoad);
    }

    public String getElementValidationMessage(WebDriver driver, String locatorType) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        return (String) jsExecutor.executeScript("return arguments[0].validationMessage;", getWebElement(driver, locatorType));
    }

    public boolean isImageLoaded(WebDriver driver, String locatorType) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        boolean status = (boolean) jsExecutor.executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", getWebElement(driver, locatorType));
        if (status) {
            return true;
        } else {
            return false;
        }
    }

    public void waitForElementVisible(WebDriver driver, String locatorType) {
        WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByLocator(locatorType)));
    }

    public void waitForAllElementVisible(WebDriver driver, String locatorType) {
        WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
        explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByLocator(locatorType)));
    }

    public void waitForElementInvisible(WebDriver driver, String locatorType) {
        WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
        explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(locatorType)));
    }

    public void waitForAllElementInvisible(WebDriver driver, String locatorType) {
        WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
        explicitWait.until(ExpectedConditions.invisibilityOfAllElements(getListWebElements(driver, locatorType)));
    }

    public void waitForElementClickable(WebDriver driver, String locatorType){
        WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
        explicitWait.until(ExpectedConditions.elementToBeClickable(getByLocator(locatorType)));
    }

    public MyDashboardPageObject openMyDashboardPage(WebDriver driver){
        waitForElementClickable(driver, pageUIs.liveGuru.BasePageUI.ACCOUNT_DASHBOARD_LINK);
        clickToElement(driver, pageUIs.liveGuru.BasePageUI.ACCOUNT_DASHBOARD_LINK);
        return pageObjects.liveGuru.PageGeneratorManager.getMyAccountDashboardPage(driver);
    }

    public AccountInforPageObject openAccountInforPage(WebDriver driver){
        waitForElementClickable(driver, pageUIs.liveGuru.BasePageUI.ACCOUNT_INFOR_LINK);
        clickToElement(driver, pageUIs.liveGuru.BasePageUI.ACCOUNT_INFOR_LINK);
        return pageObjects.liveGuru.PageGeneratorManager.getAccountInforPage(driver);
    }

    public AddressBookPageObject openAddressBookPage(WebDriver driver){
        waitForElementClickable(driver, pageUIs.liveGuru.BasePageUI.ADDRESS_BOOK_LINK);
        clickToElement(driver, pageUIs.liveGuru.BasePageUI.ADDRESS_BOOK_LINK);
        return pageObjects.liveGuru.PageGeneratorManager.getAddressBookPage(driver);
    }

    public MyOrderPageObject openMyOrdersPage(WebDriver driver){
        waitForElementClickable(driver, pageUIs.liveGuru.BasePageUI.MY_ORDERS_LINK);
        clickToElement(driver, pageUIs.liveGuru.BasePageUI.MY_ORDERS_LINK);
        return pageObjects.liveGuru.PageGeneratorManager.getMyOrdersPage(driver);
    }

    public BillingAgreementsPageObject openBillingAgreementsPage(WebDriver driver){
        waitForElementClickable(driver, pageUIs.liveGuru.BasePageUI.BILLING_AGREEMENTS_LINK);
        clickToElement(driver, pageUIs.liveGuru.BasePageUI.BILLING_AGREEMENTS_LINK);
        return pageObjects.liveGuru.PageGeneratorManager.getBillingAgreementsPage(driver);
    }

    public UserCustomerInfoPageObject openCustomerInfoPage(WebDriver driver){
        waitForElementClickable(driver, UserBasePageUI.CUSTOMER_INFO_LINK);
        clickToElement(driver, UserBasePageUI.CUSTOMER_INFO_LINK);
        return PageGeneratorManager.getUserCustomerInfoPage(driver);
    }

    public UserAddressesPageObject openAddressesPage(WebDriver driver){
        waitForElementClickable(driver, UserBasePageUI.ADDRESSES_LINK);
        clickToElement(driver, UserBasePageUI.ADDRESSES_LINK);
        return PageGeneratorManager.getUserAddressesPage(driver);
    }

    public UserOrdersPageObject openOrdersPage(WebDriver driver){
        waitForElementClickable(driver, UserBasePageUI.ORDERS_LINK);
        clickToElement(driver, UserBasePageUI.ORDERS_LINK);
        return PageGeneratorManager.getUserOrdersPage(driver);
    }

    public UserHomePageObject clickToLogoutLinkAtUser(WebDriver driver) {
        waitForElementClickable(driver, UserBasePageUI.LOGOUT_LINK);
        clickToElement(driver, UserBasePageUI.LOGOUT_LINK);
        return PageGeneratorManager.getUserHomePage(driver);
    }

    public AdminLoginPageObject clickToLogoutLinkAtAdmin(WebDriver driver) {
        waitForElementInvisible(driver, AdminBasePageUI.AJAX_BUSY);
        waitForElementClickable(driver, AdminBasePageUI.LOGOUT_LINK);
        clickToElement(driver, AdminBasePageUI.LOGOUT_LINK);
        return PageGeneratorManager.getAdminLoginPage(driver);
    }

    private long longTimeout = 30;
    private long shortTimeout = 5;
}
