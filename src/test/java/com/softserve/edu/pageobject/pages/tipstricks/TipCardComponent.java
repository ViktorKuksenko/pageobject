package com.softserve.edu.pageobject.pages.tipstricks;

import com.softserve.edu.pageobject.pages.TopPart;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TipCardComponent extends TopPart {

    private WebElement leftTipCard;
    private WebElement middleTipCard;
    private WebElement rightTipCard;

    public TipCardComponent(WebDriver driver) {
        super(driver);
        initElements();
    }

    private void initElements() {
        middleTipCard = driver.findElement(By.xpath("//app-tips-card[@class='swiper-slide ng-star-inserted swiper-slide-active']"));
        rightTipCard = driver.findElement(By.xpath("//app-tips-card[@class='swiper-slide ng-star-inserted swiper-slide-next']"));
        leftTipCard = driver.findElement(By.xpath("//app-tips-card[@class='swiper-slide ng-star-inserted swiper-slide-prev']"));


        // init elements
    }

    // Page Object

    // Functional

    // Business Logic

}
