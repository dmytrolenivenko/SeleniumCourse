package com.example.Starting;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Assignment6 {

    public static void main(String[] args) throws InterruptedException {
        //Create WebDriver and Open Page
        WebDriver driver = new EdgeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        //Adding Implicit Wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        /*
         * Select Checkbox
         * Select an option in DoroDown
         * Enter the selectod DropDown into the Lable
         * Accept Alert and compare if the ooption is the same as in the first setep
         */
        //Click on the checkbox 3
        driver.findElement(By.id("checkBoxOption3")).click();
        //Extract text and store in variable
        String choosenOption = driver.findElement(By.cssSelector("label[for='honda']")).getText();
        System.out.println(choosenOption);
        //Working with Selet DropDown
        Select dropDown = new Select(driver.findElement(By.id("dropdown-class-example")));
        dropDown.selectByVisibleText(choosenOption);
        //Putting chosen Option into the Input
        driver.findElement(By.id("name")).sendKeys(choosenOption);
        driver.findElement(By.id("confirmbtn")).click();
        //Switching to Alert mode
        String alertText = driver.switchTo().alert().getText();
        System.out.println(alertText);
        driver.switchTo().alert().accept();
        
        String[] alertArray = alertText.split("[ ,]");
        for (int i = 0; i < alertArray.length-1; i++) {
            if (alertArray[i].contains(choosenOption)) {
                Assert.assertEquals(alertArray[i], choosenOption);
                System.out.println("Choosen Option is " + choosenOption);
            } 
        }


    }
}