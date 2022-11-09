package commons;

import java.io.File;

public class GlobalConstants {
    public static final String USER_PAGE_URL = "https://demo.nopcommerce.com/";
    public static final String ADMIN_PAGE_URL = "https://admin-demo.nopcommerce.com/";
    public static final String USER_LIVE_GURU_URL = "http://live.techpanda.org/";
    public static final String PROJECT_PATH = System.getProperty("user.dir");
    public static final String OS_NAME = System.getProperty("osName");
    public static final String UPLOAD_FILE = PROJECT_PATH + File.separator + "uploadFiles";
    public static final String DOWNLOAD_FILE = PROJECT_PATH + File.separator + "downloadFiles";
    public static final String BROWSER_LOG = PROJECT_PATH + File.separator + "browserLogs";
    public static final String DRAG_DROP_HTML5 = PROJECT_PATH + File.separator + "dragDropHTML5";
    public static final String AUTO_IT_SCRIPT = PROJECT_PATH + File.separator + "autoIT";

    public static final String DB_DEV_URL = "192.168.1.15:8080";
    public static final String DB_DEV_USERNAME = "vannguyen093";
    public static final String DB_DEV_PASS = "p@ssword123@#";

    public static final String DB_TEST_URL = "192.168.1.30:8080";
    public static final String DB_TEST_USERNAME = "vannguyen093";
    public static final String DB_TEST_PASS = "p@ssword123@#";

    public static final long SHORT_TIMEOUT = 5;
    public static final long LONG_TIMEOUT = 30;
    public static final long RETRY_TEST_FAIL = 3;
}
