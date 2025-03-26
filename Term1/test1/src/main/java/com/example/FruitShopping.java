package com.example;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FruitShopping {
    public static void main(String[] args) {
        //Create WebDriver and Open Page
         WebDriver driver = new EdgeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/");
        //Our desired ShoppingList  
        List <String> shoppingList = Arrays.asList("Cucumber", "Brocolli", "Beetroot", "Carrot");
        //Applying ImplicitWait - Global waiting time until element appears
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        //Createing the ExplicitWait Object
        WebDriverWait exWait = new WebDriverWait(driver, Duration.ofSeconds(5)); 
        
        addItem(driver, shoppingList);
        checkout(driver, exWait);
        }
        //Method to add ShoppingList to the Cart
        public static void addItem (WebDriver driver, List <String> shoppingList) {

            //List of Existing Products
        List <WebElement> fruits = driver.findElements(By.cssSelector("h4.product-name"));
        int j = 0;
        for (int i = 0; i < fruits.size(); i++) {
            //for (String s : shoppingList) {
                //if (fruits.get(i).getText().contains(s)) {
                String[] name = (fruits.get(i).getText().split("-"));
                String formatedName = name[0].trim();
                if(shoppingList.contains(formatedName)) {
                    driver.findElements(By.cssSelector("div.product button")).get(i).click();
                    System.out.println(fruits.get(i).getText() + " Was Added to the Cart");
                    j++;
                    if (j == shoppingList.size()) {
                        break;
                    }
                }
            }
            System.out.println(j);
        }
        //Procceeding to CheckOut
        public static void checkout(WebDriver driver, WebDriverWait exWait) {
            driver.findElement(By.cssSelector("img[alt='Cart']")).click();
            driver.findElement(By.cssSelector("div[class*='cart-preview'] div[class='action-block'] button")).click();
            driver.findElement(By.cssSelector("input[placeholder='Enter promo code']")).sendKeys("rahulshettyacademy");
            driver.findElement(By.cssSelector("button[class='promoBtn']")).click();
            exWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("span[class='promo-btn-loader']")));
            driver.findElement(By.cssSelector("#root > div > div > div > div > button")).click();
            
        }


    }


