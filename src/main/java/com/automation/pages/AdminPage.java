package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class AdminPage extends BasePage{
    private final By userManagementElement = By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[2]/nav/ul/li[1]");
    By userRole = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[1]/div/div[2]/div/div/div[1]");

    private final By jobElement = By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[2]/nav/ul/li[2]");
    private final By organizationElement = By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[2]/nav/ul/li[3]/span");
    private final By qualificationElement = By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[2]/nav/ul/li[4]/span");
    private final By nationalitiesElement = By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[2]/nav/ul/li[5]");
    private final By corporateBrandingElement = By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[2]/nav/ul/li[6]");
    private final By configurationElement = By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[2]/nav/ul/li[7]");
    private final By addButton = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[1]/button");

    // Elements to verify Admin dashboard is correct
    private final By adminDashboardHeader = By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[1]/span");

    public AdminPage(WebDriver driver) {
        super(driver);
    }

    public void getManageUser(){
        click(userManagementElement);
        click(addButton);

    }

    public boolean isAdminisplayed(){
        return isDisplayed(adminDashboardHeader);
    }
}
