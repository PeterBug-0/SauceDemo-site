package com.automation.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class JavaScriptUtility {
    public static void scrollToElementJS(By locator){
        WebElement element = DriverManager.getDriver().findElement(locator);
        String jsScript = "arguments[0].scrollIntoView();";
        ((JavascriptExecutor)DriverManager.getDriver()).executeScript(jsScript, element);
    }

    public static void clickJS(By locator){
        WebElement element =DriverManager.getDriver().findElement(locator);
        JavascriptExecutor executor = (JavascriptExecutor) DriverManager.getDriver();
        executor.executeScript("arguments[0].click();", element);
    }
}
