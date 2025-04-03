package com.example.JavaStreams;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class Windows {

    public static void main(String[] args) throws IOException {

        WebDriver driver = new EdgeDriver();
        driver.get("https://rahulshettyacademy.com/angularpractice");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        Map<String, String> handleMap = new HashMap<>();
        driver.switchTo().newWindow(WindowType.TAB);
        List<String> handles = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(handles.get(0));
        //Lets take a screenshot
        WebElement nameInput = driver.findElement(By.cssSelector(" div:nth-child(1) > input"));
        nameInput.sendKeys("hello world");
        File scrFile = nameInput.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("NameInput.png"));
        nameInput.getRect().getHeight();
        nameInput.getRect().getDimension().getHeight();
        nameInput.getRect().getWidth();

        //driver.quit();
    }

    @Test
    public void getHandles() {
        WebDriver driver = new EdgeDriver();
        Map<String, String> handleMap = new HashMap<>();
        List<String> handles = new ArrayList<>(driver.getWindowHandles());
        for (String handle : handles) {
            driver.switchTo().window(handle);
            handleMap.put(handle, driver.getTitle());
        }
        driver.quit();
    }

}
