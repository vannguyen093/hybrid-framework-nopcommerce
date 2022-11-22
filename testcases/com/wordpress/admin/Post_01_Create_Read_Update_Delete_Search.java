package com.wordpress.admin;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.wordpress.PageGenerateManager;
import pageObjects.wordpress.admin.*;
import pageObjects.wordpress.user.UserHomePO;
import pageObjects.wordpress.user.UserPostDetailPO;

public class Post_01_Create_Read_Update_Delete_Search extends BaseTest {
    private WebDriver driver;
    private String adminUserName, adminPassword, postTitle, postBody;
    private String searchPostUrl, authorName;
    String adminUrl, userUrl, currentDay;
    AdminLoginPO adminLoginPageObject;
    AdminDashboardPO adminDashboardPage;
    AdminPostSearchPO adminPostSearchPage;
    AdminPostAddNewPO adminPostAddNewPage;
    UserHomePO userHomePage;
    UserPostDetailPO userPostDetailPage;


    @Parameters({"browser", "urlAdmin", "urlUser"})
    @BeforeClass
    public void beforeClass(String browserName, String adminUrl, String userUrl) {
        this.adminUrl = adminUrl;
        this.userUrl = userUrl;
        adminUserName = "vannguyen093";
        adminPassword = "vannguyen093";
        int randomNumber = generateFakeNumber();
        postTitle = "Live Coding Title " + randomNumber;
        postBody = "Live Coding Body " + randomNumber;
        authorName = "vannguyen093";
        currentDay = getToday();

        log.info("Pre-Condition - Step 01: Open browser and admin url");
        driver = getBrowserDriver(browserName, this.adminUrl);
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
    public void Post_02_Search_And_View_Post() {
        log.info("Search_Post - Step 01: Open 'Search post' page");
        adminPostSearchPage = adminPostAddNewPage.openSearchPostPageUrl(searchPostUrl);

        log.info("Search_Post - Step 02: Enter to 'Search' textbox");
        adminPostSearchPage.enterToSearchTextbox(postTitle);

        log.info("Search_Post - Step 03: Click to 'Search Posts' button");
        adminPostSearchPage.clickToSearchPostsButton();

        log.info("Search_Post - Step 04: Verify Search table contains '" + postTitle +"'");
        verifyTrue(adminPostSearchPage.isPostSearchTableDisplayed("title", postTitle));

        log.info("Search_Post - Step 05: Verify Search table contains '" + authorName +"'");
        verifyTrue(adminPostSearchPage.isPostSearchTableDisplayed("author", authorName));

        log.info("Search_Post - Step 06: Open User Site");
        userHomePage = adminPostSearchPage.openUserSite(driver, this.userUrl);

        log.info("Search_Post - Step 07: Verify post info displayed at Home Page");
        verifyTrue(userHomePage.isPostInfoDisplayedWithPostTitle(postTitle));
        verifyTrue(userHomePage.isPostInfoDisplayedWithPostBody(postTitle,postBody));
        verifyTrue(userHomePage.isPostInfoDisplayedWithPostAuthor(postTitle,authorName));
        verifyTrue(userHomePage.isPostInfoDisplayedWithPostCurrentDate(postTitle,currentDay));

        log.info("Search_Post - Step 08: Click to post title");
        userPostDetailPage = userHomePage.clickToPostTitle(postTitle);

        log.info("Search_Post - Step 09: Verify post info displayed at Post Detail Page");
        verifyTrue(userPostDetailPage.isPostInfoDisplayedWithPostTitle(postTitle));
        verifyTrue(userPostDetailPage.isPostInfoDisplayedWithPostBody(postTitle,postBody));
        verifyTrue(userPostDetailPage.isPostInfoDisplayedWithPostAuthor(postTitle,authorName));
        verifyTrue(userPostDetailPage.isPostInfoDisplayedWithPostCurrentDate(postTitle,currentDay));
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
