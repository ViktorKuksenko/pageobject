package com.softserve.edu.pageobject.test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.pageobject.data.User;
import com.softserve.edu.pageobject.data.UserRepository;
import com.softserve.edu.pageobject.pages.myhabits.MyHabitsPage;
import com.softserve.edu.pageobject.pages.welcome.WelcomePage;

public class SmokeTest extends GreencityTestRunner {

    //@Test
    public void checkMenu() {
        // Precondition
        //setWindowSize(640, 480);
        //setWindowSize(480, 640);
        //
        // Steps
        WelcomePage welcomePage = loadApplication()
            .navigateEconews()
            .navigateTipsTricks()
            .navigatePlaces()
            .navigateAbout()
            .navigateWelcome();
        //
        // Check
        Assert.assertEquals(welcomePage.getButtonStartAttributeClass(),
                WelcomePage.HEADER_LEFT_ATTRIBUTE);
    }
    
    @DataProvider//(parallel = true)
    public Object[][] users() {
        return new Object[][] {
            { UserRepository.getDefault() },
        };
    }
    
    //@Test(dataProvider = "users")
    public void checkLogin(User user) {
        MyHabitsPage myHabitsPage = loadApplication()
                .navigateLogin()
                .successfulLogin(user);
        Assert.assertEquals(myHabitsPage.getProfileText(),
                user.getName());
        WelcomePage welcomePage = myHabitsPage.gotoLogout();
        Assert.assertTrue(welcomePage.isSignInAvailable());
    }
    
    @Test(dataProvider = "users")
    public void checkMyHabits(User user) {
        // Steps
        WelcomePage welcomePage = loadApplication()
            .navigateMyHabits(user)
            .gotoAddHabits()
            .navigateEconews()
            .navigateTipsTricks()
            .navigatePlaces()
            .navigateAbout()
            .navigateMyHabits()
            .navigateWelcome()
            .gotoLogout();
        //
        // Check
        Assert.assertEquals(welcomePage.getButtonStartAttributeClass(),
                WelcomePage.HEADER_LEFT_ATTRIBUTE);
        Assert.assertTrue(welcomePage.isSignInAvailable());
    }
    
}
