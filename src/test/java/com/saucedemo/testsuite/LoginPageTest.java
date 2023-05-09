package com.saucedemo.testsuite;

import com.saucedemo.customlisteners.CustomListeners;
import com.saucedemo.pages.LoginPage;
import com.saucedemo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners(CustomListeners.class)

public class LoginPageTest extends BaseTest {
    LoginPage loginPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        loginPage = new LoginPage();
    }

    @Test(groups = {"sanity", "regression"})
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        loginPage.loginToApplication("standard_user", "secret_sauce");
        // Verify the text “PRODUCTS"
        Assert.assertEquals(loginPage.getTextFromProductsTitle(),"Products","Error message");
}

      @Test(groups = {"smoke","regression"})
    public void verifyThatSixProductsAreDisplayedOnPage(){
        loginPage.loginToApplication("standard_user","secret_sauce");
        String expectedNumberOfProducts = "6";
        String actualNumberOfProducts = String.valueOf(loginPage.countProductOnList());
        Assert.assertEquals(actualNumberOfProducts,expectedNumberOfProducts,"total number of products are not displayed");


      }





}