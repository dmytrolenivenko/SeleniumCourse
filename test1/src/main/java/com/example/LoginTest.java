package com.example;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;

public class LoginTest {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new EdgeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        //Login
        driver.findElement(By.id("inputUsername")).sendKeys(FortTesting.getLogin());
        //Password
        driver.findElement(By.name("inputPassword")).sendKeys(FortTesting.getPassword());
        //Agreement check box
        driver.findElement(By.cssSelector("input#chkboxOne")).click();
        //Remember me check box
        driver.findElement(By.xpath("//input[@id='chkboxTwo']")).click();
        //Singin button
        driver.findElement(By.className("signInBtn")).click();
        Thread.sleep(500);
        //Confirmation text find and print
        driver.findElement(By.xpath("//div/p")).getText();
        Thread.sleep(1000);
        System.out.println(driver.findElement(By.xpath("//div/p")).getText());
        //Verify if its actually what we are expecting
        Assert.assertEquals(driver.findElement(By.xpath("//div/p")).getText(), "You are successfully logged in.", "***Fuck you!***");
        System.out.println("Login message test = PASS.");
    }

    
}
