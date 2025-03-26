package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;


public class PopUps {
    public static void main(String[] args) {
        WebDriver driver = new EdgeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        //1st go
        driver.findElement(By.id("name")).sendKeys("Dmitry"); //Send Keys to Name
        driver.findElement(By.id("alertbtn")).click(); //Click on Alert
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();
        //2nd go
        driver.findElement(By.id("name")).sendKeys("Dmitry"); //Send Keys to Name
        driver.findElement(By.id("confirmbtn")).click(); //Click on Alert
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().dismiss();

        

    }

}
