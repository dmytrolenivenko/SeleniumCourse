package com.example;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Assignment4 {

    public static void main(String[] args) throws InterruptedException {
         //Create WebDriver and Open Page
        WebDriver driver = new EdgeDriver();
        //Implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        //Open Main Page
        driver.get("https://the-internet.herokuapp.com/");
        //Click on the Multiple Windows
        driver.findElement(By.cssSelector("a[href='/windows']")).click();
        //Click on the Click Here
        driver.findElement(By.cssSelector("a[href='/windows/new']")).click();
        Thread.sleep(1000);
        //Collect opened Tabs
        List <String> tabsArr = new ArrayList<>(driver.getWindowHandles());
        //Create Hash Map
        Map <String, String> tabs = new HashMap<>();
        //Put Tabs into Hash
        tabs.put("Main", tabsArr.get(0));
        tabs.put("New", tabsArr.get(1));
        //Switching few times
       /*  driver.switchTo().window(tabs.get("Main"));
        driver.switchTo().window(tabs.get("New"));
        driver.switchTo().window(tabs.get("Main")); */
        driver.switchTo().window(tabs.get("New"));
        //Extract Text from the New Tab
        System.out.println(driver.findElement(By.cssSelector("div.example")).getText());
        //Switching to the Main Tab
        driver.switchTo().window(tabs.get("Main"));
        //Extracting Text
        System.out.println(driver.findElement(By.cssSelector("div > h3")).getText());
         



    }
}
