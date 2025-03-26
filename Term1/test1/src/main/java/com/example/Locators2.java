package com.example;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Locators2 {

    private static WebDriver driver;
    private static final String url = "https://rahulshettyacademy.com/AutomationPractice/";

    public static void main(String[] args) {

        startWebDriver();
       // driver.get(url);
        driver.navigate().to(url);
        /* System.out.println("Text on the button is " + 
            driver.findElement(By.xpath("//header/div/button[1]/following-sibling::button[1]")).getText().toUpperCase());
        System.out.println(driver.findElement(By.xpath("//header/div/button[3]/parent::div/button[2]")).getText()); */
        //closeWebDriver(driver);
        driver.navigate().to("https://www.google.com");
        driver.get("https://www.bing.com");
        driver.navigate().back();
        driver.navigate().forward();
        
    }
    public static void startWebDriver() {
        driver = new EdgeDriver();
    }

    public static void closeWebDriver(WebDriver driver) {
        if (driver != null) {
            driver.close();
        }
    }

    public static String getUrl() {
        return url;
    }

}
