package pageObjects.jquery;

import commons.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageUIs.jquery.HomePageUI;

import java.util.ArrayList;
import java.util.List;

public class HomePageObject extends BasePage {
    WebDriver driver;

    public HomePageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void openPagingByPageNumber(String pageNumber) {
        waitForElementClickable(driver, HomePageUI.PAGING_PAGE_BY_NUMBER, pageNumber);
        clickToElement(driver, HomePageUI.PAGING_PAGE_BY_NUMBER, pageNumber);
    }

    public void inputToFilterTextboxByLabel(String filterLabel, String value) {
        waitForElementVisible(driver, HomePageUI.FILTER_TEXTBOX, filterLabel);
        sendkeysToElement(driver, HomePageUI.FILTER_TEXTBOX, value, filterLabel);
        pressKeyToElement(driver, HomePageUI.FILTER_TEXTBOX, Keys.ENTER, filterLabel);
    }

    public boolean isPageNumberActived(String pageNumber) {
        waitForElementVisible(driver, HomePageUI.FILTER_TEXTBOX, pageNumber);
        return isElementDisplayed(driver, HomePageUI.FILTER_TEXTBOX, pageNumber);
    }

    public List<String> getValueEachRowAtAllPage() {
        int totalPages = getElementSize(driver, HomePageUI.TOTAL_PAGING);

        List<String> allRowValuesAllPage = new ArrayList<String>();
        for (int index = 1; index <= totalPages; index++) {
            clickToElement(driver, HomePageUI.TOTAL_PAGING_INDEX, String.valueOf(index));

            List<WebElement> allRowEachPage = getListWebElements(driver, HomePageUI.ALL_ROW_EACH_PAGE);
            for (WebElement eachrow : allRowEachPage) {
                allRowValuesAllPage.add(eachrow.getText());
            }
        }
        return allRowValuesAllPage;
    }
}
