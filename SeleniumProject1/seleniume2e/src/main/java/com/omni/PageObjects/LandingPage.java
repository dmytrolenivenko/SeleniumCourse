package com.omni.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.omni.AbstractComponents.AbstractComponents;

public class LandingPage extends AbstractComponents {

    WebDriver driver;

    public LandingPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    /* WebElement userEmail = driver.findElement(By.id("userEmail"));
        WebElement userPassword = driver.findElement(By.id("userPassword"));
        WebElement loginButton = driver.findElement(By.id("login"));
        userEmail.sendKeys("anshika@gmail.com");
        userPassword.sendKeys("Iamking@000");
        loginButton.click(); */

    @FindBy(id = "userEmail")
    WebElement userEmail;

    @FindBy(id = "userPassword")
    WebElement userPassword;

    @FindBy(id = "login")
    WebElement loginBtn;

    public void login(String email, String password) {
        userEmail.sendKeys(email);
        userPassword.sendKeys(password);
        loginBtn.click();
    }

    public void goTo(String url) {
        driver.get(url);
    }

}
