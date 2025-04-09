package com.omni;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;

import com.omni.PageObjects.LandingPage;

public class BaseTest {
    LandingPage landingPage;
    WebDriver driver;

    public WebDriver initializeDriver() {
        driver = new EdgeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.manage().window().maximize();
        return driver;
    }

    public LandingPage launchApplication() {
        driver = initializeDriver();
        landingPage = new LandingPage(driver);
        landingPage.goTo();
        return landingPage;
    }

    @AfterMethod
    public void closeDriver() {
        driver.close();
    }

}
