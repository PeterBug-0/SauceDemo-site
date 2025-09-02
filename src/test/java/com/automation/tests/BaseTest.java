package com.automation.tests;

import com.automation.utils.DriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseTest {
    @BeforeMethod
    @Parameters("browser")
    public void setUp( String browser){
        System.out.println("Setting up test with browser: " + browser);
        DriverManager.setDriver(browser);
        DriverManager.getDriver().manage().window().maximize();
        DriverManager.getDriver().manage().deleteAllCookies();
    }

    @AfterMethod
    public void tearDown() {
        System.out.println("Cleaning up test...");
        DriverManager.quitDriver();
    }
}
