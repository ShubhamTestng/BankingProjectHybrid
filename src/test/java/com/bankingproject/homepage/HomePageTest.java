package com.bankingproject.homepage;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.banking.pom.HomePgaePom;
import com.bankingproject.base.BaseClass;

public class HomePageTest extends BaseClass{
	
HomePgaePom homepage;
	
	@BeforeClass
	public void setUp() {
		
		launchwebsite();
		
		driver.get("https://demo.guru99.com/");
	}
	
	@AfterClass
	public void tearDown() {
		
		driver.close();
	}
	
	@Test
	public void clickEmail() {
		
		homepage = new HomePgaePom();
		
		homepage.clickOnEmailButton();
		
		System.out.println("successfully clicked on email button");
		
	}
	
	@Test
	public void clickSubmit() {
		
		homepage.clickOnSubmitButton();
		
		System.out.println("successfully clicked on submit button");
	}

}
