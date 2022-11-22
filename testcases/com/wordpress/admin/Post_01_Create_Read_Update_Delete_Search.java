package com.wordpress.admin;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.wordpress.admin.*;

public class Post_01_Create_Read_Update_Delete_Search extends BaseTest {
    private WebDriver driver;
    private String adminUserName, adminPassword, postTitle, postBody;
    private String searchPostUrl;
    AdminLoginPO adminLoginPageObject;
    AdminDashboardPO adminDashboardPage;
    AdminPostSearchPO adminPostSearchPage;
    AdminPostAddNewPO adminPostAddNewPage;


    @Parameters({"browser", "urlAdmin"})
    @BeforeClass
    public void beforeClass(String browserName, String appUrl) {
        adminUserName = "vannguyen093";
        adminPassword = "vannguyen093";
        int randomNumber = generateFakeNumber();
        postTitle = "Live Coding Title " + randomNumber;
        postBody = "Live Coding Body " + randomNumber;

        log.info("Pre-Condition - Step 01: Open browser and admin url");
        driver = getBrowserDriver(browserName, appUrl);
        adminLoginPageObject = PageGenerateManager.getAdminLoginPage(driver);

        log.info("Pre-Condition - Step 02: Enter to Username textbox with value is " + adminUserName);
        adminLoginPageObject.enterToUsernameTextbox(adminUserName);

        log.info("Pre-Condition - Step 03: Enter to Password textbox with value is " + adminPassword);
        adminLoginPageObject.enterToPasswordTextbox(adminPassword);

        log.info("Pre-Condition - Step 04: Click to 'Login' button");
        adminDashboardPage = adminLoginPageObject.clickToLoginButton();

    }

    @Test
    public void Post_01_Create_New_Post() {
        log.info("Create_Post - Step 01: Click to 'Post' menu link");
        adminPostSearchPage = adminDashboardPage.clickToPostMenuLink();

        log.info("Create_Post - Step 02: Get 'Search post' url");
        searchPostUrl = adminPostSearchPage.getPageUrl(driver);

        log.info("Create_Post - Step 03: Click to 'Add New' button");
        adminPostAddNewPage = adminPostSearchPage.clickToAddNewButton();

        log.info("Create_Post - Step 04: Enter to post title");
        adminPostAddNewPage.enterToPostTitle(postTitle);

        log.info("Create_Post - Step 05: Enter to post body");
        adminPostAddNewPage.enterToPostBody(postBody);

        log.info("Create_Post - Step 06: Click to 'Pulish' primary button");
        adminPostAddNewPage.clickToPulishPrimaryButton();

        log.info("Create_Post - Step 06: Click to 'Pulish' secondary button");
        adminPostAddNewPage.clickToPulishSecondaryButton();

        log.info("Create_Post - Step 07: Verify 'Post published.' message is displayed");
        verifyTrue(adminPostAddNewPage.isPostPublishedMessageDisplayed("Post published."));
    }

    @Test
    public void Post_02_Search_Post() {
        log.info("Search_Post - Step 01: Open 'Search post' page");
        adminPostAddNewPage.openSearchPostPageUrl(searchPostUrl);

    }

    @Test
    public void Post_03_View_Post() {

    }

    @Test
    public void Post_04_Edit_Post() {

    }

    @Test
    public void Post_05_Delete_Post() {

    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        closeBrowserAndDriver();
    }
}
