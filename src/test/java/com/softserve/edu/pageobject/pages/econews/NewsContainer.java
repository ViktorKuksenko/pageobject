package com.softserve.edu.pageobject.pages.econews;

import java.util.ArrayList;
import java.util.List;

import com.softserve.edu.pageobject.pages.welcome.WelcomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class NewsContainer {
    private final String NEWS_COMPONENT_XPATH = "//li[@class = 'gallery-view-li-active ng-star-inserted']";
    private WebDriver driver;
    //
    private List<NewsComponent> newsComponents;
    private WebElement itemsFoundParagraph;
//    private List<WebElement> listButton;
//    private List<WebElement> gridButton;

    public NewsContainer(WebDriver driver) {
        this.driver = driver;
        initElements();
    }

    private void initElements() {
        // READ ALL COMPONENT by Scroll
        //
        // init elements
        itemsFoundParagraph = driver.findElement(By.xpath("//div[@class='main-wrapper']//p"));
//        listButton = driver.findElements(By.xpath("//span[@class='btn-bars']"));
//        gridButton = driver.findElements(By.xpath("//span[@class='btn-tiles']"));
        newsComponents = new ArrayList<>();
        for (WebElement current : driver.findElements(By.xpath(NEWS_COMPONENT_XPATH))) {
            newsComponents.add(new NewsComponent(current));
        }
    }

    // Page Object

    // newsComponents
    public List<NewsComponent> getNewsComponents() {
        return newsComponents;
    }

    // Functional

    public int getNewsComponentsCount() {
        return getNewsComponents().size();
    }

    public List<String> getNewsComponentTitles() {
        List<String> newsComponentTitles = new ArrayList<>();
        for (NewsComponent current : getNewsComponents()) {
            newsComponentTitles.add(current.getTitleText());
        }
        return newsComponentTitles;
    }

    protected NewsComponent getNewsComponentByTitle(String title)
    {
        NewsComponent result = null;
        for (NewsComponent current : getNewsComponents())
        {
            if (current.getTitleText().toLowerCase()
                    .equals(title.toLowerCase()))
            {
                result = current;
                break;
            }
        }
        if (result == null)
        {
            // TODO Develop Custom Exception
            // Use String.format(); final
            throw new RuntimeException("News Title: " + title + " not Found.");
        }
        return result;
    }

    public String getNewsComponentContentByTitle(String title) {
        // TODO +++++++++++++++++++ Content
        return getNewsComponentByTitle(title).getTitleText();
    }

    // TODO Get other filters, date, content

    // TODO Change to Product
    public void clickNewsComponentContentByTitle(String title) {
        // TODO +++++++++++++++++++
        getNewsComponentByTitle(title).clickTitle();
    }

    // TODO Click

    // TODO  READ ALL COMPONENT


    // Business Logic
    public String getItemsFoundParagraph() {
        return itemsFoundParagraph.getText().replaceAll("[^A-z]", " ").trim();
    }

    private List<WebElement> getGridButton() {
        return driver.findElements(By.xpath("//span[@class='btn-tiles']"));
    }

    private List<WebElement> getListButton() {
        return driver.findElements(By.xpath("//span[@class='btn-bars']"));
    }

    private List<WebElement> getGridButtonClicked() {
        return driver.findElements(By.xpath("//span[@class='btn-tiles btn-tiles-active']"));
    }

    private List<WebElement> getListButtonClicked() {
        return driver.findElements(By.xpath("//span[@class='btn-bars btn-bars-active']"));
    }

    public boolean isPresentListButton() {
        return !getListButton().isEmpty();
    }

    public boolean isPresentGridButton() {
        return !getGridButtonClicked().isEmpty();
    }

    public boolean isGridButtonClickable() {
        getListButton().get(0).click();
        getGridButton().get(0).click();
        //check if class of grid button changed after click
        return "btn-tiles btn-tiles-active".equals(getGridButtonClicked().get(0).getAttribute("class"));
    }

    public boolean isListButtonClickable() {
        getListButton().get(0).click();
        //check if class of list button changed after click
        return "btn-bars btn-bars-active".equals(getListButtonClicked().get(0).getAttribute("class"));
    }

    public NewsDetailsPage getFirstNewsComponent() {
//        new WebDriverWait(driver, 10).until(ExpectedConditions.stalenessOf(driver.findElement(By
//                .xpath("//li[@class='gallery-view-li-active ng-star-inserted'][1]//div[@class='list-gallery']"))));
        newsComponents.get(0).clickTitle();

        return new NewsDetailsPage(driver);
    }
}
