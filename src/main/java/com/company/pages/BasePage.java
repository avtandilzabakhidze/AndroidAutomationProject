package com.company.pages;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BasePage {
    AndroidDriver driver;
    WebDriverWait wait;

    public BasePage(AndroidDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public WebElement findElement(By locator) {
        return driver.findElement(locator);
    }

    public void click(By locator) {
        findElement(locator).click();
    }

    public String getText(By locator) {
        return findElement(locator).getText();
    }

    public void type(By locator, String text) {
        findElement(locator).clear();
        findElement(locator).sendKeys(text);
    }

    public boolean elementIsDisplayed(By locator) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }

    public By getProductByIndex(int index) {
        return By.xpath("(//android.view.ViewGroup[@content-desc=\"test-ADD TO CART\"])[" + index + "]");
    }

    public By getRemoveButtonByIndex(int index) {
        return By.xpath("(//android.view.ViewGroup[@content-desc=\"test-REMOVE\"])[" + index + "]");
    }

    public By getProductCardByNumber(String number) {
        return By.xpath("//android.widget.TextView[@text='" + number + "']");
    }

    public boolean scrollToDescription(String description) {
        String uiAutomatorScroll = String.format(
                "new UiScrollable(new UiSelector().scrollable(true))" +
                        ".scrollIntoView(new UiSelector().description(\"%s\"));",
                description
        );

        try {
            driver.findElement(AppiumBy.androidUIAutomator(uiAutomatorScroll));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}