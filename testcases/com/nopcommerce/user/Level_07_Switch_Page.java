package com.nopcommerce.user;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.nopCommerce.*;

import java.util.Random;

public class Level_07_Switch_Page extends BaseTest {
    private WebDriver driver;
    private String firstName, lastName, email, password;
    private HomePageObject homePage;
    private RegisterPageObject registerPage;
    private LoginPageObject loginPage;
    private CustomerInfoPageObject customerInfoPage;
    private AddressesPageObject addressesPage;
    private OrdersPageObject ordersPage;

    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName) {

        driver = getBrowserDriver(browserName);

        homePage = PageGeneratorManager.getHomePage(driver);

        firstName = "Automation";
        lastName = "FC";
        password = "123456";
        email = "vannguyen" + generateFakeNumber() + "@gmail.com";
    }

    @Test
    public void User_01_Register() {
        registerPage = homePage.clickToRegisterLink();

        registerPage.inputToFirstNameTextbox(firstName);
        registerPage.inputToLastNameTextbox(lastName);
        registerPage.inputToEmailTextbox(email);
        registerPage.inputToPasswordTextbox(password);
        registerPage.inputToConfirmPasswordTextbox(password);

        registerPage.clickToRegisterButton();

        Assert.assertEquals(registerPage.getSuccessMessage(), "Your registration completed");
        homePage = registerPage.clickToLogOutLink();
    }

    @Test
    public void User_02_Login() {
        loginPage = homePage.clickToLoginLink();

        loginPage.inputToEmailTextbox(email);
        loginPage.inputToPasswordTextbox(password);
        homePage = loginPage.clickToLoginButton();
        customerInfoPage = homePage.clickToMyAccountLink();
    }

    @Test
    public void User_03_Switch_Page() {
        addressesPage = customerInfoPage.openAddressesPage(driver);
        ordersPage = addressesPage.openOrdersPage(driver);
        customerInfoPage = ordersPage.openCustomerInfoPage(driver);
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
