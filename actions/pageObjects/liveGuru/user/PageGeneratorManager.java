package pageObjects.liveGuru.user;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {
    public static UserHomePageObject getHomePage(WebDriver driver){
        return new UserHomePageObject(driver);
    }
    public static UserLoginPageObject getLoginPage(WebDriver driver){
        return new UserLoginPageObject(driver);
    }
    public static RegisterPageObject getRegisterPage(WebDriver driver){
        return new RegisterPageObject(driver);
    }
    public static UserMyDashboardPageObject getMyAccountDashboardPage(WebDriver driver){
        return new UserMyDashboardPageObject(driver);
    }
    public static UserAccountInforPageObject getAccountInforPage(WebDriver driver){
        return new UserAccountInforPageObject(driver);
    }
    public static UserAddressBookPageObject getAddressBookPage(WebDriver driver){
        return new UserAddressBookPageObject(driver);
    }
    public static UserMyOrderPageObject getMyOrdersPage(WebDriver driver){
        return new UserMyOrderPageObject(driver);
    }
    public static UserillingAgreementsPageObject getBillingAgreementsPage(WebDriver driver){
        return new UserillingAgreementsPageObject(driver);
    }
}
