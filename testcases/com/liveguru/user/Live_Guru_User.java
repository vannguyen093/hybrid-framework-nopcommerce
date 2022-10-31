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
  MyAccountPageObject myAccountPage;
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

    myAccountPage = PageGeneratorManager.getMyAccountPage(driver);
    Assert.assertEquals(myAccountPage.getRegisterSuccessMessage(), "Thank you for registering with Main Website Store.");
    myAccountPage.clickToAccountButton();
    myAccountPage.clickToLogoutButton();
    homePage = PageGeneratorManager.getHomePage(driver);
  }

  @Test
  public void User_02_Login_To_System() {
    homePage.clickToMyAccountLink();

    loginPage = PageGeneratorManager.getLoginPage(driver);
    loginPage.inputToEmailTextbox(email);
    loginPage.inputPasswordTextbox(password);
    loginPage.clickToLoginButton();

    myAccountPage = PageGeneratorManager.getMyAccountPage(driver);
    Assert.assertEquals(myAccountPage.getHelloUserText(), "Hello, Van Nguyen!");
    myAccountPage.clickToAccountButton();
    myAccountPage.clickToLogoutButton();
    homePage = PageGeneratorManager.getHomePage(driver);
  }

  @AfterClass
  public void afterClass() {
    driver.quit();
  }
}
