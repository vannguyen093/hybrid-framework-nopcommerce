package com.liveguru.user;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.liveGuru.*;

public class Live_Guru_User extends BaseTest {
    WebDriver driver;
    HomePageObject homePage;
    LoginPageObject loginPage;
    RegisterPageObject registerPage;
    MyDashboardPageObject myAccountDashboardPage;
    AccountInforPageObject accountInforPage;
    AddressBookPageObject addressBookPage;
    MyOrderPageObject myOrderPage;
    BillingAgreementsPageObject billingAgreementsPage;
    String firstName, lastName, email, password;

    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName) {

        driver = getBrowserDriver(browserName);

        homePage = PageGeneratorManager.getHomePage(driver);

        firstName = "Van";
        lastName = "Nguyen";
        email = "vannguyen" + generateFakeNumber() + "@gmail.com";
        password = "123123";
    }

    @Test
    public void User_01_Register_To_System() {
        loginPage = homePage.clickToMyAccountLink();

        registerPage = loginPage.clickToCreateAnAccountButton();

        myAccountDashboardPage = registerPage.inputToRequiredRegisterField(firstName, lastName, email, password, password);
        Assert.assertEquals(myAccountDashboardPage.getRegisterSuccessMessage(), "Thank you for registering with Main Website Store.");

        myAccountDashboardPage.clickToAccountButton();
        homePage = myAccountDashboardPage.clickToLogoutButton();
    }

    @Test
    public void User_02_Login_To_System() {
        loginPage = homePage.clickToMyAccountLink();

        myAccountDashboardPage = loginPage.loginAsUser(email, password);
        Assert.assertEquals(myAccountDashboardPage.getHelloUserText(), "Hello, Van Nguyen!");
    }

    @Test
    public void User_03_Switch_Page() {
        myAccountDashboardPage.openPagesAtDashboardByPageName(driver, "Account Information");
        accountInforPage = PageGeneratorManager.getAccountInforPage(driver);

        accountInforPage.openPagesAtDashboardByPageName(driver, "Address Book");
        addressBookPage = PageGeneratorManager.getAddressBookPage(driver);

    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
