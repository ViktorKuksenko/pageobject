package com.softserve.edu.pageobject.pages.econews;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.softserve.edu.pageobject.pages.TopPart;
import org.openqa.selenium.WebElement;

public class NewsDetailsPage extends TopPart {
private WebElement backToNewsButton;
    public NewsDetailsPage(WebDriver driver) {
        super(driver);
        initElements();
    }

    private void initElements() {
        backToNewsButton = driver.findElement(By.xpath("//div[@class='button-text']"));
        // init elements
    }

    // Page Object
    public FilterContainer clickBackToNewsButton() {
        backToNewsButton.click();
        return new FilterContainer(driver);
    }


    // Functional

    // Business Logic
}
