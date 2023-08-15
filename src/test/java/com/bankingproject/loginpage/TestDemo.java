package com.bankingproject.loginpage;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class TestDemo {  //before test > before class > before method
	
	@BeforeClass
	public void login() {
		
		System.out.println("login succesful");
	}
	
	@Test(groups = "regression")
    public void homepage1() {
		
		System.out.println("homepage 1 sucesful");
	}
	
	 @Test(dependsOnMethods  = "homepage3")
     public void homepage2() {
		
		System.out.println("homepage 2 sucesful");
	 }
	 
	 
	 @Test(invocationCount = 2,groups = "regression")
	 public void homepage4() {
		 
		 System.out.println("not execute");
	 }
	 
	 @Test(enabled = false)
	 public void homepage5() {
		 
		 System.out.println(" execute");
	 }
	 
	 
	 @Test(groups = "functional")
	 public void homepage3() {
		 
		 System.out.println("homepage 3 sucesful");
	 }
	 
	 @BeforeTest
	 public void userid() {
		 
		 System.out.println("provide userid");
	 }
	 
	 @AfterTest
	 public void password() {
		 
		 System.out.println("succesfully logout");
	 }
	
	 @BeforeMethod
	 public void signin() {
		 
		 System.out.println("plz sign in");
	 }
	 
	   @AfterMethod
       public void AddTocart() {
		 
		 System.out.println("after sign in add to cart");
	   }
	   
	   @AfterClass
	   public void logout() {
		   
		   System.out.println("logout");
		   
	   }
	

}
