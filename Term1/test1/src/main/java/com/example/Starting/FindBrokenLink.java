package com.example.Starting;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.asserts.SoftAssert;

public class FindBrokenLink {

    public static void main(String[] args) throws IOException, URISyntaxException {
        WebDriver driver = new EdgeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        List<WebElement> links = driver.findElements(By.cssSelector("#gf-BIG li > a"));
        //Creating Soft Assertion. Will continue after fail, but saves the errors
        SoftAssert softA = new SoftAssert();
        int responseCode;
        for (WebElement link : links) {
            //get Link from element
            String url = (link.getDomAttribute("href"));
            if (url != null && !url.isEmpty()) {
                try {
                    //Modern way of creating URL
                    URI uri = URI.create(url);
                    HttpURLConnection conn = (HttpURLConnection) uri.toURL().openConnection();
                    //Head like Get, but dont receive result. Head is good :)
                    conn.setRequestMethod("HEAD");
                    conn.connect();
                    responseCode = conn.getResponseCode();
                    if (responseCode != 200) {
                        System.out.println(url + " \nIs ");

                        String message = switch (responseCode) {
                            case 300, 301, 302, 303 ->
                                responseCode + " Redirecting";
                            case 400, 401, 402, 403, 404 ->
                                responseCode + " Client Error. Unauthorized, Not Found";
                            case 500, 501 ->
                                responseCode + " Server Error";
                            default ->
                                "Generic error";
                        };
                        System.out.println(message);
                    } 
                    softA.assertTrue(responseCode < 400, url + " is borken with code " + responseCode);
                } catch (Exception e) {
                }

            }
        }
        softA.assertAll("Founded Errors");
    }

}
