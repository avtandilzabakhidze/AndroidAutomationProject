import com.company.pages.LoginPage;
import com.company.pages.ProductPage;
import com.company.pages.ProductDetailPage;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {
    protected AndroidDriver driver;
    protected LoginPage loginPage;
    protected ProductDetailPage productDetailPage;
    protected ProductPage productPage;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        String appiumServer = "http://127.0.0.1:4723";
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("appPackage", "com.swaglabsmobileapp");
        capabilities.setCapability("appActivity", "com.swaglabsmobileapp.SplashActivity");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "14.0");
        capabilities.setCapability("deviceName", "R58X60DG49W");
        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("app", System.getProperty("user.dir") + "/apk/demo.apk");
        capabilities.setCapability("fullReset", true);
        capabilities.setCapability("autoGrantPermissions", true);
        capabilities.setCapability("newCommandTimeout", 300);

        driver = new AndroidDriver(new URL(appiumServer), capabilities);
        loginPage = new LoginPage(driver);
        productDetailPage = new ProductDetailPage(driver);
        productPage = new ProductPage(driver);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    public void baseLogin(){
        loginPage.typeUsername("standard_user");
        loginPage.typePassword("secret_sauce");
        loginPage.clickLogin();
    }
}
