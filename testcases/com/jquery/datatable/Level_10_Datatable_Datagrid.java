package com.jquery.datatable;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.jquery.HomePageObject;
import pageObjects.jquery.PageGeneratorManager;

public class Level_10_Datatable_Datagrid extends BaseTest {
    private WebDriver driver;
    HomePageObject homePage;

    @Parameters({"browser", "url"})
    @BeforeClass
    public void beforeClass(String browserName, String appUrl) {

        driver = getBrowserDriver(browserName, appUrl);

        homePage = PageGeneratorManager.getHomePage(driver);
    }

    @Test
    public void Table_01_Paging() {
        homePage.openPagingByPageNumber("5");
        homePage.sleepInSecond(1);
        Assert.assertTrue(homePage.isPageNumberActived("5"));

        homePage.openPagingByPageNumber("10");
        homePage.sleepInSecond(1);
        Assert.assertTrue(homePage.isPageNumberActived("10"));

        homePage.openPagingByPageNumber("15");
        homePage.sleepInSecond(1);
        Assert.assertTrue(homePage.isPageNumberActived("15"));
    }

    @Test
    public void Table_02_Filter() {
        homePage.refreshCurrentPage(driver);

        homePage.inputToFilterTextboxByLabel("Country","Argentina");
        homePage.sleepInSecond(3);

        homePage.inputToFilterTextboxByLabel("Country","Arab Rep of Egypt");
        homePage.sleepInSecond(3);

        homePage.inputToFilterTextboxByLabel("Total","1580");
        homePage.sleepInSecond(3);
    }

    @Test
    public void Table_03() {
        homePage.getValueEachRowAtAllPage();
    }

    @Test
    public void Table_04() {
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
