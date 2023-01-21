package com.bankingproject.base;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass {
	
	
	public static WebDriver driver;
	
	
		public void launchwebsite() {
	
				String projectpath = System.getProperty("user.dir");
	
				System.out.println(projectpath);
	
				System.setProperty("webdriver.chrome.driver", projectpath+"\\driver\\chromedriver.exe");
	
				driver = new ChromeDriver();
	 
				driver.get("https://demo.guru99.com/V1/index.php");
	
				
		}

}
