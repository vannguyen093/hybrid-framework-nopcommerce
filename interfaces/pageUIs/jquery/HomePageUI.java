package pageUIs.jquery;

public class HomePageUI {
    public static final String PAGING_PAGE_BY_NUMBER = "xpath=//li[@class='qgrd-pagination-page']/a[text()='%s']";
    public static final String PAGE_NUMBER_ACTIVED = "xpath=//li[@class='qgrd-pagination-page']/a[@class='qgrd-pagination-page-link active' and text()='%s']";
    public static final String FILTER_TEXTBOX = "xpath=//div[@class='qgrd-header-text' and text()='%s']/parent::div/following-sibling::input";
    public static final String TOTAL_PAGING = "css=ul.qgrd-pagination-ul>li";
    public static final String TOTAL_PAGING_INDEX = "xpath=//ul[@class='qgrd-pagination-ul']/li[%s]/a";
    public static final String ALL_ROW_EACH_PAGE = "xpath=//tbody/tr";
}
