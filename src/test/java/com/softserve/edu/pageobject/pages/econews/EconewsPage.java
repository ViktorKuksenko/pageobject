package com.softserve.edu.pageobject.pages.econews;

import com.softserve.edu.pageobject.pages.welcome.WelcomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.softserve.edu.pageobject.pages.TopPart;

import java.util.ArrayList;
import java.util.List;

public class EconewsPage extends TopPart {

    private WebElement mainHeader;
    private List<WebElement> bottomMenu;
    private WebElement followUs;
    private List<WebElement> greencityLogo;
    //
    public EconewsPage(WebDriver driver) {
        super(driver);
        initElements();
    }

    private void initElements() {
        // init elements
        mainHeader = driver.findElement(By.className("main-header"));
        bottomMenu = driver.findElements(By.xpath("//li/a[@class='router-links']"));
        followUs = driver.findElement(By.xpath("//div[@class='follow-us-text']/p"));
        greencityLogo = driver.findElements(By.xpath("//img[@class='logo']"));
        //newsContainer = new NewsContainer(driver);
    }

    // Page Object

    // mainHeader

    public String getPageTitle() {
        return driver.getTitle();
    }

    public String getMainHeader() {
        return mainHeader.getText();
    }

    public List<WebElement> getBottomMenu() {
        return bottomMenu;
    }

    public List<String> getBottomMenuItemsName() {
        List<String> bottomMenuItems = new ArrayList<>();
        for (WebElement menuItem : getBottomMenu()) {
            bottomMenuItems.add(menuItem.getText());
        }
        return bottomMenuItems;
    }

    public String getFollowUs() {
        return followUs.getText();
    }

    public FilterContainer getFilterSection() {
        return new FilterContainer(driver);
    }

    public NewsContainer getNewsSection() {
        return new NewsContainer(driver);
    }

    public boolean isGreenCityLogoPresent() {
        return !greencityLogo.isEmpty();
    }

    public WelcomePage isGreenCityLogoClickable() {
        greencityLogo.get(0).click();
        return new WelcomePage(driver);
    }

    // Functional

    // Business Logic

}