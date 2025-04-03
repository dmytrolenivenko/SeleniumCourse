package com.example.Starting;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class Miscelleanous {

    public static void main(String[] args) {
        //Taking Screenshots
        
        //Initiate proxy server
        Proxy proxy = new Proxy();
        proxy.setHttpProxy("proxy:2222");
        //Options for the Driver
        EdgeOptions options = new EdgeOptions();
        //Addin proxy
        options.setCapability("proxy", proxy);
        //This Optoins accept Expered SSL certificate
        options.setAcceptInsecureCerts(true);
        WebDriver driver = new EdgeDriver(options);
        driver.get("https://expired.badssl.com/");

        driver.manage().deleteAllCookies(); //Delete all cookies
        driver.manage().deleteCookieNamed("sessionID"); // Delete Named cookie
        driver.manage().window().maximize(); //Maximize

        

    }
}
