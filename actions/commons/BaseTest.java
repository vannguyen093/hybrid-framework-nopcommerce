package commons;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    private WebDriver driver;
    protected final Log log;

    @BeforeSuite
    public void initBeforeSuite() {
        deleteAllureReport();
    }

    String projectPath = System.getProperty("user.dir");

    protected BaseTest() {
        log = LogFactory.getLog(getClass());
    }

    protected WebDriver getBrowserDriver(String browserName, String appUrl) {
        BrowserList browserList = BrowserList.valueOf(browserName.toUpperCase());
        switch (browserList) {
            case FIREFOX:
                //                WebDriverManager.firefoxdriver().setup();
                System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
                driver = new FirefoxDriver();
                break;
            case H_FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions options = new FirefoxOptions();
                options.addArguments("--headless");
                options.addArguments("window-size=1920x1080");
                driver = new FirefoxDriver(options);
                break;
            case CHROME:
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case H_CHROME:
                WebDriverManager.chromedriver().setup();
                ChromeOptions optionChrome = new ChromeOptions();
                optionChrome.addArguments("--headless");
                optionChrome.addArguments("window-size=1920x1080");
                driver = new ChromeDriver(optionChrome);
                break;
            case EDGE:
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            default:
                throw new RuntimeException("Browser not supported: " + browserName);
        }
        driver.manage().timeouts().implicitlyWait(GlobalConstants.LONG_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(appUrl);
        return driver;
    }

    public WebDriver getDriverInstance() {
        return this.driver;
    }

    private String getEnvironmentUrl(String serverName) {
        String envUrl = null;
        EnviromentList enviroment = EnviromentList.valueOf(serverName.toUpperCase());
        switch (enviroment) {
            case DEV:
                envUrl = "https://demo.nopcommerce.com/";
                break;
            case TESTING:
                envUrl = "https://admin-demo.nopcommerce.com/";
                break;
            case STAGING:
                envUrl = "https://staging.nopcommerce.com/";
                break;
            case PRODUCTION:
                envUrl = "https://production.nopcommerce.com/";
                break;
        }
        return envUrl;
    }

    protected boolean verifyTrue(boolean condition) {
        boolean pass = true;
        try {
            if (condition == true) {
                log.info(" -------------------------- PASSED -------------------------- ");
            } else {
                log.info(" -------------------------- FAILED -------------------------- ");
            }
            Assert.assertTrue(condition);
        } catch (Throwable e) {
            pass = false;

            VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
            Reporter.getCurrentTestResult().setThrowable(e);
        }
        return pass;
    }

    protected boolean verifyFalse(boolean condition) {
        boolean pass = true;
        try {
            if (condition == false) {
                log.info(" -------------------------- PASSED -------------------------- ");
            } else {
                log.info(" -------------------------- FAILED -------------------------- ");
            }
            Assert.assertFalse(condition);
        } catch (Throwable e) {
            pass = false;
            VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
            Reporter.getCurrentTestResult().setThrowable(e);
        }
        return pass;
    }

    protected boolean verifyEquals(Object actual, Object expected) {
        boolean pass = true;
        try {
            Assert.assertEquals(actual, expected);
            log.info(" -------------------------- PASSED -------------------------- ");
        } catch (Throwable e) {
            pass = false;
            log.info(" -------------------------- FAILED -------------------------- ");
            VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
            Reporter.getCurrentTestResult().setThrowable(e);
        }
        return pass;
    }

    protected int generateFakeNumber() {
        Random random = new Random();
        return random.nextInt(99999);
    }

    public void deleteAllureReport(){
        try {
            String pathFolderDownload = GlobalConstants.PROJECT_PATH + "/allure-json";
            File file = new File(pathFolderDownload);
            File[] files = file.listFiles();
            for (int i = 0; i < files.length; i++) {
                if (files[i].isFile()){
                    new File(files[i].toString()).delete();
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
