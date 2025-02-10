package com.company.pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class LoginPage extends BasePage {
    private final By username = By.xpath("//android.widget.EditText[@content-desc=\"test-Username\"]");
    private final By password = By.xpath("//android.widget.EditText[@content-desc=\"test-Password\"]");
    private final By login = By.xpath("//android.view.ViewGroup[@content-desc=\"test-LOGIN\"]");
    private final By productsTitle = By.xpath("//android.widget.TextView[@text=\"PRODUCTS\"]");
    private final By logOutButton = By.xpath("//android.widget.TextView[@text=\"LOGOUT\"]");
    private final By burgerMenu = By.xpath("//android.view.ViewGroup[@content-desc=\"test-Menu\"]/android.view.ViewGroup/android.widget.ImageView");
    private final By loginErrorMessages = By.xpath("//android.view.ViewGroup[@content-desc=\"test-Error message\"]");

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

    public boolean isDisplayedProductsTitle() {
        return elementIsDisplayed(productsTitle);
    }

    public void logOut(){
        click(burgerMenu);
        click(logOutButton);
    }

    public boolean loginErrorMessageIsDisplayed(){
       return elementIsDisplayed(loginErrorMessages);
    }
}