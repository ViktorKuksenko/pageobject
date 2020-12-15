package com.softserve.edu.pageobject.test.vkuksenko;

import com.softserve.edu.pageobject.test.GreencityTestRunner;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class EcoNewsSmokeTest extends GreencityTestRunner {

    @Test
    public void verifyPageTitleIsPresent() {
        String pageTitle = loadApplication()
                .navigateEconews()
                .getPageTitle();
        Assert.assertTrue(pageTitle.length() > 0);
    }

    @Test
    public void verifyPageTitleName() {
        String pageTitle = loadApplication()
                .navigateEconews()
                .getPageTitle();
        Assert.assertTrue(pageTitle.equals("Eco news"));
    }


    @Test
    public void verifyEcoNewsPageHeaderIsPresent() {
        String mainHeader = loadApplication()
                .navigateEconews()
                .getPageTitle();
        Assert.assertTrue(mainHeader.length() > 0);
    }

    @Test
    public void verifyEcoNewsPageHeaderName() {
        String mainHeader = loadApplication()
                .navigateEconews()
                .getPageTitle();
        Assert.assertTrue(mainHeader.equals("Eco news"));
    }

    public void verifyPresenceOfFilterButtons(String expectedFilterElement) {
        boolean isButtonPresent = loadApplication()
                .navigateEconews()
                .getFilterSection()
                .areFilterButtonsPresent(expectedFilterElement);
        Assert.assertTrue(isButtonPresent);
    }

    @Test
    public void verifyAdsFilterButtonIsPresent() {
        verifyPresenceOfFilterButtons("Ads");
    }

    @Test
    public void verifyEventsFilterButtonIsPresent() {
        verifyPresenceOfFilterButtons("Events");
    }

    @Test
    public void verifyNewsFilterButtonIsPresent() {
        verifyPresenceOfFilterButtons("News");
    }

    @Test
    public void verifyEducationFilterButtonIsPresent() {
        verifyPresenceOfFilterButtons("Education");
    }

    @Test
    public void verifyInitiativesFilterButtonIsPresent() {
        verifyPresenceOfFilterButtons("Initiatives");
    }

    @Test
    public void verifyFilterByElementIsPresent() {
        String filterByElement = loadApplication()
                .navigateEconews()
                .getFilterSection()
                .getFilterByElement();
        Assert.assertTrue(filterByElement.equals("Filter by"));
    }

    public void verifyClickabilityOfFilterButtons(String expectedFilterButton) {
        String filterButtonClass = loadApplication()
                .navigateEconews()
                .getFilterSection()
                .getFilterButtonClass(expectedFilterButton);
        Assert.assertTrue(filterButtonClass.equals("custom-chip global-tag global-tag-clicked"));
    }

    @Test
    public void verifyAdsFilterButtonIsClickable() {
        verifyClickabilityOfFilterButtons("Ads");
    }

    @Test
    public void verifyEventsFilterButtonIsClickable() {
        verifyClickabilityOfFilterButtons("Events");
    }

    @Test
    public void verifyNewsFilterButtonIsClickable() {
        verifyClickabilityOfFilterButtons("News");
    }

    @Test
    public void verifyEducationFilterButtonIsClickable() {
        verifyClickabilityOfFilterButtons("Education");
    }

    @Test
    public void verifyInitiativesFilterButtonIsClickable() {
        verifyClickabilityOfFilterButtons("Initiatives");
    }

    private void verifyBottomMenuItemsArePresent(String expectedMenuItems) {
        List<String> bottomMenuItems = loadApplication()
                .navigateEconews()
                .getBottomMenuItemsName();
        Assert.assertTrue(bottomMenuItems.contains(expectedMenuItems));
    }

    @Test
    public void verifyEcoNewsBottomMenuItemIsPresent() {
        verifyBottomMenuItemsArePresent("Eco news");
    }

    @Test
    public void verifyTipsAndTricksBottomMenuItemIsPresent() {
        verifyBottomMenuItemsArePresent("Tips & Tricks");
    }

    @Test
    public void verifyPlacesBottomMenuItemIsPresent() {
        verifyBottomMenuItemsArePresent("Places");
    }

    @Test
    public void verifyAboutUsBottomMenuItemIsPresent() {
        verifyBottomMenuItemsArePresent("About us");
    }

    @Test
    public void verifyMyHabitsBottomMenuItemIsPresent() {
        verifyBottomMenuItemsArePresent("My habits");
    }

    @Test
    public void verifyFollowUsElementIsPresent() {
        String followUsElement = loadApplication()
                .navigateEconews()
                .getFollowUs();
        Assert.assertTrue(followUsElement.length() > 0);
    }

    @Test
    public void verifyFollowUsElementName() {
        String followUsElement = loadApplication()
                .navigateEconews()
                .getFollowUs();
        Assert.assertTrue(followUsElement.equals("Follow us"));
    }

    @Test
    public void verifyItemsFoundParagraphIsPresent() {
        String actualItemsFoundParagraph = loadApplication()
                .navigateEconews()
                .getNewsSection()
                .getItemsFoundParagraph();
        Assert.assertEquals(actualItemsFoundParagraph, "items found");
    }

    @Test
    public void verifyGridButtonIsPresent() {
        boolean isPresentGridButton = loadApplication()
                .navigateEconews()
                .getNewsSection()
                .isPresentGridButton();
        Assert.assertTrue(isPresentGridButton);
    }

    @Test
    public void verifyListButtonIsPresent() {
        boolean isPresentListButton = loadApplication()
                .navigateEconews()
                .getNewsSection()
                .isPresentListButton();
        Assert.assertTrue(isPresentListButton);
    }

    @Test
    public void verifyListButtonIsClickable() {
        boolean isClickableListButton = loadApplication()
                .navigateEconews()
                .getNewsSection()
                .isListButtonClickable();
        Assert.assertTrue(isClickableListButton);
    }

    @Test
    public void verifyGridButtonIsClickable() {
        boolean isClickableGridButton = loadApplication()
                .navigateEconews()
                .getNewsSection()
                .isGridButtonClickable();
        Assert.assertTrue(isClickableGridButton);
    }

    @Test
    public void verifyGreencityLogoIsClickable() {
        String welcomePageLeftHeader = loadApplication()
                .navigateEconews()
                .isGreenCityLogoClickable()
                .getHeaderLeftText();
        Assert.assertTrue("A new way to cultivate useful habits".equals(welcomePageLeftHeader));
    }

    @Test
    public void verifyGreencityLogoIsPresent() {
        boolean isGreencityLogoPresent = loadApplication()
                .navigateEconews()
                .isGreenCityLogoPresent();
        Assert.assertTrue(isGreencityLogoPresent);
    }
}
