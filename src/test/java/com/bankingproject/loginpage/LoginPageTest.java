package com.bankingproject.loginpage;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.bankingproject.base.BaseClass;

public class LoginPageTest extends BaseClass {
	
	//WebDriver driver;
	
    @BeforeClass
	public void setUp() {
		
		launchwebsite();
	}
	
    @AfterClass
	public void tearDown() {
		
		driver.close();
	}
	
	@Test
	public void testTitle() {
		
		String pagetile = driver.getCurrentUrl();
		
		if(pagetile.equalsIgnoreCase("https://demo.guru99.com/V1/index.php")) {
			
		
			System.out.println("we are on correct page");
		}
		
		else {
			
			System.out.println("wrong page");
		}
	}

}
