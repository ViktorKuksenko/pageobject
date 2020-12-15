package com.softserve.edu.pageobject.pages.econews;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FilterContainer {
    private final String Filter_COMPONENT_XPATH = "//ul[@class='ul-eco-buttons']/a/li";

    private WebDriver driver;
    //
    private List<WebElement> filters;
    private WebElement filterBy;

    public FilterContainer(WebDriver driver) {
        this.driver = driver;
        initElements();
    }

    private void initElements() {
        // init elements
        filterBy = driver.findElement(By.xpath("//div[@class='wrapper']/span[. ='Filter by']"));
        filters = new ArrayList<>();
        for (WebElement current : driver.findElements(By.xpath(Filter_COMPONENT_XPATH))) {
            filters.add(current);
        }
    }

    // Page Object

    public boolean areFilterButtonsPresent(String expectedFilterElement) {
        boolean isButtonPresent = false;
        for (WebElement element : filters) {
            if (element.getText().contains(expectedFilterElement)) {
                isButtonPresent = true;
            }
        }
        return isButtonPresent;
    }

    public String getFilterButtonClass(String expectedFilterElement) {
        String filterButtonClass = "";
        for (WebElement filterButton : filters) {
            if (filterButton.getText().trim().equals(expectedFilterElement)) {
                //check if classname changed on "custom-chip global-tag global-tag-clicked"
                filterButton.click();
                filterButtonClass = filterButton.getAttribute("class");
            }
        }
        return filterButtonClass;
    }

    public NewsContainer clickFilterButtonByName(String expectedFilterElement) {
        for (WebElement filterButton : filters) {
            if (filterButton.getText().trim().equals(expectedFilterElement)) {
                //check if classname changed on "custom-chip global-tag global-tag-clicked"
                filterButton.click();
            }
        }
        return new NewsContainer(driver);
    }

    public EconewsPage unclickFilterButton() {
        for (WebElement filterButton : filters) {
            if (filterButton.getAttribute("class").equals("custom-chip global-tag global-tag-clicked")) {
                filterButton.click();
            }
        }
        return new EconewsPage(driver);
    }

    public String getFilterByElement() {
        return filterBy.getText();
    }
    // Functional

    // Business Logic

}
