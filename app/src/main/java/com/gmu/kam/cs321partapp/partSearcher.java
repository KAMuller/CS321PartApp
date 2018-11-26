package com.gmu.kam.cs321partapp;

import java.util.ArrayList;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.firefox.FirefoxDriver;


/*
 * Created By Kiran Saravanakumar
 * */

public class partSearcher 
{
	private static ArrayList<String> resultUrls = new ArrayList<String>();
	private String key = "";
	
	public partSearcher(String key)
	{
        //System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
       // System.setProperty("webdriver.chrome.driver", "/data/app/com.android.chrome-w4bCuxlU27VyB5idGlaL9w==/base.apk");
		this.key = key;
        usaSearch();
        walmartSearch();
        carpartsSearch();

		//if need just change the path to chrome on machine

	}

    public WebDriver getMobileChromeDriver() {
        System.setProperty("webdriver.chrome.driver", "/home/kiran24/Downloads/chromedriver");

        ChromeOptions chromeOptions = new ChromeOptions();
       // chromeOptions.addArguments("port");
        chromeOptions.setExperimentalOption(
                "androidPackage", "com.android.chrome");
        chromeOptions.setExperimentalOption("androidDeviceSerial", "deviceId emulator-5554");

        return new ChromeDriver(chromeOptions);
    }

	public void usaSearch()
	{
		//WebDriver driver = new ChromeDriver();
        WebDriver driver = getMobileChromeDriver();
        //driver.get("https://www.usautoparts.net");
        driver.navigate().to("https://www.usautoparts.net");
        final String url = driver.getCurrentUrl();

        WebElement element = driver.findElement(By.name("Ntt"));
        element.click();
        element.sendKeys(key);

        element.submit();

        //System.out.println("Page title is: " + driver.getTitle());
        

        while(driver.getCurrentUrl().equals(url))
        {
        	System.out.println(driver.getCurrentUrl());
        }

        resultUrls.add(driver.getCurrentUrl());

        driver.quit();
	}

	public void walmartSearch()
	{
		//WebDriver driver = new ChromeDriver();
        WebDriver driver = getMobileChromeDriver();

        driver.navigate().to("https://www.walmart.com");
        final String url = driver.getCurrentUrl();

       
        WebElement element = driver.findElement(By.name("query"));
        element.click();
        element.sendKeys(key);

        element.submit();
        //final String url = driver.getCurrentUrl();

        while(driver.getCurrentUrl().equals(url))
        {

        }

        resultUrls.add(driver.getCurrentUrl());
        driver.quit();
	}

	public void carpartsSearch()
	{
		//WebDriver driver = new ChromeDriver();
        WebDriver driver = getMobileChromeDriver();

		driver.navigate().to("https://www.carparts.com");
        final String url = driver.getCurrentUrl();
       
        WebElement element = driver.findElement(By.name("Ntt"));
        element.click();
        element.sendKeys(key);

        element.submit();

        while(driver.getCurrentUrl().equals(url))
        {

        }

        resultUrls.add(driver.getCurrentUrl());
        driver.quit();
	}

	public void carIdSearch()
	{
		//WebDriver driver = new ChromeDriver();
        WebDriver driver = getMobileChromeDriver();

		driver.navigate().to("https://www.carid.com");
        final String url = driver.getCurrentUrl();

        WebElement element = driver.findElement(By.name("headsearch-field-input"));
        element.click();
        element.sendKeys(key);

        element.submit();

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

    public static void main(String[] args) {
        String key = "Toyota Corolla 2016 tires";
        partSearcher p = new partSearcher(key);
        p.usaSearch();
        p.walmartSearch();
        p.carpartsSearch();
        for(String str: resultUrls)
        {
        	System.out.println(str);
        }
    }
}
