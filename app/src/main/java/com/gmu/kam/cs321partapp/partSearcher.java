package com.gmu.kam.cs321partapp;

import java.util.ArrayList;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


/*
 * Created By Kiran Saravanakumar
 * */

public class partSearcher 
{
	private static ArrayList<String> resultUrls = new ArrayList<String>();
	private String key = "";
	
	public partSearcher(String key)
	{
		this.key = key;
	}
	
	public void usaSearch()
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

	public void walmartSearch()
	{
		WebDriver driver = new FirefoxDriver();

        driver.get("https://www.walmart.com");
       
        WebElement element = driver.findElement(By.name("query"));
        element.click();
        element.sendKeys(key);

        element.submit();
        final String url = driver.getCurrentUrl();

        while(driver.getCurrentUrl().equals(url))
        {

        }

        resultUrls.add(driver.getCurrentUrl());
        driver.quit();
	}

	public void carpartsSearch()
	{
		WebDriver driver = new FirefoxDriver();

        driver.get("https://www.carparts.com");
       
        WebElement element = driver.findElement(By.name("Ntt"));
        element.click();
        element.sendKeys(key);

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

        driver.get("https://www.carid.com");
        WebElement element = driver.findElement(By.name("headsearch-field-input"));
        element.click();
        element.sendKeys(key);

        element.submit();
        final String url = driver.getCurrentUrl();

        while(driver.getCurrentUrl().equals(url))
        {

        }

        resultUrls.add(driver.getCurrentUrl());
        driver.quit();
	}
	
	public ArrayList<String> getFinalList()
	{
		return resultUrls;
	}

//    public static void main(String[] args) {
//        // Create a new instance of the Firefox driver
//        // Notice that the remainder of the code relies on the interface,
//        // not the implementation.
//        String key = "Toyota Corolla 2016 tires";
//        partSearcher p = new partSearcher(key);
//        p.usaSearch();
//        p.walmartSearch();
//        p.carpartsSearch();
//        for(String str: resultUrls)
//        {
//        	System.out.println(str);
//        }
//    }
}
