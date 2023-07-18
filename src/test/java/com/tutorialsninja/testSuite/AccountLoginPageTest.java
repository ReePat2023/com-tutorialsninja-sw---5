package com.tutorialsninja.testSuite;

import com.tutorialsninja.customlistners.CustomListners;
import com.tutorialsninja.pages.AccountLoginPage;
import com.tutorialsninja.pages.AccountRegisterPage;
import com.tutorialsninja.pages.HomePage;
import com.tutorialsninja.pages.MyAccountPage;
import com.tutorialsninja.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(CustomListners.class)
public class AccountLoginPageTest extends BaseTest {
    HomePage homePage;
    AccountLoginPage accountLoginPage;
    MyAccountPage accountPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        homePage = new HomePage();
        accountLoginPage = new AccountLoginPage();
        accountPage = new MyAccountPage();
    }

    @Test(groups = {"sanity", "regression"})
    public void verifyUserShouldNavigateToLoginPageSuccessfully() throws InterruptedException {
        homePage.clickOnMyAccountTab();
        homePage.selectMyAccountOptions("Login");
        Assert.assertEquals(accountLoginPage.getReturningCustomerText(),
                "Returning Customer", "Login page not displayed");
    }

    @Test(groups = {"smoke", "regression"})
    public void verifyThatUserShouldLoginAndLogoutSuccessfully() throws InterruptedException {
        homePage.clickOnMyAccountTab();
        homePage.selectMyAccountOptions("Login");
        accountLoginPage.enterEmailAddress("admin123456@gmail.com");
        accountLoginPage.enterPassword("Admin@123");
        accountLoginPage.clickOnLoginButton();
        homePage.clickOnMyAccountTab();
        homePage.selectMyAccountOptions("Logout");
        Assert.assertEquals(accountPage.getAccountLogoutText(), "Account Logout", "Not logged out");
    }

}