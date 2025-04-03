package com.example.Starting;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class UserActions {

    public static void main(String[] args) throws InterruptedException {
       
        WebDriver driver = new EdgeDriver();
        driver.get("https://www.amazon.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));  
        Actions a = new Actions(driver);
        //Sign In Button
        WebElement singInBTN = driver.findElement(By.cssSelector("a#nav-link-accountList"));
        
        a.moveToElement(singInBTN).build().perform();
        a.moveToElement(driver.findElement(By.id("twotabsearchtextbox"))).click().build().perform();
        a.moveToElement(driver.findElement(By.id("twotabsearchtextbox"))).keyDown("ShiftLeft").sendKeys("hello world").build().perform();

        

        
    }

}
