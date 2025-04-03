package com.omni;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StandAloneTest {

    public static void main(String[] args) {

        WebDriver driver = new EdgeDriver();
        driver.get("https://rahulshettyacademy.com/client");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        driver.manage().window().maximize();

        WebElement userEmail = driver.findElement(By.id("userEmail"));
        WebElement userPassword = driver.findElement(By.id("userPassword"));
        WebElement loginButton = driver.findElement(By.id("login"));
        userEmail.sendKeys("anshika@gmail.com");
        userPassword.sendKeys("Iamking@000");
        loginButton.click();

        List<String> shoppingList = new ArrayList<>(Arrays.asList("zara", "adidas", "iphone", "qwerty"));
        //List <WebElement> allProducts = collectedProducts(driver);
        //products.forEach(s -> System.out.println(s.getText()));
        List <WebElement> productList = collectedProducts(driver);
        addToCart(driver, shoppingList, productList);

    }

    public static List<WebElement> collectedProducts(WebDriver driver) {
        WebElement nextButton;
        List<WebElement> products = new ArrayList<>();
        do {
            nextButton = driver.findElement(By.cssSelector(".pagination-next"));
            List<WebElement> currentProducts = driver.findElements(By.cssSelector("div[class*='col-lg-4']"));
            for (WebElement e : currentProducts) {
                products.add(e);
            }
            if (nextButton.getDomAttribute("class").contains("enabled")) {
                nextButton.click();
            } else {
                break;
            }
        } while (nextButton.getDomAttribute("class").contains("enabled"));
        return products;
    }

    public static void addToCart(WebDriver driver, List<String> shoppingList, List<WebElement> products) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        for (WebElement product : products) {
            String name = product.getText().toLowerCase();

            for (String item : shoppingList) {
                if (name.contains(item)) {
                    WebElement buttonAdd = product.findElement(By.cssSelector("button[class='btn w-10 rounded']"));
                    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div[class='ngx-spinner-overlay ng-tns-c31-1 ng-trigger ng-trigger-fadeIn ng-star-inserted']")));
                    wait.until(ExpectedConditions.elementToBeClickable(buttonAdd));
                    try {
                        buttonAdd.click();
                    } catch (ElementClickInterceptedException e) {
                        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", buttonAdd);
                        buttonAdd.click();
                    }
                }
            }
        }
    }
}
