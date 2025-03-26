package com.example;

import static java.time.Duration.ofSeconds;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;

public class Scroll {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new EdgeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.manage().timeouts().implicitlyWait(ofSeconds(1));
        //window.scrollby(0,500)
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");
        js.executeScript("document.querySelector('.tableFixHead').scrollTop=1000");
        List<WebElement> amount = driver.findElements(By.cssSelector("div[class='tableFixHead'] table[id='product'] tr td:nth-child(4)"));
        int sum = 0;
        for (int i = 0; i < amount.size(); i++) {
            int number = Integer.parseInt(amount.get(i).getText());
            sum += number;
        }

        String[] total = driver.findElement(By.cssSelector(".totalAmount")).getText().split("[: ]");
        Assert.assertEquals(Integer.parseInt(total[total.length - 1]), sum); 
        System.out.println(sum);

        List <WebElement> rows = driver.findElements(By.cssSelector("table[name='courses'] tr"));
        List <WebElement> columns = driver.findElements(By.cssSelector("table[name='courses'] th"));
        List <WebElement> secondCourse = driver.findElements(By.cssSelector(".left-align #product > tbody > tr:nth-child(3) > td"));
        System.out.println("Number of rows = " + rows.size());
        System.out.println("Number of columns = " + columns.size());
        String[] lables = {"Name: ", "Title: ", "Price:"};
        for(int i = 0; i < secondCourse.size(); i++) {
            System.out.println(lables[i] + secondCourse.get(i).getText());
        } 
        
        String country = "Emirates";
        String firstLetters = country.substring(0, 2);
        WebElement inputCountries = driver.findElement(By.cssSelector("#autocomplete"));
        inputCountries.click();
        inputCountries.sendKeys(firstLetters);
        Thread.sleep(500);
        List <WebElement> options = driver.findElements(By.cssSelector("#ui-id-1 li"));
        for(WebElement e : options) {
            if (e.getText().contains(country)) {
                e.click();
            }
            System.out.println(e.getText());
        }
    }
}
