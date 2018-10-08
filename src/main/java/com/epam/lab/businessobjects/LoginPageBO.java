package com.epam.lab.businessobjects;

import com.epam.lab.pageobject.LoginPage;
import org.openqa.selenium.WebDriver;

public class LoginPageBO {
    private LoginPage loginPage;

    public LoginPageBO(WebDriver driver) {
        loginPage = new LoginPage(driver);
    }

    public void loginToGmail(String userName, String password) {
        loginPage.enterUserName(userName)
                .submitUserName()
                .enterPassword(password)
                .submitPassword();
    }
}