package com.company.pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class LoginPage extends BasePage {
    private final By username = By.xpath("//android.widget.EditText[@content-desc=\"test-Username\"]");
    private final By password = By.xpath("//android.widget.EditText[@content-desc=\"test-Password\"]");
    private final By login = By.xpath("//android.view.ViewGroup[@content-desc=\"test-LOGIN\"]");

    public LoginPage(AndroidDriver driver) {
        super(driver);
    }

    public void typeUsername(String usernameText) {
        type(username, usernameText);
    }

    public void typePassword(String passwordText) {
        type(password, passwordText);
    }

    public void clickLogin() {
        click(login);
    }
}
