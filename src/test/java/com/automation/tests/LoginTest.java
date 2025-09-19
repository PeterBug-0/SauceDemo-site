package com.automation.tests;

import com.automation.pages.LoginPage;
import com.automation.utils.ConfigReader;
import com.automation.utils.DriverManager;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Properties;

public class LoginTest extends BaseTest{

    Properties testConfigs = ConfigReader.loadProperties(System.getProperty("user.dir") + "/src/test/resources/configuration.properties");

    private LoginPage loginPage;

    // Test Data
    private final String BASE_URL = testConfigs.getProperty("BaseUrl");
    private final String Valid_username = testConfigs.getProperty("Valid_username");
    private final String Valid_password = testConfigs.getProperty("Valid_password");
    private final String Invalid_username = testConfigs.getProperty("Invalid_username");
    private final String Invalid_password = testConfigs.getProperty("Invalid_password");


    @Test(priority = 1, description = "Verify successful login with valid credentials")
    public void testSuccessfulLogin() {
        // Navigate to login page
        DriverManager.getDriver().get(BASE_URL);
        loginPage = new LoginPage(DriverManager.getDriver());

        // Verify login page is displayed
        Assert.assertTrue(loginPage.isLoginFormDisplayed());

        //Perform login
        loginPage.loginToApp(Valid_username, Valid_password);

        //wait for Dashboard to load  and verify successful login
        Assert.assertTrue(loginPage.isDashboardDisplayed(),"Dashboard is displayed after login");
        Assert.assertTrue(loginPage.isUserLoggedIn(),"User is logged in");
        Assert.assertTrue(loginPage.getCurrentUrl().contains("dashboard"),"URL should contain 'dashboard'");
    }

    @Test(priority = 2, description = "Verify login failure with invalid username")
    public void testInvalidUsername() {
        DriverManager.getDriver().get(BASE_URL);
        loginPage = new LoginPage(DriverManager.getDriver());

        // login with invalid username
        loginPage.loginToApp(Invalid_username,Valid_password);

        //Verify error message is displayed
        Assert.assertTrue(loginPage.isErrorMessageDisplayed(), "Error message should be displayed");
        Assert.assertFalse(loginPage.isDashboardDisplayed(), "Dashboard should not be displayed");
    }

    @Test(priority = 3, description = "Verify login failure with invalid password")
    public void testInvalidPassword() {
        DriverManager.getDriver().get(BASE_URL);
        loginPage = new LoginPage(DriverManager.getDriver());

        // login with invalid username
        loginPage.loginToApp(Valid_username,Invalid_password);

        // Also verify that error message is correct
        String actualErrorMsg = loginPage.getErrorMessage();

        //Verify error message is displayed
        Assert.assertTrue(loginPage.isErrorMessageDisplayed(), "Error message should be displayed");
        Assert.assertTrue(actualErrorMsg.contains("Epic sadface"), "Error message contains Epic sadface");
        Assert.assertFalse(loginPage.isDashboardDisplayed(), "Dashboard should not be displayed");
    }

    @Test(priority = 4, description = "Verify login failure with empty credentials")
    public void testEmptyCredentials() {
        DriverManager.getDriver().get(BASE_URL);
        loginPage = new LoginPage(DriverManager.getDriver());

        // login with invalid username
        loginPage.clickLoginBtn();

        //Verify 'required' text message is displayed under empty form fields
        Assert.assertTrue(loginPage.isRequiredTextDisplayed(), "Required text message should be displayed under empty fields");
        Assert.assertFalse(loginPage.isDashboardDisplayed(), "Dashboard should not be displayed");
    }

    @Test(priority = 5, description = "Verify individual field interactions")
    public void testFieldInteractions() {
        DriverManager.getDriver().get(BASE_URL);
        loginPage = new LoginPage(DriverManager.getDriver());

        // Test entering username
        loginPage.enterUsername(Valid_username);

        // Test entering password
        loginPage.enterPassword(Valid_password);

        // Verify form is still displayed before clicking login
        Assert.assertTrue(loginPage.isLoginFormDisplayed(), "Login form should still be displayed");

        // Click login button
        loginPage.clickLoginBtn();

        // Verify successful login
        Assert.assertTrue(loginPage.isDashboardDisplayed(), "Should be redirected to dashboard");
    }
}
