package com.nopcommerce.user;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.HomePageObject;
import pageObjects.RegisterPageObject;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Level_03_Page_Object extends BasePage {
  WebDriver driver;
  String projectPath = System.getProperty("user.dir");
  String firstName, lastName, emailAddress, password;
  HomePageObject homePage;
  RegisterPageObject registerPage;

  @BeforeClass
  public void beforeClass() {
    System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
    driver = new FirefoxDriver();

    homePage = new HomePageObject(driver);
    registerPage = new RegisterPageObject(driver);

    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    driver.get("https://demo.nopcommerce.com/");

    firstName = "Automation";
    lastName = "FC";
    password = "123456";
    emailAddress = "vannguyen" + generateFakeNumber() + "@gmail.com";
  }
  
  @Test
  public void Register_01_Empty_Data() {
    homePage.clickToRegisterLink();

    registerPage.clickToRegisterButton();

    Assert.assertEquals(registerPage.getErrorAtFirstNameTextbox(), "First name is required.");
    Assert.assertEquals(registerPage.getErrorAtLastNameTextbox(), "Last name is required.");
    Assert.assertEquals(registerPage.getErrorAtEmailTextbox(), "Email is required.");
    Assert.assertEquals(registerPage.getErrorAtPasswordTextbox(), "Password is required.");
    Assert.assertEquals(registerPage.getErrorAtConfirmPasswordTextbox(), "Password is required.");
  }
  @Test
  public void Register_02_Invalid_Email() {
    homePage.clickToRegisterLink();

    registerPage.inputToFirstNameTextbox(firstName);
    registerPage.inputToLastNameTextbox(lastName);
    registerPage.inputToEmailTextbox("123@4645@456");
    registerPage.inputToPasswordTextbox(password);
    registerPage.inputToConfirmPasswordTextbox(password);

    registerPage.clickToRegisterButton();

    Assert.assertEquals(registerPage.getErrorAtEmailTextbox(), "Wrong email");
  }
  @Test
  public void Register_03_Register_Success() {
    homePage.clickToRegisterLink();

    registerPage.inputToFirstNameTextbox(firstName);
    registerPage.inputToLastNameTextbox(lastName);
    registerPage.inputToEmailTextbox(emailAddress);
    registerPage.inputToPasswordTextbox(password);
    registerPage.inputToConfirmPasswordTextbox(password);

    registerPage.clickToRegisterButton();

    Assert.assertEquals(registerPage.getSuccessMessage(), "Your registration completed");
    registerPage.clickToLogOutLink();
  }
  @Test
  public void Register_04_Existing_Email() {
    homePage.clickToRegisterLink();

    registerPage.inputToFirstNameTextbox(firstName);
    registerPage.inputToLastNameTextbox(lastName);
    registerPage.inputToEmailTextbox(emailAddress);
    registerPage.inputToPasswordTextbox(password);
    registerPage.inputToConfirmPasswordTextbox(password);

    registerPage.clickToRegisterButton();

    Assert.assertEquals(registerPage.getErrorAtExistingEmail(), "The specified email already exists");
  }
  @Test
  public void Register_05_Password_Less_Than_6_Chars() {
    homePage.clickToRegisterLink();

    registerPage.inputToFirstNameTextbox(firstName);
    registerPage.inputToLastNameTextbox(lastName);
    registerPage.inputToEmailTextbox(emailAddress);
    registerPage.inputToPasswordTextbox("123");
    registerPage.inputToConfirmPasswordTextbox("123");

    registerPage.clickToRegisterButton();

    Assert.assertEquals(registerPage.getErrorAtPasswordTextbox(), "Password must meet the following rules:\nmust have at least 6 characters");
  }
  @Test
  public void Register_06_Invalid_Confirm_Password() {
    homePage.clickToRegisterLink();

    registerPage.inputToFirstNameTextbox(firstName);
    registerPage.inputToLastNameTextbox(lastName);
    registerPage.inputToEmailTextbox(emailAddress);
    registerPage.inputToPasswordTextbox(password);
    registerPage.inputToConfirmPasswordTextbox(firstName);

    registerPage.clickToRegisterButton();

    Assert.assertEquals(registerPage.getErrorAtConfirmPasswordTextbox(), "The password and confirmation password do not match.");
  }

  @AfterClass
  public void afterClass() {
    driver.quit();
  }

  public int generateFakeNumber() {
    Random random = new Random();
    return random.nextInt(99999);
  }
}
