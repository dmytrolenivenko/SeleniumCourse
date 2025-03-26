package com.example;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Assignment5 {
    public static void main(String[] args) throws InterruptedException {
         //Create WebDriver and Open Page
        WebDriver driver = new EdgeDriver();
        //Implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        //Open Main Page
        driver.get("https://the-internet.herokuapp.com/nested_frames");
        //Choosing Frames
        //driver.findElement(By.cssSelector("[href='/frames']")).click();
        //Choosing Nested Frames
        //driver.findElement(By.cssSelector("[href^='/nested']")).click();
        //Lets try to switch to Main Frame and then to Middle one
        driver.switchTo().frame("frame-top").switchTo().frame("frame-middle");
        System.out.println(driver.findElement(By.id("content")).getText());
        driver.switchTo().defaultContent();

    }
}
