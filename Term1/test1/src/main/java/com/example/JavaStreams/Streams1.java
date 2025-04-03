package com.example.JavaStreams;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;

public class Streams1 {

    public static void main(String[] args) {

        /* List<String> names = new ArrayList<>(Arrays.asList("Aeona", "Trent", "Marisol", "Jarek", "Elodie", 
                                                                "Branson", "Anyra", "Davin", "Callista", "Orin"));        
        //names.stream().filter(n -> n.toLowerCase().startsWith("a")).forEach(n -> System.out.println(n));

        List <String> reverseNames = new ArrayList<>(names);
        Collections.reverse(reverseNames);

        //names.stream().filter(n -> n.length() == 5).limit(5).forEach(n -> System.out.println(n));
        //names.stream().filter(n -> n.length() > 5).limit(5).map(n -> n.toUpperCase()).sorted().forEach(n -> System.out.println(n));
        
        Stream <String> newStream = Stream.concat(names.stream(), reverseNames.stream());
        //newStream.filter(n -> n.toLowerCase().startsWith("a") || n.toLowerCase().startsWith("d")).sorted().limit(10).forEach(n -> System.out.println(n));
        /* boolean flag = newStream.anyMatch(n -> n.equalsIgnoreCase("aeona"));
        Assert.assertTrue(flag);
        System.out.println(flag); */
        //List <String> smallList = newStream.filter(n -> n.contains("a")).collect(Collectors.toList()).reversed();
        //smallList.stream().filter(n -> n.toLowerCase().startsWith("a")).sorted().limit(5).forEach(n -> System.out.println(n)); */
        WebDriver driver = new EdgeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        /*  List <WebElement> elementsList = driver.findElements(By.cssSelector(".table-bordered tbody tr td:nth-child(1)"));
        List <String> unsortedList = elementsList.stream().map(s -> s.getText()).collect(Collectors.toList());
        List <String> sortedList = unsortedList.stream().sorted().collect(Collectors.toList());
        Assert.assertFalse(unsortedList.equals(sortedList));
        System.out.println("Lits are not the same");
        List <String> price = elementsList.stream().filter(s -> s.getText().equalsIgnoreCase("rice")).map(s -> getPrice(s)).collect(Collectors.toList());
        price.forEach(s -> System.out.println(s));
        elementsList.stream().map(s -> s.getText() + " = " + getPrice(s)).forEach(s -> System.out.println(s));
        //price.forEach(s -> System.out.println(s));
        Map <String, String> mapElements = elementsList.stream().collect(Collectors.toMap(s -> s.getText(), s -> getPrice(s)));
        mapElements.forEach((product, cost) -> System.out.println(product + " = " + cost));
         */
        //Sorting
        driver.findElement(By.cssSelector("th[aria-label='Veg/fruit name: activate to sort column ascending']")).click();
        List<WebElement> fruitsList;
        List<String> fruitPrice;
        String[] fruits = {"Rice", "Carrot", "Apple"};
        do {
            //Getiing a List of fruit names
            fruitsList = driver.findElements(By.cssSelector("tbody tr td:nth-child(1)"));
            //Searching for rice
            fruitPrice = fruitsList.stream().filter(s -> s.getText().equalsIgnoreCase(fruits[0])).map(s -> getPrice(s)).collect(Collectors.toList());
            if (fruitPrice.isEmpty()) {
                //Getting frech Button element to make sure its fresh
                WebElement nextButton = driver.findElement(By.cssSelector("a[aria-label='Next']"));
                //If disaabled is true
                if (nextButton.getDomAttribute("aria-disabled").equals("true")) {
                    System.out.println("No such fruit found");
                    break;
                }
                //If not true
                nextButton.click();
            }
        } while (fruitPrice.isEmpty());
        //Printing
        fruitPrice.forEach(s -> System.out.println(fruits[0] + " price is " + s)); 

        driver.findElement(By.id("search-field")).sendKeys(fruits[0]);
        fruitsList = driver.findElements(By.cssSelector("tbody tr td:nth-child(1)"));
        List <WebElement> filteredList = fruitsList.stream().filter(s -> s.getText().equalsIgnoreCase(fruits[0])).collect(Collectors.toList());
        //Assert.assertEquals(fruitsList.size(), filteredList.size());
        Assert.assertEquals(fruitsList.size(), 3);
    }

    public static String getPrice(WebElement s) {
        String price = s.findElement(By.xpath("following-sibling::td[1]")).getText();
        return price;
    }
}
