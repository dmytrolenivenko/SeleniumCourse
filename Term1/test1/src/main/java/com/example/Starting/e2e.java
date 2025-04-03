package com.example.Starting;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class e2e {

    public static void main(String[] args) throws InterruptedException {
        
        WebDriver driver = new EdgeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.manage().window().fullscreen();
        Thread.sleep(500);

        WebElement staticDropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
        Select dropDown = new Select(staticDropdown);
        dropDown.selectByIndex(1);
        System.out.println(dropDown.getFirstSelectedOption().getText());
        dropDown.selectByValue("AED");
        System.out.println(dropDown.getFirstSelectedOption().getText());
        dropDown.selectByVisibleText("USD");
        System.out.println(dropDown.getFirstSelectedOption().getText()); 

        
        driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
        driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("//a[@value='AIP']")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("//div[@id='ctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='BHO']")).click();
        Thread.sleep(500);
        driver.findElement(By.cssSelector(" div.ui-datepicker-group.ui-datepicker-group-first > table > tbody > tr:nth-child(2) > td:nth-child(6) > a")).click();
        Thread.sleep(500);
        driver.findElement(By.cssSelector("div[id='Div1'] button[class='ui-datepicker-trigger']")).click();

        driver.findElement(By.cssSelector("div.ui-datepicker-group.ui-datepicker-group-last  table  tbody > tr:nth-child(2) > td:nth-child(1) > a")).click();

        driver.findElement(By.id("autosuggest")).sendKeys("Po");
        Thread.sleep(1000);
        List <WebElement> options = driver.findElements(By.cssSelector("ul[id='ui-id-1'] li a"));
        for (WebElement option : options) {
            System.out.println(option.getText());
            if (option.getText().equalsIgnoreCase("Portugal")) {
                option.click();
                break;
            }
            } 
            List <WebElement> checkBoxes = driver.findElements(By.cssSelector("input[type*='checkbox']"));
           int counter = 0;
           for (WebElement checkBox : checkBoxes) {
            try {
                if (checkBox.isDisplayed()) {
                checkBox.click();
                counter++;
                }
            } catch (Exception e) {
                System.out.println("Not Clickable");
            }
           }
           System.out.println("Total checkboxes are = " + counter);
           //Check if checkbox is selected - TRUE
           Assert.assertTrue(driver.findElement(By.cssSelector("div div input[id*='Unmr']")).isSelected());
           Assert.assertEquals(driver.findElement(By.cssSelector("div label[for='ctl00_mainContent_chk_Unmr']")).getText(), "Unaccompanied Minor");
           //Expected text = Unaccompanied Minor 
           Thread.sleep(500);
           driver.findElement(By.id("ctl00_mainContent_chk_Unmr")).click();

           driver.findElement(By.id("divpaxinfo")).click();
           Thread.sleep(1000);
       int p = 7; //How many Adults(9 MAX)
       for (int i = p; i > 1; i--) {
           driver.findElement(By.id("hrefIncAdt")).click();
           System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
       }
       int c = 2; // How many kids(2 MAX)
       for (int i = c; i > 0; i--) {
           driver.findElement(By.id("hrefIncChd")).click();
           System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
       }
       int in = 4; // How many infants(4 MAX)
       for (int i = in; i > 0; i--) {
           driver.findElement(By.id("hrefIncInf")).click();
           System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
       }
       driver.findElement(By.id("btnclosepaxoption")).click(); 
           driver.findElement(By.id("ctl00_mainContent_btn_FindFlights")).click();
        }
    }
