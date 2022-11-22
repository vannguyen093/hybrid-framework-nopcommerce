package pageObjects.wordpress.admin;

import org.openqa.selenium.WebDriver;

public class PageGenerateManager {
    public static AdminLoginPO getAdminLoginPage(WebDriver driver) {
        return new AdminLoginPO(driver);
    }
    public static AdminDashboardPO getAdminDashboardPage(WebDriver driver) {
        return new AdminDashboardPO(driver);
    }
    public static AdminPostSearchPO getAdminPostSearchPage(WebDriver driver) {
        return new AdminPostSearchPO(driver);
    }
    public static AdminPostAddNewPO getAdminPostAddNewPage(WebDriver driver) {
        return new AdminPostAddNewPO(driver);
    }
}
