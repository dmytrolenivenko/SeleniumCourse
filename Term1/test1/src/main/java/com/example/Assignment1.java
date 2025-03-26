package com.example;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;

public class Assignment1 {
    public static void main(String[] args) {
        WebDriver driver = new EdgeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        List <WebElement> checkBoxes = driver.findElements(By.cssSelector("div[id='checkbox-example'] input"));
        if (checkBoxes.get(0).isSelected() == false) {
            checkBoxes.get(0).click();
        }
        Assert.assertTrue(checkBoxes.get(0).isSelected());
        checkBoxes.get(0).click();
        Assert.assertFalse(checkBoxes.get(0).isSelected());
        checkBoxes.size();
    }

}
