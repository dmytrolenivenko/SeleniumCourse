package com.omni;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;

import com.omni.PageObjects.CatalogPage;
import com.omni.PageObjects.CheckOutPage;
import com.omni.PageObjects.ConfirmationPage;
import com.omni.PageObjects.LandingPage;
import com.omni.PageObjects.ShoppingCart;


public class StandAloneTest {

    public static void main(String[] args) {

        String email = "anshika@gmail.com";
        String password = "Iamking@000";
        String url = "https://rahulshettyacademy.com/client";
        String productName = "ZARA COAT 3";
        String country = "Por";
        String heroMessage = "Thankyou for the order.";

        WebDriver driver = new EdgeDriver();
        
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        driver.manage().window().maximize();

        LandingPage landingPage = new LandingPage(driver);
        //CatalogPage catalogPage = new CatalogPage(driver); - IS THIS REALLY BETTER WAY TO WORK???
        ShoppingCart shoppingCart = new ShoppingCart(driver);
        CheckOutPage checkOutPage = new CheckOutPage(driver);
        ConfirmationPage confirmationPage = new ConfirmationPage(driver);

        landingPage.goTo(url);
        CatalogPage catalogPage = landingPage.login(email, password);
        catalogPage.getProductList();
        catalogPage.addToCart(productName);
        shoppingCart.goToCart();
        Assert.assertTrue(shoppingCart.cartVerifyProducts(productName));
        shoppingCart.checkOutButtonClick();
        checkOutPage.checkOut(country);
        checkOutPage.placeOrderClick();
        Assert.assertEquals(confirmationPage.getHeroMessage().toLowerCase(), heroMessage.toLowerCase());

    }
}
