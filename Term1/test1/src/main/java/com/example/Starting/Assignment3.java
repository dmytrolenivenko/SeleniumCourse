package com.example.Starting;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignment3 {

    public static void main(String[] args) {

        //Create WebDriver and Open Page
        WebDriver driver = new EdgeDriver();
        driver.get("https://rahulshettyacademy.com/loginpagePractise/");
        //Applying ImplicitWait - Global waiting time until element appears
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        //Createing the ExplicitWait Object
        WebDriverWait exWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        //FullScreen. Comment to TurnOff
        driver.manage().window().fullscreen();

        login(driver);
        insertProducts(driver, exWait);

    }

    //Method for Login and Submit
    public static void login(WebDriver driver) {
        //Lets extract UserName and Password
        String username = driver.findElement(By.cssSelector("div.form-group p b:nth-of-type(1)")).getText();
        String password = driver.findElement(By.cssSelector("div.form-group p b:nth-of-type(2)")).getText();
        //Lets put credentials into fields. Username and Password
        driver.findElement(By.cssSelector("input#username")).sendKeys(username);
        driver.findElement(By.cssSelector("input#password")).sendKeys(password);
        //Radio Button
        driver.findElement(By.cssSelector("#login-form > div:nth-child(4) > div > label:nth-child(1) > span.checkmark")).click();
        //Select Static DropDown
        WebElement dropDown = driver.findElement(By.cssSelector("select.form-control"));
        Select select = new Select(dropDown);
        select.selectByValue("consult");
        select.selectByIndex(1);
        //Check Button
        driver.findElement(By.cssSelector("input[type=\'checkbox\']")).click();
        //SignIn Button
        driver.findElement(By.cssSelector("input#signInBtn")).click();
    }
    //Method to insert all avaliable products in the Cart
    public static void insertProducts(WebDriver driver, WebDriverWait exWait) {
        //Appy ExplicitWait
        exWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("app-card-list.row")));
        //Extract all avaliable elements
        List<WebElement> productList = driver.findElements(By.cssSelector("app-card-list.row app-card"));
        System.out.println(productList);
        //For loop to click on every element
        for (int i = 0; i < productList.size(); i++) {
            productList.get(i).findElement(By.cssSelector("div.card-footer button.btn")).click();
        }
        driver.findElement(By.cssSelector("#navbarResponsive > ul > li > a")).click();
    }

}
