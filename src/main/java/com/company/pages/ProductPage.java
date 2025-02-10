package com.company.pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class ProductPage extends BasePage {
    private final By firstProduct = getProductByIndex(1);
    private final By secondProduct = getProductByIndex(2);
    private final By productRemoveButton = getRemoveButtonByIndex(1);

    public ProductPage(AndroidDriver driver) {
        super(driver);
    }

    public void selectFirstProduct() {
        click(firstProduct);
    }

    public void selectSecondProduct() {
        click(secondProduct);
    }

    public void removeFirstProduct() {
        click(productRemoveButton);
    }

    public void removeSecondProduct() {
        click(productRemoveButton);
    }

    public boolean isProductSelected() {
        return elementIsDisplayed(productRemoveButton);
    }
}
