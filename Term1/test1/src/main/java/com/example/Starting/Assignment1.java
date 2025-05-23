package com.example.Starting;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;

public class Assignment1 {

    public static void main(String[] args) throws IOException {
        WebDriver driver = new EdgeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        List<WebElement> checkBoxes = driver.findElements(By.cssSelector("div[id='checkbox-example'] input"));

        if (checkBoxes.get(0).isSelected() == false) {
            checkBoxes.get(0).click();
        }
        Assert.assertTrue(checkBoxes.get(0).isSelected());
        checkBoxes.get(0).click();
        Assert.assertFalse(checkBoxes.get(0).isSelected());
        checkBoxes.size();

        
    }


    //Taking Screenshot method
    public static void takeScrenshot(WebDriver driver) {
        //Casting driver into Screenshot taker and saying to output as a File
        File scr = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            //Saving screenshot as a file
            FileUtils.copyFile(scr, new File("C:\\\\Users\\\\dmytro.lenivenko\\\\Downloads\\\\Screens\\Screen1.png"));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Something went wrong");
        }
    }

}
