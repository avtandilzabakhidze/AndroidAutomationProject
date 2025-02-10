package com.company.pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class ProductDetailPage extends BasePage {
    private By firstProduct = By.xpath("(//android.view.ViewGroup[@content-desc=\"test-Item\"])[1]/android.view.ViewGroup");
    private By firstProductImage = By.xpath("//android.view.ViewGroup[@content-desc=\"test-Image Container\"]/android.widget.ImageView");
    private By firstProductTitle = By.xpath("//android.widget.TextView[@text=\"Sauce Labs Backpack\"]");
    private By firstProductDescription = By.xpath("//android.widget.TextView[@text=\"carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.\"]");

    public ProductDetailPage(AndroidDriver driver) {
        super(driver);
    }

    public void openFirstProduct() {
        driver.findElement(firstProduct).click();
    }

    public boolean isFirstProductImgDisplayed() {
        return elementIsDisplayed(firstProductImage);
    }

    public boolean isFirstProductTitleDisplayed() {
        return elementIsDisplayed(firstProductTitle);
    }

    public boolean isFirstProductDescriptionDisplayed() {
        return elementIsDisplayed(firstProductDescription);
    }
}
