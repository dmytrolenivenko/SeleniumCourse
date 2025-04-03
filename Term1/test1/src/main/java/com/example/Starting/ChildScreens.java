package com.example.Starting;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class ChildScreens {

    public static void main(String[] args) throws InterruptedException {
         //Create WebDriver and Open Page
        WebDriver driver = new EdgeDriver();
        driver.get("https://rahulshettyacademy.com/loginpagePractise/");
        driver.findElement(By.cssSelector("a.blinkingText")).click();
        //Creating A HashMap to store Tabs
        Map <String, String> tabs = new HashMap<>();
        //Getting Tabs
        List <String> windows = new ArrayList<>(driver.getWindowHandles());
        //Putitng Tabs into Map
        tabs.put("main", windows.get(0));
        tabs.put("email", windows.get(1));
        //Switching between Tabs
        driver.switchTo().window(tabs.get("main"));
        Thread.sleep(1000);
        driver.switchTo().window(tabs.get("email"));
        Thread.sleep(1000);
        driver.switchTo().window(tabs.get("main"));
        Thread.sleep(1000);
        driver.switchTo().window(tabs.get("email"));
        Thread.sleep(1000);
        System.out.println(driver.findElement(By.cssSelector("a[href='mailto:mentor@rahulshettyacademy.com']")).getText());
        




    }

}
