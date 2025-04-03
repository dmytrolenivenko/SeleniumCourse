package com.example.Starting;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Locators1 {

    private static String password = "rahulshettyacademy";
    private static final String login = "Jimmy Boy";
        public static void main(String[] args) throws InterruptedException {
            WebDriver driver = new EdgeDriver();
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            driver.get("https://rahulshettyacademy.com/locatorspractice/");
            driver.findElement(By.id("inputUsername")).sendKeys(login);
            driver.findElement(By.name("inputPassword")).sendKeys("Wrong Password");
            driver.findElement(By.className("signInBtn")).click();
            System.out.println(driver.findElement(By.cssSelector("p.error")).getText());
            driver.findElement(By.linkText("Forgot your password?")).click();
            driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("Jimmy");
            driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("Email@email.com");
            driver.findElement(By.xpath("//input[@type='text'][2]")).clear();
            driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("Emails@emials.com");
            driver.findElement(By.xpath("//form/input[3]")).sendKeys("007123");
    
             // Explicit wait
            //Thread.sleep(1000);
            wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.reset-pwd-btn"))).click();
    
            driver.findElement(By.cssSelector("button.reset-pwd-btn")).click();
            String message = driver.findElement(By.cssSelector("form p")).getText();
            String[] passwordBad = message.split("'");
            password = passwordBad[1];
        System.out.println(password);
        driver.findElement(By.xpath("//div[contains(@class, 'pwd')]/button[1]")).click();
        driver.findElement(By.cssSelector("input#inputUsername")).sendKeys("JimmyBoy");

        //Using * is regular expression. Will Scan ALL types for word "PASS"
        driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys(password);
        Thread.sleep(500);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input#chkboxOne"))).click();
        driver.findElement(By.cssSelector("input#chkboxTwo")).click();

        //In xPath this is thhe syntax for *. Method tag + [contains(@attribute, 'value)'']"
        driver.findElement(By.xpath("//button[contains(@class, 'submit')]")).click();

    }

    public static String getPassword() {
        return password;
    }

    public static String getLogin() {
        return login;
    }

}
