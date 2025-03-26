package com.example;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        /*
        System.out.println("Hello world!");
        WebDriver driver = new EdgeDriver();
        //WebDriver driver = new FirefoxDriver();
        driver.get("https://rahulshettyacademy.com/");
        System.out.println("The title is - " + driver.getTitle());
        System.out.println("The current URL is - " + driver.getCurrentUrl());
        driver.quit();
            */

/*             ArrayList<Integer> ints = new ArrayList<>(Arrays.asList(11,22,33,44,55,66,77,88,99,110));
            for (int i = 0; i < ints.size(); i++) {
                if (ints.get(i) % 2 == 0) {
                    System.out.println(ints.get(i));
                    break;
                } else {
                    System.out.println("Different number");
                }
            } */
    
/*                 int[] numbers = {1,2,3,4,5};
                System.out.println("The first one = " + numbers[0]);
                System.out.println("The last one = " + numbers[numbers.length -1]);
                
                System.out.println("All numbers reversed print");
                for(int i = numbers.length-1; i >= 0; i--){
                    System.out.println(numbers[i]);
                }

                int totalCount = 0;
                for(int i = 0; i < numbers.length; i++) {
                    totalCount += numbers[i];
                }
                System.out.println("Total sum of numbers = " + totalCount); */

/*                 ArrayList <String> namesList = new ArrayList<>(Arrays.asList("a","b","c","d","e"));

                String target = "c";
                ArrayList <Integer> indexes = new ArrayList<>();
                for (int i = 0; i < namesList.size(); i++) {
                    if (namesList.get(i).equals(target)) {
                        indexes.add(i);
                        System.out.println("C is in " + i);
                    }
                }         
                System.out.println(indexes);
                for(String s : namesList) {
                    if(s.equals(target)) {
                        System.out.println("C is in " + namesList.indexOf(s));
                    }
                } */

                String words = "Hello World of Cruel People";
                /* for (int i = 0; i < words.length(); i++) {
                    //System.out.println(words.charAt(i));
                } */
               System.out.println(Arrays.asList(words.split(" ")));
               int i = 0;
               while(i < words.length()) {
                System.out.println(words.charAt(i));
                i++;
               }

               String message = "Please use temporary password 'rahulshettyacademy' to Login.";
               String [] messageSplitted = message.split("'");
               System.out.println(Arrays.asList(messageSplitted));


            }
}