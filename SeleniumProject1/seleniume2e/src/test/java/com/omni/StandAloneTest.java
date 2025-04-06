package com.omni;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.omni.PageObjects.CatalogPage;
import com.omni.PageObjects.LandingPage;


public class StandAloneTest {

    static List<String> correctList = new ArrayList<>();

    public static void main(String[] args) {

        String email = "anshika@gmail.com";
        String password = "Iamking@000";
        String url = "https://rahulshettyacademy.com/client";
        String productName = "zara";
        String country = "Po";

        WebDriver driver = new EdgeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));

        
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        driver.manage().window().maximize();

        LandingPage landingPage = new LandingPage(driver);
        CatalogPage catalogPage = new CatalogPage(driver);
        
        landingPage.goTo(url);
        landingPage.login(email, password);
        catalogPage.getProductList();
        WebElement product = catalogPage.getProductByName(productName);
        System.out.println(product.getText());
        catalogPage.addToCart(product, productName);

    }


    public static void cartVerifier(WebDriver driver, List<String> correctList) {
        WebElement cartButton = driver.findElement(By.cssSelector("button[routerlink*='/dashboard/cart']"));
        cartButton.click();

        List<WebElement> cartList = driver.findElements(By.cssSelector("div[class='infoWrap'] h3"));
        List<String> cartListString = cartList.stream().map(s -> s.getText().toLowerCase()).collect(Collectors.toList());

        Assert.assertEquals(cartListString, correctList);
        System.out.println("All good");
    }

    public static void checkOut(WebDriver driver, String country) {
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 0);");
        driver.findElement(By.cssSelector("div[class='subtotal cf ng-star-inserted'] button")).click();
        WebElement selectCountry = driver.findElement(By.cssSelector("input[placeholder='Select Country']"));
        selectCountry.sendKeys(country);
        List <WebElement> countryList = driver.findElements(By.cssSelector("section[class='ta-results list-group ng-star-inserted'] button"));
        for (WebElement c : countryList) {
            if (c.getText().toLowerCase().contains(country)){
                c.click();
            }
        }
        driver.findElement(By.cssSelector("a[class='btnn action__submit ng-star-inserted']")).click();
    }

}
