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
    homePage.clickToMyAccountLink();

    loginPage = PageGeneratorManager.getLoginPage(driver);
    loginPage.clickToCreateAnAccountButton();

    registerPage = PageGeneratorManager.getRegisterPage(driver);
    registerPage.inputFirstNameTextbox(firstName);
    registerPage.inputLastNameTextbox(lastName);
    registerPage.inputEmailTextbox(email);
    registerPage.inputPasswordTextbox(password);
    registerPage.inputConfirmPasswordTextbox(password);
    registerPage.clickRegisterButton();

    myAccountDashboardPage = PageGeneratorManager.getMyAccountDashboardPage(driver);
    Assert.assertEquals(myAccountDashboardPage.getRegisterSuccessMessage(), "Thank you for registering with Main Website Store.");
    myAccountDashboardPage.clickToAccountButton();
    myAccountDashboardPage.clickToLogoutButton();
    homePage = PageGeneratorManager.getHomePage(driver);
  }

  @Test
  public void User_02_Login_To_System() {
    homePage.clickToMyAccountLink();

    loginPage = PageGeneratorManager.getLoginPage(driver);
    loginPage.inputToEmailTextbox(email);
    loginPage.inputPasswordTextbox(password);
    loginPage.clickToLoginButton();

    myAccountDashboardPage = PageGeneratorManager.getMyAccountDashboardPage(driver);
    Assert.assertEquals(myAccountDashboardPage.getHelloUserText(), "Hello, Van Nguyen!");
  }

  @Test
  public void User_03_Switch_Page() {
    accountInforPage = myAccountDashboardPage.openAccountInforPage(driver);

    addressBookPage = accountInforPage.openAddressBookPage(driver);

    myOrderPage = addressBookPage.openMyOrdersPage(driver);

    billingAgreementsPage = myOrderPage.openBillingAgreementsPage(driver);

    myAccountDashboardPage = billingAgreementsPage.openMyDashboardPage(driver);

  }

  @AfterClass
  public void afterClass() {
    driver.quit();
  }
}
