package com.example;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;

public class Calendar {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new EdgeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

        String day = "8";
        String month = "5";
        String year = "1998";
        String[] dateOriginal = {month, day, year};

        dateChoice(driver, month, day, year);

        String dateMonth = driver.findElement(By.className("react-date-picker__inputGroup__month")).getDomAttribute("value");
        String dateDay = driver.findElement(By.className("react-date-picker__inputGroup__day")).getDomAttribute("value");
        String dateYear = driver.findElement(By.className("react-date-picker__inputGroup__year")).getDomAttribute("value");
        String[] dateNew = {dateMonth, dateDay, dateYear};
        for (int i = 0; i < dateOriginal.length; i++) {
            Assert.assertEquals(dateOriginal[i], dateNew[i]);
            System.out.println("Dates are the same");
        }
        
    }

    public static void dateChoice(WebDriver driver, String month, String day, String year) {
        //Calendar place holder. Year part
        WebElement calendarHolder = driver.findElement(By.cssSelector("input[class='react-date-picker__inputGroup__input react-date-picker__inputGroup__year']"));
        calendarHolder.click();
        //Year Holder
        WebElement yearHolder = driver.findElement(By.cssSelector(".react-calendar__navigation__label"));
        yearHolder.click();
        yearHolder.click();
        //Decade less
        WebElement previousDecade = driver.findElement(By.cssSelector(".react-calendar__navigation__prev-button"));
        //Decade More
        WebElement nextDecade = driver.findElement(By.cssSelector(".react-calendar__navigation__next-button"));
        //While true, letf search for the right decade

        try {
            while (true) {
                if (Integer.parseInt(day) < 1 | Integer.parseInt(day) > 31 | Integer.parseInt(month) < 0 | Integer.parseInt(month) > 12 | Integer.parseInt(year) < 1500) {
                    if (Integer.parseInt(day) < 1 | Integer.parseInt(month) < 0 | Integer.parseInt(month) > 12 | Integer.parseInt(year) > 2500) {
                        System.out.println("Your date is out of range");
                        break;
                    }
                }
                List<WebElement> years = driver.findElements(By.cssSelector(".react-calendar__decade-view__years button"));
                String firstYear = years.get(0).getText();
                String lastYear = years.get(years.size() - 1).getText();
                if (Integer.parseInt(year) < Integer.parseInt(firstYear)) {
                    previousDecade.click();
                } else if (Integer.parseInt(year) > Integer.parseInt(lastYear)) {
                    nextDecade.click();
                } else {
                    for (int i = 0; i < years.size(); i++) {
                        String currentYear = years.get(i).getText();
                        if (year.equals(currentYear)) {
                            years.get(i).click();
                            break;
                        }
                    }
                    break;
                }
            }
            //Lets choose the right month by Index
            List<WebElement> months = driver.findElements(By.cssSelector(".react-calendar__year-view__months button abbr"));
            for (int i = 0; i < months.size() - 1; i++) {
                if (i == (Integer.parseInt(month))) {
                    months.get(i - 1).click();
                }
            }
            //Lets choose right day by text
            List<WebElement> days = driver.findElements(By.cssSelector(".react-calendar__month-view__days button abbr"));
            for (WebElement d : days) {
                if (d.getText().equals(day)) {
                    d.click();
                }
            }
        } catch (Exception e) {
            System.out.println("Your date is invalid");
        }

    }

}
