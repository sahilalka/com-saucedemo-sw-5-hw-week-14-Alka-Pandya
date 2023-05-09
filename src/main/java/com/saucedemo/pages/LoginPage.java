package com.saucedemo.pages;

import com.aventstack.extentreports.Status;
import com.saucedemo.customlisteners.CustomListeners;
import com.saucedemo.utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import java.util.List;

public class LoginPage extends Utility {

    @CacheLookup
    @FindBy(id = "user-name")
    WebElement userNameField;
    @CacheLookup
    @FindBy(name = "password")
    WebElement passwordField;
    @CacheLookup
    @FindBy(xpath = "//input[@id='login-button']")
    WebElement loginButton;
    @CacheLookup
    @FindBy(xpath = "//span[contains(text(),'Products')]")
    WebElement productsText;
    @CacheLookup
    @FindBy(xpath = "//div[@class='inventory_list']//div//div//div[@class='inventory_item_name']")
    WebElement numberOfProducts;


    public void enterUserName(String userName) {
        Reporter.log("Enter username " + userName + " to username field " + userNameField.toString());
        CustomListeners.test.log(Status.PASS, "Enter username " + userName);
        sendTextToElement(userNameField, userName);
    }

    public void enterPassword(String password) {
        Reporter.log("Enter password " + password + " to password field " + passwordField.toString());
        CustomListeners.test.log(Status.PASS, "Enter password " + password);
        sendTextToElement(passwordField, password);
    }

    public void clickOnLoginButton() {
        Reporter.log("Clicking on Login Button " + loginButton.toString());
        CustomListeners.test.log(Status.PASS, "Click on loginButton");
        clickOnElement(loginButton);
    }

    public void loginToApplication(String username, String password) {
        enterUserName(username);
        enterPassword(password);
        clickOnLoginButton();
    }

    public String getTextFromProductsTitle() {
        Reporter.log("Get text from products title" );
        CustomListeners.test.log(Status.PASS, "Get text from products text");
        return getTextFromElement(productsText);
    }

    public int countProductOnList() {
        Reporter.log("Count total number of products");
        CustomListeners.test.log(Status.PASS, "Get error message");
        List<WebElement>productsList = driver.findElements(By.xpath("//div[@class='inventory_list']//div//div//div[@class='inventory_item_name']"));
        return productsList.size();

    }


}