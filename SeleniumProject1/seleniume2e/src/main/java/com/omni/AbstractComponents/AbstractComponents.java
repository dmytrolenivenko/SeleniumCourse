package com.omni.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractComponents {

    WebDriver driver;
    WebDriverWait wait;

    public AbstractComponents(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(3));
    }

    public void waitForElementoToAppear(By findBy) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
    }

    public void waitForElementoToBeClickable(By findBy) {
        wait.until(ExpectedConditions.elementToBeClickable(findBy));
    }
    public void waitForElementoToDissapear(By findBy) {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(findBy));
    }
}