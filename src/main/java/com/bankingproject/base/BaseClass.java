package com.bankingproject.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	
	public static WebDriver driver;
	
	public static String projectpath = System.getProperty("user.dir");
	
		public void launchwebsite(String browser) throws FileNotFoundException {
			    
			   switch(browser) {
			   
			   case "chrome":
					//System.setProperty("webdriver.chrome.driver", projectpath+"\\driver\\chromedriver.exe");
				   
				   ChromeOptions chromeOptions = new ChromeOptions();
				  
				  // WebDriverManager.chromedriver().driverVersion("85.0.41").setup();
				   
				   WebDriverManager.chromedriver().setup();
				   
				   WebDriver driver = new ChromeDriver(chromeOptions);
				   
				   
					driver = new ChromeDriver();
				   break;
				   
				   
				   
			   case "firefox":
					//System.setProperty("webdriver.gecko.driver", projectpath+"\\driver\\geckodriver.exe");
				   WebDriverManager.firefoxdriver().setup();
					driver = new ChromeDriver();
			        break;
			        
			   case "edge":
					//System.setProperty("webdriver.edge.driver", projectpath+"\\driver\\msedgedriver.exe");
					driver = new EdgeDriver();
					WebDriverManager.edgedriver().setup();
				   break;
			   
			   }
	 
			   FileInputStream fis = new FileInputStream(projectpath+"//src//test//resources//config.properties");
					   
			    Properties properties = new Properties();
			    
			    try {
					properties.load(fis);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			    
			    driver.get(properties.getProperty("baseurl"));
			    
				//driver.get("https://demo.guru99.com/V1/index.php");
				
				driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
				
	
		}

}
