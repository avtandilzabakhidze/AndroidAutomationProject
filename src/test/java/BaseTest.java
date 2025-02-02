import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {
    protected AndroidDriver driver;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        String appiumServer = "http://127.0.0.1:4723";
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "14.0");
        capabilities.setCapability("appium:deviceName", "R58X60DG49W");
        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("appium:app", System.getProperty("user.dir") + "/apk/demo.apk");
        driver = new AndroidDriver(new URL(appiumServer), capabilities);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
