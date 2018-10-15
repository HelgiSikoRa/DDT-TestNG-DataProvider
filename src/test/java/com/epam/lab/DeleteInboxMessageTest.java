package com.epam.lab;

import com.epam.lab.businessobjects.InboxPageBO;
import com.epam.lab.businessobjects.LoginPageBO;
import com.epam.lab.utils.dataproviders.ExcelDataProviderClass;
import com.epam.lab.utils.parsers.ConfigFileReader;
import com.epam.lab.utils.WebDriverPool;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import org.testng.annotations.*;

public class DeleteInboxMessageTest {
    private ConfigFileReader configFileReader;

    @BeforeClass
    public void setupDriver() {
        configFileReader = new ConfigFileReader();
        System.setProperty("webdriver.chrome.driver", configFileReader.getDriverPath());
    }

    //When you will use CSV Data Provider to parse User data - uncomment next line
    //@Test(dataProvider = "csvDataProvider", dataProviderClass = CsvDataProviderClass.class)
    @Test(dataProvider = "ExcelDataProvider", dataProviderClass = ExcelDataProviderClass.class)
    public void deleteInboxMessage(String login, String password) {
        WebDriver driver = WebDriverPool.getDriver();
        driver.get(configFileReader.getWebSiteUrl());
        LoginPageBO loginPageBO = new LoginPageBO(driver);
        loginPageBO.loginToGmail(login, password);
        Assert.assertTrue(loginPageBO.checkLoginStatus());
    }

    @AfterMethod
    public void tearDown() {
        WebDriverPool.removeDriver();
    }
}