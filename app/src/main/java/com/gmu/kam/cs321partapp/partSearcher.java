package com.gmu.kam.cs321partapp;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;


/*
 * Created By Kiran Saravanakumar
 * */

public class partSearcher  {
	static ArrayList<String> resultUrls = new ArrayList<String>();
	public static void usaSearch(String key)
	{
		WebDriver driver = new FirefoxDriver();
        driver.get("https://www.usautoparts.net");

        WebElement element = driver.findElement(By.name("Ntt"));
        element.click();
        element.sendKeys(key);

        element.submit();

        //System.out.println("Page title is: " + driver.getTitle());
        final String url = driver.getCurrentUrl();

        while(driver.getCurrentUrl().equals(url))
        {

        }

        resultUrls.add(driver.getCurrentUrl());

        driver.quit();
	}

	public static void walmartSearch(String key)
	{
		WebDriver driver = new FirefoxDriver();

        // And now use this to visit Google
        driver.get("https://www.walmart.com");
        // Alternatively the same thing can be done like this
        // driver.navigate().to("http://www.google.com");

        // Find the text input element by its name
        WebElement element = driver.findElement(By.name("query"));
        element.click();
        // Enter something to search for
        element.sendKeys(key);

        // Now submit the form. WebDriver will find the form for us from the element
        element.submit();
        final String url = driver.getCurrentUrl();

        while(driver.getCurrentUrl().equals(url))
        {

        }

        resultUrls.add(driver.getCurrentUrl());
        driver.quit();
	}

	public static void carpartsSearch(String key)
	{
		WebDriver driver = new FirefoxDriver();

        // And now use this to visit Google
        driver.get("https://www.carparts.com");
        // Alternatively the same thing can be done like this
        // driver.navigate().to("http://www.google.com");

        // Find the text input element by its name
        WebElement element = driver.findElement(By.name("Ntt"));
        element.click();
        // Enter something to search for
        element.sendKeys(key);

        // Now submit the form. WebDriver will find the form for us from the element
        element.submit();
        final String url = driver.getCurrentUrl();

        while(driver.getCurrentUrl().equals(url))
        {

        }

        resultUrls.add(driver.getCurrentUrl());
        driver.quit();
	}

	public static void carIdSearch(String key)
	{
		WebDriver driver = new FirefoxDriver();

        // And now use this to visit Google
        driver.get("https://www.carid.com");
        // Alternatively the same thing can be done like this
        // driver.navigate().to("http://www.google.com");

        // Find the text input element by its name
        WebElement element = driver.findElement(By.name("headsearch-field-input"));
        element.click();
        // Enter something to search for
        element.sendKeys(key);

        // Now submit the form. WebDriver will find the form for us from the element
        element.submit();
        final String url = driver.getCurrentUrl();

        while(driver.getCurrentUrl().equals(url))
        {

        }

        resultUrls.add(driver.getCurrentUrl());
        driver.quit();
	}

    public static void main(String[] args) {
        // Create a new instance of the Firefox driver
        // Notice that the remainder of the code relies on the interface,
        // not the implementation.
        String key = "Toyota Corolla 2016 tires";
        usaSearch(key);
        walmartSearch(key);
        carpartsSearch(key);
        for(String str: resultUrls)
        {
        	System.out.println(str);
        }
    }
}
