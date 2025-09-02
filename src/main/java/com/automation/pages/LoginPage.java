package com.automation.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {
    // Page Elements (Locators)
    private final By usernameField = By.name("username");
    private final By passwordField = By.name("password");
    private final By loginButton = By.xpath("//button[@type='submit']");
    private final By errorMessage = By.xpath("//div[@class='oxd-alert-content oxd-alert-content--error']");
    private final By loginForm = By.xpath("//form[@class='oxd-form']");
    private final By forgotPasswordLink = By.xpath("//p[@class='oxd-text oxd-text--p orangehrm-login-forgot-header']");
    private final By requiredField = By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/span");

    //Dashboard Elements to verify successful login
    private final By dashboardHeader = By.xpath("//h6[text()='Dashboard']");
    private final By userDropdown = By.xpath("//p[@class='oxd-userdropdown-name']");

    // Constructor goes here
    public LoginPage (WebDriver driver){
        super(driver);
    }

    // Actions on the page
    public void enterUsername (String username){
        type(usernameField,username);
    }
    public void enterPassword (String password){
        type(passwordField,password);
    }
    public void clickLoginBtn (){
        click(loginButton);
    }
    public void loginToApp(String username, String password){
        enterUsername(username);
        enterPassword(password);
        clickLoginBtn();
    }
    // Verification Methods
    public boolean isLoginFormDisplayed() {
        return isDisplayed(loginForm);
    }

    public boolean isDashboardDisplayed() {
        try {
            return find(dashboardHeader).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isErrorMessageDisplayed() {
        return isDisplayed(errorMessage);
    }

    public String getErrorMessage() {
        if (isErrorMessageDisplayed()) {
            return getText(errorMessage);
        }
        return "";
    }

    public boolean isRequiredTextDisplayed() {
        return isDisplayed(requiredField);
    }

    public String getRequiredText() {
        if (isRequiredTextDisplayed()) {
            return getText(errorMessage);
        }
        return "";
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public boolean isUserLoggedIn() {
        return isDisplayed(userDropdown);
    }

    public void clickForgotPassword() {
        click(forgotPasswordLink);
    }
}