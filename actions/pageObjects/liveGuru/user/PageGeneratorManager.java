package pageObjects.liveGuru.user;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {
    public static HomePageObject getHomePage(WebDriver driver){
        return new HomePageObject(driver);
    }
    public static LoginPageObject getLoginPage(WebDriver driver){
        return new LoginPageObject(driver);
    }
    public static RegisterPageObject getRegisterPage(WebDriver driver){
        return new RegisterPageObject(driver);
    }
    public static MyDashboardPageObject getMyAccountDashboardPage(WebDriver driver){
        return new MyDashboardPageObject(driver);
    }
    public static AccountInforPageObject getAccountInforPage(WebDriver driver){
        return new AccountInforPageObject(driver);
    }
    public static AddressBookPageObject getAddressBookPage(WebDriver driver){
        return new AddressBookPageObject(driver);
    }
    public static MyOrderPageObject getMyOrdersPage(WebDriver driver){
        return new MyOrderPageObject(driver);
    }
    public static BillingAgreementsPageObject getBillingAgreementsPage(WebDriver driver){
        return new BillingAgreementsPageObject(driver);
    }
}
