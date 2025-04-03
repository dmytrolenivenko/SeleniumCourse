package com.example.Starting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Assignment2 {
    public static void main(String[] args) {
        WebDriver driver = new EdgeDriver();
        driver.get("https://rahulshettyacademy.com/angularpractice/");
        driver.findElement(By.cssSelector("form input[name='name']")).sendKeys("JimmyTheBoy");
        driver.findElement(By.cssSelector("form input[name='email']")).sendKeys("qwerty@gmail.com");
        driver.findElement(By.id("exampleInputPassword1")).sendKeys("1234567890");
        driver.findElement(By.id("exampleCheck1")).click();
        Select genders = new Select(driver.findElement(By.id("exampleFormControlSelect1")));
        genders.selectByContainsVisibleText("Male");
        driver.findElement(By.id("inlineRadio1")).click();
        driver.findElement(By.cssSelector("input[type='date']")).sendKeys("11/11/2000");
        driver.findElement(By.className("btn-success")).click();
        String successPhrase = driver.findElement(By.className("alert-success")).getText();
        String success = successPhrase.substring(2, successPhrase.indexOf("!"));
        Assert.assertEquals(success, "Success");
        driver.findElement(By.className("close")).click();


    }

}
