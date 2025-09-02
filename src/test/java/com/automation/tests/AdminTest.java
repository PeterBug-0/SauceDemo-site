package com.automation.tests;

import com.automation.pages.AdminPage;
import com.automation.pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import com.automation.utils.DriverManager;
import org.testng.annotations.Test;



public class AdminTest extends BaseTest{
    private AdminPage  adminPage;
    private final String ADMIN_URL = "https://opensource-demo.orangehrmlive.com/web/index.php/admin/viewSystemUsers";

    @Test(priority = 1, description = "Verify admin can add a user")
    public void  testAddUser(){
        DriverManager.getDriver().get(ADMIN_URL);
        adminPage = new AdminPage(DriverManager.getDriver());

        //Actions when on admin page
        adminPage.getManageUser();
    }



}
