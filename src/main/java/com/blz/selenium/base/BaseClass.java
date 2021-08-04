package com.blz.selenium.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

public class BaseClass {
    public static WebDriver driver;

    @Feature("BrowserName and url for starting test")
    @Description("Used setUp method for setting the browser")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Navigating to url : https://www.irctc.co.in/nget/train-search")
    @BeforeTest
    public void setUp() {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);

        driver.manage().window().maximize();
        driver.get("http://www.nammregister.org.uk/test.asp");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);

    }

   @AfterTest
    public void tearDown() {
        driver.close();
    }
}

