package com.company.pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class OrderPage extends BasePage{
    private final By firstProduct = getProductByIndex(1);
    private final By secondProduct = getProductByIndex(2);
    private final By cart = By.xpath("//android.view.ViewGroup[@content-desc=\"test-Cart\"]/android.view.ViewGroup/android.widget.ImageView");
    private final By checkout = By.xpath("//android.view.ViewGroup[@content-desc=\"test-CHECKOUT\"]");
    private final By firstName = By.xpath("//android.widget.EditText[@content-desc=\"test-First Name\"]");
    private final By lastName = By.xpath("//android.widget.EditText[@content-desc=\"test-Last Name\"]");
    private final By zipCode = By.xpath("//android.widget.EditText[@content-desc=\"test-Zip/Postal Code\"]");
    private final By continueCheck = By.xpath("//android.view.ViewGroup[@content-desc=\"test-CONTINUE\"]");
    private final By finish = By.xpath("//android.view.ViewGroup[@content-desc=\"test-FINISH\"]");
    private final By goHome = By.xpath("//android.view.ViewGroup[@content-desc=\"test-BACK HOME\"]");
    private final By productsTitleForCheckHome = By.xpath("//android.widget.TextView[@text=\"PRODUCTS\"]");
    private final By firstNameIsRequiredMessage = By.xpath("//android.view.ViewGroup[@content-desc=\"test-Error message\"]");

    public OrderPage(AndroidDriver driver) {
        super(driver);
    }

    public void selectFirstProduct() {
       click(firstProduct);
    }

    public void selectSecondProduct() {
        click(secondProduct);
    }

    public void openCart() {
        click(cart);
    }

    public void proceedToCheckout() {
        click(checkout);
    }

    public void enterCustomerDetails(String firstNameText, String lastNameText, String zipCodeText) {
        type(firstName,firstNameText);
        type(lastName,lastNameText);
        type(zipCode,zipCodeText);
    }

    public void continueCheckout() {
        click(continueCheck);
    }

    public void finishOrder() {
        scrollToDescription("test-FINISH");
        click(finish);
    }

    public void returnHome() {
        click(goHome);
    }

    public boolean isProductTitleDisplayedOnHomePage() {
        return elementIsDisplayed(productsTitleForCheckHome);
    }

    public boolean errorMessageIsDisplayed() {
        return elementIsDisplayed(firstNameIsRequiredMessage);
    }
}
