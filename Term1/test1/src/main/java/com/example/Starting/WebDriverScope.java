package com.example.Starting;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class WebDriverScope {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new EdgeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        //Lets change the scope of the driver
        WebElement footerLeft = driver.findElement(By.cssSelector("#gf-BIG > table > tbody > tr > td:nth-child(1) > ul"));
        //Lets count the links
        System.out.println(getLinks(driver));
        System.out.println(getLinks(footerLeft));
        //Lets initiate Actions
        Actions a = new Actions(driver);
        //Lets get those links and clic on them to Open in a New Tab
        for (int i = 0; i < getLinks(footerLeft); i++) {
            a.keyDown(Keys.CONTROL).click(footerLeft.findElements(By.tagName("a")).get(i)).build().perform();
        }
        //Lets iterate over tabs and get the Titles
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        for (int i = 0; i < tabs.size(); i++) {
            driver.switchTo().window(tabs.get(i));
            System.out.println("Tab " + i + " Titile - " + driver.getTitle());
        }

    }

    //Overloading :)
    public static int getLinks(WebElement driver) {
        return driver.findElements(By.tagName("a")).size();
    }

    public static int getLinks(WebDriver driver) {
        return driver.findElements(By.tagName("a")).size();
    }

}
