package com.softserve.edu.pageobject.pages.tipstricks;

import java.util.ArrayList;
import java.util.List;

import com.softserve.edu.pageobject.pages.TopPart;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.softserve.edu.pageobject.pages.econews.NewsComponent;

public class TipCardContainer extends TopPart {
    private final String TIP_CARD_COMPONENT_CSSSELECTOR = "????";

    private WebDriver driver;
    //
    private List<TipCardComponent> tipCardComponents;

    public TipCardContainer(WebDriver driver) {
        super(driver);
        initElements();
    }

    private void initElements() {
        // init elements

    }

    // Page Object

    // Functional

    // Business Logic

}
